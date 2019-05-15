export const changeAvailable = (row_id, col_id) => {
    return {
        type: 'CHANGE AVAILABILITY',
        row_id: row_id,
        col_id: col_id
    }
};

export const view = (id) => {
    return{
        type: 'VIEW',
        id: id
    }
}

export const clear = () => {
    return{
        type: 'CLEAR'
    }
}