package helpers;


import java.io.Serializable;  
  
import com.google.gson.annotations.Expose;  
/** 
 * ʹ�� new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
 * ����Gson����,û��@Exposeע�͵����Խ����ᱻ���л� 
 * serialize���л� Ĭ�� true 
 * deserialize�����л� Ĭ�� true 
 * 
 */  
public class Address implements Serializable{  
    @Expose(serialize=false)// ���л�  /���Ѿ����л�  
    private String streetNumber;  
    @Expose(deserialize=false)// �����л�  
    private String street;  
    private String district;  
    private String city;  
    private String province;  
    private String cityCode;  
    public String getCityCode() {  
        return cityCode;  
    }  
    public void setCityCode(String cityCode) {  
        this.cityCode = cityCode;  
    }  
    public String getStreetNumber() {  
        return streetNumber;  
    }  
    public void setStreetNumber(String streetNumber) {  
        this.streetNumber = streetNumber;  
    }  
    public String getStreet() {  
        return street;  
    }  
    public void setStreet(String street) {  
        this.street = street;  
    }  
    public String getDistrict() {  
        return district;  
    }  
    public void setDistrict(String district) {  
        this.district = district;  
    }  
    public String getCity() {  
        return city;  
    }  
    public void setCity(String city) {  
        this.city = city;  
    }  
    public String getProvince() {  
        return province;  
    }  
    public void setProvince(String province) {  
        this.province = province;  
    }  
      
}  