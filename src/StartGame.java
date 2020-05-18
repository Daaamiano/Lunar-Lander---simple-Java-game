

import javax.swing.JFrame;

import java.io.IOException;


public class StartGame extends JFrame {

	/**
	 * Klasa, w której znajdujê siê ustawienie wielkoœæi okna gry (po³o¿enia na ekranie oraz wielkoœci i szerokoœci okna)
	 */
	
	public StartGame() throws IOException {
		
		setTitle("Lunar Lander");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 700, 700);

		
		}
	
    }