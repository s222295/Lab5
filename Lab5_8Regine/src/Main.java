
public class Main {

	final static int queensNumber = 8;
	final static boolean debug = false;

	public static void main(String[] args) {
		
		System.out.println("Let's start!");
		
		if (debug) {
			
			int [][] queensMatrixDebugT = { 	{1,0,0,0,0,0,0,0},
												{0,0,0,0,1,0,0,0},
												{0,0,0,0,0,0,0,1},
												{0,0,0,0,0,1,0,0},
												{0,0,1,0,0,0,0,0},
												{0,0,0,0,0,0,1,0},
												{0,1,0,0,0,0,0,0},
												{0,0,0,1,0,0,0,0}	};
			
			int [][] queensMatrixDebugF = { 	{1,0,0,0,0,0,0,0},
												{1,0,0,0,0,0,0,0},
												{0,0,0,0,0,0,0,1},
												{0,0,0,0,0,1,0,0},
												{0,0,1,0,0,0,0,0},
												{0,0,0,0,0,0,1,0},
												{0,1,0,0,0,0,0,0},
												{0,0,0,1,0,0,0,0}	};
			
			Utils.printMatrix(queensMatrixDebugT, queensNumber);
			boolean result = Utils.check(queensMatrixDebugT);
			System.out.println("Matrix Check result: " + result);
			
			Utils.printMatrix(queensMatrixDebugF, queensNumber);
			result = Utils.check(queensMatrixDebugF);
			System.out.println("Matrix Check result: " + result);
		}
	
		
		// Create and initialize matrix;
		int[][] matrix = new int[queensNumber][queensNumber];
		
		Utils.initializeMatrix(matrix);
		RecursiveQueens1 rq1 = new RecursiveQueens1();
		int c1 = rq1.queensSolver1(matrix);
		System.out.println("Numero di soluzioni trovate: " + c1 );
		
		Utils.initializeMatrix(matrix);
		RecursiveQueens2 rq2 = new RecursiveQueens2();
		int c2 = rq2.queensSolver2(matrix);
		System.out.println("Numero di soluzioni trovate: " + c2 );
		
		Utils.initializeMatrix(matrix);
		RecursiveQueens3 rq3 = new RecursiveQueens3();
		int c3 = rq3.queensSolver3(matrix);
		System.out.println("Numero di soluzioni trovate: " + c3 );

		return;
	}
	
}
