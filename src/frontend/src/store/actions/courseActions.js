import axios from "axios";

export const removeHistory = courseName => {
  return {
    type: "REMOVE_HISTORY",
    courseName: courseName
  };
};

export const addHistory = courseName => {
  return {
    type: "ADD_HISTORY",
    courseName: courseName
  };
};

export const removeDesired = courseName => {
  return {
    type: "REMOVE_DESIRED",
    courseName: courseName
  };
};

export const addDesired = courseName => {
  return {
    type: "ADD_DESIRED",
    courseName: courseName
  };
};

const init = courses => {
  return { type: "INIT", courses: courses };
};

export const initCourseHistory = id => {
  //console.log("HII", id);
  return dispatch => {
    axios.get(`http://localhost:8080/courses?id=${id}`).then(response => {
      console.log(response.data);
      dispatch(init(response.data));
    });
  };
};
