package understandingJava.regex;

public class StringSplit {
    public static void main(String[] args) {
        String str = "0000000 11111       222222     3333333";
        String elements[] = str.split("\\s+");
        System.out.println("initial"+str+"\nelements= "+elements[0]+" "+elements[1]+" "+elements[2]+" "+elements[3]);
    }
}
