package BDP;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.util.Random;

import BDP.Enemy;

// Generic Enemy Builder
abstract class EnemyBuilder {

	protected Enemy enemy;

	public Enemy getEnemy() {
		return enemy;
	}

	public void createEnemy() {
		enemy = new Enemy();
	}

	public abstract void buildHealth();

	public abstract void buildSprite();

	public abstract void buildSpeed();

	public abstract void buildDamage();

	public abstract void buildSize();

	public abstract void buildPosition();
}

// One type of enemy
class SimpleErrorEnemy extends EnemyBuilder {
	
	public void buildHealth() {
		enemy.setHealth(10);
	}

	public void buildDamage() {
		enemy.setDamage(1);
	}

	public void buildSpeed() {
		enemy.setSpeed(2);
	}

	public void buildSprite() {
		enemy.setSprite("./src/assets/X.gif");
	}

	public void buildSize() {
		enemy.setSize(300, 300);
	}

	public void buildPosition() {
		enemy.setPosition(0, 0);
	}

	public void buildType() {
		// alegem random o excepție
        Class<? extends Exception>[] types = new Class[]{
            ArithmeticException.class,
            NullPointerException.class,
            ArrayIndexOutOfBoundsException.class
        };

        Random rnd = new Random();
        Class<? extends Exception> chosen = types[rnd.nextInt(types.length)];

        enemy.setCorrectException(chosen); // metoda din Enemy care setează corectException
}}
