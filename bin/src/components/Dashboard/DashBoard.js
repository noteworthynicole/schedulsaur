import React, { Component } from 'react';
import { connect } from 'react-redux';
import ProgressWheel from './ProgressWheel';
import StudentInfo from './StudentInfo';
import { edit, save } from '../../store/actions/studentActions'
import styles from './Dashboard.module.css';

/**
 *------------------------------------------------------- 
 * Main Dashboard Component
 *------------------------------------------------------- 
 */

class DashBoard extends Component{

    state = {
        type0: this.props.student.info[0].text,
        type1: this.props.student.info[1].text,
        type2: this.props.student.info[2].text,
        type3: this.props.student.info[3].text,
        type4: this.props.student.info[4].text
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
        this.props.edit();
    }

    /**
     * --- Called when save button is clicked
    */
    handleSave = () => {
        if(this.props.student.isEdit===true){
            this.props.save(
                this.state.type0,
                this.state.type1,
                this.state.type2,
                this.state.type3,
                this.state.type4
            )
        }
    }

    /**
     * --- Creates the student info section of the dashboard
     */
    createInfo = () => {
        let student_info = 
            this.props.student.info.slice(1).map((element, index) => {
                return(
                    <div key={index}>{element.type + ': '}
                        <StudentInfo id={'type'+index} info={element.text} 
                                     edit={this.props.student.isEdit}
                                     handleChange={this.handleChange}
                        />
                    </div>
                )
        })
        return (student_info)
    }

    render(){
        const { student } = this.props;
        return(
            <div>
                <h2 className='subtitle' align='center'>Dashboard</h2>
                <div className={styles.main_container}>

                    {/* // Left Section of Dashboard */}

                    <div className={styles.prog_container}>
                        <div className={styles.main_wheel}>
                            <ProgressWheel progress={student.major_percent} size='100%' desc='Degree'/>
                        </div>
                        <div className={styles.sub_wheel}>
                            <ProgressWheel progress={student.support_percent} size='65%' desc='Support'/>
                            <ProgressWheel progress={student.ge_percent} size='65%' desc='GE'/>
                        </div>
                    </div>

                    {/* // Right Section of Dashboard */}

                    <div className={styles.student_container}>
                        <div className={`${styles.info_container} subsubtitle`}>
                            <div> Name:  
                                <span className={styles.text}>
                                    {' ' + student.info[0].text}
                                </span>
                            </div>
                            <div className={styles.info}>
                                {this.createInfo()}
                            </div>
                        </div>
                    </div>
                </div>

                    {/* // Bottom Section of Dashboard */}

                <div className={styles.bottom_container}>
                    <div className='description'>
                        *Degree Progress is Measured with the classes you have inputted.
                    </div>
                    <div className={styles.button_container}>
                        <button className='white_button' onClick={this.handleEdit}>
                            {student.editButton}
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
        save: (tempM, tempC, tempE, tempUT, tempUP) => { dispatch(save(tempM, tempC, tempE, tempUT, tempUP)) },
        edit: () => { dispatch(edit()) }
    }
}

// 'connect' allows component to access the state from the store

export default connect(mapStateToProps, mapStateToDispatch)(DashBoard);