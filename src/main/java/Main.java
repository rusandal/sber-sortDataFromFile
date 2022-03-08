import comporator.SortByDistinctThenName;
import comporator.SortByName;
import model.City;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                "city_ru.csv"));
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<City> cityList = new LinkedList<>();
        while ((line = reader.readLine()) != null) {
            City city = new City();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                switch (index) {
                    case 1:
                        city.setName(data);
                        break;
                    case 2:
                        city.setRegion(data);
                        break;
                    case 3:
                        city.setDistinct(data);
                        break;
                    case 4:
                        city.setPopulation(Integer.parseInt(data));
                        break;
                    case 5:
                        city.setFoundation(data);
                        break;
                }
                index++;
            }
            index = 0;
            cityList.add(city);
        }
        reader.close();
        //Collections.sort(cityList, new SortByName().reversed());
        Collections.sort(cityList, new SortByDistinctThenName());
        for (City city : cityList) {
            System.out.println(city);
        }
    }
}