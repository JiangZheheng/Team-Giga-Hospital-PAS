package application;

/**
 * class to represent the user exceptions to be used throughout the system
 *
 */
@SuppressWarnings("serial")
public class HospitalPASException extends Exception {

	

	/**
	 * Constructor with arguements  
	 * @param message
	 */
	public HospitalPASException(String message) {
		super(message);

	}

}
