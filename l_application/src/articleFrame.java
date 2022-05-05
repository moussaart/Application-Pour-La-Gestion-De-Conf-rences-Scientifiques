
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class articleFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection conn;
	private JTextField id;
	private PreparedStatement p ;
	private ResultSet res ;
	private JTextField titreartc;
	private JTextField idart;
	private String b;
	private String[] themeStrings={"socitétal",
			"Economie","Intrastrutures","Neurosiences","Ecoles","Agroalimentaire",
			"Electronique", "Innovation","Numeérique","HighTech","Batiment","Enivronnement",
			"Matériaux","Robotique", "Energie","Chimie","Espace","Mecanique","Santé","Usine du futur",
			"Climenat","Industrie","Nature","Transport"};
	public void connection(Connection conn2) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/java_proj","root","0000");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		 } 
		 
	 }


	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public articleFrame() throws ClassNotFoundException {
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
		setUndecorated(true);
		setBackground(Color.LIGHT_GRAY);
		connection(conn) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(100, 149, 237)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 350, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		id = new JTextField();
		id.setBounds(10, 115, 330, 36);
		panel.add(id);
		id.setBackground(Color.WHITE);
		id.setColumns(100);
		
		JLabel lbart = new JLabel("ID Article\r\n");
		lbart.setBounds(10, 169, 330, 25);
		panel.add(lbart);
		lbart.setForeground(Color.DARK_GRAY);
		lbart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbart.setBackground(SystemColor.inactiveCaption);
		
		idart = new JTextField();
		idart.setBounds(10, 212, 330, 33);
		panel.add(idart);
		idart.setBackground(Color.WHITE);
		idart.setColumns(10);
		
		
		
		
		
		JLabel lb2 = new JLabel("Titre de l'article");
		lb2.setBounds(10, 263, 330, 36);
		panel.add(lb2);
		lb2.setForeground(Color.DARK_GRAY);
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		titreartc = new JTextField();
		titreartc.setBounds(10, 317, 330, 36);
		panel.add(titreartc);
		titreartc.setBackground(Color.WHITE);
		titreartc.setColumns(10);
		
		
		JLabel th = new JLabel("Theme");
		th.setBounds(10, 371, 330, 33);
		panel.add(th);
		th.setForeground(Color.DARK_GRAY);
		th.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 422, 330, 33);
		for(String i:themeStrings) {
			comboBox.addItem(i);
		}
		panel.add(comboBox);
		comboBox.setBackground(new Color(100, 149, 237));
		comboBox.setSelectedItem(null);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(70, 473, 211, 36);
		panel.add(btnNewButton);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNouveauArtacile = new JLabel("Nouveau article");
		lblNouveauArtacile.setIcon(new ImageIcon(articleFrame.class.getResource("/image/article.png")));
		lblNouveauArtacile.setForeground(new Color(30, 144, 255));
		lblNouveauArtacile.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNouveauArtacile.setBackground(Color.WHITE);
		lblNouveauArtacile.setBounds(10, 18, 330, 36);
		panel.add(lblNouveauArtacile);
		
		JLabel lblIdChercheurchchch = new JLabel("ID(s) Chercheur(s)(ch1,ch2,ch3)");
		lblIdChercheurchchch.setForeground(Color.DARK_GRAY);
		lblIdChercheurchchch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdChercheurchchch.setBackground(SystemColor.inactiveCaption);
		lblIdChercheurchchch.setBounds(10, 79, 330, 25);
		panel.add(lblIdChercheurchchch);
		
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 27));
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(808, -7, 36, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(articleFrame.class.getResource("/image/bc222.jpg")));
		lblNewLabel.setBounds(269, 11, 565, 531);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(788, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a =id.getText();
				String c,dString;
				b=idart.getText();
				c=titreartc.getText();
				dString=comboBox.getItemAt(comboBox.getSelectedIndex());
				String[] f;
				f=a.split(",");
				boolean bool = true;
				int z = 0;
				try {
					if((a.equals("")||(b.equals("")||(c.equals("")||(dString.equals("")))))) {
						JOptionPane.showMessageDialog(null, "Il existe encore une colonne vide");
					}else {
						for(int i=0;i<f.length;i++) {
							
								p=conn.prepareStatement("select*from chercheur where CIN_ch=?");
								p.setInt(1,Integer.parseInt(f[i]));
								res=p.executeQuery();
								if(res.next()) {
								}else {
									bool=false;
									z=i;
								}
						}
						if(bool) {
								p=conn.prepareStatement("insert into article values(?,0,?,?,0,null,null)");
								p.setInt(1, Integer.parseInt(b));
								p.setString(2, c);
								p.setString(3, dString);
								p.execute();
								for(int i=0;i<f.length;i++) {
									p=conn.prepareStatement("select Prenom_ch , Nom_ch from chercheur where CIN_ch=?");
									p.setInt(1, Integer.parseInt(f[i]));
									res=p.executeQuery();
									res.next();
									String kk,kk1;
									kk=res.getString(1);//prenom
									kk1=res.getString(2);//nom
									p=conn.prepareStatement("insert into rediger values(?,?,?,?)");
									p.setInt(1, Integer.parseInt(f[i]));
									p.setInt(2, Integer.parseInt(b));
									p.setString(3, c);
									p.setString(4, kk+" "+kk1);
									p.execute();	
								}
								
								
								Add fAdd=new Add(Integer.parseInt(b));
								fAdd.setVisible(true);
								dispose();
							
						}else {
							JOptionPane.showMessageDialog(null, "Cet Id numero "+z+" n'existe pas ");
						
					}
				}
					
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				
			}
		});
	}
}
