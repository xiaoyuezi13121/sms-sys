package com.zy.po;

public class Test1 {
	public static void main(String[] args) {
		for(int i=1;i<10;i++){
			for(int j=1;j<=i;j++){
				if(i==j){
					System.out.println(j+"*"+i+"="+i*j);
				}else{
					System.out.print(j+"*"+i+"="+i*j+" ");
				}
			}
		}
	}
}
