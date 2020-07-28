import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();
        String regex="^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$";
        Pattern pattern= Pattern.compile(regex);

        double totalIncome=0;
        while(!"end of shift".equals(input)) {
            Matcher matcher=pattern.matcher(input);
            if (matcher.find()) {
                int count= Integer.parseInt(matcher.group("count"));
                double price= Double.parseDouble(matcher.group("price"));
                double totalPrice= count*price;
                System.out.printf("%s: %s - %.2f%n",matcher.group("name"),matcher.group("product"),totalPrice);
                totalIncome+=totalPrice;
            }
            input=scan.nextLine();
        }
        System.out.printf("Total income: %.2f",totalIncome);
    }
}
