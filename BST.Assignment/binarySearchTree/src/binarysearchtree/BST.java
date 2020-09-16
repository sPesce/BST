package binarysearchtree;
//==============================================================================
//==============================================================================
// BST class
// each object in this class is a binary search tree
// created by Steve Pesce
// last edited 4/2/15
public class BST 
{
    //<<<<<<<<<<<<<<<<<<<< PROPERTIES >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private BSTNode root;//top node of tree
    private int height;//height is max depth + 1 
    private int size;//number of node in the tree
    
    //<<<<<<<<<<<<<<<<<<< Constructors >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //null constructor
    BST()
    {
        root = null;
        height = 0;
        size = 0;
        
    }//end BST() 
    //--------------------------------------------------------------------------
    BST(int[] values)
    {
        for(int i = 0;i < values.length; i++)
        {
            BSTNode newNode = new BSTNode(values[i]);
            
            append(newNode);
        }
       
    }//end BST(int[])
    
    //this method adds newNode to the tree at the appropriate location
    //current is used in the recursive step
    //
    //this method is private because only append(BSTNode) should be called
    //directly and it will call this method
    //  only root should be called in append, unless the method changes current
    private void append(BSTNode newNode,BSTNode current)
    {
        if (root == null)
        {
            //setup root node
            root = newNode;
            root.setDepth(0);
            size=1;
            adjustHeight(newNode);
        } else
        {
            //add 1 to depth in each level of recursion
            newNode.setDepth(current.getDepth() + 1);
            //then adjust the height
            adjustHeight(newNode);

            if (newNode.getValue() <= current.getValue())
            {
                if (current.getLeft() == null)//if spot is empty
                {
                    current.setLeft(newNode);//place node
                    
                    size++;
                } else
                {
                    append(newNode, current.getLeft());//else recall this method
                }
            } else if(newNode.getValue() > current.getValue())
            {
                if (current.getRight() == null)//if spot is empty
                {
                    current.setRight(newNode);//place node
                    
                    size++;
                } else
                {
                    append(newNode, current.getRight());//else recall method
                }
            }
        }//end else*(root != null)
    }//end append(BSTNode,BSTNode) ---------------------------------------------
    
    
    //<<<<<<<<<<<<<<<<<<<< ACCESORS/MUTATORS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //::::::::::::: HEIGHT ::::::::::::::>
    public int getHeight()
    {
        return height;
    }//end getHeight() -------------------
    public void setHeight(int height)
    {
        this.height = height;
    }//end setHeight() -------------------
    //::::::::::::: SIZE ::::::::::::::::>
    public int getSize()
    {
        return size;
    }//end getSize() ---------------------
    public void setSize(int size)
    {
        this.size = size;
    }//end setSize() ---------------------
    //::::::::::::::: ROOT :::::::::::::::>
    public BSTNode getRoot()
    {
        return root;
    }//end getRoot() ---------------------
    
    
    //<<<<<<<<<<<<<<<<<<<<< UTILITY METHODS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //this method appends a node at the correct location 
    //by recursively calling append(BSTNode,BSTNode)
    public void append(BSTNode newNode)
    {
        append(newNode,root);
    }//end append(BSTNode) -----------------------------------------------------
    //--------------------------------------------------------------------------
    
    //this method checks to see if the depth of the current node should change
    //the height of the tree, and changes it if needed
    public void adjustHeight(BSTNode current)
    {
        //height is deepest node + 1
        int nodeHeight = current.getDepth()+1;
        
        if(nodeHeight>height)
        {
            height = nodeHeight;
            
            System.out.println("height updated to: " + height);
        }
    }//end adjustHeight() ------------------------------------------------------
    
    //this method deletes the node that contains the given value
    public void delete(BSTNode node)
    {
        
    }//end delete() ------------------------------------------------------------
    
    //this method deletes the node that contains the given value
    public void delete(int value)
    {
        //node = search(
        
    }
    
   
    
    //this method calls search(int) and prints a message if the value is found
    // in the tree
    public void searchPrint(int value)
    {
        System.out.print(value);
        if (findNode(value, root) == null)
        {
            System.out.println(" does not exist in the tree.");
        } else
        {
            System.out.println(" exists in the tree.");
        }
    }//end searchPrint(int) ----------------------------------------------------
    
    private BSTNode findNode(int value, BSTNode current)
    {
        if(current != null)
        {
            if (value == current.getValue())
            {
                System.out.print("  **Test* entering "
                        + "if(value = current.value loop...**  ");
                
                return current;
            } else 
            {
                if (value < current.getValue())
                {
                    findNode(value,current.getLeft());
                } else 
                {
                    findNode(value,current.getRight());
                }
            }
        } else
        {
            return null;
        }
        return current;
    }//end findNode(int,BSTNode) -----------------------------------------------
    //recursive method that returns true if 'value' exists in a tree node
    //this method should only be called from search(int) with 'root' passed as
    // the 'current' paramater
    private boolean search(int value, BSTNode current, boolean found)
    {
        //if the current node is null, return false
        if (current == null)
        {
            return false;
        }
        else
        {   //search left subtree if the value is smaller than the node's value
            if (value < current.getValue())
            {
                search(value, current.getLeft(),false);
              
            //search right subtree if  value is bigger than the node's value  
            } else if (value > current.getValue())
            {
                search(value, current.getRight(),false);
            
            //if the value is the same as the node's value, return true
            } else if(value == current.getValue())
            {
                found = true;
            }
            return found;
            
        }//end else 
        
    }//end search(int,BSTNode) -------------------------------------------------
    
    //::::::::::::::::::::::::::::::: TRAVERSALS ::::;;;;;;;;;;;;;;;;::::::::>
    //this method traverses and prints the tree in preorder  
    public void preorder()
    {
        traverse("preorder",root);
    }//end preorder ----------------------------------------------------------
    //this method traverses and prints the tree in inorder
    public void inorder()
    {
        traverse("inorder",root);
    }//end inorder() ---------------------------------------------------------
    //this method traverses and prints the tree in postorder
    public void postorder()
    {
        traverse("postorder",root);
    }//end postorder() -------------------------------------------------------
    
    //this is a recursive inOrder traversal method
    //this method should only be called from inorder(),preorder() or postorder()
    private void traverse(String order, BSTNode current)
    {
        if(root == null)
        {
            System.out.println("The tree is empty");
        }
        if (current != null)
        {
            
            // preorder
            if(order.equalsIgnoreCase("preorder"))
            {
                System.out.println(current.getValue());  
                
                traverse("preorder",current.getLeft()); // Node < L < R
                
                traverse("preorder",current.getRight());
            } //end if(preorder) ---------------------------------------
            
            // inorder
            if(order.equalsIgnoreCase("inorder"))
            {
                traverse("inorder",current.getLeft());
                
                System.out.println(current.getValue());  // L < Node < R
                
                traverse("inorder",current.getRight());
            } //end if(inorder) ----------------------------------------
            
            // postorder
            if(order.equalsIgnoreCase("postorder"))
            {
                traverse("postorder",current.getLeft());
                
                traverse("postorder",current.getRight()); // L < R < Node
                
                System.out.println(current.getValue());
            } //end if(postorder) --------------------------------------
        }//end if(current != null) ---------------------------------------------
    }//end traverse(String, BSTNode) -------------------------------------------
}//end class BST
//==============================================================================
//==============================================================================