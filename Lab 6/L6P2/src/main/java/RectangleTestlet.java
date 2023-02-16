/**
 * @author Robert Myers
 * @author Dominick Carlucci
 * @author Stuart Walters
 * Runs an object testlet given a command-line argument. For example RectangleTestlet or BoxTestlet
 */
public class RectangleTestlet implements TestletIF {
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