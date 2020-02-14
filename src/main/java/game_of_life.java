public class game_of_life {
        static String Change(String[][] cells) {
            int w = 10, h = 10;
            int[][] grid = new int[w][h];

            for (int i = 0; i < 10; i++) {
                for (int x = 0; x < 10; x++) {
                    if (cells[i][x].equals("+")) {
                        grid[i][x] = 0;
                    } else grid[i][x] = 1;
                }
            }
            System.out.println("Previous Generation");
            System.out.println(PrintGenerations(w, h, grid));
            System.out.println();
            System.out.println(NextGeneration(grid, w, h));
            return NextGeneration(grid, w, h);
        }

        static String PrintGenerations(int q, int p, int[][] grid) {
            StringBuilder Generation = new StringBuilder();
            for (int i = 0; i < q; i++) {
                for (int j = 0; j < p; j++) {
                    if (grid[i][j] == 0)
                        Generation.append("+");
                    else
                        Generation.append("#");
                }
                Generation.append("\n");
            }
            return String.valueOf(Generation);
        }

        static String NextGeneration(int[][] grid, int x, int y) {
            int[][] nextGen = new int[x][y];

            for (int l = 1; l < x - 1; l++) {
                for (int m = 1; m < y - 1; m++) {

                    int LivingNeighbours = 0;
                    for (int i = -1; i <= 1; i++)
                        for (int j = -1; j <= 1; j++)
                            LivingNeighbours += grid[l + i][m + j];
                    LivingNeighbours-= grid[l][m];

                    if ((grid[l][m] == 1) && (LivingNeighbours < 2))
                        nextGen[l][m] = 0;

                    else if ((grid[l][m] == 1) && (LivingNeighbours > 3))
                        nextGen[l][m] = 0;

                    else if ((grid[l][m] == 0) && (LivingNeighbours == 3))
                        nextGen[l][m] = 1;

                    else
                        nextGen[l][m] = grid[l][m];
                }
            }
            System.out.println("Next Generation");
            return PrintGenerations(x, y, nextGen);
        }
    }



