/**
 * @author Robert Myers
 * @author Dominick Carlucci
 * @author Stuart Walters
 */
public class Box {
    /**
     * Default constructor
     */
    public Box(){}

    /**
     *
     * @param l Length
     * @param w Width
     * @param h Height
     * @return Volume of box
     */
    public static double getVolume(double l, double w, double h){
        return l * w * h;
    }
}
