import React, { Component } from 'react';
import styles from './Dashboard.module.css';

/**
 *------------------------------------------------------- 
 * component that creates the student information
 *------------------------------------------------------- 
 */

class StudentInfo extends Component{

    render(){
        const { id, info, edit, handleChange } = this.props;

        // show text field if editing
        const student_info = edit ? (
            <input style={{margin:'0'}} type='text' id={id} placeholder={info} onChange={handleChange}/>) : (

        // show student information if not editing
            ' ' + info
        )

        return(
            <span className={styles.text}>
                {student_info}
            </span>
        );
    }
}

export default StudentInfo;