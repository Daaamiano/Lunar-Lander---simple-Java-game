/**
 * Klasa,w ktej znajduj si zarzdzanie Toolbarem: wywietlanie pozostaego paliwa, poziomu, liczby y
 * czasu aktualnego poziomu, cakowitego czasu gry oraz iloci zdobywanych punktw 
 * funkcjonalno przyciskw (strzaek) znajdujcych si na toolbarze do sterowania rakiet 
 * funkcjonalno 3 przyciskw na dole toolbara: Start (wznawianie gry po pauzie), Pauza (zatrzymywanie rozgrywki)
 * Wyjdz(wyczenie gry)
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Toolbar extends JPanel {
	
	/** Zmienne oraz tworzenie Label wykorzystywane do wywietlania informacji na toolbar */
	public static int lev=1;
	static JLabel lblSummaryTime = new JLabel();
	static JLabel lblTime = new JLabel();
	static JLabel lblPoziomSs = new JLabel();
	static JLabel lblLifes = new JLabel();
	static JLabel lblIlo = new JLabel();
	static JLabel lblIloPunktw = new JLabel();
	static int secondsPassed = 0;
	static int secondsPassedLevel = 0;
	public static boolean pause = false;
	
	/** Metoda zwracajca poziom gry */
	public static int getLevel() {
		return lev;
	}
	
	/** Metoda wywietlajca pozostae paliwo, poziom, liczbe y 
	 *  czasu aktualnego poziomu, cakowitego czasu gry oraz iloci zdobywanych punktw  
	 */
	static ActionListener taskPerformer = new ActionListener() {
        @Override
       public void actionPerformed(ActionEvent evt) {
        	if(pause==false) {
        	 lblSummaryTime.setText("Calkowity Czas: "+currentTime());
        	 lblTime.setText("Czas poziomu: "+currentLevelTime());
           	 lblPoziomSs.setText("Poziom: "+lev);
           	 lblLifes.setText("Liczba zyc: "+Rocket.getLifes(0));
           	 lblIlo.setText("Paliwo: "+Rocket.getRocketFuel()+"%");
           	 lblIloPunktw.setText("Punkty: "+Rocket.gamePoints);
        	}
       }
   };
   
   /** Odwiezanie co 1 ms */
   static Timer t = new Timer(1000, taskPerformer);
   
   /** konstruktor, w ktrym umieszczone jest rozmieszczenie na Toolbar informacji oraz przyciskow */
