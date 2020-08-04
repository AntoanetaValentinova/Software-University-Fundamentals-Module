import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MessageManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capacity = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();

        Map<String, Integer> usernameSent = new LinkedHashMap<>();
        Map<String, Integer> usernameReceived = new TreeMap<>();

        while (!"Statistics".equals(input)) {
            String[] parts = input.split("=");
            String command = parts[0];
            switch (command) {
                case "Add":
                    String username=parts[1];
                    int sent= Integer.parseInt(parts[2]);
                    int received= Integer.parseInt(parts[3]);
                    usernameSent.putIfAbsent(username,sent);
                    usernameReceived.putIfAbsent(username,received);
                    break;
                case "Message":
                    String sender=parts[1];
                    String receiver=parts[2];
                    if (usernameSent.containsKey(sender)&&usernameSent.containsKey(receiver)) {
                        int increasedSend=usernameSent.get(sender)+1;
                        int increasedReceived=usernameReceived.get(receiver)+1;
                        usernameSent.put(sender,increasedSend);
                        usernameReceived.put(receiver,increasedReceived);
                        if ((increasedSend+usernameReceived.get(sender))>=capacity) {
                            usernameReceived.remove(sender);
                            usernameSent.remove(sender);
                            System.out.println(String.format("%s reached the capacity!",sender));
                        }
                        if ((increasedReceived+usernameSent.get(receiver))>=capacity) {
                            usernameReceived.remove(receiver);
                            usernameSent.remove(receiver);
                            System.out.println(String.format("%s reached the capacity!",receiver));
                        }
                    }
                    break;
                case "Empty":
                    String usernameToRemove=parts[1];
                    if (usernameToRemove.equals("All")) {
                        usernameSent.clear();
                        usernameReceived.clear();
                    } else {
                        usernameSent.remove(usernameToRemove);
                        usernameReceived.remove(usernameToRemove);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Users count: "+usernameSent.size());
        usernameReceived
                .entrySet()
                .stream()
                .sorted((u1,u2)->u2.getValue().compareTo(u1.getValue()))
                .forEach(u-> System.out.println(String.format("%s - %d",u.getKey(),u.getValue()+usernameSent.get(u.getKey()))));
    }
}
