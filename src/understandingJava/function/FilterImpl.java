package understandingJava.function;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterImpl {

    public List<Integer> checkAndFilter(List<Integer> list, Predicate<Integer> predicate) {

        List<Integer> l = list.stream().filter(predicate).collect(Collectors.<Integer>toList());
        list.removeAll(l);
        return l;
    }

}
