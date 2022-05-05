

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

public class Paye extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tx1;
	private JTextField tx2;
	private JTextField tx3;
	private int xx,yy;

	public Paye(int i ) {
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
		setBounds(100, 100, 423, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(255, 69, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 250, 154), 2));
		panel.setBounds(0, 0, 423, 289);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton ok = new JButton("payer");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c,v,bString;
				c=tx1.getText();
				v=tx2.getText();
				bString=tx3.getText();
				if((c.equals("")||(v.equals("")||(bString.equals(""))))) {
					JOptionPane.showMessageDialog(null, "Il existe un colonne vide ");
				}else {
					if(i==1) {
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Inscription terminée");
						try {
							Home jHome=new Home();
							jHome.setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}
				}
				
				
			}
		});
		ok.setFont(new Font("Arial", Font.BOLD, 15));
		ok.setBackground(Color.RED);
		ok.setForeground(Color.WHITE);
		ok.setBounds(225, 228, 89, 35);
		panel.add(ok);
		
		JButton btnNewButton_1 = new JButton("annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame2 jFrame2 = new Frame2();
				jFrame2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(133, 228, 89, 35);
		panel.add(btnNewButton_1);
		
		tx1 = new JTextField();
		tx1.setBounds(155, 69, 257, 28);
		panel.add(tx1);
		tx1.setColumns(10);
		
		tx2 = new JTextField();
		tx2.setColumns(10);
		tx2.setBounds(155, 122, 257, 28);
		panel.add(tx2);
		
		tx3 = new JTextField();
		tx3.setColumns(10);
		tx3.setBounds(155, 175, 257, 28);
		panel.add(tx3);
		
		JLabel lblNewLabel = new JLabel("Nom ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 76, 135, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de la carte");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(10, 129, 134, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cryptogramme");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(10, 182, 120, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Paiement");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(149, 25, 125, 19);
		panel.add(lblNewLabel_3);
		
		JLabel x = new JLabel("x");
		x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Frame3 jFrame3 = new Frame3();
				jFrame3.setVisible(true);
				dispose();
			}
		});
		x.setForeground(Color.RED);
		x.setFont(new Font("Arial", Font.BOLD, 33));
		x.setBounds(388, 5, 25, 23);
		panel.add(x);
		
		JLabel bc = new JLabel("");
		bc.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				Paye.this.setLocation(x-xx,y-yy);
			}
		});
		bc.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				yy=e.getY();
			}
		});
		bc.setIcon(new ImageIcon(Paye.class.getResource("/image/payer.jpeg")));
		bc.setBounds(0, 0, 423, 289);
		panel.add(bc);
	
	}
}
