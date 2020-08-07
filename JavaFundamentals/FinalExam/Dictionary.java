import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" \\| ");

        Map<String, List<String>> words = new TreeMap<>();
        for (int i = 0; i < input.length; i++) {
            String[] parts = input[i].split(": ");
            String word = parts[0];
            String definition = parts[1];
            words.putIfAbsent(word, new ArrayList<>());
            List<String> definitions = words.get(word);
            definitions.add(definition);
            words.put(word, definitions);
        }

        input = scan.nextLine().split(" \\| ");
        for (int i = 0; i < input.length; i++) {
            String currentWord = input[i];
            if (words.containsKey(currentWord)) {
                System.out.println(currentWord);
                words.get(currentWord).stream().sorted((d1,d2)->Integer.compare(d2.length(),d1.length()))
                        .forEach(d-> System.out.println(String.format(" -%s",d)));
            }
        }

        String finalInput=scan.nextLine();
        switch (finalInput) {
            case "End": break;
            case "List":
                words
                        .entrySet()
                        .stream()
                        .forEach(w-> System.out.print(w.getKey()+" "));break;
        }
    }
}
