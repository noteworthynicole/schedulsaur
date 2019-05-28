import React, { Component } from 'react';
import { connect }  from 'react-redux';
import styles from './Flow.module.css';

class Flowchart extends Component{

    /**
     * --- Used to create the individual course boxes
    */
    createBox = (course) => {
        switch(course.type){
            case 'CSC':
                return <div className={`${styles.box} ${styles.csc_box}`}>CSC<br/>...</div>
            case 'Support':
                return <div className= {`${styles.box} ${styles.support_box}`}>Support<br/>...</div>
            case 'GE':
                return <div className={`${styles.box} ${styles.ge_box}`}>GE<br/>...</div>
            default:
                return <div className={styles.empty_box}></div>
        }
    }

    /**
     * --- Used to create a row of courses
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
     * --- Used to create the flowchart grid
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
            <div className={styles.grid_container}>
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