import React, { Component } from 'react';
import { connect } from 'react-redux';
import { view } from '../../store/actions/scheduleActions';
import ScheduleList from './ScheduleList';
import SortFilter from './SortFilter';

/**
 * SavedSchedules
 * 
 * @description Main component to create the Saved Schedules page
 */

class SavedSchedules extends Component{

    render(){
        const { storeSavedSchedules, storeSorters, storeFilters } = this.props;
        return(
         <div>
            <div className='row'>
                <div className='col s8'>
                    <h2 className='subtitle' align='center'>Saved Schedules</h2>
                    <ScheduleList  
                        schedules={storeSavedSchedules} 
                        addCheckBoxes={false}
                        emptyText={'No Saved Schedules'}     
                    />
                </div>
                <div className='col s4'>
                    <SortFilter sorters={storeSorters} filters={storeFilters}/>
                </div>
            </div>
        </div>
        )
    }
}

const mapStateToProps = (state, onwProps) => {
    return {
        storeSavedSchedules: state.schedule.savedSchedules,
        storeSorters: state.schedule.sorters,
        storeFilters: state.schedule.filters
    }
}

const mapStateToDispatch = (dispatch) => {
    return{
        view: (id, index) => { dispatch(view(id, index)) },
    }
}

export default connect(mapStateToProps, mapStateToDispatch)(SavedSchedules);