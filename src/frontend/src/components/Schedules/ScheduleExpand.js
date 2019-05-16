import React, { Component } from 'react';
import tempMap from '../../TempMap.png'
import TableHeader from '../TimeAvailability/TableHeader';
import TableBody from '../TimeAvailability/TableBody';
import './ScheduleExpand.css'

/**
 *------------------------------------------------------- 
 * Component that creates the expanded portion of the 
 *  schedule, which contains the map and time table view
 *------------------------------------------------------- 
 */

class ScheduleExpand extends Component{
    render(){
        const { schedule } = this.props;
        return(
            <div className='layout'>
                <span className='image'>
                    <img src={tempMap} alt='Campus Map' width='100%'/>
                </span>
                <table className='tb smallTable' align='center'>
                    <thead>
                        <TableHeader  />
                    </thead>
                    <TableBody table={schedule.times} />
                </table>
            </div>
        )
    }
}

export default ScheduleExpand;