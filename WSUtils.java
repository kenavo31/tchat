package monPackage;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class WSUtils {

	public static void main(String[] args) {

		MessageBean messageBean = new MessageBean("j'ai vu le film avenger");
		try {
			sendMessage(messageBean);
			for (MessageBean message : recoverMsg()) {
				System.out.println(message.getContenu());
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static final String URL = "http://192.168.20.5:8080/TchatServer/rest/monService";

////Methode test pour envoyer au serveur//////////////////

	public static void testWS() throws Exception {

		String stringRecu = OkHttpUtils.sendGetOkHttpRequest(URL + "/helloWorld");
		System.out.println(stringRecu);
	}

////Envoyer un message au serveur//////////////
	private static final Gson GSON = new Gson();

	public static void sendMessage(MessageBean messageBean) throws Exception {
		String json = GSON.toJson(messageBean);

		OkHttpUtils.sendPostOkHttpRequest(URL + "/envoieMsg", json);

	}

//////Envoyer une arraylist message au serveur////////

	public static ArrayList<MessageBean> recoverMsg() throws Exception {

		Gson gson = new Gson();
		String jsonRecu = OkHttpUtils.sendPostOkHttpRequest(URL + "/recupMsg", "");

		ArrayList<MessageBean> list = gson.fromJson((jsonRecu), new TypeToken<ArrayList<MessageBean>>() {
		}.getType());

		return list;

	}

}
