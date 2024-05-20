public class TwoDimensionalArray {
    
    int arr[][] = null;  // Declares two dimensional array of intergars and initializes to null. Does not point to memory location.

    public TwoDimensionalArray (int numberOfRows, int numberOfCols) {
        this.arr = new int[numberOfRows][numberOfCols];
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[0].length; col++){
                arr[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    public void insertValueInTheArray(int row, int col, int value) {
        try {
            if (arr[row][col] == Integer.MIN_VALUE){
                arr[row][col] = value;
                System.out.println("The value is successfully inserted");
            } else {
                System.out.println("This cell is already occupiend");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index for 2D array");
        }
    }

    public void traverse(){
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[0].length; col++){
                System.out.println(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void searchingValue (int value){
        boolean found = false;
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[0].length; col++){
                if (arr[row][col] == value) {
                    System.out.println("Value of " + value + " is found at row: " + row + " Col: " + col);
                    found = true;
                }
            }
        }
        if (!found){
            System.out.println("Value is not found");
        }
    }

    /*public void deleteValueFromArray(int row, int col){
        try{
            System.out.println("Successfully deleted: " + arr[row][col]);
            arr[row][col] = Integer.MIN_VALUE;
            
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("This index is not valid for array");
        }
    }*/

    public void deleteValueFromArray(int valueToDelete) {
        boolean found = false; 
        
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == valueToDelete) {
                    System.out.println("Successfully deleted: " + valueToDelete + " at row: " + row + " Col: " + col);
                    arr[row][col] = Integer.MIN_VALUE; 
                    found = true;
                }
            }
        }
        
        if (!found) {
            System.out.println("Value " + valueToDelete + " is not found in the array");
        }
    }
    
    @Override
    public String toString() {
        String result = "";
        
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                result += arr[row][col] + " ";
            }
            result += "\n";
        }    
        return result;
    }

    public static void main(String[] args) {

        TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray(3, 4);

        System.out.println(twoDimensionalArray);

        twoDimensionalArray.insertValueInTheArray(0, 0, 200);
        twoDimensionalArray.insertValueInTheArray(0, 1, 200);
        twoDimensionalArray.insertValueInTheArray(2, 3, 100);

        System.out.println(twoDimensionalArray);

        twoDimensionalArray.traverse();

        twoDimensionalArray.searchingValue(100);

        //twoDimensionalArray.deleteValueFromArray(0,0);

        twoDimensionalArray.deleteValueFromArray(200);

        System.out.println(twoDimensionalArray);
    }
}


