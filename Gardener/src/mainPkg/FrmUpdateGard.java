package mainPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class FrmUpdateGard extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtPhone;
	private JTextField txtSalary;

	public FrmUpdateGard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Gardener");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(195, 32, 214, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Card No.");
		lblNewLabel_1.setBounds(40, 88, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New Phone No.");
		lblNewLabel_2.setBounds(40, 125, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New Salary");
		lblNewLabel_3.setBounds(40, 163, 95, 14);
		contentPane.add(lblNewLabel_3);
		
		txtID = new JTextField();
		txtID.setBounds(145, 85, 155, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(145, 122, 155, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtSalary = new JTextField();
		txtSalary.setBounds(145, 160, 155, 20);
		contentPane.add(txtSalary);
		txtSalary.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().equals("")||txtPhone.getText().equals("")||txtSalary.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Please fill all the fields!!!", "Empty Fields", JOptionPane.ERROR_MESSAGE);
				}else {
					String sql = "UPDATE `Gardener` SET `Phone Number` = '"+ txtPhone.getText() +"', `Salary` = '"+ txtSalary.getText() +"' WHERE `ID Card Number` = '"+txtID.getText()+"'";
					
					try {
						DataBase.st.executeUpdate(sql);
						JOptionPane.showMessageDialog(contentPane, "Gardener is Updated!!!", "Successful", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					txtID.setText("");
					txtID.requestFocus();
					txtPhone.setText("");
					txtSalary.setText("");
				}
			}
		});
		btnNewButton.setBounds(170, 202, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAdminPage frame = new FrmAdminPage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(22, 227, 69, 23);
		contentPane.add(btnNewButton_1);
	}

}
