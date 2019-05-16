import React from 'react';
import './About.css';

const About = (props) => {
    return(
        <div>
            <div style={{marginLeft:'20%'}}>
                <h1 className='title'>Schedulsaur</h1>
                <h5 className='subtext'>a friendly schedule finder</h5>
            </div>
            <div className='container'>
                <h6 className='about'>
                    schedulsaur is a scheduling app designed by <br/>
                    cal poly students for cal poly students <br/>
                </h6>
                <h6 className='about'>
                    update you time availability, generate schedules <br/>
                    view degree progress and more <br/>
                </h6>
                <h6 className='about'>
                    happy scheduling {'<3'} <br/>
                    --team bulbasaur <br/>
                </h6>
            </div>
            <div className='container'>
                <button className='green_button back_button' onClick={props.history.goBack}>Back</button>
            </div>
            <h6 style={{position:'absolute', right:'2%', bottom:'10%'}}>version 0.1.0</h6>
            <footer className='footer'></footer>
        </div>
    );
}

export default About;