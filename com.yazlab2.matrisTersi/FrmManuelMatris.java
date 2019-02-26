import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.handler.MessageContext;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.SystemColor;

public class FrmManuelMatris extends JFrame {

	private JPanel contentPane;
	static int M;
	static int N;
	private JTextField txtDeneme;
	private JTextField textField;
	private JButton btnHesaplama;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JPanel panel;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JButton btnNewButton_1;
	private JTextArea txtMatris;
	private JTextArea txtTranspoz;
	private JTextArea txtMatrisCarpimi;
	private JTextArea txtMatrisTersi;
	private JTextArea txtManuelMatris;
	int toplamSayisi = 0;
	int carpimSayisi = 0;
	private JPanel panel_1;
	private JScrollPane scrollPane_5;
	private JTextArea txtToplamCarpim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManuelMatris frame = new FrmManuelMatris();
					frame.setExtendedState(MAXIMIZED_BOTH);// tam ekran yapar
//					frame.setLocationRelativeTo(null);
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
	public FrmManuelMatris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		int elemanSayisi = M * N;
		String[] eleman = new String[elemanSayisi];

		float[][] matris1 = new float[M][N];
		contentPane.setLayout(new GridLayout(4, 2, 0, 0));

		scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1);

		txtMatris = new JTextArea();
		txtMatris.setEditable(false);
		txtMatris.setBackground(SystemColor.menu);
		scrollPane_1.setViewportView(txtMatris);

		scrollPane_2 = new JScrollPane();
		contentPane.add(scrollPane_2);

		txtTranspoz = new JTextArea();
		txtTranspoz.setEditable(false);
		txtTranspoz.setBackground(SystemColor.menu);
		scrollPane_2.setViewportView(txtTranspoz);

		scrollPane_4 = new JScrollPane();
		contentPane.add(scrollPane_4);

		txtMatrisCarpimi = new JTextArea();
		txtMatrisCarpimi.setEditable(false);
		txtMatrisCarpimi.setBackground(SystemColor.menu);
		scrollPane_4.setViewportView(txtMatrisCarpimi);

		scrollPane_3 = new JScrollPane();
		contentPane.add(scrollPane_3);

		txtMatrisTersi = new JTextArea();
		txtMatrisTersi.setEditable(false);
		txtMatrisTersi.setBackground(SystemColor.menu);
		scrollPane_3.setViewportView(txtMatrisTersi);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		txtManuelMatris = new JTextArea();
		txtManuelMatris.setEditable(false);
		txtManuelMatris.setBackground(SystemColor.menu);
		scrollPane.setViewportView(txtManuelMatris);

		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		scrollPane_5 = new JScrollPane();
		panel_1.add(scrollPane_5, BorderLayout.CENTER);

		txtToplamCarpim = new JTextArea();
		txtToplamCarpim.setBackground(SystemColor.menu);
		scrollPane_5.setViewportView(txtToplamCarpim);

		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JButton btnMatriseEkle = new JButton("Matrise Eleman Ekle");
		panel.add(btnMatriseEkle);

		btnHesaplama = new JButton("Hesapla");
		panel.add(btnHesaplama);
		btnHesaplama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N; j++) {

						System.out.print(matris1[i][j] + "  |");
					}
					System.out.println("");
				}
				HesaplamaIslemleri(matris1);
			}

		});

		btnNewButton_1 = new JButton("Anasayfa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FrmAnasayfa anasayfa = new FrmAnasayfa();
				anasayfa.setLocationRelativeTo(null);
				setVisible(false);
				anasayfa.setVisible(true);// Anasayfaya git
				dispose();// bu ekrani kapat
			}
		});
		panel.add(btnNewButton_1);
		btnMatriseEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < elemanSayisi; i++) {
					eleman[i] = JOptionPane.showInputDialog(null, "Matrisin " + (i + 1) + ". elemanýný giriniz",
							"veri girisi", JOptionPane.INFORMATION_MESSAGE);
					// Eleman float deðilse tekrar eleman girilmesi istenir.
					try {
						Float.parseFloat(eleman[i]);
					} catch (NumberFormatException e) {
						System.out.println(i);
						i--;
						JOptionPane.showMessageDialog(null, "Hatali giris : Lütfen float deðer girin");
					}
				}

				int k = 0;
				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N; j++) {
						matris1[i][j] = Float.parseFloat(eleman[k]);
						k++;

					}
				}
			}
		});
	}

	private void HesaplamaIslemleri(float[][] matris1) {

		// Orjinal Matrisi yazdýrýyoruz.
		txtMatris.append("(1.Adim)Orjinal Matris[" + M + "][" + N + "] :  \n");
		System.out.println("orjinal");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				txtMatris.append(" " + Float.toString(matris1[i][j]) + "  |");
//				System.out.print(" "+a[i][j]+" ");

			}
