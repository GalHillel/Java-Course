package EX2;

/**
 * RGB to Grayscale Image Converter
 * 
 * This class provides functionality to convert a color (RGB) image to grayscale
 * using the luminosity method, which weights the color channels based on human
 * perception (30% Red, 59% Green, 11% Blue).
 * 
 * @author University Assignment
 * @version 1.0
 */
public class RgbToGray {

    /**
     * Converts an RGB color image to grayscale using the luminosity formula.
     * The formula applies perceptual weights: 0.3*R + 0.59*G + 0.11*B
     * 
     * @param rgbImage 3D array representing RGB image [channel][height][width]
     *                 where channel 0=Red, 1=Green, 2=Blue
     * @return 2D grayscale image array [height][width] with values 0-255
     */
    public static int[][] grayscale(int[][][] rgbImage) {
        int imageHeight = rgbImage[0].length;
        int imageWidth = rgbImage[0][0].length;
        int[][] grayscaleImage = new int[imageHeight][imageWidth];

        for (int row = 0; row < imageHeight; row++) {
            for (int col = 0; col < imageWidth; col++) {
                // Apply luminosity formula: weighted sum of RGB channels
                grayscaleImage[row][col] = (int) ((0.3 * rgbImage[0][row][col]) +
                        (0.59 * rgbImage[1][row][col]) +
                        (0.11 * rgbImage[2][row][col])) * 255;
            }
        }
        return grayscaleImage;
    }
}
