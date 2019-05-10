/**
 * editName
 * 
 * @description Edit the tme preference
 * @param {*} id 
 * @param {*} index 
 */
export const editName = (id, index) => {
    return{
        type: 'TIME_NAME_EDIT',
        id: id,
        index: index
    }
}

/**
 * saveName
 * 
 * @description Save the name of the time preference
 * @param {*} id 
 * @param {*} index 
 * @param {*} name 
 */
export const saveName = (id, index, name) => {
    return{
        type: 'TIME_NAME_SAVE',
        id: id,
        index: index,
        name: name
    }
}

/**
 * changeAvailable
 * 
 * @description Change selected time cell
 * @param {*} row_id 
 * @param {*} col_id 
 */
export const changeAvailable = (row_id, col_id) => {
    return{
        type: 'CHANGE AVAILABILITY',
        row_id: row_id,
        col_id: col_id
    }
};

/**
 * view
 * 
 * @description View a saved time preference
 * @param {*} id 
 */
export const view = (id, index) => {

    // *** need to make async call to database here to save
    // *** need to make async call to database here to save

    // *** need to get new table from database
    // *** need to get new table from database

    return{
        type: 'TIME_VIEW',
        id: id,
        index: index
    }
}

/**
 * save
 * 
 * @description Save a new time preference
 */
export const save = (name) => {

    // *** need to make async call to database here to save
    // *** need to make async call to database here to save

    // *** need to get new id from database
    // *** need to get new id from database

    return{
        type: 'TIME_SAVE',
        name: name
    }
}

/**
 * del
 * 
 * @description Delete a time preference
 * @param {*} id 
 * @param {*} index 
 */
export const del = (id, index) => {
    return{
        type: 'TIME_DELETE',
        id: id,
        index: index
    }
}

/**
 * clear
 * 
 * @description Clear the time table
 */
export const clear = () => {
    return{
        type: 'TIME_CLEAR'
    }
}