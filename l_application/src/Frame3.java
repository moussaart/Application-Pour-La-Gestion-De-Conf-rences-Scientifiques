

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class Frame3 extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cin;
	private JPasswordField mdp;
	private JLabel inscrire;
	private Connection cnx;
	private PreparedStatement pStatement;
	private ResultSet rSet;
	private int xx,yy;
	
	public void  concution() {  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx=DriverManager.getConnection("jdbc:mysql://localhost/java_proj","root","0000");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}}

	/**
	 * Create the frame.
	 */
	public Frame3() {
		concution();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 395);
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
				Frame3.this.setLocation(x-xx,y-yy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				xx=e.getX();
				yy=e.getY();
			}
		});
		panel.setBackground(new Color(0x6BEAAB ));
		panel.setBounds(0, 0, 909, 395);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("CIN");
		lblNewLabel_5.setBounds(358, 98, 192, 24);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setBackground(new Color(169, 169, 169));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Espace des chercheurs ");
		lblNewLabel_1.setIcon(new ImageIcon(Frame3.class.getResource("/image/chercheur.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 37));
		lblNewLabel_1.setBounds(238, 32, 476, 34);
		panel.add(lblNewLabel_1);
		
		JLabel rt = new JLabel("");
		rt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Frame2 j = new Frame2();
				j.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(306, 126, 38, 32);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Frame3.class.getResource("/image/id.png")));
		
		JLabel lblNewLabel_4 = new JLabel("Mot de pass");
		lblNewLabel_4.setBounds(358, 176, 192, 24);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		rt.setIcon(new ImageIcon(Frame3.class.getResource("/image/sui.png")));
		rt.setBounds(10, 0, 39, 45);
		panel.add(rt);
		
		JLabel x = new JLabel("");
		x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		cin = new JTextField();
		cin.setBounds(356, 126, 194, 28);
		panel.add(cin);
		cin.setBackground(Color.WHITE);
		cin.setColumns(10);
		
		JButton conneexion = new JButton("Connexion");
		conneexion.setBounds(356, 244, 111, 28);
		panel.add(conneexion);
		conneexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cinString = cin.getText();
				@SuppressWarnings("deprecation")
				String mdpString=mdp.getText();
				if((cinString.equals(""))||(mdpString.equals(""))) {
					JOptionPane.showMessageDialog(null, "il existe un colonne vide");
					
				}else {
				
					try {
						pStatement=cnx.prepareStatement("SELECT * FROM chercheur WHERE CIN_ch=? AND mot_de_passe=?");
						pStatement.setInt(1, Integer.parseInt(cinString));
						pStatement.setString(2, mdpString);
						rSet=pStatement.executeQuery();
						if(rSet.next()) {
							Rechercher jjRechercher = new Rechercher(rSet.getString("NOM_ch"), rSet.getString("Prenom_ch"),rSet.getInt("CIN_ch"),rSet.getString("TH_nom"));
							jjRechercher.setVisible(true);
							dispose();
						}else {
						JOptionPane.showMessageDialog(null, "Chercheur inexistant veuillez s'inscrire ");
						}
					} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());;
					}
				}
			}});
		conneexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				conneexion.setForeground(new Color(0x336CE7));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				conneexion.setForeground(Color.BLACK);
			}
		});
		conneexion.setForeground(Color.BLACK);
		conneexion.setBackground(new Color(0, 250, 154));
		conneexion.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(309, 204, 32, 26);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(Frame3.class.getResource("/image/mdp.png")));
		x.setIcon(new ImageIcon(Frame3.class.getResource("/image/so.png")));
		x.setBounds(867, 0, 32, 45);
		panel.add(x);
		
		JLabel bc = new JLabel("");
		
		mdp = new JPasswordField();
		mdp.setBounds(356, 204, 194, 29);
		panel.add(mdp);
		mdp.setBackground(Color.WHITE);
		
		inscrire = new JLabel("s'inscrire");
		inscrire.setBounds(477, 248, 87, 18);
		panel.add(inscrire);
		inscrire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inscrire.setForeground(new Color(0, 250, 154));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inscrire.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				InscrireRC jInscrireRC = new InscrireRC();
				jInscrireRC.setVisible(true);
				dispose();
			}
		});
		inscrire.setForeground(new Color(255, 255, 255));
		inscrire.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		bc.setBackground(Color.WHITE);
		bc.setIcon(new ImageIcon(Frame3.class.getResource("/image/bc7.jpg")));
		bc.setBounds(-179, 0, 1088, 395);
		panel.add(bc);
	}
}
