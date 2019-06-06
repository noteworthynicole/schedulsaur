const initState = {

    /**
     * descriptors
     * 
     * @desc List of column descriptors for a schedule
     */
    descriptors:[
        'Class Name', 'Sec.', 'Class #', 'Instructor', 'Open', 'Reserved', 
        'Taken', 'Waitlist', 'Status', 'Days', 'Start', 'End'
    ],

    /**
     * schedules
     * 
     * @desc Contains all the possible schedules
     * @param {String} id schedule identifier
     * @param {String} name schedule name
     * @param {Array} classes classes for a given schedule
     * @param {Array} times time table for a given schedule
     */
    schedules:[
        /* // example of one object in schedules list {id:'0', name:'Schedule 1', classes: [], times: []} */
    ],

    /**
     * savedSchedules
     * 
     * @desc Contains a list of saved schedules
     * @param {String} id schedule identifier
     * @param {String} name schedule name
     * @param {Array} classes classes for a given schedule
     * @param {Array} times time table for a given schedule
     */
    savedSchedules:[],

    /**
     * viewing
     * 
     * @desc Reflects the state of the viewing button
     * @param {String} text either 'View' or 'Collapse'
     */
    viewing: [ ],
    
    /**
     * sorters
     * 
     * @desc Contains the different sorters
     * @param {String} id sorter identifier
     * @param {String} name sorter name
     */    
    sorters: [
        {id:'0', name:'Earliest'},
        {id:'1', name:'Latest'},
        {id:'2', name:'Least Hours'},
        {id:'3', name:'Most Hours'},
        {id:'4', name:'Least Classes'},
        {id:'5', name:'Most Classes'}
    ],

    /**
     * filters
     * 
     * @desc Contains the different filters
     * @param {String} id filter identifier
     * @param {String} name filter name
     */
    filters: [
        {id: '0', name: '12 Units'},
        {id: '1', name: '16 Units'},
        {id: '2', name: 'Not Waitlisted'}
    ],

    /* // contains identifiers for the schedules the user wants to save */
    saved:[],

    /* // contains identifiers for the schedules the user selects */
    selected: [],

    /* // local state of page */
    isViewing: false,

    loading: true
}

/*
 * --- Clones a given schedule to prevent state destruction
*/
/*
const cloneSchedules = (schedules) => {
    let newSchedules = []
    schedules.map(schedule => {
        newSchedules.push(...schedule)
        newSchedules[newSchedules.length-1].classes = [...schedule.classes]
    })
    return(newSchedules)
}
*/

/**
 * filterSchedules
 * 
 * @desc Filter the list of schedules to grab only the schedules that were selected. 
 * @desc Prevents state destruction 
 * @param {array} schedules 'schedules' array
 * @param {array} selected 'selected' array
*/
const filterSchedules = (schedules, selected) => {
    let newSchedules = []
    schedules.forEach((schedule) => {
        if(selected.includes(schedule.id)){
            newSchedules.push({...schedule})
            newSchedules[newSchedules.length-1].classes = [...schedule.classes]
        }
    })
    return(newSchedules)
}

/**
 * viewing
 * 
 * @desc Clones the viewing list to prevent state destruction
 * @desc Resets text for each element to 'View'
 * @param {array} 'viewing' array
*/
const cloneViewing = (viewing) => {
    let newViewing = []
    viewing.forEach(function(element){
        newViewing.push({...element})
        newViewing[newViewing.length-1].text = 'View'
    })
    return(newViewing)
}

/**
 * --- Modifies the state according to dispatched action 
*/
const scheduleReducer = (state=initState, action=null) => {
    switch(action.type){
        case 'SCHEDULE_LOAD':
            let genSchedules = []
            let genViewing = []
            action.schedules.forEach((schedule,index) => {
                genSchedules.push({
                    id: index.toString(),
                    name: `Schedule ${index+1}`,
                    classes: [...schedule.rows],            
                    times: [
                        {id:'0', day:'Sun', available: schedule.time.blocks[0]},
                        {id:'1', day:'Mon', available: schedule.time.blocks[1]},
                        {id:'2', day:'Tue', available: schedule.time.blocks[2]},
                        {id:'3', day:'Wed', available: schedule.time.blocks[3]},
                        {id:'4', day:'Thu', available: schedule.time.blocks[4]},
                        {id:'5', day:'Fri', available: schedule.time.blocks[5]},
                        {id:'6', day:'Sat', available: schedule.time.blocks[6]}
                    ]
                })
                genViewing.push( {text: "View"} )
            }) 
            return {
                ...state,
                schedules: genSchedules,
                viewing: genViewing,
                loading: false
            }
        
        /* // When user is viewing a schedule */
        case 'SCHEDULE_VIEW':
            let editViewing = cloneViewing(state.viewing);
            if(state.viewing[action.index].text === 'View'){
                editViewing[action.index].text = 'Collapse'
                return{
                    ...state,
                    viewing: editViewing
                }
            
            /* // When user collapses a schedule */
            }else{
                return{
                    ...state,
                    viewing: editViewing
                }
            }

        /* // When user selects a schedule */
        case 'SCHEDULE_SELECT':
            let haveSelected = [...state.selected, action.id]
            return{
                ...state,
                selected: haveSelected
            }

        /* // When user deselects a schedule */
        case 'SCHEDULE_DESELECT':
            let haveNotSelected = state.selected.filter(id => {
                return id !== action.id
            })
            return{
                ...state,
                selected: haveNotSelected
            }
        
        /* // When user filters the list of schedules */
        case 'SCHEDULE_FILTER':
            break;

        /* // When user sorts the list of schedules */
        case 'SCHEDULE_SORT':
            break;

        /* // When user saves a selected set schedules */
        case 'SCHEDULE_SAVE':
            let newSaved = [...new Set([...state.saved, ...state.selected])]
            let newSavedSchedules = filterSchedules(state.schedules, newSaved)
            let newViewing = cloneViewing(state.viewing)
            return{
                ...state,
                saved: newSaved,
                savedSchedules: newSavedSchedules,
                viewing: newViewing,
                selected: []
            }
        
        case 'CLEAN':
            return{
                ...state,
                loading: true
            }

       default:
            return state;
    }
    return state;
}

export default scheduleReducer;