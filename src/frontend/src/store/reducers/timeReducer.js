const initState = {

    /**
     * saved
     *  
     * @desc Contains names of saved time preferences
     * @param {String} id time preference identifier
     * @param {String} name name of saved time preference
     * @param {String} text indicates whether user is viewing a time preference
     * @param {Boolean} isEdit indicates wheter user is editing a time preference
     */
    saved: [
        /* // example of one saved time preference object {id: '0', name: 'Winter 2018', text: 'Select', isEdit: false} */
    ],

    /**
     * availability
     * 
     * @desc Contains the specific table of times for each saved time preference
     * @param {String} id time identifier
     * @param {String} name name of saved time preference
     * @param {String} time specifies the time of day
     * @param {Boolean} available whether student is available at the specified time
     */
    availability: [
        /* // example of one row in time table {id:'0', time:'07-08 AM', available: [true, true, true, true, true, true, true]} */
    ],

    /**
     * table
     * 
     * @desc Contains time information entered by user when creating time preferences
     * @param {String} id time identifier
     * @param {String} day specifies the day
     * @param {Boolean} available whether student is available at the specified time
     */

    table: [
        {id:'0', day:'Sun', available: [true, true, true, true, true, true, true, true, true, true, true, true, true, true, true]},
        {id:'1', day:'Mon', available: [true, true, true, true, true, true, true, true, true, true, true, true, true, true, true]},
        {id:'2', day:'Tue', available: [true, true, true, true, true, true, true, true, true, true, true, true, true, true, true]},
        {id:'3', day:'Wed', available: [true, true, true, true, true, true, true, true, true, true, true, true, true, true, true]},
        {id:'4', day:'Thu', available: [true, true, true, true, true, true, true, true, true, true, true, true, true, true, true]},
        {id:'5', day:'Fri', available: [true, true, true, true, true, true, true, true, true, true, true, true, true, true, true]},
        {id:'6', day:'Sat', available: [true, true, true, true, true, true, true, true, true, true, true, true, true, true, true]},
    ],

    // local state of page
    isViewing: false,

    // local state of page
    isCreating: true,

    // local selected time preference id
    selectedTimeId: ''

}


/**
 * cloneTable
 * 
 * @desc Clones a given table to prevent state destruction
 * @param {array} table 'table' array
 * @param {boolean} empty remove or keep already selected time slots
*/
const cloneTable = (table, empty) => {
    let newTable = [];
    table.forEach((element) => {
        newTable.push({...element})
        newTable[newTable.length-1].available = [...element.available]
        if(empty){
            newTable[newTable.length-1].available.fill(true)
        }
    })
    return(newTable)
}

/**
 * cloneSavedDefault
 * 
 * @desc Clones the time preferences list to prevent state destruction (when user views)
 * @desc Resets text for each element to 'View'
 * @param {array} saved 'saved' array
*/
const cloneSavedDefault = (saved) => {
    let newSaved = []
    saved.forEach(function(element){
        newSaved.push({...element})
        newSaved[newSaved.length-1].text = 'Select'
    })
    return(newSaved)
}

/**
 * cloneSavedEdit
 * 
 * @desc Clones the time preferences list to prevent state destruction (when user edits)
 * @desc State of editting is changed for the specific element that created the action 
 * @param {array} saved 'saved' array
 * @param {*} id schedule id
*/
const cloneSavedEdit = (saved, id) => {
    let newSaved = []
    saved.forEach(function(element){
        newSaved.push({...element})
        if(element.id === id){
            console.log("IN")
            newSaved[newSaved.length-1].isEdit = !newSaved[newSaved.length-1].isEdit
        }
    })
    return(newSaved)
}

/*
 * --- Modifies state according to dipsatched action 
*/
const timeReducer = (state=initState, action=null) => {

    switch(action.type){

        case 'LOAD_TIMES':
            let storedSaved = []
            action.times.forEach(saved => {
                storedSaved.push({id: saved.availNum, name: saved.timeName, text: 'Select', isEdit: false})
            })
            return{
                ...state,
                saved: storedSaved
            }

        /* // When user is editing the Time name */
        case 'TIME_NAME_EDIT':
            let editSaved = cloneSavedEdit(state.saved, action.id)
            console.log(state.saved)
            console.log(editSaved)
            return{
                ...state,
                saved: editSaved
            }

        /* // When user is saving the Time name */
        case 'TIME_NAME_SAVE':
            let addSaved = cloneSavedEdit(state.saved, action.id)
            addSaved[action.index].name = action.name
            return{
                ...state,
                saved: addSaved
            }

        /* // When user chooses on a specific time */
        case 'CHANGE AVAILABILITY':
            if(state.isViewing === false){
                let changeTable = cloneTable(state.table, false)
                changeTable[action.row_id].available[action.col_id] = !changeTable[action.row_id].available[action.col_id]
                return {
                    ...state,
                    table: changeTable,
                }
            }
            break;

        /* // When user wants to view a saved time preference */
        case 'TIME_VIEW':
            let viewSaved = cloneSavedDefault(state.saved)
            if(state.saved[action.index].text === 'Select'){
                let savedTable = [
                    {id:'0', day:'Sun', available: action.block.blocks[0]},
                    {id:'1', day:'Mon', available: action.block.blocks[1]},
                    {id:'2', day:'Tue', available: action.block.blocks[2]},
                    {id:'3', day:'Wed', available: action.block.blocks[3]},
                    {id:'4', day:'Thu', available: action.block.blocks[4]},
                    {id:'5', day:'Fri', available: action.block.blocks[5]},
                    {id:'6', day:'Sat', available: action.block.blocks[6]}
                ]
                viewSaved[action.index].text = 'Selected'
                return {
                    ...state,
                    saved: viewSaved,
                    table: savedTable,
                    isViewing: true,
                    selectedTimeId: action.id
                }

            /* // When user doesn't want to view a saved time preference */
            }else{
                let empty = cloneTable(state.table, true)
                return {
                    ...state,
                    saved: viewSaved,
                    table: empty,
                    isViewing: false
                }
            }

        /* // When user wants to save a saved time preference */
        case 'TIME_SAVE':
            let newTimeTable = cloneTable(state.table, true)
            let newSaved = cloneSavedDefault(state.saved)

            // *** need to get name that user inputs here
            // *** neee to get id from database
            let newTime = {id: action.timePref.availNum, name: action.timePref.name, text: 'Select', isEdit: false }
            newSaved.push(newTime)
            return{
                ...state,
                saved: newSaved,
                table: newTimeTable,
                isViewing: false,
            }

        /* // When user clears table */
        case 'TIME_CLEAR':
            let emptyTable = cloneTable(state.table, true)
            let emptySaved = cloneSavedDefault(state.saved)
            return {
                ...state,
                saved: emptySaved,
                table: emptyTable,
                isViewing: false
            }

        /* // When user deletes a time preference */
        case 'TIME_DELETE':
            let newSavedList = state.saved.filter(element => {
                return element.id !== parseInt(action.id)
            })
            return{
                ...state,
                saved: newSavedList
            }

        default:
            return state;
    }
    return state;
}

export default timeReducer;