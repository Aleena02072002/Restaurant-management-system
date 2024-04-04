package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Restaurant.HomePage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class SignupPage extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textUpName;
	private JTextField textUpUsername;
	private JPasswordField textUpPass;
	private JPasswordField textUpRepass;
	private static SignupPage frame;
	
	public JButton btnSignup;
	public JLabel lblFullName;
	public JLabel lblUsername;
	public JLabel lblPassword;
	public JLabel lblRepass;
	public JButton btnCancel;
	public JLabel lblSuccess;
	public JCheckBox cbEmployee;
	public JButton btnBackHome;
	
	HomePage newHomePage = new HomePage();
	
//	add text file
	File file = new File("D:/Users.txt");
	File file1 = new File("D:/UsersInput.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SignupPage();
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
	public SignupPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFullName.setBounds(59, 44, 126, 27);
		contentPane.add(lblFullName);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(59, 81, 126, 27);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(59, 118, 126, 27);
		contentPane.add(lblPassword);
		
		lblRepass = new JLabel("Confirm Password");
		lblRepass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRepass.setBounds(59, 157, 126, 27);
		contentPane.add(lblRepass);
		
		textUpName = new JTextField();
		textUpName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textUpName.setBounds(195, 44, 149, 24);
		contentPane.add(textUpName);
		textUpName.setColumns(10);
		
		textUpUsername = new JTextField();
		textUpUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textUpUsername.setColumns(10);
		textUpUsername.setBounds(195, 86, 149, 24);
		contentPane.add(textUpUsername);
		
		textUpPass = new JPasswordField();
		textUpPass.setBounds(195, 120, 149, 25);
		contentPane.add(textUpPass);
		
		textUpRepass = new JPasswordField();
		textUpRepass.setBounds(195, 160, 149, 24);
		contentPane.add(textUpRepass);
		
		btnSignup = new JButton("Sign Up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textUpName.getText().length() <= 0 ) {
					JOptionPane.showMessageDialog(frame, "Name is empty!");
		        }
		        else if (textUpUsername.getText().length() <= 0 ) {
		        	JOptionPane.showMessageDialog(frame, "Username is empty!");
		        }
		        else if (textUpPass.getPassword().length < 6) {
		        	JOptionPane.showMessageDialog(frame, "Your Password is too short! (Require atleast 6 characters)");
		        }
				//JPasswordField.getPassword() will return char array[] which is not a STRING
  		        else if (!(Arrays.equals(textUpPass.getPassword(), textUpRepass.getPassword()))) {
		        	JOptionPane.showMessageDialog(frame, "Your Password doesn't match!");
		        } else {    
		        	handleSignUp();
					handleUsers();
		        }
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSignup.setBounds(107, 217, 92, 27);
		btnSignup.setFocusable(false);
		contentPane.add(btnSignup);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCancel();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.setBounds(268, 217, 92, 27);
		btnCancel.setFocusable(false);
		contentPane.add(btnCancel);
		
		lblSuccess = new JLabel("Sign Up Successfully!");
		lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuccess.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSuccess.setBounds(99, 68, 227, 61);
		lblSuccess.setVisible(false);
		contentPane.add(lblSuccess);
		
		btnBackHome = new JButton("Back to Home");
		btnBackHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBackHome();
			}
		});
		btnBackHome.setBounds(141, 133, 149, 33);
		btnBackHome.setVisible(false);
		btnBackHome.setFocusable(false);
		contentPane.add(btnBackHome);
		
		cbEmployee = new JCheckBox("Are you an employee?");
		cbEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbEmployee.setBounds(151, 190, 193, 21);
		cbEmployee.setVisible(true);
		contentPane.add(cbEmployee);
				
	}
	void handleSignUp(){
		lblFullName.setVisible(false);
		lblUsername.setVisible(false);
		lblPassword.setVisible(false);
		lblRepass.setVisible(false);
		textUpName.setVisible(false);
		textUpUsername.setVisible(false);
		btnSignup.setVisible(false);
		btnCancel.setVisible(false);
		textUpPass.setVisible(false);
		textUpRepass.setVisible(false);
		cbEmployee.setVisible(false);
		lblSuccess.setVisible(true);
		btnBackHome.setVisible(true);
	}
	void handleUsers() {
		String newName = textUpName.getText();
		String newUsername = textUpUsername.getText();
		char[] charPass = textUpPass.getPassword();
		String newPassword = new String(charPass);
		if(cbEmployee.isSelected()) {
			Employee.saveEmployeeInfo(newName, newUsername, newPassword);
		} else {
			Customer.saveCustomerInfo(newName, newUsername, newPassword);
		}
	}
	void setBackHome() {
		if(btnSignup.getText() == "Đăng ký") {
			newHomePage.btnLang.setText("VI");
			newHomePage.btnMenu.setText("Thực đơn");
			newHomePage.btnSpecialDeal.setText("Khuyến mãi");
			newHomePage.btnOrder.setText("Đặt món");
			newHomePage.btnCalculator.setText("Máy tính");
			newHomePage.btnSignIn.setText("Đăng nhập");
			newHomePage.btnSignUp.setText("Đăng ký");
			newHomePage.btnSignOut.setText("Đăng xuất");
			newHomePage.lblWelcome.setText("Chào mừng đến với Nhà Hàng");
		}
		newHomePage.setVisible(true);
		dispose();
	}
	void setCancel() {
		if(btnSignup.getText() == "Đăng ký") {
			newHomePage.btnLang.setText("VI");
			newHomePage.btnMenu.setText("Thực đơn");
			newHomePage.btnSpecialDeal.setText("Khuyến mãi");
			newHomePage.btnOrder.setText("Đặt món");
			newHomePage.btnCalculator.setText("Máy tính");
			newHomePage.btnSignIn.setText("Đăng nhập");
			newHomePage.btnSignUp.setText("Đăng ký");
			newHomePage.btnSignOut.setText("Đăng xuất");
			newHomePage.lblWelcome.setText("Chào mừng đến với Nhà Hàng");
		}
		newHomePage.setVisible(true);
		dispose();
	}
}
