package fundamentals;
import exceptions.MatrixOperationException;
import exceptions.VectorOperationException;


// A class representation of a matrix, with built-in addition, subtraction & elementary row operations
// This implementation does not support an empty matrix (would be useless anyway)
public class Matrix {

    protected int numRows;

    // A matrix is composed of columns of vectors
    // columns[0] is the first column of the matrix
    protected Vector[] columns;

    public int getNumRows() {
        return numRows;
    }

    public Vector[] getColumns() {
        return columns;
    }

    public Matrix(Vector[] vectors) throws MatrixOperationException {
        int temp = vectors[0].numRows;
        // check through all vectors to make sure they are the same size
        for (Vector vect : vectors) {
            if (vect.numRows != temp) {
                throw new MatrixOperationException();
            }
        }

        columns = vectors;
        numRows = temp;
    }

    // Adds the matrix in the parameter to this one
    public void addMatrix(Matrix sub) throws MatrixOperationException, VectorOperationException {
        // If number of rows/cols is not the same;
        if (this.numRows != sub.numRows || this.columns.length != sub.columns.length) {
            throw new MatrixOperationException();
        }

        for (int i = 0; i < columns.length; i++) {
            this.columns[i].addVector(sub.columns[i]);
        }
    }

    public void subMatrix(Matrix sub) throws MatrixOperationException, VectorOperationException {
        if (this.numRows != sub.numRows || this.columns.length != sub.columns.length) {
            throw new MatrixOperationException();
        }

        for (int i = 0; i < columns.length; i++) {
            this.columns[i].subVector(sub.columns[i]);
        }
    }

    // Matrix elementary row operation - swap the specified rows in the matrix
    // Row number is assumed to not use 0-based indexing
    public void interChange(int row1, int row2) throws MatrixOperationException {
        if (row1 < 0 || row2 < 0 || row1 > numRows - 1|| row2 > numRows - 1) {
            throw new MatrixOperationException();
        }

        for (Vector vect : columns) {
            double temp = vect.elements[row1];
            vect.elements[row1] = vect.elements[row2];
            vect.elements[row2] = temp;
       }
    }

    // Matrix elementary row operation - add a multiple of one row to another
    // In this case row1 += row2 * scale
    public void replacement(int row1, int row2, double multiplier, boolean scale) throws MatrixOperationException {
        if (row1 < 0 || row2 < 0 || row1 > numRows - 1 || row2 >  numRows - 1) {
            throw new MatrixOperationException();
        }

        for (Vector vect : columns) {
            if (!scale) {
                vect.elements[row1] += vect.elements[row2] * multiplier;
            } else {
                vect.elements[row1] = vect.elements[row1] * multiplier;
            }
        }
    }

    // Matrix elementary row operation - scale all values in row by a constant
    public void scale(int row, double scale) throws MatrixOperationException {
        this.replacement(row, row, scale, true);
    }


    // Transcribes the matrix into a readable string
    public String generateMessage() {
        String retval = "{ \n";
        for (int i = 0; i < numRows; i++) {
            for (Vector vect : columns) {
                retval = retval + Integer.toString((int) vect.elements[i]) + ", ";
            }
            retval = retval + "\n";
        }
        return retval + " }";
    }







}
