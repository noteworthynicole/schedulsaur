import React, { Component } from 'react';
import { connect }  from 'react-redux';
import './Flowchart.css'

class Flowchart extends Component{

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

const mapStateToProps = (state, ownProps) => {
    return {
        courses: state.flowchart
    }
}

export default connect(mapStateToProps)(Flowchart);