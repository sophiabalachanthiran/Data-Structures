public class BinarySearchTree {
	
	private BSTNode root;
	private int size = 0;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public StudentRecord findMax(BSTNode t)
	{
		if(isEmpty())
		{
			System.out.println("Empty.");
		}
		
		while(t.right != null)
		{
			t = t.right;
		}
		
		return t.data;
	}
	
	public StudentRecord findMin(BSTNode t)
	{
		if(isEmpty())
		{
			System.out.println("Empty.");
		}
		
		while(t.left != null)
		{
			t =t.left;
		}
		
		return t.data;
	}
	
	public void delete(StudentRecord x)
	{
		if(isEmpty())
		{
			System.out.println("Empty.");
			
		}
		
		root = delete(x, root);
	}
	
	private BSTNode delete(StudentRecord x, BSTNode t)
	{
		if(t == null)
		{
			return t;
		}
		
		if(x.compareTo(t.data) < 0)
		{
			delete(x, t.left);
		}
		
		else if(x.compareTo(t.data) > 0)
		{
			delete(x, t.right);
		}
		
		else
		{
			if(t.right == null)
			{
				size--;
				return t.left;
			}
			
			else if(t.left == null)
			{
				size--;
				return t.right;
			}
			
			t.data = findMax(t.left);
			t.left = delete(t.data, t.left);
		}
		
		size--;
		
		return t;
	}
	
	public StudentRecord search(StudentRecord x)
	{
		if(isEmpty())
		{
			System.out.println("Empty.");
		}
		
		return search(x, root);
	}
	
	private StudentRecord search(StudentRecord x, BSTNode t)
	{
		if(t == null)
		{
			System.out.println("Student not found.");
			return null;
		}
		
		if(x.compareTo(t.data) < 0)
		{
			return search(x, t.left);
		}
		
		if(x.compareTo(t.data) > 0)
		{
			return search(x, t.right);
		}
		
		return t.data;
	}
	
	public void insertSort(StudentRecord x)
	{
		if(isEmpty())
		{
			root = new BSTNode(x);
			size++;
		}
		
		insertSort(x, root);
	}
	
	private void insertSort(StudentRecord x, BSTNode t)
	{
		if(t != null)
		{
			if(x.compareTo(t.data) < 0)
			{
				if(t.left == null)
				{
					t.left = new BSTNode(x);
					size++;
				}
				else
				{
					insertSort(x, t.left);
				}
			}
			
			else if(x.compareTo(t.data) > 0)
			{
				if(t.right == null)
				{
					t.right = new BSTNode(x);
					size++;
				}
				else
				{
					insertSort(x, t.right);
				}
			}
			
			else {
				System.out.println("Student: " + x + " is in roster.");
			}
		}
	}
}
