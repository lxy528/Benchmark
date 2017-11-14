package stray;

public class straysemicolontest005 {
	public static void foo(int a ){
		if(a>0)
		{
			while(a!=0);
			{
				a--;
			}
		}
		else
		{
			a=-a;
		}
	}
}
