

package binarysearchtree;
//==============================================================================
//==============================================================================
//BSTNode class
//Each object of this class is a node to a BST (binary search tree)
//Created by Steve Pesce
//Last edited 4/2/15
public class BSTNode 
{
    //<<<<<<<<<<<<<<<<<<< PROPERTIES >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private BSTNode left;//left child of this node
    private BSTNode right;//right child of this node
    private int value;//the integer value of this node    
    private int depth;//how many levels down the node is (root = 0)
    
    //<<<<<<<<<<<<<<<<<<<< CONSTRUCTORS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //constructor from value
    BSTNode(int value)
    {
        this.value = value;
        left = right = null;
        depth = -1;
    }//end BSTNode(int) --------------------------------------------------------
    //constructor from value and depth
    BSTNode(int value, int depth)
    {
        this.value = value;
        left = right = null;
        this.depth = depth;
    }//end BSTNode(int,int) ----------------------------------------------------
    //<<<<<<<<<<<<<<<<< ACCESSORS/MUTATORS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //:::::::::::::::::::::::::::::::: LEFT :::::::::::::::::::> 
    public BSTNode getLeft()
    {
        return left;
    }//end getLeft() --------------------------------
    public void setLeft(BSTNode left)
    {
        this.left = left;
    }//end setLeft() --------------------------------
    //:::::::::::::::::::::::::::::::: RIGHT ::::::::::::::::::>
    public BSTNode getRight()
    {
        return right;
    }//rnd getRight() -------------------------------
    public void setRight(BSTNode right)
    {
        this.right = right;
    }//end setRight() -------------------------------
    //:::::::::::::::::::::::::::::::: VALUE ::::::::::::::::::>
    public int getValue()
    {
        return value;
    }//end getValue() -------------------------------
    //:::::::::::::::::::::::::::::::: DEPTH ::::::::::::::::::>
    public int getDepth()
    {
        return depth;
    }//end getDepth() -------------------------------
    public void setDepth(int depth)
    {
        this.depth = depth;
    }//end setDepth() -------------------------------
    
}//end class BSTNode
//==============================================================================
//==============================================================================
