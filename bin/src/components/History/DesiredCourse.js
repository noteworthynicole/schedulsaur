import React, { Component } from 'react';
import Curriculum from '../CourseHistory/Curriculum';
import Flowchart from '../Flowchart/Flowchart';
import styles from './History.module.css';

/**
 *------------------------------------------------------- 
 * Main Desired Curriculum Component
 *------------------------------------------------------- 
 * 
 * Contains both the curriculum view and flowchart 
 *  for classes a student wants to take
 * 
 *------------------------------------------------------- 
 */

class DesiredCourse extends Component {
    state = {
        viewCurriculum: true,
    }

    /*
     * --- Generate either the curriculum or the flowchart
     */
    getView = () => {
        let view = 
            this.state.viewCurriculum ? (
                <div className={styles.main_container}>
                    <Curriculum type={'Desired'}/>
                </div>
            ) : (
                <div className={styles.main_container}>
                    <h2 className='subtitle' align='center'>Desired Classes</h2>
                    <Flowchart />
                </div>
            )
        return (view)
    }

    /*
     * --- Change the button depending on page
     */
    getButtonText = () => {
        let text =
            this.state.viewCurriculum ? ('Flowchart') : ('Curriculum')
        return text;
    }

    /*
     * --- Switch to either the curriculum or the flowchart
     */
    handleSwitch = () => {
        this.setState({
           viewCurriculum: !this.state.viewCurriculum
        })
    }

    render(){
        return(
            <div>
                {this.getView()}
                <div className={styles.button_container}>
                    <button className='green_button' onClick={this.handleSwitch}>
                        {this.getButtonText()} 
                    </button>
                </div>
            </div>
        )
    }

}

export default DesiredCourse;