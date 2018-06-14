import java.util.concurrent.Semaphore;

import javax.swing.JTextArea;

public class consumidor extends Thread {
	private String getText;
	buffer bru;
	Semaphore semaforo;
	
	public consumidor(String string,buffer bru, Semaphore semaforo) {
		this.getText = string;
		this.semaforo = semaforo;
		this.bru = bru;
		// TODO Auto-generated constructor stub
	}
	public void run()
	{	
		while(true) {

			try {
				semaforo.acquire();
				
				System.out.print(getText + " ");
				bru.Sacar();
				
				semaforo.release();
				
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}
	

}
