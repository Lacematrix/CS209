import java.io.IOException;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Practice4 {
    public static class City
    {
        private String name;
        private String state;
        private int population;

        @Override
        public String toString() {
            return "City{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", population=" + population +
                '}';
        }

        public City(String name, String state, int population)
        {
            this.name = name;
            this.state = state;
            this.population = population;

        }

        public String getName()
        {
            return name;
        }

        public String getState()
        {
            return state;
        }

        public int getPopulation()
        {
            return population;
        }

    }

    public static Stream<City> readCities(String filename) throws IOException
    {
        return Files.lines(Paths.get(filename))
                .map(l -> l.split(", "))
                .map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
    }

    public static void main(String[] args) throws IOException, URISyntaxException {

        Stream<City> cities = readCities("cities.txt");
        // Q1: count how many cities there are for each state
        // TODO: Map<String, Long> cityCountPerState = ...
        Map<String, Long> cityCountPerState = cities.collect(Collectors.groupingBy(City::getState, Collectors.counting()));
        System.out.println(cityCountPerState);


        cities = readCities("cities.txt");
        // Q2: count the total population for each state
        // TODO: Map<String, Integer> statePopulation = ...
        Map<String, Integer> statePopulation = cities.collect(Collectors.groupingBy(s->s.state, Collectors.summingInt(City::getPopulation)));
        System.out.println(statePopulation);


        cities = readCities("cities.txt");
        // Q3: for each state, get the set of cities with >500,000 population
        // TODO: Map<String, Set<City>> largeCitiesByState = ...
        Map<String, Set<City>> largeCitiesByState = cities.collect(Collectors.groupingBy(City::getState,Collectors.filtering(c -> c.getPopulation() > 500000, Collectors.toSet())));
        //largeCitiesByState.forEach(Practice4::print);
        largeCitiesByState.forEach((s, cities1) -> System.out.println(s + ": " + cities1));

    }
    public static void print(String s, Set<City> arrays){
        System.out.print(s + ": [");
        for (City city: arrays) {
            if (city.getPopulation() > 500000){
                System.out.print(city);
            }
        }
        System.out.println("]");
    }
}
