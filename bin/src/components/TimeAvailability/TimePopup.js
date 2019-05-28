import React from 'react';
import Popup from 'reactjs-popup';
import styles from './TimePopup.module.css';

/**
 *------------------------------------------------------- 
 * Component to create a popup 
 *------------------------------------------------------- 
 * @param trigger button that triggeres popup
 * @param onSave method to handle save
 * @param onChange method to change text as user types
 */

const TimePopup = ({trigger, onSave, onChange}) => {
    return(
        <Popup trigger={trigger} 
                modal contentStyle={{maxWidth:'500px', width:'90%'}} closeOnDocumentClick={false}>
            {close => (
                <div>
                    <h5 align='left'>Title</h5>
                    <form onSubmit={(e) => {onSave(e, close)}}>
                        <input type='text' placeholder='New Name' autoFocus={true} onChange={onChange}/>
                        <button align='right' className={styles.button_popup}>ok</button>
                    </form>
                </div>
            )}
        </Popup>
    )
}

export default TimePopup;