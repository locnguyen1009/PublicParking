import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GarageSpace {
    public static void main(String[] args) {
        /**
         * split
         * equals,
         * equalsIgnoreCase
         * startsWith
         * endsWith
         * https://caveofprogramming.teachable.com/p/java-for-complete-beginners
         */


        //whileloop for input info for car
        System.out.println("Welcome to my garage!");
        Scanner sc = new Scanner(System.in);
        Garage garage = new Garage();

        while (true) {

            String command = sc.nextLine();
            String nameCar;
            int slotNumber;

            if (command.equalsIgnoreCase("exit")){
                System.out.println("Good bye");
                break;

            } else if (command.equalsIgnoreCase("Park car")){  //park car
                System.out.println("What is your car license plate?");
                nameCar = sc.nextLine();
                slotNumber = garage.parkCar(nameCar);
                if (slotNumber == -1){
                    System.out.println("No space in the Lot");
                } else {
                    System.out.println("Car " + nameCar + " is parked.");
                }
                garage.show();
            } else if (command.equalsIgnoreCase("retrieve car")){ //retrieve car
                System.out.println("Give me your car license plate?");
                nameCar = sc.nextLine();
                garage.retrieveCar(nameCar);
                garage.show();

            } else { //invalid command
                System.out.println("Invalid Input. Please try again");

            }

        }





/*      int slotNumber2 = g1.parkCar("C2");
        g1.show();

        int slotNumber3 = g1.parkCar("C3");
        g1.show();

        System.out.println();

        g1.retrieveCar("C5");
        g1.show();
        System.out.println();
        g1.retrieveCar("C3");
        g1.show();

        int slotNumber6 = g1.parkCar("C6");
        g1.show();

*/

    }

    public static class Garage {
        String[] parkingSlots = new String[2];

        public int parkCar (String car){
            int pos = 0;
            while (pos < parkingSlots.length && parkingSlots[pos] != null) {
                pos++;
            }
            if (pos < parkingSlots.length) {
                parkingSlots[pos] = car;
                return pos + 1;
            } else {
                return -1;
                 //System.out.println("No available space");
            }
        }

        /**
         * lowerCase, upperCase, s1.equal(),
         *
         */
        public void retrieveCar(String car){
            int pos = 0;
            while (pos < parkingSlots.length && !car.equals(parkingSlots[pos])) {
                pos++;
            }
            if (pos < parkingSlots.length) {
                System.out.println("Found " + parkingSlots[pos] + ". Retrieving");
                parkingSlots[pos] = null;
                System.out.println("Space " + (pos+1) + " is now available.");
            } else {
                System.out.println("No Car found.");
            }
        }

        /**
         * display all cars in all slots
         * if the exists,  print the car name
         * if not, print "empty"
         *
         */
        public void show() {
            System.out.println();
            for (int i = 0; i < parkingSlots.length; i++){
                if (parkingSlots[i] != null) {
                    System.out.print(parkingSlots[i] + " ");
                } else {
                    System.out.print("Empty ");
                }
            }
            System.out.println();

        }
    }
}
