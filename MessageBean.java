package monPackage;

public class MessageBean {

	private long id;
	private int date;
	private String contenu;
	private UserBean user;

//	public MessageBean(long id, int date, String contenu, UserBean user) {
//		super();
//		this.id = id;
//		this.date = date;
//		this.contenu = contenu;
//		this.user = user;
//	}

	public MessageBean(String contenu) {
		this.contenu = contenu;
	}

	public MessageBean() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

}