package application;

import java.util.Date;
/**
 * class to control the on call team in situ
 */
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InSitu {

	/**
	 * default constructor
	 */
	public InSitu() {

	}

	/**
	 * constructor with args
	 */

	public InSitu(Patient patient) {
		this.patient = patient;
	}

	private boolean vacant = true;

	/**
	 * Date to calculate the patient time into the treatment room
	 */
	private Date timeInSitu;

	/**
	 * Date to calculate the patient time out of the treatment room
	 */
	private Date timeOutOfInSitu;
	/**
	 * instance var to hold emergency patient
	 */
	private Patient patient;

	/**
	 * method to allow the on call team to treat non-urgent patients in situ
	 * 
	 * @param patientQueue
	 * @param patient
	 */
	public static void controlInSitu(LinkedList<Patient> patientQueue,
			Patient patient) {

		// for loop to iterate through the queue and to return a patient with a
		// triage category of non urgent
		for (int loop = 0; loop <= patientQueue.size(); loop++) {
			if (patient.getTriageCategory() != Triage.EMERGENCY.getLevel()) {
				// remove patient from queue
				patientQueue.remove(patient);
				//put patient in situ
				//treat patient in situ
				//discharge patient
				// need to write patient leaving time to file
			}
		}
	}

	/**
	 * method to check if there is an emergency patient currently inSitu
	 * 
	 * @return
	 */
	public boolean checkEmergencyPatient() {
		if (getPatient() != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * method to set the patient object
	 * 
	 * @param patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;

	}

	/**
	 * method to return the patient object
	 * 
	 * @return
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Boolean to get if vacant space available for patient 
	 * @return
	 */
	public boolean isVacant() {
		return vacant;
	}

	/**
	 * Boolean to set if space for patient 
	 * @param vacant
	 */
	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}

	/**
	 * Method to get time patient enters treatment in situ 
	 * @return
	 */
	public Date getTimeInSitu() {
		return timeInSitu;
	}

	/**
	 * Method to set time patient begins treatment in situ 
	 * @param timeInSitu
	 */
	public void setTimeInSitu(Date timeInSitu) {
		if(timeInSitu!=null){
			timeOutOfInSitu=new Date();
			timeOutOfInSitu.setTime(timeInSitu.getTime()
					+ TimeUnit.MINUTES.toMillis(Limits.TIME_IN_INSITU));
			this.timeInSitu = timeInSitu;
			}else{
				timeOutOfInSitu=null;
			}
	}

	/**
	 * Method to get time patient leaves in situ 
	 * @return
	 */
	public Date getTimeOutOfInSitu() {
		return timeOutOfInSitu;
	}

	/**
	 * Method to set time patient leaves in situ 
	 * @param timeOutOfInSitu
	 */
	public void setTimeOutOfInSitu(Date timeOutOfInSitu) {
		this.timeOutOfInSitu = timeOutOfInSitu;
	}
	
	/**
	 * Method to remove patient from queue automatically once treatment is finished 
	 * @return
	 */
	public boolean removePatientFromTreatmentroomAutomatically() {
		if((this.timeOutOfInSitu.getTime()-new Date().getTime())/1000<2){
			this.patient.setLeaveTime(new Date());
			this.setPatient(null);
			this.setVacant(true);
			
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * Method to control the alerts to the manager 
	 * @return
	 */
	public boolean alertManager(){
		if((this.timeOutOfInSitu.getTime()-this.getTimeInSitu().getTime())/1000/60>=Limits.TIME_IN_INSITU){
//			new ManagerSMSAlerts().sendSSMSManagerOnCallFullyEngaged();
			System.out.println("sendSSMSManagerOnCallFullyEngaged()");
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Method to discharge the patients from the queue 
	 * @param allPatients
	 * @param patient
	 */
	public void dischargePatient(List<Patient> allPatients,Patient patient){
		this.setPatient(null);
		this.setVacant(true);
		this.setTimeInSitu(null);
		patient.setLeaveTime(new Date());
		
	}
	
	/**
	 * Method to allocate extra time to patients 
	 */
	public void allocateExtraTime() {

		timeOutOfInSitu.setTime(timeOutOfInSitu.getTime()
				+ TimeUnit.MINUTES.toMillis(Limits.EXTENDED_TIME));

	}
}
