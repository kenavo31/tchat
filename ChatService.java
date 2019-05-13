package monPackage;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/monService")
public class ChatService {

	public static ArrayList<MessageBean> miaou = new ArrayList<>();

	public static void main(String[] args) {

	}

	// http://localhost:8080/TchatServer/rest/monService/helloWorld
	// http://192.168.20.5:8080/TchatServer/rest/monService/helloWorld
	@Path("/helloWorld")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		System.out.println("Hello World!!");
		return "Hello World!";
	}

	// http://192.168.20.5:8080/TchatServer/rest/monService/envoieMsg

	@POST
	@Path("/envoieMsg")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendMsg(String recu) {
		System.out.println("/envoieMsg \njson:" + recu);

		try {
			Gson gson = new Gson();
			MessageBean msg = gson.fromJson(recu, MessageBean.class);
			BddUtils.insertMsg(msg);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(583).entity(e.getMessage()).build();
		}

	}

	// http://192.168.20.5:8080/TchatServer/rest/monService/recupMsg
	@Path("/recupMsg")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public static Response recupMsg() {

		try {
			Gson gson = new Gson();
			return Response.status(200).entity(gson.toJson(BddUtils.requestMsg())).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(583).entity(e.getMessage()).build();
		}
	}

}
