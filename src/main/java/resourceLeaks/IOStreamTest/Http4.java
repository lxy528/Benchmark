package resourceLeaks.IOStreamTest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Http4 {
	public static HttpResponse pass(HttpClient httpClient,HttpGet httpGet) throws  IOException{
		HttpResponse response =	httpClient.execute(httpGet);
		return response;
	}
	public static void http() throws IOException{
		 HttpClient httpclient = new DefaultHttpClient();
		    // 创建Get方法实例   
	     HttpGet httpgets = new HttpGet("http://127.0.0.1/");  
	    //HttpResponse response = httpclient.execute(httpgets); 
		//HttpClient client = new HttpClient();  
		//HttpMethod method = new GetMethod("http://www.apache.org");   
	     
	     HttpResponse response=	pass(httpclient,httpgets);
	     System.out.println(response.toString());
	  //   httpgets.releaseConnection();  
	}
	
}
