import React, { Component } from 'react';
import { connect } from 'react-redux';
import ProgressWheel from './ProgressWheel';
import StudentInfo from './StudentInfo';
import { save } from '../../store/actions/studentActions'
import './Dashboard.css'

/**
 *------------------------------------------------------- 
 * Main Dashboard Component
 *------------------------------------------------------- 
 */

class DashBoard extends Component{

    state = {
        isEdit: false,
        tempM: this.props.student.major,
        tempC: this.props.student.catalog_year,
        tempE: this.props.student.expected_grad,
        tempUT: this.props.student.units_this_quarter,
        tempUP: this.props.student.units_per_quarter,
        editButton: 'Edit Profile'
    }

    /**
     * --- Called when input text is changing in StudentInfo component 
    */

    handleChange = (e) => {
        this.setState({
            [e.target.id]: e.target.value
        })
    }

    /**
     * --- Called when edit profile button is clicked
    */
    handleEdit = () => {
        if(this.state.isEdit===false){
            this.setState({
                isEdit: !this.state.isEdit,
                editButton: 'Cancel'
            })
        }else{

            // discard any changes
            this.setState({
                isEdit: !this.state.isEdit,
                tempM: this.props.student.major,
                tempC: this.props.student.catalog_year,
                tempE: this.props.student.expected_grad,
                tempUT: this.props.student.units_this_quarter,
                tempUP: this.props.student.units_per_quarter,
                editButton: 'Edit Profile'
            })
        }
    }

    /**
     * --- Called when save button is clicked
    */
    handleSave = () => {
        if(this.state.isEdit===true){
            this.props.save(
                this.state.tempM,
                this.state.tempC,
                this.state.tempE,
                this.state.tempUT,
                this.state.tempUT
            )
            this.setState({
                isEdit: !this.state.isEdit
            })
        }
    }

    render(){
        const { student } = this.props;
        return(
            <div>
                <h2 className='subtitle' align='center'>Dashboard</h2>
                <div className='row dash'>

                    {/* // Left Section of Dashboard */}
                    
                    <div align='right' className='col s3 offset-s1 progress_wheel'>
                        <ProgressWheel progress={student.major_percent} size='350'/>
                        <h5 align='center'>Degree Progress</h5>
                    </div>
                    <div className='col s2 progress_wheel'>
                        <ProgressWheel progress={student.support_percent} size='150'/>
                        <h5 className='desc' align='center'>Support Progress</h5>
                        <ProgressWheel progress={student.ge_percent} size='150'/>
                        <h5 className='desc' align='center'>GE Progress</h5>
                    </div>

                    {/* // Right Section of Dashboard */}

                    <div className='col s3 offset-s2 info_section'>
                        <div className='subsubtitle'>
                            <h5> Name:  
                                <span className='dashboard_text'>
                                    {' ' + student.name}
                                </span>
                            </h5>
                            <div className='row'></div>
                            <div className='row'></div>
                            <h5>Major:
                                <StudentInfo id='tempM' info={this.state.tempM}
                                             handleChange={this.handleChange} 
                                             edit={this.state.isEdit} />
                            </h5>
                            <h5>Catalog Year:
                                <StudentInfo id='tempC' info={this.state.tempC}
                                             handleChange={this.handleChange} 
                                             edit={this.state.isEdit} />
                            </h5>
                            <h5>Expected Graduation:
                                <StudentInfo id='tempE' info={this.state.tempE}
                                             handleChange={this.handleChange} 
                                             edit ={this.state.isEdit} />
                            </h5>
                            <div className='row'></div>
                            <div className='row'></div>
                            <h5>Units This Quarter:
                                <StudentInfo id='tempUP' info={this.state.tempUP}
                                             handleChange={this.handleChange} 
                                             edit ={this.state.isEdit} />
                            </h5>
                            <h5>Units Per Quarter:
                                <StudentInfo id='tempUT' info={this.state.tempUT}
                                             handleChange={this.handleChange} 
                                             edit ={this.state.isEdit} />
                            </h5>
                        </div>
                    </div>
                </div>
                <div style = {{margin: '0px'}} className='row'>
                    <div className='col s4 offset-s8' >
                        <button className='white_button' onClick={this.handleEdit}>
                            {this.state.editButton}
                        </button>
                        <button className='green_button' onClick={this.handleSave}>
                            Save
                        </button>
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
        student: state.student
    }
}

/**
 * mapStateToDispatch
 * 
 * @description maps dispatch to props to allow component to send an action
 * @param {*} dispatch 
 */
const mapStateToDispatch = (dispatch) => {
    return{
        save: (tempM, tempC, tempE, tempUT, tempUP) => { dispatch(save(tempM, tempC, tempE, tempUT, tempUP)) }
    }
}

// 'connect' allows component to access the state from the store

export default connect(mapStateToProps, mapStateToDispatch)(DashBoard);