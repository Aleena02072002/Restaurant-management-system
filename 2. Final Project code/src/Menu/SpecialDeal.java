package Menu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Restaurant.HomePage;
import User.Employee;
import java.awt.Font;
import java.awt.Image;

public class SpecialDeal extends JFrame {

	/**
	 * 
	 */
	public JButton btnAnnounce;
	public JButton btnDelete;
	public JButton btnHome;
	public JButton btnLang;
	public DefaultTableModel tableModel;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane1;
	private JTable table;
	private static MainMenu frame;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	static MenuList menulist = new MenuList();
	public static String[] columns = new String [] {"Type","Food Name", "Price"};
	public static String[] newColumns = new String [] {"Thể loại","Món ăn", "Giá cả"};
	private JLabel lblBackground;
	
	HomePage newHomePage = new HomePage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpecialDeal frame = new SpecialDeal();
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
	public SpecialDeal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Special Deal");
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		table = new JTable();
		
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columns);
		table.setModel(tableModel);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 41, 373, 201);
		contentPane1.add(scrollPane);
		
		btnAnnounce = new JButton("Announce");
		btnAnnounce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				announce();
			}
		});
		btnAnnounce.setBounds(28, 242, 114, 21);
		btnAnnounce.setFocusable(false);
		contentPane1.add(btnAnnounce);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processButtonDelete();
			}
		});
		btnDelete.setBounds(316, 242, 85, 21);
		btnDelete.setFocusable(false);
		contentPane1.add(btnDelete);
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setDisplay();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHome.setBounds(10, 10, 95, 21);
		btnHome.setFocusable(false);
		contentPane1.add(btnHome);
		
		btnLang = new JButton("EN");
		btnLang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLanguage();
			}
		});
		btnLang.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnLang.setBounds(352, 282, 49, 21);
		contentPane1.add(btnLang);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 294, 416, 93);
		contentPane1.add(lblNewLabel);
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 436, 313);
		ImageIcon bg = new ImageIcon(this.getClass().getResource("green_blur_bg.jpg"));
		addImage(lblBackground, bg, lblBackground.getWidth(), lblBackground.getHeight());
		contentPane1.add(lblBackground);
	}
	void addImage(JLabel newLabel, ImageIcon icon, int newWidth, int newHeight) {
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(imgScale);
		newLabel.setIcon(scaledImg);
	}
		void announce()
		{	
			menulist.setMenuList();
			Object[][] data = menulist.getRowmenu();
			
			int len = data.length;
			for(int i=0; i<len; i++){
				tableModel.addRow(data[i]);
			}
		}
		
		void processButtonDelete(){
			int count = table.getRowCount();
			if(count > 0){
				int idx = table.getSelectedRow();
				if (idx >= 0)
					tableModel.removeRow(idx);
				else
					JOptionPane.showMessageDialog(frame, "DELETE ERROR!!");
			}
			else
				JOptionPane.showMessageDialog(frame, "Table does not contain any records!!");
		}
		void setLanguage() {
			if(btnLang.getText() == "EN") {
				btnLang.setText("VI");
				this.setTitle("Khuyến mãi");
				btnAnnounce.setText("Thông báo");
				btnDelete.setText("Xóa");
				btnHome.setText("Trang chủ");
				tableModel.setColumnIdentifiers(newColumns);
			}else{
				btnLang.setText("EN");
				this.setTitle("Special Deal");
				btnAnnounce.setText("Announce");
				btnDelete.setText("Delete");
				btnHome.setText("Home");	
				tableModel.setColumnIdentifiers(columns);
			}
		}
		void setDisplay() throws IOException{
			String displayName = Employee.readDisplay();
			if(displayName != "") {
				//TH: nếu đã Sign in
				changeToViet();
				newHomePage.lblHelloUser.setText(displayName);
				newHomePage.lblUserIcon.setVisible(true);
				newHomePage.lblUserIcon.setVisible(true);
				newHomePage.btnSignIn.setVisible(false);
				newHomePage.btnSignUp.setVisible(false);
				newHomePage.btnSignOut.setVisible(true);
				newHomePage.btnOrder.setVisible(true);
				newHomePage.lblUserIcon.setVisible(true);
				newHomePage.setVisible(true);
				dispose();
			}else {
				//TH: nếu chưa Sign in
				changeToViet();
				newHomePage.lblUserIcon.setVisible(false);
				newHomePage.btnSignIn.setVisible(true);
				newHomePage.btnSignUp.setVisible(true);
				newHomePage.setVisible(true);
				dispose();
			}
		}
		void changeToViet() {
			if(btnLang.getText() == "VI") {
				newHomePage.btnLang.setText("VI");
				newHomePage.setTitle("Trang chủ");
				newHomePage.btnMenu.setText("Thực đơn");
				newHomePage.btnSpecialDeal.setText("Khuyến mãi");
				newHomePage.btnOrder.setText("Đặt món");
				newHomePage.btnCalculator.setText("Máy tính");
				newHomePage.btnSignIn.setText("Đăng nhập");
				newHomePage.btnSignUp.setText("Đăng ký");
				newHomePage.btnSignOut.setText("Đăng xuất");
				newHomePage.lblWelcome.setText("Chào mừng đến với Nhà Hàng");
			}
		}
}
