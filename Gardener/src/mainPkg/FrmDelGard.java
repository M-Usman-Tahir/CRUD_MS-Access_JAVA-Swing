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
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FrmDelGard extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField txtPswrd;

	public FrmDelGard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Gardener");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(199, 36, 204, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Card No.");
		lblNewLabel_1.setBounds(50, 105, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Your Password");
		lblNewLabel_2.setBounds(50, 142, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setBounds(153, 98, 162, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtPswrd = new JPasswordField();
		txtPswrd.setEchoChar('*');
		txtPswrd.setBounds(153, 139, 162, 20);
		contentPane.add(txtPswrd);
		txtPswrd.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().equals("")||new String((txtPswrd.getPassword())).equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Please fill all the fields!!!", "Empty Fields", JOptionPane.ERROR_MESSAGE);
				}else if(new String((txtPswrd.getPassword())).equals(DataBase.getPswrd())){
					
					String sql = "DELETE FROM `Gardener` WHERE `ID Card Number` = '"+ txtID.getText() +"'";
					
					try {
						DataBase.st.executeUpdate(sql);
						JOptionPane.showMessageDialog(contentPane, "Gardener is deleted!!!", "Successful", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Password is incorrect", "Invalid Credentials", JOptionPane.ERROR_MESSAGE);	
				}
				txtID.setText("");
				txtID.requestFocus();
				txtPswrd.setText("");
			}
		});
		btnNewButton.setBounds(196, 188, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAdminPage frame = new FrmAdminPage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(35, 211, 67, 23);
		contentPane.add(btnNewButton_1);
	}

}
