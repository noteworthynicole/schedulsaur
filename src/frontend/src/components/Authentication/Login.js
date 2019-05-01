import React, { Component } from 'react';

class Login extends Component {
    state = {
        email: '',
        password: ''
    }

    handleSubmit = (e) => {
        e.preventDefault()
    }

    hangleChange = (e) => {
        this.setState({
           [e.target.id]: e.target.value
        })
    }

    render(){
        return(
            <div className='center-align'>
                <h1 className='title' >Schedulsaur</h1>
                <h5>a friendly schedule finder</h5>
                <form onSubmit={this.handleSubmit} >
                    <div className='container'>
                        <input type='email' id='email' placeholder='email' onChange={this.handleChange}/>
                        <input type='password' id='password' placeholder='password' onChange={this.handleChange}/>
                    </div>

                    {/* Will authenticate using Database */}
                    {/* Will authenticate using Database */}
                    {/* Will authenticate using Database */}
                    <button className='btn black-text' id='button_left'>
                        Sign Up
                    </button>
                    <button className='btn' id='button_right'>
                        Log In
                    </button>
                </form>
                <footer className='footer'>

                    {/* redirect to About Page */}
                    {/* redirect to About Page */}
                    {/* redirect to About Page */}
                    <h5 className='white-text'>About</h5>
                </footer>
            </div>
        )
    }
}

export default Login;