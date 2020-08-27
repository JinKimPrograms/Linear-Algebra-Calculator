import exceptions.MatrixOperationException;
import fundamentals.Matrix;
import fundamentals.Vector;
import algorithms.GaussianElimination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class GaussianEliminationTest {

    Vector vector1;
    Vector vector2;
    Vector vector3;
    Vector vector4;
    Vector vector5;
    Vector vector6;
    Vector vector7;

    Matrix matrix1;
    Matrix matrix2;
    Matrix matrix3;

    GaussianElimination gauss = new GaussianElimination();

    @BeforeEach
    public void setupTests()  {
        double[] test1 = new double[]{1, 3};
        vector1 = new Vector(test1);
        double[] test2 = new double[]{6, 9};
        vector2 = new Vector(test2);
        Vector[] vectors1 = new Vector[]{vector1, vector2};

        double[] test3 = new double[]{0, -1};
        vector3 = new Vector(test3);
        double[] test4 = new double[]{-3, 4};
        vector4 = new Vector(test4);
        double[] test5 = new double[]{1, 9};
        vector5 = new Vector(test5);
        Vector[] vectors2 = new Vector[]{vector3, vector4, vector5};

        double[] test6 = new double[]{2, 4};
        vector6 = new Vector(test6);
        double[] test7 = new double[]{4, 8};
        vector7 = new Vector(test7);
        Vector[] vectors3 = new Vector[]{vector6, vector7};


        try {
            // 2x2 matrix with 2 pivots
            matrix1 = new Matrix(vectors1);
            // 2x3 matrix with 2 pivots
            matrix2 = new Matrix(vectors2);
            // 2x2 matrix with 1 pivot
            matrix3 = new Matrix(vectors3);
        } catch (Exception e) {
            System.out.println("Hey man, you messed up your setup test. Cmon.");
        }
    }

    @Test
    public void TestSolve2x2() {
        try {
            gauss.RowReduce(matrix1);
            gauss.RowReduce(matrix3);
            // Correct answer:
            // 1 6
            // 0 1
            System.out.print(matrix1.generateMessage());
            // Correct answer:
            // 1 2
            // 0 0
            System.out.print(matrix3.generateMessage());

            gauss.BackSubstitute(matrix1);
            gauss.BackSubstitute(matrix3);
            // Correct answer:
            // 1 0
            // 0 1
            System.out.print(matrix1.generateMessage());
            // Correct answer:
            // 1 2
            // 0 0
            System.out.print(matrix3.generateMessage());
        } catch (MatrixOperationException e) {
            fail();
        }

    }

    @Test
    public void TestSolve2x3() {
        try {
            gauss.RowReduce(matrix2);
            // Correct answer:
            // 1 -4 -9
            // 0 1 -0.33
            System.out.print(matrix2.generateMessage());
            gauss.BackSubstitute(matrix2);
            // Correct answer:
            // 1 0 -9
            // 0 1 -0.33
            System.out.print(matrix2.generateMessage());
        } catch (MatrixOperationException e) {
            fail();
        }

    }





}
