import React, { Component } from 'react';
import Circle from 'react-circle';

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