const initState = {

    /**
     * saved
     *  
     * @description Contains names of saved time preferences
     * @param {String} id time preference identifier
     * @param {String} name name of saved time preference
     * @param {String} text indicates whether user is viewing a time preference
     * @param {Boolean} isEdit indicates wheter user is editing a time preference
     */
    saved: [
        {id: '0', name: 'Winter 2018', text: 'View', isEdit: false},
        {id: '1', name: 'Summer Quarter', text: 'View', isEdit: false},
        {id: '2', name: 'More Sleep', text: 'View', isEdit: false},
        {id: '3', name: 'Morning Only', text: 'View', isEdit: false},
        {id: '4', name: 'Chem TA Schedule', text: 'View', isEdit: false},
    ],

    /**
     * availability
     * 
     * @description Contains the specific table of times for each saved time preference
     * @param {String} id time identifier
     * @param {String} name name of saved time preference
     * @param {String} time specifies the time of day
     * @param {Boolean} available whether student is available at the specified time
     */
    availability: [
        {id:'0', time:'07-08 AM', available: [true, true, true, true, true, true, true]},
        {id:'1', time:'08-09 AM', available: [true, true, true, true, true, true, true]},
        {id:'2', time:'09-10 AM', available: [false, false, false, false, false, false, false]},
        {id:'3', time:'10-11 AM', available: [false, false, false, false, false, false, false]},
        {id:'4', time:'11-12 AM', available: [false, false, false, false, false, false, false]},
        {id:'5', time:'12-01 PM', available: [false, false, false, false, false, false, false]},
        {id:'6', time:'01-02 PM', available: [false, false, false, false, false, false, false]},
        {id:'7', time:'02-03 PM', available: [false, false, false, false, false, false, false]},
        {id:'8', time:'03-04 PM', available: [false, true, false, true, false, true, false]},
        {id:'9', time:'04-05 PM', available: [false, true, false, true, false, true, false]},
        {id:'10', time:'05-06 PM', available: [false, false, true, false, true, false, false]},
        {id:'11', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
        {id:'12', time:'06-07 PM', available: [false, false, false, false, false, false, false]},
        {id:'13', time:'07-08 PM', available: [false, false, false, false, false, false, false]},
        {id:'14', time:'08-09 PM', available: [true, true, false, true, false, true, true]}
    ],

    /**
     * table
     * 
     * @description Contains time information entered by user when creating time preferences
     * @param {String} id time identifier
     * @param {String} time specifies the time of day
     * @param {Boolean} available whether student is available at the specified time
     */
    table: [
        {id:'0', time:'07-08 AM', available: [false, false, false, false, false, false, false]},
        {id:'1', time:'08-09 AM', available: [false, false, false, false, false, false, false]},
        {id:'2', time:'09-10 AM', available: [false, false, false, false, false, false, false]},
        {id:'3', time:'10-11 AM', available: [false, false, false, false, false, false, false]},
        {id:'4', time:'11-12 AM', available: [false, false, false, false, false, false, false]},
        {id:'5', time:'12-01 PM', available: [false, false, false, false, false, false, false]},
        {id:'6', time:'01-02 PM', available: [false, false, false, false, false, false, false]},
        {id:'7', time:'02-03 PM', available: [false, false, false, false, false, false, false]},
        {id:'8', time:'03-04 PM', available: [false, false, false, false, false, false, false]},
        {id:'9', time:'04-05 PM', available: [false, false, false, false, false, false, false]},
        {id:'10', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
        {id:'11', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
        {id:'12', time:'06-07 PM', available: [false, false, false, false, false, false, false]},
        {id:'13', time:'07-08 PM', available: [false, false, false, false, false, false, false]},
        {id:'14', time:'08-09 PM', available: [false, false, false, false, false, false, false]}
    ],

    // local state of page
    isViewing: false,

    // local state of page
    isCreating: true

}


/**
 * cloneTable
 * 
 * @description Clones a given table to prevent state destruction
 * @param {*} table 
 * @param {*} empty 
 */
const cloneTable = (table, empty) => {
    let newTable = [];
    table.forEach((element) => {
        newTable.push({...element})
        newTable[newTable.length-1].available = [...element.available]
        if(empty){
            newTable[newTable.length-1].available.fill(false)
        }
    })
    return(newTable)
}

/**
 * cloneSaved
 * 
 * @description Clones the time preferences list to prevent state destruction (when user views)
 * @param {*} saved 
 */
const cloneSavedDefault = (saved) => {
    let newSaved = []
    saved.forEach(function(element){
        newSaved.push({...element})
        newSaved[newSaved.length-1].text = 'View'
    })
    return(newSaved)
}

/**
 * cloneSavedEdit
 * 
 * @description Clones the time preferences list ot prevent state destruction (when user edits)
 * @param {*} saved 
 * @param {*} id 
 */
const cloneSavedEdit = (saved, id) => {
    let newSaved = []
    saved.forEach(function(element){
        newSaved.push({...element})
        if(element.id === id){
            newSaved[newSaved.length-1].isEdit = !newSaved[newSaved.length-1].isEdit
        }
    })
    return(newSaved)
}

/**
 * timeReducer
 * 
 * @description Modifies state according to dipsatched action 
 * @param {*} state 
 * @param {*} action 
 */
const timeReducer = (state=initState, action) => {

    switch(action.type){

        /* // When user is editing the Time name */
        case 'TIME_NAME_EDIT':
            let editSaved = cloneSavedEdit(state.saved, action.id)
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
            if(state.saved[action.index].text === 'View'){
                let savedTable = cloneTable(state.availability, false)
                viewSaved[action.index].text = 'Viewing'
                return {
                    ...state,
                    saved: viewSaved,
                    table: savedTable,
                    isViewing: true
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

        /* // When user wants to view a saved time preference */
        case 'TIME_SAVE':
            let newTimeTable = cloneTable(state.table, true)
            let newSaved = cloneSavedDefault(state.saved)

            // *** need to get name that user inputs here
            // *** neee to get id from database
            let newTime = {id: (parseInt(state.saved[state.saved.length-1].id)+1).toString(),
                           name: action.name, text: 'View', isEdit: false }
            newSaved.push(newTime)
            return{
                ...state,
                saved: newSaved,
                table: newTimeTable,
                isViewing: false
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
                return element.id !== action.id
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