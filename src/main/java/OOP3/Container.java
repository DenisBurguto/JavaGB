package OOP3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Container implements Comparable<Container>,Iterable<Box> {
    List<Box> boxes;

    public Container(List<Box> boxes) {
        this.boxes = boxes;
    }

    public int GetWeight(){
        int totalWeight =0;
        for (Box box:boxes
             ) { totalWeight+=box.getWeight();

        }
        return totalWeight;
    }

    @Override
    public int compareTo(Container o) {
        return Integer.compare(this.GetWeight(),o.GetWeight());
    }

    @Override
    public Iterator<Box> iterator() {
        return boxes.iterator();
    }
}
