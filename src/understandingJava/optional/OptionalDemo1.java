package understandingJava.optional;

import java.util.Optional;

public class OptionalDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Optional<String> errorMessage = Optional.empty();
		errorMessage.ifPresent((message)->System.out.println("Message not present "+message));
		
		errorMessage = Optional.of(errorMessage.orElse("").concat("hello"));
		
		errorMessage.ifPresent((message)->System.out.println("Message is present here "+message));
		
		
		System.out.println
		(errorMessage.orElse(""));
		
		try {
			
			errorMessage.ifPresent((message)->{
				throw new ArithmeticException(message);
				});
			
		}
		catch(ArithmeticException e)
		{
			System.out.println("caught exception");
		}
		

	}

}
