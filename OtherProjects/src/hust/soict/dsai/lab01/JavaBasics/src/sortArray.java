import java.util.Arrays;
public class sortArray {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 8, 5};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        System.out.println("The sum of all the element is: " + sum);
        double avg =  (double)(sum)/arr.length;
        System.out.println("The average value is: " + avg);
    }
}