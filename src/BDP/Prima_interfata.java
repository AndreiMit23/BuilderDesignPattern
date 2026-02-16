package BDP;


import java.awt.Dimension;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class Prima_interfata {

	private JPanel buttonPanel;
	
	public void buton_START(JFrame gui) {
		
		ImageIcon gifIcon = new ImageIcon("./src/assetsFirst_interface/Start.gif");
		JButton b1 = new JButton(gifIcon);
//		b1.setBounds(100,50,50,100); // setBounds(x,y,width,height)


		b1.setBorder(null);
		b1.setBorderPainted(false);
		b1.setFocusPainted(false);
		b1.setFocusable(false);
		b1.setContentAreaFilled(false);
		b1.setOpaque(false);
		
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game fereastraNoua = new Game();
				fereastraNoua.setVisible(true);

				gui.dispose();
			}

		});


		b1.setPreferredSize(new Dimension(105, 33));


		buttonPanel.add(b1);

	}

	public void creareInterfata(JFrame gui) {
//		JFrame frame = new JFrame();

		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		gui.setLayout(null);


		Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		JLayeredPane layeredPane = new JLayeredPane();
	    layeredPane.setPreferredSize(d);
	    layeredPane.setLayout(null);
		
		ImageIcon gif = new ImageIcon("./src/assetsFirst_interface/Stars2.gif");
		JLabel gifLabel = new JLabel(gif);
		
//		gifLabel.setBounds(0, 0, d.width, d.height);
		
		int width = gif.getIconWidth();
		int height = gif.getIconHeight();

		int x = (d.width-width)/2;
		int y = (d.height-height)/2;
		
		gifLabel.setBounds(x,y,width,height);
		
		buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setOpaque(false);
		buttonPanel.setBounds(0,0,d.width,d.height);
		
		layeredPane.add(gifLabel,Integer.valueOf(0));
		layeredPane.add(buttonPanel,Integer.valueOf(1));
		
		gui.setContentPane(layeredPane);
//		gui.setUndecorated(true); asta e sa nu ne apara nimic nici butonul de exit nimic 

//		gui.setVisible(true);


		System.out.println(gif.getIconWidth() + " x " + gif.getIconHeight());
		System.out.println(java.awt.Toolkit.getDefaultToolkit().getScreenSize());

	}
}
