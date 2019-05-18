import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';
import './Authentication.css'


class Login extends Component {
    state = {
        email: '',
        password: ''
    }

    handleSubmit = (e) => {
        e.preventDefault()

        // *** need to authenticate account here
        // *** need to authenticate account here

        this.props.history.push('/DashBoard')
    }

    handleChange = (e) => {
        this.setState({
           [e.target.id]: e.target.value
        })
    }

    handleSignUp = (e) => {
        this.props.history.push('/Signup')
    }

    render(){
        return(
            <div className='center-align auth'>
                <h1 className='title'>Schedulsaur</h1>
                <h5 className='title_description'>a friendly schedule finder</h5>
                <form onSubmit={this.handleSubmit} >
                    <div className='container form'>
                        <input type='email' id='email' placeholder='email' onChange={this.handleChange}/>
                        <input type='password' id='password' placeholder='password' onChange={this.handleChange}/>
                    </div>
                    <button className='btn signup_button' onClick={this.handleSignUp}>
                        Sign Up
                    </button>
                    <button className='btn login_button'>
                        Log In
                    </button>
                </form>
                <footer className='footer'>
                    <h5><NavLink to='./About' className='white-text'>About</NavLink></h5>
                </footer>
            </div>
        )
    }
}

export default Login;