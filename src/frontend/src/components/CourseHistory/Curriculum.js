import React from "react";
import CourseBox from "./CourseBox";
import "./CourseHistory.css";

const Curriculum = ({type}) => {
  return (
    <div>
      <div className="course-history">
        <div className="major">
          <CourseBox
            className="major"
            height="500px"
            title={"Major ("+type+")"}
          />
        </div>
        <div className="support">
          <CourseBox height="450px" title={"Support ("+type+")"} />
        </div>
        <div className="ge">
          <CourseBox height="300px" title={"GEs ("+type+")"} />
        </div>
      </div>
    </div>
  );
};

export default Curriculum;
