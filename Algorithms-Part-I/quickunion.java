import java.util.Scanner;

//quick union implementation
public class quickunion 
{
	//declare id array
	private int[] id;
	
	//constructor - assign values ti id array
	public quickunion(int id_size)
	{
		id=new int[id_size];
		for(int i=0;i<id_size;i++)
			id[i]=i;
	}
	
	//method - root - find the root of an index in the array
	//inputs - index to find its root - int
	//output - root of the index - int
	public int root(int index)
	{
		while(index!=id[index])
			index=id[index];
		return index;
	}
	
	//method - union
	//inputs: array indices (int) on which to perform union operation
	//outputs: none
	public void union(int index1, int index2)
	{
		id[root(index1)]=id[index2];
	}
	
	//method - connected
	//inputs - 2 indices - int
	//outputs - boolean
	public boolean connected(int index1, int index2)
	{
		return root(index1)==root(index2);
	}
	
	//main function
	public static void main(String[] args)
	{
		//declare a new scanner to get input from the user
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the number of elements in the id array : ");
	    int id_size = keyboard.nextInt();
		
		//create an object for the class quickunion
		quickunion object=new quickunion(id_size);
		
		//get the choice of operations from the user
		System.out.print("\n Would you like to perform an operation? Enter 'Y' if yes, 'N' to exit : ");
		char choice1 = keyboard.next().charAt(0);
		
		while(choice1!='N')
		{
			if(choice1=='Y')
			{
				//U: perform union
				//C: check if connected
				System.out.print("\n Enter 'U' to perform a union operation and 'C' to check if connected : ");	
				char choice2 = keyboard.next().charAt(0);
				
				//get 2 indices from the user
				System.out.print("\n Enter index1 : ");
			    int index1 = keyboard.nextInt();
			    System.out.print("Enter index2 : ");
			    int index2 = keyboard.nextInt();
			    
				if(choice2=='U')
				{
					object.union(index1,index2);
				}
				
				else if(choice2=='C')
				{
					boolean conn=object.connected(index1, index2);
					if(conn==true)
						System.out.print("\n The 2 elements are connected");
					else
						System.out.print("\n The 2 elements are NOT connected");	
				}
			}
			System.out.print("\n Would you like to perform another operation? Enter 'Y' if yes, 'N' to exit : ");
			choice1 = keyboard.next().charAt(0);
		}
		System.exit(0);
	}
}
