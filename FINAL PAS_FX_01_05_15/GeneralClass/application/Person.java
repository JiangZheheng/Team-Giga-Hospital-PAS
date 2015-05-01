package application;

/**
 * 
 * Abstract class to create the attributes of a person 
 *
 */

public abstract class Person {

	/**
	 * Creation of vars 
	 */
	private String title;
	private String firstName;
	private String lastName;
	private char gender;

	/**
	 * default constructor
	 */
	public Person() {

	}

	/**
	 * constructor with args
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 */
	public Person(String title, String firstName, String lastName, char gender) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	/**
	 * 
	 * @return title of person
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Method that sets the title of the person 
	 * @param title
	 *    
	 */
	public void setTitle(String title) throws NullPointerException {
		if (title.isEmpty()) {
			throw new NullPointerException();
		} else {

			this.title = title;
		}
	}

	/**
	 * Method to get the first name
	 * @return persons first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method to set the first name 
	 * @param firstName
	 *         
	 */
	public void setFirstName(String firstName) throws NullPointerException {
		if (firstName.isEmpty()) {
			throw new NullPointerException();
		} else {
			this.firstName = firstName;
		}
	}

	/**
	 * Method to get the last name 
	 * @return last name of person
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Method to set the last name 
	 * @param lastName
	 *            
	 */
	public void setLastName(String lastName) throws NullPointerException {
		if (lastName.isEmpty()) {
			throw new NullPointerException();
		} else {
			this.lastName = lastName;
		}
	}

	/**
	 * Method to get the gender 
	 * @return gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * gender as a char - must be M/m for male or F/f for female.
	 * 
	 * @param gender
	 * @throws IllegalArgumentException
	 *             if invalid input
	 */
	public void setGender(char gender) throws IllegalArgumentException {
		if ((gender == 'M') || (gender == 'F')) {
			this.gender = gender;
		} else if ((gender == 'm') || (gender == 'f')) {
			this.gender = gender;
		} else {
			throw new IllegalArgumentException("Wrong Gender Input");
		}
	}

	
}