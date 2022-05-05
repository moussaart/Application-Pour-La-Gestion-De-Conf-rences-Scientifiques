
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.MouseMotionAdapter;



public class Rechercher extends JFrame {
	
	
	
	private static final long serialVersionUID = 1L;
     private JPanel contentPane,EVAR,artpanel,NOU_T;
	private String[] themeStrings={"socitétal",
			"Economie","Intrastrutures","Neurosiences","Ecoles","Agroalimentaire",
			"Electronique", "Innovation","Numeérique","HighTech","Batiment","Enivronnement",
			"Matériaux","Robotique", "Energie","Chimie","Espace","Mecanique","Santé","Usine du futur",
			"Climenat","Industrie","Nature","Transport"};
	private String[] jourStrings= {"09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00"};
	private JPanel p1,p2,p3;
	private JLabel a1,a2,a3;
	private JTextField ID2;
	private JTextField N_T;
	private Connection cnxConnection;
	private PreparedStatement p;
	private int  xx,yy,x,y;
	private ResultSet rSet;
	private JTextField lein;
	public void  concution() {  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnxConnection=DriverManager.getConnection("jdbc:mysql://localhost/java_proj","root","0000");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}}
	
	


	public Rechercher( String nom,String prenom,int cin,String theme ) {
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
		concution();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 527);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x=e.getXOnScreen();
				int y =e.getYOnScreen();
				Rechercher.this.setLocation(x-xx,y-yy);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				yy=e.getY();
			}
		});
		contentPane.setBorder(new LineBorder(new Color(0, 250, 154), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel nom1 = new JPanel();
		nom1.setBackground(new Color(0, 250, 154));
		nom1.setBounds(0, 0, 180, 525);
		contentPane.add(nom1);
		nom1.setLayout(null);
		
		JLabel pre = new JLabel(prenom);
		pre.setForeground(new Color(0, 0, 0));
		pre.setFont(new Font("Arial", Font.BOLD, 14));
		pre.setBounds(10, 149, 160, 14);
		nom1.add(pre);
		
		JLabel lblNom = new JLabel(nom);
		lblNom.setForeground(new Color(0, 0, 0));
		lblNom.setFont(new Font("Arial", Font.BOLD, 14));
		lblNom.setBounds(10, 116, 160, 14);
		nom1.add(lblNom);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 250, 154));
		panel_3.setBounds(0, 215, 180, 195);
		nom1.add(panel_3);
		panel_3.setLayout(null);
		
		p1 = new JPanel();
		p1.setBackground(new Color(0, 250, 154));
		p1.setBounds(0, 23, 182, 34);
		panel_3.add(p1);
		
		a1 = new JLabel("Les articles\r\n");
		a1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a1.setForeground(Color.WHITE);
				a2.setForeground(Color.BLACK);
				a3.setForeground(Color.BLACK);
				EVAR.setVisible(false);
				artpanel.setVisible(true);
				NOU_T.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				p1.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				p1.setBackground(new Color(0, 250, 154));
			}
		});
		p1.add(a1);
		a1.setFont(new Font("Arial", Font.PLAIN, 20));
		a1.setForeground(Color.BLACK);
		
		p2 = new JPanel();
		p2.setBackground(new Color(0, 250, 154));
		p2.setBounds(0, 80, 182, 34);
		panel_3.add(p2);
		
		a2 = new JLabel("Evaluer un article ");
		a2.setBackground(new Color(0, 250, 154));
		a2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a2.setForeground(Color.WHITE);
				a1.setForeground(Color.BLACK);
				a3.setForeground(Color.BLACK);
				try {
					p=cnxConnection.prepareStatement("select Etablis from chercheur where CIN_ch="+cin);
					rSet=p.executeQuery();
					rSet.next();
					if(rSet.getInt(1)==0) {
						JOptionPane.showMessageDialog(null, "Vous n'êtes pas inclus dans la liste des organisateurs");
						
					}else {
						Evaluation aEvaluation=new Evaluation(theme, cin);
						aEvaluation.setVisible(true);
						EVAR.setVisible(true);
						artpanel.setVisible(false);
						NOU_T.setVisible(false);
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				p2.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				p2.setBackground(new Color(0, 250, 154));
			}
		});
		p2.add(a2);
		a2.setFont(new Font("Arial", Font.PLAIN, 20));
		a2.setForeground(Color.BLACK);
		
		p3 = new JPanel();
		p3.setBackground(new Color(0, 250, 154));
		p3.setBounds(0, 137, 182, 34);
		panel_3.add(p3);
		
		a3 = new JLabel("Nouveau tutoriel ");
		p3.add(a3);
		a3.setFont(new Font("Arial", Font.PLAIN, 20));
		a3.setForeground(Color.BLACK);
		
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon(Rechercher.class.getResource("/image/cher.png")));
		icon.setBounds(58, 19, 64, 78);
		nom1.add(icon);
		
		JLabel home = new JLabel("");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Frame2 jFrame2 =new Frame2();
				jFrame2.setVisible(true);
				dispose();
			}
		});
		home.setIcon(new ImageIcon(Rechercher.class.getResource("/image/home.png")));
		home.setBounds(74, 429, 32, 32);
		nom1.add(home);
		
		JLabel lblNewLabel_4 = new JLabel("Sp\u00E9cialit\u00E9 : "+theme);
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 182, 160, 14);
		nom1.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Fermer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(33, 480, 115, 23);
		nom1.add(btnNewButton);
		
		NOU_T = new JPanel();
		NOU_T.setBounds(178, 0, 762, 525);
		contentPane.add(NOU_T);
		NOU_T.setLayout(null);
		
		JPanel TUTO = new JPanel();
		TUTO.setBackground(new Color(255, 255, 255));
		TUTO.setBorder(new LineBorder(new Color(0, 250, 154), 2));
		TUTO.setBounds(0, 0, 228, 525);
	    NOU_T.add(TUTO);
		TUTO.setLayout(null);
		
		JLabel ID = new JLabel("Identification");
		ID.setFont(new Font("Arial", Font.BOLD, 15));
		ID.setBounds(10, 80, 100, 14);
		TUTO.add(ID);
		
		ID2 = new JTextField();
		ID2.setBounds(10, 116, 197, 31);
		TUTO.add(ID2);
		ID2.setColumns(10);
		
		JDateChooser DATE = new JDateChooser();
		DATE.setBounds(79, 341, 128, 27);
		TUTO.add(DATE);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Arial", Font.BOLD, 15));
		lblDate.setBounds(10, 347, 46, 14);
		TUTO.add(lblDate);
		
		JComboBox<String> JOUR_C = new JComboBox<String>();
		JOUR_C.setBackground(new Color(152, 251, 152));
		JOUR_C.setBounds(10, 419, 208, 24);
		TUTO.add(JOUR_C);
		for(String i:jourStrings) {
			JOUR_C.addItem(i);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Heure de d\u00E9but");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(53, 383, 122, 14);
		TUTO.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nouveau Tutoriel");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_2.setForeground(new Color(0, 250, 154));
		lblNewLabel_2.setBounds(10, 22, 208, 36);
		TUTO.add(lblNewLabel_2);
		
		JButton inscrire = new JButton("Ajouter");
		inscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a,b,c,d,vString,l;
				a=ID2.getText();
				b=N_T.getText();
				l=lein.getText();
				SimpleDateFormat dyDateFormat=new SimpleDateFormat("yyyy,MM,dd");
				d=dyDateFormat.format(DATE.getDate());
				vString=JOUR_C.getItemAt(JOUR_C.getSelectedIndex());
				if((a.equals(""))||(b.equals(""))||(d.equals(""))||(vString.equals(""))) {
					JOptionPane.showMessageDialog(null, "!! Il exsite un colune vide");
				}else {
					try {
						p=cnxConnection.prepareStatement("INSERT INTO Tutorial VALUES (?,?,?,?,?,?,?)");
						p.setInt(1, Integer.parseInt(a));
						p.setInt(2, cin);
						p.setString(3,theme);
						p.setString(4, d);
						p.setString(5, b);
						p.setString(6, vString);
						p.setString(7, l);
						p.execute();
						ID2.setText("");
						N_T.setText("");
						lein.setText("");
						JOptionPane.showMessageDialog(null, "Le tutoriel est ajouté");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				
				
				
			}
		});
		inscrire.setBackground(new Color(0, 250, 154));
		inscrire.setFont(new Font("Arial", Font.BOLD, 15));
		inscrire.setForeground(Color.BLACK);
		inscrire.setBounds(59, 465, 111, 27);
		TUTO.add(inscrire);
		
		JLabel lblNewLabel_3 = new JLabel("Nom de tutoriel");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 169, 111, 14);
		TUTO.add(lblNewLabel_3);
		
		N_T = new JTextField();
		N_T.setColumns(10);
		N_T.setBounds(10, 205, 197, 31);
		TUTO.add(N_T);
		
		lein = new JTextField();
		lein.setColumns(10);
		lein.setBounds(10, 294, 197, 31);
		TUTO.add(lein);
		
		JLabel lblNewLabel_3_1 = new JLabel("Lien de tutoriel (zoom,meat,...)");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(10, 258, 197, 14);
		TUTO.add(lblNewLabel_3_1);
		
		JPanel KIOL = new JPanel();
		KIOL.setBackground(Color.WHITE);
		KIOL.setBounds(367, 0, 374, 73);
		NOU_T.add(KIOL);
		
		JLabel bc = new JLabel("");
		bc.setIcon(new ImageIcon(Rechercher.class.getResource("/image/bc99.jpg")));
		bc.setBounds(-218, 0, 1030, 525);
		NOU_T.add(bc);
		NOU_T.setVisible(false);
		
		EVAR = new JPanel();
		EVAR.setBackground(new Color(255, 255, 255));
		EVAR.setBorder(new LineBorder(new Color(0, 250, 154), 2));
		EVAR.setBounds(179, 0, 761, 525);
		contentPane.add(EVAR);
		EVAR.setLayout(null);
		EVAR.setVisible(false);
		
		
		a3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a3.setForeground(Color.WHITE);
				a2.setForeground(Color.BLACK);
				a1.setForeground(Color.BLACK);
				NOU_T.setVisible(true);
				artpanel.setVisible(false);
				EVAR.setVisible(false);
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				p3.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				p3.setBackground(new Color(0, 250, 154));
			}
		});
		artpanel = new JPanel();
		artpanel.setBorder(new LineBorder(new Color(0, 250, 154), 2));
		artpanel.setBackground(Color.WHITE);
		artpanel.setBounds(180, 0, 760, 525);
		contentPane.add(artpanel);
		artpanel.setLayout(null);
		
		JLabel art1 = new JLabel("les articles");
		art1.addMouseListener(new MouseAdapter() {
		    @Override
			public void mouseClicked(MouseEvent e) {
		    	LES_ART2 jArt2=new LES_ART2();
		    	jArt2.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				art1.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				art1.setForeground(new Color(0, 250, 154));
			}
		});
		art1.setForeground(new Color(0, 250, 154));
		art1.setFont(new Font("Tahoma", Font.BOLD, 70));
		art1.setBounds(178, 105, 405, 105);
		artpanel.add(art1);
		
		JLabel art2 = new JLabel("Nouveau article");
		art2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					articleFrame jArticleFrame=new articleFrame();
					jArticleFrame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			public void mouseEntered(MouseEvent e) {
			art2.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				art2.setForeground(new Color(0, 250, 154));
				}
			});
		art2.setForeground(new Color(0, 250, 154));
		art2.setFont(new Font("Tahoma", Font.BOLD, 70));
		art2.setBounds(97, 315, 567, 105);
		artpanel.add(art2);
		artpanel.setVisible(false);
	}
}
