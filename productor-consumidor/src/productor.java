import java.awt.TextField;
import java.util.concurrent.Semaphore;

import javax.swing.JTextField;

public class productor extends Thread {
	
	private String getText;
    public boolean continuar = false;
    buffer bru;
    Semaphore semaforo;
    
    
	public productor(String string, buffer bru, Semaphore semaforo) {
		this.getText = string;			//nombre
		this.bru = bru;		
		this.semaforo = semaforo;
		// TODO Auto-generated constructor stub
	}
        
	public void run()
	{
		char uno='A';
	
		while(true) {

			try {
				semaforo.acquire();
				
				System.out.print(getText + " ");
				bru.Agregar((char)(uno + (char)(Math.random() * 26)) + "");
				
				semaforo.release();
				
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		
		
	}

}
