import React from 'react';
import './Schedule.css'

/**
 *------------------------------------------------------- 
 * Component that creates the individual schedule header 
 *------------------------------------------------------- 
 * @param {array} descriptors 'descriptors' array (in store)
 */

const ScheduleHeader = ({descriptors}) => {
    const headers = descriptors.map(header => {
        return(
            <th className='sched_cell' key={header}>{header}</th>
        );
    })
    return(
        <tr className='sched_row'>
            {headers}
        </tr>
    )
}

export default ScheduleHeader;
