import React, { Component } from 'react';
import { connect } from 'react-redux';
import TableHeader from './TableHeader';
import TableBody from './TableBody';
import { changeAvailable } from '../../store/actions/timeActions';
import './TimeTable.css';

/**
 * TimeTable
 * 
 * @description Component to create the time selection table
 */

class TimeTable extends Component{
    /**
     * handleSelect
     * 
     * @method
     * @description Called when user clicks on a time cell
     */
    handleSelect = (e) => {
        const row_id = e.target.getAttribute('row_id')
        const col_id = e.target.getAttribute('col_id')
        this.props.changeAvailable(row_id, col_id);
    }

    render(){
        const { storeTimeTable } = this.props;
        return(
            <table className='tb' align='center'>
                <thead>
                    <TableHeader />
                </thead>
                <TableBody 
                    table={storeTimeTable} 
                    handleSelect={this.handleSelect}/>
            </table>
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
        storeTimeTable: state.time.table,
    }
}


/**
 * @description maps dispatch to props to allow component to send an action
 * @param {*} dispatch 
 */
const mapDispatchToProps = (dispatch) => {
    return{
        changeAvailable: (isViewing, row_id, col_id) => { 
            dispatch(changeAvailable(isViewing, row_id, col_id)) }        
    }
}

// 'connect' allows component to access the state from the store

export default connect(mapStateToProps, mapDispatchToProps)(TimeTable);