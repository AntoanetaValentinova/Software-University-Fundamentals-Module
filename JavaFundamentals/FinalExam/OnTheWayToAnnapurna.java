import java.util.*;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, List<String>> stores = new LinkedHashMap<>();
        while (!"End".equalsIgnoreCase(input)) {
            String[] parts = input.split("->");
            String command = parts[0];
            switch (command) {
                case "Add":
                    String store = parts[1];
                    String[] item = parts[2].split(",");
                    stores.putIfAbsent(store, new ArrayList<>());
                    List<String> items = stores.get(store);
                    for (int i = 0; i < item.length; i++) {
                        String current = item[i];
                        items.add(current);
                    }
                    stores.put(store, items);
                    break;
                case "Remove":
                    String storeToRemove = parts[1];
                    if (stores.containsKey(storeToRemove)) {
                        stores.remove(storeToRemove);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println("Stores list:");
        stores
                .entrySet()
                .stream()
                .sorted((s1, s2) -> {
                    int result = Integer.compare(s2.getValue().size(), s1.getValue().size());
                    if (result == 0) {
                        result = s2.getKey().compareTo(s1.getKey());
                    }
                    return result;
                })
                .forEach(s -> {
                    System.out.println(s.getKey());
                    s.getValue().stream().forEach(i-> System.out.println(String.format("<<%s>>",i)));
                });
    }
}
