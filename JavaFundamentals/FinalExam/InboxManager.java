import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, List<String>> users = new TreeMap<>();
        while (!"Statistics".equals(input)) {
            String[] parts = input.split("->");
            String command = parts[0];
            String username = parts[1];
            switch (command) {
                case "Add":
                    if (users.containsKey(username)) {
                        System.out.printf("%s is already registered%n", username);
                    } else {
                        users.put(username, new ArrayList<>());
                    }
                    break;
                case "Send":
                    String email = parts[2];
                    List<String> emails = users.get(username);
                    emails.add(email);
                    users.put(username, emails);
                    break;
                case "Delete":
                    if (users.containsKey(username)) {
                        users.remove(username);
                    } else {
                        System.out.printf("%s not found!%n", username);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        System.out.printf("Users count: %d%n", users.size());

        users
                .entrySet()
                .stream()
                .sorted((u1, u2) -> Integer.compare(u2.getValue().size(), u1.getValue().size()))
                .forEach(u -> {
                    System.out.println(u.getKey());
                    u.getValue().stream().forEach(e -> System.out.printf(" - %s%n", e));
                });
    }
}
