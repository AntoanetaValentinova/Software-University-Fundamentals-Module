import java.util.Scanner;

public class StringManipulatorTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        String input = scan.nextLine();

        while (!"End".equals(input)) {
            String[] parts = input.split("\\s+");
            String command = parts[0];
            switch (command) {
                case "Translate":
                    String ch=parts[1];
                    String replacement=parts[2];
                    text=text.replaceAll(ch,replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    String check=parts[1];
                    if (text.contains(check)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String start=parts[1];
                    String toCompare=text.substring(0,start.length());
                    if (start.equals(toCompare)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text=text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    String toFind=parts[1];
                    if (text.contains(toFind)){
                    int index=text.lastIndexOf(toFind);
                    System.out.println(index);}
                    break;
                case "Remove":
                    int startIndex= Integer.parseInt(parts[1]);
                    int count= Integer.parseInt(parts[2]);
                    int endIndex=startIndex+count;
                    if (startIndex>=0&&startIndex<text.length()&&endIndex>=0&&endIndex<text.length()){
                    String one=text.substring(0,startIndex);
                    String two=text.substring(startIndex+count);
                    text=one+two;
                    System.out.println(text);}
                    break;
            }

            input = scan.nextLine();
        }
    }
}
