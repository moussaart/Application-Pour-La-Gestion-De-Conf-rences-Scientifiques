
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class InscrireRC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cin;
	private JTextField nom;
	private JTextField prenom;
	private JTextField mdp;
	private JTextField cmdp;
	private JComboBox<Integer> etb ;
	private JComboBox<String> th;
	private String[] themeStrings={"socitétal",
			"Economie","Intrastrutures","Neurosiences","Ecoles","Agroalimentaire",
			"Electronique", "Innovation","Numeérique","HighTech","Batiment","Enivronnement",
			"Matériaux","Robotique", "Energie","Chimie","Espace","Mecanique","Santé","Usine du futur",
			"Climenat","Industrie","Nature","Transport"};
	private int c=0;
	private int ver=0;
	private int xx,yy;
	private Connection cnx;
	private PreparedStatement pStatement;
	public void  concution() {  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx=DriverManager.getConnection("jdbc:mysql://localhost/java_proj","root","0000");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}}

	public InscrireRC() {
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
		concution();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(255, 69, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				InscrireRC.this.setLocation(x-xx,y-yy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				yy=e.getY();
			}
		});
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 250, 154), 2));
		panel.setBounds(0, 0, 449, 466);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		etb = new JComboBox<Integer>();
		etb.setBounds(166, 379, 225, 24);
		etb.addItem(0);
		etb.addItem(1);
		
		panel.add(etb);
		
		JLabel lblNewLabel = new JLabel("CIN");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(40, 21, 46, 14);
		panel.add(lblNewLabel);
		
		th = new JComboBox<String>();
		th.setBackground(new Color(255, 255, 255));
		th.setBounds(166, 344, 225, 24);
		for(String i:themeStrings) {
			th.addItem(i);
		}
		panel.add(th);
		
		cin = new JTextField();
		cin.setBounds(40, 56, 225, 26);
		panel.add(cin);
		cin.setColumns(10);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(190, 138, 160, 26);
		panel.add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(40, 138, 140, 26);
		panel.add(prenom);
		
		mdp = new JTextField();
		mdp.setColumns(10);
		mdp.setBounds(40, 220, 225, 26);
		panel.add(mdp);
		
		cmdp = new JTextField();
		cmdp.setColumns(10);
		cmdp.setBounds(40, 302, 225, 26);
		panel.add(cmdp);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(40, 103, 102, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nom");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(190, 103, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mot de passe\r\n");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(40, 185, 140, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("confirmer le mot de passe");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(40, 267, 225, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Etablis");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(40, 384, 67, 14);
		panel.add(lblNewLabel_6);
		
		JButton inc = new JButton("s'inscrire");
		inc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a,b,d,h,j,f,i;
				int k;
				i=th.getItemAt(th.getSelectedIndex());
				a=cin.getText();b=nom.getText();d=prenom.getText();h=mdp.getText();j=cmdp.getText();k=etb.getItemAt(etb.getSelectedIndex());
					if(a.length()!=8) {
						JOptionPane.showMessageDialog(null, "CIN doit contenir  8 chiffres  ");
					}else{
						if(h.length()<5) {
							JOptionPane.showMessageDialog(null, "mot de passe doit  contenir 5 chiffres au minimum ");
						
						}else {
							if(c==0) {
								JOptionPane.showMessageDialog(null, "!!les payment ");
							}else {
								if((a.equals(""))||(b.equals(""))||(d.equals(""))||(h.equals(""))||(j.equals(""))||!(h.equals(j))) {
									JOptionPane.showMessageDialog(null, "il existe un colonne vide  ");
							
								}else {
									try {
										pStatement=cnx.prepareStatement("INSERT INTO chercheur VALUES (?,?,?,?,?,?)");
										pStatement.setInt(1, Integer.parseInt(a));
										pStatement.setString(2, d);
										pStatement.setString(3, b);
										pStatement.setInt(4, k);
										pStatement.setString(5, j);
										pStatement.setString(6, i);
										pStatement.execute();
										Rechercher jRechercher= new Rechercher(d,b,Integer.parseInt(a),i);
										jRechercher.setVisible(true);
										dispose();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										JOptionPane.showMessageDialog(null, e1.getMessage());
									}
							
							
								}
							}
						}}
				}
				
			});
		inc.setForeground(Color.WHITE);
		inc.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		inc.setBackground(new Color(25, 25, 112));
		inc.setBounds(288, 414, 151, 29);
		panel.add(inc);
		
		JLabel lblNewLabel_7 = new JLabel("montant \u00E0 payer : 350");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_7.setBounds(10, 419, 152, 19);
		panel.add(lblNewLabel_7);
		
		JButton paye = new JButton("payer");
		paye.setBackground(new Color(0, 191, 255));
		paye.setForeground(Color.WHITE);
		paye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c=1;
				Paye jInscrireRC = new Paye(1);
				jInscrireRC.setVisible(true);
			}
		});
		paye.setFont(new Font("Arial", Font.BOLD, 9));
		paye.setBounds(172, 414, 75, 29);
		panel.add(paye);
		
		JLabel x = new JLabel("x");
		x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		x.setForeground(new Color(0, 206, 209));
		x.setBackground(new Color(255, 0, 0));
		x.setFont(new Font("Arial", Font.BOLD, 40));
		x.setBounds(414, 11, 25, 29);
		panel.add(x);
		
		JLabel lblNewLabel_5_1 = new JLabel("Theme");
		lblNewLabel_5_1.setForeground(Color.BLACK);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5_1.setBounds(40, 349, 129, 14);
		panel.add(lblNewLabel_5_1);
		
		JLabel bc = new JLabel("");
		bc.setForeground(Color.WHITE);
		bc.setBackground(new Color(25, 25, 112));
		bc.setIcon(new ImageIcon(InscrireRC.class.getResource("/image/bc8.jpg")));
		bc.setBounds(0, 0, 449, 466);
		panel.add(bc);
		
	}
}
