import java.util.Scanner;

public class GarageWithMultipleLevel {
    public static void main(String[] args) {

        GarageWithMultipleRows g1 = new GarageWithMultipleRows(3,2);
        g1.parkCar("1");
        g1.parkCar("2");
        g1.parkCar("c4");
        g1.parkCar("c3");
        g1.parkCar("c5");

        g1.display();
        System.out.println();
        System.out.println(g1.retrieveCar(0,2));
        System.out.println(g1.retrieveCar(1,2));

        g1.display();


        System.out.println();

        System.out.println("Welcome to my garage!");
        Scanner sc = new Scanner(System.in);
        GarageWithMultipleRows garage = new GarageWithMultipleRows(2,2);

        while (true) {
            System.out.println();
            String command = sc.nextLine();
            String[] splitString = command.split("\\s+");//skip multiple spaces
            String carID = splitString[splitString.length-1];
            int[] slotNumber;

            if (command.equalsIgnoreCase("exit")){
                System.out.println("Good bye");
                break;

            } else if (splitString.length == 3 && splitString[0].equalsIgnoreCase("park") && splitString[1].equalsIgnoreCase("car") && splitString[splitString.length-1].endsWith(carID)){  //park car
                slotNumber = garage.parkCar(carID);
                if (slotNumber[0] == -1){
                    System.out.println("No space in the Lot");
                } else {
                    System.out.println("Car " + carID + " is parked at position " + slotNumber[0]+""+slotNumber[1]);
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

        public GarageWithMultipleRows(int rows, int slotNumber) {
            this.parkingSlots = new String[rows][slotNumber];
        }

        public int [] parkCar(String car) {
            int rows = 0;
            while (rows < parkingSlots.length) {
                int slotPerRow = 0;
                while (slotPerRow < parkingSlots[rows].length && parkingSlots[rows][slotPerRow] != null) {
                    slotPerRow++;
                }
                if (slotPerRow < parkingSlots[rows].length) {
                    parkingSlots[rows][slotPerRow] = car;
//                    int[] result = new int[2];
//                    result[0]= rows;
//                    result[1]=slotPerRow;
//                    return result;
                    return new int[]{rows, slotPerRow};
                } else {
                    rows++;
                }
            }
           return new int[]{-1, -1};
        }

        public void retrieveCar(String car){ //
            int rows = 0;
            boolean carFound = false;
            while (rows < parkingSlots.length) {
                int slotPerRows = 0;
                while (slotPerRows < parkingSlots[rows].length && !car.equals(parkingSlots[rows][slotPerRows])) {
                    slotPerRows++;
                }
                if (slotPerRows < parkingSlots[rows].length) {
                    System.out.println("Found " + parkingSlots[rows][slotPerRows] + ".Retrieving");
                    parkingSlots[rows][slotPerRows] = null;
                    System.out.println("Space " + (rows) + "" + (slotPerRows) + " is now available.");
                    carFound = true;
                    break;
                }
                rows++;
            }
            if (!carFound){
                System.out.println("No car found");
            }

        }

        //write method find position. input car id, output position int array.
//        public int[] findPosition(String carID){
//            boolean carFound = false;
//            int rowsNumber = 0;
//            while(rowsNumber < parkingSlots.length) {
//                int slotNumber = 0;
//                while (slotNumber < parkingSlots[rowsNumber].length) {
//                    if (carID.equals(parkingSlots[rowsNumber][slotNumber])) {
//                        return new int[]{rowsNumber, slotNumber};
//                    } else {
//                        slotNumber++;
//                    }
//                }
//                if(!carFound) {
//                    rowsNumber++;
//                }
//                else{
//                    break;
//                }
//            }
//            return new int[]{-1,-1};
//        }

        //overloading similar behavior
        //provide carID, retrieve car at that position
        public String retrieveCar(int row, int col) {
            if (row < parkingSlots.length && col < parkingSlots[row].length) {
                if( parkingSlots[row][col] == null){
                    return "No car found";
                }else {
                    String carID = parkingSlots[row][col];
                    parkingSlots[row][col] = null;
                    return "car " + carID +"  retrieving.  Space " + row + "" + col + " is available.";
                }
            }else {
                return "Invalid Parking Slot";
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
