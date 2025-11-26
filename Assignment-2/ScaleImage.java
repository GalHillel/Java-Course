package EX2;

/**
 * Image Scaling Utility
 * 
 * This class provides functionality to scale grayscale images up or down
 * using a simple nearest-neighbor scaling algorithm.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class ScaleImage {

    /**
     * Scales a grayscale image by specified height and width factors.
     * 
     * Uses a nearest-neighbor algorithm where each pixel in the source image
     * is replicated across multiple pixels in the scaled image.
     * 
     * @param heightFactor Scaling factor for height (e.g., 2.0 doubles height, 0.5
     *                     halves it)
     * @param widthFactor  Scaling factor for width (e.g., 2.0 doubles width, 0.5
     *                     halves it)
     * @param sourceImage  2D grayscale image array [height][width]
     * @return Scaled 2D grayscale image array
     */
    public static int[][] scale(double heightFactor, double widthFactor, int[][] sourceImage) {
        int originalHeight = sourceImage.length;
        int originalWidth = sourceImage[0].length;

        int scaledHeight = (int) (originalHeight * heightFactor + 1);
        int scaledWidth = (int) (originalWidth * widthFactor + 1);
        int[][] scaledImage = new int[scaledHeight][scaledWidth];

        // Map each source pixel to its corresponding region in the scaled image
        for (int row = 0; row < originalHeight; row++) {
            for (int col = 0; col < originalWidth; col++) {
                // Replicate the pixel across the scaled region
                for (int heightOffset = 0; heightOffset < heightFactor; heightOffset++) {
                    for (int widthOffset = 0; widthOffset < widthFactor; widthOffset++) {
                        int scaledRow = (int) Math.floor((row + heightFactor) + heightOffset);
                        int scaledCol = (int) Math.floor((col * widthFactor) + widthOffset);
                        scaledImage[scaledRow][scaledCol] = sourceImage[row][col];
                    }
                }
            }
        }
        return scaledImage;
    }
}
