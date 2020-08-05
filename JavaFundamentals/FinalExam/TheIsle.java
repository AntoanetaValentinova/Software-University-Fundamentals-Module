import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsle {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String regex = "^([#*&%$])(?<racer>[A-Za-z]+)\\1=(?<lengthGeohashCode>\\d+)!!(?<geohashCode>.+)$";
        Pattern pattern = Pattern.compile(regex);
        while (true)
        {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find())
            {
                String racer = matcher.group("racer");
                int lengthGeohashCode = Integer.parseInt(matcher.group("lengthGeohashCode"));
                String geohashCode = matcher.group("geohashCode");

                racer = cleanString(racer);
                geohashCode = increase(geohashCode, lengthGeohashCode);

                if (lengthGeohashCode == geohashCode.length())
                {
                    System.out.println("Coordinates found! " + racer + " -> " + geohashCode);
                    break;
                }
                else
                {
                    System.out.println("Nothing found!");
                }
            }
            else
            {
                System.out.println("Nothing found!");
            }
        }
    }

    private static String cleanString(String str)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            char symbol = str.charAt(i);
            if (Character.isLetter(symbol) || symbol == ' ')
            {
                sb.append(symbol);
            }
        }
        return sb.toString();
    }

    private static String increase(String str, int lenght)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            char symbol = str.charAt(i);
            symbol = (char)(symbol + lenght);
            sb.append(symbol);
        }
        return sb.toString();
    }
}