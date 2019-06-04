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
