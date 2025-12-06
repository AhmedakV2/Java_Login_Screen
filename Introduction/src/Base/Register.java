package Base;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Color;



public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
	private static List<User> userList = new ArrayList<>();
	
    private JTextField txtFieldKullaniciAdi; 
    private JTextField txtFieldSifre;
    private JButton btnKayit;     
    private JLabel lblNewLabel_2;
    
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
	    setTitle("Kayıt");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 450, 300);
	    contentPane = new JLayeredPane();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    // ********** 1. BİLEŞENLERE DEĞER ATAMA (BAŞLATMA) **********
	    
	    // BUTON: btnNewButton yerine sınıf alanımız olan btnKayit'i kullanalım
	    btnKayit = new JButton("Kayıt"); 
	    btnKayit.setBounds(157, 165, 89, 23);
	    contentPane.add(btnKayit);
	    
	    // KULLANICI ADI TEXTFIELD: textField yerine sınıf alanımız olan txtFieldKullaniciAdi'yi kullanalım
	    txtFieldKullaniciAdi = new JTextField(); 
	    txtFieldKullaniciAdi.setBounds(157, 54, 89, 20);
	    contentPane.add(txtFieldKullaniciAdi);
	    txtFieldKullaniciAdi.setColumns(25);
	    
	    // ŞİFRE TEXTFIELD: textField_1 yerine sınıf alanımız olan txtFieldSifre'yi kullanalım
	    txtFieldSifre = new JTextField();
	    txtFieldSifre.setBounds(157, 111, 89, 20);
	    contentPane.add(txtFieldSifre);
	    txtFieldSifre.setColumns(10);
	    
	    // Etiketler (Label'lar)
	    JLabel lblNewLabel = new JLabel("Kullanıcı Adı");
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setBounds(157, 40, 89, 14);
	    contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Şifre");
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setBounds(157, 97, 89, 14);
	    contentPane.add(lblNewLabel_1);
	    
	    lblNewLabel_2 = new JLabel("New label");
	    lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Masaüstü\\HunterGame\\Jungle.jpg"));
	    lblNewLabel_2.setBounds(0, 0, 434, 261);
	    contentPane.add(lblNewLabel_2);
	    
	    
	    // ********** 2. LISTENER EKLEME (Butonlar Oluşturulduktan Sonra) **********
	    
	    // Hatanın çözüldüğü yer: btnKayit artık NULL değil!
	    btnKayit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            
	            // Veri okuma: Artık doğru alanlardan okuma yapıyoruz.
	            String username = txtFieldKullaniciAdi.getText(); 
	            String password = txtFieldSifre.getText();
	            
	            // 1. Basit Boş Alan Kontrolü
	            if (username.isEmpty() || password.isEmpty()) {
	                JOptionPane.showMessageDialog(Register.this, "Kullanıcı Adı ve Şifre boş bırakılamaz.", "Hata", JOptionPane.ERROR_MESSAGE);
	                return; 
	            }

	            // 2. Yeni User nesnesini oluştur ve listeye ekle
	            User newUser = new User(username, password);
	            userList.add(newUser); 
	            
	            // 3. Kullanıcıya Başarı Mesajı Göster
	            JOptionPane.showMessageDialog(Register.this, 
	                                          "Kayıt Başarılı! Hoş geldin, " + username, 
	                                          "Başarı", JOptionPane.INFORMATION_MESSAGE);
	            
	            
	            // 4. Konsola kontrol amaçlı bilgi yazdır (opsiyonel)
	            System.out.println("Yeni Kullanıcı Kaydedildi: " + username);
	            System.out.println("Mevcut Kullanıcı Sayısı: " + userList.size());
	            
	            // 5. Kayıt penceresini kapat
	            dispose();
	        }
	    });

	}

	
	public static List<User> getUserList() {
		return userList;
	}

	public static void setUserList(List<User> userList) {
		Register.userList = userList;
	}

	public JButton getBtnKayit() {
		return btnKayit;
	}

	public void setBtnKayit(JButton btnKayit) {
		this.btnKayit = btnKayit;
	}

	public JTextField getTxtFieldSifre() {
		return txtFieldSifre;
	}

	public void setTxtFieldSifre(JTextField txtFieldSifre) {
		this.txtFieldSifre = txtFieldSifre;
	}

	public JTextField getTxtFieldKullaniciAdi() {
		return txtFieldKullaniciAdi;
	}

	public void setTxtFieldKullaniciAdi(JTextField txtFieldKullaniciAdi) {
		this.txtFieldKullaniciAdi = txtFieldKullaniciAdi;
	}

}
