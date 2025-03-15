package datastr;

public class MyHeap<Ttype> {
	// mainīgie
	private Ttype[] heap;
	private final int DEFAULT_SIZE = 10;
	private int size = DEFAULT_SIZE;
	private int counter = 0;

	// bezargumenta konstruktors
	public MyHeap() {
		heap = (Ttype[]) new Object[size];
	}

	// argumenta konstruktors
	public MyHeap(int inputSize) {
		if (inputSize > 0) {
			size = inputSize;
		}

		heap = (Ttype[]) new Object[size];
	}

	public boolean isFull() {
		return (counter == size);
	}

	public boolean isEmpty() {
		return (counter == 0);
	}

	public int howManyElements() {
		return counter;
	}

	private void resize() {
		size = (counter < 100) ? size * 2 : (int) (size * 1.5);
		Ttype[] listNew = (Ttype[]) new Object[size];

		for (int i = 0; i < counter; i++) {
			listNew[i] = heap[i];
		}
		heap = listNew;
		System.gc();// izsaucam atkritumu savācēju, kas izdzēsīs mazā masīva elementus

	}

	public void enqueue(Ttype element) {
		if (isFull()) {
			resize();
		}

		heap[counter] = element;
		counter++;

		// jāsakārto jeb jānodrošina kārtības īpašība jeb jāizsauc reheapUp funkcija
		reheapUp(counter - 1);

	}

	private void reheapUp(int currentChildIndex) {
		// kreisā bērna index = vecāka index * 2 + 1
		// laba bērna index = vecāka index * 2 + 2

		// vecāka index = (kreisā bērna index - 1)/2
		// vecaka index = (labā bērna index - 2)/2

		// ja benra index ir 6, tad vienā gadījumā 2.5 un otrā 2

		int currentParentIndex = (int) ((currentChildIndex - 1) / 2);

		if (currentParentIndex >= 0)// tikai tad, ja tāds vecāks eksistē (nevar būt index, kas ir negativs)
		{
			// vecāks ir mazāks par savu bērnu, tad mainām sūnu vērtības vietām
			if (((Comparable) heap[currentParentIndex]).compareTo(heap[currentChildIndex]) == -1) {
				swap(currentParentIndex, currentChildIndex);
				reheapUp(currentParentIndex);
			}
		}

	}

	private void swap(int index1, int index2) {
		Ttype temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}

	public Ttype dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Kaudze ir tukša un nav iespejams izgūt prioritārāko elementu");
		}

		Ttype maxElement = heap[0];

		heap[0] = heap[counter - 1];
		counter--;

		// janodrošina, lai būtu atkal kārtības īpašība jeb jāizsauc reheapDown
		reheapDown(0);

		return maxElement;
	}

	private void reheapDown(int currentParentIndex) {
		int currentLeftChildIndex = currentParentIndex * 2 + 1;
		int currentRightChildIndex = currentParentIndex * 2 + 2;

		// ja ir abi bērni
		if (currentLeftChildIndex < counter && currentRightChildIndex < counter) {
			// if noskaidrot, vai kreisais bērns ir lielāks par labo
			if (((Comparable) (heap[currentLeftChildIndex])).compareTo(heap[currentRightChildIndex]) == 1) {
				// ja kreisais bērns ir lielāks arī par vecāku
				if (((Comparable) (heap[currentLeftChildIndex])).compareTo(heap[currentParentIndex]) == 1) {
					swap(currentParentIndex, currentLeftChildIndex);
					reheapDown(currentLeftChildIndex);

				}
			} else // if kreisais bērns ir mazaks par labo bērnun
			{
				// ja labais bērns ir lielāks arī par vecāku
				if (((Comparable) (heap[currentRightChildIndex])).compareTo(heap[currentParentIndex]) == 1) {
					swap(currentParentIndex, currentRightChildIndex);
					reheapDown(currentRightChildIndex);

				}
			}
		}

		// ja ir tikai viens bērns un tas ir kreisais (nevar būt, ka ir tikai labais, jo
		// tad neizpildās formas īpašība
		if (currentLeftChildIndex < counter && currentRightChildIndex >= counter) {
			if (((Comparable) (heap[currentLeftChildIndex])).compareTo(heap[currentParentIndex]) == 1) {
				swap(currentParentIndex, currentLeftChildIndex);
			}
		}
		// ja nav bērnu, tad nedarām neko

	}

	public void print() throws Exception {
		// pārbaudi uz isEmpty
		if (isEmpty()) {
			Exception myException = new Exception("Kaudze ir tukša, tāpēc nevar veikt printēšanu");
			throw myException;
		}
		printHelp(0);

	}

	private void printHelp(int currentParentIndex) {
		System.out.println("P -> " + heap[currentParentIndex]);

		int currentLeftChildIndex = currentParentIndex * 2 + 1;
		int currentRightChildIndex = currentParentIndex * 2 + 2;

		// ja ir kreisais bērns, tad to printēsim
		if (currentLeftChildIndex < counter) {
			System.out.println(
					"Kreisais bērns -> " + heap[currentLeftChildIndex] + " (" + heap[currentParentIndex] + ")");
			printHelp(currentLeftChildIndex);
		}

		// ja ir labais bērns, tad to printēsim
		if (currentRightChildIndex < counter) {
			System.out
					.println("Labais bērns -> " + heap[currentRightChildIndex] + " (" + heap[currentParentIndex] + ")");
			printHelp(currentRightChildIndex);
		}

	}

	public void makeEmpty() {
		if (!isEmpty()) {
			size = DEFAULT_SIZE;
			counter = 0;
			heap = (Ttype[]) new Object[size];
			System.gc();
		}
	}

}