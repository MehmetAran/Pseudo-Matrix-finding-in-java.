import java.util.Random;

public class RandomMatris {
	private int M,N;
	private float [][] matris; 
	
	public void matris() {
		Random r = new Random();
		
		M = r.nextInt(5)+1;
		N= 	r.nextInt(5)+1;
		
		while(M==N)
			N= r.nextInt(5)+1;
	
		System.out.println("M= " + M +" N ="+N);
		
        matris = new float[M][N];
        matriseElemanAt(matris, M, N);
       
	}
	
	public float[][] matriseElemanAt(float [][] matris1,int m,int n) {
		Random r = new Random();
		
		for(int i =0;i<m;i++) {
			for(int j=0;j<n;j++) {
				float virgul = r.nextFloat();
				virgul -= virgul%0.1;
				matris1[i][j] = (r.nextInt(9)+virgul+1);
//				System.out.print(matris1[i][j] +"  ");
			}
//			System.out.println();
		}
		return matris1;
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
