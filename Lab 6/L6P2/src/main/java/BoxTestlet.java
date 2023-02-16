/**
 * @author Robert Myers
 * @author Dominick Carlucci
 * @author Stuart Walters
 * Implements TestletIF. Runs a series of boundary value analysis between 1 and 10 for the getVolume method
 */
public class BoxTestlet implements TestletIF {

    /**
     * Overriden function from TestletIF
     * @return True if all tests pass, false if not
     */
    @Override
    public boolean runTest() {
        TestHarness harness = new TestHarness();
        double l = 1.0;
        double w = 1.0;
        double h = 1.0;
        double expected = 1.0;
        double actual = Box.getVolume(l, w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        l = 1.0;
        w = 1.0;
        h = 10.0;
        expected = 10.0;
        actual = Box.getVolume(l, w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        l = 1.0;
        w = 10.0;
        h = 1.0;
        expected = 10.0;
        actual = Box.getVolume(l, w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        l = 10.0;
        w = 1.0;
        h = 1.0;
        expected = 10.0;
        actual = Box.getVolume(l, w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        l = 1.0;
        w = 10.0;
        h = 10.0;
        expected = 100.0;
        actual = Box.getVolume(l, w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        l = 10.0;
        w = 1.0;
        h = 10.0;
        expected = 100.0;
        actual = Box.getVolume(l, w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        l = 10.0;
        w = 10.0;
        h = 1.0;
        expected = 100.0;
        actual = Box.getVolume(l, w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        l = 10.0;
        w = 10.0;
        h = 10.0;
        expected = 1000.0;
        actual = Box.getVolume(l, w, h);
        if (!harness.checkEqual(actual, expected)) {
            return false;
        }
        return true;
    }
}