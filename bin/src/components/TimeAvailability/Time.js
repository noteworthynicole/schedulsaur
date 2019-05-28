import React, { Component } from 'react';
import { connect } from 'react-redux';
import SavedTimes from './SavedTimes';
import TimeTable from './TimeTable';
import TimePopup from './TimePopup';
import { save, clear}  from '../../store/actions/timeActions';
import styles from './Time.module.css';

/**
 *------------------------------------------------------- 
 * Main Time Availability Component
 *------------------------------------------------------- 
 * 
 * Contians both the time selection table and 
 *  the saved availability section 
 * 
 *------------------------------------------------------- 
 */

class Time extends Component{
  state = {
    name: ''
  }

  /**
   * --- Called when user clicks the clear button
  */
  handleClear = () => {
    this.props.clear();
  }

  /**
   * --- Called when user inputs a new name in the popup
  */
  handleChange = (e) => {
    this.setState({
      name: e.target.value
    })
  }

  /**
   * handleSave
   * 
   * @desc Called when user clicks the save button
   * @param close method that closes popup
  */
  handleSave = (e, close) => {

    // *** need to prevent empty name here

    e.preventDefault();
    this.props.save(this.state.name);    
    close()
  }

  /**
   * getButton
   * 
   * @desc Shows or hides buttons depending on state of page
   * @param {boolean} isViewing is user viewing a time preference
   * @param {string} type the type of button needed
  */
  getButton = (isViewing, type) => {
      if(isViewing && type === 'create'){

        // show 'create' button if user is viewing a saved time preference, else hide it
        return(
          <button className='green_button' onClick={this.handleClear}>
            Create New
          </button>
        )
      }else if(type === 'left'){

          // show 'clear' button if user is not viewing a saved time preference
          return(
            <button className='white_button' onClick={this.handleClear}> Clear </button>
          )
      }else if(type === 'right'){

        // show 'save' button if user is not viewing a saved time preference
        return(
          <TimePopup 
            trigger={<button className='green_button'> Save </button>}
            onSave={this.handleSave}
            onChange={this.handleChange}
          />
        )
      }else{
        return(null)
      }
  }


  render(){
    const { storeIsViewing } = this.props;

    return(
      <div className={styles.main_container}>

        {/* // Saved Availability Section  */}

        <div className={styles.saved_container}>
          <div className={styles.saved_content}>
            <h2 align='center' className='subtitle'>Saved Availability</h2>
            <div className={styles.name_list}>
              <SavedTimes />
            </div>
          </div>
          <div align='center' style={{height: '3vw'}}>
            {this.getButton(storeIsViewing, 'create')}
          </div>
        </div>

        {/* // Time Selection Table Section */}

        <div className={styles.selection_container}>
          <div className={styles.selection_content}>
            <h2 align='center' className='subtitle'>Select When You Are Available</h2>
            <div align='center' style={{paddingTop: '1%'}} className='description'> 
              Click all the boxes that correspond to the hours and days that you do <br/> 
              not want to have class. Any white boxes will be considered free.
            </div>
            <div className={styles.table_container}>
              <TimeTable />
            </div>
          </div>
          <div className={styles.button_container}>
            {this.getButton(storeIsViewing, 'left')}
            {this.getButton(storeIsViewing, 'right')}
          </div>
        </div>
      </div>
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
  return {
    storeIsViewing: state.time.isViewing
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
    save: (name) => { dispatch(save(name)) },
    clear: () => { dispatch(clear()) }
  }
}

// 'connect' allows component to access the state from the store

export default connect(mapStateToProps, mapDispatchToProps)(Time);

