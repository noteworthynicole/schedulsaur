import React, { Component } from "react";
import "./CourseBox.css";
import Course from "./Course";
import { connect } from "react-redux";

export class CourseBox extends Component {
  constructor(props) {
    super(props);
    this.myRef = React.createRef();
  }

  getGEs = () => {
    return this.props.courseHistory.ge_list.map(course => (
      <Course pageType={this.props.pageType} courseName={course} />
    ));
  };

  getMajorCourses = () => {
    return this.props.courseHistory.csc_major.map(course => (
      <Course pageType={this.props.pageType} courseName={course} />
    ));
  };

  getSupports = () => {
    return this.props.courseHistory.csc_support.map(course => (
      <Course pageType={this.props.pageType} courseName={course} />
    ));
  };

  courseContent = () => {
    switch (this.props.boxType) {
      case "major":
        return this.getMajorCourses();

      case "support":
        return this.getSupports();

      case "ge":
        return this.getGEs();

      default:
        return null;
    }
  };

  componentDidMount() {
    this.myRef.current.scrollTop = 0;
  }

  render() {
    return (
      <div className="course-box">
        <h1 align="center" className="box-header">
          {this.props.title}
        </h1>
        <div
          ref={this.myRef}
          className="course-section"
          style={{ height: this.props.height }}
        >
          {this.courseContent()}
        </div>
      </div>
    );
  }
}
/*
 * mapStateToProps
 *
 * @description maps state from store to props
 * @param {*} state
 * @param {*} ownProps
 */
const mapStateToProps = (state, ownProps) => {
  return {
    courseHistory: state.courseHistory
  };
};

/**
 * mapStateToDispatch
 *
 * @description maps dispatch to props to allow component to send an action
 * @param {*} dispatch
 */
const mapStateToDispatch = dispatch => {
  return {};
};

export default connect(
  mapStateToProps,
  mapStateToDispatch
)(CourseBox);