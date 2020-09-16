//==============================================================================
//==============================================================================
package binarysearchtree;


public class BinarySearchTree
{
    public static void main(String[] args)
    {
        int[] numbers = randomArray(100,200000);//not used yet
        
        int[] testNumbers = {6,2,1,4,3,5,7,9,8};
        
        BST testTree = new BST(testNumbers);
        
        BSTNode current = testTree.getRoot();
        
      
       
        System.out.println("\n\nTraversals:\n");
        System.out.println("in-order");
        testTree.inorder();
        System.out.println("pre-order");
        testTree.preorder();
        System.out.println("post-order");
        testTree.postorder();
        testTree.searchPrint(7);
        testTree.searchPrint(5);
        testTree.searchPrint(6);
        testTree.searchPrint(1);
        testTree.searchPrint(12);
        testTree.searchPrint(15);
    }
    //create an array with each value the same as its index
    public static int[] createLinearArray(int size)
    {
        
        int[] numbers = new int[size];
        int number;
        
        for (int i = 0; i < size; i++)
        {
            numbers[i] = i;
        }
        return numbers;
        
    }//end createLinearArray()
    //this method returns the array given as paramater, shuffled 'repeat' times
    public static int[] shuffle(int[] numbers, int repeat)
    {
        
        int placeHold;//cataclyst variable
        
        for (int i = 0; i < repeat; i++)
        {
            int index1 = (int)(Math.random() * (numbers.length));
            int index2 = (int)(Math.random() * (numbers.length ));

            while(index1 == index2)
            {
                index1 = (int)(Math.random() * (numbers.length));
            }

            placeHold = numbers[index1];
            numbers[index1] = numbers[index2];
            numbers[index2] = placeHold;
        }
        return numbers;
    }
    //this method returns an array of random numbers with no repeated elements
    public static int[] randomArray(int size, int repeatShuffle)
    {
        return shuffle(createLinearArray(size),repeatShuffle);
    }//end randomArray(int,int)
   

}//end class BinarySearchTree
//==============================================================================
//==============================================================================
