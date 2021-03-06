package puzzles;

import java.util.Random;

public class NConsecutiveIn2DArray {
	static int N = 3;
	static int M = 4;
	static int K = 4;
	static int W = 3;
	static int[][] array = new int[N][M];

	public static void main(String[] args) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				array[i][j] = new Random().nextInt(K + 1);
			}
		}
		printArray();

		// Check Row
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int reference = array[i][j];
				if (j + W - 1 < M) {
					for (int x = 0; x < W; x++) {
						if (array[i][j + x] != reference) {
							break;
						} else {
							if (x == W - 1) {
								printInRow(reference);
								return;
							}
						}
					}
				}
			}
		}

		// Check Column
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				int reference = array[i][j];
				if (i + W - 1 < N) {
					for (int x = 0; x < W; x++) {
						if (array[i+x][j] != reference) {
							break;
						} else {
							if (x == W - 1) {
								printInRow(reference);
								return;
							}
						}
					}
				}
			}
		}
		// Check Positive Diagonal ( From Left Side Top to Right Side Bottom )
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int I = i;
				int J = j;
				int reference = array[i][j];
				if (I + W - 1 < N && J + W - 1 < M) {
					for (int x = 0; x < W; x++) {
						if (array[i + x][j + x] != reference) {
							break;
						} else {
							if (x == W - 1) {
								printInRow(reference);
								return;
							}
						}
					}
				}
			}
		}
		// Check Negative Diagonal ( From Right Side Top to Left Side Bottom )
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int reference = array[i][j];
				if (i + W - 1 < N && j + W - 1 < M) {
					for (int x = 0; x < W; x++) {
						if (array[i + x][j + x] != reference) {
							break;
						} else {
							if (x == W - 1) {
								printInRow(reference);
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("-1");
	}

	/*
	 * private static void printInColumn(int reference) { for(int i=0; i<W; i++) {
	 * System.out.println(reference+" "); } }
	 */

	private static void printInRow(int reference) {
		System.out.println();
		for (int i = 0; i < W; i++) {
			System.out.print(reference + " ");
		}
	}

	private static void printArray() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(array[i][j] + " ");
				if (j == M - 1) {
					System.out.print("\n");
				}
			}
		}
	}
}
