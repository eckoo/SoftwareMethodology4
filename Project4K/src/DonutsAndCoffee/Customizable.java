package DonutsAndCoffee;

/**
 * This interface allows us to add and remove Objects.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public interface Customizable {

	/**
	 * Interface add() method.
	 * @param obj Object of type Object.
	 * @return obj Object of type Object.
	 */
    boolean add(Object obj);

    /**
	 * Interface remove() method.
	 * @param obj Object of type Object.
	 * @return obj Object of type Object.
	 */
    boolean remove(Object obj);
}
