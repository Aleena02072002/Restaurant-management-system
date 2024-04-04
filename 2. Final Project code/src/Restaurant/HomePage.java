package Restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menu.MainMenu;
import Menu.SpecialDeal;
import User.Employee;
import User.NewUser;
import User.SigninPage;
import User.SignupPage;
import Menu.calculator;
import Order_Food.OrderFood;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static HomePage frame;
	
	public JLabel lblWelcome;
	public JButton btnMenu;
	public JButton btnCalculator;
	public JButton btnSignUp;
	public JButton btnSignIn;
	public JButton btnOrder;
	public JButton btnSignOut;
	public JButton btnSpecialDeal;
	public JLabel lblHelloUser;
	public JButton btnLang;
	public JLabel lblUserIcon;
	public JLabel lblBackground;
	
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Home");
		
		lblWelcome = new JLabel("Welcome to the Restaurant");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(207, 125, 321, 134);
		contentPane.add(lblWelcome);
		
		btnMenu = new JButton("Main Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveToDisplay();
				try {
					setMenu();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMenu.setBounds(10, 10, 112, 32);
		btnMenu.setFocusable(false);
		contentPane.add(btnMenu);
		
		btnSpecialDeal = new JButton("Special Deal");
		btnSpecialDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveToDisplay();
				try {
					setDeal();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnSpecialDeal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSpecialDeal.setBounds(132, 10, 128, 32);
		btnSpecialDeal.setFocusable(false);
		contentPane.add(btnSpecialDeal);
		
		btnOrder = new JButton("Order Food");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveToDisplay();
				try {
					setOrder();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOrder.setFocusable(false);
		btnOrder.setVisible(false);
		btnOrder.setBounds(270, 10, 128, 32);
		contentPane.add(btnOrder);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSignin();
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSignIn.setBounds(496, 10, 110, 25);
		btnSignIn.setFocusable(false);
		contentPane.add(btnSignIn);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSignup();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSignUp.setBounds(616, 10, 110, 25);
		btnSignUp.setFocusable(false);
		contentPane.add(btnSignUp);
		
		btnCalculator = new JButton("Calculator");
		btnCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.createCalculator();
			}
		});
		btnCalculator.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCalculator.setBounds(10, 421, 112, 32);
		contentPane.add(btnCalculator);	
		
		btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOrder.setVisible(false);
				btnSignIn.setVisible(true);
				btnSignUp.setVisible(true);
				btnSignOut.setVisible(false);
				lblHelloUser.setText("");
			}
		});
		btnSignOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSignOut.setVisible(false);
		btnSignOut.setFocusable(false);
		btnSignOut.setBounds(635, 45, 91, 17);
		contentPane.add(btnSignOut);
		
		btnLang = new JButton("EN");
		btnLang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLanguage();
			}
		});
		btnLang.setBounds(663, 435, 51, 25);
		contentPane.add(btnLang);
		
		lblHelloUser = new JLabel("");
		lblHelloUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHelloUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHelloUser.setBounds(482, 10, 217, 25);
		contentPane.add(lblHelloUser);
		
		lblUserIcon = new JLabel("");
		lblUserIcon.setBounds(709, 14, 17, 17);
		ImageIcon user = new ImageIcon(this.getClass().getResource("user.png"));
		addImage(lblUserIcon, user, lblUserIcon.getWidth(), lblUserIcon.getHeight());
		lblUserIcon.setVisible(false);
		contentPane.add(lblUserIcon);
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 750, 500);
		ImageIcon bg = new ImageIcon(this.getClass().getResource("blur_bright_bg.jpg"));
		addImage(lblBackground, bg, lblBackground.getWidth(), lblBackground.getHeight());
		lblBackground.setVisible(true);
		contentPane.add(lblBackground);
	}
	void addImage(JLabel newLabel, ImageIcon icon, int newWidth, int newHeight) {
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(imgScale);
		newLabel.setIcon(scaledImg);
	}
	void saveToDisplay() {
		String newSignInfo = lblHelloUser.getText();
		if(newSignInfo != "") {
			NewUser.saveDisplay(newSignInfo);
		}else {
			NewUser.saveDisplay("");
		}
	}
	void setDeal() throws IOException{
		String displayName = Employee.readDisplay();
		SpecialDeal newSpecialDeal = new SpecialDeal();
		// TH: nếu không Sign In
		if(displayName == "") {
			if(btnLang.getText() == "VI") {
				String[] newColumns = new String [] {"Thể loại", "Món ăn", "Giá cả"};
				newSpecialDeal.tableModel.setColumnIdentifiers(newColumns);
				newSpecialDeal.setTitle("Khuyến mãi");
				newSpecialDeal.btnLang.setText("VI");
				newSpecialDeal.btnAnnounce.setText("Thông báo");
				newSpecialDeal.btnDelete.setText("Xóa");
				newSpecialDeal.btnHome.setText("Quay lại");				
			}
			newSpecialDeal.btnAnnounce.setVisible(false);
			newSpecialDeal.btnDelete.setVisible(false);
			newSpecialDeal.btnHome.setVisible(true);
			newSpecialDeal.setVisible(true);
		}else { // TH: nếu đã Sign In
			if(btnLang.getText() == "VI") {
				String[] newColumns = new String [] {"Thể loại", "Món ăn", "Giá cả"};
				newSpecialDeal.tableModel.setColumnIdentifiers(newColumns);
				newSpecialDeal.setTitle("Khuyến mãi");
				newSpecialDeal.btnLang.setText("VI");
				newSpecialDeal.btnAnnounce.setText("Thông báo");
				newSpecialDeal.btnDelete.setText("Xóa");
				newSpecialDeal.btnHome.setText("Quay lại");				
			}
			newSpecialDeal.setVisible(true);
		}
		dispose();
	}
	void setMenu() throws IOException{
		String displayName = Employee.readDisplay();
		MainMenu newMainMenu = new MainMenu();
		// TH: nếu không Sign In
		if(displayName == "") {
			if(btnLang.getText() == "VI") {
				String[] newColumns = new String [] {"Thể loại", "Món ăn", "Giá cả"};
				newMainMenu.tableModel.setColumnIdentifiers(newColumns);
				newMainMenu.setTitle("Thực đơn");
				newMainMenu.btnImportFile.setText("Hiện thực đơn");
				newMainMenu.btnHome.setText("Quay lại");	
				newMainMenu.btnLang.setText("VI");
				newMainMenu.lblOnce.setText("( CHỈ BẤM 1 LẦN )");
			}
			newMainMenu.btnImportMenu.setVisible(false);
			newMainMenu.btnSaveTable.setVisible(false);
			newMainMenu.btnDelete.setVisible(false);
			newMainMenu.btnHome.setVisible(true);
			newMainMenu.btnImportFile.setBounds(152, 272, 130, 28);
			newMainMenu.setVisible(true);
			dispose();
		}else {// TH: nếu đã Sign In
			if(btnLang.getText() == "VI") {
				String[] newColumns = new String [] {"Thể loại", "Món ăn", "Giá cả"};
				newMainMenu.tableModel.setColumnIdentifiers(newColumns);
				newMainMenu.btnLang.setText("VI");
				newMainMenu.setTitle("Thực đơn");
				newMainMenu.btnImportFile.setText("Hiển thị");
				newMainMenu.btnImportMenu.setText("Thêm món ăn");
				newMainMenu.btnSaveTable.setText("Lưu thực đơn");
				newMainMenu.btnDelete.setText("Xóa");
				newMainMenu.btnHome.setText("Quay lại");
			}
			newMainMenu.lblOnce.setVisible(false);
			newMainMenu.setVisible(true);
			dispose();
		}
	}
	void setOrder() throws IOException{
		
		String displayName = Employee.readDisplay();
		OrderFood newOrderFood = new OrderFood();
		// TH: nếu không Sign In
		if(displayName == "") {
			if(btnLang.getText() == "VI") {
				newOrderFood.btnLang.setText("VI");
				newOrderFood.setTitle("Đặt món");
				
				newOrderFood.lblFriedChickenText.setText("Gà Rán");
				newOrderFood.lblPhoText.setText("Phở");
				newOrderFood.lblComTamText.setText("Cơm Tấm");
				newOrderFood.lblBanhXeoText.setText("Bánh Xèo");
				newOrderFood.lblBanhKhotText.setText("Bánh Khọt");
				newOrderFood.lblLauHaiSanText.setText("Lẩu Hải Sản");
				
				newOrderFood.lblFriedChickenPriceText.setText("Giá");
				newOrderFood.lblPhoPriceText.setText("Giá");
				newOrderFood.lblComTamPriceText.setText("Giá");
				newOrderFood.lblBanhXeoPriceText.setText("Giá");
				newOrderFood.lblBanhKhotPriceText.setText("Giá");
				newOrderFood.lblLauHaiSanPriceText.setText("Giá");
				
				newOrderFood.lblFriedChickenQuantityText.setText("Số lượng");
				newOrderFood.lblPhoQuantityText.setText("Số lượng");
				newOrderFood.lblComTamQuantityText.setText("Số lượng");
				newOrderFood.lblBanhXeoQuantityText.setText("Số lượng");
				newOrderFood.lblBanhKhotQuantityText.setText("Số lượng");
				newOrderFood.lblLauHaiSanQuantityText.setText("Số lượng");
				
				newOrderFood.btnBuyFriedChicken.setText("Mua");
				newOrderFood.btnBuyPho.setText("Mua");
				newOrderFood.btnBuyComTam.setText("Mua");
				newOrderFood.btnBuyBanhXeo.setText("Mua");
				newOrderFood.btnBuyBanhKhot.setText("Mua");
				newOrderFood.btnBuyLauHaiSan.setText("Mua");
				
				newOrderFood.lblTotal.setText("Tổng cộng");
				newOrderFood.btnTotal.setText("Tính tổng");
				newOrderFood.btnReset.setText("Làm lại");
				newOrderFood.btnPrintReceipt.setText("In hóa đơn");
				newOrderFood.btnHome.setText("Trang chủ");
			}
			newOrderFood.setVisible(true);
			dispose();
		}else {// TH: nếu đã Sign In
			if(btnLang.getText() == "VI") {
				newOrderFood.btnLang.setText("VI");
				newOrderFood.setTitle("Đặt món");
				
				newOrderFood.lblFriedChickenText.setText("Gà Rán");
				newOrderFood.lblPhoText.setText("Phở");
				newOrderFood.lblComTamText.setText("Cơm Tấm");
				newOrderFood.lblBanhXeoText.setText("Bánh Xèo");
				newOrderFood.lblBanhKhotText.setText("Bánh Khọt");
				newOrderFood.lblLauHaiSanText.setText("Lẩu Hải Sản");
				
				newOrderFood.lblFriedChickenPriceText.setText("Giá");
				newOrderFood.lblPhoPriceText.setText("Giá");
				newOrderFood.lblComTamPriceText.setText("Giá");
				newOrderFood.lblBanhXeoPriceText.setText("Giá");
				newOrderFood.lblBanhKhotPriceText.setText("Giá");
				newOrderFood.lblLauHaiSanPriceText.setText("Giá");
				
				newOrderFood.lblFriedChickenQuantityText.setText("Số lượng");
				newOrderFood.lblPhoQuantityText.setText("Số lượng");
				newOrderFood.lblComTamQuantityText.setText("Số lượng");
				newOrderFood.lblBanhXeoQuantityText.setText("Số lượng");
				newOrderFood.lblBanhKhotQuantityText.setText("Số lượng");
				newOrderFood.lblLauHaiSanQuantityText.setText("Số lượng");
				
				newOrderFood.btnBuyFriedChicken.setText("Mua");
				newOrderFood.btnBuyPho.setText("Mua");
				newOrderFood.btnBuyComTam.setText("Mua");
				newOrderFood.btnBuyBanhXeo.setText("Mua");
				newOrderFood.btnBuyBanhKhot.setText("Mua");
				newOrderFood.btnBuyLauHaiSan.setText("Mua");
				
				newOrderFood.lblTotal.setText("Tổng cộng");
				newOrderFood.btnTotal.setText("Tính tổng");
				newOrderFood.btnReset.setText("Làm lại");
				newOrderFood.btnPrintReceipt.setText("In hóa đơn");
				newOrderFood.btnHome.setText("Trang chủ");
			}
			newOrderFood.setVisible(true);
			dispose();
		}
	}
	void setSignin() {
		SigninPage newSignin = new SigninPage();
		if(btnLang.getText() == "VI") {
			newSignin.setTitle("Đăng nhập");
			newSignin.btnSignin.setText("Đăng nhập");
			newSignin.btnSignup.setText("Đăng ký");
			newSignin.btnCancel.setText("Hủy bỏ");
			newSignin.lblUsername.setText("Tên đăng nhập");
			newSignin.lblPassword.setText("Mật khẩu");
		}else {
			newSignin.btnSignin.setText("Sign In");
			newSignin.btnSignup.setText("Sign Up");
			newSignin.btnCancel.setText("Cancel");
		}
		newSignin.setVisible(true);
		dispose();
	}
	void setSignup() {
		SignupPage newSignup = new SignupPage();
		if(btnLang.getText() == "VI") {
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
	void setLanguage() {
		if(btnLang.getText() == "EN") {
			btnLang.setText("VI");
			this.setTitle("Trang chủ");
			btnMenu.setText("Thực đơn");
			btnSpecialDeal.setText("Khuyến mãi");
			btnOrder.setText("Đặt món");
			btnCalculator.setText("Máy tính");
			btnSignIn.setText("Đăng nhập");
			btnSignOut.setText("Đăng xuất");
			btnSignUp.setText("Đăng ký");
			lblWelcome.setText("Chào mừng đến với Nhà Hàng");
		}else{
			btnLang.setText("EN");
			this.setTitle("Home");
			btnMenu.setText("Main Menu");
			btnSpecialDeal.setText("Special Deal");
			btnOrder.setText("Order Food");
			btnCalculator.setText("Calculator");
			btnSignIn.setText("Sign In");
			btnSignOut.setText("Sign Out");
			btnSignUp.setText("Sign Up");
			lblWelcome.setText("Welcome to the Restaurant");
		}
	}
}
