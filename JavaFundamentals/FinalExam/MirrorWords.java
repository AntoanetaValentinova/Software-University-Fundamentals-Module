import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text=scan.nextLine();
        String regex="([#@])(?<wordOne>[A-zA-z]{3,})\\1{2}(?<wordTwo>[A-Za-z]{3,})\\1";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);

        int counterMatches=0;
        List<String> pairs=new ArrayList<>();
        while(matcher.find()) {
            counterMatches++;
            StringBuilder reversed=new StringBuilder(matcher.group("wordTwo")).reverse();
            if (matcher.group("wordOne").equals(reversed.toString())) {
                String toAdd=matcher.group("wordOne")+" <=> "+matcher.group("wordTwo");
                pairs.add(toAdd);
            }
        }

        if (counterMatches==0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n",counterMatches);
        }

        if (pairs.size()==0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are: ");
            System.out.printf(String.join(", ",pairs));
        }
    }
}
