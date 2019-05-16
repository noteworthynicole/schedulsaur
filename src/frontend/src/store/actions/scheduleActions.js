/**
 * view
 * 
 * @desc View a schedule 
 * @param {*} id identifier in 'viewing' array in scheduleReducer
 * @param {*} index index in 'viewing' array in scheduleReducer
 */
export const view = (id, index) => {
    return{
        type: 'SCHEDULE_VIEW',
        id: id,
        index: index
    }
}

/**
 * select
 * 
 * @desc Select a schedule
 * @param {*} id identifier in 'selected' array in scheduleReducer
 * @param {*} index index in 'selected' array in scheduleReducer
 */
export const select = (id, index) => {
    return{
        type: 'SCHEDULE_SELECT',
        id: id,
        index: index,
    }
}

/**
 * deselect
 * 
 * @desc Deselect a schedule 
 * @param {*} id identifier in 'selected' array in scheduleReducer
 * @param {*} index index in 'selected' array in scheduleReducer
 */
export const deselect = (id, index) => {
    return{
        type: 'SCHEDULE_DESELECT',
        id: id,
        index: index
    }
}

/**
 * filter
 * 
 * @desc Filter a list of schedules
 */
export const filter = () => {
    return{
        type: 'SCHEDULE_FILTER'
    }
}

/**
 * sort
 * 
 * @desc Sort a list of schedules
 */
export const sort = () => {
    return{
        type: 'SCHEDULE_SORT'
    }
}

/**
 * save
 * 
 * @desc Save a set of schedules
 */
export const save = () => {

    // *** need to make async call to database here to save
    // *** need to make async call to database here to save

    return{
        type: 'SCHEDULE_SAVE'
    }
}

