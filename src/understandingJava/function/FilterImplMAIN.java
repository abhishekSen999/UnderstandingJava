package understandingJava.function;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FilterImplMAIN {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Original list before filtering-> "+list);
        System.out.println("Filtered items-> "+new FilterImpl().checkAndFilter(list,item->item==1));
        System.out.println("Original List after filtering-> "+list);

        System.out.println(new BigDecimal("0.00000000000").toPlainString());
    }
}
