import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();
        String regex="([=\\/])(?<name>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        List<String> destinations=new ArrayList<>();
        int travelPoints=0;

        while (matcher.find()) {
            String destination=matcher.group("name");
            destinations.add(destination);
            travelPoints=travelPoints+destination.length();
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ",destinations));
        System.out.println("Travel Points: "+travelPoints);
    }
}
