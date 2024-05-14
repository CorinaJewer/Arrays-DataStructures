//import java.util.Arrays;

public class SingleDimensionalArray{

    int [] arr = null;   

    public SingleDimensionalArray(int size){  
        arr = new int[size];  
        for (int i = 0; i < arr.length; i++){  
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int valueToInsert){
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = valueToInsert;
                System.out.println("Successfully inserted.");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array: " +  e);
        }
    }
  
    public void traverse() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); 
        }
    }
    
    public void traverse1() {
        for (int element : arr) {
            System.out.println(element + 1); 
        }
    }

    public void deleteElement(int valueToDelete) {
        try {
            boolean elementFound = false; 
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == valueToDelete) {
                    arr[i] = Integer.MIN_VALUE; 
                    elementFound = true;
                }
            }

            if (elementFound) {
                System.out.println("Deleted all occurrences of integar " + valueToDelete + ".");
            } else {
                System.out.println("Element " + valueToDelete +  " was not located.");
            }
        } catch (Exception e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }
    
    public void searchElement(int valueToSearch) {
        try{
            boolean elementFound = false; 
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == valueToSearch) {
                    System.out.println("Element " + valueToSearch + " was located at index " + i + ".");
                    elementFound = true;
                }
            }
                if (!elementFound) {
                    System.out.println("Integer " + valueToSearch + " was not located.");
                }
        }catch(Exception e){
            System.out.println("An error occured: " + e.getMessage());

        }
    }

    @Override
    public String toString() {
        String result = "["; 
        for (int i = 0; i < arr.length; i++) {
            result += arr[i]; 
            if (i < arr.length - 1) {
                result += ", "; 
            }
        }
        result += "]"; 
        return result;
    }
    

    public static void main(String[] args) {

        SingleDimensionalArray singleDimensionalArray = new SingleDimensionalArray(8);
        singleDimensionalArray.insert(0,1);
        singleDimensionalArray.insert(1,2);
        singleDimensionalArray.insert(2,3);
        singleDimensionalArray.insert(3,4);
        singleDimensionalArray.insert(4,4);
        singleDimensionalArray.insert(5,5);
        singleDimensionalArray.insert(6,6);
        singleDimensionalArray.insert(7,7); 
        
        System.out.println();

        System.out.println(singleDimensionalArray.toString());

        //System.out.println(Arrays.toString(singleDimensionalArray.arr));

        singleDimensionalArray.traverse();
        System.out.println();
        singleDimensionalArray.traverse1();

        singleDimensionalArray.searchElement(2);

        singleDimensionalArray.deleteElement(10);

        singleDimensionalArray.deleteElement(4);

        System.out.println("Revised Array: " + singleDimensionalArray.toString());
        
    }
}
