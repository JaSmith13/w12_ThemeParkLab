import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<IReviewed> attractions;

    public ThemePark() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(IReviewed attraction){
        attractions.add(attraction);
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return attractions;
    }

    public void visit(Visitor visitor, Attraction attraction){
        visitor.visitAttraction(attraction);
        attraction.incrementVisitCount();
    }

    public HashMap<String, Integer> getReviews() {
        HashMap reviews = new HashMap<String, Integer>();
        for (IReviewed attraction : this.getAllReviewed()) {
            reviews.put(attraction.getName(), attraction.getRating());
        }
        return reviews;
    }
}
