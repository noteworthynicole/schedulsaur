import React, { Component } from 'react';
import { connect } from 'react-redux';
import Schedule from './Schedule';
import ScheduleExpand from './ScheduleExpand';
import { view, select, deselect } from '../../store/actions/scheduleActions';
import './ScheduleList.css'

/**
 *------------------------------------------------------- 
 * Component to create the list of schedules
 *------------------------------------------------------- 
 */

class ScheduleList extends Component{

    /**
     * --- Called when user views a schedule
    */
    handleView = (e) => {
        this.props.view(e.target.id, e.target.getAttribute('index'))
    }

    /**
     * --- Called when user selects a schedule
    */
    handleSelect = (e) => {
        if(e.target.checked){
            this.props.select(e.target.id, e.target.getAttribute('index'))
        }else{
            this.props.deselect(e.target.id, e.target.getAttribute('index'))
        }
    }

    /**
     * expandSchedule
     * 
     * @desc Expand schedule if user clicks on view
     * @param schedule the schedule that was selected
     * @param {string} viewing 'viewing' array (in store)
     * @param {*} index index of schedule in 'viewing' array (in store)
    */
    expandSchedule = (schedule, viewing, index) => {
        if(viewing[index].text === 'View'){
            return(null)
        }else{
            return(<ScheduleExpand schedule={schedule} />)
        }
    }

    /**
     * showCheckBox
     * 
     * @desc Show checkbox if selecting potential schedules, 
     *          not when viewing saved schedules
     * @param {boolean} addCheckBoxes add checkbox in potential schedules page only
     * @param {*} sched_id id of schedule
     * @param {*} index index of schedule in 'schedules' array (in store)
    */
    showCheckBox = (addCheckBoxes, schedule_id, index) => {
        return(
            addCheckBoxes ? (
                <div style={{float:'right', marginLeft:'10px', display:'inline'}}>
                    <label>
                        <input type='checkbox' className='box-green' id={schedule_id} index={index} onClick={this.handleSelect}/>
                        <span className='sched_check'></span>
                    </label>
                </div>
            ) : (null)
        )
    }

    /**
     * listSchedules
     * 
     * @desc Lists all the shedules in the store
     * @param {array} descriptors 'descriptors' array (in store)
     * @param {array} schedules 'schedules' array (in store)
     * @param {array} viewing 'viewing' array (in store)
     * @param {boolean} addCheckboxes add checkbox in potential schedules page only
     * 
    */
    listSchedules = (descriptors, schedules, viewing, addCheckBoxes) => {
        const list = 
        schedules.map((schedule, index) => {
            return(
                <li className='li subsubtitles' key={index}>
                    <div className='sched_entry'>
                        <span className='sched_name'>
                            { schedule.name }
                        </span>
                        <button className='button_collection' id={schedule.id} index={index} onClick={this.handleView}>
                            { viewing[index].text }
                        </button>
                        { this.showCheckBox(addCheckBoxes, schedule.id, index) }
                    </div>
                    <Schedule descriptors={descriptors} schedule={schedule}/> 
                    { this.expandSchedule(schedule, viewing, index) }
                    <div></div>
                </li>
            );
        })
        return(list);
    }

    render(){
        const { storeDescriptors, schedules, storeViewing, addCheckBoxes, emptyText } = this.props;

        const schedulesList = 
            schedules.length ? (

                // Show schedules if there are any
                <ul className='ul scrollable'>
                   {this.listSchedules(storeDescriptors, schedules, storeViewing, addCheckBoxes)}
                    <div style={{marginBottom:'2%'}}></div>
                </ul>
            ) : (

                // Show text if there are no schedules
                <h6 align='center'>{ emptyText }</h6>
            )

        return(
            <div>
                { schedulesList }
                <div></div>
            </div>
        )
    }
}


/**
 * mapStateToProps
 * 
 * @description mpas state from store to props
 * @param {*} state 
 * @param {*} ownProps 
 */
const mapStateToProps = (state, ownProps) => {
    return{
        storeDescriptors: state.schedule.descriptors,
        storeViewing: state.schedule.viewing,
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
        view: (id, index) => { dispatch(view(id, index)) },
        select: (id, index) => { dispatch(select(id, index)) },
        deselect: (id, index) => { dispatch(deselect(id, index)) }
    }
}

// 'connect' allows component to access the state from the store

export default connect(mapStateToProps, mapDispatchToProps)(ScheduleList);