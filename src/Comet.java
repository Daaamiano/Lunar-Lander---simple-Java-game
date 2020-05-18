
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * Klasa, w kt�rej znjaduj� si� zmienne i metody odpowiadaj�ce za poprawne zarz�dzanie kometami.
 */

public class Comet extends JComponent {

	/**
	 * Zmienne wykorzystywane do rysowania komet, odpowiedniego skalowania obrazka i poruszania si� komet
	 */
	static double cometWidth = 32;
	static double cometHeight = 32;
	static float scalingX = 1;
	static float scalingY = 1;
	double mDirection = 0.75;

	/** Lista, w kt�rej znajduj� si� komety */
	static ArrayList<Comet> comets = new ArrayList<Comet>();

	/** wsp�rz�dne rakiety */
	double x;
	double y;

	/**
	 * Konstruktor parametryczny, wykorzystywany do nadawania komecie okre�lonych wsp�rz�dnych startowych
	 */
	public Comet(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/** metoda odpowiadaj�ca za poprawne latanie komet - nie wylatuj� poza map�
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
	
	/** Metoda zwracaj�ca wsp�rz�dna x komety */
	public double getCometX() {
		return x;
	}

	/** Metoda zwracaj�ca wsp�rz�dna y komety */
	public double getCometY() {
		return y;
	}
	
	/** Metoda rysuj�ca komet� */
	public void draw(Graphics g) {
		g.drawImage(getCometImg(), (int) (x * scalingX), (int) (y * scalingY), (int) cometWidth, (int) cometHeight, null);
	}
	
	/** Metoda pobieraj�ca obrazek komety */
	public Image getCometImg() {
		ImageIcon ic = new ImageIcon("resources/meteor1.png");
		return ic.getImage();
	}
	
	/** Metoda zwracaj�ca granice obrazka potrzebna do wykrywania kolizji komet */
	public Rectangle getBounds() {
		return new Rectangle((int) (x * scalingX), (int) (y * scalingY), (int) cometWidth, (int) cometHeight);
	}
	
	/** Metoda dodaj�ca komet� do listy ArrayList<Comet> comets */
	public void addComet(Comet c) {
		comets.add(c);
	}

	/** Metoda zwracaj�ca list� ArrayList<Comet> comets */
	public static ArrayList<Comet> getCometList() {
		return comets;
	}

	/** Metoda usuwaj�ca komet� z listy ArrayList<Comet> comets */
	public static void removeComet(Comet c) {
		comets.remove(c);
	}

}