const initState = {
    /**
     * flowchart
     *
     * @desc Contains information for grid layout for a given flowchart
     * @param {String} type the type of course
     * @param {String} len the length of quarters the course spans in the flowchart
     */
    flowchart: {
      row1: [
        { id: "0", type: "CSC", len: "1", name: "CSC/CPE 123" },
        { id: "1", type: "CSC", len: "1", name: "CSC/CPE 101" },
        { id: "2", type: "CSC", len: "1", name: "CSC/CPE 202" },
        { id: "3", type: "CSC", len: "1", name: "CSC/CPE 203" },
        { id: "4", type: "CSC", len: "2", name: "CSC 348" },
        { id: "5", type: "CSC", len: "6", name: "CSC/CPE 453" }
      ],
  
      row2: [
        { id: "6", type: "", len: "2" },
        { id: "7", type: "Support", len: "1", name: "LS Support" },
        { id: "8", type: "CSC", len: "1", name: "CSC 225" },
        { id: "9", type: "CSC", len: "1", name: "CSC/CPE 357" },
        { id: "10", type: "Support", len: "1", name: "M/S Support" },
        { id: "11", type: "CSC", len: "1", name: "CPE 315" },
        { id: "12", type: "CSC", len: "1", name: "CSC 300" },
        { id: "13", type: "CSC", len: "1", name: "Tech Elective" },
        { id: "14", type: "CSC", len: "1", name: "Tech Elective" },
        { id: "15", type: "CSC", len: "1", name: "CSC 491" },
        { id: "16", type: "CSC", len: "1", name: "CSC 492" }
      ],
  
      row3: [
        { id: "17", type: "Support", len: "1", name: "MATH 141" },
        { id: "18", type: "Support", len: "1", name: "MATH 142" },
        { id: "19", type: "Support", len: "1", name: "MATH 143" },
        { id: "20", type: "Support", len: "1", name: "MATH 244" },
        { id: "21", type: "Support", len: "1", name: "MATH 206" },
        { id: "22", type: "Support", len: "1", name: "STAT 312" },
        { id: "23", type: "CSC", len: "1", name: "CSC 349" },
        { id: "24", type: "CSC", len: "1", name: "CSC 430" },
        { id: "25", type: "CSC", len: "1", name: "CSC 431" },
        { id: "26", type: "CSC", len: "1", name: "CSC 445" },
        { id: "27", type: "CSC", len: "1", name: "Tech Elective" },
        { id: "28", type: "CSC", len: "1", name: "Tech Elective" }
      ],
  
      row4: [
        { id: "29", type: "GE", len: "3", name: "ENGL 133/134" },
        { id: "30", type: "Support", len: "1", name: "Phys / Chem 1" },
        { id: "31", type: "Support", len: "1", name: "Phys / Chem 2" },
        { id: "32", type: "Support", len: "1", name: "Phys / Chem 3" },
        { id: "33", type: "CSC", len: "1", name: "CSC 307" },
        { id: "34", type: "CSC", len: "1", name: "Tech Elective" },
        { id: "35", type: "", len: "1" },
        { id: "36", type: "CSC", len: "1", name: "Tech Elective" },
        { id: "37", type: "CSC", len: "1", name: "Tech Elective" },
        { id: "38", type: "Support", len: "1", name: "UD Support" }
      ],
  
      row5: [
        { id: "39", type: "GE", len: "3", name: "COMS 101/102" },
        { id: "40", type: "", len: "9" }
      ],
  
      row6: [
        { id: "41", type: "", len: "1" },
        { id: "42", type: "Support", len: "4", name: "ENGL 149" },
        { id: "43", type: "", len: "1" },
        { id: "44", type: "Support", len: "1", name: "Add. Support" },
        { id: "45", type: "", len: "2" },
        { id: "46", type: "Support", len: "1", name: "Add. Support" },
        { id: "47", type: "", len: "2" }
      ],
  
      row7: [
        { id: "48", type: "GE", len: "1", name: "**" },
        { id: "49", type: "GE", len: "1", name: "**" },
        { id: "50", type: "", len: "2" },
        { id: "51", type: "GE", len: "2", name: "**" },
        { id: "52", type: "", len: "1" },
        { id: "53", type: "GE", len: "1", name: "**" },
        { id: "54", type: "GE", len: "1", name: "**" },
        { id: "55", type: "", len: "1" },
        { id: "56", type: "GE", len: "1", name: "**" },
        { id: "57", type: "GE", len: "1", name: "**" }
      ]
    }
  };
  
  /**
   * --- Modifies the state according to dispatched action
   */
  const flowchartReducer = (state = initState, action = null) => {
    //    switch(action.type){
    //        default:
    //            return state
    //    }
    return state;
  };
  
  export default flowchartReducer;