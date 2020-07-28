import java.util.*;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input=scan.nextLine().split(", ");
        Map<String,Integer> participants=new LinkedHashMap<>();
        for (int i = 0; i <input.length ; i++) {
            participants.put(input[i],0);
        }

        String newInput=scan.nextLine();

        while (!"end of race".equals(newInput)) {
            String name="";
            int km=0;
            for (int i = 0; i <newInput.length() ; i++) {
                char currentCharacter=newInput.charAt(i);
                if (Character.isAlphabetic(currentCharacter)) {
                    name=name+currentCharacter;
                } else if (Character.isDigit(currentCharacter)) {
                    int currentKm= Integer.parseInt(""+currentCharacter);
                    km+=currentKm;
                }
            }
            if (participants.containsKey(name)) {
                int newKm=participants.get(name)+km;
                participants.put(name,newKm);
            }
            newInput=scan.nextLine();
        }

        Map<String,Integer> sortedMap=new LinkedHashMap<>();
        participants
                .entrySet()
                .stream()
                .sorted((r1,r2)->Integer.compare(r2.getValue(),r1.getValue()))
                .forEach(r->sortedMap.put(r.getKey(),r.getValue()));


        System.out.printf("1st place: %s%n",sortedMap.keySet().toArray()[0]);
        System.out.printf("2nd place: %s%n",sortedMap.keySet().toArray()[1]);
        System.out.printf("3rd place: %s%n",sortedMap.keySet().toArray()[2]);
    }
}
