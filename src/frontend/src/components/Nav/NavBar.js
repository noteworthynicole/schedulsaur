import React from "react";
import { NavLink, withRouter } from "react-router-dom";
import "./NavBar.css";

const NavBar = props => {
  return (
    <div className="sidebar">

      {/* // NavLink navigates to a new page specified by 'to' attribute */}

      <NavLink className="dashboard-button" to="/DashBoard">
        Dashboard
      </NavLink>

      <NavLink className="sidebar-button" to="/CourseHistory">
        Course History
      </NavLink>

      <NavLink className="sidebar-button" to="/TimeAvailability">
        Time Availability
      </NavLink>

      <NavLink className="sidebar-button" to="/DesiredCourses">
        Desired Course
      </NavLink>

      <NavLink className="sidebar-button" to="/CreateSchedules">
        Create Schedules
      </NavLink>

      <NavLink className="sidebar-button" to="/SavedSchedules">
        Saved Schedules
      </NavLink>

      <NavLink className="help-button" to="/Help">
        Help
      </NavLink>

      <NavLink className="sidebar-button" to="/About">
        About
      </NavLink>

      <NavLink className="sidebar-button" to="/">
        Log Out
      </NavLink>
    </div>
  );
};

export default withRouter(NavBar);
