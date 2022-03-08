package comporator;

import model.City;

import java.util.Comparator;

public class SortByDistinctThenName implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        if (o1.getDistinct().compareTo(o2.getDistinct()) == 0) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        } else {
            return o1.getDistinct().compareTo(o2.getDistinct());
        }
    }
}
