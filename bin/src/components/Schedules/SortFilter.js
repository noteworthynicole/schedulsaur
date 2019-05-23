import React from 'react';
import Dropdown from './Dropdown';

/**
 *------------------------------------------------------- 
 * Component creates the sort and filter dropdowns
 *------------------------------------------------------- 
 * @param {array} sorters array of sorters (names)
 * @param {array} filters array of filters (names)
 */


const SortFilter = ({ sorters, filters }) => {
    return(
        <div>
            <h2 className='subtitle' align='center'>Sorting + Filter</h2>
            <div className='row'></div>
            <Dropdown name='Sort' list={sorters}/>
            <Dropdown name='Filter' list={filters}/>
            <h6 style={{marginTop: '5%'}} align='center'>
                * You can sort by earliest class start, <br />
                   latest class end, amount of hours <br />
                  spent in class, and more.
            </h6>
        </div>
    )
}

export default SortFilter;