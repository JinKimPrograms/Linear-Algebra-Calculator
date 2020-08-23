package fundamentals;

import exceptions.VectorOperationException;
import java.util.Arrays;

// A class representation of a Vector with built-in operations
public class Vector {

    // Number of rows
    protected int numRows;

    // Has numRows values; vector[0] is the value in the first row
    protected double[] elements;


    public int getNumRows() {
        return numRows;
    }

    public double[] getElements() {
        return elements;
    }

    public Vector(double[] values) {
        this.elements = values;
        this.numRows = values.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return numRows == vector.numRows &&
                Arrays.equals(elements, vector.elements);
    }


    // Subtracts the vector in the parameter from this vector
    // Both vectors should have the same number of rows
    public void subVector(Vector sub) throws VectorOperationException {
        if (sub.numRows != this.numRows) {
            throw new VectorOperationException();
        }
        for (int i = 0; i < numRows; i++) {
            elements[i] = elements[i] - sub.elements[i];
        }
    }

    // Adds the vector in the parameter to this vector
    public void addVector(Vector sub) throws VectorOperationException {
        if (sub.numRows != this.numRows) {
            throw new VectorOperationException();
        }
        for (int i = 0; i < numRows; i++) {
            elements[i] = elements[i] + sub.elements[i];
        }
    }


    // For error message purposes - transcribes the vector into a readable string
    public String generateMessage() {
        String retval = "{";
        for (int i = 0; i < numRows; i++) {
            retval = retval + Integer.toString((int) elements[i]) + ", ";
        }
        retval = retval + "}";
        return retval;
    }


}
