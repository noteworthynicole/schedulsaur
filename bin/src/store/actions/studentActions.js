
/**
 * save 
 * 
 * @description Save the user's information
 * @param {*} major 
 * @param {*} catalog 
 * @param {*} expected 
 * @param {*} units_this 
 * @param {*} units_per 
 */
export const save = (major, catalog, expected, units_this, units_per) => {
    return{
        type: 'STUDENT_SAVE',
        major: major,
        catalog: catalog,
        expected: expected,
        units_this: units_this,
        units_per: units_per
    }
}