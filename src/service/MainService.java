package service;

public class MainService {

	public static void main(String[] args) {
		//recursionExample1(); <- ja vēlas bezgalīgo rekursiju
		recursionExample2(10); //10, 9, 8, 6, 5 (pie 5 rekursiju beigsies)

	}
	
	//bezgalīgas rekursijas piemērs
	public static void recursionExample1() {
		System.out.println("A");
		recursionExample1();
	}
	
	public static void recursionExample2(int N) {
		System.out.println("A -> " + N);
		if(N > 5)
		{
			recursionExample2(N-1);
		}
	}

}