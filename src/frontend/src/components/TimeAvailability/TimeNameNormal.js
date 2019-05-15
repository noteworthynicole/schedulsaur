import React from 'react';
import './TimeName.css'

/**
 * TimeNameNormal
 * 
 * @description Component to create the default version of the names in the saved times section
 * @param {*} param0 
 */

const TimeNameNormal = ({time, onView, onEdit, index}) => {
    return(
        <div className='slot'>
            <span className='time_name' id={time.id} index={index} onDoubleClick={onEdit}>
                { time.name }
            </span>
            <button className='button_collection' id={time.id} index={index} onClick={onView}>
                {time.text}
            </button>
        </div>
    )
}

export default TimeNameNormal;