import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n=Integer.parseInt(scan.nextLine());
        String regex="@(?<name>[A-Za-z]+)[^@\\-!:>]*:(?<population>[\\d]+)[^@\\-!:>]*!(?<attack>[AD])![^@\\-!:>]*->(?<soldierCount>[\\d]+)";
        Pattern pattern=Pattern.compile(regex);

        Map<String, List<String>> planets=new TreeMap<>();
        planets.put("Attacked", new ArrayList<>());
        planets.put("Destroyed", new ArrayList<>());

        for (int i = 0; i <n ; i++) {
            String currentMessage=scan.nextLine();
            int key=0;
            for (int j = 0; j <currentMessage.length() ; j++) {
                char currentSymbol=currentMessage.charAt(j);
                if (currentSymbol=='s'||currentSymbol=='S'||currentSymbol=='t'||currentSymbol=='T'||currentSymbol=='a'
                        ||currentSymbol=='A'||currentSymbol=='r'||currentSymbol=='R') {
                    key++;
                }
            }
            String decrypedMessage="";
            for (int j = 0; j <currentMessage.length() ; j++) {
                char currentSymbol=currentMessage.charAt(j);
                int currentPosition=currentSymbol-key;
                char newSymbol= (char) currentPosition;
                decrypedMessage+=newSymbol;
            }

            Matcher matcher=pattern.matcher(decrypedMessage);
            if (matcher.find()) {
                String attackType=matcher.group("attack");
                if (attackType.equals("A")) {
                    attackType="Attacked";
                } else if (attackType.equals("D")) {
                    attackType="Destroyed";
                }
                List<String> planetsNames=planets.get(attackType);
                String planetName=matcher.group("name");
                planetsNames.add(planetName);
                planets.put(attackType,planetsNames);
            }
        }

        planets
                .entrySet()
                .stream()
                .forEach(p->{
                    System.out.printf("%s planets: %d%n",p.getKey(),p.getValue().size());
                    p
                            .getValue()
                            .stream()
                            .sorted((planetOne,planetTwo)->planetOne.compareTo(planetTwo))
                            .forEach(planet-> System.out.printf("-> %s%n",planet));
                });
    }
}
