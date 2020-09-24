/**
 * 
 */
package sort;

import utils.ArrayPrinter;
import utils.ArrayGenerator;

/**
 * @author wjg
 *
 */
public class CountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//使用计数排序的数组的元素大小必须位于[0,k)区间内
		int k = 10;
		int[] arr = ArrayGenerator.randomArray(k);
		ArrayPrinter.print(arr);
		int[] resultArr = new int[arr.length];
		
		CountingSort sort = new CountingSort();
		sort.countingSort(arr, resultArr, k);
		
		ArrayPrinter.print(resultArr);
	}
	
	/**
	 * 使用计数排序算法对给定的数组排序
	 * @param A 需要排序的数组
	 * @param B 存放排序结果的数组
	 * @param k 数组中元素必须在[0,k)区间上
	 */
	public void countingSort(int[] A, int[] B, int k) {
		//辅助数组
		int[] C = new int[k];
		for (int i=0; i<k; i++) {
			C[i] = 0;
		}
		for (int j=0; j<A.length; j++) {
			C[A[j]]++;
		}
		//C[i] now contains the number of elements equal to i.
		for (int i=1; i<k; i++) {
			C[i] += C[i - 1];
		}
		//C[i] now contains the number of elements less than or equal to i.
		for (int j = A.length - 1; j>=0; j--) {
			B[C[A[j]] - 1] = A[j];
			C[A[j]] = C[A[j]] - 1;
		}
	}
	
	/**
	 * 使用计数排序算法对给定的数组排序
	 * @param A 需要排序的数组
	 * @param B 存放排序结果的数组
	 * @param k 数组中元素必须在[0,k)区间上
	 * @return 指示排序后元素原序号的数组
	 */
	public int[] countingSortReturnOrder(int[] A, int k) {
		//辅助数组
		int[] C = new int[k];
		int[] O = new int[A.length];
		for (int i=0; i<A.length; i++) {
			O[i] = i;
		}
		for (int i=0; i<k; i++) {
			C[i] = 0;
		}
		for (int j=0; j<A.length; j++) {
			C[A[j]]++;
		}
		//C[i] now contains the number of elements equal to i.
		for (int i=1; i<k; i++) {
			C[i] += C[i - 1];
		}
		//C[i] now contains the number of elements less than or equal to i.
		for (int j = A.length - 1; j>=0; j--) {
//			B[C[A[j]] - 1] = A[j];
			O[C[A[j]] - 1] = j;
			C[A[j]] = C[A[j]] - 1;
		}
		return O;
	}

}
