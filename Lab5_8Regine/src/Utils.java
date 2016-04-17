
public class Utils {

	/*
	 * Metodo wrapper per il controllo delle diagonali e delle regine.
	 */
	static boolean check(int[][] matrix) {

		// Solo se il controllo delle colonne ha successo, allora controlla anche le diagonali.
		if (checkColumns(matrix, Main.queensNumber))
			return checkDiagonals(matrix, Main.queensNumber);

		// Se il controllo delle colonne fallisce, ritorna false.
		return false;
	}

	/*
	 * Controllo che per ogni colonna ci sia una sola regina.
	 */
	private static boolean checkColumns(int[][] matrix, int n) {

		// Per ciascuna colonna
		for (int i = 0; i < n; i++) {
			int sum = 0;

			// Somma tutte le righe
			for (int j = 0; j < n; j++)
				sum += matrix[j][i];

			// Se la somma è maggiore di uno c'è più di una regina in quella colonna
			if (sum > 1)
				return false;
		}

		// Controllo avvenuto con successo
		return true;
	}

	/*
	 * Controllo che su ciascuna diagonale (principale e secondaria) ci sia una
	 * sola regina.
	 */
	private static boolean checkDiagonals(int[][] matrix, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (matrix[i][j] == 1) {
					// Ho trovato una regina

					int sommaDiagonalePrincipale = 0;
					int sommaDiagonaleSecondaria = 0;

					int k = 0;
					for (int h = 0; h < n; h++, k++) {
						// Diagonale principale:
						int offset = j - i;
						// Calcola l'offset tra la diagonale principale e quella
						// dove si trova la regina corrente.
						int b = k + offset;
						if (h == k && b >= 0 && b < n) {
							sommaDiagonalePrincipale += matrix[h][b];
						}
					}

					k = n - 1;
					for (int h = 0; h < n; h++, k--) {
						// Diagonale Secondaria:
						int offset = (n - 1) - (i + j);
						// Calcola l'offset tra la diagonale secondaria e quella
						// dove si trova la regina corrente.
						int b = k - offset;
						if (h + k == (n - 1) && b >= 0 && b < n) {
							sommaDiagonaleSecondaria += matrix[h][b];
						}
					}
					if (sommaDiagonalePrincipale > 1 || sommaDiagonaleSecondaria > 1) {
						return false;
					}
				}
			}
		}

		return true;
	}

	/*
	 * Stampa la matrice sulla console.
	 */
	static void printMatrix(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1)
					System.out.print("x ");
				else
					System.out.print("- ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	/*
	 * Inizializza la matrice
	 */
	static int[][] initializeMatrix(int[][] matrix) {
		for (int i = 0; i < Main.queensNumber; i++) {
			for (int j = 0; j < Main.queensNumber; j++) {
				matrix[i][j] = 0;
			}
		}
		return matrix;
	}

}
