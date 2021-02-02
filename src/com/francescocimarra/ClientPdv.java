package com.francescocimarra;

import java.net.*;
import java.io.*;

public class ClientPdv
{

	public static void main(String[] args)
	{
		Socket connessione = null;
		String server = "localhost";
		int port = 2345;
		InputStreamReader in, input;
		BufferedReader sIN, tastiera;
		OutputStream out;
		PrintWriter sOUT;
		String comandoDaInviare;
		String rispostaRicevuta;
		try 
		{
			connessione = new Socket(server, port);
			System.out.println("connessione eseguita.");
		}
		catch (IOException e)
		{
			System.out.println(e);
			System.exit(-1);
		}
		try 
		{
			
			in = new InputStreamReader (connessione.getInputStream());
			sIN = new BufferedReader(in);
			
			
			out = connessione.getOutputStream();
			sOUT = new PrintWriter(out);
			
			
			input = new InputStreamReader(System.in);
			tastiera = new BufferedReader(input);
			System.out.println("Servizio inizializzato");
			while (true)
			{
				
				System.out.println("immettere un comando (QUIT per uscire)");
				comandoDaInviare = tastiera.readLine();
				
				
				sOUT.println(comandoDaInviare);
				sOUT.flush();
				
				
				rispostaRicevuta = sIN.readLine();
				System.out.println("risposta: "+ rispostaRicevuta);
				
				if (comandoDaInviare.equals(Comando.QUIT));
					break;
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		
		try
		{
			connessione.close();
		}
		
		catch (IOException e)
		{
			System.out.println(e)
		}	
	}

}
