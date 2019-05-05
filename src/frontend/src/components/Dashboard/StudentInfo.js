import React, { Component } from 'react';

/**
 * StudentInfo
 * 
 * @description component that creates student information
 */

class StudentInfo extends Component{

    render(){
        const { id, info, edit, handleChange} = this.props;

        // show text field if editing
        const student_info = edit ? (
            <input id={id} value={info} onChange={handleChange}/>
        ) : (

        // show student information if not editing
            ' ' + info
        )

        return(
            <span style={{fontSize:'20px', fontWeight:'normal'}}>
                {student_info}
            </span>
        );
    }
}

export default StudentInfo;