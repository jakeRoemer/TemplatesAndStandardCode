package dynamicProgramming;

import java.util.Random;

public class ChainMatrixMultiply {
	
	int column;
	int row;
	static int len = 3;
	static int [][]  matrixMulti = new int [len][len];
	
	public ChainMatrixMultiply (int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	public static void main(String [] args) {
		Random rand = new Random (System.currentTimeMillis());
		ChainMatrixMultiply [] matricies = new ChainMatrixMultiply [len];
		int possibleChain = rand.nextInt(5)+1;
		for (int i = 0; i < matricies.length; i++) {
			matricies[i] = new ChainMatrixMultiply(possibleChain, possibleChain = rand.nextInt(5)+1);
		}
		printMatricies(matricies);
		System.out.println("The value for chaining matrix multiplications is " + CMM(matricies));
	}
	
	public static void printMatricies(ChainMatrixMultiply [] matricies) {
		for (int i = 0; i < matricies.length; i++) {
			System.out.print(matricies[i].column + "x" + matricies[i].row + " ");
		}
		System.out.println();
	}
	
	public static int CMM (ChainMatrixMultiply [] matricies) {
		for (int i = 0; i < matricies.length; i++) {
			for (int j = 0; j < matricies.length; j++) {
				matrixMulti[i][j] = -1;
			}
		}
		return check(0, matricies.length-1, matricies);
	}
	
	public static int check (int i, int j, ChainMatrixMultiply [] matricies) {
		if (matrixMulti[i][j] != -1) {
			return matrixMulti[i][j];
		}
		if (i == j) {
			matrixMulti[i][j] = 0;
		} else {
			int max = Integer.MAX_VALUE; //limitation if numbers are equals to integer.max_value
			int temp = -1;
			for (int p = i; p < j; p++) {
				if (matricies[p].row != matricies[p+1].column){
					System.out.println("Not a possible mutliplication chain");
				}
				temp = check(i, p, matricies) + check(p+1, j, matricies) + matricies[i].column*matricies[p].row*matricies[j].row;
				if (temp < max) {
					max = temp;
				}
			}
			matrixMulti[i][j] = max;
		}
		return matrixMulti[i][j];
	}
}
