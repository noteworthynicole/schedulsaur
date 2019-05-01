import studentReducer from './studentReducer';
import { combineReducers } from 'redux';

const rootReducer = combineReducers({
    student: studentReducer
});

export default rootReducer;