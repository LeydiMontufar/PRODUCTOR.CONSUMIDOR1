
public class buffer extends Thread{
	
	String []buffer = new String[25];
	public int ipos=0;
	
	public void Agregar(String letra) {
		if(ipos < 25){
			buffer[ipos] = letra;
			System.out.println(" -> " + buffer[ipos]);
			ipos++;
			importante.contador.setText(ipos + "");
			importante.textField.setText("");
			for(int i = 0; i < ipos; ++i)
			{
				importante.textField.setText(importante.textField.getText() + buffer[i]);
			}
		}else {
			System.out.println("El buffer esta lleno");
		}
	}
	public void Sacar() {
		if(ipos == 0 || buffer[ipos-1] == ""){
			System.out.println("El buffer esta vacio");
		}
		else{
			System.out.println(" <- " + buffer[ipos-1]);
			buffer[ipos-1]= "";
			ipos--;
			importante.contador.setText(ipos + "");
			importante.textField.setText("");
			for(int i = 0; i < ipos; ++i)
			{
				importante.textField.setText(importante.textField.getText() + buffer[i]);
			}
		}
	}	
}
