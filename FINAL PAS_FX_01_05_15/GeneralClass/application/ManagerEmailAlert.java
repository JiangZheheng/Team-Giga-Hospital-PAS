package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * class to send the relevant email alerts to the Hospital Manager - to
 * implement IAlert Interface
 * 
 */

public class ManagerEmailAlert implements IAlert {

	/**
	 * String to hold the managerEmailAddress 
	 */
	private String managerEmailAddress;

	/**
	 * static to hold the mailServerProperties
	 */
	static Properties mailServerProperties;

	/**
	 * static to get the Mail Session 
	 */
	static Session getMailSession;

	/**
	 * static to generate the mail message
	 */
	static MimeMessage generateMailMessage;

	/**
	 * Constant to hold the subject message of the A and E alert
	 */
	public static final String MANAGERSUBJECT = "A&E alert";
	
	/**
	 * Constant to hold the body of the email for two patients waiting over 30 minutes
	 */
	public static final String MANAGEREMAILTWOPATIENTS = "Two or more patients have been waiting for 30 minutes ";
	
	/**
	 * Constant to hold the body of the email for on call fully engaged
	 */
	public static final String MANAGEREMAILONCALLENGAGED = "On Call team fully engaged.  Patients being redirected";

	/**
	 * method to connect to database and pull the managers email address from
	 * the staff table this method then sets the manager email address to be
	 * used when sending alerts via email
	 * 
	 * @param mangerEmailAddress
	 */
	public void setManagerEmailAddress() {
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
					.executeQuery(DatabaseENums.DATABASEMANAGEREMAILSELECTQUERY
							.getDatabase());
			while (rs.next()) {
				this.managerEmailAddress = rs
						.getString(DatabaseENums.DATABASESTAFFEMAIL
								.getDatabase());

			}
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());

		}

	}

	public String getManagerEmail() {
		return managerEmailAddress;
	}

	public static void getProperties() {

		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

	}

	/**
	 * method to send email
	 * 
	 * @param getMailSession
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void transport(Session getMailSession)
			throws AddressException, MessagingException {

		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "hospitalsender@gmail.com",
				"validPassword");
		transport.sendMessage(generateMailMessage,
				generateMailMessage.getAllRecipients());
		transport.close();

	}

	/**
	 * method to generate and send email alerts to the Hospital Manager
	 * 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void generateAndSendEmailPatientsWaitingThirtyMinutes()
			throws AddressException, MessagingException {
		setManagerEmailAddress();
		
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		setManagerEmailAddress();
		System.out.println(getManagerEmail().toString());
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress(getManagerEmail()));
		generateMailMessage.addRecipient(Message.RecipientType.CC,
				new InternetAddress(getManagerEmail()));
		generateMailMessage.setSubject(MANAGERSUBJECT);
		String emailBody = MANAGEREMAILTWOPATIENTS;
		generateMailMessage.setContent(emailBody, "text/html");


		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "hospitalsender@gmail.com",
				"validPassword");
		transport.sendMessage(generateMailMessage,
				generateMailMessage.getAllRecipients());
		transport.close();
	}

	/**
	 * method to send the email to the Manager when on call team is fully
	 * engaged
	 * 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void generateAndSendEmailOnCallFullyEngaged()
			throws AddressException, MessagingException {
		setManagerEmailAddress();
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		setManagerEmailAddress();
		System.out.println(getManagerEmail().toString());
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress(getManagerEmail()));
		generateMailMessage.addRecipient(Message.RecipientType.CC,
				new InternetAddress(getManagerEmail()));
		generateMailMessage.setSubject(MANAGERSUBJECT);
		String emailBody = MANAGEREMAILONCALLENGAGED;
		generateMailMessage.setContent(emailBody, "text/html");
		

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "hospitalsender@gmail.com",
				"validPassword");
		transport.sendMessage(generateMailMessage,
				generateMailMessage.getAllRecipients());
		transport.close();
	}

	/**
	 * unimplemented method from IAlert interface
	 */
	@Override
	public void sendSMSToOnCallTeam() {
		// TODO Auto-generated method stub

	}

	/**
	 * unimplemented method from IAlert interface
	 */
	@Override
	public void sendSSMSManagerOnCallFullyEngaged() {
		// TODO Auto-generated method stub

	}

	/**
	 * unimplemented method from IAlert interface
	 */
	@Override
	public void sendSSMSManagerTwoPatientsWaitingThirtyMinutes() {
		// TODO Auto-generated method stub

	}
}
