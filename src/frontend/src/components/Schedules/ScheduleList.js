import React, { Component } from 'react';
import { connect } from 'react-redux';
import Schedule from './Schedule';
import ScheduleExpand from './ScheduleExpand';
import { view, select, deselect } from '../../store/actions/scheduleActions';
import './ScheduleList.css'

class ScheduleList extends Component{

    handleView = (e) => {
        this.props.view(e.target.id, e.target.getAttribute('index'))
    }

    handleSelect = (e) => {
        if(e.target.checked){
            this.props.select(e.target.id, e.target.getAttribute('index'))
        }else{
            this.props.deselect(e.target.id, e.target.getAttribute('index'))
        }
    }

    expandSchedule = (schedule, viewing, index) => {
        if(viewing[index].text === 'View'){
            return(null)
        }else{
            return(<ScheduleExpand schedule={schedule} />)
        }
    }

    showCheckBox = (addCheckBoxes, schedule_id, index) => {
        return(
            addCheckBoxes ? (
                <div style={{float:'right', marginLeft:'3%', display:'inline'}}>
                    <label>
                        <input type='checkbox' className='box-green' id={schedule_id} index={index} onClick={this.handleSelect}/>
                        <span className='sched_check'></span>
                    </label>
                </div>
            ) : (null)
        )
    }

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
                </li>
            );
        })
        return(list);
    }

    render(){
        const { storeDescriptors, schedules, storeViewing, addCheckBoxes, emptyText } = this.props;

        const schedulesList = 
            schedules.length ? (
                <ul className='ul'>
                   {this.listSchedules(storeDescriptors, schedules, storeViewing, addCheckBoxes)}
                    <div style={{marginBottom:'2%'}}></div>
                </ul>
            ) : (
                <h6 align='center'>{ emptyText }</h6>
            )

        return(
            <div>
                { schedulesList }
            </div>
        )
    }
}

const mapStateToProps = (state, ownProps) => {
    return{
        storeDescriptors: state.schedule.descriptors,
        storeViewing: state.schedule.viewing,
    }
}

const mapDispatchToProps = (dispatch) => {
    return{
        view: (id, index) => { dispatch(view(id, index)) },
        select: (id, index) => { dispatch(select(id, index)) },
        deselect: (id, index) => { dispatch(deselect(id, index)) }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(ScheduleList);