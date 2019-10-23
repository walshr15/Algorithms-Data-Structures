
public class Check_Triangle
{


    public static final int ACUTE_TRI = 2;
    public static final int RIGHT_ANGLED_TRI = 1;
    public static final int OBTUSE_TRI = 3;
    public static final double TINY_DIFF = 0.0001;
    public static final int NOT_TRI = 0;

     static boolean form_triangle(double[] ls)
    {
//       double c = max(ls);
//       double others[] = new double[2];
//       int j=0;
//       for(int i=0; i<ls.length; i++){
//    	   if(ls[i] != c){
//    		   others[j] = ls[i];
//    		   j++;
//    	   }
//    	   else{
//    		   
//    	   }
//       }
       if(2*max(ls)>=sum(ls)){
    	   return false;
       }
       else{
    	   return true;
       }
    }

    static int kind_triangle(double[] ls)
    {
    	double c = max(ls);
        double others[] = new double[2];
        int j=0;
        if(ls[0] == ls[1] && ls[0] == ls[2]){
        	others[0] = c;
        	others[1] = c;
        }
        else{
        	if(ls[0] == ls[1] || ls[0] == ls[2] || ls[1] == ls[2]){
        		others[0] = c;
        		for(int i=0; i<ls.length; i++){
        			if(ls[i] != c){
        				others[1] = ls[i];
        				}
        			}
        		}
        	else{
        		for(int i=0; i<ls.length; i++){
        			if(ls[i] != c){
        				others[j] = ls[i];
        				j++;
        				} 		
        			}
        		}
        }
        double a = others[0];
        double b = others[1];
        if(a <= 0 || b <= 0 || c <= 0){
        	return NOT_TRI;
        }
        if(2*max(ls)>=sum(ls)){
     	   return NOT_TRI;
        }
        System.out.println(a + " " + b + " " + c);
        
        double leftHandSide = ((c*c) - ((a*a)+(b*b)));
        double cosC = leftHandSide/-2*a*b;
        if(cosC == 0){
        	return RIGHT_ANGLED_TRI;
        }
        if(cosC > 0){
        	return ACUTE_TRI;
        }
        if(cosC < 0){
        	return OBTUSE_TRI;
        }
        
       return NOT_TRI;
    }


    static double sum(double[] arr)
    {
        double result = 0;
        for (int k = 0; k < arr.length; k++)
            result += arr[k];
        return result;
    }

    static double max(double[] arr)
    {
        int j = 0;
        int k = arr.length- 1;
        while ( j < k ) {
            if (arr[j] < arr[k])
                j++;
            else
                k--;
        }
        return arr[j];
    }

    static double min(double[] arr)
    {
        int j = 0;
        int k = arr.length - 1;
        while ( j < k )
            if (arr[j] > arr[k])
                j++;
            else
                k--;
        return arr[j];
    }
}