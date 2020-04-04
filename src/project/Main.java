package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Array;

public class Main {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DECIMAL x ROMAN CONVERSOR");
		lblNewLabel.setBounds(0, 11, 434, 27);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(133, 69, 167, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Turns to:");
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(191, 139, 68, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.BOLD, 21));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 185, 414, 51);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Insert a value (1 - 3000)");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 49, 414, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String teste = textField.getText(); 
				if(!teste.matches("[0-9]*") || (Integer.parseInt(teste) > 3000)) {
					lblNewLabel_3.setText("Invalid number, please check");
				} else {
					lblNewLabel_3.setText(DecimalToRoman(teste));
				}
				
			}
		});
	}
	
	public String DecimalToRoman(String value) {
		
		String letters[] = {"M","D","C","L","X","V","I"};
		int values[] = {1000,500,100,50,10,5,1};
		String retorno = "";
		
		int valor = Integer.parseInt(value);
		int resto;
		int vezes;
		
		for(int i = 0; i < 7; i++) {
			vezes = valor / values[i];
			resto = valor % values[i];
			System.out.println("\nValor: " + valor + "\nDivide por: " + values[i] + "\nVezes que vai repitir: "+ vezes +"\nResto: "+resto);
			if(vezes > 0) {
				if(vezes == 4) {
					retorno = retorno + letters[i] + letters[i-1];
				} else {
					for(int x = 1; x <= vezes; x++) {
						retorno = retorno + letters[i];
					}
				}
				valor = resto;
			}
			
		}
		System.out.println(retorno);
		return retorno;
	}
}
