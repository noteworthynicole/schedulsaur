import React from 'react';
import styles from './TimeName.module.css';

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
        <div className={styles.slot_container}>
            <h6 className={styles.time_name} id={time.id} index={index} onDoubleClick={onEdit}>
                { time.name }
            </h6>
            <button className='list-button-green' id={time.id} index={index} onClick={onView}>
                {time.text}
            </button>
        </div>
    )
}

export default TimeNameNormal;