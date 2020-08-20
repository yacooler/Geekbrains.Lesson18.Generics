import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        doTask1();
    }

    public static void doTask1(){
        Integer arr[] = {1,4,2,0};
        //IDEA подсказывает, что не обязательно писать <Integer>
        printArray(arr);
        swap(arr, 1, 2);
        printArray(arr);
    }

    public static <T> void printArray(T[] arr){
        for (T item:arr ) {
            System.out.println(item);
        }
    }

    /**
     * Обмен элементов типизированного массива местами. Меняются не значения, а ссылки на элементы.
     */
    public static <T> void swap(T[] arr, int firstIndex, int secondIndex){
        if (firstIndex < 0 || firstIndex > arr.length - 1 ||
                secondIndex < 0 || secondIndex > arr.length -1 ) {
            throw new RuntimeException(String.format(
                    "Array indexes [%d][%d] out of bounds. Expected 0..%d",
                    firstIndex, secondIndex, arr.length));
        }
        if (firstIndex==secondIndex) return;

        T buffer;
        buffer = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = buffer;
    }

    /**
     * Создание типизированного List на основе элементов массива
     */
    public static <T> List<T> asList(T[] arr){
        List<T> ret = new ArrayList<>();

        /*IDEA ругается, предлагает равноценную замену из Collections
        for(T item: arr) {
            ret.add(item);
        }*/
        Collections.addAll(ret, arr);

        return ret;
    }


}
