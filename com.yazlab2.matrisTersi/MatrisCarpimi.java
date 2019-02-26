public class MatrisCarpimi {
	private  int carpimSayisi = 0;
	private  int toplamSayisi = 0;
	public float[][]  matrisCarpma(float[][] matris1,float[][] matris2){
		int m1 = matris1.length;
		int m2 = matris2.length;
		int n2 = matris2[0].length;
		int n1 = matris1[0].length;
		
		if(matris1[0].length != matris2.length) {
			System.out.println("Hata");
			return null;
			}

		float[][] carpim = new float[m1][n2];

		for(int i=0;i<m1;i++) {
			for(int j=0;j<n2;j++) {
				float toplam = 0;
				for(int k=0;k<n1;k++) {
					toplam+=matris1[i][k]*matris2[k][j];
					carpimSayisi++;
					toplamSayisi++;	
				}
				carpim[i][j]=toplam;
				
			}
		}
		
		return carpim;
	}
	public  int getCarpimSayisi() {
		return carpimSayisi;
	}
	
	public  int getToplamSayisi() {
		return toplamSayisi;
	}
}
