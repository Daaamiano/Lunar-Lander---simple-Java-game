import java.io.IOException;

/**
 * Klasa, w ktorej znajdujê siê automatycznie wygenerowany kod przez (WindowBuilder editor)
 * Cale Menu wyswietlajace sie na samym poczatku 
 * Odpowiednie zarzadzanie przyciskami w Menu
 */

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }
    
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Button_Start = new javax.swing.JButton();
        Button_Wynik = new javax.swing.JButton();
        Button_Instrukcja = new javax.swing.JButton();
        Button_Siec = new javax.swing.JButton();
        Button_Wyjdz = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setFont(new java.awt.Font("Tahoma", 3, 14));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Lunar Lander");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lunar Lander");
        setLocationByPlatform(true);
        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 0, 0), java.awt.Color.darkGray));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.setToolTipText("");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setName(""); 

        Button_Start.setBackground(new java.awt.Color(255, 51, 51));
        Button_Start.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        Button_Start.setText("START");
        Button_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Button_StartActionPerformed(evt);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
            }
        });

        Button_Wynik.setBackground(new java.awt.Color(255, 51, 51));
        Button_Wynik.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Button_Wynik.setText("Najlepszy wyniki");
        Button_Wynik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Button_WynikActionPerformed(evt);
				} catch (IOException e) {
				
					e.printStackTrace();
				}
            }
        });

        Button_Instrukcja.setBackground(new java.awt.Color(255, 51, 51));
        Button_Instrukcja.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        Button_Instrukcja.setText("Instrukcja");
        Button_Instrukcja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_InstrukcjaActionPerformed(evt);
            }
        });

        Button_Siec.setBackground(new java.awt.Color(255, 51, 51));
        Button_Siec.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        Button_Siec.setText("Sieæ");


        Button_Wyjdz.setBackground(new java.awt.Color(255, 51, 51));
        Button_Wyjdz.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Button_Wyjdz.setText("Wyjdz");
        Button_Wyjdz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_WyjdzActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Sitka Small", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lunar Lander");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Button_Wyjdz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button_Instrukcja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button_Start, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button_Wynik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button_Siec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)))
                .addGap(141, 141, 141))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_Start, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_Wynik, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_Instrukcja, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_Siec, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_Wyjdz, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }
    
    private void Button_StartActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
    	
    	Nickname nk = new Nickname();
    	this.dispose();
        
    }
   
    private void Button_WyjdzActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void Button_InstrukcjaActionPerformed(java.awt.event.ActionEvent evt) {
          FrameInstruction ob = new FrameInstruction ();
          ob.setTitle("Instrukcja gry");
          ob.setLocation(200, 200);
          ob.setVisible(true);
          ob.setDefaultCloseOperation(FrameInstruction.DISPOSE_ON_CLOSE);
    }


    private void Button_WynikActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
          FrameResults wy = new FrameResults ();
          wy.setTitle("Najlepsze wyniki");
          wy.setLocation(200, 200);
          wy.setVisible(true);
          wy.setDefaultCloseOperation(FrameResults.DISPOSE_ON_CLOSE);
    }

    public static void main(String args[]) {

    		Main main = new Main();
                main.setVisible(true);

    }
    
    private javax.swing.JButton Button_Instrukcja;
    private javax.swing.JButton Button_Siec;
    private javax.swing.JButton Button_Start;
    private javax.swing.JButton Button_Wyjdz;
    private javax.swing.JButton Button_Wynik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
   
}