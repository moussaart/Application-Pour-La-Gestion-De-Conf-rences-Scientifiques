
import java.sql.* ;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;


public class Home extends JFrame {
	private static final long serialVersionUID = 1L ;
	private ResultSet rSet;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Connection cnx;
	private PreparedStatement pStatement;
	
	int xx,yy;
	/**
	 * Create the frame.
	 */
	public Home() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_proj","root","0000");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		setUndecorated(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				Home.this.setLocation(x-xx,y-yy);
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
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 346, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/image/participant (1).png")));

		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hamdi\\Pictures\\icon-600x500-man-with-dots_1_350x270.png"));
		lblNewLabel_1.setBounds(36, 15, 300, 262);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/image/mrc-ConvertImage.png")));
        //lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hamdi\\Pictures\\mrc.png"));
		lblNewLabel.setBounds(21, 288, 300, 106);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(395, 108, 283, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel(" CIN");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 20));
		lblUsername.setBounds(395, 42, 114, 24);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Mot de passe ");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblPassword.setBounds(395, 186, 200, 32);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(395, 260, 283, 36);
		contentPane.add(passwordField);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Frame2 j=new Frame2();
				j.setVisible(true);
				dispose();
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(30, 144, 255));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);
		
		JButton btnNewButton = new JButton("     S'inscrire      ");
		btnNewButton.setBackground(UIManager.getColor("Menu.selectionBackground"));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterForm hForm=new RegisterForm();
				hForm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setToolTipText("cliquez ici pour cr\u00E9er un nouveau compte");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(446, 407, 181, 27);
		contentPane.add(btnNewButton);
		
		JButton btnConnexion = new JButton("     connexion      ");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cin= textField.getText();
				String pass= passwordField.getText();
				if (cin.length()!=8) {
					JOptionPane.showMessageDialog(null,"Entrer un numero cin valide");
				}
				else {
					try {
						pStatement=cnx.prepareStatement("SELECT * FROM paricipant WHERE CIN_Part=? ");
						pStatement.setInt(1, Integer.parseInt(cin));
						rSet =pStatement.executeQuery();
						if(rSet.next()) {
							pStatement=cnx.prepareStatement("SELECT * FROM paricipant WHERE CIN_Part=? and mot_de_passe=? ");
							pStatement.setInt(1, Integer.parseInt(cin));
							pStatement.setString(2, pass);
							rSet =pStatement.executeQuery();
							if(rSet.next()) {
								Le_programme hLe_programme=new Le_programme(Integer.parseInt(cin));
								hLe_programme.setVisible(true);
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Mot de pass incorecte ");
							}
							
							
						}else {
							JOptionPane.showMessageDialog(null, "Ce numéro de cin n'existe pas ");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnConnexion.setToolTipText("");
		btnConnexion.setForeground(Color.BLUE);
		btnConnexion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConnexion.setBackground(UIManager.getColor("Menu.selectionBackground"));
		btnConnexion.setBounds(446, 338, 181, 27);
		contentPane.add(btnConnexion);
	}
}
