package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import controller.Controller;
import model.Model;

public class View extends JFrame {
	// In this class there are functions to show graphical elements in the software.
	// This is the View class from the MVC method.
	private static JLabel lUsername, lPassword, lWelcome;
	public static TextField tUsername, pkmName, pkmSize, pkmWeight;
	public static JPasswordField tPassword;
	private static JPanel connectionPanel;
	private static JButton connectionButton;
	public static JFrame main, connectionScreen;
	public static JPanel pPkm, pEmployees, pInstitution, pMedicine, pRooms;
	public static JTabbedPane tpp;
	public static JLabel labelResult, labelAdd, labelWeight, labelGender, labelName, labelSize, labelStatus, lMedicine,
			lEmployees, lInstitution, lTitle, labelRooms, lRooms;
	public static JButton bAdd;
	public static JRadioButton rbGenderM, rbGenderF;
	public static JMenuBar mbPkm;
	private static JMenuBar mbRooms;
	public static JMenu menuPkm;
	private static JMenu menuRooms;
	public static JMenuItem mAdd, mConsult;
	private static JMenuItem mDark;
	private static JMenuItem mFire;
	private static JMenuItem mNormal;
	private static JMenuItem mTemperature;
	private static JMenuItem mWater;
	public static JComboBox cbStatus, cbRooms;

	public View() throws IOException {
		connectionScreen();
	}

