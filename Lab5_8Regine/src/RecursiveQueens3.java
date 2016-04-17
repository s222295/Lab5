
public class RecursiveQueens3 {

	/*
	 *	Global Variables
	 */
	int solutionsCounter = 0;
	
	public int queensSolver3(int[][] matrix){
		recursiveQeensSolver3(matrix, 0);
		return solutionsCounter;
	}
	
	/*
	 * FUNZIONE RICORSIVA (seconda alternativa): restituisce una sola soluzione
	 * Il parametro level identifica il livello nell'albero della ricorsione.
	 * Nel caso del problema delle 8 regine, identifica la riga in cui si andrà
	 * a posizionare una nuova regina.
	 */
	private boolean recursiveQeensSolver3(int[][] matrix, int level) {

		// Controlla se non viola le condizioni
		if (!Utils.check(matrix))
			return false;
		
		// Condizione di terminazione
		if (level == Main.queensNumber) {
			// Ho trovato una nuova soluzione: incremento il contatore e stampo
			// la matrice.
			solutionsCounter++;
			if (Main.debug) {
				Utils.printMatrix(matrix, Main.queensNumber);
			}
			return true;
		}

		// Per ciascuna colonna
		for (int i = 0; i < Main.queensNumber; i++) {

			// Aggiungi una nuova regina sulla riga corrente
			matrix[level][i] = 1;

			// Chiama la funzione ricorsiva
			if (recursiveQeensSolver3(matrix, level + 1))
				return true;

			// Backtracking: rimuovo la regina appena aggiunta
			matrix[level][i] = 0;
		}
		return false;
	}
}
