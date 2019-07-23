import java.util.Arrays;
/*
 * This class used to calculate addition, multiplication, transpose,
 * and symmetric of sparse matrix.
 */
public final class SparseMatrix {

	public int[][] sparseMatrix;
	public int numberOfRow;
	public int numberOfColumn;

	/*
	 * Constructor to assign values to sparse matrix, row, column.
	 * @param inputMatrix This is input matrix.
	 */
	public SparseMatrix(int[][] inputMatrix) {
		sparseMatrix = inputMatrix;
		numberOfRow = inputMatrix.length;
		numberOfColumn = inputMatrix[0].length;
	}

	/*
	 * This method is used to converts the sparse matrix to Triplet Matrix.
	 * @param inputMatrix is the sparse matrix which is to be converted.
	 * @return this return triplet matrix.
	 */
	public int[][] convertSparseToTripletMatrix(int[][] inputMatrix) {
		int numberOfNonZeros = 0;
		
		for (int index1 = 0; index1 < numberOfRow; index1++) {
			for (int index2 = 0; index2 < numberOfColumn; index2++) {
				
				if (inputMatrix[index1][index2] != 0)
					numberOfNonZeros++;
			}
		}
		
		int[][] tripletMatrix = new int[numberOfNonZeros][3];
		int tripletMatrixIndex = 0;
		
		for (int index1 = 0; index1 < numberOfRow; index1++) {
			for (int index2 = 0; index2 < numberOfColumn; index2++) {
				
				if (inputMatrix[index1][index2] != 0) {
					tripletMatrix[tripletMatrixIndex][0] = index1;
					tripletMatrix[tripletMatrixIndex][1] = index2;
					tripletMatrix[tripletMatrixIndex][2] = inputMatrix[index1][index2];
					tripletMatrixIndex++;
				}
			}
		}

		return tripletMatrix;
	}

	/*
	 * This Method is used to convert triplet matrix to sparse matrix
	 * @param inputMatrix, matrix without zeroes
	 * @param row, no of rows in the input matrix
	 * @param col, no of columns in the input matrix
	 * @return This return Sparse Matrix.
	 */
	public int[][] convertTripletToSparseMatrix(int[][] inputMatrix, int row, int col) {

		int sparseMatrix[][] = new int[row][col];
		
		for (int index = 0; index < inputMatrix.length; index++) {
			
			if (inputMatrix[index][2] == 0)
				break;
			
			int rowIndex = inputMatrix[index][0];
			int colIndex = inputMatrix[index][1];
			sparseMatrix[rowIndex][colIndex] = inputMatrix[index][2];
		}

		return sparseMatrix;
	}

	/*
	 * This method calculates the transpose of the sparse matrix.
	 * @return Transpose of the Sparse Matrix
	 */
	public int[][] transposeOfSparseMatrix() {
		
		assert getSparseMatrix().length == 0 : "Matrix size is zero";

		int[][] matrix = convertSparseToTripletMatrix(this.getSparseMatrix());
		int[][] transposeMatrix = new int[matrix.length][3];

		for (int index = 0; index < matrix.length; index++) {
			transposeMatrix[index][0] = matrix[index][1];
			transposeMatrix[index][1] = matrix[index][0];
			transposeMatrix[index][2] = matrix[index][2];
		}

		return convertTripletToSparseMatrix(transposeMatrix, numberOfColumn,numberOfRow);
	}
	
	/*
	 * This method checks whether the sparse matrix is symmetric or not
	 * @return This return true if symmetric else false.
	 */
	public boolean isSparseMatrixSymmetric() {
		assert numberOfRow != numberOfColumn : "Only square matrix can be symmetric";

		int[][] sparseTransposeMatrix = transposeOfSparseMatrix();

		if (Arrays.deepEquals(this.getSparseMatrix(), sparseTransposeMatrix))
			return true;
		else
			return false;
	}

