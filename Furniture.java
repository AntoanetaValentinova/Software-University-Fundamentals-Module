import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input =scan.nextLine();
        String regex="^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$";
        Pattern pattern=Pattern.compile(regex);

        System.out.println("Bought furniture:");
        double totalMoney=0;
        while (!input.equals("Purchase")) {
            Matcher matcher=pattern.matcher(input);
            if (matcher.find()) {
                String name=matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity= Integer.parseInt(matcher.group("quantity"));
                System.out.println(name);
                double currentMoney=price*quantity;
                totalMoney+=currentMoney;
            }
            input=scan.nextLine();
        }

        System.out.printf("Total money spend: %.2f",totalMoney);
    }
}
