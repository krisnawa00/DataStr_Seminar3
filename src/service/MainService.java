package service;

import datastr.MyHeap;
import model.Patient;


public class MainService {

	public static void main(String[] args) {
		//recursionExample1(); <- ja vēlas bezgalīgo rekursiju
		//recursionExample2(10); //10, 9, 8, 6, 5 (pie 5 rekursiju beigsies)

		MyHeap<Integer> heapForint = new MyHeap<Integer>(2);
		heapForint.enqueue(5);
		heapForint.enqueue(45);
		heapForint.enqueue(33);
		heapForint.enqueue(47);
		heapForint.enqueue(46);
		heapForint.enqueue(50);
	
	try {
		heapForint.print();
		System.out.println("--------------------DEQUEUE------------------------");
		System.out.println("MAX element: " + heapForint.dequeue());
		System.out.println("MAX element: " + heapForint.dequeue());
		heapForint.print();
		System.out.println("--------------------MAKE EMPTY------------------------");
		heapForint.makeEmpty();
		heapForint.enqueue(100);
		heapForint.print();
	}
	catch (Exception e){
		e.printStackTrace();
	}	
	
	MyHeap<Patient> heapforpatients = new MyHeap<>(2);
	heapforpatients.enqueue(new Patient("Janis","Berzins", 3));
	heapforpatients.enqueue(new Patient("Liga","Apjuka", 7));
	heapforpatients.enqueue(new Patient("Lauris","Aizbegs", 9));
	heapforpatients.enqueue(new Patient("Juris","Peldis", 3));
	
	
	try {
		heapforpatients.print();
		System.out.println("--------------------DEQUEUE------------------------");
		System.out.println("MAX patient: " + heapforpatients.dequeue());
		System.out.println("MAX patient: " + heapforpatients.dequeue());
		heapforpatients.print();
		System.out.println("--------------------MAKE EMPTY------------------------");
		heapforpatients.makeEmpty();
		heapforpatients.enqueue(new Patient("Lauris","Berzins", 1));
		heapforpatients.enqueue(new Patient("Karlis","Karalis", 4));
		heapforpatients.print();
	}
	catch (Exception e){
		e.printStackTrace();
	}	
	}
	//bezgalīgas rekursijas piemērs
	public static void recursionExample1() {
		
		System.out.println("A");
		recursionExample1();
		
	}
	
	public static void recursionExample2(int N) 
	
	{
		
		System.out.println("A -> " + N);
		if(N > 5)
		{
			recursionExample2(N-1);
		}
		
	}
	

}