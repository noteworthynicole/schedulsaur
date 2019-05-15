import React from 'react';

/**
 * TableHeader
 * 
 * @description Component to create the time selection table header
 */

const TableHeader = () => {
    const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 
                  'Thursday', 'Friday', 'Saturday'].map(day => {
        return(
            <th key={day}> {day} </th>
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