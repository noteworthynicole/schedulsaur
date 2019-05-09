import React, { Component } from "react";
import "./Course.css";
import { Checkbox } from "antd";

export default class Course extends Component {
  constructor(props) {
    super(props);

    this.state = {
      color: "white"
    };
  }

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
          backgroundColor: this.state.color
        }}
      >
        <div className="leftSection">
          <Checkbox className="checkBox" autoFocus="true" />
        </div>
        <div className="midSection"> {this.props.courseName} </div>
      </div>
    );
  }
}
