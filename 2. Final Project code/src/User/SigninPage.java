package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Restaurant.HomePage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class SigninPage extends JFrame {
		
	/**
	 * 
	 */
	public JTextField textInUsername;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAccount;
	private static JPasswordField textInPass;
	private JCheckBox cbShowPass;
	private String key = null;
	private static SigninPage frame; 
	
	public JLabel lblUsername;
	public JLabel lblPassword;
	public JButton btnSignin;
	public JButton btnSignup;
	public JButton btnCancel;
	
	HomePage newHomePage = new HomePage();
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SigninPage();
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
	public SigninPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUsername.setBounds(62, 62, 89, 19);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPassword.setBounds(62, 117, 89, 13);
		contentPane.add(lblPassword);
		
		textInUsername = new JTextField();
		textInUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textInUsername.setBounds(161, 56, 132, 28);
		contentPane.add(textInUsername);
		textInUsername.setColumns(10);
		
		textInPass = new JPasswordField();
		textInPass.setBounds(161, 110, 132, 28);
		textInPass.setEchoChar('*');
		contentPane.add(textInPass);
		
		btnSignin = new JButton("Sign In");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSignin();
			}
		});
		btnSignin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSignin.setBounds(119, 158, 97, 21);
		btnSignin.setFocusable(false);
		contentPane.add(btnSignin);
		
		btnSignup = new JButton("Sign Up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				setSignup();
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSignup.setBounds(259, 202, 97, 21);
		btnSignup.setFocusable(false);
		contentPane.add(btnSignup);
		
		lblAccount = new JLabel("Don't have an account?");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAccount.setBounds(131, 207, 118, 13);
		contentPane.add(lblAccount);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCancel();
			}
		});
		
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(226, 158, 97, 21);
		btnCancel.setFocusable(false);
		contentPane.add(btnCancel);
		
		cbShowPass = new JCheckBox("");
		cbShowPass.setBounds(299, 114, 21, 21);
		cbShowPass.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					textInPass.setEchoChar((char) 0);
		        } else {
		        	textInPass.setEchoChar('*');
		        }
			}
		});
		contentPane.add(cbShowPass);
	}
	public void handleSignin() {
		try {
			if(verifyEmployee() == true) {
				key = "Employee";
			}
			else if(verifyCustomer() == true){
				key = "Customer";
			}else {
				key = "No account";
			}
		} catch (HeadlessException | IOException e1) {
			e1.printStackTrace();
		}
		if(key.equals("Employee")) {
			if(btnSignin.getText() == "Đăng nhập") {
				newHomePage.btnLang.setText("VI");
				newHomePage.btnMenu.setText("Thực đơn");
				newHomePage.btnSpecialDeal.setText("Khuyến mãi");
				newHomePage.btnOrder.setText("Đặt món");
				newHomePage.btnCalculator.setText("Máy tính");
				newHomePage.btnSignIn.setText("Đăng nhập");
				newHomePage.btnSignUp.setText("Đăng ký");
				newHomePage.btnSignOut.setText("Đăng xuất");
				newHomePage.lblWelcome.setText("Chào mừng đến với Nhà Hàng");
				JOptionPane.showMessageDialog(frame, "Đăng nhập thành công!");
			}else {
				JOptionPane.showMessageDialog(frame, "Access Granted!");
			}
			newHomePage.btnSignIn.setVisible(false);
			newHomePage.btnSignUp.setVisible(false);
			newHomePage.btnSignOut.setVisible(true);
			newHomePage.btnOrder.setVisible(true);
			newHomePage.lblUserIcon.setVisible(true);
			try {
				newHomePage.lblHelloUser.setText(setEmployeeName());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			newHomePage.setVisible(true);
			dispose();
		}
		else if(key.equals("Customer")) {
			if(btnSignin.getText() == "Đăng nhập") {
				newHomePage.btnLang.setText("VI");
				newHomePage.btnMenu.setText("Thực đơn");
				newHomePage.btnSpecialDeal.setText("Khuyến mãi");
				newHomePage.btnOrder.setText("Đặt món");
				newHomePage.btnCalculator.setText("Máy tính");
				newHomePage.btnSignIn.setText("Đăng nhập");
				newHomePage.btnSignUp.setText("Đăng ký");
				newHomePage.btnSignOut.setText("Đăng xuất");
				newHomePage.lblWelcome.setText("Chào mừng đến với Nhà Hàng");
				JOptionPane.showMessageDialog(frame, "Đăng nhập thành công!");
			}else {
				JOptionPane.showMessageDialog(frame, "Access Granted!");
			}
			newHomePage.btnSignIn.setVisible(false);
			newHomePage.btnSignUp.setVisible(false);
			newHomePage.btnSignOut.setVisible(true);
			newHomePage.btnOrder.setVisible(true);
			newHomePage.lblUserIcon.setVisible(true);
			try {
				newHomePage.lblHelloUser.setText(setCustomerName());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			newHomePage.setVisible(true);
			dispose();
		}else {
			if(btnSignin.getText() == "Đăng nhập") {
				JOptionPane.showMessageDialog(frame, "Đăng nhập thất bại!");
			}else {
			JOptionPane.showMessageDialog(frame, "Access Denied!");
			}
		}
	}
	public void setCancel() {
		HomePage newHomePage = new HomePage();
		if(btnSignin.getText() == "Đăng nhập") {
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
	void setSignup() {
		SignupPage newSignup = new SignupPage();
		if(btnCancel.getText() == "Hủy bỏ") {
			newSignup.setTitle("Đăng ký");
			newSignup.btnBackHome.setText("Trở về trang chủ");
			newSignup.btnCancel.setText("Hủy bỏ");
			newSignup.btnSignup.setText("Đăng ký");
			newSignup.lblFullName.setText("Họ và tên");
			newSignup.lblUsername.setText("Tên đăng nhập");
			newSignup.lblPassword.setText("Mật khẩu");
			newSignup.lblRepass.setText("Nhập lại mật khẩu");
			newSignup.cbEmployee.setText("Bạn có phải là nhân viên không?");
			newSignup.lblSuccess.setText("Đăng ký thành công!");
		}
		newSignup.setVisible(true);
		dispose();
	}
	public boolean verifyEmployee() throws IOException {
		String [][] users = Employee.readEmployeeFiles();
		String newUsername = textInUsername.getText();
		char[] charPass = textInPass.getPassword();
		String newPassword = new String(charPass);
		if(Employee.compareUsers(users, newUsername, newPassword)) {
			return true;
		}else {
			return false;
		}
	}
	public String setEmployeeName() throws IOException{
		String [][] users = Employee.readEmployeeFiles();
		String newUsername = textInUsername.getText();
		char[] charPass = textInPass.getPassword();
		String newPassword = new String(charPass);
		String savedName = null;
		if(verifyEmployee() == true) {
			savedName = Employee.setSignInName(users, newUsername, newPassword);
			return savedName;
		}else {
			return null;
		}
	}
	
	public boolean verifyCustomer() throws IOException {
		String [][] users = Customer.readCustomerFiles();
		String newUsername = textInUsername.getText();
		char[] charPass = textInPass.getPassword();
		String newPassword = new String(charPass);
		if(Customer.compareUsers(users, newUsername, newPassword)) {
			return true;
		}else {
			return false;
		}
	}
	public String setCustomerName() throws IOException{
		String [][] users = Customer.readCustomerFiles();
		String newUsername = textInUsername.getText();
		char[] charPass = textInPass.getPassword();
		String newPassword = new String(charPass);
		String savedName = null;
		if(verifyCustomer() == true) {
			savedName = Customer.setSignInName(users, newUsername, newPassword);
			return savedName;
		}else {
			return null;
		}
	}
}

