import React from "react";
import CourseBox from "./CourseBox";
import "./CourseHistory.css";

const CourseHistory = () => {
  return (
    <div>
      <div className="course-history">
        <div className="major">
          <CourseBox
            className="major"
            height="500px"
            title="Major (Completed)"
          />
        </div>
        <div className="support">
          <CourseBox height="450px" title="Support (Completed)" />
        </div>
        <div className="ge">
          <CourseBox height="300px" title="GEs (Completed)" />
        </div>
      </div>
      <button className="button-green" id="button-right">
        Save
      </button>
      <button className="button" id="button-left">
        Flowchart View
      </button>
    </div>
  );
};

export default CourseHistory;
