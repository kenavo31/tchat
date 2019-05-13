package monPackage;

import java.util.ArrayList;

public class Controler {

	// IHM
	private MessagerieIHM ihm;

	// --------------------
	// Constructeur
	// ------------------------
	public Controler() {
		super();
	}

	// -------------------
	// Methodes
	// -----------------
//////Methode pour Envoyer un message dans la BDD /////////////////////////////////////
	public void clicBtnEnvoyer(String message) {
		try {
			MessageBean messageBean = new MessageBean();
			messageBean.setContenu(message);
			WSUtils.sendMessage(messageBean);
			ihm.majTextField("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
////////Methode pour rafraichire et retourner less dernieres liste de message //////////////////////////////

	public void clicBtnRefresh() {
		try {
			// recupere mes donénes
			ArrayList<MessageBean> list = WSUtils.recoverMsg();
			// je les donne à l'ihm
			ihm.majListeMsg(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ihm.updateMsgErr("Une erreur est survenue : " + e.getMessage());

		}

	}

	// -------------------
	// Getter & Setter
	// -------------------

	public MessagerieIHM getIhm() {
		return ihm;
	}

	public void setIhm(MessagerieIHM ihm) {
		this.ihm = ihm;
	}

}
