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
     * @param {array} info_types  array of type of information to be presented
     */

    id: '1',
    info: [
        {type: 'Name', text: 'John Doe'},
        {type: 'Major', text: 'Software Engineering'},
        {type: 'Catalog Year', text: '2017-2019'},
        {type: 'Expected Graduation', text: 'Spring 2020'},
        {type: 'Units This Quarter', text: '16'},
        {type: 'Units Per Quarter', text: '14.5'}
    ],
    major_percent: '50',
    support_percent: '75',
    ge_percent: '10',
    isEdit: false,
    editButton: 'Edit Profile',
}

/**
 * --- Modifies state according to dispatched action
*/
const studentReducer = (state=initState, action=null) => {

    /* // When user saves their personal information */
    if(action.type === 'STUDENT_SAVE'){
        let newInfo = [
            {type: 'Name', text: 'John Doe'},
            {type: 'Major', text: action.major},
            {type: 'Catalog Year', text: action.catalog},
            {type: 'Expected Graduation', text: action.expected},
            {type: 'Units This Quarter', text: action.units_this},
            {type: 'Units Per Quarter', text: action.units_per}
        ]
        return{
            ...state,
            info: newInfo,
            isEdit: !state.isEdit,
            editButton: 'Edit Profile'
        }

    /* // When user edits their personal information */
    }else if(action.type === 'EDIT_INFO'){
        const newEditButton = (state.editButton === 'Edit Profile') ? 
            ('Cancel') : ('Edit Profile')
        return{
            ...state,
            isEdit: !state.isEdit,
            editButton: newEditButton
        }
    } else {
        return state
    }
}

export default studentReducer;
