package OOPHomeTask3;

import java.util.Comparator;

public class ContainerCountComparator implements Comparator<Container> {
    @Override
    public int compare(Container o1, Container o2) {
        int count1 = o1.boxes.size();
        int count2 = o2.boxes.size();
        return Integer.compare(count1, count2);
    }
}
