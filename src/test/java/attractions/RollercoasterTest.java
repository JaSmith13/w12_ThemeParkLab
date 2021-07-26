package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canRideIfOver145cmAndOver12YearsOld(){
        Visitor visitor = new Visitor(14, 150, 0);
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void cannotRideIfUnder145cmAndUnder12YearsOld(){
        Visitor visitor = new Visitor(11, 130, 0);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void cannotRideIfUnder145cmAndOver12YearsOld(){
        Visitor visitor = new Visitor(14, 140, 0);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }
}
