import java.util.*;

public class Hero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, List<String>> heroes=new TreeMap<>();
        while (!"End".equals(input)) {
            String[] parts = input.split(" ");
            String command = parts[0];
            String heroName = parts[1];
            switch (command) {
                case "Enroll":
                    if (heroes.containsKey(heroName)) {
                        System.out.printf("%s is already enrolled.%n",heroName);
                    } else {
                        heroes.put(heroName,new ArrayList<>());
                    }
                    break;
                case "Learn":
                    String spellName=parts[2];
                    if (heroes.containsKey(heroName)) {
                        List <String> books=heroes.get(heroName);
                        if (!books.contains(spellName)) {
                            books.add(spellName);
                            heroes.put(heroName,books);
                        } else {
                            System.out.printf("%s has already learnt %s.%n",heroName,spellName);
                        }
                    } else {
                        System.out.printf("%s doesn't exist.%n",heroName);
                    }
                    break;
                case "Unlearn":
                    List <String> books=heroes.get(heroName);
                    String spell=parts[2];
                    if (heroes.containsKey(heroName)) {
                        if (books.contains(spell)) {
                            books.remove(spell);
                        } else {
                            System.out.printf("%s doesn't know %s.%n",heroName,spell);
                        }
                    } else {
                        System.out.printf("%s doesn't exist.%n",heroName);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        System.out.println("Heroes:");
        heroes
                .entrySet()
                .stream()
                .sorted((h1,h2)->Integer.compare(h2.getValue().size(),h1.getValue().size()))
                .forEach(h->{
                    System.out.printf("== %s: ",h.getKey());
                    System.out.println(String.join(", ",h.getValue()));
                });
    }
}
