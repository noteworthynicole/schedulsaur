import React, { Component } from 'react';
import ScheduleHeader from './ScheduleHeader';
import ScheduleBody from './ScheduleBody';
import './Schedule.css'

/**
 *------------------------------------------------------- 
 * Main component that creates an individual schedule
 *------------------------------------------------------- 
 */

class Schedule extends Component{
    render(){
        const { descriptors, schedule } = this.props;
        return(
            <table className='sched_table'>
                <thead className='sched_header'>
                    <ScheduleHeader descriptors={descriptors} />
                </thead>
                <ScheduleBody classes={schedule.classes}/>
            </table>
        );
    }    
}

export default Schedule;