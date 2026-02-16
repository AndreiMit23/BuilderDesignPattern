package BDP;

import javax.swing.JFrame;

public class mainFile {

	public static void main(String[] args) {
		
		System.setProperty("sun.java2d.uiScale","1.0");
		
		JFrame frame = new JFrame();
		
		Prima_interfata interfata = new Prima_interfata();
		
		interfata.creareInterfata(frame);
		interfata.buton_START(frame);
		
		frame.setVisible(true);
	}
}
