public class BinarySearchTreeNode<T extends Comparable<T>> {

	private T data;
	private BinarySearchTreeNode<T> left;
	private BinarySearchTreeNode<T> right;

	public BinarySearchTreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	public boolean add(T data) {
		int compare = this.data.compareTo(data);
		if (data == null) {
			return false;
		} else if (compare == 0) {
			return false;
		} else if (compare > 0) {
			if (left == null) {
				left = new BinarySearchTreeNode(data);
				return true;
			} else {
				return left.add(data);
			}
		} else {
			if (right == null) {
				right = new BinarySearchTreeNode(data);
				return true;
			} else {
				return right.add(data);
			}
		}
	}

	private T findMin() {
		if (this.left == null) {
			return this.data;
		} else {
			return left.findMin();
		}
	}

	public BinarySearchTreeNode<T> remove(T data) {
		T min;
		int compare = this.data.compareTo(data);
		if (compare == 0) {
			if (this.left != null && this.right != null) {
				min = right.findMin();
				this.data = min;
				right = right.remove(min);
			} else if (this.right != null) {
				return this.right;
			} else if (this.left != null) {
				return this.left;
			} else {
				return null;
			}
		} else if (compare > 0) {
			if (left != null) {
				left = left.remove(data);
			}
		} else {
			if (right != null) {
				right = right.remove(data);
			}
		}
		return this;
	}

	public boolean contains(T data) {
		if (data == null) {
			return false;
		} else if (this.data.compareTo(data) == 0) {
			return true;
		} else if (this.data.compareTo(data) > 0) {
			if (left != null) {
				return left.contains(data);
			}
		} else {
			if (right != null) {
				return right.contains(data);
			}
		}
		return false;
	}

	public int size() {
		int total = 0;
		total++;
		if (left != null) {
			total += left.size();
		}

		if (right != null) {
			total += right.size();
		}
		return total;
	}

	public int depth() {
		int l = 0;
		int r = 0;
		if (left != null) {
			l++;
			l += left.depth();
		}
		if (right != null) {
			r++;
			r += right.depth();
		}
		if (r > l) {
			return r;
		} else {
			return l;
		}
	}

	private void stringCreator(StringBuilder str) {
				
		if (this.left != null) {
			left.stringCreator(str);
		}
			str.append(this.data).append(", ");
		
		if (this.right != null) {
			right.stringCreator(str);
		}
		
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		stringCreator(str);
		return str.toString().substring(0, str.toString().length()-2);
	}
}
