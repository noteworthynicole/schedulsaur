import React, { Component } from 'react';
import './App.css';
import './Classbox.css'

export default class Classbox extends Component {

   constructor(props) {
        super(props)

        this.state = {
            themeColor: props.themeColor
        }
        
    }
    
  render() {
    return (

     /* <div style={{backgroundColor: this.state.themeColor, display: 'flex', justifyContent: 'center', justifyContent:'center', alignItems:"center", lineHeight:.4}}>
        <h4>{this.props.classNum}</h4>
        <br/>
          <p>{this.props.className}</p>
      </div>*/

      
        <div style={{width: 150, height: 150, backgroundColor: this.props.themeColor, borderColor:"black"}}>
          <p style={{fontSize: 10, fontWeight: "bold"}}>{this.props.className}</p>
          <p style={{fontSize: 15, fontWeight: "bold"}}>{this.props.classNum}</p>
        </div>
        
    );
  }
}
