package controller;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import model.Model;
import view.View;

public class Controller {
	// In this class there are functions to control the software
	// This is the Controller class from the MVC method
	// For connection
	// Username : willytock
	// Password : test123
	// SQL base is at the root
	public static JLabel labelResult;
	private static JLabel lPokemon, lInstruction;
	private static JMenuBar mb;
	private static JMenu menuPkm;
	private static JMenuItem mAdd, mConsult;
	public static String pkmStatus;

	public static void addPokemon() {
		// This function permit to move to another panel for adding Pokemon to the day
		// care.
		View.tpp.remove(View.pPkm);
		GridBagLayout gbl = new GridBagLayout();
		View.pPkm = new JPanel(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 5;
		c.weighty = 10;
		View.labelAdd = new JLabel("Add a pokemon");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 1;
		View.pPkm.add(View.labelAdd, c);

		View.labelGender = new JLabel("Gender :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		View.pPkm.add(View.labelGender, c);

		View.rbGenderM = new JRadioButton("Male");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		View.pPkm.add(View.rbGenderM, c);

		View.rbGenderF = new JRadioButton("Female");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = GridBagConstraints.RELATIVE;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		View.pPkm.add(View.rbGenderF, c);

		View.labelName = new JLabel("Pokemon Name :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		View.pPkm.add(View.labelName, c);

		View.pkmName = new TextField(30);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = 1;
		View.pPkm.add(View.pkmName, c);

		View.labelSize = new JLabel("Size :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		View.pPkm.add(View.labelSize, c);

		View.pkmSize = new TextField(30);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight = 1;
		View.pPkm.add(View.pkmSize, c);

		View.labelWeight = new JLabel("Weight :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		View.pPkm.add(View.labelWeight, c);

		View.pkmWeight = new TextField(30);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 2;
		c.gridheight = 1;
		View.pPkm.add(View.pkmWeight, c);

		View.labelStatus = new JLabel("Disease :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		View.pPkm.add(View.labelStatus, c);

		String status[] = { "Paralyzed", "Poisonned", "Burned", "Frozen", "Flinch", "Confused" };
		View.cbStatus = new JComboBox(status);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 2;
		c.gridheight = 1;
		View.pPkm.add(View.cbStatus, c);

		View.bAdd = new JButton("Add");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight = 1;
		View.pPkm.add(View.bAdd, c);
		View.bAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == View.bAdd) {
					Model.addPokemon();
				}
			}
		});
		View.mbPkm = new JMenuBar();
		View.menuPkm = new JMenu("Menu Pokemon");
		View.mAdd = new JMenuItem("Add");
		View.mAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == View.mAdd) {
					addPokemon();
				}
			}
		});
		View.mConsult = new JMenuItem("Consult");
		View.mConsult.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == View.mConsult) {
					consultPokemon();
				}
			}
		});
		View.mbPkm.add(View.menuPkm);
		View.menuPkm.add(View.mAdd);
		View.menuPkm.add(View.mConsult);
		c.anchor = GridBagConstraints.NORTHWEST;
		c.gridx = 0;
		c.gridy = 0;
		View.pPkm.add(View.mbPkm, c);
		View.labelRooms = new JLabel("Room :");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		View.pPkm.add(View.labelRooms, c);

		String rooms[] = { "Dark", "Fire", "Normal", "Temperature", "Water" };
		View.cbRooms = new JComboBox(rooms);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 2;
		c.gridheight = 1;
		View.pPkm.add(View.cbRooms, c);

		View.labelResult = new JLabel();
		View.labelResult.setForeground(Color.green);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 2;
		c.gridheight = 1;
		View.pPkm.add(View.labelResult, c);

		View.tpp.insertTab("Pokemon", null, View.pPkm, "Pokemon", 0);
		View.tpp.setSelectedIndex(0);
	}

	public static void consultPokemon() {
		// This function permit to switch to another panel to consult all Pokemon on the
		// establishment.
		View.tpp.remove(View.pPkm);
		GridBagLayout gbl = new GridBagLayout();
		View.pPkm = new JPanel(gbl);
		Model model = new Model();
		GridBagConstraints c = new GridBagConstraints();
		mb = new JMenuBar();
		menuPkm = new JMenu("Menu Pokemon");
		mAdd = new JMenuItem("Add");
		mAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mAdd) {
					addPokemon();
				}
			}
		});
		mConsult = new JMenuItem("Consult");
		mConsult.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mConsult) {
					consultPokemon();
				}
			}
		});
		mb.add(menuPkm);
		menuPkm.add(mAdd);
		menuPkm.add(mConsult);
		c.anchor = GridBagConstraints.NORTHWEST;
		c.gridx = 0;
		c.gridy = 0;
		View.pPkm.add(mb, c);

		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 3;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		lPokemon = new JLabel("Pokemon");
		View.pPkm.add(lPokemon, c);

		c.gridx = 1;
		c.gridy = 3;
		lInstruction = new JLabel("Click on the name of the pokemon you want to delete");
		View.pPkm.add(lInstruction, c);

		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		JScrollPane panePokemon = new JScrollPane(model.tPokemon, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Model.removePkm();
		View.pPkm.add(panePokemon, c);
		View.tpp.insertTab("Pokemon", null, View.pPkm, "Pokemon", 0);
		View.tpp.setSelectedIndex(0);
	}

	public static void main(String[] args) {
		View.main();
	}
}