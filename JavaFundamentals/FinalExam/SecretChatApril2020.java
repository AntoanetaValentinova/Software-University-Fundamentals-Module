import java.util.Scanner;

public class SecretChatApril2020 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        StringBuilder sb=new StringBuilder(text);
        String command = scan.nextLine();

        while (!"Reveal".equals(command)) {
            String[] currentCommand = command.split(":\\|:");
            String com = currentCommand[0];
            switch (com) {
                case "InsertSpace":
                    int index= Integer.parseInt(currentCommand[1]);
                    sb.insert(index," ");
                    System.out.println(sb);
                    break;
                case "Reverse":
                    StringBuilder substring=new StringBuilder(currentCommand[1]);
                    if (sb.toString().contains(substring)) {
                        int startIndex=sb.indexOf(substring.toString());
                        sb.delete(startIndex,startIndex+substring.length());
                        substring.reverse();
                        sb.append(substring);
                        System.out.println(sb);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substr=currentCommand[1];
                    String toReplace=currentCommand[2];
                    sb=new StringBuilder(sb.toString().replaceAll(substr,toReplace));
                    System.out.println(sb);
                    break;
            }

            command = scan.nextLine();
        }
        System.out.printf("You have a new text message: %s",sb);
    }
}
