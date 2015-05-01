package application;

/**
 * Class to set the values of the treatment rooms
 */

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TreatmentRoom {

	/**
	 * variable to get the treatment room number
	 */
	private int roomNumber;

	/**
	 * boolean to indicate if the room is vacant
	 */
	private boolean vacant = true;

	/**
	 * Date to calculate the patient time into the treatment room
	 */
	private Date timeInTreatmentRoom;

	/**
	 * Date to calculate the patient time out of the treatment room
	 */
	private Date timeOutOfTreatmentRoom;

	/**
	 * boolean to show if patient treated
	 */
	public boolean patientTreated;

	/**
	 * instance var to declare the patient in the treatment room
	 */
	Patient patientInTreatmentRoom;
	
	/**
	 * 
	 */
	private WriteToFile writeToFile = new WriteToFile();
	public TreatmentRoom(){
		setTimeInTreatmentRoom(new Date());
		
	}

	/**
	 * Method to get the time the patient has been in the treatment room 
	 * @return
	 */
	public Date getTimeInTreatmentRoom() {
		return timeInTreatmentRoom;
	}

	/**
	 * Method to set the time the patient enters the treatment room 
	 * @param timeInTreatmentRoom
	 */
	public void setTimeInTreatmentRoom(Date timeInTreatmentRoom) {
		if(timeInTreatmentRoom!=null){
		timeOutOfTreatmentRoom=new Date();
		timeOutOfTreatmentRoom.setTime(timeInTreatmentRoom.getTime()
				+ TimeUnit.MINUTES.toMillis(Limits.TIME_IN_TREATMENT_ROOM));
		this.timeInTreatmentRoom = timeInTreatmentRoom;
		}else{
			timeOutOfTreatmentRoom=null;
		}
	}

	/**
	 * Method to get the time the patient leaves the treatment room 
	 * @return
	 */
	public Date getTimeOutOfTreatmentRoom() {
		return timeOutOfTreatmentRoom;
	}

	/**
	 * Method to set the time patient leaves the treatment room 
	 */
	private void setTimeOutOfTreatmentRoom(Date timeOutOfTreatmentRoom) {
		this.timeOutOfTreatmentRoom = timeOutOfTreatmentRoom;
		patientTreated = true;
	}

	/**
	 * Boolean to say if treatment room is vacant 
	 * @return
	 */
	public boolean isVacant() {
		return vacant;
	}

	/**
	 * Method to set if treatment room is vacant 
	 * @param vacant
	 */
	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}

	/**
	 * Method to get room number 
	 * @return
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Method to set room number 
	 * @param roomNumber
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * method to allow extra time to be allocated to treatment rooms
	 */
	public void allocateExtraTime() {

		timeOutOfTreatmentRoom.setTime(timeOutOfTreatmentRoom.getTime()
				+ TimeUnit.MINUTES.toMillis(Limits.EXTENDED_TIME));

	}

	/**
	 * method to establish whether a treatment room is free
	 */
	public void findEmptyTreatmentRoom(Patient patient) {
		vacant = true;
		patient = null;
	}

	/**
	 * method to get the Traige Category of the patient in the Treatment room
	 * 
	 * @param patient
	 * @return
	 */
	public int getPatientTriageCategory() {

		return this.getPatientInTreatmentRoom().getTriageCategory();
	}

	/**
	 * method to get the patient into the treatment treatment room
	 * 
	 * @param patientQueue
	 * @param patient
	 * @return
	 */
	public Patient getPatientInTreatmentRoom() {

		return patientInTreatmentRoom;
	}

	/**
	 * Method to set the patient object in the treatment room 
	 * @param patientInTreatmentRoom
	 */
	public void setPatientInTreatmentRoom(Patient patientInTreatmentRoom) {
		this.patientInTreatmentRoom = patientInTreatmentRoom;
	}

	/**
	 * Method to discharge the patient from the system 
	 * @param allPatients
	 * @param patient
	 * @throws FileNotFoundException 
	 */
	public void dischargePatient(List<Patient> allPatients,Patient patient) throws FileNotFoundException{
		this.patientInTreatmentRoom=null;
		this.setVacant(true);
		this.setTimeInTreatmentRoom(null);
		patient.setLeaveTime(new Date());
		writeToFile.patientLeaveTimeToFile(patient);
	}
	
	/**
	 * Method to remove the patient from the treatment room automatically 
	 * @return
	 */
	public boolean removePatientFromTreatmentroomAutomatically(){

		if((this.timeOutOfTreatmentRoom.getTime()-new Date().getTime())/1000<2){
			this.patientInTreatmentRoom.setLeaveTime(new Date());
			this.setPatientInTreatmentRoom(null);
			this.setVacant(true);
			
			return true;
		}else{
			return false;
		}
	}
}