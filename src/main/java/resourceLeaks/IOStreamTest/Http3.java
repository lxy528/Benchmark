package resourceLeaks.IOStreamTest;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Http3 {
	HttpClient httpClient;
	public void Http3() {
		httpClient= new DefaultHttpClient();
	}
	public static  void setDefaultHeaders(HttpGet a) {
		
	}
	
	private void doQuery(String url) throws ClientProtocolException, IOException {

		  HttpGet httpGet = new HttpGet(url);
		  setDefaultHeaders(httpGet); // static method
		  HttpResponse response = httpClient.execute(httpGet);   // httpClient instantiated in constructor

		  int rc = response.getStatusLine().getStatusCode();

		  if (rc != 200) {
		    // some stuff...
			  System.out.println(""); 
		  }

		  HttpEntity entity = response.getEntity();

		  if (entity == null) {
			  System.out.println(""); 
		  }
		
		  // process the entity, get input stream etc
		  
		}
}
