
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Klasa sluzaca do wyswietlania i rysowania na JPanelu wszystkich obiektow
 * znajdujacych sie w grze, rysowania planszy(polygon) wyswietlania komunikatow
 * w grze, zarzadzanie Timerem tej klasy oraz klasy Toolbar
 * 
 */

public class DrawStuff extends JPanel implements ActionListener {

	// Handler handler;

	/** Zmienna do ustawienia t�a */
	private BufferedImage background;
	/** 	*/
	Timer tm = new Timer(10, this);

	Random rand = new Random();

	/**
	 * Tworzenie obiektu Rocket o wspolrzednych x=300 oraz y=50 oraz 3 zycia
	 * startowe
	 */
	Rocket r = new Rocket(300, 50, Rocket.getLifes(0));

	/** Tworzenie obiektu ReadingFile */
	private ReadingFile rf = new ReadingFile();

	double x[];
	double y[];
	/** Zmienna ktora, zmienia liczbe komet w zaleznosci od poziomu gry */
	int cometCount = Toolbar.getLevel();
	/** nazwaPliku sluzaca do wczytywania poziomu */
	static String nazwaPliku;
	/**
	 * Zmienne typu boolean, ktore landed - ustawia sie true, jesli wyladowano prawidlowo
	 * false - jesli raketa nie wyladowala
	 * crash - true - jesli rakieta	sie rozbila. false - jesli rakieta nie jest rozbita
	 * start - true jesli timer
	 * toolbara i
	 */
	static boolean landed = false;
	static boolean crash = false;
	static boolean start;

	/** Tworzenie obiektu klasy Comet */
	Comet comet = new Comet(350, 100);

