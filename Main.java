package monPackage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessagerieIHM ihm = new MessagerieIHM();
		ihm.frame.setVisible(true);

		Controler controler = new Controler();

		controler.setIhm(ihm);
		ihm.setControler(controler);
	}

}
