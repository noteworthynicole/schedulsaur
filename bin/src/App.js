import React, { Component } from 'react';
import TopBar from './components/Nav/TopBar';
import NavBar from './components/Nav/NavBar';
import Login from './components/Authentication/Login';
import Signup from './components/Authentication/Signup';
import DashBoard from './components/Dashboard/DashBoard';
import CourseHistory from './components/History/CourseHistory';
import Time from './components/TimeAvailability/Time'
import DesiredCourse from './components/History/DesiredCourse';
import PotentialSchedules from './components/Schedules/PotentialSchedules'
import SavedSchedules from './components/Schedules/SavedSchedules'
import About from './components/Other/About'
import Help from './components/Other/Help'
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';

/**
 * Main App Class
 * 
 * Router is used to navigate between pages
 * Switch allows url to match only one route at a time
 */

class App extends Component {
  render(){
    return (
      <BrowserRouter>
        <div className='all'>
          <Switch>

            {/* // Pages Outside Main Application */}

            <Route exact path='/' component={Login}/>
            <Route path='/Signup' component={Signup}/>
            <Route path='/About' component={About}/>

            {/* // Pages Inside Main Application */}

            <div className='app-body'>   {/* // Format for entire page */}
              <TopBar />
              <NavBar />
              <div className='main'>      {/* // Format for body of app */}
                <Route path='/DashBoard' component={DashBoard}/>
                <Route path='/CourseHistory' component={CourseHistory}/>
                <Route path='/TimeAvailability' component={Time}/>
                <Route path='/DesiredCourses' component={DesiredCourse}/>
                <Route path='/CreateSchedules' component={PotentialSchedules}/>
                <Route path='/SavedSchedules' component={SavedSchedules}/>
                <Route path='/Help' component={Help}/>
              </div>
            </div>
          </Switch>
        </div>
      </BrowserRouter>
    );
  }
}


export default App;