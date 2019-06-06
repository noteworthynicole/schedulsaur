import axios from 'axios';

/**
 * getTimes
 * 
 * @desc Get the user's time prefernces from the backend
 * @param {*} studentId 
 */
export const loadTimes = (studentId) => {
    return (dispatch) => {
        axios.get(`http://localhost:8080/pref/${studentId}`)
        .then(response => {
            dispatch({ type: 'LOAD_TIMES', times: response.data})
        })
    }
}

/**
 * editName
 * 
 * @desc Edit the time preference name
 * @param {*} id  identifier in 'saved' array in timeReducer
 * @param {*} index index in 'saved' array in timeReducer
 */
export const editName = (id, index) => {
    return{
        type: 'TIME_NAME_EDIT',
        id: id,
        index: index
    }
}

/**
 * saveName
 * 
 * @desc Save the name of the time preference
 * @param {*} id identifier in 'saved' array in timeReducer
 * @param {*} index index in 'saved' array in timeReducer
 * @param {*} name new name for time preference
 */
export const saveName = (studentId, id, index, name) => {

    return (dispatch) => {
        axios.put(`http://localhost:8080/pref/${studentId}/${id}/${name}`)

        // need to verify if post was successful (response.status should equal 200)
        .then(() => {
            dispatch({ type: 'TIME_NAME_SAVE', id: id, index: index, name: name})
        })
    }
}

/**
 * changeAvailable
 * 
 * @desc Change selected time cell
 * @param {*} row_id index in 'availability' array in timeReducer
 * @param {*} col_id index in 'available' array in 'availability in timeReducer
 */
export const changeAvailable = (row_id, col_id) => {
    return{
        type: 'CHANGE AVAILABILITY',
        row_id: row_id,
        col_id: col_id
    }
};

/**
 * view
 * 
 * @desc View a saved time preference
 * @param {*} id identifier in 'saved' array in timeReducer
 * @param {*} index index in 'saved' array in timeReducer
 */
export const view = (studentId, id, index) => {

   return (dispatch) => {
        axios.get(`http://localhost:8080/block/${studentId}/${id}`)

        // need to verify if post was successful (response.status should equal 200)
        .then(response => {
            dispatch({ type: 'TIME_VIEW', block: response.data, index: index})
        })
    }
}

/**
 * save
 * 
 * @desc Save a new time preference
 * @param {*} name new name for new time preference
 */
export const save = (studentId, timeBlock, name) => {

    // *** need to make async call to database here to save
    // *** need to make async call to database here to save

    // *** need to get new id from database
    // *** need to get new id from database
    return (dispatch) => {
        axios.post("http://localhost:8080/block", 
            {
                studentId: studentId,
                availNum: '',
                name: name,
                blocks: timeBlock,
            })

        // need to verify if post was successful (response.status should equal 200)
        .then(response => {
            dispatch({ type: 'TIME_SAVE', timePref: response.data})
        })
    }
}

/**
 * del
 * 
 * @desc Delete a time preference
 * @param {*} id identifer in 'saved' array in timeReducer
 * @param {*} index index in 'saved' array in timeReducer
 */
export const del = (id, index) => {
    return{
        type: 'TIME_DELETE',
        id: id,
        index: index
    }
}

/**
 * clear
 * 
 * @desc Clear the time table
 */
export const clear = () => {
    return{
        type: 'TIME_CLEAR'
    }
}