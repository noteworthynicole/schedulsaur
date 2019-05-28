import React from 'react';
import Dropdown from './Dropdown';
import styles from './SortFilter.module.css';

/**
 *------------------------------------------------------- 
 * Component creates the sort and filter dropdowns
 *------------------------------------------------------- 
 * @param {array} sorters array of sorters (names)
 * @param {array} filters array of filters (names)
 */


const SortFilter = ({ sorters, filters }) => {
    return(
        <div className={styles.sf_container}>
            <h2 className='subtitle' align='center'>Sorting + Filter</h2>
            <div className={styles.content_container}>
                <Dropdown name='Sort' list={sorters}/>
                <Dropdown name='Filter' list={filters}/>
                <div style={{marginTop: '5%'}} align='center' className='description'>
                    * You can sort by earliest class start, <br />
                    latest class end, amount of hours <br />
                    spent in class, and more.
                </div>
            </div>
        </div>
    )
}

export default SortFilter;