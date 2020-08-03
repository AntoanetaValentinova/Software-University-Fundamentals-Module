import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfInputs= Integer.parseInt(scan.nextLine());
        String regex="^(.+)>(?<first>\\d{3})\\|(?<second>[a-z]{3})\\|(?<third>[A-Z]{3})\\|(?<fourth>[^<>]{3})<\\1$";
        Pattern pattern=Pattern.compile(regex);

        String result="";
        for (int i = 0; i <numberOfInputs ; i++) {
            String current=scan.nextLine();
            Matcher matcher=pattern.matcher(current);
            if (matcher.find()) {
                result=matcher.group("first")+matcher.group("second")+matcher.group("third")+matcher.group("fourth");
                System.out.println("Password: "+result);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
