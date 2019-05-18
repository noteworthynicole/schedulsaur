import React, { Component } from 'react';
import Curriculum from './CourseHistory/Curriculum';
import Flowchart from './Flowchart/Flowchart';

/**
 *------------------------------------------------------- 
 * Main Course History Component
 *------------------------------------------------------- 
 * 
 * Contains both the curriculum view and flowchart 
 *  for classes a student has already taken
 * 
 *------------------------------------------------------- 
 */

class CourseHistory extends Component {
    state = {
        viewCurriculum: true
    }

    getView = () => {
        let view = 
        this.state.viewCurriculum ? (
            <Curriculum type={'Completed'}/>
        ) : (
            <div>
                <h2 style={{paddingBottom: '.5%'}} className='subtitle' align='center'>Completed Classes</h2>
                <Flowchart />
            </div>
        )
        return (view)
    }

    handleCurr = () => {
        this.setState({
            viewCurriculum: true
        })
    }

    handleFlow = (e) => {
        this.setState({
            viewCurriculum: false
        })
    }

    render(){
        return(
        <div>
            {this.getView()}
            <div className='row'>
                <div align='right' className='col s4 offset-s8'>
                    <button className='white_button' onClick={this.handleCurr}>Curriculum View</button>
                    <button className='green_button' onClick={this.handleFlow}>Flowchart</button>
                </div>
            </div>
        </div>
        )
    }

}

export default CourseHistory;