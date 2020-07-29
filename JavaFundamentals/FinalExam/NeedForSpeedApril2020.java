import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedForSpeedApril2020 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scan.nextLine());
        int carMileage=0;
        int carFuelAvailable=0;

        Map<String, Integer> carsMileage = new TreeMap<>();
        Map<String, Integer> carsFuel = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] currentCar = scan.nextLine().split("\\|");
            String carName = currentCar[0];
            carMileage = Integer.parseInt(currentCar[1]);
            carFuelAvailable = Integer.parseInt(currentCar[2]);
            carsMileage.put(carName,carMileage);
            carsFuel.putIfAbsent(carName,carFuelAvailable);
        }

        String input = scan.nextLine();

        while (!"Stop".equals(input)) {
            String[] currentCommand = input.split(" : ");
            String command = currentCommand[0];
            String car = currentCommand[1];
            switch (command) {
                case "Drive":
                    int distance= Integer.parseInt(currentCommand[2]);
                    int fuel= Integer.parseInt(currentCommand[3]);
                    if (fuel<=carsFuel.get(car)) {
                        int newMileage=carsMileage.get(car)+distance;
                        int newFuel=carsFuel.get(car)-fuel;
                        carsMileage.put(car,newMileage);
                        carsFuel.put(car,newFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",car,distance,fuel);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if (carsMileage.get(car)>=100000) {
                        carsMileage.remove(car);
                        carsFuel.remove(car);
                        System.out.printf("Time to sell the %s!%n",car);
                    }
                    break;
                case "Refuel":
                    int fuelToFill= Integer.parseInt(currentCommand[2]);
                    if (carsFuel.get(car)+fuelToFill>75) {
                        fuelToFill=75-carsFuel.get(car);
                        carsFuel.put(car,75);
                    } else {
                        carsFuel.put(car, carsFuel.get(car)+fuelToFill);
                    }
                    System.out.printf("%s refueled with %d liters%n",car,fuelToFill);
                    break;
                case "Revert":
                    int km= Integer.parseInt(currentCommand[2]);
                    int newKm=carsMileage.get(car)-km;
                    if (newKm>=10000) {
                        carsMileage.put(car,newKm);
                        System.out.printf("%s mileage decreased by %d kilometers%n",car,km);
                    } else {
                        carsMileage.put(car,10000);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        carsMileage
                .entrySet()
                .stream()
                .sorted((m1,m2)->m2.getValue().compareTo(m1.getValue()))
                .forEach(c->{
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",c.getKey(),c.getValue(),carsFuel.get(c.getKey()));
                });
    }
}
