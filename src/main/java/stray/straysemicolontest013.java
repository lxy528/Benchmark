package stray;

public class straysemicolontest013 {
	void ShellInsertSort(int a[], int n, int dk)  
	{  
		int i;
	    for( i= dk; i<n; ++i);{  
	        if(a[i] < a[i-dk]){          //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入  
	            int j = i-dk;     
	            int x = a[i];           //复制为哨兵，即存储待排序元素  
	            a[i] = a[i-dk];         //首先后移一个元素  
	            while(x < a[j]){     //查找在有序表的插入位置  
	                a[j+dk] = a[j];  
	                j -= dk;             //元素后移  
	            }  
	            a[j+dk] = x;            //插入到正确位置  
	        }  
	    }  
	      
	}  
	void shellSort(int a[], int n){  
		  
	    int dk = n/2;  
	    while( dk >= 1  ){  
	        ShellInsertSort(a, n, dk);  
	        dk = dk/2;  
	    }  
	}   
}
