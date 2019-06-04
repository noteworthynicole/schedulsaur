import React, { Component } from "react";
import "./Course.css";
import { Checkbox } from "antd";
import { connect } from "react-redux";
import {
  addHistory,
  removeHistory,
  removeDesired,
  addDesired
} from "../../store/actions/courseActions";

export class Course extends Component {
  constructor(props) {
    super(props);

    this.state = {
      color: "white"
    };
  }

  updateDesiredClasses = () => {
    const desiredCourses = this.props.courseHistory.desired_courses;
    console.log(desiredCourses);
    if (desiredCourses.includes(this.props.courseName)) {
      this.props.removeDesired(this.props.courseName);
    } else {
      this.props.addDesired(this.props.courseName);
    }
  };

  updateCompletedClasses = () => {
    const takenCourses = this.props.courseHistory.courses_taken;
    console.log(takenCourses);
    if (takenCourses.includes(this.props.courseName)) {
      this.props.removeHistory(this.props.courseName);
    } else {
      this.props.addHistory(this.props.courseName);
    }
  };

  handleClick = () => {
    switch (this.props.pageType) {
      case "Desired":
        this.updateDesiredClasses();
        break;
      case "Completed":
        this.updateCompletedClasses();
        break;

      default:
        break;
    }
  };

  hasTaken = () => {
    const takenCourses = this.props.courseHistory.courses_taken;

    if (takenCourses.includes(this.props.courseName)) {
      return true;
    }
  };

  isDisabled = () => {
    if (this.hasTaken() && this.props.pageType === "Desired") {
      return true;
    }
    return false;
  };

  hasLineThrough = () => {
    if (this.isDisabled()) {
      return "line-through";
    }
    return "none";
  };

  changeColor = () => {
    this.setState({ color: "#f2f2f2" });
  };

  changeWhite = () => {
    this.setState({ color: "white" });
  };

  render() {
    return (
      <div
        className="course"
        onMouseEnter={this.changeColor}
        onMouseLeave={this.changeWhite}
        style={{
          backgroundColor: this.state.color,
          textDecoration: this.hasLineThrough()
        }}
      >
        <div className="leftSection">
          <Checkbox
            onClick={this.handleClick}
            className="checkBox"
            autoFocus={true}
            defaultChecked={this.hasTaken()}
            disabled={this.isDisabled()}
          />
        </div>
        <div className="midSection"> {this.props.courseName} </div>
      </div>
    );
  }
}

const mapStateToProps = (state, ownProps) => {
  return {
    courseHistory: state.courseHistory
  };
};

const mapStateToDispatch = dispatch => {
  return {
    removeHistory: courseName => {
      dispatch(removeHistory(courseName));
    },
    addHistory: courseName => {
      dispatch(addHistory(courseName));
    },
    removeDesired: courseName => {
      dispatch(removeDesired(courseName));
    },
    addDesired: courseName => {
      dispatch(addDesired(courseName));
    }
  };
};

export default connect(
  mapStateToProps,
  mapStateToDispatch
)(Course);
