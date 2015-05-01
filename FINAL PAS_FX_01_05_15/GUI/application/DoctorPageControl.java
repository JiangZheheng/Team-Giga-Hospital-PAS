package application;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class DoctorPageControl implements Initializable {

	/**
	 * Table column to display allergies
	 */
	@FXML
	private TableColumn<Patient, String> allergies;

	/**
	 * Table column to display address
	 */
	@FXML
	private TableColumn<Patient, String> address;

	/**
	 * Table column to display nhs number
	 */
	@FXML
	private TableColumn<Patient, Integer> nhs_number;

	/**
	 * Table view to display Patients in the queue
	 */
	@FXML
	private TableView<Patient> tableView;

	/**
	 * Table column to display patients last name
	 */
	@FXML
	private TableColumn<Patient, String> last_name;

	@FXML
	private TableColumn<Patient, Long> waitingTime;

	/**
	 * Table column to display the patients telephone number
	 */
	@FXML
	private TableColumn<Patient, String> telephone;

	/**
	 * Table column to display the patients title
	 */
	@FXML
	private TableColumn<Patient, String> title;

	/**
	 * Table column to display the patients blood group
	 */
	@FXML
	private TableColumn<Patient, String> blood_group;

	/**
	 * Table column to display the patients first name
	 */
	@FXML
	private TableColumn<Patient, String> first_name;

	/**
	 * Table column to display the triage category of the patient
	 */
	@FXML
	private TableColumn<Patient, Integer> triage;

	/**
	 * Menu item to go to alter triage category
	 */
	@FXML
	private MenuItem recategorisePatient;

	/**
	 * Menu to display patient meni items
	 */
	@FXML
	private Menu patientMenu;

	/**
	 * Menu item to go to search patient queue
	 */
	@FXML
	private MenuItem searchQueueMenuItem;

	/**
	 * Button to go to treatment room 1
	 */
	@FXML
	private Button treatmentRoom1;

	/**
	 * Button to go to treatment room 2
	 */
	@FXML
	private Button treatmentRoom2;

	/**
	 * Button to go to treatment room 5
	 */
	@FXML
	private Button treatmentRoom5;

	/**
	 * Button to go to treatment room 3
	 */
	@FXML
	private Button treatmentRoom3;

	/**
	 * Button to go to treatment room 4
	 */
	@FXML
	private Button treatmentRoom4;

	/**
	 * Button to go to insitu 1
	 */
	@FXML
	private Button insitu1;

	/**
	 * Button to go to insitu 2
	 */
	@FXML
	private Button insitu2;

	/**
	 * Button to go log out
	 */
	@FXML
	private Button logOut;

	/**
	 * On clicking the log out button the user will logged out and redirected to
	 * the login page
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
			newStage.setTitle("Doctor");
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
	 * On clicking treatment room 1 button the doctor will be redirected to the
	 * treatment room 1. Which will display the details of the current patient
	 * who is in the room
	 * 
	 * @param event
	 */
	@FXML
	void OnClickTreatmentRoom1(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			// System.out.println(GUIMain.treatmentRoomList.get(0).getPatientInTreatmentRoom());
			TreatmentRoom1Control.treatmentRoom = GUIMain.treatmentRoomList
					.get(0);
			root = FXMLLoader.load(getClass().getResource(
					"/application/TreatmentRoom1.fxml"));
			Scene scene = new Scene(root, 1020, 622);
			newStage.setTitle("Treatment Room 1");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) treatmentRoom1.getScene().getWindow();

		stage.close();
	}

	/**
	 * On clicking treatment room 1 button the doctor will be redirected to the
	 * treatment room 2. Which will display the details of the current patient
	 * who is in the room
	 * 
	 * @param event
	 */
	@FXML
	void onClickTreatmentRoom2(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			TreatmentRoom1Control.treatmentRoom = GUIMain.treatmentRoomList
					.get(1);
			root = FXMLLoader.load(getClass().getResource(
					"/application/TreatmentRoom1.fxml"));
			Scene scene = new Scene(root, 1020, 622);
			newStage.setTitle("Treatment Room 2");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) treatmentRoom2.getScene().getWindow();

		stage.close();
	}

	/**
	 * On clicking treatment room 1 button the doctor will be redirected to the
	 * treatment room 3. Which will display the details of the current patient
	 * who is in the room
	 * 
	 * @param event
	 */
	@FXML
	void onClickTreatmentRoom3(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			TreatmentRoom1Control.treatmentRoom = GUIMain.treatmentRoomList
					.get(2);
			root = FXMLLoader.load(getClass().getResource(
					"/application/TreatmentRoom1.fxml"));
			Scene scene = new Scene(root, 1020, 622);
			newStage.setTitle("Treatment Room 3");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) treatmentRoom3.getScene().getWindow();

		stage.close();
	}

	/**
	 * On clicking treatment room 1 button the doctor will be redirected to the
	 * treatment room 4. Which will display the details of the current patient
	 * who is in the room
	 * 
	 * @param event
	 */
	@FXML
	void onClickTreatmentRoom4(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			TreatmentRoom1Control.treatmentRoom = GUIMain.treatmentRoomList
					.get(3);
			root = FXMLLoader.load(getClass().getResource(
					"/application/TreatmentRoom1.fxml"));
			Scene scene = new Scene(root, 1020, 622);
			newStage.setTitle("Treatment Room 4");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) treatmentRoom4.getScene().getWindow();

		stage.close();
	}

	/**
	 * On clicking treatment room 1 button the doctor will be redirected to the
	 * treatment room 5. Which will display the details of the current patient
	 * who is in the room
	 * 
	 * @param event
	 */
	@FXML
	void onClickTreatmentRoom5(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			TreatmentRoom1Control.treatmentRoom = GUIMain.treatmentRoomList
					.get(4);
			root = FXMLLoader.load(getClass().getResource(
					"/application/TreatmentRoom1.fxml"));
			Scene scene = new Scene(root, 1020, 622);
			newStage.setTitle("Treatment Room 5");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) treatmentRoom5.getScene().getWindow();

		stage.close();
	}

	/**
	 * Method to initilise thread for the page
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(Limits.REFRESHTIME);
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								refresh();

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
	 * the method is used to refresh table, update waiting time of every patient
	 * in queue and show the Doctor the next patient and the available treatment
	 * room
	 */
	private void refresh() {
		refreshTable();

	}

	/**
	 * 
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
	 * Upon clicking the search queue menu item the doctor is redirected to the
	 * search patient page
	 * 
	 * @param event
	 */
	@FXML
	void onClickSearchQueue(ActionEvent event) {

		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/receptionistPage/SearchPatient.fxml"));
			Scene scene = new Scene(root, 1020, 622);
			newStage.setTitle("Hospital PAS");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) treatmentRoom1.getScene().getWindow();

		stage.close();

	}

	/**
	 * Upon clicking the recategorise patient menu item the doctor is redirected
	 * to the search patient page
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
		Stage stage = (Stage) treatmentRoom1.getScene().getWindow();

		stage.close();

	}

	@FXML
	void onClickInsitu1(ActionEvent event) {

	}

	@FXML
	void onClickInsitu2(ActionEvent event) {

	}
}
