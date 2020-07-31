import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfInputs= Integer.parseInt(scan.nextLine());
        String regex="U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<pass>[A-Za-z]{5,}[0-9]+)P@\\$";
        Pattern pattern=Pattern.compile(regex);

        int successfulRegistrations=0;
        for (int i = 0; i <numberOfInputs ; i++) {
            String current=scan.nextLine();
            Matcher matcher=pattern.matcher(current);
            if (matcher.find()) {
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n",matcher.group("username"),matcher.group("pass"));
                successfulRegistrations++;
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.println("Successful registrations: "+successfulRegistrations);
    }
}
