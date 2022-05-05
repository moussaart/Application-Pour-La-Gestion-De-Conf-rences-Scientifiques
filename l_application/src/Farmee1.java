
import java.awt.EventQueue;
import java.sql.*;
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

public class Farmee1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int xx,yy;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farmee1 frame = new Farmee1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Farmee1() {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(244, 164, 96), 12));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Gestion de  Conf\u00E9rence");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial", Font.BOLD, 75));
		title.setBackground(Color.WHITE);
		title.setBounds(40, 43, 852, 89);
		contentPane.add(title);
		
		JLabel suiv = new JLabel("Page Suivante");
		suiv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Frame2 jFrame2 = new Frame2();
				jFrame2.setVisible(true);
				dispose();
			}
		});
		suiv.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		suiv.setIcon(new ImageIcon(Farmee1.class.getResource("/image/sui.png")));
		suiv.setForeground(Color.WHITE);
		suiv.setBounds(736, 449, 176, 42);
		contentPane.add(suiv);
		
		JLabel sort = new JLabel("");
		sort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		sort.setIcon(new ImageIcon(Farmee1.class.getResource("/image/so.png")));
		sort.setBounds(890, 0, 32, 51);
		contentPane.add(sort);
		
		JLabel bc = new JLabel("");
		bc.setForeground(Color.WHITE);
		bc.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				yy=e.getY();
			}
		});
		bc.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y =e.getYOnScreen();
				Farmee1.this.setLocation(x-xx,y-yy);
			}
			
		});
		bc.setIcon(new ImageIcon(Farmee1.class.getResource("/image/bc1.jpg")));
		bc.setBounds(0, 0, 939, 502);
		contentPane.add(bc);
	}
}
