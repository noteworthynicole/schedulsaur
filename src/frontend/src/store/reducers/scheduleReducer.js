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
        { id: '0',
          name: 'Schedule 1',
          classes:[
            {name:'CSC 300', sec:'LEC', num:'6807', instr:'Sakellarious, N.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'TR', start:'12:00 PM', end:'01:30 PM'},
            {name:'CSC 300', sec:'LAB', num:'6808', instr:'Sakellarious, N.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'TR', start:'01:40 PM', end:'03:00 PM'},
            {name:'CSC 309', sec:'LEC', num:'6798', instr:'Falessi, D.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'MWF', start:'10:00 AM', end:'11:00 AM'},
            {name:'CSC 309', sec:'LAB', num:'6799', instr:'Falessi, D.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'MWF', start:'11:00 AM', end:'12:00 PM'}
          ],
          times: [
              {id:'0', time:'07-08 AM', available: [false, false, false, false, false, false, false]},
              {id:'1', time:'08-09 AM', available: [false, false, false, false, false, false, false]},
              {id:'2', time:'09-10 AM', available: [false, false, false, false, false, false, false]},
              {id:'3', time:'10-11 AM', available: [false, true, false, true, false, true, false]},
              {id:'4', time:'11-12 AM', available: [false, true, false, true, false, true, false]},
              {id:'5', time:'12-01 PM', available: [false, false, true, false, true, false, false]},
              {id:'6', time:'01-02 PM', available: [false, false, true, false, true, false, false]},
              {id:'7', time:'02-03 PM', available: [false, false, true, false, true, false, false]},
              {id:'8', time:'03-04 PM', available: [false, false, false, false, false, false, false]},
              {id:'9', time:'04-05 PM', available: [false, false, false, false, false, false, false]},
              {id:'10', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
              {id:'11', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
              {id:'12', time:'06-07 PM', available: [false, false, false, false, false, false, false]},
              {id:'13', time:'07-08 PM', available: [false, false, false, false, false, false, false]},
              {id:'14', time:'08-09 PM', available: [false, false, false, false, false, false, false]}
          ],
        },

        { id: '1',
          name: 'Schedule 2',
          classes:[
            {name:'CSC 300', sec:'LEC', num:'6807', instr:'Sakellarious, N.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'TR', start:'12:00 PM', end:'01:30 PM'},
            {name:'CSC 300', sec:'LAB', num:'6808', instr:'Sakellarious, N.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'TR', start:'01:40 PM', end:'03:00 PM'},
            {name:'CSC 309', sec:'LEC', num:'6798', instr:'Falessi, D.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'MWF', start:'10:00 AM', end:'11:00 AM'},
            {name:'CSC 309', sec:'LAB', num:'6799', instr:'Falessi, D.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'MWF', start:'11:00 AM', end:'12:00 PM'}
          ],
          times: [
              {id:'0', time:'07-08 AM', available: [false, false, false, false, false, false, false]},
              {id:'1', time:'08-09 AM', available: [false, false, false, false, false, false, false]},
              {id:'2', time:'09-10 AM', available: [false, false, false, false, false, false, false]},
              {id:'3', time:'10-11 AM', available: [false, true, false, true, false, true, false]},
              {id:'4', time:'11-12 AM', available: [false, true, false, true, false, true, false]},
              {id:'5', time:'12-01 PM', available: [false, false, true, false, true, false, false]},
              {id:'6', time:'01-02 PM', available: [false, false, true, false, true, false, false]},
              {id:'7', time:'02-03 PM', available: [false, false, true, false, true, false, false]},
              {id:'8', time:'03-04 PM', available: [false, false, false, false, false, false, false]},
              {id:'9', time:'04-05 PM', available: [false, false, false, false, false, false, false]},
              {id:'10', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
              {id:'11', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
              {id:'12', time:'06-07 PM', available: [false, false, false, false, false, false, false]},
              {id:'13', time:'07-08 PM', available: [false, false, false, false, false, false, false]},
              {id:'14', time:'08-09 PM', available: [false, false, false, false, false, false, false]}
          ],
        },

        { id: '2',
          name: 'Schedule 3',
          classes:[
            {name:'CSC 300', sec:'LEC', num:'6807', instr:'Sakellarious, N.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'TR', start:'12:00 PM', end:'01:30 PM'},
            {name:'CSC 300', sec:'LAB', num:'6808', instr:'Sakellarious, N.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'TR', start:'01:40 PM', end:'03:00 PM'},
            {name:'CSC 309', sec:'LEC', num:'6798', instr:'Falessi, D.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'MWF', start:'10:00 AM', end:'11:00 AM'},
            {name:'CSC 309', sec:'LAB', num:'6799', instr:'Falessi, D.', open:'22', res:'0', tak:'13', wait:'0', status:'Open', days:'MWF', start:'11:00 AM', end:'12:00 PM'}
          ],
          times: [
              {id:'0', time:'07-08 AM', available: [false, false, false, false, false, false, false]},
              {id:'1', time:'08-09 AM', available: [false, false, false, false, false, false, false]},
              {id:'2', time:'09-10 AM', available: [false, false, false, false, false, false, false]},
              {id:'3', time:'10-11 AM', available: [false, true, false, true, false, true, false]},
              {id:'4', time:'11-12 AM', available: [false, true, false, true, false, true, false]},
              {id:'5', time:'12-01 PM', available: [false, false, true, false, true, false, false]},
              {id:'6', time:'01-02 PM', available: [false, false, true, false, true, false, false]},
              {id:'7', time:'02-03 PM', available: [false, false, true, false, true, false, false]},
              {id:'8', time:'03-04 PM', available: [false, false, false, false, false, false, false]},
              {id:'9', time:'04-05 PM', available: [false, false, false, false, false, false, false]},
              {id:'10', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
              {id:'11', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
              {id:'12', time:'06-07 PM', available: [false, false, false, false, false, false, false]},
              {id:'13', time:'07-08 PM', available: [false, false, false, false, false, false, false]},
              {id:'14', time:'08-09 PM', available: [false, false, false, false, false, false, false]}
          ],
        }
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
    viewing: [
        {text: 'View'},
        {text: 'View'},
        {text: 'View'}
    ],
    
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
    isViewing: false
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
        default:
            return state;
    }
    return state;
}

export default scheduleReducer;