package monPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MessagerieIHM {

	JFrame frame;
	private JTextField textFieldMsg;
	private JButton btnRafraichir, btnEnvoyer;
	private Controler controler;
	private JTextPane textPane;

	// ----------------
	// Constructor
	// ------------------

	public MessagerieIHM() {
		initialize();
	}

	// ------------------------------------------
	// Initialize the contents of the frame.
	// ------------------------------------------

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnRafraichir = new JButton("Rafraichir");
		btnRafraichir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controler.clicBtnRefresh();
			}
		});
		btnRafraichir.setBounds(335, 270, 89, 23);
		frame.getContentPane().add(btnRafraichir);

		btnEnvoyer = new JButton("envoyer");
		btnEnvoyer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String messageEnvoyer = textFieldMsg.getText();
				controler.clicBtnEnvoyer(messageEnvoyer);
			}
		});
		btnEnvoyer.setBounds(335, 304, 89, 23);
		frame.getContentPane().add(btnEnvoyer);

		textFieldMsg = new JTextField();
		textFieldMsg.setBounds(10, 287, 315, 45);
		frame.getContentPane().add(textFieldMsg);
		textFieldMsg.setColumns(10);

		textPane = new JTextPane();
		textPane.setBounds(10, 11, 414, 248);
		frame.getContentPane().add(textPane);

	}

	// -----------------------------------------
	// Methode pour mettre à jour les données
	// -----------------------------------------

	public void majUser(String nom) {

	}

	public void majTextField(String message) {
		textFieldMsg.setText(message);

	}

//Mise a jour des messages en parcourant la liste  ////////////////////////////////
	public void majListeMsg(ArrayList<MessageBean> list) {
		String string = "<html>";
		textPane.setContentType("text/html");
		for (MessageBean messageBean : list) {
			string = string + messageBean.getContenu() + "<br>";
		}
		textPane.setText(string + "</html>");
	}

	public void updateMsgErr(String err) {

	}

	// -------------------------
	// Getter & Setter
	// -------------------------
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnRafraichir() {
		return btnRafraichir;
	}

	public void setBtnRafraichir(JButton btnRafraichir) {
		this.btnRafraichir = btnRafraichir;
	}

	public JButton getBtnEnvoyer() {
		return btnEnvoyer;
	}

	public void setBtnEnvoyer(JButton btnEnvoyer) {
		this.btnEnvoyer = btnEnvoyer;
	}

	public Controler getControler() {
		return controler;
	}

	public void setControler(Controler controler) {
		this.controler = controler;
	}

}