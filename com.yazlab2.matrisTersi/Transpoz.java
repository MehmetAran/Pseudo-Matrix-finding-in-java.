
public class Transpoz {
	
	public float[][] transpozeAl(float[][] matris){
		int m=matris.length;
		int n=matris[0].length;
		float[][] tMatris = new float[n][m];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				tMatris[j][i]=matris[i][j];
			}
		}
		
		return tMatris;
	}

}
