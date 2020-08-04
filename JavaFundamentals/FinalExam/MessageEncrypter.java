import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfInputs= Integer.parseInt(scan.nextLine());

        String regex="([*@])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<letterOne>[A-Za-z])\\]\\|\\[(?<letterTwo>[A-Za-z])\\]\\|\\[(?<letterThree>[A-Za-z])\\]\\|$";
        Pattern pattern=Pattern.compile(regex);

        for (int i = 0; i <numberOfInputs ; i++) {
            String current=scan.nextLine();
            Matcher matcher=pattern.matcher(current);
            if (matcher.find()) {
                String tag=matcher.group("tag");
                int letterOne=matcher.group("letterOne").charAt(0);
                int letterTwo=matcher.group("letterTwo").charAt(0);
                int letterThree=matcher.group("letterThree").charAt(0);
                System.out.printf("%s: %d %d %d%n",tag,letterOne,letterTwo,letterThree);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
