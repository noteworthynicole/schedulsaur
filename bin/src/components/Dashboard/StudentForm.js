import React, { Component } from 'react';
import { Form, Field, reduxForm } from 'redux-form';
import styles from './Dashboard.module.css';

/**
 *------------------------------------------------------- 
 * component that creates the student form
 *------------------------------------------------------- 
 */

class StudentForm extends Component{

    getContents = (element, edit) => {
        let content = 
            edit ? (
                <Field name={element.type} component='input' type='text' 
                    placeholder={element.text} />
            ) : (
                ' ' + element.text
            )
        return content
    }

    createForm = (info, edit) => {
        let contents = 
            info.slice(1).map((element, index) => {
                return (
                    <div key={index}>{element.type + ': '}
                        <span className={styles.text}>
                            {this.getContents(element, edit)}
                        </span>
                    </div>
                )
            })
        return contents
    }

    render(){
        const {info, edit, handleSubmit, onSubmit} = this.props;
        return (
            <Form onSubmit={handleSubmit(onSubmit)}>
                {this.createForm(info, edit)}
            </Form>
        )
    }
}

StudentForm = reduxForm({
    form: 'studentForm'
})(StudentForm)

export default StudentForm;