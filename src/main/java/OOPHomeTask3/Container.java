package OOPHomeTask3;

import java.util.List;
import java.util.Iterator;
public class Container implements Comparable<Container>, Iterable<Box>{
    public List<Box> boxes;

    public Container(List<Box> boxes) {
        this.boxes = boxes;
    }

    public int getWeight() {
        int totalWeight = 0;
        for (Box box : boxes) {
            totalWeight += box.getWeight();
        }
        return totalWeight;
    }

    @Override
    public int compareTo(Container other) {
        return Integer.compare(this.getWeight(), other.getWeight());
    }

    @Override
    public Iterator<Box> iterator() {
        return boxes.iterator();
    }
}
