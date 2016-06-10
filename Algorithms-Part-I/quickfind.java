//quick find implementation

//java scanner for input data from keyboard
import java.util.Scanner;

//perform union operations between pairs (connect pairs) in a given set of integers, check for connections between them
public class quickfind 
{
	//declare id array
	private int[] id;
	
	//constructor - initialize id array - integers --> (0 - id_size)
	public quickfind(int id_size)
	{
		id=new int[id_size];
		for(int id_value=0;id_value<id_size; id_value++)
			id[id_value]=id_value;
	}
	
	//method - union
	//inputs: array indices (int) on which to perform union operation
	//outputs: none
	public void union(int index1, int index2)
	{
		 //store id[index2] in temp variable to maintain it constant
		 //only id[index1] must be changed as per the algo
		 int temp2=id[index2];
		 
		 //change all id entries with value = id[index2], to id[index1], to connect them
		 for(int i=0; i<id.length;i++)
			 if(id[i]==id[index1])
				 id[index1]=temp2;
	}
	
	public boolean connected(int index1, int index2)
	{
		return (id[index1]==id[index2]);
	}
	
	//main function
	public static void main(String[] args)
	{

		//declare a new scanner to get input from the user
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the number of elements in the id array : ");
	    int id_size = keyboard.nextInt();
		
		//create an object for the class quickfind
		quickfind obj1=new quickfind(id_size);
		
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
					obj1.union(index1,index2);
				}
				
				else if(choice2=='C')
				{
					boolean conn=obj1.connected(index1, index2);
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
