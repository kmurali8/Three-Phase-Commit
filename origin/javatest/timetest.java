
public class timetest {
	public static void main(String[] args) {
		//long startTime = System.nanoTime();
		long startTime = System.currentTimeMillis();

		try {
			Thread.sleep(3000);
		}catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		//long endTime = System.nanoTime();
		long endTime = System.currentTimeMillis();
		long duration = endTime -startTime;
		System.out.println("duration"+duration/1000+"s");
	}
}
