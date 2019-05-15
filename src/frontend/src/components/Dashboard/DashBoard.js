import React, { Component } from 'react';
import { connect } from 'react-redux';
import ProgressWheel from './ProgressWheel';
import StudentInfo from './StudentInfo';

/**
 * DashBoard
 * 
 * @description Main component to create the Dashboard page
 */

class DashBoard extends Component{

    state = {
        isEdit: false,
        tempM: this.props.student.major,
        tempC: this.props.student.catalog_year,
        tempE: this.props.student.expected_grad,
        tempUT: this.props.student.units_this_quarter,
        tempUP: this.props.student.units_per_quarter
    }

    /**
     * handleChange
     * 
     * @method
     * @description called when input text is changing in StudentInfo component 
     */

    handleChange = (e) => {
        this.setState({
            [e.target.id]: e.target.value
        })
    }

    /**
     * handleEdit
     * @method 
     * @description called when edit profile button is clicked
     */
    handleEdit = () => {
        if(this.state.isEdit===false){
            this.setState({
                isEdit: !this.state.isEdit
            })
        }
    }


    /**
     * handleSave
     * 
     * @method
     * @description called when save button is clicked
     */
    handleSave = () => {
        if(this.state.isEdit===true){
            this.setState({
                isEdit: !this.state.isEdit
            })
        }

        // *** need to send action to modify global state 
        // *** need to send action to modify global state 

    }

    render(){
        const { student } = this.props;
        return(
            <div>
                <h2  className='subtitle' align='center'>Dashboard</h2>
                <div style={{paddingTop:'2%'}} className='row'>

                    {/* // Left Section of Dashboard */}
                    
                    <div className='col s4'>
                        <ProgressWheel progress={student.major_percent} size='400'/>
                        <h5 align='center'>Degree Progress</h5>
                    </div>
                    <div style={{paddingTop:'2%'}} className='col s2'>
                        <ProgressWheel progress={student.support_percent} size='150'/>
                        <h5 align='center'>Support Progress</h5>
                        <ProgressWheel progress={student.ge_percent} size='150'/>
                        <h5 align='center'>GE Progress</h5>
                    </div>

                    {/* // Right Section of Dashboard */}

                    <div style={{paddingTop:'1%'}} className='col s4 offset-s2'>
                        <div className='subsubtitle'>
                            <h5> Name:  
                                <span style={{fontSize:'20px', fontWeight:'normal'}}>
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
                        <div style={{paddingTop:'10%'}}>
                            <button className='button' id='button_left' onClick={this.handleEdit}>
                                Edit Profile
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
        student: state.student
    }
}


// 'connect' allows component to access the state from the store

export default connect(mapStateToProps)(DashBoard);