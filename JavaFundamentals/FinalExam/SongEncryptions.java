import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryptions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String regexArtist = "^[A-Z][a-z' ]+$";
        String regexSong = "^[A-Z ]+$";
        Pattern patternArtist = Pattern.compile(regexArtist);
        Pattern patternSong = Pattern.compile(regexSong);

        while (!"end".equals(input)) {
            String[] parts = input.split(":");
            String artist = parts[0];
            String song = parts[1];
            Matcher matcherArtist = patternArtist.matcher(artist);
            Matcher matcherSong = patternSong.matcher(song);
            if (matcherArtist.find() && matcherSong.find()) {
                String result = "";
                int key = artist.length();
                input = input.replaceAll(":", "@");
                for (int i = 0; i < artist.length(); i++) {
                    char currentSymbol = artist.charAt(i);
                    if (currentSymbol != ' ' && currentSymbol != '\'') {
                    int newValue = currentSymbol + key;
                    if (Character.isUpperCase(currentSymbol) && newValue > 90) {
                        newValue = newValue - 26;
                    }
                    if (Character.isLowerCase(currentSymbol) && newValue > 122) {
                        newValue = newValue - 26;
                    }
                    currentSymbol = (char) newValue;
                    }
                    result = result + currentSymbol;
                }
                result = result + "@";
                for (int i = 0; i < song.length(); i++) {
                    char currentSymbol = song.charAt(i);
                    if (currentSymbol != ' ' && currentSymbol != '\'') {
                    int newValue = currentSymbol + key;
                    if (Character.isUpperCase(currentSymbol) && newValue > 90) {
                        newValue = newValue - 26;
                    }
                    if (Character.isLowerCase(currentSymbol) && newValue > 122) {
                        newValue = newValue - 26;
                    }
                    currentSymbol = (char) newValue;
                    }
                    result=result+currentSymbol;
                }
                System.out.println("Successful encryption: " + result);
            } else {
                System.out.println("Invalid input!");
            }
            input = scan.nextLine();
        }
    }
}
