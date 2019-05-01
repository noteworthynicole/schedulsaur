import React, { Component } from 'react';
import TopBar from './components/TopBar';
import NavBar from './components/NavBar';
import Login from './components/Authentication/Login';
import Signup from './components/Authentication/Signup';
import DashBoard from './components/DashBoard';
import PotentialSchedules from './components/Schedules/PotentialSchedules';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';

class App extends Component {
  render(){
    return (
      <BrowserRouter>
        <div className='all'>
          <Switch>
            <Route exact path='/' component={Login}/>
            <Route path='/Signup' component={Signup}/>
            <Route path='/DashBoard' component={DashBoard}/>
{/*
            <Route path='/CourseHistory' component={CourseHistory}/>
            <Route path='/TimeAvailability' component={TimeAvailability}/>
            <Route path='/DesiredCourse' component={DesiredCourse}/>
            <Route path='/CreateSchedules' component={CreateSchedules}/>
*/}
            <Route path='/PotentialSchedules' component={PotentialSchedules}/>
{/*
            <Route path='/SavedSchedules' component={SavedSchedules}/>
            <Route path='/Help' component={Help}/>
            <Route path='/About' component={About}/>
            <Route path='/LogOut' component={LogOut}/>
*/}
          </Switch>
        </div>
      </BrowserRouter>
    );
  }
}


export default App;