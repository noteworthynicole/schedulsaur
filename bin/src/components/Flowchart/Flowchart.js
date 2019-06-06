import React, { Component } from "react";
import { connect } from "react-redux";
import styles from "./Flow.module.css";

class Flowchart extends Component {
  /**
   * --- Used to create the individual course boxes
   */
  createBox = course => {
    let coursesTaken = this.props.courseHistory.courses_taken;
    let desiredCourses = this.props.courseHistory.desired_courses;
    let boxState = {};

    if (coursesTaken.includes(course.name)) {
      boxState = { filter: "brightness(60%)" };
    }

    if (desiredCourses.includes(course.name)) {
      boxState = { border: "2px solid green" };
    }

    switch (course.type) {
      case "CSC":
        return (
          <div className={`${styles.box} ${styles.csc_box}`} style={boxState}>
            <div style={{ fontSize: "3px" }}>CSC</div>
            <div style={{ fontSize: "10px", marginTop: "2px" }}>
              {course.name}
            </div>
          </div>
        );
      case "Support":
        return (
          <div
            className={`${styles.box} ${styles.support_box}`}
            style={boxState}
          >
            <div style={{ fontSize: "3px" }}>Support</div>
            <div style={{ fontSize: "10px", marginTop: "2px" }}>
              {course.name}
            </div>
          </div>
        );
      case "GE":
        return (
          <div className={`${styles.box} ${styles.ge_box}`} style={boxState}>
            <div style={{ fontSize: "3px" }}>GE</div>
            <div style={{ fontSize: "10px", marginTop: "2px" }}>
              {course.name}
            </div>
          </div>
        );
      default:
        return <div className={styles.empty_box} />;
    }
  };

  /**
   * --- Used to create a row of courses
   */
  createRow = row => {
    return row.map((course, index) => {
      return (
        <div key={index} className={"col s" + course.len}>
          {this.createBox(course)}
        </div>
      );
    });
  };

  /**
   * --- Used to create the flowchart grid
   */
  createGrid = flowchart => {
    let grid = [];
    Object.keys(flowchart).forEach((row, index) => {
      grid.push(
        <div key={index} className="row">
          {this.createRow(flowchart[row])}
        </div>
      );
    });
    return grid;
  };

  render() {
    console.log(this.props.courseHistory.desired_courses);
    const { courses } = this.props;
    return (
      <div className={styles.grid_container}>
        {this.createGrid(courses.flowchart)}
      </div>
    );
  }
}

/**
 * mapStateToProps
 *
 * @description maps state from store to props
 * @param {*} state
 * @param {*} ownProps
 */
const mapStateToProps = (state, ownProps) => {
  return {
    courses: state.flowchart,
    courseHistory: state.courseHistory
  };
};

// 'connect' allows component to access the state from the store

export default connect(mapStateToProps)(Flowchart);