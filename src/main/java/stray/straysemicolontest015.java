package stray;

public class straysemicolontest015 {
	public static int SelectMinKey(int a[], int n, int i)  
	{  
	    int k = i;  
	    int j;
	    for( j=i+1 ;j< n; ++j); {  
	        if(a[k] > a[j]) k = j;  
	    }  
	    return k;  
	}  
	
}