public Toolbar() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		lblIlo.setText("Paliwo: 100%");
		GridBagConstraints gbc_lblIlo = new GridBagConstraints();
		gbc_lblIlo.insets = new Insets(0, 0, 5, 0);
		gbc_lblIlo.gridx = 1;
		gbc_lblIlo.gridy = 0;
		this.add(lblIlo, gbc_lblIlo);
		lblPoziomSs.setText("Poziom: "+lev);
		GridBagConstraints gbc_lblPoziomSs = new GridBagConstraints();
		gbc_lblPoziomSs.insets = new Insets(0, 0, 5, 0);
		gbc_lblPoziomSs.gridx = 1;
		gbc_lblPoziomSs.gridy = 1;
		this.add(lblPoziomSs, gbc_lblPoziomSs);
		lblLifes.setText("Liczba y: "+Rocket.getLifes(0));
		GridBagConstraints gbc_lblLifes = new GridBagConstraints();
		gbc_lblLifes.insets = new Insets(0, 0, 5, 0);
		gbc_lblLifes.gridx = 1;
		gbc_lblLifes.gridy = 2;
		this.add(lblLifes, gbc_lblLifes);
		lblTime.setText("Czas poziomu: "+currentLevelTime());
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.insets = new Insets(0, 0, 5, 0);
		gbc_lblTime.gridx = 1;
		gbc_lblTime.gridy = 3;
		this.add(lblTime, gbc_lblTime);
		lblSummaryTime.setText("Cakowity Czas: "+currentTime());
		GridBagConstraints gbc_lblSummaryTime = new GridBagConstraints();
		gbc_lblSummaryTime.insets = new Insets(0, 0, 5, 0);
		gbc_lblSummaryTime.gridx = 1;
		gbc_lblSummaryTime.gridy = 4;
		this.add(lblSummaryTime, gbc_lblSummaryTime);
		lblIloPunktw.setText("Punkty: "+Rocket.gamePoints);
		GridBagConstraints gbc_lblIloPunktw = new GridBagConstraints();
		gbc_lblIloPunktw.insets = new Insets(0, 0, 5, 0);
		gbc_lblIloPunktw.gridx = 1;
		gbc_lblIloPunktw.gridy = 5;
		this.add(lblIloPunktw, gbc_lblIloPunktw);
		JButton btnUp = new JButton("\u02C4");
	    GridBagConstraints gbc_btnUp = new GridBagConstraints();
	    gbc_btnUp.insets = new Insets(0, 0, 5, 0);
	    gbc_btnUp.gridx = 1;
	    gbc_btnUp.gridy = 6;
	    this.add(btnUp, gbc_btnUp);
	    
	    /** Fukncjonalno prycisku (strzaka w gre) sucych do latania rakiety*/
	    btnUp.addMouseListener(new MouseListener() {
	        public void mouseClicked(MouseEvent e) {}
	        public void mouseEntered(MouseEvent e) {}
	        public void mouseExited(MouseEvent e) {}
	        public void mousePressed(MouseEvent e) {
	        	Rocket.falling=false;
	        }
	        public void mouseReleased(MouseEvent e) {
	        	Rocket.falling=true;
	        }
	    });
	    btnUp.addKeyListener(new KeyListener(){
	        public void keyTyped(KeyEvent e) {}
	        public void keyPressed(KeyEvent e) {
	            if (btnUp.getModel().isPressed()) {
	            	Rocket.falling=false;
	            } else {
	            	Rocket.falling=true;
	            }
	        }
	        public void keyReleased(KeyEvent e) {
	        	Rocket.falling=true;
	        }
	    });
	    
	    JButton btnLeft = new JButton("\u02C2");
	    GridBagConstraints gbc_btnLeft = new GridBagConstraints();
	    gbc_btnLeft.insets = new Insets(0, 0, 5, 0);
	    gbc_btnLeft.gridx = 0;
	    gbc_btnLeft.gridy = 7;
	    this.add(btnLeft, gbc_btnLeft);
	    btnLeft.addMouseListener(new MouseListener() {
	        public void mouseClicked(MouseEvent e) {}
	        public void mouseEntered(MouseEvent e) {}
	        public void mouseExited(MouseEvent e) {}
	        public void mousePressed(MouseEvent e) {
	        	Rocket.flyingDirection=-1;
	        }
	        public void mouseReleased(MouseEvent e) {
	        	Rocket.flyingDirection=0;
	        }
	    });
	    
	    /** Fukncjonalno prycisku (strzaka w lewo) sucych do latania rakiety*/
	    btnLeft.addKeyListener(new KeyListener(){
	        public void keyTyped(KeyEvent e) {}
	        public void keyPressed(KeyEvent e) {
	            if (btnLeft.getModel().isPressed()) {
	            	Rocket.flyingDirection=-1;
	            } else {
	            	Rocket.flyingDirection=0;
	            }
	        }
	        public void keyReleased(KeyEvent e) {
	        	Rocket.flyingDirection=0;
	        }
	    });
	    
	    JButton btnRight = new JButton("\u02C3");
	    GridBagConstraints gbc_btnRight = new GridBagConstraints();
	    gbc_btnRight.insets = new Insets(0, 0, 5, 0);
	    gbc_btnRight.gridx = 3;
	    gbc_btnRight.gridy = 7;
	    this.add(btnRight, gbc_btnRight);
	    
	    btnRight.addMouseListener(new MouseListener() {
	        public void mouseClicked(MouseEvent e) {}
	        public void mouseEntered(MouseEvent e) {}
	        public void mouseExited(MouseEvent e) {}
	        public void mousePressed(MouseEvent e) {
	        	Rocket.flyingDirection=1;
	        }
	        public void mouseReleased(MouseEvent e) {
	        	Rocket.flyingDirection=0;
	        }
	    });
	    
	    /** Funkcjonalnosc prycisku (strzaka w prawo) sluzacych do latania rakiety*/
	    btnRight.addKeyListener(new KeyListener(){
	        public void keyTyped(KeyEvent e) {}
	        public void keyPressed(KeyEvent e) {
	            if (btnRight.getModel().isPressed()) {
	            	Rocket.flyingDirection=1;
	            } else {
	            	Rocket.flyingDirection=0;
	            }
	        }
	        public void keyReleased(KeyEvent e) {
	        	Rocket.flyingDirection=0;
	        }
	    });
	    /** Fukncjonalno prycisku (strzaka w prawo) sucych do latania rakiety*/
    	JButton btnStart = new JButton("Start");
		btnStart.setHorizontalAlignment(SwingConstants.TRAILING);
		btnStart.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 0);
		gbc_btnStart.weighty = 25;
		gbc_btnStart.anchor = GridBagConstraints.SOUTH;
		gbc_btnStart.gridx = 1;
		gbc_btnStart.gridy = 23;
		this.add(btnStart, gbc_btnStart);
		btnStart.addActionListener(new ActionListener(){
			@Override
			/** Fukncjonalnosc prycisku START sluzacych do wznawiania gry*/
			public void actionPerformed(ActionEvent arg0) {
				if(pause==true && DrawStuff.landed==false && DrawStuff.crash==false) {
					pause=false;	
				}
				else {
					System.out.println("Nie moesz teraz nacisn przycisku!");
				}
			}
		});
		JButton btnPauza = new JButton("Pauza");
		btnPauza.setHorizontalAlignment(SwingConstants.TRAILING);
		btnPauza.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnPauza = new GridBagConstraints();
		gbc_btnPauza.insets = new Insets(0, 0, 5, 0);
		gbc_btnPauza.weighty = 0;
		gbc_btnPauza.anchor = GridBagConstraints.SOUTH;
		gbc_btnPauza.gridx = 1;
		gbc_btnPauza.gridy = 24;
		this.add(btnPauza, gbc_btnPauza);
		btnPauza.addActionListener(new ActionListener(){
			@Override
			/** Fukncjonalnosc prycisku Pauza sluzacych do zatrzymywania gry*/
			public void actionPerformed(ActionEvent arg0) {
				if(pause==false && DrawStuff.landed==false && DrawStuff.crash==false) {
					pause=true;
				}
				else {
					System.out.println("Nie moesz teraz nacisn przycisku!");
				}
			}
		});
		JButton btnWyjd = new JButton("Wyjdz");
		btnWyjd.setHorizontalAlignment(SwingConstants.LEADING);
		btnWyjd.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnWyjd = new GridBagConstraints();
		gbc_btnWyjd.insets = new Insets(0, 0, 5, 0);
		gbc_btnWyjd.weighty = 0;
		gbc_btnWyjd.gridx = 1;
		gbc_btnWyjd.gridy = 25;
		gbc_btnWyjd.anchor = GridBagConstraints.PAGE_END;
		this.add(btnWyjd, gbc_btnWyjd);
		btnWyjd.addActionListener(new ActionListener(){
			@Override
			
			/** Fukncjonalnosc prycisku Wyjdz sluzacych do zakonczenia gry*/
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
}

/** Metoda zwracajaca czas poziomu */
public static String currentLevelTime(){
	String levelTime = checkLevelTime(secondsPassedLevel++);
	return levelTime;
}

/** Metoda zwracajaca czas gry*/
public static String currentTime(){
	String s = checkTime(secondsPassed++);
    return s;
}

static int minutes=0;

/** Metoda zmieniajaca zapis czasu, gdy czas osiagnie minute*/
public static String checkTime(int t){
String time1 = null;
if (t < 10){
	 time1=(""+minutes+":"+"0"+t);
	}
	else if(t>=10){
	 time1=(""+minutes+":"+""+t);
	 }
if(t==59) {
	secondsPassed=0;
	minutes++;
}
return time1;
	}

/** Metoda sluzaca do poprawnego zapisu czasu ( gdy jest mniejszy od 10 to pokazywany jest czas 01, 02, itp.*/
public static String checkLevelTime(int t){
String time1 = null;
if (t < 10){
	 time1=("0"+t);
	}
	else if(t>=10){
	 time1=(""+t);
	 }
return time1;
	}
}