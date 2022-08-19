package project.pkg1.stud.version;


import java.util.Scanner;

public class p1helper {
	
	public static void print_header(){
		System.out.println("Month\tPrincipal\tInterest\tBalance");
		System.out.println("-----\t---------\t--------\t-------");
	}
	
	public static void print_monthly_data(int month, double principal, 
		       double interest, double loaned){
		
		System.out.println( month +"\t"+ Math.round(principal*100.0)/100.0+"\t\t"+ Math.round(interest*100.0)/100.0+"\t\t"+ Math.round(loaned*100.0)/100.0);
		
	}

	
	public static double get_param(String prompt, double min, double max){
		Scanner my_double = new Scanner(System.in);
		double returned ;
		while(true){
			try{
				System.out.println(prompt);
				returned = Double.parseDouble(my_double.next());
				if(returned >=min && returned <=max){
					return returned;
				}
			} catch(Exception e){
				my_double.reset();
			}
		}
		
	}
	
}
