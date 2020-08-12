package data.algorithms;
import data.exceptions.MatrixOperationException;
import data.fundamentals.Matrix;
import data.fundamentals.Vector;

public class GaussianElimination {

    // Converts the given matrix into reduced row echelon form
    public void Solve(Matrix matrix) {
        int pointer = 0;
        int rowNumber = matrix.getNumRows();
        Vector[] columns = matrix.getColumns();
        int colNumber = columns.length;
    }

}
