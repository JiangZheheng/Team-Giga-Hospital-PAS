package application;

/**
 * the class represents the triageNursePageControl
 * @author 
 */
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TriageNursePageControl implements Initializable {
	
	Thread myThread;

	/**
	 * declaration of menu item set triage
	 */
	@FXML
	private MenuItem setTriage;
	/**
	 * declaration of menu item new patient
	 */
	@FXML
	private MenuItem newPatient;
	/**
	 * declaration of menu item for patient search
	 */
	@FXML
	private MenuItem patientSearch;
	/**
	 * declaration of menu item for alter triage
	 */
	@FXML
	private MenuItem alterTriage;
	/**
	 * declaration of log out button
	 */
	@FXML
	private Button logout;
	/**
	 * declaration of table view for patients
	 */
	@FXML
	private TableView<Patient> tableView;
	/**
	 * declaration of table column allergies
	 */
	@FXML
	private TableColumn<Patient, String> allergies;
	/**
	 * declaration of table column address
	 */
	@FXML
	private TableColumn<Patient, String> address;
	/**
	 * declaration of table column nhs number
	 */
	@FXML
	private TableColumn<Patient, Integer> nhs_number;
	/**
	 * declaration of table column last name
	 */
	@FXML
	private TableColumn<Patient, String> last_name;
	/**
	 * declaration of table column triage
	 */
	@FXML
	private TableColumn<Patient, Integer> triage;
	/**
	 * declaration of table column waiting time
	 */
	@FXML
	private TableColumn<Patient, Long> waitingTime;
	/**
	 * declaration of table column telephone
	 */
	@FXML
	private TableColumn<Patient, String> telephone;
	/**
	 * declaration of table column title
	 */
	@FXML
	private TableColumn<Patient, String> title;
	/**
	 * declaration of table column blood group
	 */
	@FXML
	private TableColumn<Patient, String> blood_group;
	/**
	 * declaration of table column first name
	 */
	@FXML
	private TableColumn<Patient, String> first_name;
	/**
	 * declaration j doe button
	 */
	@FXML
	private Button jDoe;

	/**
	 * Onclick will log the user out
	 * 
	 * @param event
	 */
	@FXML
	void logoutOnClick(ActionEvent event) {

		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/LoginScreen.fxml"));
			Scene scene = new Scene(root, 450, 400);
			newStage.setTitle("Triage Nurse");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) logout.getScene().getWindow();
		if (myThread.isAlive()) {
			myThread.interrupt();
		}
		stage.close();
	}

	@FXML
	void newPatientOnClick(ActionEvent event) {

	}

	/**
	 * Onclick will search the patient
	 * 
	 * @param event
	 */
	@FXML
	void patienSearchOnClick(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/receptionistPage/SearchPatient.fxml"));
			Scene scene = new Scene(root, 900, 522);
			newStage.setTitle("Patient Search");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Sets the triage with an on click event
	 * 
	 * @param event
	 */
	@FXML
	void setTriageOnClick(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/receptionistPage/SetTriage.fxml"));
			Scene scene = new Scene(root, 687, 488);
			newStage.setTitle("Set Triage");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Alter triage code on click
	 * 
	 * @param event
	 */
	@FXML
	void alterTriageOnClick(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/receptionistPage/AlterTriage.fxml"));
			Scene scene = new Scene(root, 687, 488);
			newStage.setTitle("Alter Triage");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * initialize this page and create a new thread to refresh this page every
	 * second
	 * 
	 * @author
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {

						while (true) {
							Thread.sleep(Limits.REFRESHTIME);
							Platform.runLater(new Runnable() {

								@Override
								public void run() {
									refresh();

								}
							});
						}
					}
				} catch (InterruptedException e) {
					System.out.println("Refresh thread is interrupted");
				}

			}
		});
		myThread.setDaemon(true);
		myThread.start();

	}

	/**
	 * the method is used to refresh table, update waiting time of every patient
	 * in queue and show the receptionist the next patient and the available
	 * treatment room
	 * 
	 * @author Jiang Zhe Heng
	 */
	private void refresh() {
		refreshTable();
	}

	/**
	 * refresh all patient in queue
	 * 
	 * @author Jiang Zhe Heng
	 * @param treatmentRoom
	 */
	private void refreshTable() {
		if (!GUIMain.patientQueue.isEmpty()) {
			ObservableList<Patient> list = FXCollections.observableArrayList();
			nhs_number
					.setCellValueFactory(new PropertyValueFactory<Patient, Integer>(
							"nhsNumber"));
			title.setCellValueFactory(new PropertyValueFactory<Patient, String>(
					"title"));
			first_name
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"firstName"));
			last_name
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"lastName"));
			address.setCellValueFactory(new PropertyValueFactory<Patient, String>(
					"address"));
			telephone
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"contactNum"));
			allergies
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"allergies"));
			blood_group
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"bloodGroup"));
			triage.setCellValueFactory(new PropertyValueFactory<Patient, Integer>(
					"triage"));
			triage.setCellFactory(new Callback<TableColumn<Patient, Integer>, TableCell<Patient, Integer>>() {

				@Override
				public TableCell<Patient, Integer> call(
						TableColumn<Patient, Integer> param) {

					return new TableCell<Patient, Integer>() {
						@Override
						protected void updateItem(Integer item, boolean empty) {
							super.updateItem(item, empty);

							if (item != null) {
								for (int loop = 0; loop < Triage.values().length; loop++) {
									if (item == Triage.values()[loop]
											.getLevel()) {
										setText(Triage.values()[loop]
												.getTriage());
									}
								}
							}
						}
					};
				}
			});

			waitingTime
					.setCellValueFactory(new PropertyValueFactory<Patient, Long>(
							"waitingTime"));
			waitingTime
					.setCellFactory(new Callback<TableColumn<Patient, Long>, TableCell<Patient, Long>>() {

						@Override
						public TableCell<Patient, Long> call(
								TableColumn<Patient, Long> param) {

							return new TableCell<Patient, Long>() {
								@Override
								protected void updateItem(Long item,
										boolean empty) {
									super.updateItem(item, empty);
									if (item != null) {
										long seconds = item / 1000;
										if (seconds < 60) {
											setText("00:"
													+ String.format("%02d",
															seconds));
										} else if (seconds >= 60
												&& seconds < 3600) {
											setText(String.format("%02d:",
													seconds / 60)
													+ String.format("%02d",
															seconds % 60));
										} else {
											setText("More than one hour");
										}
									}
								}
							};
						}
					});
			for (Patient patient : GUIMain.patientQueue) {
				list.add(patient);
				tableView.setItems(list);
			}
		} else {
			tableView.setItems(null);
		}
	}

	/**
	 * Button to assign JDoe
	 * 
	 * @param event
	 */
	public void JDoeOnClick(ActionEvent event) {

		Patient patient = new Patient();
		patient.setFirstName("J");
		patient.setLastName("Doe");

		Random randomNHSNumber = new Random();
		for (int loop = 0; loop <= Limits.PATIENT_LIMIT_IN_PAS; loop++) {
			patient.setNhsNumber(randomNHSNumber.nextInt(8000) + 1000);
		}

		new SortPatientQueue().allocatePatientToTreatmentRoom(
				GUIMain.patientQueue, patient, GUIMain.treatmentRoomList);

	}
}
