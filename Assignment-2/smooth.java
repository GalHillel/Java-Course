package EX2;

public class smooth {
	public static int[][][] Smooth(int[][][] img, int n) {
		int a = img[0].length, b = img[0][0].length;
		int[][][] smooth = new int[3][a][b];
		for (int num = 0; num < 3; num++) {
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					int ps = 0, pc = 1;
					for (int h = -num; h < num; h++) {
						if (i - h < 0 || i + h < 0)
							continue;
						else if (i + h >= a)
							break;
						for (int c = -num; c <= num; c++) {
							if ((j + c) < 0 || (j - c) < 0)
								continue;
							else if (j + c >= b)
								break;

							ps += img[num][i + h][j + c];
							pc++;

						}
					}
					smooth[num][i][j] = ps / pc;
				}
			}
		}
		return smooth;
	}

}
