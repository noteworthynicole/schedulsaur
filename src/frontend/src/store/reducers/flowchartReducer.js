const initState = {
    /**
     * flowchart
     * 
     * @desc Contains information for grid layout for a given flowchart
     * @param {String} type the type of course
     * @param {String} len the length of quarters the course spans in the flowchart
     */
    flowchart: {
        row1:[
            {id:'0', type:'CSC', len:'1'},
            {id:'1', type:'CSC', len:'1'},
            {id:'2', type:'CSC', len:'1'},
            {id:'3', type:'CSC', len:'1'},
            {id:'4', type:'CSC', len:'2'},
            {id:'5', type:'CSC', len:'6'}
        ],

        row2:[
            {id:'6', type:'', len:'2'},
            {id:'7', type:'Support', len:'1'},
            {id:'8', type:'CSC', len:'1'},
            {id:'9', type:'CSC', len:'1'},
            {id:'10', type:'Support', len:'1'},
            {id:'11', type:'CSC', len:'1'},
            {id:'12', type:'CSC', len:'1'},
            {id:'13', type:'CSC', len:'1'},
            {id:'14', type:'CSC', len:'1'},
            {id:'15', type:'CSC', len:'1'},
            {id:'16', type:'CSC', len:'1'}
        ],

        row3:[
            {id:'17', type:'Support', len:'1'},
            {id:'18', type:'Support', len:'1'},
            {id:'19', type:'Support', len:'1'},
            {id:'20', type:'Support', len:'1'},
            {id:'21', type:'Support', len:'1'},
            {id:'22', type:'Support', len:'1'},
            {id:'23', type:'CSC', len:'1'},
            {id:'24', type:'CSC', len:'1'},
            {id:'25', type:'CSC', len:'1'},
            {id:'26', type:'CSC', len:'1'},
            {id:'27', type:'CSC', len:'1'},
            {id:'28', type:'CSC', len:'1'}
        ],

        row4:[
            {id:'29', type:'GE', len:'3'},
            {id:'30', type:'Support', len:'1'},
            {id:'31', type:'Support', len:'1'},
            {id:'32', type:'Support', len:'1'},
            {id:'33', type:'CSC', len:'1'},
            {id:'34', type:'CSC', len:'1'},
            {id:'35', type:'', len:'1'},
            {id:'36', type:'CSC', len:'1'},
            {id:'37', type:'CSC', len:'1'},
            {id:'38', type:'Support', len:'1'}
        ],

        row5:[
            {id:'39', type:'GE', len:'3'},
            {id:'40', type:'', len:'9'}
        ],

        row6:[
            {id:'41', type:'', len:'1'},
            {id:'42', type:'Support', len:'4'},
            {id:'43', type:'', len:'1'},
            {id:'44', type:'Support', len:'1'},
            {id:'45', type:'', len:'2'},
            {id:'46', type:'Support', len:'1'},
            {id:'47', type:'', len:'2'}
        ],

        row7:[
            {id:'48', type:'GE', len:'1'},
            {id:'49', type:'GE', len:'1'},
            {id:'50', type:'', len:'2'},
            {id:'51', type:'GE', len:'2'},
            {id:'52', type:'', len:'1'},
            {id:'53', type:'GE', len:'1'},
            {id:'54', type:'GE', len:'1'},
            {id:'55', type:'', len:'1'},
            {id:'56', type:'GE', len:'1'},
            {id:'57', type:'GE', len:'1'}
        ]
    }
}

/**
 * --- Modifies the state according to dispatched action 
*/
const flowchartReducer = (state=initState, action=null) => {
//    switch(action.type){
//        default:
//            return state
//    }
    return state;
}

export default flowchartReducer;
