package helpers;


import java.io.Serializable;  
  
import com.google.gson.annotations.Expose;  
/** 
 * 使用 new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
 * 创建Gson对象,没有@Expose注释的属性将不会被序列化 
 * serialize序列化 默认 true 
 * deserialize反序列化 默认 true 
 * 
 */  
public class Address implements Serializable{  
    @Expose(serialize=false)// 序列化  /类已经序列化  
    private String streetNumber;  
    @Expose(deserialize=false)// 反序列化  
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