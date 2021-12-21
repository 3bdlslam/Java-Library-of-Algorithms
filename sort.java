public class Date implements Comparable<Date>
{ 
	public int compareTo(Date that)
	{
		if (this.year < that.year ) return -1;
		if (this.year > that.year ) return +1;
		if (this.month < that.month) return -1;
		if (this.month > that.month) return +1;
		if (this.day < that.day ) return -1;
		if (this.day > that.day ) return +1;
		return 0;
	}


}

public class Date implements Comparable<Date>
{
 private final int month, day, year;
 public Date(int m, int d, int y)
 {
 month = m; 
 day = d;
 year = y;
 }
 …
 public int compareTo(Date that)
 {
 if (this.year < that.year ) return -1;
 if (this.year > that.year ) return +1;
 if (this.month < that.month) return -1;
 if (this.month > that.month) return +1;
 if (this.day < that.day ) return -1;
 if (this.day > that.day ) return +1;
 return 0;
 }
}

public class Sorting 
{
	//Two useful sorting abstractions
	
	private static boolean less(Comparable v, Comparable w)
	{ 
		return v.compareTo(w) < 0; 
	}

	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static boolean isSorted(Comparable[] a)
	{
		for (int i = 1; i < a.length; i++)
		if (less(a[i], a[i-1])) return false;
		return true;
	}
	
	private static boolean isSorted(Comparable[] a, int lo, int hi)
	{
		for (int i = lo+1; i <= hi; i++)
		if (less(a[i], a[i-1])) return false;
		return true;
	}
	
}

public class Selection extends Sorting 
{
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		for (int i = 0; i < N; i++)
		{
			int min = i;
			for (int j = i+1; j < N; j++)
			if (less(a[j], a[min]))
			min = j;
			exch(a, i, min);
		}
	}


}


public class Insertion extends Sorting 
{
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0; j--)
				if (less(a[j], a[j-1]))
					exch(a, j, j-1);
				else break;
	}	
	
	public static void sort(Comparable[] a, int st, int end)
	{
		int N = a.length;
		for (int i = st; i < end+1; i++)
			for (int j = i; j > st; j--)
				if (less(a[j], a[j-1]))
					exch(a, j, j-1);
				else break;
	}
}


	
public class Shell extends Sorting
{
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		int h = 1; 
		while (h < N/3) h = 3*h + 1;
			while (h >= 1)
			{
				for (int i = h; i < N; i++)
				{
					for (int j = i; j > h && less(a[j], a[j-h]); j -= h)
						exch(a, j, j-h);
				}
				h = h/3;
			}
	}
}




public class Merge extends Sorting
{
	private const CUTOFF=7;
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		
		/*	eleminated by modification 3
		for(int k=lo; k<= hi; K++)
		{
			aux[k] = a[k];
		}*/ 
		
		int i =lo, j=mid+1;
		for(int k=lo; k<= hi; K++)
		{
			if(i > mid) 					a[k]=aux[j++];
			else if(j > hi) 				a[k]=aux[i++];
			else if(less(aux[j],aux[i]))	a[k]=aux[j++];
			else 							a[k]=aux[i++];
		}
		
		assert isSorted(a, lo, hi);
	}
	
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if(hi<=lo+CUTOFF-1)					// modification 1: Cutoff to insrtion to avoid memory coast
		{
			Insertion.sort(a, lo, hi);
			return;
		}
		int mid =lo+((hi-lo)/2);
		sort(aux, a, lo, mid);				// modification 3: elemenate copy by swich roles
		sort(aux, a, mid+1, hi);
		if(less(a[mid], a[mid+1]))	return;	// modification 2: erturn if the half is already sorted
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a)
	{
		 aux = new Comparable[a.length];
		 sort(a, aux, 0, a.length - 1);
	}
}


public class MergeBU extends Merge
{
	public static void sortTypical(Comparable[] a)
	{
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz+sz)
		for (int lo = 0; lo < N-sz; lo += sz+sz)
			merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
	}
	
	public static void sort(comparable [] a)
	{
		int N = a.length();
		boolean switchRoles = false;
		comparable[] aux = new comparable[N];
		for(int sz=Math.min(6,N-1); sz<N; sz+=sz)
			for(int lo=0,hi; lo<N-sz; lo+=sz+sz)
			{	
				hi=Math.min(lo+sz+sz-1,N-1);
				if(sz < 7)
				{
					Insertion.sort(a, lo ,hi);
				}
				else if (switchRoles)
				{
					merge(aux, a, lo, lo+sz-1, hi);
				}	
				else
				{
					merge(a, aux, lo, lo+sz-1, hi);
				}
			}
	}
	
} 

