package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class viewTreatmentRoomControl {

	/**
	 * declaration to represent text field on the gui
	 */
    @FXML
    private TextField titleTextFieldT5;

    /**
	 * declaration to represent text field on the gui 
	 */
    @FXML
    private TextField titleTextFieldT4;

    /**
	 * declaration to represent the text field in the gui 
	 */
    @FXML
    private TextField titleTextFieldT2;

    /**
	 * declaration to represent textfield in the gui 
	 */
    @FXML
    private TextField titleTextFieldT1;

    /**
	 * declaration to represent label in the gui 
	 */
    @FXML
    private Label treatmentRoom;

    /**
	 * declaration to represent text field in gui 
	 */
    @FXML
    private TextField firstNameTextFieldT1;

    /**
	 * declaration to represent text field in the gui 
	 */
    @FXML
    private TextField firstNameTextFieldT4;

    /**
	 * declaration to represent text field in the gui 
	 */
    @FXML
    private TextField firstNameTextFieldT5;

    /**
	 * declaration to represent text field in the gui 
	 */
    @FXML
    private TextField firstNameTextFieldT2;

    /**
	 * declaration to represent text field in the gui 
	 */
    @FXML
    private TextField firstNameTextFieldT3;

    /**
	 * declaration to represent label in the gui 
	 */
    @FXML
    private Label nhsNumberT12;

    /**
	 * declaration to represent a label in gui 
	 */
    @FXML
    private Label titleT1;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label titleT2;

    /**
	 * declaration to represent label in the gui 
	 */
    @FXML
    private Label firstNameT5;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label titleT4;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label firstNameT4;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label titleT5;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label firstNameT1;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label firstNameT2;

    /**
	 * declaration to represent a text field in the gui 
	 */
    @FXML
    private TextField nhsNumberTextFieldT3;

    /**
	 * declaration to represent a textfield in the gui 
	 */
    @FXML
    private TextField nhsNumberTextFieldT4;

    /**
	 * declaration to represent textfield in the gui 
	 */
    @FXML
    private TextField nhsNumberTextFieldT1;

    /**
	 * declaration to represent text area in the gui 
	 */
    @FXML
    private TextArea textBoxT4;

    /**
	 * declaration to represent textfield 
	 */
    @FXML
    private TextField nhsNumberTextFieldT2;

    /**
	 * declaration to represent text field 
	 */
    @FXML
    private TextField nhsNumberTextFieldT5;

    /**
	 * declaration to represent textfield in the gui 
	 */
    @FXML
    private TextField lastNameTextFieldT4;

    /**
	 * declaration to represent text field in the gui 
	 */
    @FXML
    private TextField lastNameTextFieldT5;

    /**
	 * declaration to represent text field in the gui 
	 */
    @FXML
    private TextField lastNameTextFieldT2;

    /**
	 * declaration to represent label in the gui 
	 */
    @FXML
    private Label nhsNumberT1;

    /**
	 * declaration to represent textfield in the gui 
	 */
    @FXML
    private TextField lastNameTextFieldT3;

    /**
	 * declaration to represent textfield in the gui 
	 */
    @FXML
    private TextField lastNameTextFieldT1;

    /**
	 * declaration to represent label in the gui 
	 */
    @FXML
    private Label nhsNumberT4;

    /**
	 * declaration to represent label in the gui 
	 */
    @FXML
    private Label nhsNumberT5;
    
    /**
	 * declaration to represent label in the gui  
	 */
    @FXML
    private Label nhsNumberT2;

    /**
	 * declaration to represent text area 
	 */
    @FXML
    private TextArea testBoxT12;

    /**
	 * declaration to represent text field
	 */
    @FXML
    private TextField triageCategoryT2;

    /**
	 * declaration to represent text area 
	 */
    @FXML
    private TextArea testBoxT13;

    /**
	 * declaration to represent text field 
	 */
    @FXML
    private TextField triageCategoryT3;

    /**
	 * declaration to represent a button in the gui 
	 */
    @FXML
    private Button back;

    /**
	 * declaration to represent text field in the gui 
	 */
    @FXML
    private TextField triageCategoryT4;

    /**
	 * declaration to represent text field in the gui 
	 */
    @FXML
    private TextField triageCategoryT5;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label treatmentRoom5;

    /**
	 * declaration to represent a lebel in the gui 
	 */
    @FXML
    private Label treatmentRoom4;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label firstNameT12;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label triageCategoryT1;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label lastNameT2;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label lastNameT1;

    /**
	 * declaration to represent a label in the gui 
	 */ 
    @FXML
    private Label lastNameT12;

    /**
	 * declaration to represent a label in gui 
	 */
    @FXML
    private Label lastNameT5;

    /**
	 * declaration to represent a label in gui 
	 */
    @FXML
    private Label lastNameT4;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label treatmentRoom1;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label treatmentRoom2;

    /**
	 * declaration to represent a label in the gui 
	 */
    @FXML
    private Label triageCategoryT12;

    /**
	 * declaration to represent a text area in the gui 
	 */
    @FXML
    private TextArea testBoxT1;

    /**
	 * declaration to represent a text area in the gui 
	 */
    @FXML
    private TextArea testBoxT2;

    /**
	 * declaration to represent a button in the gui 
	 */
    @FXML
    private Button logOut;

    /**
	 * method for an event triggered by a click 
	 */
    @FXML
    void onClickBack(ActionEvent event) {

    }

    /**
	 * method for an event triggered by a click of log out button  
	 */
    @FXML
    void onClickLogOut(ActionEvent event) {

    }

}
