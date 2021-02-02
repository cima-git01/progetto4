package com.Parmodmall;
import java.net.*;
import java.util.*;
import java.io.*;

public class ServerPuntiDiVerifica {
	protected List<PuntoDiVerifica> elencoPuntiDiVerifica;
	
	public ServerPuntiDiVerifica()
	{
		ServerSocket sSocket;
		Socket connessione = null;
		int port = 2345;
		
		elencoPuntiDiVerifica = new ArrayList<PuntoDiVerifica>();
		
		try
		{
			sSocket = new ServerSocket(port);
			System.out.println("in attesa di connessioni...");
			
			//ciclo infinito
			while(true)
			{
				connessione = sSocket.accept();
				new ConnessioneClient(connessione,this);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		try
		{
			connessione.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	public static void main()
	{
		new ServerPuntiDiVerifica();
		System.out.println("uscita");
	}

}
