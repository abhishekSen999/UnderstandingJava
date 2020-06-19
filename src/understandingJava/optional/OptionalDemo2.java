package understandingJava.optional;

import java.util.Optional;

public class OptionalDemo2 {

	public static void main(String[] args) {
		
		
		Optional<String>  errorMessage = Optional.empty();
		errorMessage = Optional.of("Test error meassage");
		
		errorMessage.ifPresent((message)->{
			System.out.println(message);
		});
		
		
		
		

	}

}
