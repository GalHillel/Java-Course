package EX2;

/**
 * Image Rotation Utility
 * 
 * This class provides functionality to rotate an RGB image 90 degrees
 * clockwise.
 * The rotation transforms the image such that the top edge becomes the right
 * edge.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class Rotate90 {

    /**
     * Rotates an RGB image 90 degrees clockwise.
     * 
     * Algorithm: For a clockwise 90° rotation, the pixel at position (row, col)
     * in the original image moves to position (col, height-1-row) in the rotated
     * image.
     * 
     * @param rgbImage 3D array representing RGB image [channel][height][width]
     *                 where channel 0=Red, 1=Green, 2=Blue
     * @return Rotated 3D RGB image array [channel][width][height]
     */
    public static int[][][] rotate(int[][][] rgbImage) {
        int originalHeight = rgbImage[0].length;
        int originalWidth = rgbImage[0][0].length;

        // Rotated image dimensions are swapped
        int[][][] rotatedImage = new int[3][originalWidth][originalHeight];

        // Process each color channel
        for (int channel = 0; channel < 3; channel++) {
            for (int row = 0; row < originalHeight; row++) {
                for (int col = 0; col < originalWidth; col++) {
                    // 90° clockwise: (row, col) -> (col, height-1-row)
                    rotatedImage[channel][col][originalHeight - 1 - row] = rgbImage[channel][row][col];
                }
            }
        }
        return rotatedImage;
    }
}
