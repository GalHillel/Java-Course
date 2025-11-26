package EX2;

/**
 * Image Smoothing Filter
 * 
 * This class provides functionality to apply a smoothing (blur) filter to RGB
 * images
 * using a box filter algorithm that averages pixel values in a neighborhood.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class SmoothImage {

    /**
     * Applies a smoothing filter to an RGB image by averaging pixel values
     * in a neighborhood around each pixel.
     * 
     * The filter uses a box blur approach where each pixel is replaced by
     * the average of itself and its neighbors within the specified radius.
     * Edge pixels use available neighbors only (no padding).
     * 
     * @param rgbImage 3D array representing RGB image [channel][height][width]
     *                 where channel 0=Red, 1=Green, 2=Blue
     * @param radius   Smoothing radius - larger values create more blur
     * @return Smoothed 3D RGB image array with same dimensions as input
     */
    public static int[][][] applySmoothing(int[][][] rgbImage, int radius) {
        int imageHeight = rgbImage[0].length;
        int imageWidth = rgbImage[0][0].length;
        int[][][] smoothedImage = new int[3][imageHeight][imageWidth];

        // Process each color channel independently
        for (int channel = 0; channel < 3; channel++) {
            for (int row = 0; row < imageHeight; row++) {
                for (int col = 0; col < imageWidth; col++) {
                    int pixelSum = 0;
                    int pixelCount = 1;

                    // Sum all pixels in the neighborhood
                    for (int verticalOffset = -channel; verticalOffset < channel; verticalOffset++) {
                        // Skip pixels outside image bounds
                        if (row - verticalOffset < 0 || row + verticalOffset < 0)
                            continue;
                        else if (row + verticalOffset >= imageHeight)
                            break;

                        for (int horizontalOffset = -channel; horizontalOffset <= channel; horizontalOffset++) {
                            // Skip pixels outside image bounds
                            if ((col + horizontalOffset) < 0 || (col - horizontalOffset) < 0)
                                continue;
                            else if (col + horizontalOffset >= imageWidth)
                                break;

                            pixelSum += rgbImage[channel][row + verticalOffset][col + horizontalOffset];
                            pixelCount++;
                        }
                    }

                    // Set pixel to average of neighborhood
                    smoothedImage[channel][row][col] = pixelSum / pixelCount;
                }
            }
        }
        return smoothedImage;
    }
}
