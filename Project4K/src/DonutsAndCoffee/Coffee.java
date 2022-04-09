package DonutsAndCoffee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class holds properties of Coffee objects.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Coffee extends MenuItem implements Customizable {

	/**
	 * Creates COFFEE_PRICE_DEFAULT Object of type double.
	 */
    private static final double COFFEE_PRICE_DEFAULT = 1.69;
    
    /**
     * Creates PRICE_PER_ADD_IN Object of type double.
     */
    private static final double PRICE_PER_ADD_IN = 0.30;
    
    /**
     * Creates PRICE_PER_SIZE_UP Object of type double.
     */
    private static final double PRICE_PER_SIZE_UP = 0.40;

    /**
     * Creates SIZE Object of type String[].
     */
    public static final String[] SIZE = {"Short", "Tall", "Grande", "Venti"};
    
    /**
     * Creates ADDIN Objet of type String[].
     */
    public static final String[] ADDIN = {"Cream", "Milk", "WhippedCream", "Syrup", "Caramel"};

    /**
     * Creates size Object of type String.
     */
    private String size;
    
    /**
     * Creates addIns Object of type List String.
     */
    private List<String> addIns;

    /**
     * Coffee constructor.
     * @param size Object of type String.
     * @param addIns Object of type List String.
     * @param quantity Object of type int.
     */
    public Coffee(String size, List<String> addIns, int quantity) {
        super(quantity, 0.0);
        int sizeNum = Arrays.asList(SIZE).indexOf(size);
        double clcPrice = COFFEE_PRICE_DEFAULT + sizeNum * PRICE_PER_SIZE_UP + addIns.size() * PRICE_PER_ADD_IN;
        setPrice(clcPrice);
        this.size = size;
        this.addIns = addIns;
    }

    /**
     * Coffee constructor.
     * @param size Object of type String.
     * @param quantity Object of type int.
     */
    public Coffee(String size, int quantity) {
        super(quantity, 0.0);
        addIns = new ArrayList<>();

        setPrice(itemPrice());
        this.size = size;
        this.addIns = new ArrayList<>();
    }

    /**
     * Sets the size of a Coffee object.
     *
     * @param newSize the desired size
     */
    public void setSize(String newSize) {
        this.size = newSize;
    }

    /**
     * A method that calculates and returns the price of the item.
     *
     * @return current item price.
     */
    @Override
    public double itemPrice() {
        int sizeNum = Arrays.asList(SIZE).indexOf(size);
        return (COFFEE_PRICE_DEFAULT + sizeNum * PRICE_PER_SIZE_UP + addIns.size() * PRICE_PER_ADD_IN)
                * super.getQuantity();
    }

    /**
     * A method that adds add-ins to a Coffee Object.
     *
     * @param obj object to be added to the add-ins for Coffee
     * @return true if add-in successful, false if not.
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof String) {
            String addIn = (String) obj;
            if (Arrays.asList(ADDIN).contains(addIn)) {
                addIns.add(addIn);
                return true;
            }
        }
        return false;
    }

    /**
     * A method that removes add-ins from a Coffee object.
     *
     * @param obj object to be added
     * @return true if add-in removed, false if not.
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof String) {
            String addIn = (String) obj;
            return addIns.remove(addIn);
        }
        return false;
    }

    /**
     * A method that checks if one coffee object is equal to another.
     *
     * @param obj Coffee object to be checked against
     * @return true if equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coffee) {
            Coffee other = (Coffee) obj;

            if (!this.size.equals(other.size)) {
                return false;
            }

            if (this.addIns.size() != other.addIns.size()) {
                return false;
            }

            for (String addIn : addIns) {
                if (!other.addIns.contains(addIn)) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    /**
     * This method returns the string representation of a Coffee object.
     *
     * @return String representation of Coffee object
     */
    @Override
    public String toString() {
        String myCoffee = "Coffee (" + this.getQuantity() + ") " + size;

        if (addIns.size() > 0) {
            myCoffee += addIns.toString();
        }

        return myCoffee;
    }
}
