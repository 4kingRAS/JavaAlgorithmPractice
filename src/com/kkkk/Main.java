package com.kkkk;

import java.util.Scanner;
import com.kkkk.sort.BasicSort;

public class Main {

    public static void main(String[] args) {
	    Utils utils = new Utils();
	    BasicSort basicSort = new BasicSort();
        Scanner scanner = new Scanner(System.in);
		int a[] = new int[6];

		for (int i = 0; i < 6; i++) {
			a[i] = scanner.nextInt();
		}
		basicSort.bubbleSort(a);
	    for (int i = 0; i < 6; i++) {
			System.out.println(a[i]);
		}
    }

}
