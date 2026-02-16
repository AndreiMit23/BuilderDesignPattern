package BDP;

import BDP.*;
import java.io.*;
import javax.swing.JFrame;

public class Game extends JFrame {

	EnemyDirector ed;
	EnemyBuilder eb;

	Game() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//		gui.setUndecorated(true); asta e sa nu ne apara nimic nici butonul de exit nimic
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1800, 1080);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		EnemyPanel enemies = new EnemyPanel();

		this.add(enemies);
		this.repaint();

		this.setVisible(true);
	}
}
