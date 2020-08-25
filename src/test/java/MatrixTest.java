
import fundamentals.Matrix;
import fundamentals.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class MatrixTest {

    Vector vector1;
    Vector vector2;
    Vector vector3;
    Vector vector4;
    Vector vector5;

    Matrix matrix1;
    Matrix matrix2;
    Matrix matrix3;

    @BeforeEach
    public void setupTests()  {
        double[] test1 = new double[]{1, 3};
        vector1 = new Vector(test1);
        double[] test2 = new double[]{6, 9};
        vector2 = new Vector(test2);
        Vector[] vectors1 = new Vector[]{vector1, vector2};

        double[] test3 = new double[]{-2, -1};
        vector3 = new Vector(test3);
        double[] test4 = new double[]{-3, 4};
        vector4 = new Vector(test4);
        Vector[] vectors2 = new Vector[]{vector3, vector4};
        double[] test5 = new double[]{1};
        vector5 = new Vector(test5);
        Vector[] vectors3 = new Vector[]{vector5};


        try {
            matrix1 = new Matrix(vectors1);
            matrix2 = new Matrix(vectors2);
            matrix3 = new Matrix(vectors3);
        } catch (Exception e) {
            System.out.println("Hey man, you messed up your setup test. Cmon.");
        }
    }

    @Test
    public void testConstructor() {

        Vector[] columns = matrix1.getColumns();
        Vector column1 = columns[0];
        Vector column2 = columns[1];

        assertEquals(matrix1.getNumRows(), 2);
        assertEquals(column1, vector1);
        assertEquals(column2, vector2);

        double[] temp = new double[]{1, 3, 5};
        Vector vector5 = new Vector(temp);
        Vector[] mismatchedVectors = new Vector[]{vector1, vector5};

        try {
            Matrix wrong = new Matrix(mismatchedVectors);
            fail();
        } catch (Exception e) {
            // Test success! Caught exception.
        }
    }

    @Test
    public void testAddMatrix() {
        try {
            matrix1.addMatrix(matrix2);
        } catch (Exception e) {
            fail();
        }

        Vector[] columns = matrix1.getColumns();
        double[] vector1Contents = columns[0].getElements();
        double[] vector2Contents = columns[1].getElements();
        assertEquals(vector1Contents[0], -1);
        assertEquals(vector1Contents[1], 2);
        assertEquals(vector2Contents[0], 3);
        assertEquals(vector2Contents[1], 13);

        try {
            matrix1.addMatrix(matrix3);
            fail();
        } catch (Exception e) {
            // Success! Tried to add matrix of wrong size
        }
    }

    @Test
    public void testSubMatrix() {
        try {
            matrix1.subMatrix(matrix2);
        } catch (Exception e) {
            fail();
        }

        Vector[] columns = matrix1.getColumns();
        double[] vector1Contents = columns[0].getElements();
        double[] vector2Contents = columns[1].getElements();
        assertEquals(vector1Contents[0], 3);
        assertEquals(vector1Contents[1], 4);
        assertEquals(vector2Contents[0], 9);
        assertEquals(vector2Contents[1], 5);

        try {
            matrix1.subMatrix(matrix3);
            fail();
        } catch (Exception e) {
            // Success! Tried to add matrix of wrong size
        }
    }

    @Test
    public void testInterChange() {
        try {
            matrix1.interChange(0, 1);
        } catch (Exception e) {
            fail();
        }

        Vector[] columns = matrix1.getColumns();
        double[] vector1Contents = columns[0].getElements();
        double[] vector2Contents = columns[1].getElements();
        assertEquals(vector1Contents[0], 3);
        assertEquals(vector1Contents[1], 1);
        assertEquals(vector2Contents[0], 9);
        assertEquals(vector2Contents[1], 6);

        try {
            matrix1.interChange(1, 3);
            fail();
        } catch (Exception e) {
        }
        try {
            matrix1.interChange(2, 1);
            fail();
        } catch (Exception e) {
        }
        try {
            matrix1.interChange(4, 3);
            fail();
        } catch (Exception e) {
        }
        try {
            matrix1.interChange(2, 4);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void testReplacement() {
        try {
            matrix1.replacement(0, 1, 3, false);
        } catch (Exception e) {
            fail();
        }

        Vector[] columns = matrix1.getColumns();
        double[] vector1Contents = columns[0].getElements();
        double[] vector2Contents = columns[1].getElements();
        assertEquals(vector1Contents[0], 10);
        assertEquals(vector1Contents[1], 3);
        assertEquals(vector2Contents[0], 33);
        assertEquals(vector2Contents[1], 9);

        try {
            matrix1.replacement(1, 3, 1, false);
            fail();
        } catch (Exception e) {
        }
        try {
            matrix1.replacement(2, 1,1, false);
            fail();
        } catch (Exception e) {
        }
        try {
            matrix1.replacement(4, 3, 1, false);
            fail();
        } catch (Exception e) {
        }
        try {
            matrix1.replacement(2, 4, 1, false);
            fail();
        } catch (Exception e) {
        }

        try {
            matrix2.scale(0, 2);
        } catch (Exception e) {
            fail();
        }

        Vector[] columns2 = matrix2.getColumns();
        double[] vector1Contents2 = columns2[0].getElements();
        double[] vector2Contents2 = columns2[1].getElements();
        assertEquals(vector1Contents2[0], -4);
        assertEquals(vector1Contents2[1], -1);
        assertEquals(vector2Contents2[0], -6);
        assertEquals(vector2Contents2[1], 4);

    }


    @Test
    public void testGenerateMessage() {
        String msg = matrix1.generateMessage();
        assertEquals(msg, "{ \n1, 6, \n3, 9, \n }");
    }




}

