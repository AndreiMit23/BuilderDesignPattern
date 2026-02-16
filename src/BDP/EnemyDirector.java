package BDP;

import BDP.*;

// Enemy Director to build enemies
public class EnemyDirector {

	private EnemyBuilder enemyBuilder;

	public void setEnemyBuilder(EnemyBuilder eb) {
		enemyBuilder = eb;
	}

	public Enemy getEnemy() {
		return enemyBuilder.getEnemy();
	}

	public void buildEnemy() {
		enemyBuilder.createEnemy();
		enemyBuilder.buildHealth();
		enemyBuilder.buildDamage();
		enemyBuilder.buildSpeed();
		enemyBuilder.buildSprite();
		enemyBuilder.buildSize();
		enemyBuilder.buildPosition();
		
		if(enemyBuilder instanceof SimpleErrorEnemy) {
			((SimpleErrorEnemy) enemyBuilder).buildType();
		}
	}
}
