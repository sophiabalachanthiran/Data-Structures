public class BSTNode {
	StudentRecord data;
	protected BSTNode right;
	protected BSTNode left;
	
	public BSTNode(StudentRecord data)
	{
		this.data = data;
		right = null;
		left = null;
	}
	
	public void setData(StudentRecord data)
	{
		this.data = data;
	}
	
	public void setRight(BSTNode right)
	{
		this.right = right;
	}
	
	public void setLeft(BSTNode left)
	{
		this.left = left;
	}
	
	public Student getData()
	{
		return this.data;
	}
	
	public BSTNode getRight()
	{
		return this.right;
	}
	
	public BSTNode getLeft()
	{
		return this.left;
	}
	
	public String toString()
	{
		return data.toString();
	}
}