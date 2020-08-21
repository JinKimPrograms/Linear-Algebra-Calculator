import exceptions.VectorOperationException;
import fundamentals.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class VectorTest {

    Vector vector1;
    Vector vector2;
    Vector vector3;

    @BeforeEach
    public void setupTests(){
        double[] test1 = new double[]{1, 3, 5};
        vector1 = new Vector(test1);

        double[] test2 = new double[]{};
        vector2 = new Vector(test2);

        double[] test3 = new double[]{2, 5, 7};
        vector3 = new Vector(test3);
    }

    @Test
    public void testConstructor(){
        assertEquals(vector1.getNumRows(), 3);
        assertEquals(vector2.getNumRows(), 0);

        double[] temp = vector1.getElements();
        assertEquals(temp[0], 1, 0.1);
        assertEquals(temp[1], 3, 0.1);
        assertEquals(temp[2], 5, 0.1);
    }

    @Test
    public void testVectorAddSubNormal(){
        try {
            vector1.subVector(vector3);
            double[] temp = vector1.getElements();
            assertEquals(temp[0], -1, 0.1);
            assertEquals(temp[1], -2, 0.1);
            assertEquals(temp[2], -2, 0.1);
        } catch (VectorOperationException e) {
            fail();
        }

        try {
            vector1.addVector(vector3);
            double[] temp = vector1.getElements();
            assertEquals(temp[0], 1, 0.1);
            assertEquals(temp[1], 3, 0.1);
            assertEquals(temp[2], 5, 0.1);
        } catch (VectorOperationException e) {
            fail();
        }
    }

    @Test
    public void testVectorAddSubException() {
        try {
            vector1.subVector(vector2);
            fail();
        } catch (VectorOperationException e) {
            try {
                vector1.addVector(vector2);
               fail();
            } catch (VectorOperationException e2) {
                // Success!
            }
        }
    }

    @Test
    public void testGenerateString() {
        assertEquals(vector2.generateMessage(), "{}");
        assertEquals(vector1.generateMessage(), "{1, 3, 5, }");
    }








}
