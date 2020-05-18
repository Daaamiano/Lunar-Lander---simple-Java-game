
/**
 * Klasa, w której znajduje siê odczytywanie danych z plikow konfiguracyjnych:
 * wspo³rzednych punktów do rysowania polygon, liczby punktow, grawitacji danego poziomu 
 * oraz do zapisywania nicku oraz liczby punktow do pliku ranking.properties
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadingFile {

	/** Zmienne wykorzystywane do oczytywania wartosci w plikach konfiguracyjnych */
	String mapPoints = "mapPoints";
	static String levelGravity = "gravity";

	public static double[] points(String polyPoints, String mapPoints, String Level)
			throws FileNotFoundException, IOException, ArrayIndexOutOfBoundsException {
		/** Tworzenie obiektu properties */
		Properties p = new Properties();
		/** Tworzenie obiektu FileInputStream */
		InputStream is = new FileInputStream(Level);
		/** Ladowanie pliku konfiguracyjnego */
		p.load(is);
		/** Odczytanie liczby punktow do tworzenia podloza (Polygon) */
		int numberPoints = Integer.parseInt(p.getProperty(mapPoints));
		/** tablica przechowywuj¹ca wspolrzedne do rysowania za pomoca polygon */
		double points[] = new double[numberPoints];

		for (int i = 0; i < numberPoints; i++) {
			points[i] = Double.parseDouble(p.getProperty(polyPoints + i));
		}
		is.close();
		return points;
	}

	/**
	 * Metoda getNumberPoints zwraca nam ilosc punktow z pliku konfiguracyjnego
	 * (nazwe pliku podajemy jako parametr)
	 */
	public int getNumberPoints(String nazwaPliku) throws IOException {
		Properties p = new Properties();
		InputStream is = new FileInputStream(nazwaPliku);
		p.load(is);
		is.close();
		return Integer.parseInt(p.getProperty(mapPoints));
	}

	/** Metoda pobieraj¹ca z podanego pliku konfiguarcyjnego wartosc grawitacji aktualnego poziomu */
	public static double getGravity(String nazwaPliku) throws IOException {
		Properties p = new Properties();
		InputStream is = new FileInputStream(nazwaPliku);
		p.load(is);
		return Double.parseDouble(p.getProperty(levelGravity));
	}

	/** Metoda s³uz¹ca zapisywania nicku oraz liczby punktow do pliku ranking.properties */
	public static void saveToFile(String nick, String score) throws IOException {
		Properties p = new Properties();
		InputStream is = new FileInputStream("resources/ranking.properties");
		p.load(is);

		p.setProperty(nick, score);
		p.store(new FileOutputStream("resources/ranking.properties"), null);
		is.close();
	}

}