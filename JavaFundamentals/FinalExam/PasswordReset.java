import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        String commands=scan.nextLine();

        while (!"Done".equals(commands)) {
            String [] command=commands.split("\\s+");
            String currentCommand=command[0];
            switch (currentCommand) {
                case "TakeOdd":
                    String temp="";
                    for (int i = 0; i <input.length() ; i++) {
                        if (i%2!=0) {
                            String currentSymbol=""+input.charAt(i);
                            temp+=currentSymbol;
                        }
                    }
                    input=temp;
                    System.out.println(input);
                    break;
                case "Cut":
                    int index= Integer.parseInt(command[1]);
                    int length= Integer.parseInt(command[2]);
                    String firstPart=input.substring(0,index);
                    String secondPart=input.substring(index+length);
                    input=firstPart+secondPart;
                    System.out.println(input);
                    break;
                case "Substitute":
                    String substring=command[1];
                    String substitute=command[2];
                    if (input.contains(substring)) {
                        input=input.replaceAll(substring,substitute);
                        System.out.println(input);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            commands=scan.nextLine();
        }

        System.out.printf("Your password is: %s",input);
    }
}


