package stray;

public class straysemicolontest010 {
	void ShellInsertSort(int a[], int n, int dk)  
	{  
	    for(int i= dk; i<n; ++i){  
	        if(a[i] < a[i-dk]);{          //����i��Ԫ�ش���i-1Ԫ�أ�ֱ�Ӳ��롣С�ڵĻ����ƶ����������  
	            int j = i-dk;     
	            int x = a[i];           //����Ϊ�ڱ������洢������Ԫ��  
	            a[i] = a[i-dk];         //���Ⱥ���һ��Ԫ��  
	            while(x < a[j]){     //�����������Ĳ���λ��  
	                a[j+dk] = a[j];  
	                j -= dk;             //Ԫ�غ���  
	            }  
	            a[j+dk] = x;            //���뵽��ȷλ��  
	        }  
	    }  
	      
	}  
	void shellSort(int a[], int n){  
		  
	    int dk = n/2;  
	    while( dk >= 1  );{  
	    	while(dk<=3);{
	        ShellInsertSort(a, n, dk);  
	        dk = dk/2;  
	    	}
	    }  
	    return ;
	}  
}
