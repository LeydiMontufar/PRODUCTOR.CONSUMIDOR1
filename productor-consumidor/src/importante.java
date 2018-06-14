import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class importante extends Thread {

	private JFrame frame;
	static JTextField textField;
	static JLabel contador;
	
	Semaphore semaforo = new Semaphore(1);
	buffer bru =new buffer();
	
	productor pro1;
	productor pro2;
	consumidor con1;
	consumidor con2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {


				try {
					importante window = new importante();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public importante() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 628, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("INICIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pro1 = new productor("productor1", bru, semaforo);
				pro1.start();			
			}
		});
		btnNewButton.setBounds(34, 56, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PARAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pro1.suspend();
				
			}
		});
		btnNewButton_1.setBounds(34, 90, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("INICIO");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pro2 = new productor("Productor 2", bru, semaforo);
				pro2.start();
			}
		});
		btnNewButton_2.setBounds(34, 193, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton
				("PARAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pro2.suspend();
			}
			
		});
		btnNewButton_3.setBounds(34, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(127, 155, 372, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("SALIR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_4.setBounds(288, 238, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblProductorConsumidor = new JLabel("PRODUCTOR CONSUMIDOR");
		lblProductorConsumidor.setBounds(246, 11, 149, 14);
		frame.getContentPane().add(lblProductorConsumidor);
		
		JButton btnNewBuctton = new JButton("INICIO");
		btnNewBuctton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con1 = new consumidor("Consumidor 1", bru, semaforo);
				con1.start();
			}
		});
		btnNewBuctton.setBounds(519, 65, 89, 14);
		frame.getContentPane().add(btnNewBuctton);
		
		JButton btnParar = new JButton("PARAR");
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con1.suspend();
			
			}
	});
		btnParar.setBounds(519, 90, 89, 23);
		frame.getContentPane().add(btnParar);
		
		
		JButton btnInicio = new JButton("INICIO");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con2 = new consumidor("Consumidor 2", bru, semaforo);
				con2.start();
			}
		});
		btnInicio.setBounds(519, 193, 89, 23);
		frame.getContentPane().add(btnInicio);
		
		JButton btnPara = new JButton("PARA");
		btnPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con2.suspend();
				//con2.detener();
			}
		});
		btnPara.setBounds(519, 227, 89, 23);
		frame.getContentPane().add(btnPara);
		
		JLabel lblProductor = new JLabel("productor1");
		lblProductor.setBounds(46, 31, 97, 14);
		frame.getContentPane().add(lblProductor);
		
		JLabel lblProductor_1 = new JLabel("productor 2");
		lblProductor_1.setBounds(46, 158, 71, 14);
		frame.getContentPane().add(lblProductor_1);
		
		JLabel lblConsumidor = new JLabel("consumidor 1");
		lblConsumidor.setBounds(519, 31, 93, 14);
		frame.getContentPane().add(lblConsumidor);
		
		JLabel lblConsumidor_1 = new JLabel("consumidor 2");
		lblConsumidor_1.setBounds(523, 158, 89, 14);
		frame.getContentPane().add(lblConsumidor_1);
		
		JButton btnContinuar = new JButton("CONTINUAR");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pro1.resume();
			}
		});
		btnContinuar.setBounds(133, 72, 108, 23);
		frame.getContentPane().add(btnContinuar);
		
		JButton btnNewButton_5 = new JButton("CONTINUAR");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pro2.resume();
			}
			
		});
		btnNewButton_5.setBounds(137, 211, 104, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("CONTINUAR");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con1.resume();
				
			}
		});
		btnNewButton_6.setBounds(392, 72, 106, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("CONTINUAR");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con2.resume();
				//con2.detener();
			}
		});
		btnNewButton_7.setBounds(399, 211, 110, 23);
		frame.getContentPane().add(btnNewButton_7);
		
		contador = new JLabel("0");
		contador.setBounds(299, 129, 46, 14);
		frame.getContentPane().add(contador);
		
		JLabel lblMontufarIdmeVizaida = new JLabel("Montufar Idme Vizaida Leyifer");
		lblMontufarIdmeVizaida.setBounds(44, 266, 197, 14);
		frame.getContentPane().add(lblMontufarIdmeVizaida);
		
		//txt1 = new JTextField();
		//txt1.setColumns(10);
	//	txt1.setBounds(120, 152, 372, 20);
	//	frame.getContentPane().add(txt1);
	}
	public JTextField getTextField() {
		return textField;
	}
}
