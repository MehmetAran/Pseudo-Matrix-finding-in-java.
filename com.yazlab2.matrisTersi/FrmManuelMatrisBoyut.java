import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmManuelMatrisBoyut extends JFrame {

	private JPanel contentPane;
	private JTextField txtM;
	private JTextField txtN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManuelMatrisBoyut frame = new FrmManuelMatrisBoyut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManuelMatrisBoyut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtM = new JTextField();
		txtM.setBounds(155, 62, 86, 20);
		contentPane.add(txtM);
		txtM.setColumns(10);
		
		txtN = new JTextField();
		txtN.setBounds(155, 93, 86, 20);
		contentPane.add(txtN);
		txtN.setColumns(10);
		
		JButton btnNewButton = new JButton("G\u00F6nder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String satirTemp, sutunTemp;
					satirTemp = txtM.getText();
					sutunTemp = txtN.getText();
					
					int i=0, j=0;
					if(satirTemp!=null && i<satirTemp.length() && (Character.isDigit(satirTemp.charAt(i)) || satirTemp.charAt(i)==',' || satirTemp.charAt(i)=='.')) {
						if(sutunTemp!=null && j<sutunTemp.length() && (Character.isDigit(sutunTemp.charAt(j)) || sutunTemp.charAt(j)==',' || sutunTemp.charAt(j)=='.')) {
							
							int satir, sutun;
							satir = Integer.parseInt(satirTemp);
							sutun = Integer.parseInt(sutunTemp);
							
							if( satir > 5 || satir < 1 && sutun > 5 || sutun < 1 ) {
								JOptionPane.showMessageDialog(null, " M - N sayilari 1-5 aralýðýnda olmalidir!!!","Uyarý",2);
							}
							else if(satir == sutun) {
								JOptionPane.showMessageDialog(null, "Matrisi kare matris yapmayýn!!!");
							}
							else {
								FrmManuelMatris.M = satir;
								FrmManuelMatris.N = sutun;
								
								FrmManuelMatris verileriGonder = new FrmManuelMatris();
								verileriGonder.setLocationRelativeTo(null);
								setVisible(false);
								verileriGonder.setVisible(true);// Manuel matris iþlemlerine git
								verileriGonder.setExtendedState(MAXIMIZED_BOTH);//tam ekran yapar
								dispose();// bu ekrani kapat				
							}
							j++;
						}
						
						else 
							JOptionPane.showMessageDialog(null, "sayi girmediniz!!!","UYARI",2);
						i++;
					}
					else 
						JOptionPane.showMessageDialog(null, "sayi girmediniz!!!","UYARI",2);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "sayi girmediniz!!!","UYARI",2);
				}
				
			}
			
		});
		btnNewButton.setBounds(155, 134, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Matris boyutunu giriniz([M][N]).....");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(109, 30, 280, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblM = new JLabel("M");
		lblM.setBounds(119, 65, 15, 14);
		contentPane.add(lblM);
		
		JLabel lblN = new JLabel("N");
		lblN.setBounds(119, 96, 15, 14);
		contentPane.add(lblN);
	}
}
