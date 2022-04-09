package DonutsAndCoffee;

/**
 * enum class for DonutTypes and related actions.
 * @author Kiernan King and Ahmed Alghazwi.
 *
 */
public enum DonutTypes {
		/**
		 * Creates YEASTDONUT enum Object.
		 */
	    YEASTDONUT("Yeast Donuts", 1.59),
	    
	    /**
	     * Creates CAKEDONUT enum Object.
	     */
	    CAKEDONUT("Cake Donuts", 1.79),
	    
	    /**
	     * Creates DONUTHOLES enum Object.
	     */
	    DONUTHOLES("Donut Holes", 0.39);
		
		/**
		 * Creates value Object of type String.
		 */
	    private String value;
	    
	    /**
	     * Creates price Object of type double.
	     */
	    private double price;

	    /**
	     * getPrice returns the current price of the object.
	     * @return price Object of type double.
	     */
	    public double getPrice() {
	        return price;
	    }
	    
	    /**
	     * getValue returns the current type of the donut.
	     * @param type Object of type String.
	     * @return donut type if recognized type, null if not.
	     */
	    public static DonutTypes getValue(String type) {
	        switch (type) {
	            case "Yeast Donuts":
	                return YEASTDONUT;
	            case "Cake Donuts":
	                return CAKEDONUT;
	            case "Donut Holes":
	                return DONUTHOLES;
	        }

	        return null;
	    }
	    
	    /**
	     * DonutTypes constructor method.
	     * @param value Object of type String.
	     * @param price Object of type double.
	     */
	    private DonutTypes(String value, double price) {
	        this.value = value;
	        this.price = price;
	    }
	    
	    /**
	     * toString returns String representation of the donut.
	     * @return value Object of type String.
	     */
	    @Override
	    public String toString() {
	        return value;
	    }
}
