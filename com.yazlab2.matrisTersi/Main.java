import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Ýþlemler\n"
				+ "1.Manuel Matris\n"
				+ "2.Random Matris");

		
		Scanner sc = new Scanner(System.in);
		int secim = sc.nextInt();
		float[][] a ;
		if(secim == 1) {
			ManuelMatris m1 = new ManuelMatris();
			m1.matris();
			a = m1.matrisiDondur();
		}
		else {
			RandomMatris m1 = new RandomMatris();
			m1.matris();
			a = m1.matrisiDondur();
		}
		Hesapla(a);
		
}
	
	public static float[][] Hesapla(float[][] a){
		Transpoz transpoz = new  Transpoz();
		MatrisCarpimi matrisCarpimi = new MatrisCarpimi();
		MatrisTersiAl matrisTersiAl = new MatrisTersiAl();
		
		
		float[][] pinv;
		if(a.length<a[0].length) {
			float[][] aT = transpoz.transpozeAl(a) ;
			float[][] aXaT = matrisCarpimi.matrisCarpma(a, aT);
			float[][] invaXaT = matrisTersiAl.matrisTersiAl(aXaT);
			pinv = matrisCarpimi.matrisCarpma(aT, invaXaT);
		}
		else {
			float[][] aT = transpoz.transpozeAl(a) ;
			float[][] aTXa = matrisCarpimi.matrisCarpma(aT, a);
			float[][] invaTXaT = matrisTersiAl.matrisTersiAl(aTXa);
			pinv = matrisCarpimi.matrisCarpma(invaTXaT, aT);
		}
		for(int i = 0;i<pinv.length;i++) {
			for(int j=0;j<pinv[0].length;j++) {
				System.out.print(" "+pinv[i][j]+" ");
			}
			System.out.println();
		}
		
		return pinv;
	}
	
}
