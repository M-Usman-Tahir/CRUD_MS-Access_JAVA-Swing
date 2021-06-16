package mainPkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAdminPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdminPage frame = new FrmAdminPage();
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
	public FrmAdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHead = new JLabel("Admin Panel");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblHead.setBounds(10, 24, 414, 52);
		contentPane.add(lblHead);
		
		JButton btnNewButton = new JButton("Add Gardener");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAddGardener frame = new FrmAddGardener();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(51, 99, 148, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Gardener");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmDelGard frame = new FrmDelGard();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(222, 99, 161, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Gardener");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmUpdateGard frame = new FrmUpdateGard();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(51, 151, 148, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Search Gardener");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmSearchGard frame = new FrmSearchGard();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(222, 151, 161, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LogOut");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLogin frame = new FrmLogin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(167, 216, 89, 23);
		contentPane.add(btnNewButton_4);
	}

}
