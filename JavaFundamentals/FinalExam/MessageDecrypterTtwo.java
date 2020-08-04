import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypterTtwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfInputs= Integer.parseInt(scan.nextLine());
        String regex="^([$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<one>\\d+)\\]\\|\\[(?<two>\\d+)\\]\\|\\[(?<three>\\d+)\\]\\|$";
        Pattern pattern=Pattern.compile(regex);

        for (int i = 0; i <numberOfInputs ; i++) {
            String current=scan.nextLine();
            Matcher matcher=pattern.matcher(current);
            if (matcher.find()) {
                String tag=matcher.group("tag");
                char one= (char)Integer.parseInt(matcher.group("one"));
                char two= (char)Integer.parseInt(matcher.group("two"));
                char three= (char)Integer.parseInt(matcher.group("three"));
                System.out.println(String.format("%s: %c%c%c",tag,one,two,three));
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
