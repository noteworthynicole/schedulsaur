import React, { Component } from "react";
import "./CourseBox.css";
import Course from "./Course";

export default class CourseBox extends Component {
  render() {
    return (
      <div className="course-box">
        <h1 align="center" className="box-header">
          {this.props.title}
        </h1>
        <div className="course-section" style={{ height: this.props.height }}>
          <Course courseName="CSC/CPE 101" />
          <Course courseName="CSC/CPE 101" />
          <Course courseName="CSC/CPE 101" />
          <Course courseName="CSC/CPE 101" />
          <Course courseName="CSC/CPE 101" />
          <Course courseName="CSC/CPE 101" />
          <Course courseName="CSC/CPE 101" />
          <Course courseName="CSC/CPE 101" />
          <Course courseName="CSC/CPE 101" />
          <Course courseName="CSC/CPE 101" />
        </div>
      </div>
    );
  }
}
