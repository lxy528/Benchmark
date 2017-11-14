package resourceLeaks.IOStreamTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Http
{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void http(){
		 HttpClient httpclient = new DefaultHttpClient();
		    // 创建Get方法实例   
	     HttpGet httpgets = new HttpGet("http://127.0.0.1/");  
	    //HttpResponse response = httpclient.execute(httpgets); 
		//HttpClient client = new HttpClient();  
		//HttpMethod method = new GetMethod("http://www.apache.org");   
	     try {
			HttpResponse response =	httpclient.execute(httpgets);
			System.out.println(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // httpgets.releaseConnection();  

	}
}