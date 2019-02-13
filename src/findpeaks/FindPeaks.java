/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findpeaks;

/**
 *
 * @author Bartosz
 */
public class FindPeaks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] grid = {
            {10, 1, 1, 1, 1},
            {1, 1, 1, 1, 10},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {10, 1, 1, 1, 1}
        };
        int RADIUS = 2;

       
        iterateGrid(grid, RADIUS);

    }

    public static void iterateGrid(int[][] grid, int radius) {
        boolean result = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result = isPeak(grid, i, j, radius);
                if (result) {
                    System.out.println(i + "," + j + "|" + grid[i][j]);
                }
            }
        }
    }

    public static boolean isPeak(int[][] grid, int x, int y, int radius) {

        int minX = Math.max(x - radius, 0);
        int maxX = Math.min(x + radius, 4);
        int minY = Math.max(y - radius, 0);
        int maxY = Math.min(y + radius, 4);
        int currentValue = grid[x][y];
        boolean isPeak = true;

        for (int i = minX; i < maxX + 1; i++) {
            for (int j = minY; j < maxY + 1; j++) {
                if (!(i == x && j == y)) {
                    if (grid[i][j] >= currentValue) {
                        isPeak = false;
                        return isPeak;
                    }
                }
            }
        }
        return isPeak;
    }
}
