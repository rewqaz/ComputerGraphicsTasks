package Objects;

import Objects.Ellipse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Color;

public class EllipseFillerTest {
    private Ellipse ellipseFiller;

    @Before
    public void setUp() {
        ellipseFiller = new Ellipse(200, 200, 100, 50, Color.RED, Color.BLUE);
    }

    @Test
    public void testInterpolateColor() {
        Color startColor = Color.RED;
        Color endColor = Color.BLUE;

        Color interpolatedColor = ellipseFiller.interpolateColor(0.5);

        assertEquals(127, interpolatedColor.getRed());
        assertEquals(0, interpolatedColor.getGreen());
        assertEquals(127, interpolatedColor.getBlue());
    }

    @Test
    public void testIsInsideEllipse() {
        assertTrue(ellipseFiller.isInsideEllipse(200, 200));  // Центр эллипса
        assertTrue(ellipseFiller.isInsideEllipse(250, 200));  // Внутри эллипса
        assertFalse(ellipseFiller.isInsideEllipse(350, 250)); // Снаружи эллипса
    }

    @Test
    public void testDistanceToCenter() {
        double distance = ellipseFiller.distanceToCenter(200, 200);
        assertEquals(0.0, distance, 0.1);

        distance = ellipseFiller.distanceToCenter(250, 200);
        assertEquals(50.0, distance, 0.1);
    }
}
