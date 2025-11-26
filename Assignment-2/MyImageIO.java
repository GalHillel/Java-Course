package EX2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Image Input/Output Utility
 * 
 * This class provides functionality to read images from files and write
 * RGB or grayscale image arrays back to files in JPEG format.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class MyImageIO {

	/**
	 * Reads an image file and converts it to a 3D RGB array.
	 * 
	 * @param fileName Path to the image file to read
	 * @return 3D array [channel][height][width] where channel 0=Red, 1=Green,
	 *         2=Blue,
	 *         or null if file cannot be read
	 */
	public static int[][][] readImageFromFile(String fileName) {
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(fileName));
			int imageHeight = bufferedImage.getHeight();
			int imageWidth = bufferedImage.getWidth();
			int[][][] rgbArray = new int[3][imageHeight][imageWidth];

			// Extract RGB values for each pixel
			for (int row = 0; row < imageHeight; row++) {
				for (int col = 0; col < imageWidth; col++) {
					Color pixelColor = new Color(bufferedImage.getRGB(col, row));
					rgbArray[0][row][col] = pixelColor.getRed();
					rgbArray[1][row][col] = pixelColor.getGreen();
					rgbArray[2][row][col] = pixelColor.getBlue();
				}
			}
			return rgbArray;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Writes an RGB image array to a JPEG file.
	 * 
	 * @param fileName Output file name (without extension; .jpg will be appended)
	 * @param pixels   3D array [channel][height][width] representing RGB image
	 */
	public static void writeImageToFile(String fileName, int[][][] pixels) {
		int imageWidth = pixels[0][0].length;
		int imageHeight = pixels[0].length;
		BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.createGraphics();

		// Draw each pixel
		for (int row = 0; row < imageHeight; row++) {
			for (int col = 0; col < imageWidth; col++) {
				graphics.setColor(new Color(pixels[0][row][col], pixels[1][row][col], pixels[2][row][col]));
				graphics.fillRect(col, row, 1, 1);
			}
		}

		try {
			fileName = fileName + ".jpg";
			ImageIO.write(bufferedImage, "jpg", new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes a grayscale image array to a JPEG file.
	 * 
	 * @param fileName Output file name (without extension; .jpg will be appended)
	 * @param pixels   2D array [height][width] representing grayscale image
	 */
	public static void writeImageToFile(String fileName, int[][] pixels) {
		int imageWidth = pixels[0].length;
		int imageHeight = pixels.length;
		BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_BYTE_GRAY);

		// Set each pixel value
		for (int row = 0; row < imageHeight; row++) {
			for (int col = 0; col < imageWidth; col++) {
				bufferedImage.setRGB(col, row, pixels[row][col]);
			}
		}

		try {
			fileName = fileName + ".jpg";
			ImageIO.write(bufferedImage, "jpg", new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
