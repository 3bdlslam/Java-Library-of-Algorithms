public class QuickFindUF
{
	private int[] id;
	
	public QuickFindUF(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++)
		id[i] = i;
	}
	
	public boolean connected(int p, int q)
	{ return id[p] == id[q]; }
	
	public void union(int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++)
		if (id[i] == pid) id[i] = qid;
	}
}


public class QuickUnionUF
{
	private int[] id;
	
	public QuickUnionUF(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
	}
	
	private int root(int i)
	{
		while (i != id[i]) i = id[i];
		return i;
	}
	
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
}






public class WeightedQuickUnionUF
{
	private int[] id;
	private int[] sz;
	private int count;
	
	public WeightedQuickUnionUF(int N)
	{
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
		for (int i = 0; i < N; i++) sz[i] = 1; 
	}
	
	private int root(int i)
	{
		while (i != id[i]) 
		{  
			id[i] = id[id[i]];  // Path compression
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		if (i == j) return;
		if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; } 
		else { id[j] = i; sz[i] += sz[j]; } 
	}
}