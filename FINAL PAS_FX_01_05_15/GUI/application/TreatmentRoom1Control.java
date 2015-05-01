package application;

import java.io.FileNotFoundException;

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
 * This class controls treatment room 1
 * 
 *
 */
public class TreatmentRoom1Control implements Initializable {

	/**
	 * declaration of treatment room var
	 */
	public static TreatmentRoom treatmentRoom;
	/**
	 * declaration of patient var
	 */
	private Patient patient;
	/**
	 * declaration of text area for telephone
	 */
	@FXML
	private TextArea telephoneTextArea1;
	/**
	 * declaration of first name var
	 */
	@FXML
	private Label firstName1;
	/**
	 * declaration of label blood group
	 */
	@FXML
	private Label bloodGroup1;
	/**
	 * declaration of back button
	 */
	@FXML
	private Button back;
	/**
	 * declaration of text area last name
	 */
	@FXML
	private TextArea lastNameTextArea1;
	/**
	 * declaration for text box
	 */
	@FXML
	private TextArea textBox21;
	/**
	 * declaration of text area allergies
	 */
	@FXML
	private TextArea allergiesTextArea1;
	/**
	 * declaration of label for last name
	 */
	@FXML
	private Label lastName1;
	/**
	 * declaration of button for discharge
	 */
	@FXML
	private Button dischargePatient1;
	/**
	 * declaration for log out button
	 */
	@FXML
	private Button logOut1;
	/**
	 * declaration of label for triage cat
	 */
	@FXML
	private Label triageCategory1;
	/**
	 * declaration of label for timer
	 */
	@FXML
	private Label timer1;
	/**
	 * declaration of text area for first name
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
	 * declaration label for title
	 */
	@FXML
	private Label title1;
	/**
	 * declaration text area blood group
	 */
	@FXML
	private TextArea bloodGroupTextArea1;
	/**
	 * declaration for button for recategorise patient
	 */
	@FXML
	private Button recategorisePatient1;
	/**
	 * declaration of label for nhs number
	 */
	@FXML
	private Label nhsNumber;
	/**
	 * declaration of label for text box
	 */
	@FXML
	private TextArea textBox11;
	/**
	 * declaration of text area triage cat
	 */
	@FXML
	private TextArea triageCategoryTextArea1;
	/**
	 * declaration for nhs text area
	 */
	@FXML
	private TextArea nhsNumberTextArea;
	/**
	 * declaration of button for allocate extra time
	 */
	@FXML
	private Button allocateExtraTime1;
	/**
	 * declaration for label - telephone
	 */
	@FXML
	private Label telephoneNumber1;
	/**
	 * declaration for label of patient details
	 */
	@FXML
	private Label patientDetails1;
	/**
	 * declaration for text area for address
	 */
	@FXML
	private TextArea addressTextArea1;
	/**
	 * declaration of treatment room
	 */
	@FXML
	private Label treatmentRoom11;
	/**
	 * declaration of text area title
	 */
	@FXML
	private TextArea titleTextArea1;
	/**
	 * declaration of label for allergies
	 */
	@FXML
	private Label allergies1;

	/**
	 * Logs the user out when button is clicked
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
	 * discharges patient on click
	 * 
	 * @param event
	 * @throws FileNotFoundException
	 */
	@FXML
	void onClickDischargePatient(ActionEvent event)
			throws FileNotFoundException {
		treatmentRoom.dischargePatient(GUIMain.allPatientList, patient);
	}

	/**
	 * Can be expanded on further development
	 * 
	 * @param event
	 */
	@FXML
	void onClickFurtherAction(ActionEvent event) {

	}

	/**
	 * Allows doctor to recategorise patient
	 * 
	 * @param event
	 */
	@FXML
	void onClickRecategorisePatient(ActionEvent event) {

		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/receptionistPage/AlterTriage.fxml"));
			Scene scene = new Scene(root, 1020, 622);
			newStage.setTitle("Hospital PAS");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) treatmentRoom11.getScene().getWindow();

		stage.close();

	}

	/**
	 * Allows doctor to allocate extra time to patient
	 * 
	 * @param event
	 */
	@FXML
	void onClickAllocateExtraTime(ActionEvent event) {
		treatmentRoom.allocateExtraTime();
	}

	/**
	 * Closes window
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
	 * Method launches the JavaFX
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		patient = treatmentRoom.getPatientInTreatmentRoom();
		refreshThread();

	}

	/**
	 * ~Method to refresh the Page and keep the information up to date
	 */
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
								patient = treatmentRoom.patientInTreatmentRoom;
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
	 * Method to refresh the information on the page
	 */
	private void refreshPatientInformation() {

		if (patient != null) {
			nhsNumberTextArea.setText(String.valueOf(patient.getNhsNumber()));
			titleTextArea1.setText(patient.getTitle());
			firstNameTextArea1.setText(patient.getFirstName());
			lastNameTextArea1.setText(patient.getLastName());
			addressTextArea1.setText(patient.getAddress());
			telephoneTextArea1.setText(String.valueOf(patient.getNhsNumber()));
			allergiesTextArea1.setText(patient.getAllergies());
			bloodGroupTextArea1.setText(patient.getBloodGroup());
			int triage = patient.getTriage();
			for (int loop = 0; loop < Triage.values().length; loop++) {
				if (triage == Triage.values()[loop].getLevel()) {
					triageCategoryTextArea1.setText(Triage.values()[loop]
							.getTriage());
				}
			}
			String time = setTime(treatmentRoom.getTimeOutOfTreatmentRoom()
					.getTime() - new Date().getTime());
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
