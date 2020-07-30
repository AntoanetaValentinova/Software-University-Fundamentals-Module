import java.util.Scanner;

public class ActivationKey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String activationKey = scan.nextLine();

        String input = scan.nextLine();

        while (!"Generate".equals(input)) {
            String[] parts = input.split(">>>");
            String command = parts[0];
            switch (command) {
                case "Contains":
                    String substring=parts[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n",activationKey,substring);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String caseUL=parts[1];
                    int startIndex= Integer.parseInt(parts[2]);
                    int endIndex= Integer.parseInt(parts[3]);
                    String toReplace=activationKey.substring(startIndex,endIndex);
                    String newString="";
                    if ("Upper".equals(caseUL)) {
                        newString=toReplace.toUpperCase();
                    } else if ("Lower".equals(caseUL)){
                        newString=toReplace.toLowerCase();
                    }
                    activationKey=activationKey.replace(toReplace,newString);
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int startIndexx= Integer.parseInt(parts[1]);
                    int endIndexx= Integer.parseInt(parts[2]);
                    String first=activationKey.substring(0,startIndexx);
                    String second=activationKey.substring(endIndexx);
                    activationKey=first+second;
                    System.out.println(activationKey);
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println("Your activation key is: "+activationKey);
    }
}
