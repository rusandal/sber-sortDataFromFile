package comporator;

import model.City;

import java.util.Comparator;

public class SortByName implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
