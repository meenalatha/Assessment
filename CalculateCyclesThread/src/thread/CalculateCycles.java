package thread;

class CalculatePrice {
	int price =1000;
	public synchronized void calculate() {
		price++;
		System.out.println("Price of cycle : "+price);
	}
}

public class CalculateCycles {
	
	public static void main(String[] args) throws InterruptedException {
		
		CalculatePrice c = new CalculatePrice();
		Thread t1 = new Thread(() -> {
						for(int i=1;i<=500;i++) {
							c.calculate();
						}
					});
		Thread t2 = new Thread(() -> {
			for(int i=1;i<=500;i++) {
				c.calculate();
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
