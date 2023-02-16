/**
 * @author Robert Myers
 * @author Dominick Carlucci
 * @author Stuart Walters
 * Implements TestletIF. Runs a series of boundary value analysis between 1 and 10 for the getArea method
 */
public class RectangleTestlet implements TestletIF {

    /**
     * Overriden function from TestletIF
     * @return True if all tests pass, false if not
     */
    @Override
    public boolean runTest() {
        TestHarness harness = new TestHarness();
        int w = 1;
        int h = 1;
        int expected = 1;
        int actual = Rectangle.getArea(w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        w = 1;
        h = 10;
        expected = 10;
        actual = Rectangle.getArea(w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        w = 10;
        h = 1;
        expected = 10;
        actual = Rectangle.getArea(w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        w = 10;
        h = 10;
        expected = 100;
        actual = Rectangle.getArea(w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        return true;
    }
}