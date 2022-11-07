import Cinema.Cinema;
import java.text.DecimalFormat;
import java.util.*;

public class MainClass {
    public static int numberOfRows;
    public static int numberOfSeats;
    public static int countTickets = 0;
    public static int currentIncome = 0;
    public static double percentage = 0.0;
    private static final DecimalFormat df = new DecimalFormat("0.00");
   public static char[][] cinema;

    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        numberOfSeats = scanner.nextInt();
        cinema = new char[numberOfRows][numberOfSeats];
        printCinema();
        while (true){
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.print("> ");
            int option = scanner.nextInt();
            if(option == 0){
                break;
            }if(option == 2){
                ticketPrice();
                System.out.println();
            }if(option == 1){
                showSeats();
                System.out.println();
            }if(option == 3){
                printTotalProfit();
                System.out.println();
            }
        }
    }
    public static void showSeats(){
        System.out.println();
        System.out.println("Cinema:");
        for(int i = 0; i<=numberOfSeats; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for(int m = 0; m<cinema.length ; m++){

            System.out.print(m+ 1+ " ");
            for(int n = 0; n<cinema[m].length; n++){
                System.out.print(cinema[m][n] + " ");
            }
            System.out.println();
        }

        }
    public static void ticketPrice(){
        System.out.println();
        int ticketValueEight = 8;
        int ticketValueTen = 10;
        Scanner scanner = new Scanner(System.in);
        int rowNumber;
        while (true) {
            System.out.println("Enter a row number:");
            System.out.print("> ");
            rowNumber = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            System.out.print("> ");
            int seatNumber = scanner.nextInt();
            System.out.println();
            if((rowNumber>numberOfRows || rowNumber<0) || (seatNumber>numberOfSeats || seatNumber<0) ){
                System.out.println("Wrong input!");
                System.out.println();
                continue;
            }
            if (cinema[rowNumber - 1][seatNumber - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
                System.out.println();
                continue;
            }
            cinema[rowNumber - 1][seatNumber - 1] = 'B';
            countTickets++;

            int totalSeats = numberOfRows * numberOfSeats;
            int halfFront = numberOfRows / 2;
            if (totalSeats <= 60) {
                System.out.println("Ticket price: $10");
                currentIncome += ticketValueTen;
            } else {
                if (numberOfRows % 2 == 0) {
                    if (rowNumber <= halfFront) {
                        System.out.println("Ticket price: $10");
                        currentIncome += ticketValueTen;
                    } else {
                        System.out.println("Ticket price: $8");
                        currentIncome += ticketValueEight;
                    }
                } else {
                    if (rowNumber <= halfFront) {
                        System.out.println("Ticket price: $10");
                        currentIncome += ticketValueTen;
                    } else {
                        System.out.println("Ticket price: $8");
                        currentIncome += ticketValueEight;
                    }
                }
            }
            break;
        }
    }
    public static void printTotalProfit(){
        int totalIncome = 0;
        int totalNumberOfSeats = numberOfRows * numberOfSeats;
        double value = (double) 100 * countTickets / totalNumberOfSeats;
        percentage+=value;
        int frontHalfRows = numberOfRows / 2;
        int backHalfRows = numberOfRows / 2;
        int frontHalfPrice;
        int backHalfPrice;
        if (totalNumberOfSeats <= 60) {
            totalIncome = totalNumberOfSeats * 10;
        } else {
            if (numberOfRows % 2 == 0) {
                int numberOfFrontSeats = frontHalfRows * numberOfSeats;
                int numberOfBackSeats = backHalfRows * numberOfSeats;
                frontHalfPrice = numberOfFrontSeats * 10;
                backHalfPrice = numberOfBackSeats * 8;
                totalIncome = frontHalfPrice + backHalfPrice;
            } else {
                int numberOfFrontSeats = frontHalfRows * numberOfSeats;
                int numberOfBackSeats = (backHalfRows +1) * numberOfSeats;
                frontHalfPrice = numberOfFrontSeats * 10;
                backHalfPrice = numberOfBackSeats * 8;
                totalIncome += frontHalfPrice + backHalfPrice;
            }
        }
        System.out.println();
        System.out.println("Number of purchased tickets: " + countTickets);
        System.out.println("Percentage: " + df.format(percentage)  + "%");
        System.out.println("Current income: " + "$" + currentIncome);
        System.out.println("Total income: " + "$" + totalIncome);
        percentage = 0.0;
    }
    public static void printCinema(){
        for(int m = 0; m<cinema.length ; m++){
            for(int n = 0; n<cinema[m].length; n++){
                cinema[m][n] = 's';
            }
            System.out.println();
        }
    }

}




