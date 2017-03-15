package basic;

public class maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat=new int[5][5];
		int k=0;
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				mat[i][j]=k++;
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
	}
		for(int i=0;i<mat[0].length;i++){
			int k1=0;
			int temp=i;
			System.out.print(mat[k1][i] + " ");
			while((++i<mat.length) && (++k1<mat[0].length))
			{
				System.out.print(mat[i][k1]+" ");
			}
			i=temp;
			System.out.println();
		}
		for(int i=1;i<mat.length;i++){
			int k1=0;
			int temp=i;
			System.out.print(mat[i][k1]+ " ");
			while((++i<mat.length)&&(++k1<mat[0].length)){
				System.out.print(mat[i][k1]+ " ");
			}
			i=temp;
			System.out.println();
		}
		
	}

}
