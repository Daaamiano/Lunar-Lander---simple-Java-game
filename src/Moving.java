
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Klasa odpowiadajaca za odpowiednie zarzadzanie ruchem rakiety i odbieranie
 * tego w klasie Rocket, gdzie te metody sa opisane
 */

public class Moving extends KeyAdapter {
	
	DrawStuff ds;
	
	
	public Moving(DrawStuff ds) {
		this.ds = ds;
		
		
		 
	}

	/** wywoLywana, gdy wcisniemy przycisk */
	public void keyPressed(KeyEvent ke) {

		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (ds.r.rocketFuel > 0) {
				Rocket.flyingDirection = 1;
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			if (ds.r.rocketFuel > 0) {
				Rocket.falling = false;
				
				
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			if (ds.r.rocketFuel > 0) {
				Rocket.flyingDirection = -1;
			}

		}
		if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
			if (DrawStuff.start == false) {
				DrawStuff.start = true;
				ds.r.velY = 0;
				ds.r.velX = 0;

			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			/** WywoLane gdy wyladujemy na ladowisku */
			if (DrawStuff.landed == true) {
				DrawStuff.landed = false;
				DrawStuff.start = false;
				Toolbar.lev++;
				Comet.comets.clear();
				Rocket.gamePoints += 1000* (((double) 1 / (Toolbar.secondsPassedLevel)) * (Rocket.getRocketFuel() / 100));
				ds.r.rocketFuel = 100;
				new DrawStuff();
				new Rocket(300, 50, Rocket.getLifes(0));
				ds.repaint();
				Toolbar.secondsPassedLevel = 0;
			}
			/** WywoLane gdy nastapi zderzenie i wybuch */
			else if (DrawStuff.crash == true) {
				/** WywoLane gdy gracz rozbiL siê ale ma jeszcze ¿ycia */
				if (Rocket.getLifes(0) != 1) {
					DrawStuff.crash = false;
					ds.r.col = 0;
					ds.r.rocketFuel = 100;
					Comet.comets.clear();
					new DrawStuff();
					new Rocket(300, 50, Rocket.getLifes(0));
					Rocket.getLifes(1);
					ds.repaint();
					Toolbar.secondsPassedLevel = 0;
				}
				/** WywoLane gdy gracz stracil wszytskie ¿ycia */
				else if (Rocket.getLifes(0) == 1) {
					try {
						ReadingFile.saveToFile(Nickname.nick, "" + Rocket.gamePoints);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"KONIEC GRY\nSTRACILES ZYCIA\nNACISNIJ ENTER ABY ROZPOCZAC OD POCZATKU ");
					DrawStuff.crash = false;
					Comet.comets.clear();
					ds.r.rocketFuel = 100;
					ds.r.col = 0;
					Rocket.gamePoints = 0;

					Toolbar.lev = 1;
					Toolbar.minutes = 0;
					Toolbar.secondsPassed = 0;
					Toolbar.secondsPassedLevel = 0;

					new DrawStuff();

					ds.r = new Rocket(300, 50, 3);

					ds.repaint();
				}
			}
		}
	}

	
	

	/** Wywoalane, gdy puscimy przycisk */
	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			Rocket.flyingDirection = 0;
		} else if (ke.getKeyCode() == KeyEvent.VK_UP) {
			Rocket.falling = true;

		} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			Rocket.flyingDirection = 0;
		}
	}
}