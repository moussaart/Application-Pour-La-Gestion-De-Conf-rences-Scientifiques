
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.desktop.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Le_session extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table2;
	private int m;
	private Connection cnxConnection;
	private PreparedStatement preparedStatement;
	private ResultSet r;
	private JDateChooser date;
	private String d,a,b,c;
	private JLabel b1,b2,b3;
	private JTextPane b4;
	private int xx,yy;
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
	    r = pStatement.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(r));
	} 
    	catch (SQLException e) 
    	 {
    		JOptionPane.showMessageDialog(null, e.getMessage());
	  } 
    }


	/**
	 * Create the frame.
	 */
	public Le_session() {
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
		setBounds(100, 100, 923, 501);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y =e.getYOnScreen();
				Le_session.this.setLocation(x-xx,y-yy);
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
		contentPane.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "choisir un article");
				}else {
					try {
						preparedStatement=cnxConnection.prepareStatement("select pdf from article where ID_art="+m);
						r=preparedStatement.executeQuery();
						r.next();
						try {
							File file=new File("test.pdf");
							FileOutputStream outputStream=new FileOutputStream(file);
							InputStream f=r.getBinaryStream(1);
							byte[] b = new byte[1024];
							while(f.read(b)>0) {
								outputStream.write(b);
							}
							try {
								Desktop.getDesktop().open(new File(file.getAbsolutePath()));
							} catch (Exception e2) {
								System.out.println(e2.getMessage());
							}
						} catch (Exception e2) {
							// TODO: handle exception
							System.out.println(e2.getMessage());
						}
					} catch (SQLException e2) {
						// TODO: handle exception
						System.out.println(e2.getMessage());
					}
				}}
		});
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(100, 467, 115, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Informations sur la session");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 77, 247, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Informations sur l'article");
		lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(10, 294, 247, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Les articles");
		lblNewLabel_2_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(645, 287, 126, 23);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("Les sessions programm\u00E9es ");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(574, 16, 267, 23);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(100, 149, 237)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 315, 294, 144);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		b1 = new JLabel("");
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("Arial", Font.BOLD, 15));
		b1.setBounds(10, 5, 274, 23);
		panel_1.add(b1);
		
		b2 = new JLabel("");
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Arial", Font.BOLD, 15));
		b2.setBounds(10, 33, 274, 23);
		panel_1.add(b2);
		
		b3 = new JLabel("");
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("Arial", Font.BOLD, 15));
		b3.setBounds(10, 61, 274, 23);
		panel_1.add(b3);
		
		b4 = new JTextPane();
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("Arial", Font.BOLD, 15));
		b4.setBounds(10, 89, 274, 48);
		panel_1.add(b4);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(100, 149, 237)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 95, 294, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel a1 = new JLabel("");
		a1.setForeground(Color.BLACK);
		a1.setFont(new Font("Arial", Font.BOLD, 15));
		a1.setBounds(10, 4, 274, 29);
		panel.add(a1);
		
		JLabel a2 = new JLabel("");
		a2.setForeground(Color.BLACK);
		a2.setFont(new Font("Arial", Font.BOLD, 15));
		a2.setBounds(10, 37, 274, 29);
		panel.add(a2);
		
		JLabel a3 = new JLabel("");
		a3.setForeground(Color.BLACK);
		a3.setFont(new Font("Arial", Font.BOLD, 15));
		a3.setBounds(10, 70, 274, 29);
		panel.add(a3);
		
		JTextPane a4 = new JTextPane();
		a4.setForeground(Color.BLACK);
		a4.setFont(new Font("Arial", Font.BOLD, 15));
		a4.setBounds(10, 103, 274, 72);
		panel.add(a4);
		
		JButton aff = new JButton("Afficher");
		aff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat dyDateFormat=new SimpleDateFormat("yyyy,MM,dd");
					d=dyDateFormat.format(date.getDate());
					if(d.equals("")) {
						JOptionPane.showMessageDialog(null, "Pas de date");
					}else {
						preparedStatement=cnxConnection.prepareStatement("select id_session as ID , jour_Date as date ,théme from session where jour_Date=?");
						preparedStatement.setString(1, d);
						r=preparedStatement.executeQuery();
						if(r.next()) {
							table_load(preparedStatement,table);
						}else {
							JOptionPane.showMessageDialog(null, "Pas des sessions");
						}
						a1.setText("");
						a2.setText("");a3.setText("");a4.setText("");b1.setText("");b2.setText("");b3.setText("");b4.setText("");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
			}
		});
		aff.setBackground(new Color(100, 149, 237));
		aff.setFont(new Font("Arial", Font.BOLD, 15));
		aff.setForeground(Color.BLACK);
		aff.setBounds(282, 45, 193, 28);
		contentPane.add(aff);
		
		date = new JDateChooser();
		date.setBounds(79, 46, 193, 28);
		contentPane.add(date);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setViewportBorder(new LineBorder(new Color(100, 149, 237), 2));
		scrollPane_1.setBounds(503, 315, 410, 175);
		contentPane.add(scrollPane_1);
		
		table2 = new JTable();
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table2.getModel();
				int i=table2.getSelectedRow();
				m= Integer.parseInt(model.getValueAt(i, 0).toString());
				try {
					preparedStatement=cnxConnection.prepareStatement("select * from article where ID_art="+m);
					r=preparedStatement.executeQuery();
					r.next();
					a=r.getString(2);//score
					b=r.getString(3);//titre
					c="";
					preparedStatement=cnxConnection.prepareStatement("select * from rediger where art_ID="+m);
					r=preparedStatement.executeQuery();
					while(r.next()) {
						c=c+r.getString("nom")+" , ";//redege par 	
					}
					b1.setText("1-Identification : "+m);
					b2.setText("2-Titre : "+b);
					b4.setText("4-Rédigé par : "+c);
					b3.setText("3-Score : "+a);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		scrollPane_1.setViewportView(table2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(100, 149, 237), 2));
		scrollPane.setBounds(501, 45, 412, 231);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int i=table.getSelectedRow();
				int t= Integer.parseInt(model.getValueAt(i, 0).toString());
				try {
				  preparedStatement=cnxConnection.prepareStatement("select ID_art,Titer,Score from apr where id_session="+t);
				  table_load(preparedStatement, table2);
				  preparedStatement=cnxConnection.prepareStatement("select * from session where id_session="+t);
					r=preparedStatement.executeQuery();
					r.next();
				  
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Le_session.class.getResource("/image/bc789.jpg")));
		lblNewLabel.setBounds(106, 11, 588, 479);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel_1.setBounds(10, 46, 81, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("x");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 35));
		lblNewLabel_3.setBounds(894, 11, 19, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Les sessions programm\u00E9es");
		lblNewLabel_4.setIcon(new ImageIcon(Le_session.class.getResource("/image/session.png")));
		lblNewLabel_4.setForeground(new Color(100, 149, 237));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_4.setBounds(10, 6, 449, 41);
		contentPane.add(lblNewLabel_4);
		
		JLabel ret = new JLabel("");
		ret.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Frame2 jFrame2=new Frame2();
				jFrame2.setVisible(true);
				dispose();
			}
		});
		ret.setIcon(new ImageIcon(Le_session.class.getResource("/image/fleche-gauche-esquissee.png")));
		ret.setBounds(852, 11, 32, 23);
		contentPane.add(ret);
	}
}
