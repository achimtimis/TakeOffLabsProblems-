/**
 * Created by achy_ on 3/20/2016.
 */

/*
 Problem: Rotate an N by N array by 90 degrees.

 Solution: There are some possible solutions I've thought of,like making a new array and adding elements from the givem matrix in the right order
 (but that would not be inplace rotation),or splitting the matrix in layers and rotate each individual layer.
    In the end I've opted for a more simple solution imo,computing the transpose of the matrix and then shifting the collumns to the right until we get the right placement.
 */
public class MatrixRotation90 {
    private int[][] matrix = {
            { 1, 2, 3 },
            { 5, 6, 7},
            { 8, 9, 10}

    };

    /*
    Inorder printing of the matrix.
     */
    public void printMatrix() {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

/* changes the items bellow the main diagonals with the respective one above it.
            [1][2][3]    transposed  [1][4][7]
  given     [4][5][6] -> matrix      [2][5][8]
matrix      [7][8][9]                [3][6][9]
 */
    public void generateTranspose(){
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    /* shifting collumns to the right
     [1][4][7]        [7][4][1]
     [2][5][8] ->     [8][5][2]
     [3][6][9]        [9][6][3]

     */
    public void shiftMatrix(){
        int n= matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - 1 - j; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }

    }
    public void rotate90(){
        generateTranspose();
        shiftMatrix();
        printMatrix();
    }
}
