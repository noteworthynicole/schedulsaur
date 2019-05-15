const initState = {

    /**
     * saved
     *  
     * @description Contains names of saved time preferences
     * @param {String} id time preference identifier
     * @param {String} name name of saved time preference
     */
    saved: [
        {id: '1', name: 'Winter 2018', text: 'View'},
        {id: '2', name: 'Summer Quarter', text: 'View'},
        {id: '3', name: 'More Sleep', text: 'View'},
        {id: '4', name: 'Morning Only', text: 'View'},
        {id: '5', name: 'Chem TA Schedule', text: 'View'},
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
        {id:'1', name:'Winter 2018', time:'07-08 AM', available: [false, false, false, false, false, false, false]},
        {id:'2', name:'Winter 2018', time:'08-09 AM', available: [false, false, false, false, false, false, false]},
        {id:'3', name:'Winter 2018', time:'09-10 AM', available: [false, true, true, true, true, true, false]},
        {id:'4', name:'Winter 2018', time:'10-11 AM', available: [false, true, true, true, true, true, false]},
        {id:'5', name:'Winter 2018', time:'11-12 AM', available: [false, true, true, true, true, true, false]},
        {id:'6', name:'Winter 2018', time:'12-01 PM', available: [false, true, true, true, true, true, false]},
        {id:'7', name:'Winter 2018', time:'01-02 PM', available: [false, true, true, true, true, true, false]},
        {id:'8', name:'Winter 2018', time:'02-03 PM', available: [false, true, true, true, true, true, false]},
        {id:'9', name:'Winter 2018', time:'03-04 PM', available: [false, true, true, true, true, true, false]},
        {id:'10', name:'Winter 2018', time:'04-05 PM', available: [false, true, true, true, true, true, false]},
        {id:'11', name:'Winter 2018', time:'05-06 PM', available: [false, false, true, false, true, false, false]},
        {id:'12', name:'Winter 2018', time:'05-06 PM', available: [false, false, true, false, true, false, false]},
        {id:'13', name:'Winter 2018', time:'06-07 PM', available: [false, false, true, false, true, false, false]},
        {id:'14', name:'Winter 2018', time:'07-08 PM', available: [false, false, true, false, true, false, false]},
        {id:'15', name:'Winter 2018', time:'08-09 PM', available: [false, false, true, false, true, false, false]}
    ],

    table: [
        {id:'1', name:'', time:'07-08 AM', available: [false, false, false, false, false, false, false]},
        {id:'2', name:'', time:'08-09 AM', available: [false, false, false, false, false, false, false]},
        {id:'3', name:'', time:'09-10 AM', available: [false, false, false, false, false, false, false]},
        {id:'4', name:'', time:'10-11 AM', available: [false, false, false, false, false, false, false]},
        {id:'5', name:'', time:'11-12 AM', available: [false, false, false, false, false, false, false]},
        {id:'6', name:'', time:'12-01 PM', available: [false, false, false, false, false, false, false]},
        {id:'7', name:'', time:'01-02 PM', available: [false, false, false, false, false, false, false]},
        {id:'8', name:'', time:'02-03 PM', available: [false, false, false, false, false, false, false]},
        {id:'9', name:'', time:'03-04 PM', available: [false, false, false, false, false, false, false]},
        {id:'10', name:'', time:'04-05 PM', available: [false, false, false, false, false, false, false]},
        {id:'11', name:'', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
        {id:'12', name:'', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
        {id:'13', name:'', time:'06-07 PM', available: [false, false, false, false, false, false, false]},
        {id:'14', name:'', time:'07-08 PM', available: [false, false, false, false, false, false, false]},
        {id:'15', name:'', time:'08-09 PM', available: [false, false, false, false, false, false, false]}
    ],

    isViewing: false

}

const timeReducer = (state=initState, action) => {

    switch(action.type){
        case 'CHANGE AVAILABILITY':
            if(state.isViewing === false){
                let newTable = [...state.table]
                newTable[action.row_id].available[action.col_id] = !newTable[action.row_id].available[action.col_id]
                return {
                    ...state,
                    table: newTable,
                }
            }
            break;
        case 'VIEW':
            let newSaved = [...state.saved]
            newSaved.forEach(function(element){
                element.text = 'View'
            })
            console.log(state.saved[action.id].text)
            console.log(state.saved[action.id])
            console.log(state.saved)
            if(state.saved[action.id].text === 'View'){
                let savedTable = [...state.availability]
                newSaved[action.id].text = 'Viewing'
                return {
                    ...state,
                    saved: newSaved,
                    table: savedTable,
                    isViewing: true
                }
            }else{
            console.log(state.saved[action.id])
                let empty = [...state.table]
                empty.forEach(function(element){
                    element.available.fill(false)
                })
                return {
                    ...state,
                    saved: newSaved,
                    table: empty,
                    isViewing: false
                }
            }
        case 'CLEAR':
            let emptyTable = [...state.table]
            emptyTable.forEach(function(element){
                element.available.fill(false)
            })
            return {
                ...state,
                table: emptyTable
            }
        default:
            return state;
    }
    return state;
}

export default timeReducer;