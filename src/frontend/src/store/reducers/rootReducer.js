import studentReducer from './studentReducer';
import timeReducer from './timeReducer';
import { combineReducers } from 'redux';

/**
 * Root Reducer
 * 
 * @description Combines all the reducers 
 * @param {studentReducer} student student reducer
 * @param {timeReducer} time time reducer
 */

const rootReducer = combineReducers({
    student: studentReducer,
    time: timeReducer
});

export default rootReducer;