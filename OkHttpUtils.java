package monPackage;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

	//
	public static String sendGetOkHttpRequest(String url) throws Exception {
		System.out.println("Url : " + url);
		OkHttpClient client = new OkHttpClient();
		// Cr�ation de la requete
		Request request = new Request.Builder().url(url).build();
		// Execution de la requ�te
		Response response = client.newCall(request).execute();
		// Analyse du code retour
		if (response.code() == 583) {
			throw new Exception("R�ponse du serveur incorrect : " + response.body().string());
		} else if (response.code() < 200 || response.code() > 299) {
			throw new Exception("R�ponse du serveur incorrect : " + response.code());
		} else {
			// R�sultat de la requete.
			return response.body().string();
		}
	}

	public static String sendPostOkHttpRequest(String url, String paramJson) throws Exception {
		System.out.println("Url : " + url);
		OkHttpClient client = new OkHttpClient();
		MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		// Corps de la requ�te
		RequestBody body = RequestBody.create(JSON, paramJson);

		// Cr�ation de la requete
		Request request = new Request.Builder().url(url).post(body).build();
		// Execution de la requ�te
		Response response = client.newCall(request).execute();
		// Analyse du code retour
		if (response.code() == 583) {
			throw new Exception("R�ponse du serveur incorrect : " + response.body().string());
		} else if (response.code() < 200 || response.code() > 299) {
			throw new Exception("R�ponse du serveur incorrect : " + response.code());
		} else {
			// R�sultat de la requete.
			return response.body().string();
		}
	}

}
