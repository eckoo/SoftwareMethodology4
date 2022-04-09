package DonutsAndCoffee;

/**
 * This class holds properties of the Donut object.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Donut extends MenuItem {

	/**
	 * Creates YEAST_FLAVORS Object of type String[].
	 */
    public static final String[] YEAST_FLAVORS = {"Jelly Filled", "Boston Kreme", "Strawberry Lemon Swirl"};
    
    /**
     * Creates CAKE_FLAVORS Object of type String[].
     */
    public static final String[] CAKE_FLAVORS = {"Maple Frosted", "Blueberry Cake", "Icecream Cake"};
    
    /**
     * Creates HOLE_FLAVORS Object of type String[].
     */
    public static final String[] HOLE_FLAVORS = {"Choloco", "Glazed", "Berry Beautiful"};

    /**
     * Creates type Object of type DonutTypes.
     */
    private DonutTypes type;
    
    /**
     * Creates flavor Object of type String.
     */
    private String flavor;

    /**
     * This constructor initializes a Donut object with its properties.
     *
     * @param quantity the number of donuts
     * @param type the type of donut
     * @param flavor the donut flavor
     */
    public Donut(int quantity, DonutTypes type, String flavor) {
        super(quantity, type.getPrice());

        this.type = type;
        this.flavor = flavor;
    }

    /**
     * This method fetches the price of a Donut object.
     *
     * @return a double, the price of a Donut object.
     */
    @Override
    public double itemPrice() {
        return super.getPrice() * super.getQuantity();
    }

    /**
     * This method checks if two Donut objects are equal.
     *
     * @param obj Donut object to be checked against
     * @return true if the objects are equal, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Donut) {
            Donut other = (Donut) obj;

            if (this.type != other.type) {
                return false;
            }
            return flavor.equals(other.flavor);

        }

        return false;
    }

    /**
     * This method returns a String representation of a Donut object.
     *
     * @return String representation of a Donut object.
     */
    @Override
    public String toString() {
        return flavor + "(" + getQuantity() + ")";
    }
}
