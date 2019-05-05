import React, { Component} from 'react';

/**
 * TableBody
 * @descripton Component to create the time selection table body
 */

class TableBody extends Component{

    fillRow = (row) => {
        let col_id = 0;
        return(
            row.available.map(selected => {
                return(
                    selected ? (
                        <td key={col_id+=1} row_id={row.id} col_id={col_id} 
                            bgcolor='#5ea181' className='table_td' onClick={this.props.handleSelect}></td>
                    ) : (
                        <td key={col_id+=1} row_id={row.id} col_id={col_id} 
                            style={{backgroundColor:'white'}} className='table_td' onClick={this.props.handleSelect}></td>
                    )
                )
            })
        )
    }

    render(){
        const { table } = this.props;
        const times = table.map(time => {
            return(
                <tr className='table_tr' key={time.id}>
                    <td>{time.time}</td>
                    {this.fillRow(time)}
                </tr>
            )
        })

        return(
            <tbody>
                {times}
            </tbody>
        );
    }
}

export default TableBody;