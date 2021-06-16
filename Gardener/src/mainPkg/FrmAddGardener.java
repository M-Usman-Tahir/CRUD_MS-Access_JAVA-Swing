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

public class FrmAddGardener extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtWorkingTime;
	private JTextField txtIDCard;
	private JTextField txtSalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddGardener frame = new FrmAddGardener();
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
	public FrmAddGardener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Gardener");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(230, 26, 276, 44);
		contentPane.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(165, 94, 170, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(165, 125, 170, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(165, 156, 170, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtWorkingTime = new JTextField();
		txtWorkingTime.setBounds(165, 187, 170, 20);
		contentPane.add(txtWorkingTime);
		txtWorkingTime.setColumns(10);
		
		txtIDCard = new JTextField();
		txtIDCard.setBounds(165, 218, 170, 20);
		contentPane.add(txtIDCard);
		txtIDCard.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(55, 97, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Working Time");
		lblNewLabel_2.setBounds(55, 190, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID Card No.");
		lblNewLabel_3.setBounds(55, 221, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(55, 159, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone No.");
		lblNewLabel_5.setBounds(55, 128, 100, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Salary");
		lblNewLabel_6.setBounds(271, 278, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		txtSalary = new JTextField();
		txtSalary.setBounds(331, 275, 111, 20);
		contentPane.add(txtSalary);
		txtSalary.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().equals("")||txtPhone.getText().equals("")||txtAddress.getText().equals("")||txtWorkingTime.getText().equals("")||txtIDCard.getText().equals("")||txtSalary.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Please fill all the fields!!!", "Empty Fields", JOptionPane.ERROR_MESSAGE);
				}else {
					
					String sql = "INSERT INTO `Gardener` (`Name`, `Phone Number`, `Address`, `Working Time`, `Salary`, `ID Card Number`) VALUES ('"+ txtName.getText() +"', '"+ txtPhone.getText() +"', '"+ txtAddress.getText() +"', '"+ txtWorkingTime.getText() +"', '"+ txtSalary.getText() +"', '"+ txtIDCard.getText()+"')";
					
					try {
						DataBase.st.executeUpdate(sql);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(contentPane, "Gardener is added!!!", "Successful", JOptionPane.INFORMATION_MESSAGE);
					txtName.setText("");
					txtName.requestFocus();
					txtPhone.setText("");
					txtAddress.setText("");
					txtWorkingTime.setText("");
					txtIDCard.setText("");
				}
			}
		});
		btnNewButton.setBounds(289, 329, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAdminPage frame = new FrmAdminPage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(42, 329, 73, 23);
		contentPane.add(btnNewButton_1);
	}
}
