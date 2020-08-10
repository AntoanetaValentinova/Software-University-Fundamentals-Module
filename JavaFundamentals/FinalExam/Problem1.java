import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String stops = scan.nextLine();

        String input = scan.nextLine();
        while (!"Travel".equals(input)) {
            String[] parts = input.split(":");
            String command = parts[0];
            switch (command) {
                case "Add Stop":
                    int index= Integer.parseInt(parts[1]);
                    String string=parts[2];
                    StringBuilder sb=new StringBuilder(stops);
                    if (index>=0&&index<stops.length()) {
                        sb.insert(index,string);
                        stops=sb.toString();
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex= Integer.parseInt(parts[1]);
                    int endIndex= Integer.parseInt(parts[2]);
                    if (startIndex>=0&&startIndex<stops.length()&&endIndex>=0&&endIndex<stops.length()) {
                        String one=stops.substring(0,startIndex);
                        String two=stops.substring(endIndex+1);
                        stops=one+two;
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString=parts[1];
                    String newString=parts[2];
                    if (stops.contains(oldString)) {
                        stops=stops.replaceAll(oldString,newString);
                    }
                    System.out.println(stops);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: "+stops);
    }
}
