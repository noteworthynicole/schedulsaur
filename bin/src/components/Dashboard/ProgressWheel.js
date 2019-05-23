import React, { Component } from 'react';
import Circle from 'react-circle';

/**
 *------------------------------------------------------- 
 * Component to create the progress wheel 
 *------------------------------------------------------- 
 */

class ProgressWheel extends Component{
    state = {
        percentage: 0
    }

    // Used for progress wheel animation
    componentDidMount() {
        setInterval(() => {
            this.setState({
                percentage: this.props.progress
            })
        }, );
    }

    render(){
        return(
            <div align='center'>
                <Circle 
                    progress={this.state.percentage}
                    animationDuration='1s'
                    size={this.props.size}
                    textColor='#8b8b8b'
                    progressColor='#5ea181'
                />
            </div>
        );
    }
}

export default ProgressWheel;