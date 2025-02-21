package mrrock.com.touristguidedel2.Repository;


import mrrock.com.touristguidedel2.Model.Tags;
import mrrock.com.touristguidedel2.Model.Touristattraction;
import org.springframework.boot.autoconfigure.web.reactive.TomcatReactiveWebServerFactoryCustomizer;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristattractionRepository {
    private List<Touristattraction> touristattractionList = new ArrayList<>();


    private Tags[] testTags = {Tags.BIOGRAF,Tags.KULTURELT};

    public TouristattractionRepository() {
        touristattractionList.add(new Touristattraction("Tivoli","Ost",testTags));
        touristattractionList.add(new Touristattraction("gaming","Ost",testTags));
    }

    // GET All Attractions
    public List<Touristattraction> getAllAttractions(){
        return touristattractionList;
    }

    // POST Save Attraction
    public Touristattraction saveAttraction(Touristattraction touristattraction){
        touristattractionList.add(touristattraction);
        return touristattraction;
    }

    // GET Attraction Tags
    public List<Tags> getAttractionsTags(String name) {
        List<Tags> foundTags = new ArrayList<>();
        for (Touristattraction attractions : touristattractionList) {
            if (attractions.getName().equalsIgnoreCase(name)) {
                for (Tags t : attractions.getTags()) {
                    foundTags.add(t);
                }
            }

        }
        return foundTags;
    }

    // POST Update Attraction
    public Touristattraction updateAttraction(Touristattraction touristattraction) {
        for (Touristattraction attraction : touristattractionList) {
            if (attraction.getId().equals(touristattraction.getId())) {
                attraction.setDescription(touristattraction.getDescription());
                attraction.setName(touristattraction.getName());
                attraction.setTags(touristattraction.getTags());
                attraction.setCity(touristattraction.getCity());
                return attraction;
            }
        }
        return null;
    }

    // GET Attraction By Name
    public Touristattraction getAttractionByName(String name) {
        for (Touristattraction t :touristattractionList) {
            if (name.equalsIgnoreCase(t.getName())){
                return t;
            }
        }
        return null;
    }

    // POST Delete Attraction
    public Touristattraction deleteAttraction(String name) {
        Touristattraction temp = null;
        for (Touristattraction t : touristattractionList) {
            if (t.getName().equalsIgnoreCase(name)) {
                temp = t;
                touristattractionList.remove(t);
                return temp;
            }
        }
        return temp;
    }
}
