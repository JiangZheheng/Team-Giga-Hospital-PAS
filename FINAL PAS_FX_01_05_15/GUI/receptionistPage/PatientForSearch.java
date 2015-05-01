/**
 * @author Paul 40133443
 */

package receptionistPage;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class PatientForSearch {
	private final StringProperty title;
	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty nhsNumber;
	private final StringProperty address;
	private final StringProperty bloodGroup;
	private final StringProperty contactNumber;
	private final StringProperty triageCategory;
	private final StringProperty waitingTime;

	public PatientForSearch(String nhsNumber, String firstName,
			String lastName, String title, String address,
			String contactNumber, String bloodGroup, String triageCategory,
			String waitingTime) {
		this.nhsNumber = new SimpleStringProperty(nhsNumber);
		this.title = new SimpleStringProperty(title);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.address = new SimpleStringProperty(address);
		this.contactNumber = new SimpleStringProperty(contactNumber);
		this.bloodGroup = new SimpleStringProperty(bloodGroup);
		this.triageCategory = new SimpleStringProperty(triageCategory);
		this.waitingTime = new SimpleStringProperty(waitingTime);
	}

	/**
	 * Method to get the first name 
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName.get();
	}

	/**
	 * Method to set the first name
	 * 
	 * @return
	 */
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	/**
	 * Method to get the first name
	 * 
	 * @return
	 */
	public StringProperty firstNameProperty() {
		return firstName;
	}

	/**
	 * Method to get last name 
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName.get();
	}

	/**
	 * Method to set the last name 
	 * 
	 * @return
	 */
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	/**
	 * Method to get last name 
	 * 
	 * @return
	 */
	public StringProperty lastNameProperty() {
		return lastName;
	}

	/**
	 * Method to get nsh number 
	 * 
	 * @return
	 */
	public String getNhsNumber() {
		return nhsNumber.get();
	}

	/**
	 * Method to set the nhs number 
	 * 
	 * @return
	 */
	public void setNhsNumber(String nhsNumber) {
		this.nhsNumber.set(nhsNumber);
	}

	/**
	 * Method to get nhs number 
	 * 
	 * @return
	 */
	public StringProperty nhsNumberProperty() {
		return nhsNumber;
	}

	/**
	 * Method to get address
	 * 
	 * @return
	 */
	public String getAddress() {
		return address.get();
	}

	/**
	 * Method to set the adress 
	 * 
	 * @return
	 */
	public void setAddress(String address) {
		this.address.set(address);
	}

	/**
	 * Method to get address
	 * 
	 * @return
	 */
	public StringProperty addressProperty() {
		return address;
	}

	/**
	 * Method to get blood group 
	 * 
	 * @return
	 */
	public String getBloodGroup() {
		return bloodGroup.get();
	}

	/**
	 * Method to set the blood group 
	 * 
	 * @return
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup.set(bloodGroup);
	}

	/**
	 * Method to get blood group 
	 * 
	 * @return
	 */
	public StringProperty bloodGroupProperty() {
		return bloodGroup;
	}

	/**
	 * Method to get contact number 
	 * 
	 * @return
	 */
	public String getContactNumber() {
		return contactNumber.get();
	}

	/**
	 * Method to set the contact number 
	 * 
	 * @return
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber.set(contactNumber);
	}

	/**
	 * Method to get contact number 
	 * 
	 * @return
	 */
	public StringProperty contactNumberProperty() {
		return contactNumber;
	}

	/**
	 * Method to get title 
	 * 
	 * @return
	 */
	public String getTitle() {
		return title.get();
	}

	/**
	 * Method to set the title
	 * 
	 * @return
	 */
	public void setTitle(String title) {
		this.title.set(title);
	}

	/**
	 * Method to get title 
	 * 
	 * @return
	 */
	public StringProperty titleProperty() {
		return title;
	}

	/**
	 * Method to get triage category 
	 * 
	 * @return
	 */
	public String getTriageCategory() {
		return triageCategory.get();
	}

	/**
	 * Method to set the triage category 
	 * 
	 * @return
	 */
	public void setTriageCategory(String triageCategory) {
		this.triageCategory.set(triageCategory);
	}

	/**
	 * Method to get triage category 
	 * 
	 * @return
	 */
	public StringProperty triageCategoryProperty() {
		return triageCategory;
	}

	/**
	 * Method to get waiting time 
	 * 
	 * @return
	 */
	public String getWaitingTime() {
		return waitingTime.get();
	}

	/**
	 * Method to set the waiting time 
	 * 
	 * @return
	 */
	public void setWaitingTime(String waitingTime) {
		this.waitingTime.set(waitingTime);
	}

	/**
	 * Method to get waiting time 
	 * 
	 * @return
	 */
	public StringProperty waitingTimeProperty() {
		return waitingTime;
	}

}
