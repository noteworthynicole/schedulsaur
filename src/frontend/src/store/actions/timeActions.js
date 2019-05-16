/**
 * editName
 * 
 * @desc Edit the time preference name
 * @param {*} id  identifier in 'saved' array in timeReducer
 * @param {*} index index in 'saved' array in timeReducer
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
 * @desc Save the name of the time preference
 * @param {*} id identifier in 'saved' array in timeReducer
 * @param {*} index index in 'saved' array in timeReducer
 * @param {*} name new name for time preference
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
 * @desc Change selected time cell
 * @param {*} row_id index in 'availability' array in timeReducer
 * @param {*} col_id index in 'available' array in 'availability in timeReducer
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
 * @desc View a saved time preference
 * @param {*} id identifier in 'saved' array in timeReducer
 * @param {*} index index in 'saved' array in timeReducer
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
 * @desc Save a new time preference
 * @param {*} name new name for new time preference
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
 * @desc Delete a time preference
 * @param {*} id identifer in 'saved' array in timeReducer
 * @param {*} index index in 'saved' array in timeReducer
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
 * @desc Clear the time table
 */
export const clear = () => {
    return{
        type: 'TIME_CLEAR'
    }
}