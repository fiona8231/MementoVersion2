import java.util.ArrayList;

public class Container {

    ArrayList<Fraction> listContainer =  new ArrayList<>();

    public void addElement(Fraction newFraction){
         listContainer.add(newFraction);
    }

    public Fraction getElement(int index){
        return listContainer.get(index);
    }

}
