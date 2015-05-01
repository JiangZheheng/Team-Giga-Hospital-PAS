package application;

/**
 * the class is used to test individual page
 */
import java.util.ArrayList;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageTest extends Application {

	public PageTest() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GUIMain.patientQueue=new LinkedList<Patient>();
		GUIMain.inSitus=new ArrayList<InSitu>();
		GUIMain.inSitus.add(new InSitu());
		GUIMain.inSitus.add(new InSitu());
		try {
			Parent root = FXMLLoader.load(getClass().getResource(
					"/application/DoctorPage.fxml"));
			Scene scene = new Scene(root, 1000, 600);
			primaryStage.setTitle("FXML Welcome");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void refresh() {
		if(!GUIMain.patientQueue.isEmpty()){
		GUIMain.patientQueue.sort(new SortPatientComparator());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
