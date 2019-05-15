import React, { Component } from 'react';
import { connect } from 'react-redux';
import ScheduleList from './ScheduleList';
import SortFilter from './SortFilter';
import { save } from '../../store/actions/scheduleActions';

/**
 * Potential Schedules
 * 
 * @description Main component to create the Potential Schedules page
 */

class PotentialSchedules extends Component{

    /**
     * handleSave
     * 
     * @method
     * @description Called when user saves a schedule
     */
    handleSave = () => {
        this.props.save()
        this.props.history.push('/SavedSchedules')    
    }

    render(){
        const { storeSchedules, storeSorters, storeFilters } = this.props;
        return(
         <div>
            <div className='row'>
                <div className='col s8'>
                    <h2 className='subtitle' align='center'>Potential Schedules</h2>
                    <ScheduleList  
                        schedules={storeSchedules} 
                        addCheckBoxes={true} 
                        emptyText={'No Schedules Meet Your Criteria'} 
                    />
                </div>
                <div className='col s4'>
                    <SortFilter sorters={storeSorters} filters={storeFilters} />
                    <div style={{marginTop:'10%'}} className='row' align='center'>
                        <button className='green_button' onClick={this.handleSave}>Save Shedule(s)</button>
                    </div>
                </div>
            </div>
        </div>
        )
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
        storeSchedules: state.schedule.schedules,
        storeSorters: state.schedule.sorters,
        storeFilters: state.schedule.filters
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
        save: () => { dispatch(save()) }
    }
}

// 'connect' allows component to access the state from the store

export default connect(mapStateToProps, mapDispatchToProps)(PotentialSchedules);