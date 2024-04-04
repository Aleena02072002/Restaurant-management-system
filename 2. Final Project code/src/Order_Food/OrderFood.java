package Order_Food;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Restaurant.HomePage;
import User.NewUser;

public class OrderFood extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spinnerChickenQuantity, spinnerPhoQuantity, spinnerComTamQuantity, spinnerBanhXeoQuantity,
			spinnerBanhKhotQuantity, spinnerLauHaiSanQuantity;
	private JTextField textFieldTotal;
	private JTextArea textArea;
	private JLabel timeLabel, dateLabel;
	SimpleDateFormat timeFormat, dateFormat;
	private String time, date;
	private double total = 0d;
	private int x = 0; 

	private ImageIcon friedChicken, pho, comTam, banhXeo, banhKhot, lauHaiSan;
	private JPanel panelFriedChicken, panelPho, panelComTam, panelBanhXeo, panelBanhKhot, panelLauHaiSan, panel;
	private JLabel lblFriedChicken, lblPho, lblComTam, lblBanhXeo, lblBanhKhot,lblLauHaiSan;
	private JLabel lblFriedChickenPrice, lblPhoPrice, lblComTamPrice, lblBanhXeoPrice, lblBanhKhotPrice, 
			lblLauHaiSanPrice;
	
	public JLabel lblFriedChickenText, lblPhoText, lblComTamText, lblBanhXeoText, lblBanhKhotText, lblLauHaiSanText;
	public JLabel lblFriedChickenPriceText, lblPhoPriceText, lblComTamPriceText, lblBanhXeoPriceText, 
			lblBanhKhotPriceText, lblLauHaiSanPriceText;
	public JLabel lblFriedChickenQuantityText, lblPhoQuantityText ,lblComTamQuantityText, lblBanhXeoQuantityText, 
			lblBanhKhotQuantityText, lblLauHaiSanQuantityText;
	public JButton btnBuyFriedChicken, btnBuyPho, btnBuyComTam, btnBuyBanhXeo, btnBuyBanhKhot, btnBuyLauHaiSan;
	public JButton btnReset, btnPrintReceipt;
	public JButton btnHome;
	public JLabel lblTotal;
	public JButton btnLang;
	public JButton btnTotal;
	javax.swing.Timer clockTimer;
	
	HomePage newHomePage = new HomePage();
	private JLabel lblBackground;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFood frame = new OrderFood();
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
	public OrderFood() {
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				clockTimer.stop();
				java.awt.EventQueue.invokeLater(() -> new HomePage().setVisible(true));
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 800);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		setContentPane(contentPane);
		this.setTitle("Order Food");
		contentPane.setLayout(null);
		
		//NHỚ KIỂM TRA ĐỔI LINK HÌNH PHÍA DƯỚI
		friedChicken = new ImageIcon(this.getClass().getResource("fried_chicken.jpg"));
		pho = new ImageIcon(this.getClass().getResource("pho.jpg"));
		comTam = new ImageIcon(this.getClass().getResource("com_tam.jpg"));
		banhXeo = new ImageIcon(this.getClass().getResource("banh_xeo.jpg"));
		banhKhot = new ImageIcon(this.getClass().getResource("banh_khot.jpg"));
		lauHaiSan = new ImageIcon(this.getClass().getResource("lau_hai_san.jpg"));
		

		panelFriedChicken = new JPanel();
		panelFriedChicken.setBounds(10, 37, 207, 275);
		contentPane.add(panelFriedChicken);
		panelFriedChicken.setLayout(null);

		lblFriedChicken = new JLabel("");
		lblFriedChicken.setBounds(0, 11, 207, 112);
		addImage(lblFriedChicken, friedChicken, 207, 112);
		panelFriedChicken.add(lblFriedChicken);

		lblFriedChickenText = new JLabel("Fried Chicken");
		lblFriedChickenText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFriedChickenText.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriedChickenText.setBounds(58, 134, 83, 34);
		panelFriedChicken.add(lblFriedChickenText);

		lblFriedChickenPriceText = new JLabel("Price");
		lblFriedChickenPriceText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFriedChickenPriceText.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriedChickenPriceText.setBounds(10, 180, 62, 23);
		panelFriedChicken.add(lblFriedChickenPriceText);

		lblFriedChickenPrice = new JLabel("50k");
		lblFriedChickenPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriedChickenPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFriedChickenPrice.setBounds(115, 180, 62, 23);
		panelFriedChicken.add(lblFriedChickenPrice);

		lblFriedChickenQuantityText = new JLabel("Quantity");
		lblFriedChickenQuantityText.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriedChickenQuantityText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFriedChickenQuantityText.setBounds(10, 214, 62, 23);
		panelFriedChicken.add(lblFriedChickenQuantityText);

		spinnerChickenQuantity = new JSpinner();
		spinnerChickenQuantity
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerChickenQuantity.setBounds(105, 214, 72, 23);
		panelFriedChicken.add(spinnerChickenQuantity);
		
		btnBuyFriedChicken = new JButton("Purchase");
		btnBuyFriedChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBuy(spinnerChickenQuantity, lblFriedChickenText);
			}
		});
		btnBuyFriedChicken.setBounds(47, 247, 110, 18);
		panelFriedChicken.add(btnBuyFriedChicken);

		panelPho = new JPanel();
		panelPho.setLayout(null);
		panelPho.setBounds(259, 37, 207, 275);
		contentPane.add(panelPho);

		lblPho = new JLabel("");
		lblPho.setBounds(0, 11, 207, 112);
		addImage(lblPho, pho, 207, 112);
		panelPho.add(lblPho);

		lblPhoText = new JLabel("Pho");
		lblPhoText.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoText.setBounds(58, 134, 83, 34);
		panelPho.add(lblPhoText);

		lblPhoPriceText = new JLabel("Price");
		lblPhoPriceText.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoPriceText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoPriceText.setBounds(10, 180, 62, 23);
		panelPho.add(lblPhoPriceText);

		lblPhoPrice = new JLabel("30k");
		lblPhoPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoPrice.setBounds(115, 180, 62, 23);
		panelPho.add(lblPhoPrice);

		lblPhoQuantityText = new JLabel("Quantity");
		lblPhoQuantityText.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoQuantityText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoQuantityText.setBounds(10, 214, 62, 23);
		panelPho.add(lblPhoQuantityText);

		spinnerPhoQuantity = new JSpinner();
		spinnerPhoQuantity
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0)
						, null, Integer.valueOf(1)));
		spinnerPhoQuantity.setBounds(105, 214, 72, 23);
		panelPho.add(spinnerPhoQuantity);
		
		btnBuyPho = new JButton("Purchase");
		btnBuyPho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBuy(spinnerPhoQuantity, lblPhoText);
			}
		});
		btnBuyPho.setBounds(50, 247, 110, 18);
		panelPho.add(btnBuyPho);

		panelComTam = new JPanel();
		panelComTam.setLayout(null);
		panelComTam.setBounds(500, 37, 207, 275);
		contentPane.add(panelComTam);

		lblComTam = new JLabel("");
		lblComTam.setHorizontalAlignment(SwingConstants.CENTER);
		lblComTam.setBounds(0, 11, 207, 112);
		addImage(lblComTam, comTam, 207, 112);
		panelComTam.add(lblComTam);

		lblComTamText = new JLabel("Com Tam");
		lblComTamText.setHorizontalAlignment(SwingConstants.CENTER);
		lblComTamText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComTamText.setBounds(58, 134, 83, 34);
		panelComTam.add(lblComTamText);

		lblComTamPriceText = new JLabel("Price");
		lblComTamPriceText.setHorizontalAlignment(SwingConstants.CENTER);
		lblComTamPriceText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComTamPriceText.setBounds(10, 180, 62, 23);
		panelComTam.add(lblComTamPriceText);

		lblComTamPrice = new JLabel("30k");
		lblComTamPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblComTamPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComTamPrice.setBounds(115, 180, 62, 23);
		panelComTam.add(lblComTamPrice);

		lblComTamQuantityText = new JLabel("Quantity");
		lblComTamQuantityText.setHorizontalAlignment(SwingConstants.CENTER);
		lblComTamQuantityText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComTamQuantityText.setBounds(10, 214, 62, 23);
		panelComTam.add(lblComTamQuantityText);

		spinnerComTamQuantity = new JSpinner();
		spinnerComTamQuantity
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerComTamQuantity.setBounds(105, 214, 72, 23);
		panelComTam.add(spinnerComTamQuantity);
		
		btnBuyComTam = new JButton("Purchase");
		btnBuyComTam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBuy(spinnerComTamQuantity, lblComTamText);
			}
		});
		btnBuyComTam.setBounds(46, 247, 115, 18);
		panelComTam.add(btnBuyComTam);

		panelBanhXeo = new JPanel();
		panelBanhXeo.setLayout(null);
		panelBanhXeo.setBounds(10, 323, 207, 275);
		contentPane.add(panelBanhXeo);

		lblBanhXeo = new JLabel("");
		lblBanhXeo.setBounds(0, 11, 207, 112);
		addImage(lblBanhXeo, banhXeo, 207, 112);
		panelBanhXeo.add(lblBanhXeo);

		lblBanhXeoText = new JLabel("Banh Xeo");
		lblBanhXeoText.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanhXeoText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBanhXeoText.setBounds(58, 134, 83, 34);
		panelBanhXeo.add(lblBanhXeoText);

		lblBanhXeoPriceText = new JLabel("Price");
		lblBanhXeoPriceText.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanhXeoPriceText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBanhXeoPriceText.setBounds(10, 180, 62, 23);
		panelBanhXeo.add(lblBanhXeoPriceText);

		lblBanhXeoPrice = new JLabel("5k");
		lblBanhXeoPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanhXeoPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBanhXeoPrice.setBounds(115, 180, 62, 23);
		panelBanhXeo.add(lblBanhXeoPrice);

		lblBanhXeoQuantityText = new JLabel("Quantity");
		lblBanhXeoQuantityText.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanhXeoQuantityText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBanhXeoQuantityText.setBounds(10, 214, 62, 23);
		panelBanhXeo.add(lblBanhXeoQuantityText);

		spinnerBanhXeoQuantity = new JSpinner();
		spinnerBanhXeoQuantity
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerBanhXeoQuantity.setBounds(105, 214, 72, 23);
		panelBanhXeo.add(spinnerBanhXeoQuantity);
		
		btnBuyBanhXeo = new JButton("Purchase");
		btnBuyBanhXeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBuy(spinnerBanhXeoQuantity, lblBanhXeoText);
			}
		});
		btnBuyBanhXeo.setBounds(47, 247, 107, 18);
		panelBanhXeo.add(btnBuyBanhXeo);

		panelBanhKhot = new JPanel();
		panelBanhKhot.setLayout(null);
		panelBanhKhot.setBounds(259, 323, 207, 275);
		contentPane.add(panelBanhKhot);

		lblBanhKhot = new JLabel("");
		lblBanhKhot.setBounds(0, 10, 207, 112);
		addImage(lblBanhKhot, banhKhot, 207, 112);
		panelBanhKhot.add(lblBanhKhot);

		lblBanhKhotText = new JLabel("Banh Khot");
		lblBanhKhotText.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanhKhotText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBanhKhotText.setBounds(58, 134, 83, 34);
		panelBanhKhot.add(lblBanhKhotText);

		lblBanhKhotPriceText = new JLabel("Price");
		lblBanhKhotPriceText.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanhKhotPriceText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBanhKhotPriceText.setBounds(10, 180, 62, 23);
		panelBanhKhot.add(lblBanhKhotPriceText);

		lblBanhKhotPrice = new JLabel("20k");
		lblBanhKhotPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanhKhotPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBanhKhotPrice.setBounds(115, 180, 62, 23);
		panelBanhKhot.add(lblBanhKhotPrice);

		lblBanhKhotQuantityText = new JLabel("Quantity");
		lblBanhKhotQuantityText.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanhKhotQuantityText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBanhKhotQuantityText.setBounds(10, 214, 62, 23);
		panelBanhKhot.add(lblBanhKhotQuantityText);

		spinnerBanhKhotQuantity = new JSpinner();
		spinnerBanhKhotQuantity
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerBanhKhotQuantity.setBounds(105, 214, 72, 23);
		panelBanhKhot.add(spinnerBanhKhotQuantity);
		
		btnBuyBanhKhot = new JButton("Purchase");
		btnBuyBanhKhot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBuy(spinnerBanhKhotQuantity, lblBanhKhotText);
			}
		});
		btnBuyBanhKhot.setBounds(47, 247, 109, 18);
		panelBanhKhot.add(btnBuyBanhKhot);

		panelLauHaiSan = new JPanel();
		panelLauHaiSan.setLayout(null);
		panelLauHaiSan.setBounds(500, 323, 207, 275);
		contentPane.add(panelLauHaiSan);

		lblLauHaiSan = new JLabel("");
		lblLauHaiSan.setBounds(0, 11, 207, 112);
		addImage(lblLauHaiSan, lauHaiSan, 207, 112);
		panelLauHaiSan.add(lblLauHaiSan);

		lblLauHaiSanText = new JLabel("Lau Hai San");
		lblLauHaiSanText.setHorizontalAlignment(SwingConstants.CENTER);
		lblLauHaiSanText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLauHaiSanText.setBounds(58, 134, 83, 34);
		panelLauHaiSan.add(lblLauHaiSanText);

		lblLauHaiSanPriceText = new JLabel("Price");
		lblLauHaiSanPriceText.setHorizontalAlignment(SwingConstants.CENTER);
		lblLauHaiSanPriceText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLauHaiSanPriceText.setBounds(10, 180, 62, 23);
		panelLauHaiSan.add(lblLauHaiSanPriceText);

		lblLauHaiSanPrice = new JLabel("100k");
		lblLauHaiSanPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblLauHaiSanPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLauHaiSanPrice.setBounds(115, 180, 62, 23);
		panelLauHaiSan.add(lblLauHaiSanPrice);

		lblLauHaiSanQuantityText = new JLabel("Quantity");
		lblLauHaiSanQuantityText.setHorizontalAlignment(SwingConstants.CENTER);
		lblLauHaiSanQuantityText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLauHaiSanQuantityText.setBounds(10, 214, 62, 23);
		panelLauHaiSan.add(lblLauHaiSanQuantityText);

		spinnerLauHaiSanQuantity = new JSpinner();
		spinnerLauHaiSanQuantity
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerLauHaiSanQuantity.setBounds(105, 214, 72, 23);
		panelLauHaiSan.add(spinnerLauHaiSanQuantity);
		
		btnBuyLauHaiSan = new JButton("Purchase");
		btnBuyLauHaiSan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBuy(spinnerLauHaiSanQuantity, lblLauHaiSanText);
			}
		});
		btnBuyLauHaiSan.setBounds(43, 247, 114, 18);
		panelLauHaiSan.add(btnBuyLauHaiSan);

		panel = new JPanel();
		panel.setBounds(734, 37, 447, 604);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 447, 568);
		panel.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
