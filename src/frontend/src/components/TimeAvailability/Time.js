import React, { Component } from 'react';
import { connect } from 'react-redux';
import SavedTimes from './SavedTimes';
import TimeTable from './TimeTable';
import TimePopup from './TimePopup';
import { save, clear}  from '../../store/actions/timeActions';

/**
 * Time
 * 
 * @description Main component to create the Time Availability page
 */

class Time extends Component{
  state = {
    name: ''
  }

  /**
   * handleClear
   * 
   * @method
   * @description Called when user clicks the clear button
   */
  handleClear = () => {
    this.props.clear();
  }

  /**
   * handleSave
   * 
   * @method
   * @description Called when user clicks the save button
   */
  handleSave = (e, close) => {

    // *** need to prevent empty name here

    e.preventDefault();
    this.props.save(this.state.name);    
    close()
  }

  handleChange = (e) => {
    this.setState({
      name: e.target.value
    })
  }

  /**
   * button
   * 
   * @description  Shows or hides buttons depending on state of page
   * @param {*} left 
   */
  getButton = (isViewing, type) => {
      if(isViewing && type === 'create'){

        // show 'create' button if user is viewing a saved time preference, else hide it
        return(
          <button style={{margin:'10%'}} className='green_button' onClick={this.handleClear}>
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
      <div>
        <div className='row'>

          {/* // Saved Availability Section  */}

          <div className='col s4'>
            <div style={{marginLeft:'10%'}}>
              <h2 align='center' className='subtitle'>Saved Availability</h2>
              <SavedTimes />
              <div align='center'>
                {this.getButton(storeIsViewing, 'create')}
              </div>
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
            <TimeTable />
         </div>
          <div className='row'>
            <div className='col s4 offset-s8' style={{marginTop:'1%'}}>
              {this.getButton(storeIsViewing, 'left')}
              {this.getButton(storeIsViewing, 'right')}
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
    storeIsViewing: state.time.isViewing
  }
}

/**
 * mapDispatchToProps
 * 
 * @description map dispatch to props to allow component to send an action
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