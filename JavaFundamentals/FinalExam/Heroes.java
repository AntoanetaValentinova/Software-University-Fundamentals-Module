import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Heroes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scan.nextLine());

        Map<String, Integer> HPs = new TreeMap<>();
        Map<String, Integer> MPs = new LinkedHashMap<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            String[] parts = scan.nextLine().split("\\s+");
            String name = parts[0];
            int HP = Integer.parseInt(parts[1]);
            int MP = Integer.parseInt(parts[2]);
            if (HP > 100) {
                HPs.put(name, 100);
            } else {
                HPs.put(name, HP);
            }
            if (MP > 200) {
                MPs.put(name, 200);
            } else {
                MPs.put(name, MP);
            }
        }
        String input = scan.nextLine();

        while (!"End".equals(input)) {
            String[] parts = input.split(" - ");
            String command = parts[0];
            String name = parts[1];
            switch (command) {
                case "CastSpell":
                    int mpNeeded= Integer.parseInt(parts[2]);
                    String spellName=parts[3];
                    if (mpNeeded<=MPs.get(name)) {
                        int newMp=MPs.get(name)-mpNeeded;
                        MPs.put(name,newMp);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",name,spellName,newMp);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n",name,spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage= Integer.parseInt(parts[2]);
                    String attacker=parts[3];
                    int newHP=HPs.get(name)-damage;
                    HPs.put(name,newHP);
                    if (newHP>0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",name,damage,attacker,newHP);
                    } else {
                        HPs.remove(name);
                        MPs.remove(name);
                        System.out.printf("%s has been killed by %s!%n",name,attacker);
                    }
                    break;
                case "Recharge":
                    int amount= Integer.parseInt(parts[2]);
                    int newM=MPs.get(name)+amount;
                    if (newM<=200) {
                        MPs.put(name,newM);
                    } else {
                        amount=200-MPs.get(name);
                        MPs.put(name,200);
                    }
                    System.out.printf("%s recharged for %d MP!%n",name,amount);
                    break;
                case "Heal":
                    int amountHp= Integer.parseInt(parts[2]);
                    int newH=HPs.get(name)+amountHp;
                    if (newH<=100) {
                        HPs.put(name,newH);
                    } else {
                        amountHp=100-HPs.get(name);
                        HPs.put(name,100);
                    }
                    System.out.printf("%s healed for %d HP!%n",name,amountHp);
                    break;
            }
            input = scan.nextLine();
        }
        HPs
                .entrySet()
                .stream()
                .sorted((h1,h2)->h2.getValue().compareTo(h1.getValue()))
                .forEach(h-> System.out.printf("%s%n  HP: %d%n  MP: %d%n",h.getKey(),h.getValue(),MPs.get(h.getKey())));
    }
}
