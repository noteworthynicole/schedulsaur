import React from 'react';
import './TimeName.css'

/**
 *------------------------------------------------------- 
 * Component to create the default version of time names
 *------------------------------------------------------- 
 * 
 * The default version only displays the name and 
 *  view button in the saved availability section
 * 
 *------------------------------------------------------- 
 * @param {array} time 'saved' array (in store)
 * @param onView method to change state when viewing 
 * @param onEdit method to change state when editting name
 * @param {*} index index of name in saved availability section
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