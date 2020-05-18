
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Klasa, w kt�rej znajduj� si� automatycznie wygenerowany kod przez (WindowBuilder editor)
 * przedstawiaj�cy okienko w kt�rym znajduj� si� instrukcja gry.
 * Okienko pojawia si� po naci�ni�ciu przycisku w startowym Menu - Insstrukcja
 */


public class FrameInstruction extends javax.swing.JFrame {
	
	
	/** Konstruktor wywo�uj�cy metod� initComponents() */
    public FrameInstruction() {
        initComponents();
    }
   
    /** Metoda, w kt�rej znajduj� si� automatycznie wygenerowany kod przez (WindowBuilder editor) */
   
    private void initComponents() {
    	
    	
    	try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("resources/Instruction.png")))));	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 300, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }
}