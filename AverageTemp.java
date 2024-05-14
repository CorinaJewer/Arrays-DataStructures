import java.util.InputMismatchException;
import java.util.Scanner;

public class AverageTemp {

    private int[] temperatures;

    public AverageTemp(int size){
        temperatures = new int[size];
    }

    public void userTemps(){
        Scanner in = new Scanner(System.in);
        
        for (int i = 0; i < temperatures.length; i++) {
            boolean validInteger = false;
            while (!validInteger){
                try{
                    System.out.print("Please enter a temperature in celius #" + (i + 1) + ": ");
                    temperatures[i] = in.nextInt();
                    validInteger = true; 
                }catch(InputMismatchException e){
                    System.out.println("Please enter a valid integer.");
                    in.next();
                }
            }
        }
        in.close();
    }
    
    public double averageTempCelius() {
        double sum = 0;
        for (int temp : temperatures) {
            sum += temp;
        }
        return sum / temperatures.length;
    }

    public int aboveAverageTemp(){
        double averageTempCelius = averageTempCelius();
        int count = 0;
        for (int temp : temperatures){
            if (temp > averageTempCelius){
                count++;
            }    
        }
        return count; 
    }

    public static void main(String[] args) {
        
        AverageTemp averageTemp = new AverageTemp(8);
        System.out.println();
        averageTemp.userTemps();

        System.out.println("The average temperature is " + averageTemp.averageTempCelius() + " degress celius.");

        System.out.println("The number of temperatures above the average value of " + averageTemp.averageTempCelius() + " degrees celius is " + averageTemp.aboveAverageTemp() + ".");

        System.out.println();
    }
}
