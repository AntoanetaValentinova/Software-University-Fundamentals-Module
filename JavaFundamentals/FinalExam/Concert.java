import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, List<String>> bandMembers=new LinkedHashMap<>();
        Map<String, Integer> bandMTime=new TreeMap<>();
        int totalTime=0;
        while (!"start of concert".equals(input)) {
            String[] parts = input.split("; ");
            String command = parts[0];
            String bandName = parts[1];
            switch (command) {
                case "Add":
                    String [] membersAll=parts[2].split(", ");
                    bandMembers.putIfAbsent(bandName,new ArrayList<>());
                    List<String> members=bandMembers.get(bandName);
                    for (int i = 0; i <membersAll.length ; i++) {
                        String currentMember=membersAll[i];
                        if (!members.contains(currentMember)) {
                            members.add(currentMember);
                        }
                    }
                    bandMembers.put(bandName,members);
                    break;
                case "Play":
                    int time= Integer.parseInt(parts[2]);
                    totalTime+=time;
                    if (bandMTime.containsKey(bandName)) {
                        int newTime=bandMTime.get(bandName)+time;
                        bandMTime.put(bandName,newTime);
                    } else {
                        bandMTime.put(bandName,time);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Total time: "+totalTime);
        bandMTime
                .entrySet()
                .stream()
                .sorted((b1,b2)->b2.getValue().compareTo(b1.getValue()))
                .forEach(b-> System.out.println(String.format("%s -> %d",b.getKey(),b.getValue())));
        input=scan.nextLine();
        System.out.println(input);
        for (Map.Entry<String,List<String>> s : bandMembers.entrySet()) {
            if (s.getKey().equals(input)) {
                s
                        .getValue()
                        .stream()
                        .forEach(m-> System.out.println(String.format("=> %s",m)));
            }
        }
    }
}
