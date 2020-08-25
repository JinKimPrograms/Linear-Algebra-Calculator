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

        double[] test3 = new double[]{-2, -1};
        vector3 = new Vector(test3);
        double[] test4 = new double[]{-3, 4};
        vector4 = new Vector(test4);
        double[] test5 = new double[]{1, 9};
        vector5 = new Vector(test5);
        Vector[] vectors2 = new Vector[]{vector3, vector4, vector5};


        try {
            matrix1 = new Matrix(vectors1);
            matrix2 = new Matrix(vectors2);
        } catch (Exception e) {
            System.out.println("Hey man, you messed up your setup test. Cmon.");
        }
    }

    @Test
    public void TestSolve2x2() {
        try {
            gauss.Solve(matrix1);
        } catch (MatrixOperationException e) {
            fail();
        }

        // Correct answer:
        // 1 6
        // 0 1
        System.out.print(matrix1.generateMessage());
    }

    @Test
    public void TestSolve2x3() {
        try {
            gauss.Solve(matrix2);
        } catch (MatrixOperationException e) {
            fail();
        }

        System.out.print(matrix2.generateMessage());
    }



}
