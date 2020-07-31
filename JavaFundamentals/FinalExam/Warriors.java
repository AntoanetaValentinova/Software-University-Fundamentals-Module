import java.util.Scanner;

public class Warriors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String skill = scan.nextLine();

        String input = scan.nextLine();

        while (!"For Azeroth".equals(input)) {
            String[] parts = input.split(" ");
            String command = parts[0];
            switch (command) {
                case "GladiatorStance":
                    skill = skill.toUpperCase();
                    System.out.println(skill);
                    break;
                case "DefensiveStance":
                    skill = skill.toLowerCase();
                    System.out.println(skill);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(parts[1]);
                    String letter = parts[2];
                    if (index >= 0 && index < skill.length()) {
                        StringBuilder sb = new StringBuilder(skill);
                        sb.replace(index, index + 1, letter);
                        skill = sb.toString();
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }
                    break;
                case "Target":
                    String substring = parts[2];
                    String currentCommand = parts[1];
                    switch (currentCommand) {
                        case "Change":
                            if (skill.contains(substring)) {
                                String secondSubstring = parts[3];
                                skill = skill.replaceAll(substring, secondSubstring);
                                System.out.println(skill);
                            }
                            break;
                        case "Remove":
                            if (skill.contains(substring)) {
                                String one = skill.substring(0, skill.indexOf(substring));
                                String two = skill.substring(skill.indexOf(substring) + substring.length());
                                skill = one + two;
                                System.out.println(skill);
                            }
                            break;
                        default:
                            System.out.println("Command doesn't exist!");
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");

            }
            input = scan.nextLine();
        }
    }
}
