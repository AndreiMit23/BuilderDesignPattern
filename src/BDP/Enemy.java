package BDP;

import BDP.Vector2Int;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

// Generic enemy class
public class Enemy {

	private int health;
	private int speed;
	private int damage;
	private Image sprite;
	private Vector2Int size, position;

	public void setHealth(int health) {
		this.health = health;
	}

	public void setSprite(String path) {
//		try {
//			this.sprite = ImageIO.read(new File(path));
//		} catch (IOException ex) {
//			System.out.println(ex);
//		}
		this.sprite = new ImageIcon(path).getImage();
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setSize(int x, int y) {
		this.size = new Vector2Int(x, y);
	}

	public void setPosition(int x, int y) {
		this.position = new Vector2Int(x, y);
	}

	public Vector2Int getPosition() {
		return this.position;
	}

	public Vector2Int getSize() {
		return this.size;
	}

	public Image getSprite() {
		return this.sprite;
	}

	public boolean containsPoint(int mouseX, int mouseY) {
		return (
			mouseX >= position.x &&
			mouseX <= position.x + size.x &&
			mouseY >= position.y &&
			mouseY <= position.y + size.y
		);
	}
	
	private Class<? extends Exception> correctException;
	
	public void setCorrectException(Class <? extends Exception> exClass) {
		this.correctException = exClass;
	}
	

	
	public Class<? extends Exception> getCorrectException(){
		return correctException;
	}
}
