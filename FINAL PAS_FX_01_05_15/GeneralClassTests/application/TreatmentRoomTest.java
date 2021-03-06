package application;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreatmentRoomTest {

	/**
	 * set up test data 
	 */
	int roomNumber;
	boolean vacant, patientTreated;
	Date timeInTreatmentRoom, timeOutOfTreatmentRoom;
	Patient patientInTreatmentRoom;

	/**
	 * Test constructor
	 */
	@Test
	public void testTreatmentRoomDefaultConstructor() {
		TreatmentRoom treatmentroom = new TreatmentRoom();
		assertNotNull(treatmentroom);
	}

	/**
	 * Test constructor with arguements 
	 */
	@Test
	public void testTimeInTreatmentRoom() {
		TreatmentRoom treatmentroom = new TreatmentRoom();
		Date expected = new Date();
		treatmentroom.setTimeInTreatmentRoom(expected);
		Date actual = treatmentroom.getTimeInTreatmentRoom();
		assertEquals(expected, actual);
	}
	
	
	
/**
 * test of get and set for treatment room number
 */
	@Test
	public void testRoomNumber() {
		TreatmentRoom treatmentroom = new TreatmentRoom();
		int expected = 1;
		treatmentroom.setRoomNumber(expected);
		int actual = treatmentroom.getRoomNumber();
		assertEquals(expected, actual);
	}

	/**
	 * test getter and setter for patient in treatment room
	 */
	@Test
	public void testGetSetPatientInTreatmentRoom() {
		TreatmentRoom treatmentroom = new TreatmentRoom();
		Patient patient = new Patient();
		Patient expected = patient;
		treatmentroom.setPatientInTreatmentRoom(patient);
		Patient actual = treatmentroom.getPatientInTreatmentRoom();
		assertEquals(expected, actual);
	}
}
