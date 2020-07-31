import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String email = scan.nextLine();
        String input=scan.nextLine();

        while (!"Complete".equals(input)) {
            String[] parts = input.split(" ");
            String command = parts[0];
            switch (command) {
                case "Make":
                    String caseType = parts[1];
                    switch (caseType) {
                        case "Upper":
                            email=email.toUpperCase();
                            System.out.println(email);
                            break;
                        case "Lower":
                            email=email.toLowerCase();
                            System.out.println(email);
                            break;
                    }
                    break;
                case "GetDomain":
                    int count= Integer.parseInt(parts[1]);
                    StringBuilder domain=new StringBuilder();
                    int counter=email.length()-1;
                    for (int i = 0; i <count ; i++) {
                        domain.append(email.charAt(counter));
                        counter--;
                    }
                    System.out.println(domain.reverse());
                    break;
                case "GetUsername":
                    if (email.contains("@")) {
                        int index=email.indexOf("@");
                        String username=email.substring(0,index);
                        System.out.println(username);
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n",email);
                    }
                    break;
                case "Replace":
                    String toReplace=parts[1];
                    email=email.replaceAll(toReplace,"-");
                    System.out.println(email);
                    break;
                case "Encrypt":
                    for (int i = 0; i <email.length() ; i++) {
                        int current=email.charAt(i);
                        System.out.printf("%d ",current);
                    }
                    break;
            }
            input=scan.nextLine();
        }
    }
}
