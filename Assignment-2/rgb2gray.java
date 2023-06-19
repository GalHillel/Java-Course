package EX2;

public class rgb2gray {
	public static int[][] grayscale(int[][][] img) {
		int a = img[0].length, b = img[0][0].length;
		int[][] grayscale = new int[a][b];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				grayscale[i][j] = (int) (((0.3 * img[0][i][j]) + (0.59 * img[1][i][j]) + (0.11 * img[2][i][j])) * 255);
			}
		}
		return grayscale;
	}

}