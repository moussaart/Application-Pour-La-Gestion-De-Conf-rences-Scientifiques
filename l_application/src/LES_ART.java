import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.desktop.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LES_ART extends JPanel {
	private Connection cnxConnection;
	private PreparedStatement  pStatement,pp;
	private ResultSet rs;
	private int t;
	private FileOutputStream outputStream;
	private FileInputStream fileInputStream;
	private byte[] buffer;
	private File file2=new File("r.pdf");
	private JLabel art,th,red,tit;
	private String[] themeStrings={"socitétal",
						"Economie","Intrastrutures","Neurosiences","Ecoles","Agroalimentaire",
						"Electronique", "Innovation","Numeérique","HighTech","Batiment","Enivronnement",
						"Matériaux","Robotique", "Energie","Chimie","Espace","Mecanique","Santé","Usine du futur",
						"Climenat","Industrie","Nature","Transport"};

	private JComboBox<String> th1,or;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	public void  concution() {  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnxConnection=DriverManager.getConnection("jdbc:mysql://localhost/java_proj","root","0000");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}}
	public void table_load()
    {
    	try 
    	{
    		String a,b;
    		a= th1.getItemAt(th1.getSelectedIndex());
    		b=(String) or.getItemAt(or.getSelectedIndex());
    		String hString;
    		if(b.equals("dec")) {
    			hString="ASC";
    		}else {
				hString= "DESC";
			}
    		
	    pStatement = cnxConnection.prepareStatement("SELECT ID_art as ID, TH_nom as théme,Titre, Score FROM article WHERE TH_nom='"+a+"' and Score>=1.5 and cont>=3 ORDER BY Score "+hString);
	    rs = pStatement.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));
	    	
	    
	} 
    	catch (SQLException e) 
    	 {
    		JOptionPane.showMessageDialog(null, e.getMessage());
	  } 
    }

	/**
	 * Create the panel.
	 */
	public LES_ART() {
		concution();
		setBorder(new LineBorder(new Color(0, 250, 154), 2));
		setBackground(Color.WHITE);
		setBounds(178, 0, 762, 525);
		setLayout(null);
		
		JButton btnOverirePdf = new JButton("Ouvrir PDF");
		btnOverirePdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(art.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "choisir un article ");
					
				}else {
					try {
						pp=cnxConnection.prepareStatement("select pdf from article where ID_art="+t);
						rs=pp.executeQuery();
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
		btnOverirePdf.setFont(new Font("Arial", Font.BOLD, 15));
		btnOverirePdf.setBackground(new Color(255, 99, 71));
		btnOverirePdf.setBounds(90, 476, 150, 38);
		add(btnOverirePdf);
		
		JLabel titre = new JLabel("Les articles");
		titre.setForeground(new Color(255, 99, 71));
		titre.setBackground(new Color(255, 99, 71));
		titre.setFont(new Font("Times New Roman", Font.BOLD, 46));
		titre.setBounds(265, 11, 230, 42);
		add(titre);
		
		th1 = new JComboBox<String>();
		th1.setBackground(Color.WHITE);
		th1.setFont(new Font("Arial", Font.BOLD, 15));
		th1.setBounds(175, 102, 132, 24);
		for(String i:themeStrings) {
			th1.addItem(i);
		}
		add(th1);
		
		JLabel lblNewLabel = new JLabel("Pour choisir un th\u00E9me ");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 108, 176, 14);
		add(lblNewLabel);
		
		or = new JComboBox<String>();
		or.addItem("cor");
		or.addItem("décor");
		or.setBackground(Color.WHITE);
		or.setFont(new Font("Arial", Font.BOLD, 15));
		or.setBounds(175, 148, 132, 24);
		add(or);
		
		JLabel lblPourTrier = new JLabel("Pour trier ");
		lblPourTrier.setForeground(new Color(0, 0, 139));
		lblPourTrier.setFont(new Font("Arial", Font.BOLD, 15));
		lblPourTrier.setBounds(10, 152, 176, 14);
		add(lblPourTrier);
		
		JLabel lblInformationSurLarticle = new JLabel("Informations sur l'article ");
		lblInformationSurLarticle.setForeground(new Color(0, 0, 139));
		lblInformationSurLarticle.setFont(new Font("Arial", Font.BOLD, 20));
		lblInformationSurLarticle.setBounds(54, 194, 241, 14);
		add(lblInformationSurLarticle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(255, 99, 71), 2));
		scrollPane.setBounds(329, 102, 423, 396);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int i=table.getSelectedRow();
				String uString = model.getValueAt(i, 0).toString();
				try {
					pStatement = cnxConnection.prepareStatement("SELECT * FROM article WHERE ID_art="+uString);
					pp = cnxConnection.prepareStatement("SELECT * FROM rediger WHERE art_ID="+uString);
					  rs = pStatement.executeQuery();
					  rs.next();
					  String tyString = rs.getString("Titre");
					  t=rs.getInt("ID_art");
					  art.setText("1-Article : "+rs.getString("ID_art"));
					  tit.setText("2-Titre : "+rs.getString("Titre"));
					  th.setText("3-Théme : "+rs.getString("TH_nom"));
					  pStatement= cnxConnection.prepareStatement("select * from rediger where art_ID="+Integer.parseInt(uString));
					  rs=pStatement.executeQuery();
					  String jString="";
					  while (rs.next()) {
						  jString=jString+rs.getString("nom")+",";
					}
					  red.setText("4-Rédigé par : "+jString);  
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}	
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 99, 71), 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 219, 310, 251);
		add(panel);
		panel.setLayout(null);
		
		art = new JLabel("");
		art.setForeground(new Color(255, 99, 71));
		art.setFont(new Font("Arial", Font.BOLD, 14));
		art.setBounds(10, 27, 290, 29);
		panel.add(art);
		
		tit = new JLabel("");
		tit.setForeground(new Color(255, 99, 71));
		tit.setFont(new Font("Arial", Font.BOLD, 14));
		tit.setBounds(10, 83, 290, 29);
		panel.add(tit);
		
		th = new JLabel("");
		th.setForeground(new Color(255, 99, 71));
		th.setFont(new Font("Arial", Font.BOLD, 14));
		th.setBounds(10, 139, 290, 29);
		panel.add(th);
		
		red = new JLabel("");
		red.setForeground(new Color(255, 99, 71));
		red.setFont(new Font("Arial", Font.BOLD, 9));
		red.setBounds(10, 195, 290, 29);
		panel.add(red);
		
		JButton ok = new JButton("Afficher les articles");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load();
			}
		});
		ok.setFont(new Font("Arial", Font.BOLD, 15));
		ok.setBackground(new Color(255, 99, 71));
		ok.setBounds(446, 55, 188, 36);
		add(ok);
		
		JLabel bc = new JLabel("");
		bc.setIcon(new ImageIcon(LES_ART.class.getResource("/image/bc10.png")));
		bc.setBounds(0, 0, 762, 525);
		add(bc);
		table_load();

	}
}
