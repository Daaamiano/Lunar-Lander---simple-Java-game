
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * Klasa, w której znjaduj¹ siê zmienne i metody odpowiadaj¹ce za poprawne zarz¹dzanie kometami.
 */

public class Comet extends JComponent {

	/**
	 * Zmienne wykorzystywane do rysowania komet, odpowiedniego skalowania obrazka i poruszania siê komet
	 */
	static double cometWidth = 32;
	static double cometHeight = 32;
	static float scalingX = 1;
	static float scalingY = 1;
	double mDirection = 0.75;

	/** Lista, w której znajduj¹ siê komety */
	static ArrayList<Comet> comets = new ArrayList<Comet>();

	/** wspó³rzêdne rakiety */
	double x;
	double y;

	/**
	 * Konstruktor parametryczny, wykorzystywany do nadawania komecie okreœlonych wspó³rzêdnych startowych
	 */
	public Comet(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/** metoda odpowiadaj¹ca za poprawne latanie komet - nie wylatuj¹ poza mapê
	 * oraz na zatrzymaniu ruchu komet podczas pauzowania gry.
	 */
	public void update(int width) {
		if (Toolbar.pause == false) {
			x += mDirection;
			if (x > (475))
				mDirection = -mDirection;
			else if (x < 0)
				mDirection = -mDirection;
		}
	}
	
	/** Metoda zwracaj¹ca wspó³rzêdna x komety */
	public double getCometX() {
		return x;
	}

	/** Metoda zwracaj¹ca wspó³rzêdna y komety */
	public double getCometY() {
		return y;
	}
	
	/** Metoda rysuj¹ca kometê */
	public void draw(Graphics g) {
		g.drawImage(getCometImg(), (int) (x * scalingX), (int) (y * scalingY), (int) cometWidth, (int) cometHeight, null);
	}
	
	/** Metoda pobieraj¹ca obrazek komety */
	public Image getCometImg() {
		ImageIcon ic = new ImageIcon("resources/meteor1.png");
		return ic.getImage();
	}
	
	/** Metoda zwracaj¹ca granice obrazka potrzebna do wykrywania kolizji komet */
	public Rectangle getBounds() {
		return new Rectangle((int) (x * scalingX), (int) (y * scalingY), (int) cometWidth, (int) cometHeight);
	}
	
	/** Metoda dodaj¹ca kometê do listy ArrayList<Comet> comets */
	public void addComet(Comet c) {
		comets.add(c);
	}

	/** Metoda zwracaj¹ca listê ArrayList<Comet> comets */
	public static ArrayList<Comet> getCometList() {
		return comets;
	}

	/** Metoda usuwaj¹ca kometê z listy ArrayList<Comet> comets */
	public static void removeComet(Comet c) {
		comets.remove(c);
	}

}