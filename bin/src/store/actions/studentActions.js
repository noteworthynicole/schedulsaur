import axios from "axios";
import { initCourseHistory } from "./courseActions";
/**
 * init
 *
 * @desc Initialize the user's information
 */
export const init = email => {
  // required to pause dispatch for async calls
  return dispatch => {
    // add email password here **************
    axios.get(`http://localhost:8080/user/${email}`).then(response => {
      // carry on with dispatch after async call finishes
      dispatch({ type: "STUDENT_INIT", user: response.data });
    });
  };
};

/**
 * edit
 *
 * @desc Edit the user's information
 */
export const edit = () => {
  return {
    type: "EDIT_INFO"
  };
};

/**
 * save
 *
 * @description Save the user's information
 */
export const save = (newInfo, id) => {
  return dispatch => {
    // axios update call *******************
    axios
      .put("http://localhost:8080/user/update", {
        id: id,
        name: newInfo[0].text,
        major: newInfo[1].text,
        minor: newInfo[2].text,
        catalogYear: newInfo[3].text,
        planningQuarter: newInfo[4].text,
        unitsThisQuarter: newInfo[5].text
      })
      .then(() => {
        // need to verify if post was successful (response.status should equal 200)
        dispatch({ type: "STUDENT_SAVE", info: newInfo });
      });
  };
};

/**
 * createNew
 *
 * @description Create a new user
 * @param {*} user
 */
export const createNew = user => {
  return dispatch => {
    axios
      .post("http://localhost:8080/user", {
        id: "NULL",
        name: user.name,
        major: user.major,
        minor: user.minor,
        catalogYear: user.catalogYear,
        planningQuarter: user.planningQuarter,
        unitsThisQuarter: user.unitsThisQuarter,
        email: user.email,
        password: user.password,
        previousClasses: "NULL"
      })
      .then(response => {
        // need to verify if post was successful (response.status should equal 200)
        dispatch({ type: "STUDENT_INIT", user: response.data });
      });
  };
};
