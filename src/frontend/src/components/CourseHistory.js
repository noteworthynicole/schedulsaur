import React, { Component } from 'react';
import Curriculum from './CourseHistory/Curriculum';
import Flowchart from './Flowchart/Flowchart';

/**
 * CourseHistory
 * 
 * @description Main component to create the Course History page
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
                <div className='col s4 offset-s9'>
                    <button className='white_button' onClick={this.handleCurr}>Curriculum View</button>
                    <button className='green_button' onClick={this.handleFlow}>Flowchart</button>
                </div>
            </div>
        </div>
        )
    }

}

export default CourseHistory;