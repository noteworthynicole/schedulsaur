const initState = {

    /**
     * student
     * 
     * @desc Contains information about a student
     * @param {String} id student identifier
     * @param {String} name name of student
     * @param {String} major major of student
     * @param {String} catalog_year catalog year studetn follows
     * @param {String} expected_grad expected graduation
     * @param {String} units_this_quarter units taking this quarter
     * @param {String} units_per_quarter units per quarter
     * @param {String} major_percent percent completion of major courses
     * @param {String} support_percent percent completion of support courses
     * @param {String} ge_percent percent completion of ge courses
     */

    id: '1',
    name: 'John Doe',
    major: 'Software Engineering',
    catalog_year: '2017-2019',
    expected_grad: 'Spring 2020',
    units_this_quarter: '16 units',
    units_per_quarter: '14.5 units',
    major_percent: '50',
    support_percent: '75',
    ge_percent: '10'
}

/**
 * --- Modifies state according to dispatched action
*/
const studentReducer = (state=initState, action=null) => {

    /* // When user saves their personal information */
    if(action.type === 'STUDENT_SAVE'){
        return{
            ...state,
            major: action.major,
            catalog_year: action.catalog,
            expected_grad: action.expected,
            units_this_quarter: action.units_this,
            units_per_quarter: action.units_per
        }
    } else {
        return state
    }
}

export default studentReducer;