package monPackage;

import java.util.Scanner;

public class UserBean {

	// --------
	// attribut
	// --------

	private String nom;

	// -------
	// methode
	// -------

	public static String ecrire() {
		Scanner scan = new Scanner(System.in);
		System.out.println("entrer votre message");
		String contenu = scan.nextLine();
		scan.close();
		System.out.println(contenu);
		return contenu;
	}

	// -----------
	// constructor
	// -----------

	public UserBean(String nom) {
		super();
		this.nom = nom;
	}

	// -----------------
	// getter and setter
	// -----------------
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
