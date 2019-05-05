import React, { Component } from 'react';
import TableHeader from './TableHeader';
import TableBody from './TableBody';

/**
 * TimeTable
 * 
 * @description Component to create the time selection table
 */

class TimeTable extends Component{
    render(){
        const { isViewing, table, handleSelect } = this.props;
        return(
            <table className='tb' align='center'>
                <thead>
                    <TableHeader />
                </thead>
                <TableBody table={table} isViewing={isViewing} handleSelect={handleSelect}/>
            </table>
        );
    }
}

export default TimeTable;