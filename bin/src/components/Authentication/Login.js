import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';
import styles from './Auth.module.css';


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
            <div className={styles.main_container}>
                <div className='title-container'>
                  <h1 className='title'>Schedulsaur</h1>
                  <h5 className='title-description'>a friendly schedule finder</h5>
                </div>
                <form className={styles.form_container} onSubmit={this.handleSubmit} >
                    <input type='email' id='email' placeholder='email' onChange={this.handleChange}/>
                    <input type='password' id='password' placeholder='password' onChange={this.handleChange}/>
                    <div className={styles.button_container}>
                      <button className={`btn-small ${styles.signup_button}`} onClick={this.handleSignUp}>
                          Sign Up
                      </button>
                      <button className={`btn-small ${styles.login_button}`}>
                          Log In
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

export default Login;