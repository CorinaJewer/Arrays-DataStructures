import java.util.Scanner;

public class MovieTheatre {

    private char seating [][];

    public MovieTheatre(int numOfRows, int numOfSeats){
        this.seating = new char[numOfRows][numOfSeats];

        for (int row = 0; row < seating.length; row++){
            for (int seat = 0; seat < seating[0].length; seat++) {
                seating[row][seat] = '-';
            }
        }    
    }

    public void display(){
        System.out.println();
        System.out.print("    ");
        for (int seat = 0; seat < seating[0].length; seat++) {
            System.out.printf("%-5s", seat + 1);        
        }

        System.out.println();
    
        for (int row = 0; row < seating.length; row++){
            System.out.printf("%-2s", row + 1);
            for (int seat = 0; seat < seating[0].length; seat++) {
                System.out.print("[ " + seating[row][seat] + " ]");
            }
            System.out.println();      
        } 
    }

    public void selectSeat(int row, int seat){
        try {
            int rowIndex = row - 1;
            int seatIndex = seat - 1;
    
            if (seating[rowIndex][seatIndex] == '-'){
                seating[rowIndex][seatIndex] = 'X';
                System.out.println();
                System.out.println("Your seat has been successfully reserved.");
            } else {
                System.out.println("That seat is unavailable, please choose again.");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please choose again, you've selected an invalid seat.");
        }
    }
            
    public static void main(String[] args) {
        
        MovieTheatre cineplex = new MovieTheatre(10,10);

        System.out.println();

        Scanner in = new Scanner(System.in);
        boolean reservingSeat = true;

        while(reservingSeat){

            System.out.println();
            System.out.println("Welcome to Cineplex!");
            System.out.println("--------------------");
            System.out.println("1. View Seating Chart");
            System.out.println("2. Choose Your Seat");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Please make your choice: ");

            int selection = in.nextInt();
            
            switch (selection){

                case 1:
                    cineplex.display();
                    break;
                case 2:
                    System.out.print("Enter the row number: ");
                    int row = in.nextInt();
                    System.out.print("Enter the seat number: ");
                    int seat = in.nextInt();
                    cineplex.selectSeat(row,seat);
                    break;
                case 3:
                    reservingSeat = false;
                    System.out.println();
                    System.out.println("Enjoy the Movie!");
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice, Please choose again.");
                    break;            
            }
        }        
        in.close();
    }
}


