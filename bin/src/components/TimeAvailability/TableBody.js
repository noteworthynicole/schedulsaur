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
     * @param  {*} row_index the index of the row
     */
    fillRow = (table, row_index) => {
        let row = this.getCorrespondingSlots(table, row_index)
        return(
            row.map((selected, index) => {
                return(
                    !selected ? (
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

    getCorrespondingSlots = (table, index) => {
        let rows = 
            table.map((day) => {
                return(
                    day.available[index]
                )
            })
        return rows;
    }

    render(){
        const { table } = this.props;
        const timeSlots = [ '07-08 AM', '08-09 AM', '09-10 AM', '10-11 AM', '11-12 AM',
                            '12-01 PM', '01-02 PM', '02-03 PM', '03-04 PM', '04-05 PM',
                            '05-06 PM', '05-06 PM', '06-07 PM', '07-08 PM', '08-09 PM']
        const times = timeSlots.map((time, index) => {
            return(
                <tr className={styles.table_tr} key={index}>
                    <td className={styles.time_slot}>
                        {time}
                    </td>
                    {this.fillRow(table, index)}
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