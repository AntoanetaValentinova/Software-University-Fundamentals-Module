import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String string = scan.nextLine();
        String input = scan.nextLine();

        while (!"Done".equals(input)) {
            String[] parts = input.split(" ");
            String command = parts[0];
            switch (command) {
                case "Change":
                    String ch=parts[1];
                    String replacement=parts[2];
                    string=string.replaceAll(ch,replacement);
                    System.out.println(string);
                    break;
                case "Includes":
                    String text=parts[1];
                    if (string.contains(text)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String end=parts[1];
                    int length=end.length();
                    String last=string.substring(string.length()-length,string.length());
                    if (end.equals(last)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    string=string.toUpperCase();
                    System.out.println(string);
                    break;
                case "FindIndex":
                    String charr=parts[1];
                    int index=string.indexOf(charr);
                    System.out.println(index);
                    break;
                case "Cut":
                    int startIndex= Integer.parseInt(parts[1]);
                    int lengthh= Integer.parseInt(parts[2]);
                    string=string.substring(startIndex,startIndex+lengthh);
                    System.out.println(string);
                    break;
            }

            input = scan.nextLine();
        }
    }
}
