
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Desktop;
import java.io.*;

public class Evaluation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection cnx;
	private PreparedStatement pStatement,pr ;
	private ResultSet rs,vs ;
	private JTable table;
	private int j,xx,yy,d;
	private Float k ;
	private FileOutputStream outputStream;
	private String hh,vv;
	private JScrollPane scrollPane;
	private JTextField ID;
	private JComboBox<Integer> sco;
	private JLabel bc;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	private JButton btnOverirePdf;
	public void  concution() {  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx=DriverManager.getConnection("jdbc:mysql://localhost/java_proj","root","0000");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}}
		 
	 public void table_load()
			    {
			    	try 
			    	{
				    pStatement = cnx.prepareStatement("SELECT * FROM article ");
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
	public Evaluation(String Th,int cin ) {
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
		setBounds(178, 0, 762, 525);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y =e.getYOnScreen();
				Evaluation.this.setLocation(x-xx,y-yy);
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
		contentPane.setBorder(new LineBorder(new Color(240, 128, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ajouter");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(240, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a= sco.getItemAt(sco.getSelectedIndex());
				String b=ID.getText();
				int h = Integer.parseInt(b);
				if(b.equals("")) {
					JOptionPane.showMessageDialog(null,"!!! pas d'ID");
					
				}else {
					try {
						pr=cnx.prepareStatement("SELECT * FROM evaluer WHERE art_ID=? and ID_ch= ? " );
						pr.setInt(1, h);
						pr.setInt(2, cin);
						vs=pr.executeQuery();
						if(vs.next()) {
							JOptionPane.showMessageDialog(null, "Vous avez évalué");
						}else {
							pr=cnx.prepareStatement("SELECT * FROM article WHERE ID_art="+h);
							vs=pr.executeQuery();
							vs.next();
							j = Integer.parseInt(vs.getString("cont"));
							k=Float.parseFloat(vs.getString("Score"));
							Float kl=k*j;
							String hh=vs.getString("TH_nom");
							vv=vs.getString("Titre");
							pStatement=cnx.prepareStatement("UPDATE article SET cont=? , Score=?  WHERE ID_art="+h);
							if(Th.equals(hh)) {
							pStatement.setInt(1, j+1);
							pStatement.setFloat(2,(Float)(kl+a)/(j+1));
															
							}else{
							pStatement.setInt(1, j+1);
							pStatement.setFloat(2,(float) (k*j+(a*0.5)/(j+0.5)));	
							}
							pStatement.execute();
							pStatement= cnx.prepareStatement("INSERT INTO evaluer VALUES("+cin+","+b+","+a+")");
							pStatement.execute();
							table_load();
							pr=cnx.prepareStatement("SELECT * FROM article WHERE ID_art="+h);
							vs=pr.executeQuery();
							vs.next();
							String yuString=vs.getString("Titre");
							j = Integer.parseInt(vs.getString("cont"));
							Float u = vs.getFloat("Score");
							if((j>=3)) {
								if((u<1.5)) {
									JOptionPane.showMessageDialog(null, "L'article est  pour le moment refusé");
								}else {
									pr=cnx.prepareStatement("select * from apr where ID_art="+h);
									rs=pr.executeQuery();
									if(rs.next()) {
										JOptionPane.showMessageDialog(null, "L'article est déjà ajouté dans sessios "+rs.getInt("id_session"));
									}else {
										pr=cnx.prepareStatement("select * from session where théme=?");
										pr.setString(1, hh);
										rs=pr.executeQuery();
										boolean bool=false;
										while(rs.next()) {
											int y = rs.getInt("id_session");
											String dateString = rs.getString("jour_Date");
											pr=cnx.prepareStatement("select  count(ID_art) from apr where id_session="+y);
											rs=pr.executeQuery();
											rs.next();
											if(rs.getInt(1)<3) {
												pr=cnx.prepareStatement("insert into apr values (?,?,?,?,?)");
												pr.setInt(1, Integer.parseInt(b));
												pr.setInt(2, y);
												pr.setFloat(3, u);
												pr.setString(4, yuString);
												pr.setString(5, dateString);
												pr.execute();
												JOptionPane.showMessageDialog(null, "l'article est  ajouté dans la  session "+y+" dans la  date "+dateString);	
												bool=true;
											}
										}
										if(!bool) {
											DateFormat format = new SimpleDateFormat("yyyy/MM/dd ");
											Calendar calendar = Calendar.getInstance();
											String datgString= format.format(calendar.getTime());
											pr=cnx.prepareStatement("select count(id_session) from session where jour_Date=?");
											pr.setString(1, datgString);
											rs=pr.executeQuery();
											if(rs.next()) {
												int j =rs.getInt(1);
												if(j<4) {
													pr=cnx.prepareStatement("insert into session (jour_Date,théme) values (?,?)");
													pr.setString(1, datgString);
													pr.setString(2, hh);
													pr.execute();
													pr=cnx.prepareStatement("select id_session from java_proj.session order by id_session desc");
													rs=pr.executeQuery();
													rs.next();
													int lm = rs.getInt(1);
													
													pr=cnx.prepareStatement("insert into apr values (?,?,?,?,?)");
													pr.setInt(1, Integer.parseInt(b));
													pr.setInt(2,lm);
													pr.setFloat(3, u);
													pr.setString(4, yuString);
													pr.setString(5, datgString);
													pr.execute();
													JOptionPane.showMessageDialog(null, "article ajouté dans la nouvelle session "+lm+" dans la date "+datgString);
												}else {
													calendar.add(Calendar.DAY_OF_MONTH, 1);
													datgString= format.format(calendar.getTime());
													pr=cnx.prepareStatement("insert into session (jour_Date,théme) values (?,?)");
													pr.setString(1, datgString);
													pr.setString(2, hh);
													pr.execute();
													pr=cnx.prepareStatement("select id_session from java_proj.session order by id_session desc");
													rs=pr.executeQuery();
													rs.next();
													int lm = rs.getInt(1);
													pr=cnx.prepareStatement("insert into apr values (?,?,?,?,?)");
													pr.setInt(1, Integer.parseInt(b));
													pr.setInt(2,lm);
													pr.setFloat(3, u);
													pr.setString(4, yuString);
													pr.setString(5, datgString);
													pr.execute();
													JOptionPane.showMessageDialog(null, "article ajouté dans la  nouvelle session "+lm+" dans la date "+datgString);
													
												}
											}else {
												pr=cnx.prepareStatement("insert into session (jour_Date,théme) values (?,?)");
												pr.setString(1, datgString);
												pr.setString(2, hh);
												pr.execute();
												pr=cnx.prepareStatement("select id_session from java_proj.session order by id_session desc");
												rs=pr.executeQuery();
												rs.next();
												int lm = rs.getInt(1);
												pr=cnx.prepareStatement("insert into apr values (?,?,?,?,?)");
												pr.setInt(1, Integer.parseInt(b));
												pr.setInt(2,lm);
												pr.setFloat(3, u);
												pr.setString(4, yuString);
												pr.setString(5, datgString);
												pr.execute();
												JOptionPane.showMessageDialog(null, "article ajouté dans la  nouvelle session "+lm+" dans la date "+datgString);
											}
										}
									}
								}
								
							
								
							}
							
						
						}} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						
						}
					
					}
				
				}
			});
		
		btnOverirePdf = new JButton("Ouvrir PDF");
		btnOverirePdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID.equals("")) {
					JOptionPane.showMessageDialog(null, "Choisir un article");
				}else {
					try {
						pr=cnx.prepareStatement("select pdf from article where ID_art="+Integer.parseInt(ID.getText()));
						rs=pr.executeQuery();
						rs.next();
						try {
							File file=new File("test.pdf");
							outputStream=new FileOutputStream(file);
							InputStream f=rs.getBinaryStream(1);
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
					
				}
			}
		});
		btnOverirePdf.setForeground(new Color(0, 0, 0));
		btnOverirePdf.setFont(new Font("Arial", Font.BOLD, 15));
		btnOverirePdf.setBackground(new Color(240, 128, 128));
		btnOverirePdf.setBounds(33, 448, 186, 33);
		contentPane.add(btnOverirePdf);
		btnNewButton.setBounds(72, 345, 105, 33);
		contentPane.add(btnNewButton);
		
		JButton ttt = new JButton("afficher");
		ttt.setForeground(new Color(0, 0, 0));
		ttt.setFont(new Font("Arial", Font.BOLD, 15));
		ttt.setBackground(new Color(240, 128, 128));
		ttt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load();
			}
		});
		
		lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Evaluation.class.getResource("/image/eva1.png")));
		lblNewLabel_3.setBounds(442, 11, 261, 91);
		contentPane.add(lblNewLabel_3);
		lblNewLabel.setForeground(new Color(240, 128, 128));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel.setBounds(727, 11, 25, 28);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(new Color(240, 128, 128));
		lblNewLabel_1.setFont(new Font("Arial", Font.ITALIC, 23));
		lblNewLabel_1.setBounds(33, 191, 84, 24);
		contentPane.add(lblNewLabel_1);
		ttt.setBounds(33, 405, 186, 33);
		contentPane.add(ttt);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(258, 113, 475, 401);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				int i=table.getSelectedRow();
				int t= Integer.parseInt(model.getValueAt(i, 0).toString());
				ID.setText(t+"");
			}
		});
		scrollPane.setViewportView(table);
		
		ID = new JTextField();
		ID.setBounds(33, 228, 186, 28);
		contentPane.add(ID);
		ID.setColumns(10);
		
		sco = new JComboBox<Integer>();
		sco.setBackground(new Color(255, 250, 240));
		sco.setBounds(33, 310, 186, 24);
		for(int i=0 ;i<=3 ;i++) {
			sco.addItem(i);
		}
		contentPane.add(sco);
		
		lblNewLabel_2 = new JLabel("Score");
		lblNewLabel_2.setForeground(new Color(240, 128, 128));
		lblNewLabel_2.setFont(new Font("Arial", Font.ITALIC, 23));
		lblNewLabel_2.setBounds(33, 267, 84, 28);
		contentPane.add(lblNewLabel_2);
		
		bc = new JLabel("");
		bc.setIcon(new ImageIcon(Evaluation.class.getResource("/image/bc555.jpg")));
		bc.setBounds(10, 11, 448, 492);
		contentPane.add(bc);
		
	
	}
}

