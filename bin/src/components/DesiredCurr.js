import React, { Component } from 'react';
import Flowchart from './Flowchart/Flowchart';
import Curriculum from './CourseHistory/Curriculum';

/**
 *------------------------------------------------------- 
 * Main Desired Curriculum Component
 *------------------------------------------------------- 
 * 
 * Contains both the curriculum view and flowchart 
 *  for classes a student wants to take
 * 
 *------------------------------------------------------- 
 */

class DesiredCurr extends Component {
    state = {
        viewCurriculum: true
    }

    getView = () => {
        let view = 
        this.state.viewCurriculum ? (
            <Curriculum type={'Desired'}/>
        ) : (
            <div>
                <h2 style={{paddingBottom: '.5%'}} className='subtitle' align='center'>Desired Classes</h2>
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

    handleFlow = () => {
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

export default DesiredCurr;