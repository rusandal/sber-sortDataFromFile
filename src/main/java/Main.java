import comporator.SortByDistinctThenName;
import model.City;
import java.util.*;

import static utils.CityUtils.*;

public class Main {
    public static void main(String[] args) {
        List<City> cityList = parse();

        //Сортировка по городу в обратном порядке
        //Collections.sort(cityList, new SortByName().reversed());
        //Сортировка по округу, затем по имени
        //Collections.sort(cityList, new SortByDistinctThenName());

        //Поиск индекса (города) с наибольшим количеством жителей
        City[] cityArray = cityList.stream().toArray(City[]::new);
        City city1 = Arrays.stream(cityArray).max(Comparator.comparing(City::getPopulation)).get();
        int index = Arrays.stream(cityArray).toList().indexOf(city1);
        System.out.println("["+index+"] = "+city1.getPopulation());
       /* for (City city : cityArray) {
            System.out.println(city);
        }*/
        //System.out.println(cityArray);
    }

}