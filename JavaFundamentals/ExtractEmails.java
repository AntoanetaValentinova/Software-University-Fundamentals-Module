import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text=scan.nextLine();
        String regex="(?<=\\s)[A-Za-z0-9]+[\\._-]?[A-Za-z0-9]*@[A-Za-z]+[-]?[A-Za-z]+((\\.[A-Za-z]+[-]?[A-Za-z]+){1,})";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);

        while (matcher.find()) {
            String email=matcher.group();
            System.out.println(email);
        }
    }
}
