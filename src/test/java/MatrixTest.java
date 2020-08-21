//
//import exceptions.MatrixOperationException;
//import fundamentals.Matrix;
//import fundamentals.Vector;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//public class MatrixTest {
//
//    Vector vector1;
//    Vector vector2;
//    Vector vector3;
//    Vector vector4;
//
//    Matrix matrix1;
//    Matrix matrix2;
//    Matrix matrix3;
//
//    @BeforeEach
//    public void setupTests()  {
//        double[] test1 = new double[]{1, 3};
//        vector1 = new Vector(test1);
//        double[] test2 = new double[]{6, 9};
//        vector2 = new Vector(test1);
//        Vector[] vectors1 = new Vector[]{vector1, vector2};
//
//        double[] test3 = new double[]{-2, -1};
//        vector3 = new Vector(test1);
//        double[] test4 = new double[]{-3, 4};
//        vector4 = new Vector(test1);
//        Vector[] vectors2 = new Vector[]{vector3, vector4};
//
//        try {
//            Matrix matrix1 = new Matrix(vectors1);
//            Matrix matrix2 = new Matrix(vectors2);
//            Matrix matrix3 = new Matrix(new Vector[]{});
//        } catch (Exception e) {
//            System.out.println("Hey man, you messed up your setup test. Cmon.");
//        }
//    }
//
//    @Test
//    public void testConstructor() {
//        assertEquals(matrix1.getNumRows(), 2);
//        Vector column1 = matrix1.getColumns()[0];
//        Vector column2 = matrix1.getColumns()[1];
//
//        assertEquals(column1, 0);
//    }
//
//}
//
