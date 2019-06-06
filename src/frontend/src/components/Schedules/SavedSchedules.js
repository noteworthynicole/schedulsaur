import React, { Component } from 'react';
import { connect } from 'react-redux';
import { view } from '../../store/actions/scheduleActions';
import ScheduleList from './ScheduleList';
import SortFilter from './SortFilter';
import  styles from './MainSched.module.css';

/**
 *------------------------------------------------------- 
 * Main Saved Schedules Component
 *------------------------------------------------------- 
 * 
 * Contains both the list of saved schedules and 
 *  the sorter/filter section
 * 
 *------------------------------------------------------- 
 */

class SavedSchedules extends Component{

    render(){
        const { storeSavedSchedules, storeSorters, storeFilters } = this.props;
        return(
            <div className={styles.main_container}>

                    {/* // Schedule Section */}

                <div className={styles.list_container}>
                    <h2 className='subtitle' align='center'>Saved Schedules</h2>
                    <ScheduleList  
                        needsToLoad={false}
                        schedules={storeSavedSchedules} 
                        addCheckBoxes={false}
                        emptyText={'No Saved Schedules'}     
                    />
                </div>

                    {/* // Sort & Filter Section */}

                <div className={styles.filter_container}>
                    <SortFilter sorters={storeSorters} filters={storeFilters}/>
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
 * @param {*} onwProps 
 */

const mapStateToProps = (state, onwProps) => {
    return {
        storeSavedSchedules: state.schedule.savedSchedules,
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
        view: (id, index) => { dispatch(view(id, index)) }
    }
}

// 'connect' allows comopnent to access the state from the store

export default connect(mapStateToProps, mapDispatchToProps)(SavedSchedules);