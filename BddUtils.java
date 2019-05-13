package monPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BddUtils {

	public static final String URL = "jdbc:mysql://localhost:3306/tchatbdd";
	public static final String LOGIN = "root";
	public static final String PASSWORD = "";

	private final static String QUERY_SAVE_MSG = "INSERT INTO message (contenu) VALUES (?)";

	public static void insertMsg(MessageBean message) throws Exception {
		Connection con = null; // java.sql pour le choix
		PreparedStatement stmt = null; // java.sql pour le choix
		try {
			// Pour travailler avec Tomcat
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = con.prepareStatement(QUERY_SAVE_MSG);
			// Remplir la requ�te
			stmt.setString(1, message.getContenu());
			// Lancer la requ�te
			stmt.executeUpdate();
		} finally {
			// On ferme la connexion
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private final static String QUERY_FIND_MSG = "SELECT * FROM message ORDER by id DESC";

	public static ArrayList<MessageBean> requestMsg() throws Exception {
		Connection con = null;
		Statement stmt = null;
		ArrayList<MessageBean> list = new ArrayList<>();
		try {
			// Pour travailler avec Tomcat et wamp Rajouter :
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(QUERY_FIND_MSG);
			while (rset.next()) {
				MessageBean msg = rsetToMsg(rset);
				list.add(msg);
			}

			return list;
		} finally {
			if (con != null) {// On ferme la connexion
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static MessageBean rsetToMsg(ResultSet rset) throws SQLException {
		final MessageBean msg = new MessageBean();

		msg.setId(rset.getInt("id"));
		msg.setContenu(rset.getString("contenu"));

		return msg;
	}
}
