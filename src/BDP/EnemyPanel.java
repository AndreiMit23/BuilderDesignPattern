package BDP;

import BDP.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class EnemyPanel extends JPanel implements ActionListener, MouseListener {

	Vector<Enemy> enemies;
	int waveTime = 2;
	Timer timer;
	EnemyDirector ed;
	EnemyBuilder eb;

	ExceptionHandler handler;

	EnemyPanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width, screenSize.height);
		this.addMouseListener(this);

		enemies = new Vector<Enemy>();
//		timer = new Timer();

		ed = new EnemyDirector();
		eb = new SimpleErrorEnemy();

		ed.setEnemyBuilder(eb);

		handler = new ExceptionHandler();
		
		Timer spawner = new Timer(4000, e -> {
			try {
				ed.buildEnemy();
				Enemy en = ed.getEnemy();

				int posX = new Random().nextInt(1600);
				int posY = new Random().nextInt(600);

				en.setPosition(posX, posY);
				enemies.add(en);

			} catch (Exception ex) {
				handler.handle(ex);
			}

		});
		spawner.start();

		var gameLoop = new javax.swing.Timer(16, e -> {
			repaint();
		});

		gameLoop.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		for (Enemy e : enemies) {
			g2d.drawImage(e.getSprite(), e.getPosition().x, e.getPosition().y, e.getSize().x, e.getSize().y, null);
		}
//		
//		g.setColor(Color.DARK_GRAY);
//		g.setFont(new Font("Arial",Font.BOLD,24));
//		g.drawString("Score: " + score, 20,30);

		String scoreText = "score: " + score;
		Font font = new Font("Google Sans", Font.BOLD, 28);

		g2d.setFont(font);
		g2d.setColor(Color.WHITE);

		FontMetrics fm = g2d.getFontMetrics();

		int x = getWidth() - fm.stringWidth(scoreText) - 20; // dreapta aliniere
		int y = fm.getAscent() + 20; // dreapta sus aliniere

		int textWidth = fm.stringWidth(scoreText);
		int textHeight = fm.getHeight();

		int boxWidth = textWidth + 20;
		int boxHeight = textHeight + 10;

		int boxX = getWidth() - boxWidth - 12;
		int boxY = 18;

		g2d.setColor(Color.DARK_GRAY); // culoare container
		g2d.fillRoundRect(boxX, boxY, boxWidth, boxHeight, 15, 15);
		g2d.drawRoundRect(boxX, boxY, boxWidth, boxHeight, 15, 15);

		g2d.setColor(Color.WHITE);
		g2d.drawString(scoreText, x, y);

		g2d.setFont(new Font("Arial", Font.BOLD, 20));

		// distanță între mesaje
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
	}

	int score = 0;
	
	final int max_score = 3;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Iterator<Enemy> it = enemies.iterator();
		while (it.hasNext()) {
			Enemy enemy = it.next();
			if (enemy.containsPoint(e.getX(), e.getY())) {
				ExceptionSelector selector = new ExceptionSelector(enemy, handler);
				selector.setVisible(true);

				if (selector.isCorrect()) {
					it.remove();
					score++;
					if(score >= max_score) {
						JOptionPane.showMessageDialog(this, "AI CASTIGAT !!!","FELICITARI!", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
					repaint();
				} else {
					JOptionPane.showMessageDialog(this, "GAME OVER!", "Info", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				break;
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}
