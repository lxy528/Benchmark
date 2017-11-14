package stray;

public class straysemicolontest004 {

	void Bubble_1 ( int r[], int n) {  
	    int i= n -1;  //初始时,最后位置保持不变  
	    while ( i> 0); {   
	        int pos= 0; //每趟开始时,无记录交换  
	        for (int j= 0; j< i; j++)  
	            if (r[j]> r[j+1]) {  
	                pos= j; //记录交换的位置   
	                int tmp = r[j]; r[j]=r[j+1];r[j+1]=tmp;  
	            }   
	        i= pos; //为下一趟排序作准备  
	     }   
	}  
}
