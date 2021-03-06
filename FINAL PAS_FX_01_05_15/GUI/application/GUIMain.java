package application;

import java.io.FileNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class controls the FX application
 * 
 *
 */
public class GUIMain extends Application {
	/**
	 * array list for In Situ Rooms
	 */
	public static ArrayList<InSitu> inSitus;

	/**
	 * all treatment room in PAS,it is global variable
	 */
	public static ArrayList<TreatmentRoom> treatmentRoomList;

	/**
	 * all patient in PAS,it is global variable
	 */
	public static LinkedList<Patient> allPatientList;
	/**
	 * Linked list for patient Queue
	 */
	public static LinkedList<Patient> patientQueue;
	/**
	 * declaration of write to file class
	 */
	public static WriteToFile writeToFile = new WriteToFile();
	/**
	 * static var for sort patient queue
	 */
	public static SortPatientQueue sortPatientQueue;
	/**
	 * static int for status
	 */
	public static int status;
	/**
	 * static declaration for next patient from pateint class
	 */
	public static Patient nextPatient;
	/**
	 * declaration of On call class
	 */
	public static OnCall onCall = new OnCall();

	public static void main(String[] args) {

		launch(args);

	}

	/**
	 * Sets the stage for the JavaFX to run on
	 */
	public void start(Stage primaryStage) {
		initialise();
		try {

			Parent root = FXMLLoader.load(getClass().getResource(
					"/application/LoginScreen.fxml"));

			Scene scene = new Scene(root, 450, 400);

			primaryStage.setTitle("Hospital PAS");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			threadStart();
			alertThread();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Thread to manage the alerts
	 */
	private void alertThread() {
		System.out.println("alertThreadForQueueSize");
		Thread alertThread = new Thread() {

			@Override
			public void run() {
				// delay the thread to ensure message is only sent once
				boolean delay = false;

				try {
					while (true) {
						while (!delay) {
							Thread.sleep(1000);

							if (sortPatientQueue
									.calculateQueueSize(GUIMain.patientQueue)) {
								delay = true;
							}
						}
						delay = false;
						Thread.sleep(1000 * 60*30);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		};

		alertThread.setDaemon(true);
		alertThread.start();

		System.out.println("alertThreadForSitu");
		Thread inSituThread = new Thread() {
			/**
			 * Thread for in situ class
			 */
			@Override
			public void run() {

				boolean delay = false;

				try {
					while (true) {
						while (!delay) {
							Thread.sleep(1000);

							for (InSitu inSitu : inSitus)
								try {
									{
										if (inSitu.isVacant() == false) {

											if (inSitu.alertManager()) {
												delay = true;
											}
										}
									}
								} catch (AddressException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (MessagingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
						delay = false;
						Thread.sleep(1000 * 60*30);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		};

		inSituThread.setDaemon(true);
		inSituThread.start();

		System.out.println("alertThreadForThirtyMin");
		Thread alertThreadForThirtyMinAlert = new Thread() {

			@Override
			public void run() {
				// delay the thread to ensure message is only sent once
				boolean delay = false;

				try {
					while (true) {
						while (!delay) {
							Thread.sleep(1000);

							if (sortPatientQueue
									.thirtyMinuteManagerAlert(patientQueue)) {

								delay = true;
							}
						}
						delay = false;
						Thread.sleep(1000 * 60*30);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		};

		alertThreadForThirtyMinAlert.setDaemon(true);
		alertThreadForThirtyMinAlert.start();
	}

	/**
	 * method to start the thread for the whole system
	 */
	private void threadStart() {
		System.out
				.println("Thread Starting.. show next Patient, "
						+ "allocate the next patient,move patient to the front,"
						+ "remove patient from treatment and situ if time is out,"
						+ "calculate the status, write queue into file");
		Thread queueThread = new Thread() {

			@Override
			public void run() {

				try {
					while (true) {
						Thread.sleep(1000);
						nextPatient = patientQueue.peek();

						GUIMain.status=sortPatientQueue.calculateStatus(patientQueue);
						sortPatientQueue.allocatePatientToTreatmentRoom(
								patientQueue, patientQueue.peek(),
								treatmentRoomList);

						sortPatientQueue.movePatientToTopOfQueue(patientQueue);

						for (TreatmentRoom treatmentRoom : treatmentRoomList) {
							if (treatmentRoom.isVacant() == false) {
								treatmentRoom
										.removePatientFromTreatmentroomAutomatically();
							}
						}
						for (InSitu inSitu : inSitus) {
							if (inSitu.isVacant() == false) {
								inSitu.removePatientFromTreatmentroomAutomatically();
							}
						}
						try {
							writeToFile.writeQueueToFile(GUIMain.patientQueue);
						} catch (FileNotFoundException e) {

							e.printStackTrace();
						}

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		};

		queueThread.setDaemon(true);
		queueThread.start();
	}

	/**
	 * method to initialise variables
	 */
	public void initialise() {
		inSitus = new ArrayList<InSitu>();
		patientQueue = new LinkedList<Patient>();
		allPatientList = new LinkedList<Patient>();
		treatmentRoomList = new ArrayList<TreatmentRoom>();
		status = 1;
		nextPatient = new Patient();
		for (int loop = 0; loop < Limits.NUMBERS_OF_ROOM; loop++) {
			treatmentRoomList.add(new TreatmentRoom());
		}
		for (int loop = 0; loop < 2; loop++) {
			inSitus.add(new InSitu());
		}
		sortPatientQueue = new SortPatientQueue();

	}

	/**
	 * Method to pull the staff details from the database
	 * 
	 * @return
	 */
	public static ArrayList<Staff> getAllStaff() {
		ArrayList<Staff> allStaff = new ArrayList<Staff>();
		String url = "jdbc:mysql://web2.eeecs.qub.ac.uk/40108307";
		Connection con;
		Statement stmt; // loading driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		// making the connection
		try {
			con = DriverManager.getConnection(url, "40108307", "CZB6355");
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute

			ResultSet rs = stmt.executeQuery("select * from STAFF");
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setStaffID(Integer.parseInt(rs.getString("STAFF_ID")));
				staff.setTitle(rs.getString("TITLE"));
				staff.setFirstName(rs.getString("FIRST_NAME"));
				staff.setLastName(rs.getString("LAST_NAME"));
				staff.setPassword(rs.getString("STAFF_PASSWORD"));
				staff.setRole(rs.getString("STAFF_ROLE"));
				staff.setTeam(rs.getString("STAFF_TEAM"));
				staff.setEmail(rs.getString("EMAIL_ADDRESS"));
				staff.setTelephone(rs.getString("TELEPHONE"));

				allStaff.add(staff);
			}
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return allStaff;
	}

}// end of GUIMain Class

