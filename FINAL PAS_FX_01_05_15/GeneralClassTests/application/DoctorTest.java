package application;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class DoctorTest {

	// test data
	String validTitle, invalidTitle, validFirstName, invalidFirstName,
			validLastName, invalidLastName, validPassword, invalidPassword;
	char validGender, invalidGender;
	int validStaffID, invalidStaffID;

	/**
	 * set up test data 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		validTitle = "ValidTitle";
		invalidTitle = null;
		validFirstName = "ValidFirstName";
		invalidFirstName = null;
		validLastName = "ValidLastName";
		invalidLastName = null;
		validPassword = "ValidPassword";
		invalidPassword = null;
		validGender = 'F';
		invalidGender = 'Y';
		validStaffID = 1001;
		invalidStaffID = -1;
	}

	/**
	 * Default constructor test 
	 */
	@Test
	public void testDoctorDefaultConstructor() {
		Doctor doctor = new Doctor();
		assertNotNull(doctor);
	}

	/**
	 * testing  constructor with valid arguments
	 */
	@Test
	public void testDoctorConstructor() {
		Doctor doctor = new Doctor(validTitle, validFirstName, validLastName,
				validGender, validStaffID, validPassword);
		assertNotNull(doctor);
		assertEquals(validGender, doctor.getGender());
		assertEquals(validTitle, doctor.getTitle());
		assertEquals(validFirstName, doctor.getFirstName());
		assertEquals(validLastName, doctor.getLastName());
		assertEquals(validStaffID, doctor.getStaffID());
		assertEquals(validPassword, doctor.getPassword());
	}
	
	/**
	 * testing  constructor with invalid arguments
	 */
	@Test
	public void testDoctorConstructorInvalid(){
		Doctor doctor = new Doctor(invalidTitle, invalidFirstName, invalidLastName,
				invalidGender, invalidStaffID, invalidPassword);
		assertNotNull(doctor);
		assertEquals(invalidGender, doctor.getGender());
		assertEquals(invalidTitle, doctor.getTitle());
		assertEquals(invalidFirstName, doctor.getFirstName());
		assertEquals(invalidLastName, doctor.getLastName());
		assertEquals(invalidStaffID, doctor.getStaffID());
		assertEquals(invalidPassword, doctor.getPassword());
	}
	
	

	/**
	 * Test catagorise patient method
	 */
	@Test
	public void testCategorisePatient() {
		Doctor doctor = new Doctor();
		Patient patient = new Patient();
		Triage triage = Triage.SEMI_URGENT;
		LinkedList<Patient> patientQueue  = new LinkedList<Patient>();
		LinkedList<Patient> allPatients = new LinkedList<Patient>();
		
		try {
			doctor.categorisePatient(allPatients, patientQueue, patient, triage);
		} catch (HospitalPASException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test to recatagorise patient methods 
	 */
	@Test
	public void testRecategorisePatient() {
		Doctor doctor = new Doctor();
		Patient patient = new Patient();
		Triage triage = Triage.EMERGENCY;
		LinkedList<Patient> patientQueue  = new LinkedList<Patient>();
		LinkedList<Patient> allPatients = new LinkedList<Patient>();
		
		try {
			doctor.categorisePatient(allPatients, patientQueue, patient, triage);
		} catch (HospitalPASException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test the put patient into queue method with a true value 
	 */
	@Test
	public void testPutPatientIntoQueue() {
		boolean inQueue = true;
		Patient patient = new Patient();
		LinkedList<Patient> patientQueue  = new LinkedList<Patient>();
		
		Doctor doctor = new Doctor();
		doctor.putPatientIntoQueue(patientQueue, patient);
		assertTrue(inQueue);
		
	}

	/**
	 * Test the put patient into queue method with a false value 
	 */
	@Test
	public void testPutPatientIntoQueueFalse() {
		boolean inQueue = false;
		Patient patient = new Patient();
		LinkedList<Patient> patientQueue  = new LinkedList<Patient>();
		
		Doctor doctor = new Doctor();
		doctor.putPatientIntoQueue(patientQueue, patient);
		assertFalse(inQueue);
		
	}
}
