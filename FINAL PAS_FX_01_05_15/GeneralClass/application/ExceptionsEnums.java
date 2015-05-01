package application;

/**
 * Enums to hold the messages to be displayed when HospitalPASExceptions are
 * thrown
 * 
 *
 */

public enum ExceptionsEnums {
	
	/**
	 * List of ENums to be used in the exceptions
	 */

	NHSNUMBEREXCEPTION("Invald NHS Number"), UNABLETOTRIAGE(
			"Unable to triage this patient"), PATIENTALREADYTRIAGED(
			"Sorry this patient has already been triaged"), CANTRECOGNISEPATIENT(
			"Unable to recognise this patient. Try again"), PATIENTALREADYREGISTERED(
			"Sorry patient already registered"), PATIENTNOTINDATABASE(
			"Sorry this patient is not in the database.  Try again"), QUEUELIMITEXCEEDED(
			"Unable to add this patient to queue, queue limit has been reached.  On Call have been called"), ONCALLENGAGEDEXCEPTION(
			"OnCallTeam is engaged,the emergency patient is redirected to another hospital"), EMERGENCYSENTTOONCALL(
			"The emergency patient is sent to on call team");

	/**
	 * Variable to hold the data
	 */
	private String exception;

	/**
	 * Constructor with arguements for the ENums
	 * @param exception
	 */
	private ExceptionsEnums(String exception) {
		this.exception = exception;
	}

	/**
	 * method to get the exception
	 * @return
	 */
	public String getException() {
		return exception;
	}

	/**
	 * Method to set the exception 
	 * @param exception
	 */
	public void setException(String exception) {
		this.exception = exception;
	}

}
