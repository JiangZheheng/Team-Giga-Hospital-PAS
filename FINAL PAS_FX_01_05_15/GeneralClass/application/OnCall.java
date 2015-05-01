package application;

/**
 * 
 * Class to control on call alerts 
 *
 */
public class OnCall {

	/**
	 * Boolean to say if on call team are engaged 
	 */
	private boolean onCallEngaged1=false;
	
	/**
	 * Boolean to say if on call team are engaged 
	 */
	private boolean onCallEngaged2=false;

	/**
	 * Instatiation of the insitu object 
	 */
	private InSitu inSitu;

	/**
	 * Instantiation of the patient object 
	 */
	private Patient patient;


	/**
	 * method to check if there are emergency patients waiting to be treated
	 * inSitu if the onCall team have been called and if there are none the
	 * onCall team begin treating patients from the Queue
	 */
	public void checkInSituForEmergencyPatients() {
		if ((onCallEngaged1 == true) && (inSitu.checkEmergencyPatient() == false)&&(onCallEngaged2 == true)) {
			InSitu.controlInSitu(GUIMain.patientQueue, patient);
		} else {
			treatEmergency();
		}
	}
	
	/**
	 * Method to set patient to be treated insitu 
	 */
	public void treatEmergency(){
		inSitu.getPatient();
		inSitu.setPatient(null);
	}

	/**
	 * Boolean to get if on call team 1 currently engaged 
	 * @return
	 */
	public boolean isOnCallEngaged1() {
		return onCallEngaged1;
	}

	/**
	 * Method to set if on call team 1 engaged 
	 * @param onCallEngaged1
	 */
	public void setOnCallEngaged1(boolean onCallEngaged1) {
		this.onCallEngaged1 = onCallEngaged1;
	}

	/**
	 * Method to get is on call team 2 engaged 
	 * @return
	 */
	public boolean isOnCallEngaged2() {
		return onCallEngaged2;
	}

	/**
	 * Method to set if on call team 2 engaged 
	 * @param onCallEngaged2
	 */
	public void setOnCallEngaged2(boolean onCallEngaged2) {
		this.onCallEngaged2 = onCallEngaged2;
	}
}
