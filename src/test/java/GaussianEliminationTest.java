import algorithms.GaussianElimination;
import exceptions.MatrixOperationException;
import fundamentals.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GaussianEliminationTest {

    Vector vector1;
    Vector vector2;
    Vector vector3;
    Vector vector4;
    Vector[] columns;
    Matrix matrix;

    @BeforeEach
    public void setupTests(){
        double[] test1 = new double[]{1, 1, 3};
        vector1 = new Vector(test1);

        double[] test2 = new double[]{3, 1, 11};
        vector2 = new Vector(test2);

        double[] test3 = new double[]{1, -1, 5};
        vector3 = new Vector(test3);

        double[] test4 = new double[]{9, 1, 35};
        vector4 = new Vector(test4);

        columns = new Vector[]{vector1, vector2, vector3, vector4};
        try {
            matrix = new Matrix(columns);
        } catch (MatrixOperationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testConstructor(){
        GaussianElimination manager = new GaussianElimination();
        manager.Solve(matrix);
        System.out.print(matrix.generateMessage());
    }

}
