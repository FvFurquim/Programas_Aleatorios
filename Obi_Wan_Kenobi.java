// Obi_Wan_Kenobi.java

import java.util.Scanner;

public class Obi_Wan_Kenobi
{
	public static void main(String[] args) {
        
    Scanner input = new Scanner( System.in );
    
    String obi = input.nextLine();
    
    switch( obi ) {
        case "Hello There" :
            System.out.print( "General Kenobi" );
            break;
        case "Don´t try it,I have the high ground" :
            System.out.print( "You underestimate my power" );
            break;
            
        default :
            System.out.print( "Oh no, I'm not brave enough for politics" );
    }
    
	}
}
