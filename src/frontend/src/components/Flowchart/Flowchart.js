import React, { Component } from 'react';
import { connect }  from 'react-redux';
import './Flowchart.css'

/**
 * Flowchart
 * 
 * @description Component that creates the flowchart
 */

class Flowchart extends Component{

    /**
     * createBox
     * 
     * @method
     * @description Used to create the individual course boxes
     */
    createBox = (course) => {
        switch(course.type){
            case 'CSC':
                return <div className='box csc_box'>CSC<br/>...</div>
            case 'Support':
                return <div className='box support_box'>Support<br/>...</div>
            case 'GE':
                return <div className='box ge_box'>GE<br/>...</div>
            default:
                return <div className='empty_box'></div>
        }
    }

    /**
     * createRow
     * 
     * @method
     * @description Used to create a row of courses
     */
    createRow = (row) => {
        return(
            row.map((course, index) => {
                return(
                    <div key={index} className={'col s' + course.len}>
                        {this.createBox(course)}
                    </div>
                )
            })    
        )
    }

    /**
     * createGrid
     * 
     * @method
     * @description Used to create the entire grid
     */
    createGrid = (flowchart) => {
        let grid = []
        Object.keys(flowchart).forEach((row, index)=>{
            grid.push(
                <div key={index} className='row'>
                    {this.createRow(flowchart[row])}
                </div>
            )
        })
        return(grid)
    }

    render(){
        const { courses } = this.props;
        return(
            <div>
                {this.createGrid(courses.flowchart)}
            </div>
        )
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
        courses: state.flowchart
    }
}

// 'connect' allows component to access the state from the store

export default connect(mapStateToProps)(Flowchart);