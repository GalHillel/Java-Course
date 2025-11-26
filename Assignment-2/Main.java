package EX2;

/**
 * Assignment 2: Image Processing Demonstration
 * 
 * This class demonstrates various image processing operations including:
 * - 90-degree rotation
 * - Smoothing (blur filter)
 * - RGB to grayscale conversion
 * - Image scaling (both up and down)
 * 
 * @author University Assignment
 * @version 1.0
 */
public class Main {

	/**
	 * Main method that executes all image processing demonstrations.
	 * Reads a source image and applies various transformations, saving
	 * each result to a separate output file.
	 * 
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {

		System.out.println("start");

		// Load source image
		int[][][] sourceImage = MyImageIO.readImageFromFile("C:\\42104.jpg");

		// ========== Rotate 90 Degrees ==========
		try {
			int[][][] rotatedImage = EX2.Rotate90.rotate(sourceImage);
			MyImageIO.writeImageToFile("rotate90", rotatedImage);
		} catch (Exception e) {
			System.out.println("Error during rotation:");
			e.printStackTrace();
		}

		// ========== Apply Smoothing Filter ==========
		try {
			int[][][] smoothedImage = EX2.SmoothImage.applySmoothing(sourceImage, 10);
			MyImageIO.writeImageToFile("smooth", smoothedImage);
		} catch (Exception e) {
			System.out.println("Error during smoothing:");
			e.printStackTrace();
		}

		// ========== Convert to Grayscale ==========
		int[][] grayImage = null;
		try {
			grayImage = EX2.RgbToGray.grayscale(sourceImage);
			MyImageIO.writeImageToFile("grayImage", grayImage);
		} catch (Exception e) {
			System.out.println("Error during grayscale conversion:");
			e.printStackTrace();
		}

		// ========== Scale Up Image ==========
		try {
			int[][] scaledUpImage = EX2.ScaleImage.scale(2, 2, grayImage);
			MyImageIO.writeImageToFile("scalledUpImage", scaledUpImage);
		} catch (Exception e) {
			System.out.println("Error during scale up:");
			e.printStackTrace();
		}

		// ========== Scale Down Image ==========
		try {
			int[][] scaledDownImage = EX2.ScaleImage.scale(1, 4.3, grayImage);
			MyImageIO.writeImageToFile("scalledDownImage", scaledDownImage);
		} catch (Exception e) {
			System.out.println("Error during scale down:");
			e.printStackTrace();
		}

		System.out.println("done");

	}

}
