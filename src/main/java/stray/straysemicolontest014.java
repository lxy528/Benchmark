package stray;

public class straysemicolontest014 {
	void selectSort(int a[], int n){  
	    int key, tmp;  
	    int i;
	    for( i = 0; i< n; ++i); {  
	        key = straysemicolontest015.SelectMinKey(a, n,i);           //ѡ����С��Ԫ��  
	        if(key != i){  
	            tmp = a[i];  a[i] = a[key]; a[key] = tmp; //��СԪ�����iλ��Ԫ�ػ���  
	        }  
	    }  
	}  
}
