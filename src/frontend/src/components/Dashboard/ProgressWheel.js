import React, { Component } from 'react';
import Circle from 'react-circle';

/**
 * ProgressWheel
 * 
 * @description Component to create the progress wheel on the Dashboard page
 */

class ProgressWheel extends Component{
    render(){
        return(
            <div align='center'>
                <Circle 
                    progress={this.props.progress}
                    size={this.props.size}
                    textColor='#8b8b8b'
                    progressColor='#5ea181'
                />
            </div>
        );
    }
}

export default ProgressWheel;