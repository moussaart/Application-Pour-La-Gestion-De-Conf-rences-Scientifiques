
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class Inscrire_T extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField idp;
	private JTextField idt;
	private String b1,b2,b3,b4,n_et_p;
	private JLabel a1,a2,a4,a3;
	private int cinp,cint;
	private int c=0;
	private JComboBox<String> comboBox ;
	private PreparedStatement preparedStatement;
	private ResultSet rs;
	private Connection cnxConnection;
	private int xx,yy;
	private String[] themeStrings={"socitétal",
			"Economie","Intrastrutures","Neurosiences","Ecoles","Agroalimentaire",
			"Electronique", "Innovation","Numeérique","HighTech","Batiment","Enivronnement",
			"Matériaux","Robotique", "Energie","Chimie","Espace","Mecanique","Santé","Usine du futur",
			"Climenat","Industrie","Nature","Transport"};

	
	
	
	public void  concution() {  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnxConnection=DriverManager.getConnection("jdbc:mysql://localhost/java_proj","root","0000");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}}
	public void table_load(PreparedStatement pStatement,JTable table)
    {
    	try 
    	{
	    rs = pStatement.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));
	} 
    	catch (SQLException e) 
    	 {
    		JOptionPane.showMessageDialog(null, e.getMessage());
	  } 
    }
	

	/**
	 * Create the frame.
	 */
	public Inscrire_T() {
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
		setBounds(100, 100, 1101, 502);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				Inscrire_T.this.setLocation(x-xx,y-yy);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				yy=e.getY();
				
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(147, 112, 219), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton inscrire = new JButton("s'inscrire ");
		inscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String g=idp.getText();
				String tString=idt.getText();
				if(g.equals("")) {
					JOptionPane.showMessageDialog(null, "!!! Pas d'id de participant ");
				}else{
					if(tString.equals("")) {
						JOptionPane.showMessageDialog(null, "!!! Pas d'id de tutoriel ");
					}else {
						cint=Integer.parseInt(g);
						cinp=Integer.parseInt(tString);
						if(c==0) {
							JOptionPane.showMessageDialog(null, "!!! paimment effectué");
						}else {
							try {
								preparedStatement=cnxConnection.prepareStatement("select * from paricipant where CIN_Part="+cint);
								rs=preparedStatement.executeQuery();
								if(rs.next()) {
									preparedStatement=cnxConnection.prepareStatement("INSERT INTO assister VALUES(?,null,?,null)");
									preparedStatement.setInt(2, cint);
									preparedStatement.setInt(1, cinp);
									preparedStatement.execute();
									JOptionPane.showMessageDialog(null, "merci");
									idp.setText("");
									idt.setText("");
									c=0;
								}else {
									JOptionPane.showMessageDialog(null, "Cet ID est introuvable. Inscrivez-vous s'il vous plaît ");
								}
							} catch (SQLException e2) {
								JOptionPane.showMessageDialog(null, e2.getMessage());
							}
						}
					}
					
				}
			}
		});
		inscrire.setBackground(new Color(147, 112, 219));
		inscrire.setFont(new Font("Arial", Font.BOLD, 12));
		inscrire.setForeground(Color.BLACK);
		inscrire.setBounds(325, 461, 89, 30);
		contentPane.add(inscrire);
		
		JButton payer = new JButton("payer");
		payer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c=1;
				Paye jPaye=new Paye(1);
				jPaye.setVisible(true);
			}
		});
		payer.setBackground(new Color(147, 112, 219));
		payer.setFont(new Font("Arial", Font.BOLD, 12));
		payer.setForeground(Color.BLACK);
		payer.setBounds(226, 461, 89, 30);
		contentPane.add(payer);
		
		JButton ok = new JButton("ok");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String hString=idt.getText();
				if(hString.equals("")) {
					JOptionPane.showMessageDialog(null, "Pas d'id");
				}else {
					int t=Integer.parseInt(hString);
					try {
						preparedStatement=cnxConnection.prepareStatement("SELECT * FROM tutorial WHERE ID_tuto="+t);
						rs=preparedStatement.executeQuery();
						if(rs.next()) {
							b1=rs.getString(3);//theme
							b2=rs.getString(4);//date
							b3=rs.getString(5);//nom
							b4=rs.getString(6);
							cint=rs.getInt(2);
							preparedStatement=cnxConnection.prepareStatement("SELECT * FROM chercheur WHERE CIN_ch="+cint);							
							rs=preparedStatement.executeQuery();
							rs.next();
							n_et_p=rs.getString(2)+" "+rs.getString(3);
							a1.setText("1-Nom de tutoriel : "+b3);
							a2.setText("2-présenté par : "+n_et_p);
							a3.setText("3-Thémé : "+b1);
							a4.setText("4-Date : "+b2+" Heure de début :"+b4); 
						}else {
							JOptionPane.showMessageDialog(null, "Ce Tutoriel n'existe pas ");
						}
							
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				}
		});
		ok.setBackground(new Color(147, 112, 219));
		ok.setForeground(Color.BLACK);
		ok.setBounds(369, 78, 59, 30);
		contentPane.add(ok);
		
		JLabel lblNewLabel_1_3 = new JLabel("Montant \u00E0 payer 150DT");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(10, 471, 206, 20);
		contentPane.add(lblNewLabel_1_3);
		
		idp = new JTextField();
		idp.setBounds(10, 79, 179, 29);
		contentPane.add(idp);
		idp.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(147, 112, 219)));
		scrollPane.setBounds(451, 57, 640, 225);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int i=table.getSelectedRow();
				int t= Integer.parseInt(model.getValueAt(i, 0).toString());
				try {
					preparedStatement=cnxConnection.prepareStatement("SELECT * FROM tutorial WHERE ID_tuto="+t);
					rs=preparedStatement.executeQuery();
					rs.next();
						b1=rs.getString(3);//theme
						b2=rs.getString(4);//date
						b3=rs.getString(5);//nom
						b4=rs.getString(6);
						cint=rs.getInt(2);
						preparedStatement=cnxConnection.prepareStatement("SELECT * FROM chercheur WHERE CIN_ch="+cint);							
						rs=preparedStatement.executeQuery();
						rs.next();
						idt.setText(t+"");
						n_et_p=rs.getString(2)+" "+rs.getString(3);
						a1.setText("1-Nom de tutoriel : "+b3);
						a2.setText("2-présenté par : "+n_et_p);
						a3.setText("3-Théme : "+b1);
						a4.setText("4-Date : "+b2+" Heure du début :"+b4); 
					
				} catch (SQLException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		table.setBorder(new LineBorder(new Color(147, 112, 219), 2));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(147, 112, 219), 2));
		panel.setBounds(451, 322, 640, 169);
		contentPane.add(panel);
		panel.setLayout(null);
		
		a1 = new JLabel("");
		a1.setForeground(Color.BLACK);
		a1.setFont(new Font("Arial", Font.BOLD, 15));
		a1.setBounds(10, 13, 279, 26);
		panel.add(a1);
		
		a2 = new JLabel("");
		a2.setForeground(Color.BLACK);
		a2.setFont(new Font("Arial", Font.BOLD, 15));
		a2.setBounds(10, 52, 279, 26);
		panel.add(a2);
		
		a3 = new JLabel("");
		a3.setForeground(Color.BLACK);
		a3.setFont(new Font("Arial", Font.BOLD, 15));
		a3.setBounds(10, 91, 289, 26);
		panel.add(a3);
		
		a4 = new JLabel("");
		a4.setForeground(Color.BLACK);
		a4.setFont(new Font("Arial", Font.BOLD, 15));
		a4.setBounds(10, 130, 303, 28);
		panel.add(a4);
		
		idt = new JTextField();
		idt.setColumns(10);
		idt.setBounds(193, 79, 174, 29);
		contentPane.add(idt);
		
		JLabel bc = new JLabel("");
		bc.setIcon(new ImageIcon(Inscrire_T.class.getResource("/image/bc12.png")));
		bc.setBounds(10, 78, 430, 402);
		contentPane.add(bc);
		
		JLabel lblNewLabel_1 = new JLabel("ID participant");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(10, 54, 152, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID tutoriel");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setBounds(193, 54, 115, 14);
		contentPane.add(lblNewLabel_1_1);
		JLabel x = new JLabel("x");
		x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Frame2 jFrame2= new Frame2();
				jFrame2.setVisible(true);
			}
		});
		x.setForeground(new Color(147, 112, 219));
		x.setFont(new Font("Arial", Font.BOLD, 40));
		x.setBounds(1070, -2, 21, 35);
		contentPane.add(x);
		
		JLabel lblNewLabel = new JLabel("Inscription aux Tutoriels");
		lblNewLabel.setIcon(new ImageIcon(Inscrire_T.class.getResource("/image/tuto.png")));
		lblNewLabel.setForeground(new Color(147, 112, 219));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 323, 43);
		contentPane.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(451, 26, 640, 30);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton aff = new JButton("afficher");
		aff.setBounds(324, 0, 220, 23);
		panel_2.add(aff);
		aff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String thhString= comboBox.getItemAt(comboBox.getSelectedIndex());
				try {
					preparedStatement=cnxConnection.prepareStatement("select * from  tutorial where TH_nom=?" );
					preparedStatement.setString(1, thhString);
					table_load(preparedStatement,table);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		aff.setFont(new Font("Arial", Font.BOLD, 15));
		aff.setBackground(new Color(147, 112, 219));
		
		comboBox = new JComboBox<String>();
		for(String i:themeStrings) {
			comboBox.addItem(i);
		}
		comboBox.setBounds(128, 0, 188, 24);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Th\u00E9me");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 3, 108, 18);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Informations sur le tutoriel");
		lblNewLabel_2.setBounds(673, 293, 277, 24);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	}
}
