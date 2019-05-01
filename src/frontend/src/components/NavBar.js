import React from 'react';
import { NavLink, withRouter } from 'react-router-dom';

const NavBar = (props) => {
    return(
        <div className='app-body'>
            <div className='sidebar'>
                <li><NavLink to='/DashBoard'>Dashboard</NavLink></li>
                <li><NavLink to='/CourseHistory'>Course History</NavLink></li>
                <li><NavLink to='/TimeAvailability'>Time Availability</NavLink></li>
                <li><NavLink to='/DesirecCourse'>Desired Course</NavLink></li>
                <li><NavLink to='/CreateSchedules'>Create Schedules</NavLink></li>
                <li><NavLink to='/SavedSchedules'>Saved Schedules</NavLink></li>
                <li><NavLink to='/Help'>Help</NavLink></li>
                <li><NavLink to='/About'>About</NavLink></li>
                <li><NavLink to='/LogOut'>Log Out</NavLink></li>
            </div>
        </div>
    );
}

export default withRouter(NavBar);
