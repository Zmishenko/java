package task8;

import java.util.ArrayList;
import java.util.List;

public class ClassesByProducts {

    private final List<String> category = new ArrayList<>();

    public ClassesByProducts() {
        category.add("Cars");
        category.add("Mobile_Phones");
        category.add("Movies");
        category.add("TV_shows");
    }

    public List<String> getCategory() {
        return category;
    }
}
