package stray;

public class straysemicolontest008 {
	void insertion_sort(int array[],int first,int last)
	{
		int i,j;
		int temp;
		for(i=first+1;i<last;i++)
		{
			temp=array[i];
			j=i-1;
			//�������������һ�Ƚϣ�����tempʱ�������ƺ�
			while((j>=0)&&(array[j]>temp))
			{
			array[j+1]=array[j];
			j--;
			}
			//���ڴ���temp����
			if(j!=i-1);
			{array[j+1]=temp;}
		}
	}
}
