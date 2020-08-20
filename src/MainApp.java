import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        doTask1();
        System.out.println();
        doTask2();
    }

    public static void doTask1(){
        Integer[] arr = {1,2,3,4};
        //IDEA подсказывает, что не обязательно писать <Integer>, он виден из контекста
        printArray(arr);
        swap(arr, 1, 2);
        printArray(arr);
    }

    public static void doTask2(){
        FruitBox<Apple> appleFruitBox = new FruitBox<>();
        FruitBox<Orange> orangeFruitBox = new FruitBox<>();
        FruitBox<Apple> newAppleFruitBox = new FruitBox<>();

        appleFruitBox.addFruit(new Apple());
        appleFruitBox.addFruit(new Apple());
        appleFruitBox.addFruit(new Apple());
        //appleFruitBox.addFruit(new Orange());--Ошибка, ожидается яблоко
        System.out.println("Apples box weigh:" + appleFruitBox.getWeigh());

        orangeFruitBox.addFruit(new Orange());
        System.out.println("Oranges box weigh:" + orangeFruitBox.getWeigh());
        System.out.println("Is weighs equals? " + appleFruitBox.compareTo(orangeFruitBox));
        System.out.println("Add additional orange!");
        orangeFruitBox.addFruit(new Orange());
        System.out.println("Oranges box weigh:" + orangeFruitBox.getWeigh());
        System.out.println("Is weighs now equals? " + appleFruitBox.compareTo(orangeFruitBox));

        System.out.println("New empty apple box weigh:" + newAppleFruitBox.getWeigh());
        System.out.println("Move apples to new box...");
        appleFruitBox.moveContentTo(newAppleFruitBox);
        System.out.println("Old apple box weigh:" + appleFruitBox.getWeigh());
        System.out.println("New apple box weigh:" + newAppleFruitBox.getWeigh());
        //appleFruitBox.moveContentTo(orangeFruitBox); -- Ошибка, ожидается яблочная коробка

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

        for(T item: arr) {
            ret.add(item);
        }
        /*IDEA ругается, предлагает на замену аналогичную функцию из Collections
            Collections.addAll(ret, arr);
         */

        return ret;
    }


}
