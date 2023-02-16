/**
 * @author Robert Myers
 * @author Dominick Carlucci
 * @author Stuart Walters
 * TestHarness holds two overriden checkEquals functions.
 * One for taking in actual and expected as ints.
 * Another for taking actual and expected as doubles
 */
public class TestHarness {
    public boolean checkEqual(int actual, int expected){
        return actual == expected;
    }
    public boolean checkEqual(double actual, double expected){
        return actual == expected;
    }
}
