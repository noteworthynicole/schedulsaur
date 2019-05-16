import React from 'react';
import './TimeName.css'

/**
 *------------------------------------------------------- 
 * Component to create the edited version of time names
 *------------------------------------------------------- 
 * 
 * The edited version displays the name and the cancel, 
 *  save, delete, and view buttons in the saved 
 *  availability section
 * 
 *------------------------------------------------------- 
 * @param {array} time 'saved' array (in store)
 * @param onView method to change state when viewing 
 * @param onChange method to change state when changing name
 * @param onEdit method to change state when editting name
 * @param onSave method to change state when saving name
 * @param onDelete method to change state when deleting name
 * @param {*} index index of name in saved availability section
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