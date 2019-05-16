import React, { Component } from 'react';
import './Schedule.css'

/**
 *------------------------------------------------------- 
 * Component that creates the individual schedule body
 *------------------------------------------------------- 
 */

class ScheduleBody extends Component{

    /**
     * fillRow
     * 
     * @desc Fills the rows of the schedule table with the courses in that schedule
     * @param {array} course contains all the information for one course
    */
    fillRow = (course) => {
        let values = []
        Object.keys(course).forEach((element, index)=>{
            if(course.hasOwnProperty(element)){
                values.push(
                    <td key={index} className='sched_cell'>{ course[element] }</td>
                )     
            }
        })
        return(values)
    }

    render(){
        const { classes } = this.props;

        // creates the table
        const table = classes.map((course, index) => {
            return(
                <tr key={index}>
                    {this.fillRow(course)}
                </tr>
            )
        })
        return(
            <tbody>
                {table}
            </tbody>
        );
    }
}

export default ScheduleBody;