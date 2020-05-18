
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

public class Nickname {

	private JFrame frmNick;
	static String nick;

	/**
	 * Konstruktor wywolujacy funkcje initialize()
	 */
	public Nickname() {
		initialize();
		
	}
	

	/**
	 * Funkcja initialize(), wywo³uje now¹ nowy Frame, w korym wpisujemy nick gracza
	 * Po nacisnieciu przycisku Dalej nick ten frame jest zamykany i tworzy siê nowy, w ktorym rysowana jest gra
	 * new StartGame() - tworzy nowy JFrame
	 * new DrawStuff() - tworzy nowy obiekt, ktory rysuje okienko z gr¹
	 * new Toolbar() - tworzy nowy obiekt, ktory rysuje Toolbar z prawej strony JFrame'a, na ktorym wyswietlane sa elementy gry (np. czas poziomu, punkty, itp.)
	 */
	private void initialize() {
		frmNick = new JFrame();
		frmNick.setTitle("Nick");
		frmNick.setResizable(false);
		frmNick.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frmNick.setBounds(700, 400, 351, 191);
		frmNick.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNick.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		frmNick.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0, 0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblWpiszSwjNick = new JLabel("Wpisz swoj nick");
		lblWpiszSwjNick.setForeground(Color.WHITE);
		
		GridBagConstraints gbc_lblWpiszSwjNick = new GridBagConstraints();
		gbc_lblWpiszSwjNick.gridwidth = 10;
		gbc_lblWpiszSwjNick.insets = new Insets(0, 0, 5, 0);
		gbc_lblWpiszSwjNick.gridx = 0;
		gbc_lblWpiszSwjNick.gridy = 1;
		
		panel.add(lblWpiszSwjNick, gbc_lblWpiszSwjNick);
		
		JTextPane textPane = new JTextPane();
		
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 10;
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 3;
		panel.add(textPane, gbc_textPane);
		
		JButton btnZatwierd = new JButton("Dalej");
		btnZatwierd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {    
				nick = textPane.getText();
				if(!textPane.getText().isEmpty()) {
				
				try {		
					StartGame st = new StartGame();
					Toolbar tb = new Toolbar();
			        DrawStuff d = new DrawStuff();
			        st.add(d);
			        st.add(tb, BorderLayout.EAST);
			        st.setVisible(true);
			        frmNick.setVisible(false);
				} catch (IOException e) {
					
					e.printStackTrace();
				}  
				}
				else if(textPane.getText().isEmpty())	{
					JOptionPane.showMessageDialog(null,"Wprowadz swoj nick!!");
				}
			        
			}
		});
		GridBagConstraints gbc_btnZatwierd = new GridBagConstraints();
		gbc_btnZatwierd.insets = new Insets(0, 0, 5, 0);				//Odstêp(top, left, bottom, right)
		gbc_btnZatwierd.gridwidth = 10;
		gbc_btnZatwierd.gridx = 0;
		gbc_btnZatwierd.gridy = 4;
		panel.add(btnZatwierd, gbc_btnZatwierd);
		
	}

}