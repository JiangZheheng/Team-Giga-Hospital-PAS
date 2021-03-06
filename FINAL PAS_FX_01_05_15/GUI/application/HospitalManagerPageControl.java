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
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * This class controls the hospital manager page
 *
 *
 */
public class HospitalManagerPageControl implements Initializable {
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
	 * Displays table view
	 */
	@FXML
	private TableView<Patient> tableView;
	/**
	 * Displays table column for last name
	 */
	@FXML
	private TableColumn<Patient, String> last_name;
	/**
	 * Displays table column for waiting time
	 */
	@FXML
	private TableColumn<Patient, Long> waitingTime;
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
	 * declaration of log out button
	 */
	@FXML
	private Button logOut;
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
	 * Displays table column for triage
	 */
	@FXML
	private TableColumn<Patient, Integer> triage;
	/**
	 * declaration of staff button
	 */
	@FXML
	private Button staff;
	/**
	 * declaration of button for treatment rooms
	 */
	@FXML
	private Button treatmentRooms;
	/**
	 * declaration of label for timer
	 */
	@FXML
	private Label timer;

	/**
	 * Method to launch the java FX
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
	 * in queue and show the receptionist the next patient and the available
	 * treatment room
	 * 
	 * @author
	 */
	private void refresh() {
		refreshTable();
		String showTime = showTime(GUIMain.sortPatientQueue
				.calculateAverageWaitingTime(GUIMain.patientQueue));
		timer.setText(showTime);

	}

	/**
	 * Log out of system
	 * 
	 * @param event
	 */
	@FXML
	public void onClickLogOut(ActionEvent event) {

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
		Stage stage = (Stage) logOut.getScene().getWindow();

		stage.close();
	}

	/**
	 * Display treatment rooms
	 * 
	 * @param event
	 */
	@FXML
	public void onClickTreatmentsRooms(ActionEvent event) {

		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/viewTreatmentRooms.fxml"));
			Scene scene = new Scene(root, 1000, 600);
			newStage.setTitle("Hospital Manager");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) treatmentRooms.getScene().getWindow();

		stage.close();
	}

	/**
	 * launches all staff view
	 * 
	 * @param event
	 */
	@FXML
	public void onClickStaff(ActionEvent event) {

		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/viewStaff.fxml"));
			Scene scene = new Scene(root, 1000, 600);
			newStage.setTitle("Hospital Manager");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) staff.getScene().getWindow();

		stage.close();
	}

	/**
	 * Method to refresh the table on the page
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
	 * method to show time
	 * @param time
	 * @return
	 */
	private String showTime(long time) {
		String showTime = "00:00";
		if (time != 0) {
			long seconds = time / 1000;
			if (seconds < 60) {
				showTime = ("00:" + String.format("%02d", seconds));
			} else if (seconds >= 60 && seconds < 3600) {
				showTime = (String.format("%02d:", seconds / 60) + String
						.format("%02d", seconds % 60));
			} else {
				showTime = ("More than one hour");
			}
		}
		return showTime;

	}

}
