import React, { Component } from 'react';
import { connect } from 'react-redux';
import { createNew } from '../../store/actions/studentActions';
import { NavLink } from 'react-router-dom';
import styles from './Auth.module.css';

class Signup extends Component {
    state = {
        email: '',
        password: '',
        name: '',
        major: '',
        minor: 'N/A',
        catalogYear: '',
        planningQuarter: 'N/A',
        unitsThisQuarter: '0',
        continue: false
    }

    handleSubmit = (e) => {
       e.preventDefault()
       this.props.createNew(this.state);
       this.props.history.push('./Dashboard')
    }

    handleChange = (e) => {
        this.setState({
           [e.target.id]: e.target.value
        })
    }

    handleContinue = (e) => {
        e.preventDefault()
        e.target.reset()

        this.setState({
            continue: true
        })
    }

    getForm = () => {
        let currentForm =
            this.state.continue ? (
                <form className={styles.form_container} onSubmit={this.handleSubmit}>
                    <input type='text' id='major' placeholder='Major' onChange={this.handleChange}/>
                    <input type='text' id='minor' placeholder='Minor (if any)' onChange={this.handleChange}/>
                    <input type='text' id='catalogYear' placeholder='Catalog Year' onChange={this.handleChange}/>
                    <div className={styles.button_container}>
                        <button className={`btn ${styles.signup_button}`} onClick={this.handleSubmit}>
                            Sign Up
                        </button>
                    </div>
                </form>
           ) : (
                <form className={styles.form_container} onSubmit={this.handleContinue}>
                    <input type='text' id='name' placeholder='full name' onChange={this.handleChange}/>
                    <input type='email' id='email' placeholder='email' onChange={this.handleChange}/>
                    <input type='password' id='password' placeholder='password' onChange={this.handleChange}/>
                    <div className={styles.button_container}>
                        <button className={`btn ${styles.signup_button}`}>
                            Continue
                        </button>
                    </div>
                </form>
           )
            return currentForm;
        }

    render(){
        return(
            <div className={styles.main_container}>
                <div className='title-container'>
                    <h1 className='title'>Schedulsaur</h1>
                    <h5 className='title-description'>a friendly schedule finder</h5>
                </div>
                {this.getForm()}
               <footer className='footer'>
                    <h5><NavLink to='./About' className='white-text'>About</NavLink></h5>
                </footer>
            </div>
        )
    }
}

/**
 * mapStateToDispatch
 * 
 * @description maps dispatch to props to allow component to send an action
 * @param {*} dispatch 
 */
const mapDispatchToProps = (dispatch) => {
    return{
        createNew: (user) => { dispatch(createNew(user)) }
    }
}

export default connect(null, mapDispatchToProps)(Signup);