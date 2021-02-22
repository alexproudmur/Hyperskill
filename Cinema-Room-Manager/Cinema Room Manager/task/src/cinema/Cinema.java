package cinema;

import java.util.Scanner;

public class Cinema {
    int income = 0;

    public static void main(String[] args) {
        final Cinema cinema = new Cinema();
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int a = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int b = scanner.nextInt();

        String[][] array = cinema.createCinemaRoom(a, b);
        String input;

        do {
            System.out.println("\n\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            input = scanner.next();

            switch (input) {
                case "1":
                    cinema.showPlaces(array);
                    break;
                case "2":
                    cinema.buyTicket(array, scanner);
                    break;
                case "3":
                    cinema.showStats(array);
                    break;
                case "0":
                    break;
            }
        } while (!input.equals("0"));

//        System.out.println("Total income:");
//        int d;
//        if (a*b > 60) {
//            d = b * (a / 2 * 10 + (a - a / 2) * 8);
//        } else {
//            d = a * b * 10;
//        }
//
//        System.out.printf("$%d", d);
    }

    public void showStats(String[][] array) {
        int purchased = 0;
        for (String[] strings : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (strings[j].equals("B")) {
                    purchased++;
                }
            }
        }

        double percentage = 100 * (double) purchased / (array.length * array[0].length);
        int totalIncome;
        if (array.length * array[0].length > 60) {
            int b = array.length / 2;
            totalIncome = array[0].length * (b * 10 + (array.length - b) * 8);
        } else {
            totalIncome = array[0].length * array.length * 10;
        }


        System.out.printf("Number of purchased tickets: %d\n", purchased);
        System.out.println(String.format("Percentage: %.2f", percentage) + "%");
        System.out.printf("Current income: $%d\n", income);
        System.out.printf("Total income: $%d\n", totalIncome);
    }

    public void buyTicket(String[][] array, Scanner scanner) {
        System.out.println("\n\nEnter a row number:");
        int rowNumber = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        if (rowNumber > array.length || seatNumber > array[0].length) {
            System.out.println("\nWrong input!");
            buyTicket(array, scanner);
        } else if (array[rowNumber-1][seatNumber-1].equals("B")) {
            System.out.println("That ticket has already been purchased!");
            buyTicket(array, scanner);
        } else {
            int a = array.length;
            int b = array[0].length;

            int priceForTicket;
            int frontRows = a / 2;

            if (rowNumber > frontRows && a*b > 60) {
                priceForTicket = 8;
            } else {
                priceForTicket = 10;
            }
            this.income += priceForTicket;
            System.out.println();
            System.out.printf("Ticket price: $%d", priceForTicket);
            array[rowNumber-1][seatNumber-1] = "B";
            System.out.println();


        }
    }

    public void showPlaces(String[][] array) {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 1; i <= array[0].length; i++) {
            System.out.print(i + " ");
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print("\n" + (i+1) + " ");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
    }


    public String[][] createCinemaRoom(int a, int b) {

        String[][] array = new String[a][b];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = "S";
            }
        }
        return array;
    }
}