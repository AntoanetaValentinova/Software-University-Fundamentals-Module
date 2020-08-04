import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Integer> peopleHealth = new TreeMap<>();
        Map<String, Integer> peopleEnergy = new LinkedHashMap<>();

        while (!"Results".equals(input)) {
            String[] parts = input.split(":");
            String command = parts[0];
            switch (command) {
                case "Add":
                    String personName=parts[1];
                    int health= Integer.parseInt(parts[2]);
                    int energy= Integer.parseInt(parts[3]);
                    if (peopleHealth.containsKey(personName)){
                        int newHealth=peopleHealth.get(personName)+health;
                        peopleHealth.put(personName,newHealth);
                    } else {
                        peopleHealth.put(personName,health);
                        peopleEnergy.put(personName,energy);
                    }
                    break;
                case "Attack":
                    String attackerName=parts[1];
                    String defenderName=parts[2];
                    int damage= Integer.parseInt(parts[3]);
                    if (peopleHealth.containsKey(attackerName)&&peopleHealth.containsKey(defenderName)) {
                        int reducedHealth=peopleHealth.get(defenderName)-damage;
                        int reducedEnergy=peopleEnergy.get(attackerName)-1;
                        if (reducedHealth>0) {
                            peopleHealth.put(defenderName,reducedHealth);
                        } else {
                            peopleHealth.remove(defenderName);
                            peopleEnergy.remove(defenderName);
                            System.out.println(String.format("%s was disqualified!",defenderName));
                        }
                        if (reducedEnergy>0) {
                            peopleEnergy.put(attackerName,reducedEnergy);
                        } else {
                            peopleHealth.remove(attackerName);
                            peopleEnergy.remove(attackerName);
                            System.out.println(String.format("%s was disqualified!",attackerName));
                        }
                    }
                    break;
                case "Delete":
                    String username=parts[1];
                    if (username.equals("All")) {
                        peopleHealth.clear();
                        peopleEnergy.clear();
                    } else {
                        if (peopleHealth.containsKey(username)) {
                            peopleHealth.remove(username);
                            peopleEnergy.remove(username);
                        }
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("People count: "+peopleHealth.size());
        peopleHealth
                .entrySet()
                .stream()
                .sorted((p1,p2)->p2.getValue().compareTo(p1.getValue()))
                .forEach(p-> System.out.println(String.format("%s - %d - %d",p.getKey(),p.getValue(),peopleEnergy.get(p.getKey()))));
    }
}