//			System.out.println();
			txtMatris.append("\n");
		}

		float[][] pinv;

		Transpoz transpoz = new Transpoz();
		MatrisCarpimi matrisCarpimi = new MatrisCarpimi();
		MatrisTersiAl matrisTersiAl = new MatrisTersiAl();

		if (matris1.length < matris1[0].length) {
			float[][] aT = transpoz.transpozeAl(matris1);
			// Transpoz yazdýrma
			System.out.println("2.adim");
			txtTranspoz.append("(2.Adým) Oluþturulan random matrisin Transpozu : \n");
			for (int i = 0; i < aT.length; i++) {
				for (int j = 0; j < aT[0].length; j++) {

					txtTranspoz.append(" " + Float.toString(aT[i][j]) + "  |");
					System.out.print(" " + aT[i][j] + "  |");
				}
				System.out.println();
				txtTranspoz.append("\n");
			}
			float[][] aXaT = matrisCarpimi.matrisCarpma(matris1, aT);
			// Matris carpýmlarý
			System.out.println("3.adim");
			txtMatrisCarpimi.append("(3.Adým) Matris Carpimi (matris * matrisTranspozu) : \n");
			for (int i = 0; i < aXaT.length; i++) {
				for (int j = 0; j < aXaT[0].length; j++) {

					txtMatrisCarpimi.append(" " + Float.toString(aXaT[i][j]) + "  |");
					System.out.print(" " + aXaT[i][j] + "  |");
				}
				System.out.println();
				txtMatrisCarpimi.append("\n");
			}
			float[][] invaXaT = matrisTersiAl.matrisTersiAl(aXaT);
			// Matris Tersi
			System.out.println("4.adim");
			txtMatrisTersi.append("(4.Adým) Matrisin Tersi (tersi * matris transpozu) : \n");
			for (int i = 0; i < invaXaT.length; i++) {
				for (int j = 0; j < invaXaT[0].length; j++) {

					txtMatrisTersi.append(" " + Float.toString(invaXaT[i][j]) + "  |");
					System.out.print(" " + invaXaT[i][j] + "  |");
				}
				System.out.println();
				txtMatrisTersi.append("\n");
			}
			pinv = matrisCarpimi.matrisCarpma(aT, invaXaT);
			// Matrisin sözde tersini yazdýrýyoruz.
			txtManuelMatris.append(
					"(5.Adim-Son Adim)\nMatrisin Sözde Tersi (matris transpozu * (tersi * matris transpozu)) : \n");
			System.out.println("son");
			for (int i = 0; i < pinv.length; i++) {
				for (int j = 0; j < pinv[0].length; j++) {

					txtManuelMatris.append(" " + Float.toString(pinv[i][j]) + "  |");
					System.out.print(" " + pinv[i][j] + "  |");
				}
				System.out.println();
				txtManuelMatris.append("\n");
			}
			carpimSayisi = matrisCarpimi.getCarpimSayisi() + matrisTersiAl.getCarpimSayisi();
			toplamSayisi = matrisCarpimi.getToplamSayisi() + matrisTersiAl.getToplamSayisi();
			System.out.println("toplam sayisi = " + toplamSayisi + " carpim sayisi = " + carpimSayisi);
			txtToplamCarpim.append("toplam sayisi = \n" + toplamSayisi);
			txtToplamCarpim.append("\ncarpim sayisi = \n" + carpimSayisi);
		} else {
			float[][] aT = transpoz.transpozeAl(matris1);
			// Transpoz yazdýrma
			System.out.println("2.adim");
			txtTranspoz.append("(2.Adým) Oluþturulan random matrisin Transpozu : \n");
			for (int i = 0; i < aT.length; i++) {
				for (int j = 0; j < aT[0].length; j++) {

					txtTranspoz.append(" " + Float.toString(aT[i][j]) + "  |");
					System.out.print(" " + aT[i][j] + "  |");
				}
				System.out.println();
				txtTranspoz.append("\n");
			}
			float[][] aTXa = matrisCarpimi.matrisCarpma(aT, matris1);
			// Matris carpýmlarý
			System.out.println("3.adim");
			txtMatrisCarpimi.append("(3.Adým) Matris Carpimi (matrisTranspozu * matris) : \n");
			for (int i = 0; i < aTXa.length; i++) {
				for (int j = 0; j < aTXa[0].length; j++) {

					txtMatrisCarpimi.append(" " + Float.toString(aTXa[i][j]) + "  |");
					System.out.print(" " + aTXa[i][j] + "  |");
				}
				System.out.println();
				txtMatrisCarpimi.append("\n");
			}
			float[][] invaTXaT = matrisTersiAl.matrisTersiAl(aTXa);
			// Matris Tersi
			System.out.println("4.adim");
			txtMatrisTersi.append("(4.Adým) Matrisin Tersi(tersin Transpozu * matrisin transpozu)  : \n");
			for (int i = 0; i < invaTXaT.length; i++) {
				for (int j = 0; j < invaTXaT[0].length; j++) {

					txtMatrisTersi.append(" " + Float.toString(invaTXaT[i][j]) + "  |");
					System.out.print(" " + invaTXaT[i][j] + "  |");
				}
				System.out.println();
				txtMatrisTersi.append("\n");
			}
			pinv = matrisCarpimi.matrisCarpma(invaTXaT, aT);
			// Matrisin sözde tersini yazdýrýyoruz.
			txtManuelMatris.append(
					"(5.Adim-Son Adim)\nMatrisin Sözde Tersi ((tersin transpozu * matris transpozu)*matris transpozu) : \n");
			System.out.println("son");
			for (int i = 0; i < pinv.length; i++) {
				for (int j = 0; j < pinv[0].length; j++) {

					txtManuelMatris.append(" " + Float.toString(pinv[i][j]) + "  |");
					System.out.print(" " + pinv[i][j] + "  |");
				}
				System.out.println();
				txtManuelMatris.append("\n");
			}
			carpimSayisi = matrisCarpimi.getCarpimSayisi() + matrisTersiAl.getCarpimSayisi();
			toplamSayisi = matrisCarpimi.getToplamSayisi() + matrisTersiAl.getToplamSayisi();
			System.out.println("toplam sayisi = " + toplamSayisi + " carpim sayisi = " + carpimSayisi);
			txtToplamCarpim.append("toplam sayisi = \n" + toplamSayisi);
			txtToplamCarpim.append("\ncarpim sayisi = \n" + carpimSayisi);

		}

	}

}
