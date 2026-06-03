public class SyncMethods {
    private long c1 = 0;
    private long c2 = 0;

    public synchronized void inc1() {
	c1++;
    }

    public synchronized void inc2() {
	c2++;
    }
    
    public static void main(String[] args) throws InterruptedException {
	Thread t1, t2;
	SyncMethods syncStmnt = new SyncMethods(); 

	t1 = new Thread(() -> {
		int i = 0;
		while (i < 1000) { syncStmnt.inc1(); syncStmnt.inc2(); i++;}
		System.out.println("t1 Stopped");
	});

	t2 = new Thread(() -> {
		int i = 0;
		while (i < 1000) { syncStmnt.inc1(); syncStmnt.inc2(); i++;}
		System.out.println("t1 Stopped");
	});
	t1.start();
	t2.start();
	Thread.sleep(1000);

	System.out.println("c1: " + syncStmnt.c1);
	System.out.println("c2: " + syncStmnt.c2);
    }
}
