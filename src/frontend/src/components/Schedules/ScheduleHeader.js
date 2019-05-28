import React from 'react';
import styles from './Schedule.module.css';

/**
 *------------------------------------------------------- 
 * Component that creates the individual schedule header 
 *------------------------------------------------------- 
 * @param {array} descriptors 'descriptors' array (in store)
 */

const ScheduleHeader = ({descriptors}) => {
    const headers = descriptors.map(header => {
        return(
            <th className={styles.sched_cell} key={header}>{header}</th>
        );
    })
    return(
        <tr className={styles.sched_row}>
            {headers}
        </tr>
    )
}

export default ScheduleHeader;
