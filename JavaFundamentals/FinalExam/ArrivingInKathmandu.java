import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex="^(?<name>[A-Za-z0-9!@#\\$?]+)=(?<length>[0-9]+)<<(?<geocode>.+)$";
        Pattern pattern=Pattern.compile(regex);
        String input=scan.nextLine();

        while (!"Last note".equals(input)) {
            Matcher matcher=pattern.matcher(input);
            if (matcher.find()) {
                String name=matcher.group("name");
                int length= Integer.parseInt(matcher.group("length"));
                String geocode=matcher.group("geocode");
                if (geocode.length()==length) {
                    String decrypedName="";
                    for (int i = 0; i <name.length() ; i++) {
                        char current=name.charAt(i);
                        if (Character.isLetterOrDigit(current)) {
                            decrypedName=decrypedName+current;
                        }
                    }
                    System.out.printf("Coordinates found! %s -> %s%n",decrypedName,geocode);
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }
            input=scan.nextLine();
        }
    }
}
