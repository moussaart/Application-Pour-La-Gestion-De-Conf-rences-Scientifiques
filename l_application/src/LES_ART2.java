

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class LES_ART2 extends JFrame {

	private JPanel contentPane;
	private Connection cnxConnection;
	private PreparedStatement  pStatement;
	private ResultSet rs;
	private JComboBox<String> th1,or;
	private static final long serialVersionUID = 1L;
	private JTable table;
	private int xx,yy;
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
    		
	    pStatement = cnxConnection.prepareStatement("SELECT ID_art, TH_nom,Titre, Score FROM article WHERE TH_nom='"+a+"' and Score>=1.5 ORDER BY Score "+hString);
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
	public LES_ART2() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 517);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				LES_ART2.this.setLocation(x-xx,y-yy);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				yy=e.getY();
			}
		});
		contentPane.setBorder(new LineBorder(new Color(255, 99, 71), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setForeground(new Color(255, 99, 71));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setBounds(729, 0, 35, 47);
		contentPane.add(lblNewLabel);
		LES_ART jArt = new LES_ART();
		jArt.setBounds(2, 2, 762, 513);
		contentPane.add(jArt);
	}
}
