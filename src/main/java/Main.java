import comporator.SortByDistinctThenName;
import model.City;

import java.text.MessageFormat;
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
        findBySimpleBruteForce(cityList);
        /*City[] cityArray = cityList.stream().toArray(City[]::new);
        City city1 = Arrays.stream(cityArray).max(Comparator.comparing(City::getPopulation)).get();
        int index = Arrays.stream(cityArray).toList().indexOf(city1);
        System.out.println("["+index+"] = "+city1.getPopulation());*/

        findCityCountByRegion(cityList);

        /*for (City city : cityArray) {
            System.out.println(city);
        }*/
        //System.out.println(cityArray);
    }

    private static void findBySimpleBruteForce(List<City> cities) {
        City[] array = new City[cities.size()];
        cities.toArray(array);
        City current = array[0];
        int index = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i].getPopulation() > current.getPopulation()) {
                current = array[i];
                index = i;
            }
        }
        System.out.println(MessageFormat.format("[{0}] = {1}", index, array[index]));
    }
    private static void findCityCountByRegion(List<City> cities){
        Map<String, Integer> cityCount = new HashMap<>();                       
        for (City city:cities){
            if(cityCount.get(city.getRegion())==null){
                cityCount.put(city.getRegion(), 1);
            } else {
                cityCount.put(city.getRegion(), cityCount.get(city.getRegion())+1);
            }

        }
        for(Map.Entry<String, Integer> entry:cityCount.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }

    }
}