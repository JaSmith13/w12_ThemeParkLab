import attractions.Dodgems;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Dodgems dodgems;
    TobaccoStall tobaccoStall;
    RollerCoaster rollerCoaster;

    @Before
    public void before() {
        dodgems = new Dodgems("Dodgems", 4);
        tobaccoStall = new TobaccoStall("Jimmys Baccy", "James Dean", ParkingSpot.B1, 5);
        rollerCoaster = new RollerCoaster("Big Hurl", 5);
        themePark = new ThemePark();
        themePark.addAttraction(dodgems);
        themePark.addAttraction(tobaccoStall);
        themePark.addAttraction(rollerCoaster);
    }

    @Test
    public void canGetAllReviewed() {
        assertEquals(3, themePark.getAllReviewed().size());
    }

    @Test
    public void canVisitAttraction() {
        Visitor visitor = new Visitor(18, 180, 10);
        themePark.visit(visitor, dodgems);
        assertEquals(1, dodgems.getVisitCount());
        assertEquals(1, visitor.getVisitedAttractions().size());
    }

    @Test
    public void canGetReviews() {
        assertEquals(4, themePark.getReviews().get("Dodgems").intValue());
    }
}


