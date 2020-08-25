package algorithms;
import exceptions.MatrixOperationException;
import fundamentals.Matrix;
import fundamentals.Vector;

public class GaussianElimination {

    // Converts the given matrix into reduced row echelon form
    public void Solve(Matrix matrix) throws MatrixOperationException {
        // Pointer for which row - start at first row (row 0)
        int p = 0;

        int numRows = matrix.getNumRows();
        Vector[] columns = matrix.getColumns();

        while (p < numRows) {
            double[] currVector = columns[p].getElements();

            for (int i = p; i < numRows; i++) {
                if (currVector[i] == 0) {
                    continue;
                }
                matrix.interChange(p, i);
                // At this point, it is guaranteed that that the i'th row of the p'th vector is a pivot
                Double pivot = currVector[i];
                // Turn the pivot into 1
                matrix.scale(i, 1/pivot);
                // Everything below the pivot is reduced to 0
                for (int n = i + 1; n < numRows; n++) {
                    Double curr = currVector[n];
                    matrix.replacement(n, i, (curr * -1), false);
                }
                break;
           }
            // Move to next row
            p++;
        }
    }

}
