/*********************************************************************************************************************
     **
     **  Heap Tree using Array 
     **  Both max heap and min heap is implemented
     **  Input in the form of array
     **  Output is printed in listed manner
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/


class Heap 
{
	int []heap;
	int capacity=10;
	int pos;

	//Heap class constructor
	public Heap()
	{

		heap=new int[capacity];
		pos=-1;

	}

	//main method
	public static void main(String[] args) 
	{

		int arr[]={50,45,35,33,16,25,34,12,10};

		// MAX HEAP 
		Heap max = new Heap();

		for(int i=0;i<arr.length;i++)
			max.maxHeapInsert(arr[i]);
		
		System.out.print("Max Heap : ");
		max.print();
		System.out.print("After deletetion Max Heap : ");
		max.maxDelete();
		max.print();

		// MIN HEAP 
		Heap min = new Heap();

		for(int i=0;i<arr.length;i++)
			min.minHeapInsert(arr[i]);

		System.out.print("\nMin Heap : ");
		min.print();
		System.out.print("After deletetion Min Heap : ");
		min.minDelete();
		min.print();
		
	}

	//function to delete maximum element form MAX HEAP
	private void maxDelete()
	{

		heap[0]=heap[pos];

		pos--;
		int parent=0;
		int left=1;
		int right=2;
		int last=pos;

		int larger= heap[left]>heap[right]?heap[left]:heap[right];
		
		while( left<pos && (larger>heap[parent]) )
		{
	
			if(heap[left]==larger)
			{
				swap(left,parent);
				parent=left;
				left=parent*2+1;
				right=parent*2+2;
			}
			else
			{
				swap(right,parent);
				parent=right;
				left=parent*2+1;
				right=parent*2+2;
			}
	
			if(left<pos)
			larger= heap[left]>heap[right]?heap[left]:heap[right];
			if(left==pos)
				larger=heap[left];
	
		}

	}

	//function to delete minimum element form MIN HEAP
	private void minDelete()
	{

		heap[0]=heap[pos];

		pos--;
		int parent=0;
		int left=1;
		int right=2;
		int last=pos;

		int smaller= heap[left]<heap[right]?heap[left]:heap[right];
		
		while( left<pos && (smaller<heap[parent]) )
		{
	
			if(heap[left]==smaller)
			{
				swap(left,parent);
				parent=left;
				left=parent*2+1;
				right=parent*2+2;
			}
			else
			{
				swap(right,parent);
				parent=right;
				left=parent*2+1;
				right=parent*2+2;
			}
	
			if(left<pos)
				smaller= heap[left]<heap[right]?heap[left]:heap[right];
			if(left==pos)
				smaller=heap[left];
	
		}

	}

	//function to insert element in MAX HEAP
	private void  maxHeapInsert(int data)
	{

		if(pos==capacity-1)
			System.out.println("Overflow");
		else
		{
			heap[++pos]=data;
			int child=pos;
			int parent=(child-1)/2;

			while( heap[parent]<heap[child] && parent>=0)
			{

				swap(child,parent);		
				child=parent;
				parent=(child-1)/2;
			}
		}

	}

	//function to insert element in MIN HEAP
	private void  minHeapInsert(int data)
	{

		if(pos==capacity-1)
			System.out.println("Overflow");
		else
		{
			heap[++pos]=data;
			int child=pos;
			int parent=(child-1)/2;

			while( heap[parent]>heap[child] && parent>=0)
			{

				swap(child,parent);		
				child=parent;
				parent=(child-1)/2;
			}
		}

	}

	//function to print element of heap
	private void  print()
	{

		for(int i=0;i<=pos;i++)
		{
			System.out.print(heap[i]+" ");
		}
		System.out.println();

	}

	//function to swap element
	private void swap(int child,int parent)
	{

		int tmp=heap[child];
		heap[child]=heap[parent];
		heap[parent]=tmp;

	}

}
