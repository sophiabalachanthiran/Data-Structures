public class WaitingList {
	
	private int size = 5;
	private StudentRecord[] data = new StudentRecord[size];
	private int front = 0;
	private int rear = -1;
	private int count = 0;
	
	public boolean isEmpty()
	{
		return count == 0;
	}
	
	public void enqueue(StudentRecord stu)
	{
		if(count < size)
		{
			rear = (rear + 1) % size;
			data[rear] = stu;
			count++;
		}
	}
	
	public StudentRecord dequeue()
	{
		StudentRecord temp = data[front];
		front = (front -1) % size;
		count--;
		return temp;
	}
}