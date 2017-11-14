package resourceLeaks.IOStreamTest;

import java.io.*;
import java.net.*;
import java.util.*;

public class Sockettest3 {
  boolean started = false;
  ServerSocket ss = null;
  List<Client> clients = new ArrayList<Client>();

  public static void main(String[] args) {
    new Sockettest3().start();
  }
 
  public void start() {
    try {
      ss = new ServerSocket(8888);
      started = true;
      System.out.println("�˿��ѿ���,ռ��8888�˿ں�....");
    } catch (RuntimeException e) {
      System.out.println("�˿�ʹ����....");
      System.out.println("��ص���س����������з�������");
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      while (started) {
        Socket s = ss.accept();
        Client c = new Client(s);
        System.out.println("a client connected!");
        new Thread(c).start();
        clients.add(c);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        ss.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  public static void  close(DataInputStream dis,DataOutputStream dos,Socket s){
	  try {
          if (dis != null)
            dis.close();
          if (dos != null)
           // dos.close();
          if (s != null) {
          //   s.close();
          }

        } catch (IOException e1) {
          e1.printStackTrace();
        }
  }
  class Client implements Runnable {
    private Socket s;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    private boolean bConnected = false;

    public Client(Socket s) {
      this.s = s;
      try {
        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());
        bConnected = true;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void send(String str) {
      try {
        dos.writeUTF(str);
      } catch (IOException e) {
        clients.remove(this);
        System.out.println("�Է��˳��ˣ��Ҵ�List����ȥ���ˣ�");
      }
    }

    public void run() {
      try {
        while (bConnected) {
          String str = dis.readUTF();
          System.out.println("------------���Ա��ط�����:" + str);
          for (int i = 0; i < clients.size(); i++) {
            Client c = clients.get(i);
            c.send(str);
          }
        }
      } catch (EOFException e) {
        System.out.println("Client closed!");
      } catch (IOException e) {
        e.printStackTrace();
      } 
      close(dis,dos,s);
    }
  }
}
