package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import view.View;

public class Model {
	// In this class there are all function calling SQL request
	// This is the Model class from the MVC method
	public static JTable tPokemon;
	public JTable tMedicine;
	public JTable tEmployees;
	public JTable tInstitution;
	public JTable tNormal;
	public JTable tDark;
	public JTable tFire;
	public JTable tTemperature;
	public JTable tWater;
	public static JLabel labelResult;
	public static ListSelectionModel select;
	static Connection cn = null;

	public Model() {
		getPokemon();
		getMedicine();
		getEmployees();
		getInstitution();
		getRooms();
		removePkm();
	}

	public void getPokemon() {
		// Function used to get list of Pokemons in the data base
		// Object for the connection to PhpMyAdmin
		String url = "";
		String login = "";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			Statement stmt = cn.createStatement();
			// SQL request
			String sql = "SELECT name, size, weight, gender, status, room FROM pokemon";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			String columns[] = { "Name", "Size", "Weight", "Gender", "Status", "Room" };
			rs.last();
			int nbrows = rs.getRow();
			rs.beforeFirst();
			int nbcolumn = rsmd.getColumnCount();
			String[][] data = new String[nbrows][nbcolumn];
			int i = 0;
			while (rs.next()) {
				String name = rs.getString("name");
				double size = rs.getDouble("size");
				double weight = rs.getDouble("weight");
				String gender = rs.getString("gender");
				String status = rs.getString("status");
				String room = rs.getString("room");
				data[i][0] = name;
				data[i][1] = size + "";
				data[i][2] = weight + "";
				data[i][3] = gender;
				data[i][4] = status;
				data[i][5] = room;
				i++;
			}
			// Put all the data on a table list
			DefaultTableModel model = new DefaultTableModel(data, columns);
			tPokemon = new JTable(model);
			tPokemon.setShowGrid(true);
			tPokemon.setShowVerticalLines(true);
			tPokemon.setCellSelectionEnabled(true);
			select = tPokemon.getSelectionModel();
			cn.close();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void getEmployees() {
		// Function used to get list of employees of the Pokemon day care
		String url = "";
		String login = "";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			Statement stmt = cn.createStatement();
			// SQL request
			String sql = "SELECT name, firstName, role FROM employees";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			String columns[] = { "Name", "First Name", "Role" };
			rs.last();
			int nbrows = rs.getRow();
			rs.beforeFirst();
			int nbcolumn = rsmd.getColumnCount();
			String[][] data = new String[nbrows][nbcolumn];
			int i = 0;
			while (rs.next()) {
				String name = rs.getString("name");
				String firstName = rs.getString("firstName");
				String role = rs.getString("role");
				data[i][0] = name;
				data[i][1] = firstName;
				data[i][2] = role;
				i++;
			}
			DefaultTableModel model = new DefaultTableModel(data, columns);
			tEmployees = new JTable(model);
			tEmployees.setShowGrid(true);
			tEmployees.setShowVerticalLines(true);
			cn.close();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void getMedicine() {
		// This function used to get all available medicines in the day care
		String url = "";
		String login = "";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			Statement stmt = cn.createStatement();
			// SQL request
			String sql = "SELECT name, price, quantities, expirationDate FROM medicine";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			String column[] = { "Name", "Price", "Quantities", "Expiration Date" };
			rs.last();
			int nbrows = rs.getRow();
			rs.beforeFirst();
			int nbcolumn = rsmd.getColumnCount();
			String[][] data = new String[nbrows][nbcolumn];
			int i = 0;
			while (rs.next()) {
				String name = rs.getString("name");
				int quantities = rs.getInt("quantities");
				double price = rs.getDouble("price");
				Date expDate = rs.getDate("expirationDate");
				data[i][0] = name;
				data[i][1] = price + "";
				data[i][2] = quantities + "";
				data[i][3] = expDate + "";
				i++;
			}
			DefaultTableModel model = new DefaultTableModel(data, column);
			tMedicine = new JTable(model);
			tMedicine.setShowGrid(true);
			tMedicine.setShowVerticalLines(true);
			cn.close();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void getRooms() {
		// Function used to get Pokemons order by their room, useful to know how many
		// Pokemons they are by type of rooms
		String url = "";
		String login = "";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			Statement stmt = cn.createStatement();
			// SQL request
			String sql = "SELECT name, size, weight, gender, status, room FROM pokemon ORDER BY room";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			String columns[] = { "Name", "Size", "Weight", "Gender", "Status", "Room" };
			rs.last();
			int nbrows = rs.getRow();
			rs.beforeFirst();
			int nbcolumn = rsmd.getColumnCount();
			String[][] dataDark = new String[nbrows][nbcolumn];
			String[][] dataFire = new String[nbrows][nbcolumn];
			String[][] dataNormal = new String[nbrows][nbcolumn];
			String[][] dataTemperature = new String[nbrows][nbcolumn];
			String[][] dataWater = new String[nbrows][nbcolumn];
			// Getting data for each type of room
			int i = 0;
			while (rs.next()) {
				if (rs.getString("room").equals("Dark")) {
					String name = rs.getString("name");
					double size = rs.getDouble("size");
					double weight = rs.getDouble("weight");
					String gender = rs.getString("gender");
					String status = rs.getString("status");
					String room = rs.getString("room");
					dataDark[i][0] = name;
					dataDark[i][1] = size + "";
					dataDark[i][2] = weight + "";
					dataDark[i][3] = gender;
					dataDark[i][4] = status;
					dataDark[i][5] = room;
					i++;
					DefaultTableModel model = new DefaultTableModel(dataDark, columns);
					tDark = new JTable(model);
					tDark.setShowGrid(true);
					tDark.setShowVerticalLines(true);
				} else if (rs.getString("room").equals("Fire")) {
					String name = rs.getString("name");
					double size = rs.getDouble("size");
					double weight = rs.getDouble("weight");
					String gender = rs.getString("gender");
					String status = rs.getString("status");
					String room = rs.getString("room");
					dataFire[i][0] = name;
					dataFire[i][1] = size + "";
					dataFire[i][2] = weight + "";
					dataFire[i][3] = gender;
					dataFire[i][4] = status;
					dataFire[i][5] = room;
					i++;
					DefaultTableModel model = new DefaultTableModel(dataFire, columns);
					tFire = new JTable(model);
					tFire.setShowGrid(true);
					tFire.setShowVerticalLines(true);
				} else if (rs.getString("room").equals("Normal")) {
					String name = rs.getString("name");
					double size = rs.getDouble("size");
					double weight = rs.getDouble("weight");
					String gender = rs.getString("gender");
					String status = rs.getString("status");
					String room = rs.getString("room");
					dataNormal[i][0] = name;
					dataNormal[i][1] = size + "";
					dataNormal[i][2] = weight + "";
					dataNormal[i][3] = gender;
					dataNormal[i][4] = status;
					dataNormal[i][5] = room;
					i++;
					DefaultTableModel model = new DefaultTableModel(dataNormal, columns);
					tNormal = new JTable(model);
					tNormal.setShowGrid(true);
					tNormal.setShowVerticalLines(true);
				} else if (rs.getString("room").equals("Temperature")) {
					String name = rs.getString("name");
					double size = rs.getDouble("size");
					double weight = rs.getDouble("weight");
					String gender = rs.getString("gender");
					String status = rs.getString("status");
					String room = rs.getString("room");
					dataTemperature[i][0] = name;
					dataTemperature[i][1] = size + "";
					dataTemperature[i][2] = weight + "";
					dataTemperature[i][3] = gender;
					dataTemperature[i][4] = status;
					dataTemperature[i][5] = room;
					i++;
					DefaultTableModel model = new DefaultTableModel(dataTemperature, columns);
					tTemperature = new JTable(model);
					tTemperature.setShowGrid(true);
					tTemperature.setShowVerticalLines(true);
				} else if (rs.getString("room").equals("Water")) {
					String name = rs.getString("name");
					double size = rs.getDouble("size");
					double weight = rs.getDouble("weight");
					String gender = rs.getString("gender");
					String status = rs.getString("status");
					String room = rs.getString("room");
					dataWater[i][0] = name;
					dataWater[i][1] = size + "";
					dataWater[i][2] = weight + "";
					dataWater[i][3] = gender;
					dataWater[i][4] = status;
					dataWater[i][5] = room;
					i++;
					DefaultTableModel model = new DefaultTableModel(dataWater, columns);
					tWater = new JTable(model);
					tWater.setShowGrid(true);
					tWater.setShowVerticalLines(true);
				}
			}
			cn.close();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void getInstitution() {
		// Function used to get all with free spaces for taking care of Pokemon
		String url = "";
		String login = "";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			Statement stmt = cn.createStatement();
			// SQL request
			String sql = "SELECT region, name, city, freeRooms FROM institution";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			String column[] = { "Région", "Name", "City", "Free Rooms" };
			rs.last();
			int nbrows = rs.getRow();
			rs.beforeFirst();
			int nbcolumn = rsmd.getColumnCount();
			String[][] data = new String[nbrows][nbcolumn];
			int i = 0;
			while (rs.next()) {
				String region = rs.getString("region");
				String name = rs.getString("name");
				String city = rs.getString("city");
				int freeRooms = rs.getInt("freeRooms");
				data[i][0] = region;
				data[i][1] = name;
				data[i][2] = city;
				data[i][3] = freeRooms + "";
				i++;
			}
			DefaultTableModel model = new DefaultTableModel(data, column);
			tInstitution = new JTable(model);
			tInstitution.setShowGrid(true);
			tInstitution.setShowVerticalLines(true);
			cn.close();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void addPokemon() {
		// Function used to insert Pokemons into the data base from the software
		String url = "";
		String login = "";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			// Request insert creation
			String query_insert = "insert into pokemon(gender, name, size, status, weight, room)"
					+ "values(?,?,?,?,?,?)";
			PreparedStatement preparedStmt_insert = cn.prepareStatement(query_insert);
			JRadioButton rbGenderF = View.rbGenderF;
			JRadioButton rbGenderM = View.rbGenderM;
			String pkmGender = "";
			if (rbGenderF.isSelected()) {
				pkmGender = "Female";
			} else if (rbGenderM.isSelected()) {
				pkmGender = "Male";
			}
			// Getting data from text fields on the software
			preparedStmt_insert.setString(1, pkmGender);
			String pkmName = View.getPkmName();
			preparedStmt_insert.setString(2, pkmName);
			String pkmSize = View.getPkmSize();
			preparedStmt_insert.setString(3, pkmSize);
			String pkmStatus = View.cbStatus.getItemAt(View.cbStatus.getSelectedIndex()) + "";
			preparedStmt_insert.setString(4, pkmStatus);
			String pkmWeight = View.getPkmWeight();
			preparedStmt_insert.setString(5, pkmWeight);
			String pkmRoom = View.cbRooms.getItemAt(View.cbRooms.getSelectedIndex()) + "";
			preparedStmt_insert.setString(6, pkmRoom);
			// Execution
			preparedStmt_insert.execute();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				// Label to verify the adding of the Pokemon and emptying text fields
				View.labelResult.setText("Pokemon added successfully");
				View.pkmName.setText("");
				View.pkmSize.setText("");
				View.pkmWeight.setText("");
				cn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	public static void removePkm() {
		// Function used to remove a Pokemon, for example when the Pokemon leave the day
		// care when it's healed
		// Element to get the Pokemon selected
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getSource() == select) {
					String selection = null;
					int[] row = tPokemon.getSelectedRows();
					int[] column = tPokemon.getSelectedColumns();
					for (int i = 0; i < row.length; i++) {
						for (int j = 0; j < column.length; j++) {
							selection = (String) tPokemon.getValueAt(row[i], column[j]);
						}
					}
					String url = "";
					String login = "";
					String password = "";
					try {
						Class.forName("com.mysql.jdbc.Driver");
						cn = DriverManager.getConnection(url, login, password);
						// SQL request
						String sql = "DELETE FROM pokemon WHERE name=?";
						PreparedStatement pstmt = cn.prepareStatement(sql);
						pstmt.setString(1, selection);
						pstmt.executeUpdate();
						cn.close();
						// Refresh the table list of Pokemon
						Controller.consultPokemon();
					} catch (ClassNotFoundException cnfe) {
						cnfe.printStackTrace();
					} catch (SQLException sqle) {
						sqle.printStackTrace();
					}
				}
			}
		});
	}

	public static void connection() {
		// Function used to log in to the software
		Statement stmt = null;
		String url = "";
		String login = "";
		String password = "";
		String user = View.tUsername.getText();
		char[] pwd = View.tPassword.getPassword();
		String npwd = String.valueOf(pwd);
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			// SQL request
			String sql = "SELECT * FROM login";
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("username").equals(login)) {
					if (rs.getString("password").equals(npwd)) {
						System.out.println("correct");
						View.connectionScreen.dispose();
						View.init();
					} else {
						System.out.println("wrong");
					}
				} else {
					System.out.println("wrong");
				}
			}
			cn.close();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}
}
