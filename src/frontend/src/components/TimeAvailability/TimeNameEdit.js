import React from 'react';
import './TimeName.css'

/**
 * TimeNameEdit
 * 
 * @description Component to create the editted version of the names in the saved times section
 * @param {*} param0 
 */

const TimeNameEdit = ({time, onView, onChange, onEdit, onSave, onDelete, index}) => {
    return(
        <div>
            <form id={time.id} index={index} onSubmit={onSave}>
                <div>
                    <input type='text' id={time.id} index={index} placeholder={time.name} onChange={onChange}/>
                </div>
            </form>
            <div>
                <button style={{marginRight:'1%'}} className='button_collection_edit' id={time.id} index={index} onClick={onEdit}>
                    Cancel
                </button>
                <button style={{marginRight:'1%'}} className='button_collection_edit' id={time.id} index={index} onClick={onSave}>
                    Save
                </button>
                <button style={{marginRight:'1%'}} className='button_collection_edit' id={time.id} index={index} onClick={onDelete}>
                    Delete
                </button>
                <button style={{float:'right'}} className='button_collection' id={time.id} index={index} onClick={onView}>
                    {time.text}
                </button>
            </div>
        </div>
    )
}

export default TimeNameEdit;