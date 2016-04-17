
public class RecursiveQueens2 {
	
	static int solutionsCounter = 0;
	
	public int queensSolver2(int[][] matrix){
		recursiveQeensSolver2(matrix, 0);
		return solutionsCounter;
	}
	
	/*
	 * FUNZIONE RICORSIVA (prima alternativa):
	 * Il parametro level identifica il livello nell'albero della ricorsione.
	 * Nel caso del problema delle 8 regine, identifica la riga in cui si andrà
	 * a posizionare una nuova regina.
	 */
	private void recursiveQeensSolver2(int[][] matrix, int level) {

		// Controlla se non viola le condizioni
		if (!Utils.check(matrix))
			return;
		
		// Condizione di terminazione
		if (level == Main.queensNumber) {
			// Ho trovato una nuova soluzione: incremento il contatore e stampo
			// la matrice.
			solutionsCounter++;
			if (Main.debug) {
				Utils.printMatrix(matrix, Main.queensNumber);
			}
			return;
		}

		// Per ciascuna colonna
		for (int i = 0; i < Main.queensNumber; i++) {

			// Aggiungi una nuova regina sulla riga corrente
			matrix[level][i] = 1;

			// Chiama la funzione ricorsiva
			recursiveQeensSolver2(matrix, level + 1);

			// Backtracking: rimuovo la regina appena aggiunta
			matrix[level][i] = 0;
		}
	}

}
