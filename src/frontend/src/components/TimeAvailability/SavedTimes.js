import React, { Component} from 'react';
import { connect } from 'react-redux';
import TimeNameEdit from './TimeNameEdit';
import TimeNameNormal from './TimeNameNormal';
import { editName, saveName, view, del } from '../../store/actions/timeActions';
import styles from './SavedTimes.module.css';

/**
 *------------------------------------------------------- 
 * Component to create the saved availability section
 *------------------------------------------------------- 
 */

class SavedTimes extends Component{
    state = {
        tempName: ''
    }

    /**
     * --- Called when user changes the name of a saved time preference
    */
    handleNameChange = (e) => {
        this.setState({
            tempName: e.target.value
        })
    }

    /**
     * --- Called when user clicks to edit the name of a saved time preference
    */
    handleNameEdit = (e) => {
        this.props.editName(e.target.id, e.target.getAttribute('index'))
    }

    /**
     * --- Called when user saves a new name
    */
    handleNameSave = (e) => {

    // *** need to prevent empty name here

        e.preventDefault()
        this.props.saveName(this.props.studentId, e.target.id, 
                            e.target.getAttribute('index'), this.state.tempName)
    }

    /**
     * --- Called when user deletes a saved time preference
    */
    handleDelete = (e) => {
        this.props.del(e.target.id, e.target.getAttribute('index'))
    }

    /**
     * --- Called when user clicks to view a saved time preference
    */
    handleView = (e) => {
        this.props.view(this.props.studentId, e.target.id, e.target.getAttribute('index'))
    }

    /**
     * normalOrEditBox
     * 
     * @desc Grabs component based on state of name (user is editting or not editting)
     * @param {boolean} isEdit whether user is editing a name
     * @param {array} time 'saved' array (in store)
     * @param {*} index index of name in saved availability section
    */
    normalOrEditBox = (isEdit, time, index) => {
        let box = 
            isEdit ? (
                <TimeNameEdit 
                    time={time} 
                    onView={this.handleView} 
                    onChange={this.handleNameChange}
                    onEdit={this.handleNameEdit} 
                    onSave={this.handleNameSave} 
                    onDelete={this.handleDelete} 
                    index={index} 
                />
            ) : (
                <TimeNameNormal 
                    time={time} 
                    onView={this.handleView} 
                    onEdit={this.handleNameEdit}
                    index={index} 
                />
            )
        return(box)
    }

    render(){
        const { storeSavedTimes } = this.props;

        // show names of saved preferences if user has any
        const savedList = 
            storeSavedTimes.length ? (
                storeSavedTimes.map((time, index) => {
                    return(
                        <li className={styles.time_li} key={index}>
                            {this.normalOrEditBox(time.isEdit, time, index)}
                        </li>
                    );
                })
            ) : (
            // if user has no saved preferences
                <div style={{marginTop: '5%'}} className='center'> 
                    You Have No Saved Time Preferences
                </div>
            )
        return(
            <ul className={styles.time_ul}>
                { savedList }
            </ul>
        );
    }
}

/**
 * mapStateToProps
 * 
 * @description maps state from store to props
 * @param {*} state 
 * @param {*} ownProps 
 */
const mapStateToProps = (state, ownProps) => {
    return{
        storeSavedTimes: state.time.saved,
        studentId: state.student.id
    }
}

/**
 * mapDispatchToProps
 * 
 * @description maps dispatch to props to allow component to send an action
 * @param {*} dispatch 
 */
const mapDispatchToProps = (dispatch) => {
    return{
        editName: (id, index) => { dispatch(editName(id, index)) },
        saveName: (studentId, id, index, name) => { dispatch(saveName(studentId, id, index, name)) },
        view: (studentId, id, index) => { dispatch(view(studentId, id, index)) },
        del: (id, index) => { dispatch(del(id, index)) }
    }
}

// 'connect' allows component to access the state from the store

export default connect(mapStateToProps, mapDispatchToProps)(SavedTimes);