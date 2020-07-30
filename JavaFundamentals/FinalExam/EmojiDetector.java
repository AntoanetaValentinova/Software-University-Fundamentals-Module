import java.awt.image.AreaAveragingScaleFilter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text=scan.nextLine();
        String regex="([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})(\\1)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        String regexDigit="[\\d]";
        Pattern patternDigit=Pattern.compile(regexDigit);
        Matcher matcherDigit=patternDigit.matcher(text);

        BigInteger coolness=new BigInteger("1");
        while (matcherDigit.find()) {
            BigInteger currentDigit= BigInteger.valueOf(Integer.parseInt(matcherDigit.group()));
            coolness=coolness.multiply(currentDigit);
        }

        int counterEmojies=0;
        List<String> coolOnes=new ArrayList<>();
        while (matcher.find()) {
            counterEmojies++;
            String currentEmoji=matcher.group("emoji");
            BigInteger sumEmoji=new BigInteger("0");
            for (int i = 0; i <currentEmoji.length() ; i++) {
                int currentValue=currentEmoji.charAt(i);
                sumEmoji=sumEmoji.add(BigInteger.valueOf(currentValue));
            }
            if  (sumEmoji.compareTo(coolness)>0) {
                coolOnes.add(matcher.group());
            }
        }
        System.out.printf("Cool threshold: %d%n",coolness);
        System.out.printf("%d emojis found in the text. The cool ones are:%n",counterEmojies);
        if (coolOnes.size()>0) {
            for (String coolOne : coolOnes) {
                System.out.println(coolOne);
            }
        }
    }
}
