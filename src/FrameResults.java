
/**
 * Klasa, w której znajdujê siê automatycznie wygenerowany kod przez (WindowBuilder editor)
 * oraz zaimplementowane jest sortowanie i wypisywanie najlepszych wyników.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


public class FrameResults extends javax.swing.JFrame {

	/** Konstruktor wywo³uj¹cy metodê initComponents() */
	public FrameResults() throws IOException {
		initComponents();
	}

	/**
	 * Metoda, w której znajdujê siê automatycznie wygenerowany kod przez
	 * (WindowBuilder editor)
	 */
	private void initComponents() throws IOException {
		/** tablice wykorzystywane do trzymania nickow graczy oraz ich wyników */
		String[] arrayKey = new String[] {};
		String[] arrayValue = new String[] {};
		
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		/** tworzenie Jlabel w którym bêd¹ wyœwietlane nick oraz liczba punktów */
		JLabel lblNewLabel_0 = new JLabel("");
		JLabel lblNewLabel_1 = new JLabel("");
		JLabel lblNewLabel_2 = new JLabel("");
		JLabel lblNewLabel_3 = new JLabel("");
		JLabel lblNewLabel_4 = new JLabel("");
		JLabel lblNewLabel_5 = new JLabel("");
		JLabel lblNewLabel_6 = new JLabel("");
		JLabel lblNewLabel_7 = new JLabel("");
		JLabel lblNewLabel_8 = new JLabel("");
		JLabel lblNewLabel_9 = new JLabel("");
		
		/** ustawienie tekstu na œrodku */
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Najlepsze wyniki zdobyte przez graczy:");
		
		/** otworzenie pliku ranking.properties, w którym znajduj¹ siê nicki wraz z punktami */
		File file = new File("resources/ranking.properties");
		Properties properties = new Properties();
		FileInputStream fileInput = new FileInputStream(file);
		properties.load(fileInput);
		fileInput.close();

		
		int i = 0;
		
		/** tworzenie dwóch list, sk³adaj¹cych siê z nicków i wyników gracza */
		ArrayList<String> myListOfValues = new ArrayList<String>(Arrays.asList(arrayValue));
		ArrayList<String> myListOfKeys = new ArrayList<String>(Arrays.asList(arrayKey));

		/** Pêtla przechodz¹ca po pliku konfiguracyjnym i dodaj¹ca nicki i wartoœci do listy a potem do tablicy
		 * ka¿dy nick z wartoœci¹ jest w oddzielnej linii w pliku konfiguracyjnym
		 */
		Enumeration<Object> enuKeys = properties.keys();
		while (enuKeys.hasMoreElements()) {
			String key = (String) enuKeys.nextElement();
			String value = properties.getProperty(key);

			myListOfKeys.add(key);
			arrayKey = myListOfKeys.toArray(arrayKey);
			myListOfValues.add(value);
			arrayValue = myListOfValues.toArray(arrayValue);
		}

		/** Parsowanie wartoœci przypisanych do danych kluczy w pliku properties z typu string na typ integer 
		 * w celu posortowania ich.
		 */
		int size = arrayValue.length;
		int[] arrayValueInteger = new int[size];
		for (i = 0; i < arrayValue.length; i++) {
			arrayValueInteger[i] = Integer.parseInt(arrayValue[i]);
		}

		
		int tempValue;
		String tempKey;
		
		/** Sortowanie po wartoœciach (które s¹ przypisane do danych kluczy (nicków)) 
		 * w celu przedstawienia w grze najlepszych wyników (od najlepszego do najgorszego) */
		for (i = 1; i < arrayValueInteger.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arrayValueInteger[j] > arrayValueInteger[j - 1]) {
					tempValue = arrayValueInteger[j];
					arrayValueInteger[j] = arrayValueInteger[j - 1];
					arrayValueInteger[j - 1] = tempValue;

					tempKey = arrayKey[j];
					arrayKey[j] = arrayKey[j - 1];
					arrayKey[j - 1] = tempKey;

				}
			}
		}
		
		/** Ustawianie od najlepszego do najgorszego wyniku (wraz z nickiem) w okienku Instrukcji*/
		for (i = 0; i < arrayValueInteger.length; i++) {
			if (i == 0)
				lblNewLabel_0.setText(arrayKey[i] + ":" + arrayValueInteger[i]);
			if (i == 1)
				lblNewLabel_1.setText(arrayKey[i] + ":" + arrayValueInteger[i]);
			if (i == 2)
				lblNewLabel_2.setText(arrayKey[i] + ":" + arrayValueInteger[i]);
			if (i == 3)
				lblNewLabel_3.setText(arrayKey[i] + ":" + arrayValueInteger[i]);
			if (i == 4)
				lblNewLabel_4.setText(arrayKey[i] + ":" + arrayValueInteger[i]);
			if (i == 5)
				lblNewLabel_5.setText(arrayKey[i] + ":" + arrayValueInteger[i]);
			if (i == 6)
				lblNewLabel_6.setText(arrayKey[i] + ":" + arrayValueInteger[i]);
			if (i == 7)
				lblNewLabel_7.setText(arrayKey[i] + ":" + arrayValueInteger[i]);
			if (i == 8)
				lblNewLabel_8.setText(arrayKey[i] + ":" + arrayValueInteger[i]);
			if (i == 9)
				lblNewLabel_9.setText(arrayKey[i] + ":" + arrayValueInteger[i]);
		}
		
		/** Automatycznie wygenerowany kod przez (WindowBuilder editor) */
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(67)
						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE).addGap(43))
				.addGroup(layout.createSequentialGroup().addGap(171)
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_9)
								.addComponent(lblNewLabel_8).addComponent(lblNewLabel_7).addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_5).addComponent(lblNewLabel_4).addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2).addComponent(lblNewLabel_1).addComponent(lblNewLabel_0))
						.addContainerGap(173, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_0)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_3)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_4)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_5)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_6)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_7)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_8)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_9).addGap(60)));
		getContentPane().setLayout(layout);

		pack();
	}

	private javax.swing.JLabel jLabel1;
}