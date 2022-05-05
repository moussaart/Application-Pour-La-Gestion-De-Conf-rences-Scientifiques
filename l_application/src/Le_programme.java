
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

public class Le_programme extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xx,yy;
	private JLabel a1,a2;
	/**
	 * Create the frame.
	 */
	public Le_programme(int cin1) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 504);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y =e.getYOnScreen();
				Le_programme.this.setLocation(x-xx,y-yy);
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
		contentPane.setBorder(new LineBorder(new Color(255, 182, 193), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Le programme \r\n");
		lblNewLabel.setForeground(new Color(255, 99, 71));
		lblNewLabel.setIcon(new ImageIcon(Le_programme.class.getResource("/image/conf.png")));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 50));
		lblNewLabel.setBounds(20, 16, 503, 74);
		contentPane.add(lblNewLabel);
		
		JLabel session = new JLabel("");
		session.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Le_session jLe_session=new Le_session();
				jLe_session.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				a1.setForeground(new Color(0xEC9517));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				a1.setForeground(Color.BLACK);
			}
		});
		session.setIcon(new ImageIcon(Le_programme.class.getResource("/image/session1.png")));
		session.setBounds(132, 106, 139, 138);
		contentPane.add(session);
		
		JLabel x = new JLabel("X");
		x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		x.setForeground(new Color(255, 182, 193));
		x.setFont(new Font("Arial", Font.BOLD, 37));
		x.setBounds(878, 16, 36, 44);
		contentPane.add(x);
		
		JLabel ret = new JLabel("");
		ret.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home jFrame2;
				try {
					jFrame2 = new Home();
					jFrame2.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		ret.setIcon(new ImageIcon(Le_programme.class.getResource("/image/fleche-gauche-esquissee.png")));
		ret.setBounds(867, 464, 47, 29);
		contentPane.add(ret);
		
		JLabel bc = new JLabel("");
		bc.setIcon(new ImageIcon(Le_programme.class.getResource("/image/bc456.jpg")));
		bc.setBounds(368, 11, 546, 482);
		contentPane.add(bc);
		
		a1 = new JLabel("Les sessions");
		a1.setFont(new Font("Arial", Font.BOLD, 30));
		a1.setForeground(Color.BLACK);
		a1.setBounds(117, 260, 190, 29);
		contentPane.add(a1);
		
		JLabel tutoriel = new JLabel("");
		tutoriel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Les_tutroiel hLes_tutroiel=new Les_tutroiel(cin1);
					hLes_tutroiel.setVisible(true);
					dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				a2.setForeground(new Color(0xEC9517));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				a2.setForeground(Color.BLACK);
			}
		});
		tutoriel.setIcon(new ImageIcon(Le_programme.class.getResource("/image/tr.png")));
		tutoriel.setBounds(138, 305, 126, 138);
		contentPane.add(tutoriel);
		
		a2 = new JLabel("Les tutoriels");
		a2.setForeground(Color.BLACK);
		a2.setFont(new Font("Arial", Font.BOLD, 30));
		a2.setBounds(117, 459, 190, 29);
		contentPane.add(a2);
	}
}
