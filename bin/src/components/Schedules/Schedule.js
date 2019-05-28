import React, { Component } from 'react';
import ScheduleHeader from './ScheduleHeader';
import ScheduleBody from './ScheduleBody';
import styles from './Schedule.module.css'

/**
 *------------------------------------------------------- 
 * Main component that creates an individual schedule
 *------------------------------------------------------- 
 */

class Schedule extends Component{
    render(){
        const { descriptors, schedule } = this.props;
        return(
            <table className={styles.sched_table}>
                <thead className={styles.sched_header}>
                    <ScheduleHeader descriptors={descriptors} />
                </thead>
                <ScheduleBody classes={schedule.classes}/>
            </table>
        );
    }    
}

export default Schedule;