package understandingJava.optional;

import java.util.Optional;

public class OptionalFilter2 {
    public static void main(String[] args) {


        class SmallObject{

            int anInteger;
            Optional<Integer> optionalOfAnInteger;
            Optional<SmallObject> optionalOfSmallObject;
            SmallObject(int number){
                anInteger = number;
                optionalOfAnInteger = Optional.of(anInteger);
            }

            public void setOptionalOfSmallObject(Optional<SmallObject> optionalOfSmallObject) {
                this.optionalOfSmallObject = optionalOfSmallObject;
            }
        }

        SmallObject smallObject = new SmallObject(9000);
        SmallObject smallObject1 = new SmallObject(18000);
        smallObject.setOptionalOfSmallObject(Optional.of(smallObject1));
        smallObject1.setOptionalOfSmallObject(Optional.of(smallObject));

        Optional<Integer> maybe = smallObject.optionalOfAnInteger.map(num->num/2);
        Optional<Integer> definitely = smallObject.optionalOfAnInteger.flatMap(num->Optional.of(num/2));


        Optional<SmallObject> optionalSmallObject = smallObject.optionalOfSmallObject.flatMap(mySmallObject->mySmallObject.optionalOfSmallObject);
        Optional<SmallObject> optionalSmallObject1 = smallObject1.optionalOfSmallObject.map(mySmallObject->mySmallObject.optionalOfSmallObject.get());

    }
}
