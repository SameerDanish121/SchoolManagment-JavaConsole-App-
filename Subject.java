package PROJECT;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Subject {
public String Subject[]=new String[10];
public int SID[]=new int[10];
Scanner sc=new Scanner(System.in);
int index=-1;
public void insert(String no,int yes) {
	 if(Subject==null) {
		 Subject[0]=no;
		 SID[0]=yes;
		 index++;
	 }else {
		 index++;
		 Subject[index]=no;
		 SID[index]=yes;
	 }
}
public void DisplaySubject() {
	if(index==-1) {
		System.out.println("NO subject");
	}else {
		System.out.println("NO    ID    NAME");
		System.out.println("----------------");
		
	for(int i=0;i<=index;i++) {
	System.out.println((i+1)+"     "+SID[i]+"     "+Subject[i]);
	}	}
}
public String ChoseByID(int ID) {
	 String chosedSubject=null;
	 for(int i=0;i<=index;i++) {
	 if(ID==SID[i]) {
	 return chosedSubject=Subject[i]; 
	 }
	 }
	 return chosedSubject;
}
public void RemoveSubject() {
	if(index==-1) {
		System.out.println("NO DATA TO BE DELETD");
	}else {
	System.out.print("i) .Enter subject id you want to delete");
	int abc=sc.nextInt();
    int temp1[]=new int[SID.length-1];
	String[]  temp=new String[SID.length-1];
	int k=0;
	for(int i=0;i<=index;i++) {
		if(SID[i]!=abc) {
			temp1[k]=SID[i];
			temp[k]=Subject[i];
			k++;
		}
	}
	SID=temp1;
	Subject=temp;
	index--;
		
		}
}


}


