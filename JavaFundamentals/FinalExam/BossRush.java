import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numberOfInputs= Integer.parseInt(scan.nextLine());
        String regex="\\|(?<boss>[A-Z]{4,})\\|:#(?<tittle>[A-Za-z]+ [A-Za-z]+)#";
        Pattern pattern=Pattern.compile(regex);

        for (int i = 0; i <numberOfInputs ; i++) {
            String current=scan.nextLine();
            Matcher matcher=pattern.matcher(current);
            if (matcher.find()) {
                String name= matcher.group("boss");
                String tittle=matcher.group("tittle");
                System.out.printf("%s, The %s%n>> Strength: %d%n>> Armour: %d%n"
                        ,name,tittle, name.length(),tittle.length());
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
