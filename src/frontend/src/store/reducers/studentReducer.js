const initState = {
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
    // add switch for actions
    return state;
}

export default studentReducer;
