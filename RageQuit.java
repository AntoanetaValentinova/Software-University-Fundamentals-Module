import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String text=scan.nextLine();

        String regex="(?<valid>(?<string>[^0-9]+)(?<repeat>[\\d]+))";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        StringBuilder repeated=new StringBuilder();

        while (matcher.find()) {
            String toRepeat=matcher.group("string").toUpperCase();
            int timesToRepeat= Integer.parseInt(matcher.group("repeat"));
            for (int i = 0; i <timesToRepeat ; i++) {
                repeated.append(toRepeat);
            }
        }
//try
        System.out.printf("Unique symbols used: %d%n",repeated.chars().distinct().count());
        System.out.print(repeated);
    }
}
