import React, { Component } from "react";
import Curriculum from "../CourseHistory/Curriculum";
import Flowchart from "../Flowchart/Flowchart";
import styles from "./History.module.css";
import Popup from "reactjs-popup";

/**
 *-------------------------------------------------------
 * Main Course History Component
 *-------------------------------------------------------
 *
 * Contains both the curriculum view and flowchart
 *  for classes a student has already taken
 *
 *-------------------------------------------------------
 */

class CourseHistory extends Component {
  state = {
    viewCurriculum: true
  };

  /*
   * --- Generate either the curriculum or the flowchart
   */
  getView = () => {
    let view = this.state.viewCurriculum ? (
      <div className={styles.main_container}>
        <Curriculum type={"Completed"} />
      </div>
    ) : (
      <div className={styles.main_container}>
        <h2 className="subtitle" align="center">
          Completed Classes
        </h2>
        <Flowchart />
      </div>
    );
    return view;
  };

  /*
   * --- Change the button depending on page
   */
  getButtonText = () => {
    let text = this.state.viewCurriculum ? "Flowchart" : "Curriculum";
    return text;
  };

  /*
   * --- Switch to either the curriculum or the flowchart
   */
  handleSwitch = () => {
    this.setState({
      viewCurriculum: !this.state.viewCurriculum
    });
  };

  componentDidMount = () => {
    console.log("yo");
  };

  render() {
    return (
      <div>
        {this.getView()}
        <div align="right" className={styles.button_container}>
          <Popup
            trigger={
              <button
                className="white_button"
                style={{ marginRight: "0px" }}
                onClick={this.handleSave}
              >
                Save
              </button>
            }
            modal
            contentStyle={{ maxWidth: "459px", width: "90%" }}
            closeOnDocumentClick
            overlayStyle={{ width: "100%" }}
          >
            {close => (
              <div className={styles.modal}>
                <div className={styles.header}>Confirm Courses</div>
                <button onClick={close} className="white_button">
                  Cancel
                </button>
                <button onClick={close} className="green_button">
                  Save
                </button>
              </div>
            )}
          </Popup>
          <button className="green_button" onClick={this.handleSwitch}>
            {this.getButtonText()}
          </button>
        </div>
      </div>
    );
  }
}

export default CourseHistory;