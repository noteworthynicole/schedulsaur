import React, { Component } from 'react';
import Map from '../../Map2.png' 
 import TableHeader from '../TimeAvailability/TableHeader';
import TableBody from '../TimeAvailability/TableBody';
import PinchZoomPan from 'react-responsive-pinch-zoom-pan';
import './ScheduleExpand.css'

/**
 *------------------------------------------------------- 
 * Component that creates the expanded portion of the 
 *  schedule, which contains the map and time table view
 *------------------------------------------------------- 
 */

class ScheduleExpand extends Component{

    /**
     * --- disable scroll when interacting with map
     */
    disableScroll = () => {
        var list = document.getElementsByClassName('ul');
        list[0].classList.remove('scrollable')
        list[0].classList.add('nonscrollable')
    }

    /**
     * --- enable scroll when not interacting with map
     */
    enableScroll = () => {
        var list = document.getElementsByClassName('ul');
        list[0].classList.remove('nonscrollable')
        list[0].classList.add('scrollable')
    }

    render(){
        const { schedule } = this.props;
        return(
            <div className='layout'>
                <div className='image' onMouseOver={this.disableScroll} onMouseLeave={this.enableScroll}>
                    <PinchZoomPan 
                        position='center' 
                        initialScale={2.5} 
                        maxScale={5} 
                        zoomButtons={false} >
                            <img src={Map} alt='Campus Map' width='100%'/>
                    </PinchZoomPan>
                </div>
                <table className='tb smallTable' align='center'>
                    <thead>
                        <TableHeader  />
                    </thead>
                    <TableBody table={schedule.times} />
                </table>
            </div>
        )
    }
}

export default ScheduleExpand;