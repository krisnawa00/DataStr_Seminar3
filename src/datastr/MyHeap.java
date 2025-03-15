package datastr;

public class MyHeap<Ttype> {
	//mainīgie
	private Ttype[] heap;
	private final int DEFAULT_SIZE = 10;
	private int size = DEFAULT_SIZE;
	private int counter = 0;
	
	//bezargumenta konstruktors
		public MyHeap() {
			heap = (Ttype[])new Object[size];
		}
		
		//argumenta konstruktors
		public MyHeap(int inputSize) {
			if(inputSize > 0) {
				size = inputSize;
			}
			
			heap = (Ttype[])new Object[size];	
		}
		
		public boolean isFull()
		{
			return (counter == size);
		}
		
		public boolean isEmpty() {
			return (counter == 0);
		}
		
		public int howManyElements() {
			return counter;
		}
		
		private void resize() {
			size = (counter < 100) ? size * 2 : (int)(size * 1.5);
			Ttype[] listNew = (Ttype[]) new Object[size];
			
			for(int i = 0; i < counter; i++) {
				listNew[i] = heap[i];
			}
			heap = listNew;
			System.gc();//izsaucam atkritumu savācēju, kas izdzēsīs mazā masīva elementus
			
		}
		
		public void enqueue (Ttype element) {
			if(isFull()) {
				resize();
			}
			
			heap[counter] = element;
			counter++;
			
			reheapUp(counter -1);
			
		}
		
		private void reheapUp(int currentChildIndex) {
			//kreisa berna index = vecaka index * 2 + 1
			//laba berna index = vecaka index * 2 + 2
			
			//vecaka index = (kreisa berna index - 1)/2
			//vecaka index = (laba berna index - 2)/2
			
			// ja berna index ir 6, tad veina gadijuma 2.5 un otra 2
			
			int currentParentIndex = (int)((currentChildIndex - 1)/2);
			
			if(currentParentIndex >= 0) {
			if(  ((Comparable)heap[currentParentIndex]).compareTo(heap[currentChildIndex]) == -1){
				swap(currentParentIndex,currentChildIndex);
				reheapUp(currentParentIndex);
			}
		}
			}

		private void swap(int index1, int index2) {
			Ttype temp = heap[index1];
			heap[index1] = heap[index2];
			heap[index2] = temp;	
		}
		
		public Ttype dequeue() throws Exception{
			if(isEmpty()) {
				throw new Exception("Kaudze ir tuksa");
			}
			Ttype maxElement = heap[0];
			
			heap[0] = heap[counter - 1];
			counter--;
			return maxElement;
		}
		private void reheapDown (int currentParentIndex) {
			int currentLeftChildIndex = currentParentIndex * 2 + 1;
			int currentRightChildIndex = currentParentIndex * 2 + 2;
			
			if (currentLeftChildIndex < counter && currentRightChildIndex < counter) 
			{
				
				
				if(((Comparable)(heap[currentLeftChildIndex])).compareTo(heap[currentRightChildIndex])==1) {
					if ( ((Comparable)heap[currentLeftChildIndex]).compareTo(currentParentIndex)==1) {
						swap(currentParentIndex, currentLeftChildIndex);
						reheapDown(currentRightChildIndex);
					}
				}
				else {
					if ( ((Comparable)heap[currentLeftChildIndex]).compareTo(currentParentIndex)==1) {
						swap(currentParentIndex, currentLeftChildIndex);
						reheapDown(currentRightChildIndex);
					}
					
					
				}

			}
			
			if(currentLeftChildIndex < counter  && currentRightChildIndex >= counter) {
				if ( ((Comparable)heap[currentLeftChildIndex]).compareTo(currentParentIndex)==1) {
					swap(currentParentIndex, currentLeftChildIndex);
					
				}
			}
		}
		
}