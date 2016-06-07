package Model;

public class EnsemblePieces{
	public static Piece[] pieces(){
		Piece[] ret = new Piece[21];
		int[][] position = new int[21][2];
		int[][][] piece = new int[21][7][7];

		// On remplie les positions
		position[0] = new int[]{-1, -1};
		position[1] = new int[]{3, -1};
		position[2] = new int[]{6, -1};
		position[3] = new int[]{9, -1};
		position[4] = new int[]{11, -1};
		position[5] = new int[]{11, 1};
		position[6] = new int[]{0, 2};
		position[7] = new int[]{5, 2};
		position[8] = new int[]{7, 4};
		position[9] = new int[]{-1, 6};
		position[10] = new int[]{2, 5};
		position[11] = new int[]{5, 5};
		position[12] = new int[]{8, 6};
		position[13] = new int[]{-1, 9};
		position[14] = new int[]{3, 9};
		position[15] = new int[]{7, 8};
		position[16] = new int[]{10, 9};
		position[17] = new int[]{-1, 12};
		position[18] = new int[]{6, 12};
		position[19] = new int[]{3, 13};
		position[20] = new int[]{7, 14};

		// On remplie les matrices
		piece[0] = new int[][]{{0, 1, 2, 2, 1, 0, 0},
							   {1, 2, 3, 3, 2, 0, 0},
							   {2, 3, 3, 2, 1, 0, 0},
							   {2, 3, 2, 1, 0, 0, 0},
							   {1, 2, 1, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0}};

		piece[1] = new int[][]{{0, 1, 2, 1, 0, 0, 0},
							   {1, 2, 3, 2, 0, 0, 0},
							   {2, 3, 3, 2, 0, 0, 0},
							   {2, 3, 2, 1, 0, 0, 0},
							   {1, 2, 1, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0}};

		piece[2] = new int[][]{{1, 2, 2, 1, 0, 0, 0},
							   {2, 3, 3, 2, 0, 0, 0},
							   {2, 3, 3, 2, 0, 0, 0},
							   {1, 2, 2, 1, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0}};

		piece[3] = new int[][]{{1, 2, 1, 0, 0, 0, 0},
							   {2, 3, 2, 0, 0, 0, 0},
							   {2, 3, 2, 0, 0, 0, 0},
							   {2, 3, 2, 0, 0, 0, 0},
							   {2, 3, 2, 0, 0, 0, 0},
							   {1, 2, 1, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0}};

		piece[4] = new int[][]{{1, 2, 1, 0, 0, 0, 0},
							   {2, 3, 2, 0, 0, 0, 0},
							   {1, 2, 1, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0}};

		piece[5] = new int[][]{{1, 2, 1, 0, 0, 0, 0},
							   {2, 3, 2, 0, 0, 0, 0},
							   {2, 3, 2, 0, 0, 0, 0},
							   {1, 2, 1, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0}};

		piece[6] = new int[][]{{0, 1, 2, 1, 0, 0, 0},
							   {1, 2, 3, 2, 1, 0, 0},
							   {2, 3, 3, 3, 2, 0, 0},
							   {1, 2, 3, 2, 1, 0, 0},
							   {0, 1, 2, 1, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0}};

		piece[7] = new int[][]{{1, 2, 2, 2, 1, 0, 0},
							   {2, 3, 3, 3, 2, 0, 0},
							   {2, 3, 2, 2, 1, 0, 0},
							   {1, 2, 1, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0}};

		piece[8] = new int[][]{{1, 2, 2, 2, 2, 2, 1},
							   {2, 3, 3, 3, 3, 3, 2},
							   {1, 2, 2, 2, 2, 2, 1},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0}};

		piece[9] = new int[][]{{0, 1, 2, 1, 0, 0, 0},
							   {1, 2, 3, 2, 0, 0, 0},
							   {2, 3, 3, 2, 0, 0, 0},
							   {1, 2, 2, 1, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0}};

		piece[10] = new int[][]{{0, 1, 2, 1, 0, 0, 0},
							    {1, 2, 3, 2, 0, 0, 0},
							    {2, 3, 3, 2, 0, 0, 0},
							    {2, 3, 3, 2, 0, 0, 0},
							    {1, 2, 2, 1, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		piece[11] = new int[][]{{1, 2, 1, 0, 0, 0, 0},
							    {2, 3, 2, 1, 0, 0, 0},
							    {2, 3, 3, 2, 0, 0, 0},
							    {2, 3, 2, 1, 0, 0, 0},
							    {1, 2, 1, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		piece[12] = new int[][]{{1, 2, 2, 2, 2, 1, 0},
							    {2, 3, 3, 3, 3, 2, 0},
							    {1, 2, 3, 2, 2, 1, 0},
							    {0, 1, 2, 1, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		piece[13] = new int[][]{{1, 2, 2, 2, 1, 0, 0},
							    {2, 3, 3, 3, 2, 0, 0},
							    {2, 3, 2, 3, 2, 0, 0},
							    {1, 2, 1, 2, 1, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		piece[14] = new int[][]{{1, 2, 2, 2, 1, 0, 0},
							    {2, 3, 3, 3, 2, 0, 0},
							    {2, 3, 2, 2, 1, 0, 0},
							    {2, 3, 2, 0, 0, 0, 0},
							    {1, 2, 1, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		piece[15] = new int[][]{{1, 2, 1, 0, 0, 0, 0},
							    {2, 3, 2, 2, 1, 0, 0},
							    {2, 3, 3, 3, 2, 0, 0},
							    {2, 3, 2, 2, 1, 0, 0},
							    {1, 2, 1, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		piece[16] = new int[][]{{0, 1, 2, 1, 0, 0, 0},
							    {0, 2, 3, 2, 0, 0, 0},
							    {1, 2, 3, 2, 0, 0, 0},
							    {2, 3, 3, 2, 0, 0, 0},
							    {2, 3, 2, 1, 0, 0, 0},
							    {1, 2, 1, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		piece[17] = new int[][]{{1, 2, 1, 0, 0, 0, 0},
							    {2, 3, 2, 2, 1, 0, 0},
							    {2, 3, 3, 3, 2, 0, 0},
							    {1, 2, 2, 3, 2, 0, 0},
							    {0, 0, 1, 2, 1, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		piece[18] = new int[][]{{1, 2, 2, 2, 1, 0, 0},
							    {2, 3, 3, 3, 2, 0, 0},
							    {1, 2, 2, 2, 1, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		piece[19] = new int[][]{{1, 2, 1, 0, 0, 0, 0},
							    {2, 3, 2, 2, 1, 0, 0},
							    {2, 3, 3, 3, 2, 0, 0},
							    {1, 2, 3, 2, 1, 0, 0},
							    {0, 1, 2, 1, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		piece[20] = new int[][]{{1, 2, 2, 2, 2, 1, 0},
							    {2, 3, 3, 3, 3, 2, 0},
							    {2, 3, 2, 2, 2, 1, 0},
							    {1, 2, 1, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0},
							    {0, 0, 0, 0, 0, 0, 0}};

		// On crée les pièces
		for(int i=0; i<21; i++){
			ret[i] = new Piece(null, piece[i], i+1);
			ret[i].setPosition(position[i]);
		}

		return ret;
	}
}