
import java.util.Scanner;

/* Class BinarySearchTree */

public class Tester
 {
     public static void main(String[] args)
    {                 
        Scanner input = new Scanner(System.in);
        /* Creating object of BST */
        BST bst = new BST(); 
        System.out.println("Binary Search Tree Test\n");          
        char ch;
        /*  Perform tree operations  */
        do    
        {
            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1. insert");
            System.out.println("2. count nodes");
            System.out.println("3. check empty");
            System.out.println("4. search");
            System.out.println("5. find min"); 
            System.out.println("5. find max");
            
            int choice = input.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                bst.insert( input.nextInt() );                     
                break;                                                                                         
            case 2 : 
                System.out.println("Nodes = "+ bst.countNodes());
                break;     
            case 3 :  
                System.out.println("Empty status = "+ bst.isEmpty());
                break; 
            
             case 4 : 
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ bst.search( input.nextInt() ));
                break; 
            case 5 :  
                System.out.println("Min = "+ bst.minNode());
                break;
            case 6 :  
               // System.out.println("Max = "+ bst.maxNode());
                break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = input.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y'); 
        input.close();
    }
     
 }
