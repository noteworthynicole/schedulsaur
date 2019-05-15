import React, { Component } from 'react';
import { connect } from 'react-redux';
import SavedTimes from './SavedTimes';
import TimeTable from './TimeTable';
import { changeAvailable, view, clear}  from '../../actions/timeActions';

/**
 * Time
 * 
 * @description Main component to create the Time Availability page
 */

class Time extends Component{

  state = {

    buttons: this.props.time.saved.map(time => {
      return({text: 'View'})
    }),

    isViewing: false,

    table: [
        {id:'1', name:'', time:'07-08 AM', available: [false, false, false, false, false, false, false]},
        {id:'2', name:'', time:'08-09 AM', available: [false, false, false, false, false, false, false]},
        {id:'3', name:'', time:'09-10 AM', available: [false, false, false, false, false, false, false]},
        {id:'4', name:'', time:'10-11 AM', available: [false, false, false, false, false, false, false]},
        {id:'5', name:'', time:'11-12 AM', available: [false, false, false, false, false, false, false]},
        {id:'6', name:'', time:'12-01 PM', available: [false, false, false, false, false, false, false]},
        {id:'7', name:'', time:'01-02 PM', available: [false, false, false, false, false, false, false]},
        {id:'8', name:'', time:'02-03 PM', available: [false, false, false, false, false, false, false]},
        {id:'9', name:'', time:'03-04 PM', available: [false, false, false, false, false, false, false]},
        {id:'10', name:'', time:'04-05 PM', available: [false, false, false, false, false, false, false]},
        {id:'11', name:'', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
        {id:'12', name:'', time:'05-06 PM', available: [false, false, false, false, false, false, false]},
        {id:'13', name:'', time:'06-07 PM', available: [false, false, false, false, false, false, false]},
        {id:'14', name:'', time:'07-08 PM', available: [false, false, false, false, false, false, false]},
        {id:'15', name:'', time:'08-09 PM', available: [false, false, false, false, false, false, false]}
    ]
    
  }

  handleSelect = (e) => {
    const row_id = e.target.getAttribute('row_id')-1
    const col_id = e.target.getAttribute('col_id')-1
    this.props.changeAvailable(row_id, col_id);
  }

  /**
   * handleClick
   * 
   * @method
   * @description called when user clicks on view button
   */
  handleClick = (e) => {

      this.props.view(e.target.id-1)

  }

  /**
   * handleClear
   * 
   * @method
   * @description called when user clicks the clear button
   */
  handleClear = () => {
    this.props.clear();
  }

  /**
   * handleSave
   * 
   * @method
   * @description called when user clicks the save button
   */
  handleSave = () => {

    // *** need to send action to modify global state
    // *** need to send action to modify gloabl state

  }

  render(){
    const { time } = this.props;
    return(
      <div>
        <div className='row'>

          {/* // Saved Availability Section  */}

          <div className='col s4'>
            <h2 align='center' className='subtitle'>Saved Availability</h2>
            <SavedTimes onClick={this.handleClick} saved={time.saved}/>
            <div align='center'>
              <button style={{margin:'10%'}} className='button' id='button_right' onClick={this.handleClear}>
                Create New
              </button>
            </div>
          </div>

          {/* // Time Selection Table Section */}

          <div className='col s6 offset-s1'>
            <h2 align='center' className='subtitle'>Select When You Are Available</h2>
            <h6 align='center'> 
              Click all the boxes that correspond to the hours and days <br />
              that you do not want to have class. Any white boxes will be considered free.
            </h6>
            <div className='row'></div>
            <TimeTable table={time.table} isViewing={this.state.isViewing} handleSelect={this.handleSelect}/>
            <div align='right'>
              <button className='button' id='button_left' onClick={this.handleClear}>
                Clear
              </button>
              <button className='button' id='button_right' onClick={this.handleSave}>
                Save
              </button>
            </div>
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
    time: state.time
  }
}

const mapDispatchToProps = (dispatch) => {
  return{
    changeAvailable: (isViewing, row_id, col_id) => { dispatch(changeAvailable(isViewing, row_id, col_id)) },
    view: (id) => { dispatch(view(id)) },
    clear: () => { dispatch(clear()) }
  }
}

// 'connect' allows component to access the state from the store

export default connect(mapStateToProps, mapDispatchToProps)(Time);