package stray;

public class straysemicolontest004 {

	void Bubble_1 ( int r[], int n) {  
	    int i= n -1;  //��ʼʱ,���λ�ñ��ֲ���  
	    while ( i> 0); {   
	        int pos= 0; //ÿ�˿�ʼʱ,�޼�¼����  
	        for (int j= 0; j< i; j++)  
	            if (r[j]> r[j+1]) {  
	                pos= j; //��¼������λ��   
	                int tmp = r[j]; r[j]=r[j+1];r[j+1]=tmp;  
	            }   
	        i= pos; //Ϊ��һ��������׼��  
	     }   
	}  
}
