import React, { Component } from 'react';
import './Dropdown.css';

class Dropdown extends Component {
    state = {
        isOpen: false
    }

    /**
     * handleClickOutside
     * 
     * @method
     * @description Called when user clicks outside  dropdown menu
     */
    handleClickOutside = () => {
        this.setState({
            isOpen: false
        })
    } 


    /**
     * toggleList
     * 
     * @method
     * @description Called when user clicks on a dropdown menu
     */
    toggleList = (e) => {
        this.setState({
            isOpen: !this.state.isOpen
        })
    }

    render(){
        const { name, list } = this.props;

        // changes angle icon when dropdown is clicked
        const angleIcon = 
            this.state.isOpen ? (
                    <i className='small material-icons right'>expand_less</i>
            ) : (
                    <i className='small material-icons right'>expand_more</i>
            )

        // create dropdown elements
        const elements =
            list.map((element, index) => {
                return(
                    <div key={index} style={{borderBottom:'solid 1px white'}}>
                        <li style={{marginLeft:'20%'}} key={index}>{element.name}</li>
                    </div>
                )
            })

        // create dropdown menu
        const listelements = 
            this.state.isOpen ? (
                <ul className='dropdown-cont'>{elements}</ul>
            ) : (null)

        return(
            <div className='dropdown'>
                <div className='drop' onClick={this.toggleList}>
                    {name}
                    {angleIcon}
                </div>
                <div align='center'>
                        {listelements} 
                </div>
            </div>
        )
    }
}

export default Dropdown;