	/*
	 * This method adds two sparse matrices.
	 * @param inputMatrix is the matrix whose addition is to be carried out with the current matrix
	 * @return addition of the given two matrices
	 */
	public int[][] addTwoSparseMatrices(int[][] inputMatrix) {
		int[][] tripletMatrix1 = convertSparseToTripletMatrix(getSparseMatrix());
		int[][] tripletMatrix2 = convertSparseToTripletMatrix(inputMatrix);
		int[][] resultantMatrix = new int[tripletMatrix1.length + tripletMatrix2.length][3];

		assert tripletMatrix1.length == 0 || tripletMatrix2.length == 0 : "Matrices cannot be added";

		if (numberOfRow == inputMatrix.length && numberOfColumn == inputMatrix[0].length) {
			int rowOfMatrix1;
			int columnOfMatrix1;
			int resultantMatrixRow = 0;

			for (int index = 0; index < tripletMatrix1.length; index++) {
				rowOfMatrix1 = tripletMatrix1[index][0];
				columnOfMatrix1 = tripletMatrix1[index][1];

				int index1 = indexAlreadyPresent(tripletMatrix2, rowOfMatrix1,columnOfMatrix1);

				if (index1 >= 0) {
					resultantMatrix[resultantMatrixRow][0] = rowOfMatrix1;
					resultantMatrix[resultantMatrixRow][1] = columnOfMatrix1;
					resultantMatrix[resultantMatrixRow][2] = tripletMatrix1[index][2] + tripletMatrix2[index1][2];
					resultantMatrixRow++;
				} else {
					resultantMatrix[resultantMatrixRow][0] = rowOfMatrix1;
					resultantMatrix[resultantMatrixRow][1] = columnOfMatrix1;
					resultantMatrix[resultantMatrixRow][2] = tripletMatrix1[index][2];
					resultantMatrixRow++;
				}
			}

			for (int index1 = 0; index1 < tripletMatrix2.length; index1++) {
				
				int index = indexAlreadyPresent(resultantMatrix, tripletMatrix2[index1][0], tripletMatrix2[index1][1]);
				
				if (index < 0) {

					resultantMatrix[resultantMatrixRow][0] = tripletMatrix2[index1][0];
					resultantMatrix[resultantMatrixRow][1] = tripletMatrix2[index1][1];
					resultantMatrix[resultantMatrixRow][2] = tripletMatrix2[index1][2];
					resultantMatrixRow++;
				}
			}

		} else
			throw new AssertionError("Matrices size are unequal");

		return convertTripletToSparseMatrix(resultantMatrix, numberOfRow, numberOfColumn);
	}

	/*
	 * This method is used to multiplies two sparse matrices
	 * @param inputMatrix is the matrix whose multiplication is to be carried out with
	 * the current matrix
	 * @return product of the given two matrices
	 */
	public int[][] multiplySparseMatrix(int[][] inputMatrix) {
		int[][] matrix1 = getSparseMatrix();
		int[][] productMatrix = new int[numberOfRow][inputMatrix[0].length];

		assert numberOfColumn != inputMatrix.length : "Matrices cannot be multiplied";

		for (int index1 = 0; index1 < numberOfRow; index1++) {
			for (int index2 = 0; index2 < inputMatrix[0].length; index2++) {
				for (int index3 = 0; index3 < inputMatrix.length; index3++) {
					productMatrix[index1][index2] += matrix1[index1][index3] * inputMatrix[index3][index2];
				}
			}
		}

		return productMatrix;
	}

	/*
	 * This method checks whether the given row and column index are present in
	 * the matrix
	 * @param matrixToBeChecked is the matrix in which the checking is to be done
	 * @param rowToBeChecked is the row index which is to be checked
	 * @param ColumnTobeChecked is the column index which is to be checked
	 * @return  index where the indices are found
	 */
	public int indexAlreadyPresent(int[][] matrixToBeChecked, int rowToBeChecked, int ColumnTobeChecked) {
		
		int answer = -1;
		
		for (int index = 0; index < matrixToBeChecked.length; index++) {
			
			if ((matrixToBeChecked[index][0] == rowToBeChecked) && (matrixToBeChecked[index][1] == ColumnTobeChecked)) {
				answer = index;
				break;
			}
		}
		return answer;
	}

	/*
	 * This method returns the sparse matrix.
	 * @return This return Sparse matrix.
	 */
	public int[][] getSparseMatrix() {
		return sparseMatrix;
	}

	/*
	 * This method returns the number of rows in the Sparse Matrix.
	 * @return this return Number of Rows in the Sparse Matrix.
	 */
	public int getRow() {
		return numberOfRow;
	}

	/*
	 * This method returns the number of columns in the Sparse Matrix.
	 * @return This return Number of Columns in the Sparse Matrix.
	 */
	public int getColumn() {
		return numberOfColumn;
	}

}
