package understandingJava.regex;

public class DecimalRemoval {
    public static void main(String[] args) {
        String charge = "7897897890.0000";
        String regex = ".0+";
        System.out.println("->"+charge.replaceAll(regex,""));
    }
}
