//this method calls findNode(int,BSTNode) and prints a message if the value is found
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
    
    //this method recursively looks for the node that contains 'value' and 
    //returns that node if it is found.  Returns null if no nodes contain
    //the value.
    private BSTNode findNode(int value, BSTNode current)
    {
        if(current != null)
        {
            if (value == current.getValue())
            {
                System.out.print("  **Test* entering "
                        + "if(value = current.value loop...**  ");
                
                return current;//return current if its value matches 'value'
            } else 
            {
                if (value < current.getValue())
                {
                    //recursively call this method with left child
                    findNode(value,current.getLeft());
                } else 
                {
                    //recursively call this method with right child
                    findNode(value,current.getRight());
                }
            }
        } else
        {
            //if current == null, return null
            return null;
        }
        return current;//always return current
    }//end findNode(int,BSTNode) -----------------------------------------------