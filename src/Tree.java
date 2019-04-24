public class Tree {

	public Node root;

	public void insert(Node nodeToInsert){
		Node node = nodeToInsert;
		if (root == null){
			root = node;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (node.id < current.id){
					current = current.leftChild;
					if (current == null){
						parent.leftChild = node;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null){
						parent.rightChild = node;
						return;
					}
				}
			}
		}
	}

	public int heightOfBinaryTree(Node node)
	{
		if (node == null)
		{
			return 0;
		}
		else
		{
			return 1 +
					Math.max(heightOfBinaryTree(node.leftChild),
							heightOfBinaryTree(node.rightChild));
		}
	}
}
