

import javax.swing.JFrame;

import java.io.IOException;


public class StartGame extends JFrame {

	/**
	 * Klasa, w kt�rej znajduj� si� ustawienie wielko��i okna gry (po�o�enia na ekranie oraz wielko�ci i szeroko�ci okna)
	 */
	
	public StartGame() throws IOException {
		
		setTitle("Lunar Lander");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 700, 700);

		
		}
	
    }