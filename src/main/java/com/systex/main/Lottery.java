package com.systex.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lottery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("請輸入抽獎的組數： ");
		int numSets = scanner.nextInt();
		
		System.out.println("請輸入要排除的數字(1~49)(以空格分割)： ");
		scanner.nextLine()	;
		String excludeInput  = scanner.nextLine();
		String[] excludeString = excludeInput.split(" ");
		Set<Integer> excludeNumbers = new HashSet<>();
		
		for (String num : excludeString) {
		    try {
		        int excludeNum = Integer.parseInt(num);
		        if (excludeNum < 1 || excludeNum > 49) {
		            System.out.println("輸入的排除數字不在1到49的範圍內：" + excludeNum);
		        } else {
		            excludeNumbers.add(excludeNum);
		        }
		    } catch (NumberFormatException e) {
		        System.out.println("輸入的排除數字格式錯誤：" + num);
		    }
		}
		
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= 49; i++) {
			if (!excludeNumbers.contains(i)) {
				numbers.add(i);
			}
		}
		
		Random random = new Random();
		for (int i = 1; i <= numSets; i++) {
			System.out.println("第 " + i + " 組");
			Collections.shuffle(numbers);
			
			for (int j = 0; j < 6; j++) {
				int index = random.nextInt(numbers.size());
				System.out.print(numbers.get(index) + " ");
			}
			System.out.println();
		}
		
		scanner.close();
	}

}
