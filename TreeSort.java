// Java program to
// implement Tree Sort
class TreeSort
{

    // Array for sorted data
    int[] sortedData;
    int index = 0;

    // Keeps track of number of iterations
    int TreeSortIterations = 0;
    
	// Class containing left and
	// right child of current
	// node and key value
	class Node
	{
		int key;
		Node left, right;

		public Node(int item)
		{
			key = item;
			left = right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	TreeSort()
	{
		root = null;
	}

	// This method mainly
	// calls insertRec()
	void insert(int key)
	{
		root = insertRec(root, key);
	}
	
	/* A recursive function to
	insert a new key in BST */
	Node insertRec(Node root, int key)
	{

		/* If the tree is empty,
		return a new node */
		if (root == null)
		{
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur
		down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

        TreeSortIterations++;
        
		/* return the root */
		return root;
	}
	
	// A function to do
	// inorder traversal of BST
	void inorderRec(Node root)
	{
		if (root != null)
		{
			inorderRec(root.left);
            sortedData[index] = root.key;
            index++;
			//System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}
	void treeins(int arr[])
	{
        sortedData = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
		{
			insert(arr[i]);
		}
		
	}
    public int[] getSortedData() {
        return sortedData;
    }

    public int getIteration() {
        return TreeSortIterations;
    }
}

// This code is contributed
// by Vibin M
