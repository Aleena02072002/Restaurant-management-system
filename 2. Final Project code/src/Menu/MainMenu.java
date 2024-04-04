package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Restaurant.HomePage;
import User.Employee;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	
	public JScrollPane scrollPane;
	public DefaultTableModel tableModel;
	public JButton btnImportMenu;
	public JButton btnImportFile;
	public JButton btnSaveTable;
	public JButton btnDelete;
	public JButton btnHome;
	public JLabel lblOnce;
	public JButton btnLang;
	
	private JLabel lblBackground;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private static MainMenu frame;
	private JLabel lblNewLabel;
	static MenuList menulist = new MenuList();
	static String[] columns = new String [] {"Type","Food Name", "Price"};
	static String[] newColumns = new String [] {"Thể loại","Món ăn", "Giá cả"};
	
	HomePage newHomePage = new HomePage();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Main Menu");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columns);
		table.setModel(tableModel);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 40, 373, 201);
		contentPane.add(scrollPane);
		
		btnImportMenu = new JButton("Import menu");
		btnImportMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importMenu();
			}
		});
		btnImportMenu.setBounds(28, 241, 114, 21);
		btnImportMenu.setFocusable(false);
		contentPane.add(btnImportMenu);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processButtonDelete();
			}
		});
		btnDelete.setBounds(316, 241, 85, 21);
		btnDelete.setFocusable(false);
		contentPane.add(btnDelete);
		
		btnSaveTable = new JButton("Save Table");
		btnSaveTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveTable();
			}
		});
		btnSaveTable.setBounds(152, 241, 114, 21);
		btnSaveTable.setFocusable(false);
		contentPane.add(btnSaveTable);
		
		btnImportFile = new JButton("Import file");
		btnImportFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importSave();
			}
		});
		btnImportFile.setBounds(28, 272, 114, 21);
		contentPane.add(btnImportFile);
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setDisplay();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnHome.setBounds(10, 9, 97, 21);
		btnHome.setFocusable(false);
		contentPane.add(btnHome);
		
		lblOnce = new JLabel("( ONLY PRESS ONCE )");
		lblOnce.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnce.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblOnce.setBounds(152, 251, 134, 21);
		contentPane.add(lblOnce);
		
		btnLang = new JButton("EN");
		btnLang.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnLang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLanguage();
			}
		});
		btnLang.setFocusable(false);
		btnLang.setBounds(374, 312, 52, 21);
		contentPane.add(btnLang);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 295, 416, 93);
		contentPane.add(lblNewLabel);
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 436, 354);
		ImageIcon bg = new ImageIcon(this.getClass().getResource("coffee_pink_bg.jpg"));
		addImage(lblBackground, bg, lblBackground.getWidth(), lblBackground.getHeight());
		contentPane.add(lblBackground);
	}
	void addImage(JLabel newLabel, ImageIcon icon, int newWidth, int newHeight) {
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(imgScale);
		newLabel.setIcon(scaledImg);
	}
		void importMenu()
		{	
			menulist.setMenuList();
			Object[][] data = menulist.getRowmenu();
			
			int len = data.length;
			for(int i=0; i<len; i++){
				tableModel.addRow(data[i]);
			}
		}
		
		void importSave()
		{
			try {
				Object[][] ob = menulist.readUsingFiles();
				int len = ob.length;
				for(int i=0; i<len; i++){
					tableModel.addRow(ob[i]);
				}
				
			} catch (IOException e) {
				System.out.println("Error");
				e.printStackTrace();
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
		
		void saveTable()
		{
			MenuList.saveData(tableModel);
		}
		void setLanguage() {
			if(btnLang.getText() == "EN") {
				btnLang.setText("VI");
				this.setTitle("Thực đơn");
				btnImportFile.setText("Hiển thị");
				btnImportMenu.setText("Thêm món ăn");
				btnSaveTable.setText("Lưu thực đơn");
				btnDelete.setText("Xóa");
				btnHome.setText("Trang chủ");
				lblOnce.setText("( CHỈ BẤM 1 LẦN )");
				tableModel.setColumnIdentifiers(newColumns);
			}else{
				btnLang.setText("EN");
				this.setTitle("Main Menu");
				btnImportFile.setText("Import file");
				btnImportMenu.setText("Import menu");
				btnSaveTable.setText("Save Table");
				btnDelete.setText("Delete");
				btnHome.setText("Home");	
				lblOnce.setText("( ONLY PRESS ONCE )");
				tableModel.setColumnIdentifiers(columns);
			}
		}
		public void setDisplay() throws IOException{
			String displayName = Employee.readDisplay();
			if(displayName != "") {
				//TH: nếu đã Sign in
				changeToViet();
				newHomePage.lblHelloUser.setText(displayName);
				newHomePage.lblUserIcon.setVisible(true);
				newHomePage.btnSignIn.setVisible(false);
				newHomePage.btnSignUp.setVisible(false);
				newHomePage.btnSignOut.setVisible(true);
				newHomePage.btnOrder.setVisible(true);
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
				newHomePage.setTitle("Trang chủ");
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
		}
}
