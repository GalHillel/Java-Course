package EX2;

public class rotate90 {
	public static int[][][] rotate(int[][][] img) {
		int h = img[0].length, w = img[0][0].length;
		int[][][] rotate = new int[3][w][h];
		for (int n = 0; n < 3; n++) {
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					rotate[n][j][h - 1 - i] = img[n][i][j];
				}
			}
		}
		return rotate;

	}

}
