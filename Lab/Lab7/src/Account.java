import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private double balance;

		private Lock doDeposit = new ReentrantLock();

    /**
     *
     * @param money
     */
    public void deposit(double money) {
        try {
					newDeposit(money);
			try {
			    Thread.sleep(10);   // Simulating this service takes some processing time
			}
			catch(InterruptedException ex) {
			    ex.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


	public void deposit2(double money) {
		try {
			doDeposit.lock();
			balance = money + balance;
			doDeposit.unlock();
			try {
				Thread.sleep(10);   // Simulating this service takes some processing time
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		public synchronized void newDeposit(double money){
			try {
				balance += money;
			}catch (Exception e){

			}
		}


    public double getBalance() {
        return balance;
    }
}