import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.Random;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRandomMatris extends JFrame {

	private JPanel contentPane;
	private int m, n;
	private float[][] matris;
	int toplamSayisi = 0;
	int carpimSayisi = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRandomMatris frame = new FrmRandomMatris();
					frame.setExtendedState(MAXIMIZED_BOTH);// tam ekran yapar
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
	public FrmRandomMatris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4, 2, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		panel.add(scrollPane);

		JTextArea txtMatris = new JTextArea();
		txtMatris.setEditable(false);
		txtMatris.setBackground(SystemColor.menu);
		scrollPane.setViewportView(txtMatris);

		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);

		JTextArea txtTranspoz = new JTextArea();
		txtTranspoz.setEditable(false);
		txtTranspoz.setBackground(SystemColor.menu);
		scrollPane_1.setViewportView(txtTranspoz);

		JScrollPane scrollPane_3 = new JScrollPane();
		panel.add(scrollPane_3);

		JTextArea txtMatrisCarpimi = new JTextArea();
		txtMatrisCarpimi.setEditable(false);
		txtMatrisCarpimi.setBackground(SystemColor.menu);
		scrollPane_3.setViewportView(txtMatrisCarpimi);

		JScrollPane scrollPane_4 = new JScrollPane();
		panel.add(scrollPane_4);

		JTextArea txtMatrisTersi = new JTextArea();
		txtMatrisTersi.setEditable(false);
		txtMatrisTersi.setBackground(SystemColor.menu);
		scrollPane_4.setViewportView(txtMatrisTersi);

		JScrollPane scrollPane_2 = new JScrollPane();
		panel.add(scrollPane_2);

		JTextArea txtRandomMatris = new JTextArea();
		txtRandomMatris.setEditable(false);
		txtRandomMatris.setBackground(SystemColor.menu);
		scrollPane_2.setViewportView(txtRandomMatris);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_8.add(scrollPane_5, BorderLayout.CENTER);
		
		JTextArea txtToplamCarpim = new JTextArea();
		txtToplamCarpim.setBackground(SystemColor.menu);
		scrollPane_5.setViewportView(txtToplamCarpim);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 3, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);

		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
				JButton btnAnasayfa = new JButton("Anasayfa");
				panel_1.add(btnAnasayfa);
				btnAnasayfa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						FrmAnasayfa anasayfa = new FrmAnasayfa();
						anasayfa.setLocationRelativeTo(null);
						setVisible(false);
						anasayfa.setVisible(true);// Anasayfaya git
						dispose();// bu ekrani kapat
					}
				});

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		// burada iþlemlerimiz baslýyor.
		float[][] a;
		RandomMatris m1 = new RandomMatris();
		m1.matris();
		a = m1.matrisiDondur();

		m = m1.satirSayisiDondur();
		n = m1.sutunSayisiDondur();

		// Orjinal Matrisi yazdýrýyoruz.
		txtMatris.append("(1.Adim)Orjinal Matris[" + m + "][" + n + "] :  \n");
		System.out.println("orjinal");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				txtMatris.append(" " + Float.toString(a[i][j]) + "  |");
				System.out.print(" " + a[i][j] + " ");

			}
			System.out.println();
			txtMatris.append("\n");
		}

		float[][] pinv;

		Transpoz transpoz = new Transpoz();
		MatrisCarpimi matrisCarpimi = new MatrisCarpimi();
		MatrisTersiAl matrisTersiAl = new MatrisTersiAl();

		if (a.length < a[0].length) {
			float[][] aT = transpoz.transpozeAl(a);
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
			float[][] aXaT = matrisCarpimi.matrisCarpma(a, aT);
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
			txtRandomMatris.append(
					"(5.Adim-Son Adim)\nMatrisin Sözde Tersi (matris transpozu * (tersi * matris transpozu)) : \n");
			System.out.println("son");
			for (int i = 0; i < pinv.length; i++) {
				for (int j = 0; j < pinv[0].length; j++) {

					txtRandomMatris.append(" " + Float.toString(pinv[i][j]) + "  |");
					System.out.print(" " + pinv[i][j] + "  |");
				}
				System.out.println();
				txtRandomMatris.append("\n");
			}
			carpimSayisi = matrisCarpimi.getCarpimSayisi() + matrisTersiAl.getCarpimSayisi();
			toplamSayisi = matrisCarpimi.getToplamSayisi() + matrisTersiAl.getToplamSayisi();
			System.out.println("toplam sayisi = " + toplamSayisi + " carpim sayisi = " + carpimSayisi);
			txtToplamCarpim.append("toplam sayisi = \n" + toplamSayisi);
			txtToplamCarpim.append("\ncarpim sayisi = \n" + carpimSayisi);
		} else {
			float[][] aT = transpoz.transpozeAl(a);
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
			float[][] aTXa = matrisCarpimi.matrisCarpma(aT, a);
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
			txtRandomMatris.append(
					"(5.Adim-Son Adim)\nMatrisin Sözde Tersi ((tersin transpozu * matris transpozu)*matris transpozu) : \n");
			System.out.println("son");
			for (int i = 0; i < pinv.length; i++) {
				for (int j = 0; j < pinv[0].length; j++) {

					txtRandomMatris.append(" " + Float.toString(pinv[i][j]) + "  |");
					System.out.print(" " + pinv[i][j] + "  |");
				}
				System.out.println();
				txtRandomMatris.append("\n");
			}
			carpimSayisi = matrisCarpimi.getCarpimSayisi() + matrisTersiAl.getCarpimSayisi();
			toplamSayisi = matrisCarpimi.getToplamSayisi() + matrisTersiAl.getToplamSayisi();
			System.out.println("toplam sayisi = " + toplamSayisi + " carpim sayisi = " + carpimSayisi);
			txtToplamCarpim.append("toplam sayisi = \n" + toplamSayisi);
			txtToplamCarpim.append("\ncarpim sayisi = \n" + carpimSayisi);
		}

	}
}
