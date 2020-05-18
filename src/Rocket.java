import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Klasa, w ktorej znjaduja sie zmienne i metody odpowiadajace za poprawne
 * zarzadzanie rakieta.
 */

public class Rocket extends JComponent {

	private BufferedImage rocket;
	private BufferedImage explosion;
	private BufferedImage fire;

	static JLabel lblNewLabel = new JLabel();

	/**
	 * Pola okreslajace zmiane wspelrzednych rakiety w trakcie przyciskania klawisza
	 * odpowidajacego za ruch oraz do swobodnego lotu oraz ustalona liczba zyc (3) i
	 * startowa ilosc paliwa rakiety (100)
	 */
	float velX = 0;
	float velY = 0;
	int col = 0;
	static int lifes = 3;
	double rocketFuel = 100;
	static double x;
	static double y;
	static int gamePoints;

	double rocketWidth;
	double rocketHeight;
	float scalingX = 1;
	float scalingY = 1;

	/** zmienna o typie boolean ktora odpowiada za spadanie w osi Y */
	public static boolean falling = true;
	/** zmienna o typie int ktora odpowiada za spadanie w osi X */
	public static int flyingDirection;

	/** zmienne o typie float odpowiadajace za przyspieszanie rakiety */
	private float accelerationY = 0.1f;
	private float accelerationX = 0.1f;
	/**
	 * zmienne o typie String wykorzystywana w klasie Toolbar do wyswietlania
	 * pozostalego paliwa w grze
	 */
	static String fuel;

	/**
	 * Konstruktor parametryczny tworzacy obiekt z klasy Rocket z podanymi
	 * wspolrzednymi (x,y) rakiety, liczba zyc oraz przypisujacy do zmiennych
	 * obrazki rakiety, wybuchu i ognia.
	 */
	public Rocket(float x, float y, int life) {
		Rocket.x = x;
		Rocket.y = y;
		lifes = life;

		try {
			rocket = ImageIO.read(new File("resources/Rocket8.png"));
			explosion = ImageIO.read(new File("resources/explosion.png"));
			fire = ImageIO.read(new File("resources/animatedFire.png"));

		} catch (IOException e) {
			System.out.println("Couldn't find rocket or explosion .png");
			e.printStackTrace();
		}

	}

	/** Metoda zarzadzajaca iloscia zyc */
	public static int getLifes(int x) {
		if (x == 1)
			--lifes;
			
		return lifes;
	}

	/** Metoda zwracajaca granice obrazka potrzebna do wykrywania kolizji rakiety */
	public Rectangle getBounds() {
		return new Rectangle((int) (x * scalingX), (int) (y * scalingY), (int) rocketWidth, (int) rocketHeight);
	}

	/** Metoda sprawdzajaca czy rakieta zderza sie z kometa */
	public int checkCollisions() {
		ArrayList<Comet> comets = Comet.getCometList();

		for (int i = 0; i < comets.size(); i++) {
			Comet tempComet = comets.get(i);

			if (getBounds().intersects(tempComet.getBounds())) {
				Comet.removeComet(tempComet);
				col++;
			}
		}
		return col;
	}

	/**
	 * Metoda rysujaca rakiete i w przypadku roznych okolicznosci (kolizja badz ruch
	 * rakiety w gore) dodatkowych obrazkow
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		if (DrawStuff.crash == false) {

			if (falling == false) {

				g2.drawImage(rocket, (int) (x * scalingX), (int) (y * scalingY), (int) rocketWidth, (int) rocketHeight, null);
				drawFire(g);

			} else if (falling == true) {
				g2.drawImage(rocket, (int) (x * scalingX), (int) (y * scalingY), (int) rocketWidth, (int) rocketHeight, null);
			}
		} else if (DrawStuff.crash == true) {
			drawCrash(g2);
		}

	}

	/** Metoda rysujaca plomien rakiety */
	public void drawFire(Graphics g) {
		g.drawImage(fire, (int) (x * scalingX + rocketWidth / 10), (int) (y * scalingY + rocketHeight),
				(int) (0.8 * rocketWidth), (int) (0.8 * rocketHeight), null);
	}

	/** Metoda rysujaca wybuch rakiety */
	public void drawCrash(Graphics g) {
		g.setColor(Color.white);
		
		g.setFont(new Font("arial", Font.BOLD, 40));
		g.drawImage(explosion, (int) (x * scalingX), (int) (y * scalingY), (int) rocketWidth * 2,(int) rocketHeight * 2, null);

	}

	/** Metoda obcinajaca w wartosci paliwa miejsca po przecinku */
	public String setRocketFuel(double x) {
		DecimalFormat df = new java.text.DecimalFormat();
		df.setMaximumFractionDigits(0);
		df.setMinimumFractionDigits(0);
		fuel = df.format(x);
		return fuel;
	}

	/**
	 * Metoda wykorzystywana w klasie Toolbar do poprawnego wyswietlania paliwa w
	 * trakcie gry
	 */
	public static double getRocketFuel() {
		fuel = fuel.replace(",", ".");
		fuel = fuel.replace("-", "");
		return Double.parseDouble(fuel);
	}

	/** Metoda odpowiadajaca za poprawne latanie rakiety (jej predkosci) */
	public void move() throws IOException {
		if (Toolbar.pause == false) {
			y += velY;
			if (falling == true) {
				velY += (ReadingFile.getGravity(DrawStuff.nazwaPliku));
				setRocketFuel(rocketFuel);
			} else if (falling == false) {
				velY -= 0.01 + (0.01 * accelerationY);
				if (rocketFuel > 0 && Toolbar.getLevel()<6)
					rocketFuel -= 0.1;
				else if(rocketFuel > 0)
					rocketFuel -= 0.15;
					
				setRocketFuel(rocketFuel);

			}

			x += velX;

			if (flyingDirection == -1) {

				velX -= 0.01 + (0.01 * accelerationX);
				if (rocketFuel > 0 && Toolbar.getLevel()<6)
					rocketFuel -= 0.1;
				else if(rocketFuel > 0)
					rocketFuel -= 0.15;
			} else if (flyingDirection == 0) {

				if (velX < 0)
					velX += 0.001;
				else if (velX == 0)
					velX = 0;
				else if (velX > 0)
					velX -= 0.001;
			} else if (flyingDirection == 1) {

				velX += 0.01 + (0.01 * accelerationX);
				if (rocketFuel > 0 && Toolbar.getLevel()<6)
					rocketFuel -= 0.1;
				else if(rocketFuel > 0)
					rocketFuel -= 0.15;
			}

		}
	}

	/**
	 * Metody wykorzystywane w klasie DrawStuff do tworzenia obiektu Point2D i
	 * poprawnego wykrywania dzieki temu kolizji z planeta.
	 */
	public double skalowaneX1() {
		return x * scalingX;
	}

	public double skalowaneX2() {
		return (x * scalingX + rocketWidth);
	}

	public double skalowaneY() {
		return (y * scalingY + rocketHeight);
	}
}