package application;

/**
 * Class to control SMS alerts 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class OnCallSMSAlert implements IAlert {

	/**
	 * String to hold first doctor on call telephone number
	 */
	private String firstDoctorOnCall;

	/**
	 * String to hold second doctor on call telephone number
	 */
	private String secondDoctorOnCall;

	/**
	 * String to hold first nurse on call telephone number
	 */
	private String firstNurseOnCall;

	/**
	 * String to hold second nurse on call telephone number
	 */
	private String secondNurseOnCall;

	/**
	 * String to hold third nurse on call telephone number
	 */
	private String thirdNurseOnCall;

	/**
	 * Method to get first doctor on call details
	 * 
	 * @return
	 */
	public String getFirstDoctorOnCall() {
		return firstDoctorOnCall;
	}

	/**
	 * Method to get second on call details
	 * 
	 * @return
	 */
	public String getSecondDoctorOnCall() {
		return secondDoctorOnCall;

	}

	/**
	 * Method to get first nurse on call details
	 * 
	 * @return
	 */
	public String getFirstNurseOnCall() {
		return firstNurseOnCall;
	}

	/**
	 * Method to get second on call nurse details
	 * 
	 * @return
	 */
	public String getSecondNurseOnCall() {
		return secondNurseOnCall;
	}

	/**
	 * Method to get third nurse on call
	 * 
	 * @return
	 */
	public String getThirdNurseOnCall() {
		return thirdNurseOnCall;
	}

	/**
	 * method to set the telephone number to send the Alert to the first on call
	 * doctor
	 * 
	 * @param firstDoctorOnCall
	 * @return
	 */
	public void setFirstDoctorOnCallPhoneNumber() {

		String url = DatabaseENums.DATABASEURL.getDatabase();
		Connection con;
		Statement stmt;
		// loading driver
		try {

			Class.forName(DatabaseENums.DATABASECLASS.getDatabase());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		try {
			// making the connection
			con = DriverManager.getConnection(url,
					DatabaseENums.DATABASEUSERNAME.getDatabase(),
					DatabaseENums.DATABASEPASSWORD.getDatabase());
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			ResultSet rs = stmt
					.executeQuery(DatabaseENums.DATABASEONCALLDOCTORTELEHPONESELECTQUERY
							.getDatabase());
			while (rs.next()) {
				this.firstDoctorOnCall = rs
						.getString(DatabaseENums.DATABASESTAFFTELEPHONE
								.getDatabase());

			}
			rs.close();
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());

		}

	}

	/**
	 * Method to set the telephone for the second on call nurse to receive
	 * alerts
	 * 
	 * @return
	 */
	public void setSecondDoctorOnCallPhoneNumber() {
		String url = DatabaseENums.DATABASEURL.getDatabase();
		Connection con;
		Statement stmt;
		// loading driver
		try {
			Class.forName(DatabaseENums.DATABASECLASS.getDatabase());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			// making the connection
			con = DriverManager.getConnection(url,
					DatabaseENums.DATABASEUSERNAME.getDatabase(),
					DatabaseENums.DATABASEPASSWORD.getDatabase());
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			ResultSet rs = stmt
					.executeQuery(DatabaseENums.DATABASEONCALLDOCTORTWOTELEHPONESELECTQUERY
							.getDatabase());
			while (rs.next()) {
				this.secondDoctorOnCall = rs
						.getString(DatabaseENums.DATABASESTAFFTELEPHONE
								.getDatabase());
			}
			rs.close();
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());

		}

	}

	/**
	 * method to set telephone number for the first on call nurse to receive SMS
	 * alert
	 * 
	 * @return
	 */
	public void setFirstNurseOnCallPhoneNumber() {
		String url = DatabaseENums.DATABASEURL.getDatabase();
		Connection con;
		Statement stmt;
		// loading driver
		try {
			Class.forName(DatabaseENums.DATABASECLASS.getDatabase());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			// making the connection
			con = DriverManager.getConnection(url,
					DatabaseENums.DATABASEUSERNAME.getDatabase(),
					DatabaseENums.DATABASEPASSWORD.getDatabase());
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			ResultSet rs = stmt
					.executeQuery(DatabaseENums.DATABASEONCALLNURSETELEHPONESELECTQUERY
							.getDatabase());
			while (rs.next()) {
				this.firstNurseOnCall = rs
						.getString(DatabaseENums.DATABASESTAFFTELEPHONE
								.getDatabase());
				
			}
			rs.close();
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());

		}

	}

	/**
	 * method to set telephone number for the second on call nurse to receive
	 * SMS alert
	 * 
	 * @return
	 */
	public void setSecondNurseOnCallPhoneNumber() {
		String url = DatabaseENums.DATABASEURL.getDatabase();
		Connection con;
		Statement stmt;
		// loading driver
		try {
			Class.forName(DatabaseENums.DATABASECLASS.getDatabase());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			// making the connection
			con = DriverManager.getConnection(url,
					DatabaseENums.DATABASEUSERNAME.getDatabase(),
					DatabaseENums.DATABASEPASSWORD.getDatabase());
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			ResultSet rs = stmt
					.executeQuery(DatabaseENums.DATABASEONCALLNURSETWOTELEHPONESELECTQUERY
							.getDatabase());
			while (rs.next()) {
				this.secondNurseOnCall = rs
						.getString(DatabaseENums.DATABASESTAFFTELEPHONE
								.getDatabase());
			}
			rs.close();
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());

		}

	}

	/**
	 * method to set the telephone number for the third on call nurse to receive
	 * SMS
	 * 
	 * @return
	 */
	public void setThirdNurseOnCallPhoneNumber() {
		String url = DatabaseENums.DATABASEURL.getDatabase();
		Connection con;
		Statement stmt;
		// loading driver
		try {
			Class.forName(DatabaseENums.DATABASECLASS.getDatabase());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

			try {
				// making the connection
				con = DriverManager.getConnection(url,
						DatabaseENums.DATABASEUSERNAME.getDatabase(),
						DatabaseENums.DATABASEPASSWORD.getDatabase());
				// create a statement object
				stmt = con.createStatement();
				// supply the statement object with a string to execute
				ResultSet rs = stmt
						.executeQuery(DatabaseENums.DATABASEONCALLNURSETHREETELEHPONESELECTQUERY
								.getDatabase());
				while (rs.next()) {
					this.thirdNurseOnCall = rs
							.getString(DatabaseENums.DATABASESTAFFTELEPHONE
									.getDatabase());
				}
				rs.close();
				// close statement object
				stmt.close();
				// close connection
				con.close();
			} catch (SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());

			}
	}

	/**
	 * method to send the relevant SMS to the On Call team
	 * 
	 * @param user
	 * @param hash
	 * @param message
	 * @param sender
	 * @param numbers
	 * @return
	 */

	public String sendData(String user, String hash, String message,
			String sender, String number) {
		System.out.println(sender);
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(
					AlertsENums.SMSCONNECTION.getAlert()).openConnection();

			// data to be sent
			String data = user + hash + number + message + sender;
			System.out.println(data);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length",
					Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			// user exception to go here
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

	/**
	 * method to construct the SMS message to the on call team when alert is
	 * called
	 */
	@Override
	public void sendSMSToOnCallTeam() {

		// Construct data from TxtLocal
		String user = "username=" + AlertsENums.SMSUSERNAME.getAlert();
		String hash = "&hash=" + AlertsENums.SMSHASHKEY.getAlert();
		String message = "&message="
				+ AlertsENums.SMSALERTONCALLTEAM.getAlert();
		String sender = "&sender=" + AlertsENums.SMSSENDER.getAlert();
		setFirstDoctorOnCallPhoneNumber();
		String number1 = "&numbers=" + getFirstDoctorOnCall();
		setSecondDoctorOnCallPhoneNumber();
		String number2 = "&numbers=" + getSecondDoctorOnCall();
		setFirstNurseOnCallPhoneNumber();
		String number3 = "&numbers=" + getFirstNurseOnCall();
		setSecondNurseOnCallPhoneNumber();
		String number4 = "&numbers=" + getSecondNurseOnCall();
		setThirdNurseOnCallPhoneNumber();
		String number5 = "&numbers=" + getThirdNurseOnCall();

		// calling the method to send the data to all 5 on call staff
		sendData(user, hash, message, sender, number1);
		sendData(user, hash, message, sender, number2);
		sendData(user, hash, message, sender, number3);
		sendData(user, hash, message, sender, number4);
		sendData(user, hash, message, sender, number5);
	}

	/**
	 * unimplemented method
	 */
	@Override
	public void sendSSMSManagerOnCallFullyEngaged() {
		// TODO Auto-generated method stub

	}

	/**
	 * unimplemented method
	 */
	@Override
	public void sendSSMSManagerTwoPatientsWaitingThirtyMinutes() {
		// TODO Auto-generated method stub

	}

	/**
	 * unimplemented method
	 */
	@Override
	public void generateAndSendEmailOnCallFullyEngaged()
			throws AddressException, MessagingException {
		// TODO Auto-generated method stub

	}

	/**
	 * unimplemented method
	 */
	@Override
	public void generateAndSendEmailPatientsWaitingThirtyMinutes()
			throws AddressException, MessagingException {
		// TODO Auto-generated method stub

	}

}
