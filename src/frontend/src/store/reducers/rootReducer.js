import studentReducer from './studentReducer';
import timeReducer from './timeReducer';
import scheduleReducer from './scheduleReducer';
import { combineReducers } from 'redux';
import flowchartReducer from './flowchartReducer';

/**
 * Root Reducer
 * 
 * @description Combines all the reducers 
 * @param {studentReducer} student student reducer
 * @param {timeReducer} time time reducer
 * @param {scheduleReducer} schedule schedule reducer
 * @param {flowchartReducer} flowchart flowchart reducer
 */

const rootReducer = combineReducers({
    student: studentReducer,
    time: timeReducer,
    schedule: scheduleReducer,
    flowchart: flowchartReducer
});

export default rootReducer;