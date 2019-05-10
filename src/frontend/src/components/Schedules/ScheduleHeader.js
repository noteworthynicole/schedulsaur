import React from 'react';
import './Schedule.css'

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
