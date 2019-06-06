const initState = {

    /**
     * student
     * 
     * @desc Contains information about a student
     * @param {String} id student identifier
     * @param {array} info student information
     * @param {String} major_percent percent completion of major courses
     * @param {String} support_percent percent completion of support courses
     * @param {String} ge_percent percent completion of ge courses
     * @param {boolean} isEdit if user is editing their info
     * @param {String} editButton type of button (depends on isEdit)
     */

    id: '',
    info: [
        {type: 'Name', text: 'N/A'},
        {type: 'Major', text: 'N/A'},
        {type: 'Minor', text: 'N/A'},
        {type: 'Catalog Year', text: 'N/A'},
        {type: 'Planning Quarter', text: 'N/A'},
        {type: 'Units This Quarter', text: '0'}
    ],
    major_percent: '40',
    support_percent: '25',
    ge_percent: '75',
    isEdit: false,
    editButton: 'Edit Profile'
}

/**
 * cloneInfo
 * 
 * @desc Clones the 'info' array to prevent state destruction (when updating)
 * @param {object} action Object containing the student information
 */
const cloneInfo = (action) => {
    let newInfo = [
        {type: 'Name', text: action.name},
        {type: 'Major', text: action.major},
        {type: 'Minor', text: action.minor},
        {type: 'Catalog Year', text: action.catalogYear},
        {type: 'Planning Quarter', text: action.planningQuarter},
        {type: 'Units This Quarter', text: action.unitsThisQuarter}
    ]
    return newInfo
}


/**
 * --- Modifies state according to dispatched action
*/
const studentReducer = (state=initState, action=null) => {

    switch(action.type){

        /* // Initialize student information */
        case 'STUDENT_INIT':
            let initInfo = cloneInfo(action.user);
            return{
                ...state,
                id: action.user.id,
                info: initInfo
            }

        /* // When user edits their personal information */
        case 'EDIT_INFO':
            const newEditButton = (state.editButton === 'Edit Profile') ? 
                ('Cancel') : ('Edit Profile')
            return{
                ...state,
                isEdit: !state.isEdit,
                editButton: newEditButton
            }
        /* // When user saves their personal information */
        case 'STUDENT_SAVE':
            return{
                ...state,
                info: action.info,
                isEdit: !state.isEdit,
                editButton: 'Edit Profile'
            }
        default: 
            return state;
    }
}

export default studentReducer;
