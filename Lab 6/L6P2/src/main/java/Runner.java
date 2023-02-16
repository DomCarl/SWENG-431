/**
 * @author Robert Myers
 * @author Dominick Carlucci
 * @author Stuart Walters
 * @version 1.0
 * Runs an object testlet given a command-line argument. For example RectangleTestlet or BoxTestlet
 */
public class Runner {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Class.forName(args[0]);   // Create a class from a command-line argument at position 0
        Object o = c.newInstance();         // Create an instance (object) of class from previous line
        TestletIF test = (TestletIF) o;     // Cast this class as a Testlet
        boolean result = test.runTest();    // Call the run function
        System.out.println(result ? "Passed" : "False");    // Ternary for printing results of test
    }
}
