import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String encryptedString=scan.nextLine();
        String [] substrings=scan.nextLine().split(" ");

        String regex="^[d-z\\{\\}\\|\\#]+$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(encryptedString);

        if (matcher.find()){
            String decrypted="";
            for (int i = 0; i <encryptedString.length() ; i++) {
                char current=encryptedString.charAt(i);
                int value=current-3;
                char newChar=(char) value;
                decrypted=decrypted+newChar;
            }
            String one=substrings[0];
            String two=substrings[1];
            decrypted=decrypted.replaceAll(one,two);
            System.out.println(decrypted);
        } else {
            System.out.println("This is not the book you are looking for.");
        }
    }
}
