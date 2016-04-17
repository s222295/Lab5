
public class RecursiveQueens1 {
	
	/*
	 *	Global Variables
	 */
	final static int queensNumber = 8;
	static int solutionsCounter = 0;
	
	public int queensSolver1(int[][] matrix){
		recursiveQeensSolver1(matrix, 0);
		return solutionsCounter;
	}
	
	/*
	 * FUNZIONE RICORSIVA:
	 * Il parametro level identifica il livello nell'albero della ricorsione.
	 * Nel caso del problema delle 8 regine, identifica la riga in cui si andrà
	 * a posizionare una nuova regina.
	 */
	private void recursiveQeensSolver1(int[][] matrix, int level) {

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

			// Controlla se non viola le condizioni
			if (Utils.check(matrix))
				// Chiama la funzione ricorsiva
				recursiveQeensSolver1(matrix, level + 1);

			// Backtracking: rimuovo la regina appena aggiunta
			matrix[level][i] = 0;
		}
	}

}