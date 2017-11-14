package resourceLeaks.IOStreamTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentHashMap;

public class Sockettest {
	private String serverIp="127.0.0.1";  
    private int port=8080;  
    private boolean running=false;  
    private long lastSendTime;  
    //private ConcurrentHashMap<Class, ObjectAction> actionMapping = new ConcurrentHashMap<Class,ObjectAction>();  
		
    public void start() throws UnknownHostException, IOException {
			if(running)return;
			Socket socket = new Socket(serverIp,port);
			System.out.println("±¾µØ¶Ë¿Ú£º"+socket.getLocalPort());
			lastSendTime=System.currentTimeMillis();
			running=true;
			System.out.println(lastSendTime);
			//socket.close();
		}
		
		
	}
