package Base;

import javax.swing.JOptionPane; // Mesaj kutusu için
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    // Sınıf Alanları (Tüm metodlarda erişilebilir olması için)
    private JTextField txtFieldKullaniciAdi; 
    private JTextField txtFieldSifre;
    private JButton btnGiris;
    private JLabel lblNewLabel_2;

    public Login() {
        setTitle("Giriş Ekranı");
        // Ana pencereyi kapatmadığımız için DISPOSE kullanıyoruz
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // ********** 1. BİLEŞENLERİ OLUŞTURMA VE EKLEME **********

        btnGiris = new JButton("Giriş Yap");
        btnGiris.setBounds(157, 165, 120, 23);
        contentPane.add(btnGiris);
        
        txtFieldKullaniciAdi = new JTextField();
        txtFieldKullaniciAdi.setBounds(157, 54, 120, 20);
        contentPane.add(txtFieldKullaniciAdi);
        txtFieldKullaniciAdi.setColumns(10);
        
        txtFieldSifre = new JTextField();
        txtFieldSifre.setBounds(157, 111, 120, 20);
        contentPane.add(txtFieldSifre);
        txtFieldSifre.setColumns(10);
        
        // Etiketler (Label'lar)
        JLabel lblNewLabel = new JLabel("Kullanıcı Adı:");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(57, 57, 89, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Şifre:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(57, 114, 89, 14);
        contentPane.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(0, 0, 434, 261);
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Masaüstü\\HunterGame\\Jungle.jpg"));
        contentPane.add(lblNewLabel_2);

        // ********** 2. GİRİŞ BUTONU LISTENER'I (Giriş Mantığı) **********
        btnGiris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                // Kullanıcıdan girilen verileri al
                String enteredUsername = txtFieldKullaniciAdi.getText();
                String enteredPassword = txtFieldSifre.getText();
                
                boolean loginSuccess = false;

                // Kayıtlı Kullanıcı Listesini al (Register sınıfından)
                List<User> registeredUsers = Register.getUserList();
                
                // Listedeki her kullanıcıyı kontrol et
                for (User user : registeredUsers) {
                    // Kullanıcı adı ve şifre eşleşiyorsa
                    if (user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
                        loginSuccess = true;
                        break; // Eşleşme bulundu, döngüden çık
                    }
                }
                
                // Sonuca göre mesaj göster
                if (loginSuccess) {
                    JOptionPane.showMessageDialog(Login.this, "Giriş Başarılı! Hoş geldiniz.", "Başarı", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    // Başarılı giriş sonrası açılacak Ana Sayfa penceresi buraya gelebilir.
                    
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Kullanıcı adı veya şifre yanlış.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}