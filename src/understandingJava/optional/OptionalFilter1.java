package understandingJava.optional;

import java.util.Optional;

public class OptionalFilter1 {



    public static void main(String[] args) {
        int number = 9000;
        Optional<Integer> maybe = Optional.ofNullable(number);
        Optional<Integer> isIt = maybe.map(num->num/2);
        Optional<Integer> areYouSure = maybe.flatMap(num->Optional.of(num/2));
        Optional<Integer> okayLetsSeeIfItsEven = maybe.filter(num->num%2==0);
        System.out.println("lets check -> if 409 is even:"+ Optional.of(409).filter(num->num%2==0));
        System.out.println("lets check -> if 400 is even:"+ Optional.of(400).filter(num->num%2==0));
    }
}
