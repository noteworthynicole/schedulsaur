import React, { Component } from 'react';
import TopBar from './TopBar';
import NavBar from './NavBar';
import { connect } from 'react-redux';
import ProgressWheel from './ProgressWheel';

class DashBoard extends Component{

    handleEdit = () => {
        //handle click
        // and redirect
    }


    handleSave = () => {
        //handle click
        // and redirect
    }

    render(){
        const { student } = this.props;
        return(
            <div>
                <TopBar />
                <NavBar />
                <h2 align='center'>Dashboard</h2>
                <ProgressWheel progress={student.major_percent} size='250'/>
                <p align='center'>Degree Progress</p>
                <ProgressWheel progress={student.support_percent} size='150'/>
                <p align='center'>Degree Progress</p>
                <ProgressWheel progress={student.ge_percent} size='150'/>
                <p align='center'>Degree Progress</p>
                <p className='column'>
                    <b>Name: {student.name}</b>
                    <b>Major: {student.major}</b>
                    <b>Catalog Year: {student.catalog_year}</b>
                    <b>Expected Graduation: {student.expected_grad}</b>
                    <b>Units This Quarter: {student.units_this_quarter}</b>
                    <b>Units Per Quarter: {student.units_per_quarter}</b>
                </p>

                {/* need to handle when cases when not editing and when user is editing */}
                {/* need to handle when cases when not editing and when user is editing */}
                {/* need to handle when cases when not editing and when user is editing */}
                {/* need to store edited in material in local state and then send action to modify global state*/}
                <button className='button' id='button_left' onClick={this.handleEdit}>
                    Edit Profile
                </button>
                <button className='button' id='button_right' onClick={this.handleSave}>
                    Save
                </button>
            </div>
        );
    }
}

const mapStateToProps = (state, ownProps) => {
    return {
        student: state.student
    }
}

export default connect(mapStateToProps)(DashBoard);