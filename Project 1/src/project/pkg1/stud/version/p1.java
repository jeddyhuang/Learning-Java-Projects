package project.pkg1.stud.version;



public class p1 extends p1helper {
	/*	Functions
		public static void print_header();
		
		public static void print_monthly_data (int month, double principal, 
			       double interest, double loaned);
			       
		double get_param(string prompt, double min, double max);
			       
	 */
	
	public static void main(String[] args) {
		
		double monthly_payment = get_param("Please enter the monthly payment: ", 1, 1000000);
                //interest can be in a decimal or relative to 100
                double interest = get_param("Please enter the interest rate: ", 0, 1);
                
                double years = get_param("Please enter the duration of the loan, in years:", 1, 100);
                
		//print_monthly_data (int month, double principal, double interest, double loaned)		
		print_header();

            double andrew = 0;
            /*
            set a temporary integer
            */
            for(int i = 0; i < years*12 ; i++){
                /*
                loop it so that it runs for every month
                */
                andrew = (12*(andrew+monthly_payment)/(interest + 12));
                /*
                solve for the initial balance from the updated balance formula
                */
                print_monthly_data((int)(years*12) - i, monthly_payment - andrew * interest/12, andrew * interest/12, andrew);
                /*
                fill in the header with the appropriate fillings
                */
            }
	
		
	}

}
