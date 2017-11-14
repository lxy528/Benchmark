package resourceLeaks.IOStreamTest;
import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List;  
  
import net.sf.json.JSONArray;  
  
import helpers.Address;  
import com.google.gson.Gson;  
import com.google.gson.JsonArray;  
import com.google.gson.JsonElement;  
import com.google.gson.JsonObject;  
import com.google.gson.JsonParser;  
	  
	/** 
 *@DEMO:napp 
 *@Author:jilongliang 
 *@Date:2013-7-20 
 */  
public class Json {
    private static Gson gson=new Gson();  
    /** 
     * ͨ��JsonLib������ת����Json���� 
     * @param url 
     * @throws Exception 
     */  
    private static JSONArray getArrayToJsonByJsonLib()throws Exception  
    {  
        JSONArray jsonArr=null;  
        List<Address> lists=new ArrayList<Address>();  
        for (int i = 1; i <=12; i++) {  
            Address addr = new Address();   
            addr.setProvince("��"+i+"��ʡ��");  
            addr.setCity("��"+i+"������");  
            addr.setCityCode("130"+i);  
            addr.setStreet("�ֵ�"+i);  
            addr.setStreetNumber("�ֵ�����"+i);  
            lists.add(addr);  
        }  
        jsonArr = JSONArray.fromObject(lists);  //�Ѷ���ת����Json����  
        return jsonArr;  
    }  
      
    public static void main(String[] args)throws Exception{  
        getJsonGson();   
          
    }  
      
    /** 
     * ����Json-lib��װ����Json����,Gson����Json����. 
     * @throws Exception 
     */  
    private static void getJsonGson() throws Exception {  
        //Json-lib��JSONArray�������  
        JSONArray  JsonArray =getArrayToJsonByJsonLib();  
        String jsonData=JsonArray.toString();  
        /* 
         * �Լ���װ��һ��json��ʽ����ʽ����Ϊ{,,}����ΪJsonElement�����parse�����������Ƿ��� 
         * �ᱨ��com.google.gson.JsonSyntaxException: java.io.EOFException: End of input at line 1 column 1307 
         */  
        String json="{status:1,address:"+jsonData+"}";  
  
        // ����һ��JsonParser  
        JsonParser parser = new JsonParser();  
        JsonElement jsonEl = parser.parse(json);  
        JsonObject jsonObj = null;  
        jsonObj = jsonEl.getAsJsonObject();//ת����Json����  
        String status=jsonObj.get("status").getAsString();//status�ڵ�  
        System.out.println(status);  
          
        JsonElement addressEl=jsonObj.get("address");//address�ڵ�  
        if(addressEl.isJsonArray()){//�ж��Ƿ�ΪJson����  
            JsonArray jsonArray= addressEl.getAsJsonArray();//תΪ����  
            for(Iterator iter=jsonArray.iterator();iter.hasNext();){  
                JsonObject obj=(JsonObject) iter.next();  
                //String city=obj.get("city").getAsString();//����һ������key����ȡֵ  
                Address add=gson.fromJson(obj, Address.class);//�����������ʹ��Gsonȡ����  
                System.out.println(add.getProvince()+"\t"+add.getCity());  
	             }  
	        }  
	    }  
	       
	 
}
