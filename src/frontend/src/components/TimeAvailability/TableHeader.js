import React from 'react';
import './TableHeader.css';

/**
 * TableHeader
 * 
 * @description Component to create the time selection table header
 */

const TableHeader = () => {
    const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 
                  'Thursday', 'Friday', 'Saturday'].map(day => {
        return(
            <th key={day} className='day_name'> {day} </th>
        );
    })
    return(
        <tr className='table_tr'>
            <th></th>
            {days}
        </tr>
    );
}

export default TableHeader;