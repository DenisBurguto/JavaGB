package OOP3;

import java.util.Comparator;

public class ContainerCountComparator implements Comparator<Container> {

    @Override
    public int compare(Container o1, Container o2) {

        return Integer.compare(o1.boxes.size(),o2.boxes.size());
    }
}