	/**
	 * Wywolanie konstruktora klasy DrawStuff dodanie komety do listy w zaleznosci
	 * od zmiennej cometCount start = false ustawia, ze timer jest zapauzowany do
	 * wczytywania zdjecia na background planszy
	 */
	public DrawStuff() {
		 setFocusable(true);

		for (int i = 0; i < cometCount; i++) {
			int x = rand.nextInt(470);
			int y = rand.nextInt(350) + 100;
			comet.addComet(new Comet(x, y));
		}

		start = false;

		try {
			background = ImageIO.read(new File("resources/spaceBackground.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * Metoda actionPerformed, ktora przyjmuje parametr e i jest wywolywana kiedy
	 * jest wygenerowane zdarzenie na obiekcie Jest ona powiazana z klasa Moving,
	 * ktorej nadzoruje przyciski wcisniete 
	 * requestFocus, pozwala na sterowanie klawiatura rakiety znajduja sie na JPanelu sprawdza czy start=false lub true.
	 * Jesli false nie zagramy, bo rakieta nie zacznie sie ruszac 
	 * Zapewnia rysowanie obiektow klasy Comet (czyli ich poruszanie) jesli start=true Timer
	 * wystartuje dla klasy Toolbar i klasy DrawStuff
	 */
	public void actionPerformed(ActionEvent e) {
		this.addKeyListener(new Moving(this));

		this.requestFocus();
		if (start == true) {
			try {
				this.r.move();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int i = 0; i < Comet.comets.size(); i++) {
				Comet tempComet = Comet.comets.get(i);
				tempComet.update(getWidth());
			}

		}
		
		this.repaint();

	}
	
	/**	Metoda paintComponent z przekazaniem kontekstu graficznego g do rysowania na JPanelu 
	 * 	Odpowiedniego skalowania szerokosci, wysokosci, polozenia x i polozenia y Komet i Rakiety
	 * 	Ustawia odpowiedz zmiennej "nazwaPliku" - czyli przypisuje nazwe ktory poziom powinien byc czytany
	 * 	Sprawdza czy rakieta nie wyszla poza plansze
	 * 	Sprawdza czy zostala nacisnieta pauza na Toolbarze
	 * 	
	 * 	 */
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		if (Toolbar.pause == true ) {
			tm.stop();
			Toolbar.t.stop();
		}
		else if (Toolbar.pause == false ) {
			tm.start();
			Toolbar.t.start();
		}


		if (Toolbar.getLevel() < 6) {
			r.rocketWidth = 0.08 * getWidth();
			r.rocketHeight = 0.08 * getHeight();
			r.scalingX = (float) getWidth() / 508;
			r.scalingY = (float) getHeight() / 653;

			Comet.cometWidth = 0.06 * getWidth();
			Comet.cometHeight = 0.08 * getHeight();
			Comet.scalingX = (float) getWidth() / 508;
			Comet.scalingY = (float) getHeight() / 653;
		} else {
			r.rocketWidth = 0.05 * getWidth();
			r.rocketHeight = 0.05 * getHeight();
			r.scalingX = (float) getWidth() / 508;
			r.scalingY = (float) getHeight() / 653;

			Comet.cometWidth = 0.05 * getWidth();
			Comet.cometHeight = 0.05 * getHeight();
			Comet.scalingX = (float) getWidth() / 508;
			Comet.scalingY = (float) getHeight() / 653;
		}
              
		if (Toolbar.getLevel() == 1) {
			nazwaPliku = "resources/level1.properties";
		} else if (Toolbar.getLevel() == 2) {
			nazwaPliku = "resources/level2.properties";
		} else if (Toolbar.getLevel() == 3) {
			nazwaPliku = "resources/level3.properties";
		} else if (Toolbar.getLevel() == 4) {
			nazwaPliku = "resources/level4.properties";
		} else if (Toolbar.getLevel() == 5) {
			nazwaPliku = "resources/level5.properties";
		} else if (Toolbar.getLevel() == 6) {
			nazwaPliku = "resources/level6.properties";
		} else if (Toolbar.getLevel() == 7) {
			nazwaPliku = "resources/level7.properties";
		} else if (Toolbar.getLevel() == 8) {
			nazwaPliku = "resources/level8.properties";
		} else if (Toolbar.getLevel() == 9) {
			nazwaPliku = "resources/level9.properties";
		} else if (Toolbar.getLevel() == 10) {
			nazwaPliku = "resources/level10.properties";
		}
		drawMap(g);
		try {
			checkWhetherLanded(g);
		} catch (IOException e) {
			System.out.println("Nie sprawdzono warunku checkWhetherLanded()");
			e.printStackTrace();
		}
		
		
		
		if (Rocket.x <= 0)
			Rocket.x = 0;
		if (Rocket.x >= 470)
			Rocket.x = 470;
		if (Rocket.y <= 0)
			Rocket.y = 0;

		
	}

	/** Rysuje mape za pomoca polygon
	 * 	Nadaje tlo na planszy i ustawia kolor wewnatrz Polygon
	 * 	Rysuje komety
	 *	Sprawdza warunek przed pozpoczeciem danego poziomu
	 * 	fillPolygon wypelnia srodek(w tym przypadku kolorem czerwonym) pomiedzy punktami 
	 * */
	public void drawMap(Graphics g) {
		Graphics2D graph2 = (Graphics2D) g;

		// this.setBackground(Color.black);
		graph2.drawImage(background, 0, 0, (int) getWidth(), (int) getHeight(), null);
		graph2.setColor(Color.white);
		
		try {

			Polygon poly = new Polygon(getIntX(), getIntY(), rf.getNumberPoints(nazwaPliku));

			graph2.drawPolygon(poly);
			if(Toolbar.getLevel()<6) {
			graph2.setColor(Color.red);
			}
			else
				graph2.setColor(Color.white);
			

			graph2.fillPolygon(poly);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < Comet.comets.size(); i++) {
			Comet tempComet = Comet.comets.get(i);
			tempComet.draw(g);

		}
		if (start == false) {
			graph2.setColor(Color.white);
			graph2.setFont(new Font("arial", Font.BOLD, 25));
			graph2.drawString("Nacisnij SPACJE,", getWidth() / 2 - 100, getHeight() / 2);
			graph2.setFont(new Font("arial", Font.BOLD, 25));
			graph2.drawString("aby zaczac grac.", getWidth() / 2 - 100, getHeight() / 2 + 20);

		}
		tm.start();
	}

	/**
	 * Sprawdza czy rakieta wyladowala poprawnie (nie za duza predkosc velY i velX) lub nie napotkala przeszkody (meteory)
	 * repaint() zapewnia znikniecie komety w pierwszym warunku
	 * 
	 * @throws IOException
	 */
	public void checkWhetherLanded(Graphics g) throws IOException {
		Graphics2D graph2 = (Graphics2D) g;
		Point2D w = new Point2D.Double(r.skalowaneX1(), r.skalowaneY());
		Point2D h = new Point2D.Double(r.skalowaneX2(), r.skalowaneY());

		if (r.checkCollisions() == 1) {

			
			crash = true;
			this.tm.stop();
			Toolbar.t.stop();
			repaint();
			graph2.setColor(Color.white);
			graph2.setFont(new Font("arial", Font.BOLD, 50));
			graph2.drawString("ROZBILES SIE :/", getWidth() / 2 - 180, getHeight() / 2);
			graph2.setFont(new Font("arial", Font.BOLD, 18));
			graph2.drawString("Nacisnij ENTER, zeby zaczac grac.", getWidth() / 2 - 150, getHeight() / 2 + 50);
		}

		try {
			Polygon poly = new Polygon(getIntX(), getIntY(), rf.getNumberPoints(nazwaPliku));

			if (poly.contains(w) == false & poly.contains(h) == false) {
				r.paint(g);
			} else if (poly.contains(w) == true & poly.contains(h) == true) {
				if (r.velY < 0.4 && r.velX <= 0.1) {
					
					r.paint(g);
					this.tm.stop();
					Toolbar.t.stop();
					landed = true;

					graph2.setColor(Color.blue);
					graph2.setFont(new Font("arial", Font.BOLD, 50));
					graph2.drawString("Udalo Ci sie!", getWidth() / 2 - 150, getHeight() / 2);
					graph2.setColor(Color.white);
					graph2.setFont(new Font("arial", Font.BOLD, 18));
					graph2.drawString("Nacisnij ENTER,", getWidth() / 2 - 150, getHeight() / 2 + 20);
					graph2.drawString("zeby przejsc do nastepnego poziomu", getWidth() / 2 - 150, getHeight() / 2 + 40);
				} else {
					crash = true;

					this.tm.stop();
					Toolbar.t.stop();
					r.drawCrash(g);
					graph2.setColor(Color.white);
					graph2.setFont(new Font("arial", Font.BOLD, 50));
					graph2.drawString("ROZBILES SIE :/", getWidth() / 2 - 180, getHeight() / 2);
					graph2.setFont(new Font("arial", Font.BOLD, 18));
					graph2.drawString("Nacisnij ENTER, zeby zaczac grac.", getWidth() / 2 - 150, getHeight() / 2 + 50);

				}

			} else if (poly.contains(h) == true) {
				
				crash = true;
				this.tm.stop();
				Toolbar.t.stop();
				r.drawCrash(g);
				graph2.setColor(Color.white);
				graph2.setFont(new Font("arial", Font.BOLD, 50));
				graph2.drawString("ROZBILES SIE :/", getWidth() / 2 - 180, getHeight() / 2);
				graph2.setFont(new Font("arial", Font.BOLD, 18));
				graph2.drawString("Nacisnij ENTER, zeby zaczac grac.", getWidth() / 2 - 150, getHeight() / 2 + 50);

			} else if (poly.contains(w) == true) {
				
				this.tm.stop();
				Toolbar.t.stop();
				r.drawCrash(g);
				crash = true;

				graph2.setColor(Color.white);
				graph2.setFont(new Font("arial", Font.BOLD, 50));
				graph2.drawString("ROZBILES SIE :/", getWidth() / 2 - 180, getHeight() / 2);
				graph2.setFont(new Font("arial", Font.BOLD, 18));
				graph2.drawString("Nacisnij ENTER, zeby zaczac grac.", getWidth() / 2 - 150, getHeight() / 2 + 50);
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Zczytywanie wartosci punktow x potrzebnych do narysowania planszy (Polygon), odpowiednie ich przeskalowanie i zapisywanie ich do talbicy
	 * Metoda ta sluzy do zwracania tablicy punktow x potrzebnych do narysowania planszy
	 * 
	 */
	public int[] getIntX() {

		try {
			x = ReadingFile.points("x", "mapPoints", nazwaPliku);

		} catch (ArrayIndexOutOfBoundsException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * Petla zapewniajaca, ze plansza w trakcie rozszerzania ekranu bedzie sie
		 * rozszerzala (skalowanie)
		 */
		for (int i = 0; i < x.length; i++) {
			x[i] = (int) (getWidth() * x[i]);
		}
		final int[] intx = new int[x.length];
		for (int i = 0; i < x.length; ++i)
			intx[i] = (int) x[i];

		return intx;
	}

	/**
	 * Zczytywanie wartosci punktow y potrzebnych do narysowania planszy (Polygon), odpowiednie ich przeskalowanie i zapisywanie ich do talbicy
	 * Metoda ta sluzy do zwracania tablicy punktow y potrzebnych do narysowania planszy
	 * 
	 */
	public int[] getIntY() {

		try {
			y = ReadingFile.points("y", "mapPoints", nazwaPliku);
		} catch (ArrayIndexOutOfBoundsException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * Petla zapewniajaca, ze plansza w trakcie rozszerzania ekranu bedzie sie
		 * rozszerzala (skalowanie)
		 */
		for (int i = 0; i < y.length; i++) {
			y[i] = getHeight() * y[i];

		}
		final int[] inty = new int[y.length];
		for (int i = 0; i < y.length; ++i)
			inty[i] = (int) y[i];

		return inty;
	}

}