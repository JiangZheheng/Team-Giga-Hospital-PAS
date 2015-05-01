package application;

/**
 * Enums to hold the content to be used in the SMS Alerts Classes for the On Call Team and the Hospital Manager
 *
 */

public enum AlertsENums {

	SMSALERTONCALLTEAM(
			"On Call Team Needed in A and E. Queue capacity has reached the maximum"), ALERTMANAGERONCALLFULLYENGAGED(
			"On Call team fully engaged.  Patients being redirected"), ALERTMANAGERWAITINGTIME(
			"Two or more patients have been waiting over 30 minutes"), SMSUSERNAME(
			"hospitalsender@outlook.com"), SMSHASHKEY(
			"41b6105030728d7adeb182a5c5700c8343b9d307"), SMSSENDER(
			"hospitalPAS"), SMSCONNECTION("https://api.txtlocal.com/send/?");

	/**
	 * variable to hold the Alert converted to a String value
	 */
	private String alert;

	/**
	 * Constructor with arguments for the Alerts Enums
	 * @param alert
	 */
	private AlertsENums(String alert) {
		this.alert = alert;
	}

	/**
	 * method to get the Alert as a String value
	 * @return
	 */
	public String getAlert() {
		return alert;
	}

	/**
	 * method to set the Alert as a String value
	 * @param alert
	 */
	public void setAlert(String alert) {
		this.alert = alert;
	}

}
