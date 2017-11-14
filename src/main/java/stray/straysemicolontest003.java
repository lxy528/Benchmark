package stray;

public class straysemicolontest003 {
	void insertion_sort(int array[],int first,int last)
	{
		int i,j;
		int temp;
		for(i=first+1;i<last;i++)
		{
			temp=array[i];
			j=i-1;
			//与已排序的数逐一比较，大于temp时，该数移后
			while((j>=0)&&(array[j]>temp));
			{
			array[j+1]=array[j];
			j--;
			}
			//存在大于temp的数
			if(j!=i-1);
			{array[j+1]=temp;}
		}
	}
}
