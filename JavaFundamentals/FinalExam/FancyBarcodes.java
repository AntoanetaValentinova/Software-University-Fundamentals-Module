import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());
        String regex="^([@][#]+)[A-Z][A-Za-z0-9]{4,}[A-Z][@][#]+$";
        Pattern pattern=Pattern.compile(regex);

        for (int i = 0; i <n ; i++) {
            String currentBarcode=scan.nextLine();
            Matcher matcher=pattern.matcher(currentBarcode);
            if (!matcher.find()) {
                System.out.println("Invalid barcode");
            } else {
                String group="";
                for (int j = 0; j <currentBarcode.length() ; j++) {
                    char symbol=currentBarcode.charAt(j);
                    if (Character.isDigit(symbol)) {
                        group+=symbol;
                    }
                }
                if(group.length()==0) {
                    group="00";
                }
                System.out.printf("Product group: %s%n",group);
            }
        }
    }
}
