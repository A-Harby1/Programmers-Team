import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class User_Account_gui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public User_Account_gui(Posts ob,String Username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Account_gui frame = new User_Account_gui(ob,Username,1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public User_Account_gui(Posts ob,String Username,int x) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Write post");
		lblNewLabel.setBounds(10, 10, 67, 69);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(81, 10, 331, 69);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(81, 90, 116, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Post");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ob.set_post(textArea.getText());
				ob.set_postDate(textField.getText());
				ob.set_userName(Username);
				Posts_Database pd = new Posts_Database();
				pd.save_post(ob.get_post(), ob.get_userName(), ob.get_postDate());
			}
		});

		Posts_Database pd = new Posts_Database();
		pd.get_posts();
		
		btnNewButton.setBounds(222, 90, 190, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 90, 67, 23);
		contentPane.add(lblDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 402, 146);
		contentPane.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea(pd.posts);
		scrollPane.setViewportView(textArea_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 128, 202, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(222, 127, 190, 23);
		contentPane.add(btnNewButton_1);

	}
}
