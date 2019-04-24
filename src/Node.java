public class Node {
	public Node leftChild;
	public Node rightChild;
	public int id;
	public int rndNumber;

	public Node(int id, int rndNumber){
		this.id = rndNumber;
		this.rndNumber = rndNumber;
	}

	public void display(){
		System.out.println(rndNumber);
	}

	public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
		if(rightChild!=null) {
			rightChild.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
		}
		sb.append(prefix).append(isTail ? "└── " : "┌── ").append(rndNumber).append("\n");
		if(leftChild!=null) {
			leftChild.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
		}
		return sb;
	}

	@Override
	public String toString() {
		return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
	}
}