	public void connectionScreen() throws IOException {
		// This function describes the graphical interface of the login screen.
		connectionScreen = new JFrame();
		connectionScreen = this;
		// Title of the window
		connectionScreen.setTitle("Pokemon Day Care");
		// Layout of the window, it's how the window will be divided.
		// I choose GridBagLayout because I felt it better suited to my use.
		GridBagLayout gbl = new GridBagLayout();
		// And "c" is the constraint of the layout, where we want to place elements.
		GridBagConstraints c = new GridBagConstraints();
		connectionScreen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		connectionScreen.setSize(1650, 1080);
		connectionScreen.setLocationRelativeTo(null);
		connectionScreen.setDefaultCloseOperation(EXIT_ON_CLOSE);

		connectionPanel = new JPanel();
		connectionPanel.setLayout(gbl);
		c.weightx = 5;
		c.weighty = 5;
		// All graphic elements, label and text fields
		BufferedImage title = ImageIO.read(new File("PokemonDayCareTitle.png"));
		lTitle = new JLabel(new ImageIcon(title));
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 0;
		connectionPanel.add(lTitle, c);

		lWelcome = new JLabel("Welcome", SwingConstants.CENTER);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 1;
		connectionPanel.add(lWelcome, c);

		lUsername = new JLabel("Username", SwingConstants.CENTER);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		connectionPanel.add(lUsername, c);

		tUsername = new TextField(50);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth = 2;
		connectionPanel.add(tUsername, c);

		lPassword = new JLabel("Password", SwingConstants.CENTER);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		connectionPanel.add(lPassword, c);

		// This particular field hide characters
		tPassword = new JPasswordField(50);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 4;
		c.gridwidth = 2;
		connectionPanel.add(tPassword, c);

		// This button active an action from the model because its needs SQL request
		connectionButton = new JButton("Connection");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 5;
		connectionPanel.add(connectionButton, c);
		connectionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Model.connection();
			}
		});
		connectionScreen.add(connectionPanel);
	}

	public static void init() {
		// This function initialize graphic interface, only those elements which are
		// likely to change will call another function.
		// I choose to use another window, different from the connection one because I
		// feel it's more practical.
		main = new JFrame();
		main.setTitle("Pokemon DayCare Software");
		main.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main.setSize(1650, 1080);
		main.setLocationRelativeTo(null);
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		// All elements below are part of the software, they compose it and sometimes
		// call function from the controller or the model.
		// For all elements, constraints must be redefined or constraints are save from
		// the last element.
		pPkm = new JPanel(gbl);
		c.weightx = 5;
		c.weighty = 10;
		labelAdd = new JLabel("Add a pokemon");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 1;
		pPkm.add(labelAdd, c);

		labelGender = new JLabel("Gender :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		pPkm.add(labelGender, c);

		rbGenderM = new JRadioButton("Male");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		pPkm.add(rbGenderM, c);

		rbGenderF = new JRadioButton("Female");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = GridBagConstraints.RELATIVE;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		pPkm.add(rbGenderF, c);

		labelName = new JLabel("Pokemon Name :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		pPkm.add(labelName, c);

		pkmName = new TextField(30);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = 1;
		pPkm.add(pkmName, c);

		labelSize = new JLabel("Size :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		pPkm.add(labelSize, c);

		pkmSize = new TextField(30);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight = 1;
		pPkm.add(pkmSize, c);

		labelWeight = new JLabel("Weight :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		pPkm.add(labelWeight, c);

		pkmWeight = new TextField(30);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 2;
		c.gridheight = 1;
		pPkm.add(pkmWeight, c);

		labelStatus = new JLabel("Disease :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		pPkm.add(labelStatus, c);

		String status[] = { "Paralyzed", "Poisonned", "Burned", "Frozen", "Flinch", "Confused" };
		cbStatus = new JComboBox(status);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 2;
		c.gridheight = 1;
		pPkm.add(cbStatus, c);

		bAdd = new JButton("Add");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight = 1;
		pPkm.add(bAdd, c);
		bAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == bAdd) {
					Model.addPokemon();
				}
			}
		});
		mbPkm = new JMenuBar();
		menuPkm = new JMenu("Menu Pokemon");
		mAdd = new JMenuItem("Add");
		mAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mAdd) {
					Controller.addPokemon();
				}
			}
		});
		mConsult = new JMenuItem("Consult");
		mConsult.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mConsult) {
					Controller.consultPokemon();
				}
			}
		});
		mbPkm.add(menuPkm);
		menuPkm.add(mAdd);
		menuPkm.add(mConsult);
		c.anchor = GridBagConstraints.NORTHWEST;
		c.gridx = 0;
		c.gridy = 0;
		pPkm.add(mbPkm, c);

		labelRooms = new JLabel("Room :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		pPkm.add(labelRooms, c);

		String rooms[] = { "Dark", "Fire", "Normal", "Temperature", "Water" };
		cbRooms = new JComboBox(rooms);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 2;
		c.gridheight = 1;
		pPkm.add(cbRooms, c);

		labelResult = new JLabel();
		labelResult.setForeground(Color.green);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 2;
		c.gridheight = 1;
		pPkm.add(labelResult, c);

		pMedicine = new JPanel(gbl);
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 3;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		lMedicine = new JLabel("Medicine");
		pMedicine.add(lMedicine, c);
		Model model = new Model();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		JScrollPane paneMedicine = new JScrollPane(model.tMedicine, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pMedicine.add(paneMedicine, c);

		pEmployees = new JPanel(gbl);
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 3;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		lEmployees = new JLabel("Employees");
		pEmployees.add(lEmployees, c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		JScrollPane paneEmployees = new JScrollPane(model.tEmployees, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pEmployees.add(paneEmployees, c);

		pInstitution = new JPanel(gbl);
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 3;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		lInstitution = new JLabel("Institutions");
		pInstitution.add(lInstitution, c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		JScrollPane paneInstitution = new JScrollPane(model.tInstitution, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pInstitution.add(paneInstitution, c);

		pRooms = new JPanel(gbl);
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 3;
		c.weighty = 2;
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		lRooms = new JLabel("Rooms");
		pRooms.add(lRooms, c);
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 2;
		model.getRooms();
		JScrollPane paneDarkRooms = new JScrollPane(model.tDark, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pRooms.add(paneDarkRooms, c);

		mbRooms = new JMenuBar();
		menuRooms = new JMenu("Menu Rooms");
		mDark = new JMenuItem("Dark Rooms");
		mDark.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pRooms.removeAll();
				mbRooms.add(menuRooms);
				menuRooms.add(mDark);
				menuRooms.add(mFire);
				menuRooms.add(mNormal);
				menuRooms.add(mTemperature);
				menuRooms.add(mWater);
				c.anchor = GridBagConstraints.NORTHWEST;
				c.gridx = 0;
				c.gridy = 0;
				pRooms.add(mbRooms, c);
				c.anchor = GridBagConstraints.CENTER;
				c.gridx = 2;
				c.gridy = 0;
				c.gridwidth = 3;
				c.gridheight = 1;
				lRooms = new JLabel("Rooms");
				pRooms.add(lRooms, c);
				c.gridx = 2;
				c.gridy = 1;
				c.gridwidth = 3;
				c.gridheight = 2;
				model.getRooms();
				JScrollPane paneDarkRooms = new JScrollPane(model.tDark, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				pRooms.add(paneDarkRooms, c);
			}
		});
		mFire = new JMenuItem("Fire Rooms");
		mFire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pRooms.removeAll();
				mbRooms.add(menuRooms);
				menuRooms.add(mDark);
				menuRooms.add(mFire);
				menuRooms.add(mNormal);
				menuRooms.add(mTemperature);
				menuRooms.add(mWater);
				c.anchor = GridBagConstraints.NORTHWEST;
				c.gridx = 0;
				c.gridy = 0;
				pRooms.add(mbRooms, c);
				c.anchor = GridBagConstraints.CENTER;
				c.gridx = 2;
				c.gridy = 0;
				c.gridwidth = 3;
				c.gridheight = 1;
				lRooms = new JLabel("Rooms");
				pRooms.add(lRooms, c);
				c.gridx = 2;
				c.gridy = 1;
				c.gridwidth = 3;
				c.gridheight = 2;
				model.getRooms();
				JScrollPane paneFireRooms = new JScrollPane(model.tFire, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				pRooms.add(paneFireRooms, c);
			}
		});
		mNormal = new JMenuItem("Normal Rooms");
		mNormal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pRooms.removeAll();
				mbRooms.add(menuRooms);
				menuRooms.add(mDark);
				menuRooms.add(mFire);
				menuRooms.add(mNormal);
				menuRooms.add(mTemperature);
				menuRooms.add(mWater);
				c.anchor = GridBagConstraints.NORTHWEST;
				c.gridx = 0;
				c.gridy = 0;
				pRooms.add(mbRooms, c);
				c.anchor = GridBagConstraints.CENTER;
				c.gridx = 2;
				c.gridy = 0;
				c.gridwidth = 3;
				c.gridheight = 1;
				lRooms = new JLabel("Rooms");
				pRooms.add(lRooms, c);
				c.gridx = 2;
				c.gridy = 1;
				c.gridwidth = 3;
				c.gridheight = 2;
				model.getRooms();
				JScrollPane paneNormalRooms = new JScrollPane(model.tNormal, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				pRooms.add(paneNormalRooms, c);
			}
		});
		mTemperature = new JMenuItem("Temperature Rooms");
		mTemperature.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pRooms.removeAll();
				mbRooms.add(menuRooms);
				menuRooms.add(mDark);
				menuRooms.add(mFire);
				menuRooms.add(mNormal);
				menuRooms.add(mTemperature);
				menuRooms.add(mWater);
				c.anchor = GridBagConstraints.NORTHWEST;
				c.gridx = 0;
				c.gridy = 0;
				pRooms.add(mbRooms, c);
				c.anchor = GridBagConstraints.CENTER;
				c.gridx = 2;
				c.gridy = 0;
				c.gridwidth = 3;
				c.gridheight = 1;
				lRooms = new JLabel("Rooms");
				pRooms.add(lRooms, c);
				c.gridx = 2;
				c.gridy = 1;
				c.gridwidth = 3;
				c.gridheight = 2;
				model.getRooms();
				JScrollPane paneTemperatureRooms = new JScrollPane(model.tTemperature,
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				pRooms.add(paneTemperatureRooms, c);
			}
		});
		mWater = new JMenuItem("Water Rooms");
		mWater.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pRooms.removeAll();
				mbRooms.add(menuRooms);
				menuRooms.add(mDark);
				menuRooms.add(mFire);
				menuRooms.add(mNormal);
				menuRooms.add(mTemperature);
				menuRooms.add(mWater);
				c.anchor = GridBagConstraints.NORTHWEST;
				c.gridx = 0;
				c.gridy = 0;
				pRooms.add(mbRooms, c);
				c.anchor = GridBagConstraints.CENTER;
				c.gridx = 2;
				c.gridy = 0;
				c.gridwidth = 3;
				c.gridheight = 1;
				lRooms = new JLabel("Rooms");
				pRooms.add(lRooms, c);
				c.gridx = 2;
				c.gridy = 1;
				c.gridwidth = 3;
				c.gridheight = 2;
				model.getRooms();
				JScrollPane paneWaterRooms = new JScrollPane(model.tWater, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				pRooms.add(paneWaterRooms, c);
			}
		});
		mbRooms.add(menuRooms);
		menuRooms.add(mDark);
		menuRooms.add(mFire);
		menuRooms.add(mNormal);
		menuRooms.add(mTemperature);
		menuRooms.add(mWater);
		c.anchor = GridBagConstraints.NORTHWEST;
		c.gridx = 0;
		c.gridy = 0;
		pRooms.add(mbRooms, c);

		tpp = new JTabbedPane();
		tpp.add("Pokemon", pPkm);
		tpp.add("Medicine", pMedicine);
		tpp.add("Employees", pEmployees);
		tpp.add("Institution", pInstitution);
		tpp.add("Rooms", pRooms);
		main.add(tpp);
		main.setVisible(true);
	}

	public static String getPkmName() {
		return pkmName.getText();
	}

	public void setPkmName(TextField pkmName) {
		View.pkmName = pkmName;
	}

	public static String getPkmSize() {
		return pkmSize.getText();
	}

	public void setPkmSize(TextField pkmSize) {
		View.pkmSize = pkmSize;
	}

	public static String getPkmWeight() {
		return pkmWeight.getText();
	}

	public void setPkmWeight(TextField pkmWeight) {
		View.pkmWeight = pkmWeight;
	}

	public static JRadioButton getRbGenderM() {
		return rbGenderM;
	}

	public void setRbGenderM(JRadioButton rbGenderM) {
		View.rbGenderM = rbGenderM;
	}

	public static JRadioButton getRbGenderF() {
		return rbGenderF;
	}

	public void setRbGenderF(JRadioButton rbGenderF) {
		View.rbGenderF = rbGenderF;
	}

	public static JLabel getLabelResult() {
		return labelResult;
	}

	public void setLabelResult(JLabel labelResult) {
		View.labelResult = labelResult;
	}

	public static TextField gettUsername() {
		return tUsername;
	}

	public static void settUsername(TextField tUsername) {
		View.tUsername = tUsername;
	}

	public static JPasswordField gettPassword() {
		return tPassword;
	}

	public static void settPassword(JPasswordField tPassword) {
		View.tPassword = tPassword;
	}

	public static JComboBox getCbStatus() {
		return cbStatus;
	}

	public static void setCbStatus(JComboBox cbStatus) {
		View.cbStatus = cbStatus;
	}

	public static JComboBox getCbRooms() {
		return cbRooms;
	}

	public static void setCbRooms(JComboBox cbRooms) {
		View.cbRooms = cbRooms;
	}

	public static void main() {
		EventQueue.invokeLater(() -> {
			View window;
			try {
				window = new View();
				window.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}