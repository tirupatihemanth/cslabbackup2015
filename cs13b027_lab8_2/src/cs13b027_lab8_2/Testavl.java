package cs13b027_lab8_2;

//Homework #2 Testing code
//By Merrill McKee 2/13/2007
//For Arup Guha's CS2 Spring 2007 class

//Needs to be compiled with AVLTree.java from which it will
//use that file's AVLTree class.

public class Testavl {

	public static void main(String[] args) {
		
		// Test Case #1
		//  - A single node tree has its only node deleted.
		// Create:
		//                     10
		//
		// Call: delete(10)
		//
		// Result:
		//                    empty tree
		try
		{
			AVLTree t1 = new AVLTree( );
			t1.insert(10);
			t1.delete(10);
			System.out.println("**** TEST CASE #1 (5 pts) ****");
			t1.printInorder();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("CRASH! During TEST CASE #1");
		}
		// Test Case #2
		//  - A small tree has its leaf deleted (tests searching
		//    and deleting a leaf.
		// Create:
		//                     20
		//                    /  \
		//                  10    30
		//                 /  \  /  \
		//                5  15 25  35
		//
		// Call: delete(25)
		//
		// Results:
		//                     20
		//                    /  \
		//                  10    30
		//                 /  \     \
		//                5  15     35		
		
		try
		{
			AVLTree t2 = new AVLTree( );
			t2.insert(20);
			t2.insert(10);
			t2.insert(30);
			t2.insert(5);
			t2.insert(15);
			t2.insert(25);
			t2.insert(35);
			
			t2.delete(25);
			System.out.println("**** TEST CASE #2 (5 pts) ****");		
			t2.printInorder();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("CRASH! During TEST CASE #2");
		}
		
		// Test Case #3
		//  - A small tree has an inner node deleted.
		// Create:
		//                     20
		//                    /  \
		//                  10    30
		//                 /  \  /  
		//                5  15 25  
		//
		// Call: delete(30)
		// 
		// Results:
		//                     20
		//                    /  \
		//                  10    25
		//                 /  \     
		//                5  15    	
		
		try
		{
			
			AVLTree t3 = new AVLTree( );
			t3.insert(20);
			t3.insert(10);
			t3.insert(30);
			t3.insert(5);
			t3.insert(15);
			t3.insert(25);
			
			t3.delete(30);
			System.out.println("**** TEST CASE #3 (5 pts) ****");		
			t3.printInorder();		
		
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("CRASH! During TEST CASE #3");
		}
		
		// Test Case #4
		//  - A small tree has a non-existant node deleted.
		// Create:
		//                     20
		//                    /  \
		//                  10    30
		//                 /  \  /  
		//                5  15 25  
		//
		// Call: delete(17)
		// 
		// Results:
		//                     20
		//                    /  \
		//                  10    30
		//                 /  \  /  
		//                5  15 25  	
		
		try
		{
		
			AVLTree t4 = new AVLTree( );
			t4.insert(20);
			t4.insert(10);
			t4.insert(30);
			t4.insert(5);
			t4.insert(15);
			t4.insert(25);
			
			t4.delete(17);
			System.out.println("**** TEST CASE #4 (5 pts) ****");		
			t4.printInorder();	
		
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("CRASH! During TEST CASE #4");
		}
		
		// Test Case #5
		//  - A small tree has its root deleted.
		// Create:
		//                     20
		//                    /  \
		//                  10    30
		//                       /  \
		//                      25  35
		//
		// Call: delete(20)
		// 
		// Results: (simplest result with no rotations)
		//          (replace root with smallest value on the right or 25)
		//
		//                     25
		//                    /  \
		//                  10    30
		//                         \
		//                         35		
		// 
		// (alternative results - replace root with largest value on the left or 10)
		//   (single rotation)                (double rotation)
		//
		//          30                               25
		//         /  \                             /  \
		//       10    35                         10    30
		//         \                                     \
		//         25                                    35
		
		try
		{
			AVLTree t5 = new AVLTree( );
			t5.insert(20);
			t5.insert(10);
			t5.insert(30);
			t5.insert(25);
			t5.insert(35);
			
			t5.delete(20);
			System.out.println("**** TEST CASE #5 (5 pts) ****");		
			t5.printInorder();		
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("CRASH! During TEST CASE #5");
		}		
		
		// Test Case #6
		//  - A small tree has all nodes but the root deleted from the bottom up.
		// Create:
		//                     20
		//                    /  \
		//                  10    30
		//                 /  \  /  
		//                5  15 25  
		//
		// Call: delete(5), delete(15), delete(25), delete(10), delete(30)
		// 
		// Results:
		//                     20
		
		try
		{
			AVLTree t6 = new AVLTree( );
			t6.insert(20);
			t6.insert(10);
			t6.insert(30);
			t6.insert(5);
			t6.insert(15);
			t6.insert(25);
			
			t6.delete(5);
			t6.delete(15);
			t6.delete(25);
			t6.delete(10);
			t6.delete(30);		
			System.out.println("**** TEST CASE #6 (5 pts) ****");		
			t6.printInorder();			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("CRASH! During TEST CASE #6");
		}		
		
		// Test Case #7 (single rotation)
		//  
		// Create:
		//
		//                     20
		//             /                 \
		//            10                 30
		//          /    \             /    \
		//         5     15           25    40
		//               /           /     /  \
		//             12           22    35   50
		//                               /
		//                              31
		// 
		// Call: delete(50)
		//
		//                     20
		//             /                 \
		//            10                 30
		//          /    \             /    \
		//         5     15           25    35
		//               /           /     /  \
		//             12           22    31   40
		//                                
		//       
		
		try
		{
			
			AVLTree t7 = new AVLTree( );
			t7.insert(20);
			t7.insert(10);
			t7.insert(30);
			t7.insert(5);
			t7.insert(15);
			t7.insert(25);
			t7.insert(40);
			t7.insert(12);
			t7.insert(22);
			t7.insert(35);
			t7.insert(50);
			t7.insert(31);
			
			t7.delete(50);	
			System.out.println("**** TEST CASE #7 (10 pts) ****");		
			t7.printInorder();	
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("CRASH! During TEST CASE #7");
		}
		
		// Test Case #8 (double rotation)
		//  
		// Create:
		//
		//                     20
		//             /                 \
		//            10                 30
		//          /    \             /    \
		//         5     15           25    40
		//               /           /     /  \
		//             12           22    35   50
		//                               /
		//                              31
		// 
		// Call: delete(22)
		//
		//                     20
		//             /                 \
		//            10                 35
		//          /    \             /    \
		//         5     15           30    40
		//               /           /  \      \
		//             12           25  31     50
		//                                
		//           
		
		try
		{
		
			AVLTree t8 = new AVLTree( );
			t8.insert(20);
			t8.insert(10);
			t8.insert(30);
			t8.insert(5);
			t8.insert(15);
			t8.insert(25);
			t8.insert(40);
			t8.insert(12);
			t8.insert(22);
			t8.insert(35);
			t8.insert(50);
			t8.insert(31);
			
			t8.delete(22);	
			System.out.println("**** TEST CASE #8 (10 pts) ****");		
			t8.printInorder();	
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("CRASH! During TEST CASE #8");
		}		
		
		// Test Case #9 (multiple rotations - using exam problem)
		//
		// Create:
		//                     20
		//             /                 \
		//            10                 30
		//          /    \             /    \
		//         5     15           25    40
		//               /           /     /  \
		//             12           22    35   50
		//                               /
		//                              31
		//
		// Call: delete(5)
		//
		// Results:
		//                     30
		//             /                 \
		//            20                 40
		//          /    \             /    \
		//        12      25          35    50
		//       /  \    /           /     
		//     10   15  22          31    
		//                              
		//                              	
		
		try
		{
		
			AVLTree t9 = new AVLTree( );
			t9.insert(20);
			t9.insert(10);
			t9.insert(30);
			t9.insert(5);
			t9.insert(15);
			t9.insert(25);
			t9.insert(40);
			t9.insert(12);
			t9.insert(22);
			t9.insert(35);
			t9.insert(50);
			t9.insert(31);
			
			t9.delete(5);	
			System.out.println("**** TEST CASE #9 (10 pts) ****");		
			t9.printInorder();			
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("CRASH! During TEST CASE #9");
		}		

	}
}