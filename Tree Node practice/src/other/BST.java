package other;
/* Class BST */
 public class BST
 {
	 /* Instance variable */
	 private Node root;
	
	/* Constructor */
	public BST()
	{
		root = null;
	}
	
	/* Function to check if tree is empty */
    public boolean isEmpty()
    {
    	return root == null;
    }
    
    /* Functions to insert data */
    public void insert(int data)
    {
       root = insert(root, data); 
    }
    
    /* Function to insert data recursively */
    private Node insert(Node node, int data)
    {
    	if (node == null)
    		node = new Node(data);
    	else
    	{
    		if (data < node.data)
    			node.left = insert(node.left,data);
    		else
    			node.right = insert(node.right,data);
    	}
    	
    	return node;
        
    }
    
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(Node r)
    {
        if (r == null)
        	return 0;
        else
        {
        	int cnt = 1;
        	cnt += countNodes(r.left);
        	cnt += countNodes(r.right);
        	return cnt;
        }
        
    }
    
    
    
    /* Functions to search for an element 
    public boolean search(int val)
    {
        
    }
    
    /* Function to search for an element recursively 
    private boolean search(Node r, int val)
    {
        
    }
    
    /* Functions to find the minimum element 
    public Node minNode()
	{
		
	}
    
    /* Function to find the minimum element recursively 
	private Node minNode(Node r)
	{
		
	}
	
	/* Functions to find the maximum element 
    public Node maxNode()
	{
		
	}
    
    /* Function to find the maximum element recursively 
	private Node maxNode()
	{
		
	}
	
*/	
 }
