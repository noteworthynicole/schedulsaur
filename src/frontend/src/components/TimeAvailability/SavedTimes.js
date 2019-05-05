import React, { Component} from 'react';

/**
 * SavedTimes
 * 
 * @description Component to create the saved availability section
 */

class SavedTimes extends Component{

    render(){
        const { onClick, saved } = this.props;

        // show names of saved preferences if user has any
        const savedList = saved.length ? (
            saved.map(time => {
                return(
                    <li className='li' id='subtitle' key={time.id}>
                        { time.name }
                        <span style={{float:'right'}}>
                        <button className='button_collection' id={time.id}  onClick={onClick}>
                            {saved[time.id-1].text}
                        </button>
                        </span>
                    </li>
                );
            })
        ) : (
        // if user has no saved preferences
            <div className='center'> You Have No Saved Time Preferences</div>
        )

        return(
            <ul className='ul'>
                { savedList }
            </ul>
        );
    }
}

export default SavedTimes;