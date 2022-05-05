
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.net.MalformedURLException;
import java.net.URI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Les_tutroiel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ResultSet rs;
	private int xx,yy,t;
	private JPanel panel;
	private String a,b,c,d ,nom;
	private Connection cnxConnection;
	private PreparedStatement preparedStatement;
	private JTable table;
	private JLabel a1,a2,a3;
	private JTextPane a4;
	private JLabel lblNewLabel;
	private JLabel lblLespaceDesTutoriels;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	public void  concution() throws ClassNotFoundException {  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnxConnection=DriverManager.getConnection("jdbc:mysql://localhost/java_proj","root","0000");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}}
	public void table_load(int cin )
    {
    	try 
    	{
    		preparedStatement=cnxConnection.prepareStatement("select ID_tuto as ID , t.TH_nom as théme  , t.jour_Date as date  , t.date as time  , Nom "
					+ "from tutorial as  t , assister as   a , paricipant as p"+
    				" where p.CIN_Part=? and p.CIN_Part=a.PAR_cin and a.TUTO_id=t.ID_tuto ORDER BY date ASC ");
			preparedStatement.setInt(1, cin);
			rs = preparedStatement.executeQuery();
	    	table.setModel(DbUtils.resultSetToTableModel(rs));    
	} 
    	catch (SQLException e) 
    	 {
    		JOptionPane.showMessageDialog(null, e.getMessage());
	  } 
    }


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public Les_tutroiel(int cin ) throws ClassNotFoundException {
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
		setBounds(100, 100, 1072, 477);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				yy=e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y =e.getYOnScreen();
				Les_tutroiel.this.setLocation(x-xx,y-yy);
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOverire = new JButton("Ouvrir");
		btnOverire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Choisir un tutoriel ");
				}else {
					try {
						preparedStatement=cnxConnection.prepareStatement("select site from tutorial where ID_tuto="+t);
						rs=preparedStatement.executeQuery();
						rs.next();
						try {
							URI j = new URI(rs.getString(1));
							Desktop.getDesktop().browse(j);
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
			}
		});
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Les_tutroiel.class.getResource("/image/creation-de-sites-web.png")));
		lblNewLabel_4.setBounds(774, 431, 46, 43);
		contentPane.add(lblNewLabel_4);
		btnOverire.setForeground(Color.BLACK);
		btnOverire.setFont(new Font("Arial", Font.BOLD, 20));
		btnOverire.setBackground(new Color(255, 99, 71));
		btnOverire.setBounds(815, 441, 247, 23);
		contentPane.add(btnOverire);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		scrollPane.setBounds(10, 65, 346, 353);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(186, 85, 211)));
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setBackground(new Color(216, 191, 216));
				try {
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					int i =table.getSelectedRow();
					t =Integer.parseInt( model.getValueAt(i, 0).toString());
					a=model.getValueAt(i, 1).toString();
					b=model.getValueAt(i, 2).toString();
					c=model.getValueAt(i, 3).toString();
					d=model.getValueAt(i, 4).toString();
					preparedStatement=cnxConnection.prepareStatement("SELECT ch.Prenom_ch , ch.Nom_ch "
				    		+ "from tutorial t, chercheur ch where t.ID_tuto="+t+" and ch.CIN_ch=t.ch_ID ");
				    rs=preparedStatement.executeQuery();
				    nom="";
				   while(rs.next()) {
					   nom=rs.getString(1)+" "+rs.getString(2); 
				   }
				    	
					a1.setText("1-Théme : "+a+" et Nom : "+d);
					a2.setText("2-Date : "+b);
					a3.setText("3- Heure de debuit : "+c);
					a4.setText("4-Présent par : "+nom);	
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		scrollPane.setViewportView(table);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(716, 92, 346, 322);
		contentPane.add(panel);
		panel.setLayout(null);
		
		a1 = new JLabel("");
		a1.setForeground(new Color(0, 0, 0));
		a1.setFont(new Font("Arial", Font.BOLD, 15));
		a1.setBounds(10, 42, 326, 28);
		panel.add(a1);
		
		a2 = new JLabel("");
		a2.setForeground(new Color(0, 0, 0));
		a2.setFont(new Font("Arial", Font.BOLD, 15));
		a2.setBounds(10, 112, 326, 28);
		panel.add(a2);
		
		a3 = new JLabel("");
		a3.setForeground(new Color(0, 0, 0));
		a3.setFont(new Font("Arial", Font.BOLD, 15));
		a3.setBounds(10, 182, 326, 28);
		panel.add(a3);
		
		a4 = new JTextPane();
		a4.setForeground(new Color(0, 0, 0));
		a4.setFont(new Font("Arial", Font.BOLD, 15));
		a4.setBounds(10, 252, 326, 44);
		panel.add(a4);
		
		JButton aff = new JButton("Afficher");
		aff.setBackground(new Color(255, 99, 71));
		aff.setForeground(new Color(0, 0, 0));
		aff.setFont(new Font("Arial", Font.BOLD, 20));
		aff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a1.setText("");
				a2.setText("");
				a3.setText("");
				a4.setText("");
				panel.setBackground(Color.WHITE);
				table_load(cin);
				
			}
		});
		aff.setBounds(10, 441, 346, 23);
		contentPane.add(aff);
		
		lblNewLabel = new JLabel("Informations sur le tutoriel ");
		lblNewLabel.setForeground(new Color(100, 149, 237));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(716, 65, 309, 34);
		contentPane.add(lblNewLabel);
		
		lblLespaceDesTutoriels = new JLabel("L'espace des Tutoriels");
		lblLespaceDesTutoriels.setIcon(new ImageIcon(Les_tutroiel.class.getResource("/image/tuto.png")));
		lblLespaceDesTutoriels.setForeground(new Color(100, 149, 237));
		lblLespaceDesTutoriels.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblLespaceDesTutoriels.setBounds(10, 11, 323, 43);
		contentPane.add(lblLespaceDesTutoriels);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Home fHome=new Home();
					fHome.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel_1.setBounds(1035, 9, 27, 34);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Le_programme jLe_programme=new Le_programme(cin);
				jLe_programme.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(Les_tutroiel.class.getResource("/image/fleche-gauche-esquissee.png")));
		lblNewLabel_2.setBounds(993, 15, 32, 23);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Les_tutroiel.class.getResource("/image/20944349-ConvertImage.jpg")));
		lblNewLabel_3.setBounds(269, 11, 924, 455);
		contentPane.add(lblNewLabel_3);
	}
}
