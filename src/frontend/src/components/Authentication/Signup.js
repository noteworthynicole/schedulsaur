import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';
import './Authentication.css'

class Signup extends Component {
    state = {
        email: '',
        password: '',
        firstName: '',
        lastName: ''
    }

    handleSubmit = (e) => {
        e.preventDefault()

        // *** need to authenticate here and create new account here
        // *** need to authenticate here and create new account here

        this.props.history.push('./Dashboard')
    }

    hangleChange = (e) => {
        this.setState({
           [e.target.id]: e.target.value
        })
    }

    render(){
        return(
            <div className='center-align'>
                <h1 className='title'>Schedulsaur</h1>
                <h5 className='title_description'>a friendly schedule finder</h5>
                <form onSubmit={this.handleSubmit} >
                    <div className="container">
                        <input type='text' id='firstName' placeholder='first name' onChange={this.handleChange}/>
                        <input type='text' id='lastName' placeholder='last name' onChange={this.handleChange}/>
                        <input type='email' id='email' placeholder='email' onChange={this.handleChange}/>
                        <input type='password' id='password' placeholder='password' onChange={this.handleChange}/>
                    </div>
                    <button className='btn signup_button'>
                        Sign Up
                    </button>
                </form>
                <footer className='footer'>
                    <h5><NavLink to='./About' className='white-text'>About</NavLink></h5>
                </footer>
            </div>
        )
    }
}

export default Signup;