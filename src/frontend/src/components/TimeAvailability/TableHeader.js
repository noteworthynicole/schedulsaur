import React from 'react';
import styles from './TimeTable.module.css';

/**
 *------------------------------------------------------- 
 * Component to create the time selection table header
 *------------------------------------------------------- 
 */

const TableHeader = () => {
    const days = ['Sun.', 'Mon.', 'Tues.', 'Wed.', 
                  'Thurs.', 'Fri.', 'Sat.'].map(day => {
        return(
            <th key={day}> 
                <div className={styles.day_name}>{day}</div> 
            </th>
        );
    })
    return(
        <tr className={styles.table_tr}>
            <th></th>
            {days}
        </tr>
    );
}

export default TableHeader;