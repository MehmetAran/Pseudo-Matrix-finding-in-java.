
public class MatrisTersiAl {
	private  int carpimSayisi = 0;
	private  int toplamSayisi = 0;
	public float[][] matrisTersiAl(float[][] matris) {
		int n = matris.length;
		int m = matris[0].length;
		if(m != n) {
			System.out.println("Hata");
			return null;
		}
		float[][] birimMatris=birimMatris(n);
		float islem1,islem2;
		for(int i=0;i<n;i++) {
			islem1=matris[i][i];
			for(int j=0;j<n;j++) {
				matris[i][j] = matris[i][j]/islem1;
				carpimSayisi++;
				birimMatris[i][j] = birimMatris[i][j]/islem1;
				carpimSayisi++;
			}
		for(int x=0;x<n;x++) {
			if(x!=i) {
				islem2 = matris[x][i];
				for(int j=0;j<n;j++) {
					matris[x][j] = matris[x][j] - (matris[i][j]*islem2);
					toplamSayisi++;
					carpimSayisi++;
					birimMatris[x][j] = birimMatris[x][j] -(birimMatris[i][j]*islem2);
					toplamSayisi++;
					carpimSayisi++;
				}
			}
		}
			
		}
		float[][] tersMatris = birimMatris; 
		return tersMatris;
	}
	
	private float[][] birimMatris(int n) {
		float[][] birimMatris = new float[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i == j)
					birimMatris[i][j]=1;
				else
					birimMatris[i][j]=0;

			}
		}
		return birimMatris;
	}
	public  int getCarpimSayisi() {
		return carpimSayisi;
	}
	
	public  int getToplamSayisi() {
		return toplamSayisi;
	}
}
