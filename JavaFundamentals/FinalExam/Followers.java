import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Followers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Integer> likes = new TreeMap<>();
        Map<String, Integer> comments = new LinkedHashMap<>();
        while (!"Log out".equals(input)) {
            String[] parts = input.split(":\\s+");
            String command = parts[0];
            String username = parts[1];
            switch (command) {
                case "New follower":
                    likes.putIfAbsent(username, 0);
                    comments.putIfAbsent(username, 0);
                    break;
                case "Like":
                    int count = Integer.parseInt(parts[2]);
                    if (likes.containsKey(username)) {
                        int newLikes = likes.get(username) + count;
                        likes.put(username, newLikes);
                    } else {
                        likes.put(username, count);
                    }
                    break;
                case "Comment":
                    if (comments.containsKey(username)) {
                        int newComments = comments.get(username) + 1;
                        comments.put(username, newComments);
                    } else {
                        comments.put(username, 1);
                    }
                    break;
                case "Blocked":
                    if (comments.containsKey(username) && likes.containsKey(username)) {
                        comments.remove(username);
                        likes.remove(username);
                    } else if (comments.containsKey(username)) {
                        comments.remove(username);
                    } else if (likes.containsKey(username)) {
                        likes.remove(username);
                    } else {
                        System.out.printf("%s doesn't exist.%n", username);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        int countFollowers = Math.max(likes.size(), comments.size());
        System.out.println(countFollowers + " followers");
        Map<String, Integer> result = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> s : comments.entrySet()) {
            if (!likes.containsKey(s.getKey())) {
                likes.put(s.getKey(), 0);
            }
        }
        likes
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    if (comments.containsKey(e.getKey())) {
                        result.put(e.getKey(), (e.getValue() + comments.get(e.getKey())));
                    } else {
                        result.putIfAbsent(e.getKey(), e.getValue());
                    }
                });

        result
                .entrySet()
                .stream()
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
