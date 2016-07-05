/**
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example,
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
 var spiralOrder = function(matrix) {
    var result = [];
    
    if (matrix === null || matrix.length === 0 || matrix[0].length === 0) {
        return result;
    }
    
    var row = matrix.length;
    var col = matrix[0].length;
    
    var x = 0;
    var y = 0;
    
    while (row > 0 && col > 0) {
        if (row === 1) {
            for (var i = 0; i < col; i++) {
                result.push(matrix[x][y++]);
            }
            break;
        } else if(col === 1) {
            for (i = 0; i < row; i++) {
                result.push(matrix[x++][y]);
            }
            break;
        }
        
        for (i = 0; i < col - 1; i++) {
            result.push(matrix[x][y++]);
        }
        for (i = 0; i < row - 1; i++) {
            result.push(matrix[x++][y]);
        }
        for (i = 0; i < col - 1; i++) {
            result.push(matrix[x][y--]);
        }
        for (i = 0; i < row - 1; i++) {
            result.push(matrix[x--][y]);
        }
        x++;
        y++;
        col -= 2;
        row -= 2;
    }
    
    return result;
    
};
