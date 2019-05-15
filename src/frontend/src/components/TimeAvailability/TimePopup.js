import React from 'react';
import Popup from 'reactjs-popup';
import './TimePopup.css';

/**
 * TimePopup
 * 
 * @description Component to create the popup when saving a time preference
 * @param {*} param0 
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
                        <button align='right' className='button_popup'>ok</button>
                    </form>
                </div>
            )}
        </Popup>
    )
}

export default TimePopup;