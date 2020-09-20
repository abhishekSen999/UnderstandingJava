package understandingJava.exception;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;

public class UnderstandingExceptionFlowAndStackTrace {
    public static void main(String[] args) throws Exception {
        UnderstandingFlow obj = new UnderstandingFlow();
        obj.callingFunction();
    }

}

class UnderstandingFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnderstandingFlow.class);

    public void callingFunction() throws Exception {
        int dummyResult = getDummyResult();
        System.out.println("dummyResult = " + dummyResult);
    }

    private int getDummyResult() throws Exception {
//        if (true){
//            LOGGER.trace("exception will be thrown now");
//            throw new Exception("HAHAException");
//        }
        try {
            createException();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();

            throw e;
        }

    }

    private void createException()throws Exception{
        throw new Exception("HAHAHA Exception");
    }
}
