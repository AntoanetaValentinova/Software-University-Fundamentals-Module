import java.util.*;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, List<String>> roads = new TreeMap<>();
        while (!"END".equals(input)) {
            String[] parts = input.split("->");
            String command = parts[0];
            String road = parts[1];
            switch (command) {
                case "Add":
                    String racer = parts[2];
                    roads.putIfAbsent(road, new ArrayList<>());
                    List<String> racers = roads.get(road);
                    racers.add(racer);
                    roads.put(road, racers);
                    break;
                case "Move":
                    String currentRacer = parts[2];
                    String nextRoad = parts[3];
                    if (roads.get(road).contains(currentRacer)) {
                        roads.get(road).remove(currentRacer);
                        roads.get(nextRoad).add(currentRacer);
                    }
                    break;
                case "Close":
                    if (roads.containsKey(road)) {
                        roads.remove(road);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Practice sessions:");
        roads
                .entrySet()
                .stream()
                .sorted((r1, r2) -> Integer.compare(r2.getValue().size(), r1.getValue().size()))
                .forEach(r -> {
                    System.out.println(r.getKey());
                    r.getValue().stream().forEach(p-> System.out.println(String.format("++%s",p)));
                });
    }
}
