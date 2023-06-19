package EX2;

public class scaleup {
	public static int[][] scale(double factor_h, double factor_w, int[][] im) {
		int a = im.length, b = im[0].length;
		int a1 = (int) (a * factor_h + 1), b1 = (int) (b * factor_w + 1);
		int[][] scale = new int[a1][b1];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				for (int k = 0; k < factor_h; k++) {
					for (int x = 0; x < factor_w; x++) {
						int i1 = (int) Math.floor((i + factor_h) + k), j1 = (int) Math.floor((j * factor_w) + x);
						scale[i1][j1] = im[i][j];
					}
				}
			}
		}
		return scale;

	}

}