//		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		getContentPane().add(scrollPane);
		
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(10, 579, 68, 14);
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTotal);

		textFieldTotal = new JTextField();
		textFieldTotal.setBounds(321, 573, 96, 20);
		textFieldTotal.setEditable(false);
		textFieldTotal.setText("0.0");
		textFieldTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textFieldTotal);
		textFieldTotal.setColumns(10);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(142, 618, 89, 23);
		contentPane.add(btnReset);

		timeLabel = new JLabel("");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(578, 11, 150, 14);
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		contentPane.add(timeLabel);
		dateFormat = new SimpleDateFormat("dd-MMMMM-yyyy");
		
		 btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processButtonTotal();
			}
		});
		btnTotal.setBounds(20, 618, 89, 23);
		contentPane.add(btnTotal);
		
		btnPrintReceipt = new JButton("Print Receipt");
		btnPrintReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(total == 0) {
					if(btnLang.getText() == "EN") {
						JOptionPane.showMessageDialog(null, "Please increase the quantity");
					}
					JOptionPane.showMessageDialog(null, "Vui lòng tăng số lượng món ăn");
	
				} else {
					try {
						if(!btnTotal.isEnabled()) textArea.print();
						else if(btnLang.getText() == "EN"){
							JOptionPane.showMessageDialog(null, "Please press \"Total\" button to confirm your purchase");
						}else {
							JOptionPane.showMessageDialog(null, "Hãy bấm vào nút \"Tính tổng\" để xác nhận thanh toán");
						}
					} catch (PrinterException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnPrintReceipt.setBounds(269, 618, 137, 23);
		contentPane.add(btnPrintReceipt);
		
				dateLabel = new JLabel("");
				dateLabel.setBounds(817, 12, 220, 14);
				contentPane.add(dateLabel);
				dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
				
		btnLang = new JButton("EN");
		btnLang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLanguage();
			}
		});
		btnLang.setBounds(672, 619, 52, 21);
		contentPane.add(btnLang);
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setDisplay();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnHome.setBounds(10, 10, 99, 23);
		contentPane.add(btnHome);
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 1600, 800);
		ImageIcon bg = new ImageIcon(this.getClass().getResource("blur_dark.jpg"));
		addImage(lblBackground, bg, screenWidth, screenHeight);
		contentPane.add(lblBackground);

		setTime();
	}
	void addImage(JLabel newLabel, ImageIcon icon, int newWidth, int newHeight) {
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(imgScale);
		newLabel.setIcon(scaledImg);
	}
	public void reset() {
		spinnerChickenQuantity.setValue(0);
		spinnerPhoQuantity.setValue(0);
		spinnerComTamQuantity.setValue(0);
		spinnerBanhXeoQuantity.setValue(0);
		spinnerBanhKhotQuantity.setValue(0);
		spinnerLauHaiSanQuantity.setValue(0);
		textFieldTotal.setText("0.0");
		textArea.setText("");
		btnTotal.setEnabled(true);
		x = 0;
		total = 0;
		btnBuyFriedChicken.setEnabled(true);
		btnBuyPho.setEnabled(true);
		btnBuyComTam.setEnabled(true);
		btnBuyBanhXeo.setEnabled(true);
		btnBuyBanhKhot.setEnabled(true);
		btnBuyLauHaiSan.setEnabled(true);
		
	}
	
	public void processButtonTotal() {
		if(total == 0d) {
			if(btnLang.getText() == "EN")
			{
				JOptionPane.showMessageDialog(null, "Please tick the \"Purchase\" button to confirm your purchase");
			}else {	
				JOptionPane.showMessageDialog(null, "Hãy nhấn vào nút \"Mua\" để hoàn tất thanh toán");
			}
			btnTotal.setEnabled(true);
		} else {
			if(btnLang.getText() == "EN") {
				textArea.setText(textArea.getText() + 
						"\n********************************************************************************************\n" +
						"     Total\t\t\t" + total +
						"\n\n*****************************************Thank You***************************************");
			}else {
				textArea.setText(textArea.getText() + 
						"\n********************************************************************************************\n" +
						"     Total\t\t\t" + total +
						"\n\n****************************************Xin cám ơn***************************************");
			}
			
			btnTotal.setEnabled(false); 
			btnBuyFriedChicken.setEnabled(false);
			btnBuyPho.setEnabled(false);
			btnBuyComTam.setEnabled(false);
			btnBuyBanhXeo.setEnabled(false);
			btnBuyBanhKhot.setEnabled(false);
			btnBuyLauHaiSan.setEnabled(false);
		

		}
		
	}
	public void printCurrentTotal() {
		textFieldTotal.setText(String.valueOf(total));
	}

	public boolean quantityIsZero(int quantity) {
		if (quantity == 0) {
			if(btnLang.getText() == "EN") {
				JOptionPane.showMessageDialog(null, "Please increase the quantity");
			}
			JOptionPane.showMessageDialog(null, "Vui lòng tăng số lượng món ăn");
			return false;
		}
		return true;
	}

	public void display_Infor_On_Text_Area() {
		if(btnLang.getText() == "EN") {
			textArea.setText(
					"****************************************RESTAURANT***********************************\n\n"
							+ "Time: " + timeLabel.getText() + " Date: " + dateLabel.getText()
							+ "\n********************************************************************************************\n\n" +
							"      Item Name " + "\t\t" + "Price\n");
		}else {
			textArea.setText(
					"****************************************NHÀ   HÀNG*************************************\n\n"
							+ "Thời gian: " + timeLabel.getText() + " Ngày: " + dateLabel.getText()
							+ "\n********************************************************************************************\n\n" +
							"      Món ăn " + "\t\t" + "Giá\n");
		}
		
	}
	void setLanguage() {
		if(btnLang.getText() == "EN") {
			btnLang.setText("VI");
			this.setTitle("Đặt món");
			
			lblFriedChickenText.setText("Gà Rán");
			lblPhoText.setText("Phở");
			lblComTamText.setText("Cơm Tấm");
			lblBanhXeoText.setText("Bánh Xèo");
			lblBanhKhotText.setText("Bánh Khọt");
			lblLauHaiSanText.setText("Lẩu Hải Sản");
			
			lblFriedChickenPriceText.setText("Giá");
			lblPhoPriceText.setText("Giá");
			lblComTamPriceText.setText("Giá");
			lblBanhXeoPriceText.setText("Giá");
			lblBanhKhotPriceText.setText("Giá");
			lblLauHaiSanPriceText.setText("Giá");
			
			lblFriedChickenQuantityText.setText("Số lượng");
			lblPhoQuantityText.setText("Số lượng");
			lblComTamQuantityText.setText("Số lượng");
			lblBanhXeoQuantityText.setText("Số lượng");
			lblBanhKhotQuantityText.setText("Số lượng");
			lblLauHaiSanQuantityText.setText("Số lượng");
			
			btnBuyFriedChicken.setText("Mua");
			btnBuyPho.setText("Mua");
			btnBuyComTam.setText("Mua");
			btnBuyBanhXeo.setText("Mua");
			btnBuyBanhKhot.setText("Mua");
			btnBuyLauHaiSan.setText("Mua");
			
			lblTotal.setText("Tổng cộng");
			btnTotal.setText("Tính tổng");
			btnReset.setText("Làm lại");
			btnPrintReceipt.setText("In hóa đơn");
			btnHome.setText("Trang chủ");
			
		}else{
			btnLang.setText("EN");
			this.setTitle("Order Food");
			
			lblFriedChickenText.setText("Fried Chicken");
			lblPhoText.setText("Pho");
			lblComTamText.setText("Com Tam");
			lblBanhXeoText.setText("Banh Xeo");
			lblBanhKhotText.setText("Banh Khot");
			lblLauHaiSanText.setText("Lau Hai San");
			
			lblFriedChickenPriceText.setText("Price");
			lblPhoPriceText.setText("Price");
			lblComTamPriceText.setText("Price");
			lblBanhXeoPriceText.setText("Price");
			lblBanhKhotPriceText.setText("Price");
			lblLauHaiSanPriceText.setText("Price");
			
			lblFriedChickenQuantityText.setText("Quantity");
			lblPhoQuantityText.setText("Quantity");
			lblComTamQuantityText.setText("Quantity");
			lblBanhXeoQuantityText.setText("Quantity");
			lblBanhKhotQuantityText.setText("Quantity");
			lblLauHaiSanQuantityText.setText("Quantity");
			
			btnBuyFriedChicken.setText("Purchase");
			btnBuyPho.setText("Purchase");
			btnBuyComTam.setText("Purchase");
			btnBuyBanhXeo.setText("Purchase");
			btnBuyBanhKhot.setText("Purchase");
			btnBuyLauHaiSan.setText("Purchase");
			
			lblTotal.setText("Total");
			btnTotal.setText("Total");
			btnReset.setText("Reset");
			btnPrintReceipt.setText("Print Receipt");
			btnHome.setText("Home");
		}
	}
	void setDisplay() throws IOException{
		String displayName = NewUser.readDisplay();
		if(displayName != "") {
			//TH: nếu đã Sign in
			changeVietHome();
			newHomePage.lblHelloUser.setText(displayName);
			newHomePage.btnSignIn.setVisible(false);
			newHomePage.btnSignUp.setVisible(false);
			newHomePage.btnSignOut.setVisible(true);
			newHomePage.btnOrder.setVisible(true);
			newHomePage.lblUserIcon.setVisible(true);
			newHomePage.setVisible(true);
			dispose();
		}else {
			//TH: nếu chưa Sign in
			changeVietHome();
			newHomePage.lblUserIcon.setVisible(false);
			newHomePage.btnSignIn.setVisible(true);
			newHomePage.btnSignUp.setVisible(true);
			newHomePage.setVisible(true);
			dispose();
		}
	}
	void changeVietHome() {
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
	void handleBuy(JSpinner quantitySpinner, JLabel priceLabel) {
		int quantity = Integer.parseInt(quantitySpinner.getValue().toString());
		if(quantityIsZero(quantity)) {
			x++;
			if(x == 1) {
				display_Infor_On_Text_Area();
			}
			double price = (double) quantity * 50;
			total += price;
			textArea.setText(textArea.getText() + x + " .  " + priceLabel.getText() + "\t\t" + price + "\n");
		printCurrentTotal();
		}
	}
	public void setTime() {
		clockTimer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				time = timeFormat.format(Calendar.getInstance().getTime());
				timeLabel.setText(time);

				date = dateFormat.format(Calendar.getInstance().getTime());
				dateLabel.setText(date);
			}
		});
		clockTimer.start();
	}
}
