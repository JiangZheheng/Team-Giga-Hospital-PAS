package application;

/**
 * the class represents the receptionistPageControl
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import application.Patient;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ReceptionistPageControl implements Initializable {
	Thread myThread;
	/**
	 * declaration for menu item - alter triage
	 */
	@FXML
	private MenuItem alterTriage;
	/**
	 * declaration for menu item - patient search
	 */
	@FXML
	private MenuItem patientSearch;
	/**
	 * declaration for button ok
	 */
	@FXML
	private Button okButton;
	/**
	 * declaration for label status
	 */
	@FXML
	private Label status;
	/**
	 * declaration for label treatment number
	 */
	@FXML
	private Label treatmentNo;
	/**
	 * declaration for text area alert
	 */
	@FXML
	private TextArea alertTextArea;
	/**
	 * declaration of menu item for new patient
	 */
	@FXML
	private MenuItem newPatient;
	/**
	 * declaration of menu item set triage
	 */
	@FXML
	private MenuItem setTriage;
	/**
	 * declaration of button for log out
	 */
	@FXML
	private Button logOut;
	/**
	 * Displays table column for triage
	 */
	@FXML
	private TableColumn<Patient, Integer> triage;
	/**
	 * Displays table column for allergies
	 */
	@FXML
	private TableColumn<Patient, String> allergies;
	/**
	 * Displays table column for address
	 */
	@FXML
	private TableColumn<Patient, String> address;
	/**
	 * Displays table column for nhs number
	 */
	@FXML
	private TableColumn<Patient, Integer> nhs_number;
	/**
	 * Displays table column for last name
	 */
	@FXML
	private TableColumn<Patient, String> last_name;
	/**
	 * Displays table column for telephone
	 */
	@FXML
	private TableColumn<Patient, String> telephone;
	/**
	 * Displays table column for title
	 */
	@FXML
	private TableColumn<Patient, String> title;
	/**
	 * Displays table column for blood group
	 */
	@FXML
	private TableColumn<Patient, String> blood_group;
	/**
	 * Displays table column for first name
	 */
	@FXML
	private TableColumn<Patient, String> first_name;
	/**
	 * Displays table column for patient table
	 */
	@FXML
	private TableView<Patient> patientTable;
	/**
	 * Displays table column for triage next patient
	 */
	@FXML
	private TableColumn<Patient, Integer> triage_nextPatient;
	/**
	 * Displays table column for allergies next patient
	 */
	@FXML
	private TableColumn<Patient, String> allergies_nextPatient;
	/**
	 * Displays table column for address next patient
	 */
	@FXML
	private TableColumn<Patient, String> address_nextPatient;
	/**
	 * Displays table column for nhs number next patient
	 */
	@FXML
	private TableColumn<Patient, Integer> nhs_number_nextPatient;
	/**
	 * Displays table column for last name next patient
	 */
	@FXML
	private TableColumn<Patient, String> last_name_nextPatient;
	/**
	 * Displays table column for telephone next patient
	 */
	@FXML
	private TableColumn<Patient, String> telephone_nextPatient;
	/**
	 * Displays table column for title next patient
	 */
	@FXML
	private TableColumn<Patient, String> title_nextPatient;
	/**
	 * Displays table column for blood group next patient
	 */
	@FXML
	private TableColumn<Patient, String> blood_group_nextPatient;
	/**
	 * Displays table column for first name next patient
	 */
	@FXML
	private TableColumn<Patient, String> first_name_nextPatient;
	/**
	 * Displays table view next patient
	 */
	@FXML
	private TableView<Patient> nextPatient;

	/**
	 * Patient search on click event
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
	 * Open login page
	 * 
	 * @param event
	 */
	@FXML
	void alterTriageOnClick(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/LoginScreen.fxml"));
			Scene scene = new Scene(root, 450, 400);
			newStage.setTitle("Receptionist");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) logOut.getScene().getWindow();

		stage.close();
	}

	/**
	 * Open login page
	 * 
	 * @param event
	 */
	@FXML
	public void logOutOfSystem(ActionEvent event) {

		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/LoginScreen.fxml"));
			Scene scene = new Scene(root, 450, 400);
			newStage.setTitle("Receptionist");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) logOut.getScene().getWindow();

		if (myThread.isAlive()) {
			myThread.interrupt();
		}
		stage.close();
	}

	public ReceptionistPageControl() {

	}

	/**
	 * Open new patient page
	 */
	@FXML
	public void newPatientOnClick(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/receptionistPage/NewPatient.fxml"));
			Scene scene = new Scene(root, 450, 400);
			newStage.setTitle("New Patient");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Open login page
	 * 
	 * @param event
	 */
	@FXML
	private void setTriageOnClick(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/LoginScreen.fxml"));
			Scene scene = new Scene(root, 450, 400);
			newStage.setTitle("Receptionist");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) logOut.getScene().getWindow();

		stage.close();
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

						Thread.sleep(Limits.REFRESHTIME);

						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								refresh();

							}
						});
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
	 * @author
	 */
	private void refresh() {
		refreshTable();
		refreshNextPatient();
		refreshAlertTextArea();
		status.setText(String.valueOf(GUIMain.status));
	}

	private void refreshAlertTextArea() {

	}

	/**
	 * refresh next patient
	 * 
	 * @author
	 * @param treatmentRoom
	 */
	private void refreshNextPatient() {
		if (!GUIMain.patientQueue.isEmpty()) {
			ObservableList<Patient> observableList = FXCollections
					.observableArrayList();
			GUIMain.nextPatient = GUIMain.patientQueue.peek();
			observableList.add(GUIMain.nextPatient);
			nextPatient.setItems(null);
			nhs_number_nextPatient
					.setCellValueFactory(new PropertyValueFactory<Patient, Integer>(
							"NhsNumber"));
			title_nextPatient
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"title"));
			first_name_nextPatient
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"firstName"));
			last_name_nextPatient
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"lastName"));
			triage_nextPatient
					.setCellValueFactory(new PropertyValueFactory<Patient, Integer>(
							"triage"));
			triage_nextPatient
					.setCellFactory(new Callback<TableColumn<Patient, Integer>, TableCell<Patient, Integer>>() {

						@Override
						public TableCell<Patient, Integer> call(
								TableColumn<Patient, Integer> param) {

							return new TableCell<Patient, Integer>() {
								@Override
								protected void updateItem(Integer item,
										boolean empty) {
									super.updateItem(item, empty);
									if (item != null) {
										for (int loop = 0; loop < Triage
												.values().length; loop++) {
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
			address_nextPatient
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"address"));
			telephone_nextPatient
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"contactNum"));
			allergies_nextPatient
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"allergies"));
			blood_group_nextPatient
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"bloodGroup"));

			nextPatient.setItems(observableList);
		} else {
			nextPatient.setItems(null);
		}

	}

	/**
	 * refresh all patient in queue
	 * 
	 * @author
	 * @param treatmentRoom
	 */
	private void refreshTable() {
		ObservableList<Patient> observableList = FXCollections
				.observableArrayList(GUIMain.allPatientList);
		if (!GUIMain.allPatientList.isEmpty()) {
			patientTable.setItems(null);
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

			patientTable.setItems(observableList);

		} else {
			patientTable.setItems(null);
		}
	}

}
