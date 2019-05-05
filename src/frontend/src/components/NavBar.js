import React from 'react';
import { NavLink, withRouter } from 'react-router-dom';

/**
 * NavBar 
 * 
 * @description Component to create the navigation bar
 * @param {*} props 
 */

const NavBar = (props) => {
    return(
        <div className='sidebar'>

            {/* // NavLink navigates to a new page specified by 'to' attribute */}

            <li className='sidebar-button'><NavLink to='/DashBoard'>Dashboard</NavLink></li>
            <li className='sidebar-button'><NavLink to='/CourseHistory'>Course History</NavLink></li>
            <li className='sidebar-button'><NavLink to='/TimeAvailability'>Time Availability</NavLink></li>
            <li className='sidebar-button'><NavLink to='/DesiredCourse'>Desired Course</NavLink></li>
            <li className='sidebar-button'><NavLink to='/CreateSchedules'>Create Schedules</NavLink></li>
            <li className='sidebar-button'><NavLink to='/SavedSchedules'>Saved Schedules</NavLink></li>
            <li className='sidebar-button'><NavLink to='/Help'>Help</NavLink></li>
            <li className='sidebar-button'><NavLink to='/About'>About</NavLink></li>
            <li className='sidebar-button'><NavLink to='/'>Log Out</NavLink></li>
        </div>
    );
}

export default withRouter(NavBar);
