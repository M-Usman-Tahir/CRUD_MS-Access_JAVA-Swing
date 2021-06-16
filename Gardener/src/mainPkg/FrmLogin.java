package mainPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
//	private JTextField txtPswrd;
	private JPasswordField txtPswrd;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Login Page");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(144, 23, 152, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email/Phone Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(64, 89, 128, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(64, 130, 83, 17);
		contentPane.add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(202, 86, 148, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPswrd = new JPasswordField();
		txtPswrd.setToolTipText("");
		txtPswrd.setEchoChar('*');
		txtPswrd.setBounds(202, 129, 148, 20);
		contentPane.add(txtPswrd);
		txtPswrd.setColumns(10);
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtEmail.getText().equals("")||new String((txtPswrd.getPassword())).equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Kindly input both the credential fields!", "Invalid Credentials", JOptionPane.ERROR_MESSAGE);
				}else {
					if (DataBase.getPswrd(txtEmail.getText()).equals(new String((txtPswrd.getPassword())))) {	
						FrmAdminPage frame = new FrmAdminPage();
						frame.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(contentPane, "Your Credentials are incorrect! Try Again!", "Invalid Credentials", JOptionPane.ERROR_MESSAGE);
						txtEmail.setText("");
						txtEmail.requestFocus();
						txtPswrd.setText("");
					}
				}
			}
		});
		btnLogin.setBounds(172, 196, 89, 23);
		contentPane.add(btnLogin);
	}
}
