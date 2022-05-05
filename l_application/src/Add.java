

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.*;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField fil;
	private File file;
	private Connection cnx;
	private PreparedStatement pStatement;
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
	public Add(int cin ) {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Choisir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser=new JFileChooser( );
				int r=jFileChooser.showOpenDialog(null) ;
				if(r==JFileChooser.APPROVE_OPTION) {
					file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
					fil.setText(file.getAbsolutePath());	
				}
			}
		});
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton.setBounds(289, 78, 122, 37);
		contentPane.add(btnNewButton);
		
		fil = new JTextField();
		fil.setBounds(10, 78, 269, 37);
		contentPane.add(fil);
		fil.setColumns(100);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(file==null) {
					JOptionPane.showMessageDialog(null, "Choisir un fichier  ");
				}else {
					try {
						FileInputStream fileInputStream = new FileInputStream(file);
						pStatement=cnx.prepareStatement(" update article set pdf=? where ID_art="+cin);
						pStatement.setBinaryStream(1, fileInputStream);
						pStatement.executeUpdate();
						JOptionPane.showMessageDialog(null, "ok");
						dispose();
					} catch (FileNotFoundException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		ok.setFont(new Font("Times New Roman", Font.BOLD, 24));
		ok.setBackground(new Color(100, 149, 237));
		ok.setBounds(10, 167, 401, 37);
		contentPane.add(ok);
	}
}
