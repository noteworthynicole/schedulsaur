import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';
import styles from './Auth.module.css';

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
            <div className={styles.main_container}>
                <div className='title-container'>
                    <h1 className='title'>Schedulsaur</h1>
                    <h5 className='title-description'>a friendly schedule finder</h5>
                </div>
                <form className={styles.form_container} onSubmit={this.handleSubmit} >
                    <input type='text' id='firstName' placeholder='first name' onChange={this.handleChange}/>
                    <input type='text' id='lastName' placeholder='last name' onChange={this.handleChange}/>
                    <input type='email' id='email' placeholder='email' onChange={this.handleChange}/>
                    <input type='password' id='password' placeholder='password' onChange={this.handleChange}/>
                    <div className={styles.button_container}>
                        <button className={`btn ${styles.signup_button}`}>
                            Sign Up
                        </button>
                    </div>
                </form>
                <footer className='footer'>
                    <h5><NavLink to='./About' className='white-text'>About</NavLink></h5>
                </footer>
            </div>
        )
    }
}

export default Signup;