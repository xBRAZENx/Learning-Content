package com.atharva.TestPrograms;

import java.util.Scanner;

public class StringOccurence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter str1");
		String str1 = sc.nextLine();
		System.out.println("Enter str2");
		String str2 = sc.nextLine();
		str2.trim();
		int count=0;
		for(int i=0;i<str1.length()-str2.length()+1;i++) {
			String cmp = str1.substring(i, i+str2.length());
			if(cmp.equals(str2))
				count++;
		}
		
		System.out.println(count);
	}
}
