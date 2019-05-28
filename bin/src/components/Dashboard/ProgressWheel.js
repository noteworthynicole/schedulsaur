import React, { Component } from 'react';
import Circle from 'react-circle';
import styles from './Dashboard.module.css';

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
        this.interval = setInterval(() => {
            this.setState({
                percentage: this.props.progress
            })
        }, );
    }

    componentWillUnmount() {
        clearInterval(this.interval)
    }

    render(){
        return(
            <svg align='center' style={{height: this.props.size, width: this.props.size}} 
                className={styles.wheel}>
                <Circle 
                    progress={this.state.percentage}
                    animationDuration='1s'
                    size='100%'
                    textColor='#fff'
                    progressColor='#5ea181'
                />
                <text className={styles.wheel_text} x='50%' y='48%' textAnchor='middle'>
                    {this.state.percentage + '%'}
                </text>
                <text className={styles.wheel_text} x='50%' y='60%' textAnchor='middle'>
                    {this.props.desc}
                </text>
            </svg>
        );
    }
}

export default ProgressWheel;