package mainPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmSearchGard extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField txtPswrd;
	private JTable table;

	public FrmSearchGard() {
		Object Col[] = {"Name", "Phone Number", "Address", "Working Time", "ID Card Number", "Salary"};
		DefaultTableModel model = new DefaultTableModel(Col, 0);
		table  = new JTable(model);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Gardener");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 29, 729, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Card No.");
		lblNewLabel_1.setBounds(52, 97, 112, 14);
		contentPane.add(lblNewLabel_1);
		
		txtID = new JTextField();
		txtID.setBounds(139, 94, 161, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtPswrd = new JPasswordField();
		txtPswrd.setEchoChar('*');
		txtPswrd.setBounds(454, 94, 161, 20);
		contentPane.add(txtPswrd);
		txtPswrd.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			boolean found = false;
			public void actionPerformed(ActionEvent e) {
				if(found) {
					model.removeRow(0);
				}
				if(txtID.getText().equals("")||new String((txtPswrd.getPassword())).equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Please fill all the fields!!!", "Empty Fields", JOptionPane.ERROR_MESSAGE);
				}else if(new String((txtPswrd.getPassword())).equals(DataBase.getPswrd())){
					found = false;
					String sql = "SELECT * FROM `Gardener` WHERE `ID Card Number` = '"+txtID.getText()+"'";
					ResultSet rslt;
					Object row[] = new Object[6];
					try {
						rslt = DataBase.st.executeQuery(sql);
						while(rslt.next()) {
							found = true;
							row[0] = rslt.getString("Name");
							row[1] = rslt.getString("Phone Number");
							row[2] = rslt.getString("Address");
							row[3] = rslt.getString("Working Time");
							row[4] = rslt.getString("ID Card Number");
							row[5] = rslt.getDouble("Salary");
							model.addRow(row);
						}						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if(!found) {
						JOptionPane.showMessageDialog(contentPane, "Gardener is NOT found!!!", "Successful", JOptionPane.INFORMATION_MESSAGE);					
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "Password is incorrect", "Invalid Credentials", JOptionPane.ERROR_MESSAGE);	
				}
				txtID.setText("");
				txtID.requestFocus();
				txtPswrd.setText("");
			}
		});
		btnNewButton.setBounds(297, 138, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAdminPage frame = new FrmAdminPage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(22, 289, 67, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Your Password");
		lblNewLabel_2.setBounds(327, 97, 112, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 190, 702, 59);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
	}
}
