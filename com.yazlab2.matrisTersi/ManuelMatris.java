import java.util.Random;
import java.util.Scanner;

public class ManuelMatris {
	private int M,N;
	private float [][] matris;
	private Scanner sc= new Scanner(System.in);;
	
	public void matris() {
		do {
			System.out.println("M :");
			M = sc.nextInt();
			System.out.println("N :");
			N =sc.nextInt();
		
	}while(M==0 || N==0 || M==N);
	matris = new float[M][N];
	matriseElemanAt(matris, M,N);
		
	}
	
	private float[][] matriseElemanAt(float [][] matris1,int m,int n) {		
		for(int i =0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print("Matris[" +(i+1)+"]"+"["+(j+1)+"] = ");
				matris1[i][j] = sc.nextFloat();
			}
		}
		return  matris1;
	}
	
	public float[][] matrisiDondur(){
		return matris;
	}
	public int satirSayisiDondur() {
		return M;
	}
	public int sutunSayisiDondur() {
		return N;
	}
	
}
