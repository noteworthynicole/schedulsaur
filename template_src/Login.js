import React, { Component } from 'react';
import './App.css';
import { Redirect } from 'react-router';

class App extends Component {
  state = {
   toDashboard: false,
 }
  handleClick = () => {
    this.setState({
        toDashboard: true,
      });
  }
  render() {
    {/*if (this.state.toDashboard === true) {
      return <Redirect to='./Dashboard' />
    */}
    return (
      <div class="all">
      {/*Since this is the login page, I repurposed top_zone to become bottom_zone
        and all the stylings are separate to get the "centeredness" compared
        to the rest of the aspects. Login_input takes care of the input and them
        login_button is nearly identical besides the fixed position. The wrapper
        sucessfully makes it centerd vertically, but I had to use padding to get
        the horizontal "middleness" so if it looks wrong on your screen, this is why.*/}
      <div class="loginWrapper">
      <h1>Schedulsaur</h1>
      <h2>a friendly schedule finder</h2>
      <input type="text" id="email_name" class="login_input" placeholder="Email"/>
      <br/>
      <input type="text" id="password_name" class = "login_input" placeholder="Password"/>
      <br/>
        <div class="loginButton" id="button_left" onClick={this.handleClick}>
           <a>Login</a>
        </div>
        <div class="loginButton" id="button_right" onClick={this.handleClick}>
           <a>Sign Up</a>
        </div>
      </div>
      <div class="bottom_zone">
        <p align="center"> About </p>
      </div>
              </div>
    );

  }
}

export default App;
