import studentReducer from './studentReducer';
import timeReducer from './timeReducer';
import scheduleReducer from './scheduleReducer';
import flowchartReducer from './flowchartReducer';
import courseHistoryReducer from './courseHistoryReducer';
import { reducer as formReducer } from 'redux-form';
import { combineReducers } from 'redux';

/**
 * Root Reducer
 * 
 * @desc Combines all the reducers 
 * @param {studentReducer} student for dashboard
 * @param {timeReducer} time for time availability
 * @param {scheduleReducer} schedule for saved and potential schedules
 * @param {flowchartReducer} flowchart for desired courses and course history
 */

const rootReducer = combineReducers({
    student: studentReducer,
    time: timeReducer,
    schedule: scheduleReducer,
    courseHistory: courseHistoryReducer,
    flowchart: flowchartReducer,
    form: formReducer
});

export default rootReducer;