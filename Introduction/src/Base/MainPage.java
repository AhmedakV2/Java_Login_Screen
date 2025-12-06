package Base;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setTitle("Ana Sayfa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnLogin = new JButton(" Giriş Yap");
		btnLogin.setBounds(158, 202, 89, 23);
		contentPane.add(btnLogin);
		
		
		
		JButton btnRegister = new JButton("Kayıt Ol");
		btnRegister.setBounds(372, 202, 89, 23);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Masaüstü\\HunterGame\\Jungle.jpg"));
		lblNewLabel.setBounds(0, 0, 693, 360);
		contentPane.add(lblNewLabel);
		
		
		
		btnLogin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       new Login().setVisible(true);
		    }
		});
		
		
		btnRegister.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 new Register().setVisible(true);
		    }
		});

	}
}
