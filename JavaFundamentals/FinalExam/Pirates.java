import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine().replaceAll(" ","");

        Map<String, Integer> populations = new LinkedHashMap<>();
        Map<String, Integer> golds = new TreeMap<>();
        while (!"Sail".equals(input)) {
            String[] parts = input.split("\\|\\|");
            String city = parts[0];
            int population = Integer.parseInt(parts[1]);
            int gold = Integer.parseInt(parts[2]);
            populations.putIfAbsent(city, 0);
            golds.putIfAbsent(city, 0);
            int newPopulation = populations.get(city) + population;
            int newGold = golds.get(city) + gold;
            populations.put(city, newPopulation);
            golds.put(city, newGold);
            input = scan.nextLine().replaceAll(" ","");
        }

        input = scan.nextLine().replaceAll(" ","");
        while (!"End".equals(input)) {
            String[] parts = input.split("=>");
            String command = parts[0];
            String city = parts[1];
            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(parts[2]);
                    int gold = Integer.parseInt(parts[3]);
                    int newPopulation = populations.get(city) - people;
                    int newGold = golds.get(city) - gold;
                    populations.put(city, newPopulation);
                    golds.put(city, newGold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);
                    if (newPopulation <= 0 || newGold <= 0) {
                        populations.remove(city);
                        golds.remove(city);
                        System.out.printf("%s has been wiped off the map!%n", city);
                    }
                    break;
                case "Prosper":
                    int goldAdd = Integer.parseInt(parts[2]);
                    if (goldAdd < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int increasedGold = golds.get(city) + goldAdd;
                        golds.put(city, increasedGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldAdd, city, increasedGold);
                    }
                    break;
            }
            input = scan.nextLine().replaceAll(" ","");
        }

        if (golds.size() == 0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", golds.size());
            golds
                    .entrySet()
                    .stream()
                    .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
                    .forEach(c -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", c.getKey(), populations.get(c.getKey()), c.getValue()));
        }
    }
}
