package graphics.shapes.ui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {
	public void menu(JFrame f) {
		JMenuBar mb;

		JMenu menu;

		JMenuItem m1;
		JMenuItem m2;
		// JMenuItem m3;

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mb = new JMenuBar();

		menu = new JMenu("Menu");

		m1 = new JMenuItem("Create");
		m2 = new JMenuItem("Erase");
		// m3 = new JMenuItem("MenuItem3");
		

		menu.add(m1);
		menu.add(m2);
		// x.add(m3);
		JMenu about;
		about = new JMenu("About");

		mb.add(menu);

		mb.add(about);
		f.setJMenuBar(mb);

		f.setSize(300, 200);
		f.setVisible(true);

	}

}
