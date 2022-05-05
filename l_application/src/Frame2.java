
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

public class Frame2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel tx4, programmeT,inscription2,inscripition1;
	private JPanel panel;
	private int xx,yy;
	public Frame2() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 493);
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
				int y=e.getYOnScreen();
				Frame2.this.setLocation(x-xx,y-yy);
			}
		});
		contentPane.setBackground(new Color(0x353232));
		contentPane.setBorder(new LineBorder(new Color(0xEAE7E7), 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel rech = new JLabel("");
		rech.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.setBorder(new LineBorder(new Color(0x5DADE2 ), 3));
				panel.setBorder(new LineBorder(new Color(0x5DADE2), 2));
				contentPane.setBackground(new Color(0x5DADE2));
				tx4.setForeground(new Color(0,0,0));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				contentPane.setBorder(new LineBorder(new Color(0xEAE7E7 ), 1));
				panel.setBorder(new LineBorder(new Color(0xEAE7E7 ), 1));
				contentPane.setBackground(new Color(0x353232));
				tx4.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Frame3 jFrame = new Frame3();
				jFrame.setVisible(true);
				dispose();
			}
		});
		
		JLabel inscripition = new JLabel("");
		inscripition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.setBorder(new LineBorder(new Color(0xF1C40F), 3));
				panel.setBorder(new LineBorder(new Color(0xF1C40F), 2));
				contentPane.setBackground(new Color(0xF1C40F));
				inscripition1.setForeground(new Color(0,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				contentPane.setBorder(new LineBorder(new Color(0xEAE7E7 ), 1));
				panel.setBorder(new LineBorder(new Color(0xEAE7E7 ), 1));
				contentPane.setBackground(new Color(0x353232));
				inscripition1.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterForm hForm=new RegisterForm();
				hForm.setVisible(true);
				dispose();
			}
		});
		
		inscription2 = new JLabel("Inscription aux Tutoriaux");
		inscription2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		inscription2.setBounds(557, 435, 376, 46);
		inscription2.setForeground(new Color(255,255,255));
		contentPane.add(inscription2);
		
		JLabel le_programme = new JLabel("");
		le_programme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.setBorder(new LineBorder(new Color(0x2ECC71), 3));
				panel.setBorder(new LineBorder(new Color(0x2ECC71), 2));
				contentPane.setBackground(new Color(0x2ECC71));
				programmeT.setForeground(new Color(0,0,0));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				contentPane.setBorder(new LineBorder(new Color(0xEAE7E7 ), 1));
				panel.setBorder(new LineBorder(new Color(0xEAE7E7 ), 1));
				contentPane.setBackground(new Color(0x353232));
				programmeT.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Home h;
				try {
					h = new Home();
					h.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel prog = new JLabel("");
		prog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.setBorder(new LineBorder(new Color(0xEC7063), 3));
				panel.setBorder(new LineBorder(new Color(0xEC7063), 2));
				contentPane.setBackground(new Color(0xEC7063));
				inscription2.setForeground(new Color(0,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				contentPane.setBorder(new LineBorder(new Color(0xEAE7E7 ), 1));
				panel.setBorder(new LineBorder(new Color(0xEAE7E7 ), 1));
				contentPane.setBackground(new Color(0x353232));
				inscription2.setForeground(new Color(255,255,255));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Inscrire_T jInscrire_T = new Inscrire_T();
				jInscrire_T.setVisible(true);
				dispose();
			}
		});
		prog.setIcon(new ImageIcon(Frame2.class.getResource("/image/tr.png")));
		prog.setBounds(679, 289, 133, 135);
		contentPane.add(prog);
	    programmeT = new JLabel("Le programme");
		programmeT.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		programmeT.setBounds(223, 246, 232, 31);
		programmeT.setForeground(new Color(255,255,255));
		contentPane.add(programmeT);
		le_programme.setIcon(new ImageIcon(Frame2.class.getResource("/image/le programme.png")));
		le_programme.setBounds(273, 103, 133, 136);
		contentPane.add(le_programme);
		inscripition.setIcon(new ImageIcon(Frame2.class.getResource("/image/inscription.png")));
		inscripition.setBounds(273, 289, 133, 136);
		contentPane.add(inscripition);
		
		inscripition1 = new JLabel("Inscription des participants");
		inscripition1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		inscripition1.setForeground(new Color(255,255,255));
		inscripition1.setBounds(133, 441, 412, 35);
		contentPane.add(inscripition1);
		rech.setIcon(new ImageIcon(Frame2.class.getResource("/image/rechercher.png")));
		rech.setBounds(679, 94, 133, 145);
		contentPane.add(rech);
		tx4 = new JLabel("Espace des chercheurs ");
		tx4.setForeground(new Color(255,255,255));
		tx4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		tx4.setBounds(567, 248, 356, 27);
		contentPane.add(tx4);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255,255,255 ), 1));
		panel.setBounds(0, 0, 1085, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel la_conférence = new JLabel("La conf\u00E9rence");
		la_conférence.setBounds(357, -21, 353, 114);
		la_conférence.setForeground(new Color(255, 255, 255));
		la_conférence.setFont(new Font("Arial", Font.BOLD, 50));
		panel.add(la_conférence);
		
		JLabel x = new JLabel("");
		x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		x.setBounds(1053, 0, 32, 30);
		x.setIcon(new ImageIcon(Frame2.class.getResource("/image/x.png")));
		x.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
		panel.setBackground(new Color(0x494646));
		panel.add(x);
	}
}
