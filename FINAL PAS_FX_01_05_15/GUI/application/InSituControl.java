package application;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * The class controls the In Situ page
 * 
 * @author Paul
 *
 */
public class InSituControl implements Initializable {
	/**
	 * static var declaration for inSitu
	 */
	public static InSitu inSitu;
	/**
	 * declaration of patient from patient class
	 */
	private Patient patient;
	/**
	 * declaration of telephone text area
	 */
	@FXML
	private TextArea telephoneTextArea1;
	/**
	 * declaration of label for first name
	 */
	@FXML
	private Label firstName1;
	/**
	 * declaration of label for blood group
	 */
	@FXML
	private Label bloodGroup1;
	/**
	 * declaration of button for back
	 */
	@FXML
	private Button back;
	/**
	 * declaration of last name text area
	 */
	@FXML
	private TextArea lastNameTextArea1;
	/**
	 * declaration of text area for text box 21
	 */
	@FXML
	private TextArea textBox21;
	/**
	 * declaration of allergies text area
	 */
	@FXML
	private TextArea allergiesTextArea1;
	/**
	 * declaration of label for last name
	 */
	@FXML
	private Label lastName1;
	/**
	 * declaration of button for discharge patient
	 */
	@FXML
	private Button dischargePatient1;
	/**
	 * declaration for log out button
	 */
	@FXML
	private Button logOut1;
	/**
	 * declaration of triage cat label
	 */
	@FXML
	private Label triageCategory1;
	/**
	 * declaration of label for timer
	 */
	@FXML
	private Label timer1;
	/**
	 * declaration for text  area for first name
	 */
	@FXML
	private TextArea firstNameTextArea1;
	/**
	 * declaration of label for address
	 */
	@FXML
	private Label address1;
	/**
	 * declaration of button for further action
	 */
	@FXML
	private Button furtherAction1;
	/**
	 * declaration of label for title
	 */
	@FXML
	private Label title1;
	/**
	 * declaration of text area for blood group
	 */
	@FXML
	private TextArea bloodGroupTextArea1;
	/**
	 * declaration of button for recatrogise patient
	 */
	@FXML
	private Button recategorisePatient1;
	/**
	 * declaration for nhs label
	 */
	@FXML
	private Label nhsNumber;
	/**
	 * declaration for text box area
	 */
	@FXML
	private TextArea textBox11;
	/**
	 * declaration of text area for triage cat
	 */
	@FXML
	private TextArea triageCategoryTextArea1;
	/**
	 * declaration of nhs text area
	 */
	@FXML
	private TextArea nhsNumberTextArea;
	/**
	 * declaration for button of extra time
	 */
	@FXML
	private Button allocateExtraTime1;
	/**
	 * declaration for label - telephone
	 */
	@FXML
	private Label telephoneNumber1;
	/**
	 * declaration of label for patient details
	 */
	@FXML
	private Label patientDetails1;
	/**
	 * declaration for text area address
	 */
	@FXML
	private TextArea addressTextArea1;
	/**
	 * declaration of label for treatment number
	 */
	@FXML
	private Label treatmentRoom11;
	/**
	 * declaration of text area for title
	 */
	@FXML
	private TextArea titleTextArea1;
	/**
	 * declaration of label for allergies
	 */
	@FXML
	private Label allergies1;

	/**
	 * Event to log out the user on the click of the log out button
	 * 
	 * @param event
	 */
	@FXML
	void onClickLogOut(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/LoginScreen.fxml"));
			Scene scene = new Scene(root, 450, 400);
			newStage.setTitle("Hospital Manager");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) logOut1.getScene().getWindow();

		stage.close();

	}

	/**
	 * Method to discharge the patient on click of button
	 * 
	 * @param event
	 */
	@FXML
	void onClickDischargePatient(ActionEvent event) {
		inSitu.dischargePatient(GUIMain.allPatientList, patient);
	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	void onClickFurtherAction(ActionEvent event) {

	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	void onClickRecategorisePatient(ActionEvent event) {

	}

	/**
	 * Alloocates extra time to the patient when clicked by doctor
	 * 
	 * @param event
	 */
	@FXML
	void onClickAllocateExtraTime(ActionEvent event) {
		inSitu.allocateExtraTime();
	}

	/**
	 * Closes the current window
	 * 
	 * @param event
	 */
	@FXML
	void onClickBack(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/DoctorPage.fxml"));
			Scene scene = new Scene(root, 1000, 600);
			newStage.setTitle("Hospital Manager");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) back.getScene().getWindow();

		stage.close();
	}

	/**
	 * launches the page
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		patient = inSitu.getPatient();
		refreshThread();

	}

	private void refreshThread() {
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								patient = inSitu.getPatient();
								refreshPatientInformation();

							}
						});

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		myThread.setDaemon(true);
		myThread.start();
	}

	/**
	 * refreshes patient information on the screen for the user
	 */

	private void refreshPatientInformation() {

		if (patient != null) {
			nhsNumberTextArea.setText(String.valueOf(patient.getNhsNumber()));
			titleTextArea1.setText(patient.getTitle());
			firstNameTextArea1.setText(patient.getFirstName());
			lastNameTextArea1.setText(patient.getLastName());
			addressTextArea1.setText(patient.getAddress());
			telephoneTextArea1.setText(String.valueOf(patient.getContactNum()));
			allergiesTextArea1.setText(patient.getAllergies());
			bloodGroupTextArea1.setText(patient.getBloodGroup());
			int triage = patient.getTriage();
			for (int loop = 0; loop < Triage.values().length; loop++) {
				if (triage == Triage.values()[loop].getLevel()) {
					triageCategoryTextArea1.setText(Triage.values()[loop]
							.getTriage());
				}
			}
			String time = setTime(inSitu.getTimeOutOfInSitu().getTime()
					- new Date().getTime());
			timer1.setText(time);
		} else {
			nhsNumberTextArea.setText("");
			titleTextArea1.setText("");
			firstNameTextArea1.setText("");
			lastNameTextArea1.setText("");
			addressTextArea1.setText("");
			telephoneTextArea1.setText("");
			allergiesTextArea1.setText("");
			bloodGroupTextArea1.setText("");
			triageCategoryTextArea1.setText("");
			timer1.setText("00:00");
		}
	}

	/**
	 * Method to set the time for the patient object entering the treatment
	 * rooms
	 * 
	 * @param time
	 * @return
	 */
	private String setTime(long time) {
		if (time != 0) {
			long seconds = time / 1000;
			if (seconds < 60) {
				return ("00:" + String.format("%02d", seconds));
			} else if (seconds >= 60 && seconds < 3600) {
				return (String.format("%02d:", seconds / 60) + String.format(
						"%02d", seconds % 60));
			} else {
				return ("More than one hour");
			}
		}
		return "00:00";
	}

}
