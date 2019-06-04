import { produce } from "immer";

const initState = {
  csc_major: [
    "CSC/CPE 101",
    "CSC/CPE 123",
    "CSC/CPE 108",
    "CSC/CPE 202",
    "CSC/CPE 203",
    "CSC 225",
    "CSC 300",
    "CSC 307",
    "CSC 308",
    "CSC 309",
    "CPE 315",
    "CSC 348",
    "CSC 349",
    "CSC/CPE 357",
    "CSC 430",
    "CSC/CPE 431",
    "CSC 445",
    "CSC/CPE 453",
    "CSC 491",
    "CSC 492",
    "CSC 497",
    "CSC 498"
  ],
  csc_support: [
    "ENGL 149",
    "MATH 141",
    "MATH 142",
    "MATH 143",
    "MATH 206",
    "MATH 244",
    "STAT 312",
    "BIO 111",
    "BIO 161",
    "BIO 213",
    "BMED 213",
    "BOT 121",
    "MCRO 221",
    "MCRO 224",
    "MATH 241",
    "MATH 248",
    "MATH 306",
    "MATH 335",
    "MATH 336",
    "MATH 437",
    "MATH 470",
    "STAT 313",
    "STAT 323",
    "STAT 324",
    "STAT 330",
    "STAT 331",
    "STAT 334",
    "STAT 416",
    "STAT 418",
    "STAT 419",
    "STAT 434",
    "CHEM 124",
    "CHEM 125",
    "CHEM 126",
    "PHYS 141",
    "PHYS 132",
    "PHYS 133",
    "BIO 111",
    "BIO 161",
    "BOT 121",
    "CHEM 124",
    "MCRO 221",
    "MCRO 224",
    "PHYS 141"
  ],

  ge_list: [
    "Expository Writing (A1)",
    "Oral Communication (A2)",
    "Reasoning, Argumentation, Writing (A3)",
    "Mathematics/Stats (B1)",
    "Life Science (B2)",
    "Physical Science (B3)",
    "Science/Math Elective (B1-5)",
    "Uppder-Div Science/Math (B6)",
    "Literature (C1)",
    "Philosophy (C2)",
    "Fine and Performing Arts (C3)",
    "Arts/Humanities Elective (C1-5)",
    "The American Experience (D1)",
    "Political Economy (D2)",
    "Comparative Social Institutions (D3)",
    "Self Development (D4)",
    "Arts and Humanities - Upper Division",
    "Society and the Individual - Upper Division",
    "Technology (F)"
  ],

  courses_taken: [
    "CSC/CPE 101",
    "CSC/CPE 123",
    "CSC/CPE 108",
    "CSC/CPE 202",
    "CSC/CPE 203"
  ],

  desired_courses: ["MATH 143"]
};

const courseHistoryReducer = (state = initState, action = null) =>
  produce(state, draft => {
    switch (action.type) {
      case "REMOVE_HISTORY":
        draft.courses_taken = [];
        state.courses_taken.forEach(course => {
          if (course !== action.courseName) {
            draft.courses_taken.push(course);
          }
        });
        break;

      case "ADD_HISTORY":
        draft.courses_taken.push(action.courseName);
        break;

      case "REMOVE_DESIRED":
        draft.desired_courses = [];
        state.desired_courses.forEach(course => {
          if (course !== action.courseName) {
            draft.desired_courses.push(course);
          }
        });
        break;

      case "ADD_DESIRED":
        draft.desired_courses.push(action.courseName);
        break;

      default:
        break;
    }
  });

export default courseHistoryReducer;
