package practice;

public class Bank {
	int balance = 100000;
	Boolean lock;

	public Bank() {

		// TODO Auto-generated constructor stub
		lock = true;
	}

	public synchronized void draw(int value) {
		while (lock) {
			try {
				wait();

			} catch (InterruptedException e) {

			}
		}
		balance -= value;
		lock = true;
		notifyAll();

	}

	public synchronized void deposit(int value) {

		while (!lock) {
			try {
				wait();
			} catch (InterruptedException e) {

			}

		}
		balance += value;
		lock = false;
		notifyAll();
	}

	public synchronized int getBalance() {
		return balance;
	}
	
}
