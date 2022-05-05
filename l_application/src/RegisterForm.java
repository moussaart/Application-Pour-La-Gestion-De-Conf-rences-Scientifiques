
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;


public class RegisterForm extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton_CANCEL;
    private javax.swing.JButton jButton_Register_;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField_PASS;
    private javax.swing.JTextField jTextField_prenom;
    private javax.swing.JTextField jTextField_nom;
    private javax.swing.JTextField jTextField_cin;
    private JTextField jtext_num;
	int xx,yy;
	private Connection cnx;
	public void  concution() {  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx=DriverManager.getConnection("jdbc:mysql://localhost/java_proj","root","0000");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}}

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")

    private void initComponents() {
    	
        concution();
        jPanel1 = new javax.swing.JPanel();
        jPanel1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				RegisterForm.this.setLocation(x-xx,y-yy);
			}
		});
		jPanel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				yy=e.getY();
			}
		});
        jLabelClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setForeground(Color.BLACK);
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_cin = new javax.swing.JTextField();
        jPasswordField_PASS = new javax.swing.JPasswordField();
        jButton_Register_ = new javax.swing.JButton();
        jButton_CANCEL = new javax.swing.JButton();
        jLabelRegister = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_prenom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_nom = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inscription");

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(jLabelMin)
                .addGap(18, 18, 18)
                .addComponent(jLabelClose)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel2)
                    .addContainerGap(302, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMin, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabelClose))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(Color.WHITE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel4.setForeground(Color.BLACK);
        jLabel4.setText("Numero Cin:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel5.setForeground(Color.BLACK);
        jLabel5.setText("Password:");

        jTextField_cin.setBackground(Color.WHITE);
        jTextField_cin.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jTextField_cin.setForeground(Color.BLACK);

        jPasswordField_PASS.setBackground(Color.WHITE);
        jPasswordField_PASS.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jPasswordField_PASS.setForeground(Color.BLACK);

        jButton_Register_.setBackground(new java.awt.Color(34, 167, 240));
        jButton_Register_.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton_Register_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register_.setText("S'inscrire");
        jButton_Register_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String prenom = jTextField_prenom.getText();
                String nom = jTextField_nom.getText();
                String cin = jTextField_cin.getText();
                String pass = String.valueOf(jPasswordField_PASS.getPassword());
                String numero = jtext_num.getText();
                        
                if (cin.length()!=8) {
        			JOptionPane.showMessageDialog(null,"Entrer un numero cin valide");
        		}
                
                else if(pass.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Ajouter un mot de passe ");
                } 
                else if(checkUsername(cin))
                {
                    JOptionPane.showMessageDialog(null, "Ce numero Cin existe déjà!");
                }
                
                else{
                
                    
                PreparedStatement ps;
                String query = "INSERT INTO paricipant  VALUES (?,?,?,?,?)";
                
                try {
                    ps = cnx.prepareStatement(query);
                    ps.setInt(1, Integer.parseInt(cin));
                    ps.setString(2, nom);
                    ps.setString(3, prenom);
                    ps.setString(4,pass);
                    ps.setInt(5,Integer.parseInt(numero));
                    ps.execute();
                    Paye nPaye=new Paye(2);
                    nPaye.setVisible(true);
                    dispose();
                    
                } catch (SQLException ex) {
                	System.out.println(ex.getMessage());
                }
                }
            }
        });

        jButton_CANCEL.setBackground(new java.awt.Color(242, 38, 19));
        jButton_CANCEL.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton_CANCEL.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CANCEL.setText("Annuler");
        jButton_CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Home nHome = new Home();
					nHome.setVisible(true);
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jLabelRegister.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabelRegister.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegister.setText("click here to login");
        jLabelRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegisterMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel6.setForeground(Color.BLACK);
        jLabel6.setText("nom:");

        jTextField_prenom.setBackground(Color.WHITE);
        jTextField_prenom.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField_prenom.setForeground(Color.BLACK);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel7.setForeground(Color.BLACK);
        jLabel7.setText("prenom:");

        jTextField_nom.setBackground(Color.WHITE);
        jTextField_nom.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField_nom.setForeground(Color.BLACK);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RegisterForm.class.getResource("/image/123-ConvertImage (1).jpg")));
        
        jtext_num = new JTextField();
        jtext_num.setForeground(Color.BLACK);
        jtext_num.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jtext_num.setBackground(Color.WHITE);
        
        JLabel lblNumroPortable = new JLabel();
        lblNumroPortable.setText("num\u00E9ro portable");
        lblNumroPortable.setForeground(Color.BLACK);
        lblNumroPortable.setFont(new Font("Tahoma", Font.PLAIN, 18));


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(43)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel5)
        								.addComponent(jLabel4)
        								.addComponent(lblNumroPortable, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))))
        					.addGap(51)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jTextField_cin, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jPasswordField_PASS, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jtext_num, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jTextField_nom, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jTextField_prenom, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(146)
        					.addComponent(jLabelRegister)
        					.addGap(173))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jButton_CANCEL, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        					.addGap(38)
        					.addComponent(jButton_Register_, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
        					.addGap(93)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 492, Short.MAX_VALUE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(51)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(jLabel6)
        							.addGap(18)
        							.addComponent(jLabel7)
        							.addGap(18)
        							.addComponent(jLabel4)
        							.addGap(18)
        							.addComponent(jLabel5)
        							.addGap(18)
        							.addComponent(lblNumroPortable, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(jTextField_prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(jTextField_nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(jTextField_cin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(jPasswordField_PASS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(jtext_num, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton_Register_, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton_CANCEL, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
        					.addGap(118)
        					.addComponent(jLabelRegister)))
        			.addGap(30))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
        				.addComponent(jPanel2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1185, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {

        System.exit(0);

    }

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {

        this.setState(JFrame.ICONIFIED);

    }

    private void jLabelRegisterMouseClicked(java.awt.event.MouseEvent evt) {
        LoginForm lgf = new LoginForm();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }



    
    // function to check if the numero cin already exist
    public boolean checkUsername(String username)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM paricipant WHERE CIN_Part =?";
        
        try {
            ps = cnx.prepareStatement(query);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
        	ex.getMessage();
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkUser;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }
}
