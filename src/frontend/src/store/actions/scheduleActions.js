/**
 * view
 * 
 * @description View a schedule 
 * @param {*} id 
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
 * @description Select a schedule
 * @param {*} id 
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
 * @description Deselect a schedule 
 * @param {*} id 
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
 * @description Filter a list of schedules
 */
export const filter = () => {
    return{
        type: 'SCHEDULE_FILTER'
    }
}

/**
 * sort
 * 
 * @description Sort a list of schedules
 */
export const sort = () => {
    return{
        type: 'SCHEDULE_SORT'
    }
}

/**
 * save
 * 
 * @description Save a set of schedules
 */
export const save = () => {

    // *** need to make async call to database here to save
    // *** need to make async call to database here to save

    return{
        type: 'SCHEDULE_SAVE'
    }
}

