
	public static void sort(Comparable[] a, int st, int end)
	{
		int N = a.length;
		for (int i = st; i < end+1; i++)
			for (int j = i; j > st; j--)
				if (less(a[j], a[j-1]))
					exch(a, j, j-1);
				else break;
	}

// example of how to modify sorting code to work with compatator Instead of comparable 

public class Insertion
{
	public static void sort(Object[] a, Comparator comparator)
	{
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0 && less(comparator, a[j], a[j-1]); j--)
				exch(a, j, j-1);
	} 
	private static boolean less(Comparator c, Object v, Object w)
	{ return c.compare(v, w) < 0; }
	private static void exch(Object[] a, int i, int j)
	{ Object swap = a[i]; a[i] = a[j]; a[j] = swap; }
}



// 2 examples of classes has diffrent comparators implementation coul be used with sort


public class Student
{ 
	public static final Comparator<Student> BY_NAME = new ByName();
	public static final Comparator<Student> BY_SECTION = new BySection();
	private final String name;
	private final int section;

	//...
	
	private static class ByName implements Comparator<Student>
	{
		public int compare(Student v, Student w)
		{ return v.name.compareTo(w.name); }
	}
	private static class BySection implements Comparator<Student>
	{
		public int compare(Student v, Student w)
		{ return v.section - w.section; }
	}
}


  
public class Point2D
{
	public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
	private final double x, y;

	//	... 

	private static int ccw(Point2D a, Point2D b, Point2D c)
	{ /* as in previous lecture */ }
	
	private class PolarOrder implements Comparator<Point2D>
	{
		public int compare(Point2D q1, Point2D q2)
		{			
			double dy1 = q1.y - y;
			double dy2 = q2.y - y;
			if (dy1 == 0 && dy2 == 0) { ... }
			else if (dy1 >= 0 && dy2 < 0) return -1;
			else if (dy2 >= 0 && dy1 < 0) return +1;
			else return -ccw(Point2D.this, q1, q2);
		}
	}
}

