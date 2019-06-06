import React, { Component } from 'react';
import { connect } from 'react-redux';
import ProgressWheel from './ProgressWheel';
import StudentForm from './StudentForm';
import { submit } from 'redux-form';
import { edit, save } from '../../store/actions/studentActions'
import styles from './Dashboard.module.css';

/**
 *------------------------------------------------------- 
 * Main Dashboard Component
 *------------------------------------------------------- 
 */

class DashBoard extends Component{

    /**
     * --- Called when edit profile button is clicked
    */
    handleEdit = () => {
        this.props.edit();
    }

    /**
     * --- Called when save button is clicked or form is submitted
    */
    handleSave = (values) => {
        if(this.props.student.isEdit===true){

            // repalce values (backend purposes)
            if(Object.keys(values).length === 0){
                return (this.props.save(null, null))
            }else{
                let newInfo = []
                this.props.student.info.forEach(function(old){
                    let new_text = old.text
                    Object.keys(values).forEach(function(changed_value){
                        if(changed_value === old.type){
                            new_text = values[changed_value]
                        }
                    })
                    newInfo.push({type: old.type, text: new_text})
                })
                this.props.save(newInfo, this.props.student.id)
            }
        }
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
                                <StudentForm info={student.info} 
                                    edit={student.isEdit}
                                    onSubmit={this.handleSave} 
                                />
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
                        <button className='green_button' onClick={this.props.submitForm}>
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
        edit: () => { dispatch(edit()) },
        submitForm: () => { dispatch(submit('studentForm')) },
        save: (newInfo, id) => { dispatch(save(newInfo, id)) }
    }
}


// 'connect' allows component to access the state from the store

export default connect(mapStateToProps, mapStateToDispatch)(DashBoard);