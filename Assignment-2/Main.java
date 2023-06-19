package EX2;

public class Main {

	public static void main(String[] args) {

		System.out.println("start");

		int[][][] myImage = MyImageIO.readImageFromFile("C:\\42104.jpg");

		// rotate90
		try {
			int[][][] rotate90 = EX2.rotate90.rotate(myImage);
			MyImageIO.writeImageToFile("rotate90.jpg", rotate90);
		} catch (Exception e) {
			System.out.println("rotate 90");
			e.printStackTrace();
		}

		// Smooth
		try {
			int[][][] smooth = EX2.smooth.Smooth(myImage, 10);
			MyImageIO.writeImageToFile("smooth.jpg", smooth);
		} catch (Exception e) {
			System.out.println("Smooth");
			e.printStackTrace();
		}

		// rgb2gray
		int[][] grayImage = null;
		try {
			grayImage = EX2.rgb2gray.grayscale(myImage);
			MyImageIO.writeImageToFile("grayImage.jpg", grayImage);
		} catch (Exception e) {
			System.out.println("rgb2gray");
			e.printStackTrace();
		}
		// scale
		try {
			int[][] scalledUpImage = EX2.scaleup.scale(2, 2, grayImage);
			MyImageIO.writeImageToFile("scalledUpImage.jpg", scalledUpImage);
		} catch (Exception e) {
			System.out.println("scale up");
			e.printStackTrace();
		}

		try {
			int[][] scalledDownImage = EX2.scaleup.scale(1, 4.3, grayImage);
			MyImageIO.writeImageToFile("scalledDownImage.jpg", scalledDownImage);
		} catch (Exception e) {
			System.out.println("scale down");
			e.printStackTrace();
		}

		System.out.println("done");

	}

}
