import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruit>{
    private final List<T> content = new ArrayList<>();

    public float getWeigh(){
        float weigh = 0;
        for (T e:content ) {
            weigh += e.getWeigh();
        }
        return weigh;
    }

    /**
     * Сравнивать можем с коробкой с любым типом фруктов внутри
     */
    public boolean compareTo(FruitBox<? extends Fruit> box){
        return getWeigh() == box.getWeigh();
    }

    /**
     * Перемещать может только в коробку для того же типа фруктов
     */
    public void moveContentTo(FruitBox<T> destination){
        //Никто не может использовать контент, т.к. он перемещается
        synchronized (content){
            for (T e: content ) {
                destination.addFruit(e);
            }
            content.clear();
        }

    }

    public void addFruit(T fruit){
        content.add(fruit);
    }

}
