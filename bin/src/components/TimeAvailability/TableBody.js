import React, { Component} from 'react';
import styles from './TimeTable.module.css';

/**
 *------------------------------------------------------- 
 * Component to create the time selection table body
 *------------------------------------------------------- 
 */

class TableBody extends Component{

    /**
     * fillRow
     * 
     * @desc Fills in the cells with the color corresponding 
     *          to the sate of the cell (selected or not selected)
     * @param {array} row an array of booleans
     * @param  {*} row_index the index of the row
     */
    fillRow = (row, row_index) => {
        return(
            row.available.map((selected, index) => {
                return(
                    selected ? (
                        // fill green if selected
                        <td key={index} row_id={row_index} col_id={index} 
                            bgcolor='#5ea181' className={styles.table_td} 
                            onClick={this.props.handleSelect}></td>
                    ) : (
                        // fill white if not selected
                        <td key={index} row_id={row_index} col_id={index} 
                            className={styles.table_td} 
                            onClick={this.props.handleSelect}></td>
                    )
                )
            })
        )
    }

    render(){
        const { table } = this.props;
        const times = table.map((time, index) => {
            return(
                <tr className={styles.table_tr} key={index}>
                    <td className={styles.time_slot}>
                        {time.time}
                    </td>
                    {this.fillRow(time, index)}
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