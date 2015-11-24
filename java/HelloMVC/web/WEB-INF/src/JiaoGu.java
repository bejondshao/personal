/**
 * Created by bejond on 15-11-24.
 */
public class JiaoGu {
	public static void main(String[] args) {
		System.out.println(add(2));
	}

	 static int add(int n)
	{

		if(n==1)
		{
			return 1;
		}
		if((n & 1)==1)
		{
			return add(n*3+1)+1;
		}
		else
		{
			return add(n/2)+1;
		}
	}
}
