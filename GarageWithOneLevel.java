import java.util.Locale;
import java.util.Scanner;

public class GarageWithOneLevel {
    public static void main(String[] args) {
        /**
         * split
         * equals,
         * equalsIgnoreCase
         * startsWith
         * endsWith
         * https://caveofprogramming.teachable.com/p/java-for-complete-beginners
         */
        Garage g2 = new Garage(2);
        g2.parkCar("c1");
        g2.show();

        //whileloop for input info for car
        System.out.println("Welcome to my garage!");
        Scanner sc = new Scanner(System.in);
        Garage garage = new Garage(10);

        while (true) {
            String command = sc.nextLine();
            String[] splitString = command.split("\\s+");
            String carID = splitString[splitString.length-1];
            int slotNumber;

            if (command.equalsIgnoreCase("exit")){
                System.out.println("Good bye");
                break;

            } else if (splitString.length == 3 && splitString[0].equalsIgnoreCase("park") && splitString[1].equalsIgnoreCase("car") && splitString[splitString.length-1].endsWith(carID)){  //park car
                slotNumber = garage.parkCar(carID);
                if (slotNumber == -1){
                    System.out.println("No space in the Lot");
                } else {
                    System.out.println("Car " + carID + " is parked.");
                }
                garage.show();

            } else if (splitString[0].equalsIgnoreCase("retrieve") && splitString[1].equalsIgnoreCase("car") && splitString[splitString.length-1].endsWith(carID)){ //retrieve car
                garage.retrieveCar(carID);
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
//[][]
    }

    public static class Garage {
        String[] parkingSlots;

        public Garage(int parkingSpace){
            this.parkingSlots = new String[parkingSpace];

        }
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
