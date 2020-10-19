import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        System.out.println("Введите размер массива не меньше 10");
        int nAge = 0;
        try {
            while (nAge < 10) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String sAge = reader.readLine();
                nAge = Integer.parseInt(sAge);
                if (nAge < 10) {
                    System.out.println("Вы ввели размер массива меньше 10 попробуйте еще раз");
                }
            }
            System.out.println("Array capacity " + nAge);
            int[] array = new int[nAge];
            addNumber(array);
            int[] newArray;
            newArray = deleteNumber(array);
            smash(newArray);
            System.out.println("Delete element:" + search(newArray, array));
        } catch (IOException e) {
            System.out.println("Error read from keyboard " + e);
        } catch (NumberFormatException e) {
            System.out.println("Entered character is not an integer " + e);
        }
    }

    private static int search(int[] newArray, int[] oldArray) {
        int sumElementOldArray = 0;
        int sumElementNewArray = 0;
        System.out.println("newArray " + Arrays.toString(newArray));
        System.out.println("oldArray " + Arrays.toString(oldArray));
        for (int i = 0; i < oldArray.length; i++) {
            sumElementOldArray = oldArray[i] + sumElementOldArray;
            if (i < (newArray.length)) {
                sumElementNewArray = newArray[i] + sumElementNewArray;
            }
        }
        System.out.println("Sum new Array:" + sumElementNewArray);
        System.out.println("Sum old Array:" + sumElementOldArray);
        return sumElementOldArray - sumElementNewArray;
    }

    private static int[] smash(int[] array) {
        Random randomIndex = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = randomIndex.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
        System.out.println("Mix Array " + Arrays.toString(array));
        return array;
    }

    private static int[] deleteNumber(int[] array) {
        Random random = new Random();
        int randomNumber = random.nextInt(array.length);
        System.out.println(randomNumber);
        int[] result = new int[array.length - 1];
        System.arraycopy(array, 0, result, 0, randomNumber);
        System.arraycopy(array, randomNumber + 1, result, randomNumber, array.length - randomNumber - 1);
        System.out.println("Array with delete element " + Arrays.toString(array));
        System.out.println("Array without delete element " + Arrays.toString(result));
        return result;
    }

    public static int[] addNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }
}
