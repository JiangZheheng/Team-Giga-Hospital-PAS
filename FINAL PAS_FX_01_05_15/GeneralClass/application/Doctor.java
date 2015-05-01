package application;

import java.util.LinkedList;

/**
 * Class to contain the details of the Doctor, extending Staff Class, and
 * including methods that the doctor can use throughout the system. Implements
 * ILogin and ICategorise
 *
 */

public class Doctor extends Staff implements ILogin, ICategorise {

	/**
	 * Default constructor for Doctor Class
	 */
	public Doctor() {

	}

	/**
	 * constructor with arguments for doctor Class
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param staffID
	 * @param password
	 */
	public Doctor(String title, String firstName, String lastName, char gender,
			int staffID, String password) {
		super(title, firstName, lastName, gender, staffID, password);

	}

	/**
	 * unimplemented method from ICategorise interface - only to be used by the
	 * Triage Nurse, as a doctor can only alter the Triage category of a patient
	 * 
	 * @return
	 */
	@Override
	public boolean categorisePatient(LinkedList<Patient> allPatients,
			LinkedList<Patient> patientQueue, Patient patient, Triage triage)
			throws HospitalPASException {
		return false;

	}

	/**
	 * method to allow a doctor to alter the Triage Category of a patient should
	 * their condition change - can be used in both the Treatment Rooms and the
	 * Patient Queue
	 */
	@Override
	public boolean recategorisePatient(LinkedList<Patient> patientQueue,
			Patient patient, Triage triage) throws HospitalPASException {
		// if statement to check that the patient is not a null value before assigning them a Triage category
		if (patient != null) {
			//sets the patient category
			patient.setTriageCategory(triage);
			// sorts the patient queue by triage category
			patientQueue.sort(new SortPatientComparator());
			return true;
		} else {
			throw new HospitalPASException(
					ExceptionsEnums.CANTRECOGNISEPATIENT.getException());
		}

	}

	/**
	 * Method to allow the Doctor to place the Patient back into the queue once
	 * their triage category has be reassigned
	 */
	@Override
	public boolean putPatientIntoQueue(LinkedList<Patient> patientQueue,
			Patient patient) {
		boolean inQueue = false;

		// if statement to ensure that the queue limit has not been reached
		// before the Doctor can place the patient into the queue
		if (patientQueue.size() < Limits.PATIENT_LIMIT_IN_QUEUE) {
			// adds patient to queue
			patientQueue.add(patient);
			// sorts the patient queue by triage category
			patientQueue.sort(new SortPatientComparator());
			inQueue = true;
		}

		return inQueue;
	}

}