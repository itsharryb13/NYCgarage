package nycgarage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * The Nycgarage class represents a simple program to manage a parking garage in New York City.
 * It allows users to park cars, retrieve cars, and view a list of parked cars.
 * The program calculates the parking duration and charges based on a fixed rate.
 * @author Harpreet Singh
 */
public class Nycgarage {

    /**
     * The main method where the program execution begins.
     * @param args The command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Initialize variables
        List<Car> list = new ArrayList<>(20);
        Scanner scnr = new Scanner(System.in);
        int primary = 0;

        // Adding some pre-existing cars to the garage for testing purposes
        list.add(new Car(1, "jjb1321", LocalDateTime.now().plusHours(1)));
        list.add(new Car(2, "jjb1322", LocalDateTime.now().plusHours(2)));
        list.add(new Car(3, "jjb1323", LocalDateTime.now().plusHours(3)));
        list.add(new Car(4, "jjb1324", LocalDateTime.now().plusHours(4)));
        list.add(new Car(5, "jjb1325", LocalDateTime.now().plusHours(4)));
        list.add(new Car(6, "jjb1326", LocalDateTime.now().plusHours(4)));

        do {
            // Display user menu
            System.out.println("If you want to park, press -> 1");
            System.out.println("If you want to retrieve your car, press -> 2");
            System.out.println("To get a list of cars, press -> 3");

            // Get user choice
            primary = scnr.nextInt();

            // Parking
            if (primary == 1) {
                if (list.size() < 20) {
                    System.out.print("Please enter the plate number without special characters: ");
                    String plateNum = scnr.next();
                    LocalDateTime startingDurationH = LocalDateTime.now();
                    System.out.print("Please enter hours of stay: ");
                    int expectedDuration = scnr.nextInt();
                    Car newCar = new Car(expectedDuration, plateNum.toLowerCase(), startingDurationH);
                    list.add(newCar);
                    sortCarsByDuration(list);  // Sort the list after adding a new car
                } else {
                    System.out.println("Garage is Full");
                }
            }

            // Retrieving a car
            if (primary == 2) {
                if (list.isEmpty()) {
                    System.out.println("You did not park your car in this parking lot");
                } else {
                    System.out.print("Please enter the plate number: ");
                    String poping = scnr.next().toLowerCase();
                    Iterator<Car> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        Car car = iterator.next();
                        if (car.getPlate().equals(poping)) {
                            LocalDateTime currentTime = LocalDateTime.now();
                            Duration totalHours = Duration.between(currentTime, car.getStartDurationH());
                            int totalAmount = (int) ((totalHours.toHours() + 1) * 15);
                            System.out.println("Your Total is " + totalAmount);
                            System.out.println("Your car " + car.getPlate().toUpperCase() + " is coming.");
                            iterator.remove();
                        }
                    }
                }
            }

            // Listing all cars
            if (primary == 3) {
                for (Car car : list) {
                    System.out.println(car.toString());
                }
            } else if (primary == 137923) {
                System.out.println("See you during working hours");
            }

        } while (primary != 137923);
    }

    // Custom comparator to sort cars by expected duration from lowest to longest
    private static void sortCarsByDuration(List<Car> cars) {
        cars.sort(Comparator.naturalOrder());
    }
}
