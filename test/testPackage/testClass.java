package testPackage;

import org.testng.annotations.Test;

public class testClass {
    @Test
    public void learnForLoop() {

        int userCount = 1;
        String code = "name|";

        /*
         * String[] userCode = code.split(",");
         * 
         * for (String x : userCode) { System.out.println(x);
         * 
         * }
         */

        for (int i = 0; i < userCount; i++) {
            String[] userCode = code.split("\\|");
            System.out.println(userCode[i]);
            System.out.println(code);

        }

    }

}
