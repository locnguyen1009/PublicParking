import java.util.Scanner;

public class GarageWithMultipleLevel {
    public static void main(String[] args) {
        System.out.println("Welcome to my garage!");
        Scanner sc = new Scanner(System.in);
        GarageWithMultipleRows garage = new GarageWithMultipleRows(2,4);

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
                garage.display();

            } else if (splitString[0].equalsIgnoreCase("retrieve") && splitString[1].equalsIgnoreCase("car") && splitString[splitString.length-1].endsWith(carID)){ //retrieve car
                garage.retrieveCar(carID);
                garage.display();

            } else { //invalid command
                System.out.println("Invalid Input. Please try again");

            }
        }
    }

    public static class GarageWithMultipleRows {

        String[][] parkingSlots;

        public GarageWithMultipleRows(int rows, int slotPerRow) {
            this.parkingSlots = new String[rows][slotPerRow];
        }

        public int parkCar(String car) {
            int rows = 0;
            while (rows < parkingSlots.length) {
                int slotPerRow = 0;
                while (slotPerRow < parkingSlots[rows].length && parkingSlots[rows][slotPerRow] != null) {
                    slotPerRow++;
                }
                if (slotPerRow < parkingSlots[rows].length) {
                    parkingSlots[rows][slotPerRow] = car;
                    break;
                } else {
                    rows++;
                }
            }

            if (rows < parkingSlots.length) {  //not sure how to return
                return rows;
            } else {
                return -1;
            }
        }

        public void retrieveCar(String car){
            int rows = 0;
            while (rows < parkingSlots.length) {
                int slotPerRows = 0;
                while (slotPerRows < parkingSlots[rows].length && !car.equals(parkingSlots[rows][slotPerRows])) {
                    slotPerRows++;
                }
                if (slotPerRows < parkingSlots[rows].length) {
                    System.out.println("Found " + parkingSlots[rows][slotPerRows] + ".Retrieving");
                    parkingSlots[rows][slotPerRows] = null;
                    System.out.println("Space " + (rows) + "-" + (slotPerRows) + " is now available.");
                } else {
                    System.out.println("no car found");
                    break;
                }
                rows++;
            }
        }

        public void display () {
            System.out.println();
            for (int i = 0; i < parkingSlots.length; i++) {
                for (int j = 0; j < parkingSlots[i].length; j++) {
                    if (parkingSlots[i][j] != null) {
                        System.out.print(parkingSlots[i][j] + "   ");
                    } else {
                        System.out.print("Empty ");
                    }
                }
                System.out.println();
            }

        }
    }
}
