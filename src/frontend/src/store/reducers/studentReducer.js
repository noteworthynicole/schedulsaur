const initState = {

    /**
     * student
     * 
     * @description Contains information about a student
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

const studentReducer = (state=initState, action) => {

    // *** add switch for actions
    // *** add switch for actions

    return state;
}

export default studentReducer;
