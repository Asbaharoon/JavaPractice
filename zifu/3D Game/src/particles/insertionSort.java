package particles;

import java.util.List;

public class insertionSort { 
    
    public static void sortHighToLow(List<particle> list) {
        for (int i = 1; i < list.size(); i++) {
            particle item = list.get(i);
            if (item.getDistance() > list.get(i - 1).getDistance()) {
                sortUpHighToLow(list, i);
            }
        }
    }
 
    private static void sortUpHighToLow(List<particle> list, int i) {
        particle item = list.get(i);
        int attemptPos = i - 1;
        while (attemptPos != 0 && list.get(attemptPos - 1).getDistance() < item.getDistance()) {
            attemptPos--;
        }
        list.remove(i);
        list.add(attemptPos, item);
    }
}