package ArvoreRubroNegra;

public class RedBlackTree <T extends Comparable<T>> extends AbstractBinarySearchTree<T>{

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    @Override
    public void balanceAfterInsert(Node<T> node) {
        while (node != root && node.parent.color == RED) {
            if (node.parent == node.parent.parent.left) {
                Node<T> uncle = node.parent.parent.right;
                if (uncle != null && uncle.color == RED) {
                    // Case 1: Uncle is red
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        // Case 2: Node is a right child
                        node = node.parent;
                        rotateLeft(node);
                    }
                    // Case 3: Node is a left child
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateRight(node.parent.parent);
                }
            } else {
                Node<T> uncle = node.parent.parent.left;
                if (uncle != null && uncle.color == RED) {
                    // Case 1: Uncle is red
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        // Case 2: Node is a left child
                        node = node.parent;
                        rotateRight(node);
                    }
                    // Case 3: Node is a right child
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }
    private void rotateLeft(Node<T> node) {
        Node<T> temp = node.right;
        node.right = temp.left;
        if (temp.left != null) {
            temp.left.parent = node;
        }
        temp.parent = node.parent;
        if (node.parent == null) {
            root = temp;
        } else if (node == node.parent.left) {
            node.parent.left = temp;
        } else {
            node.parent.right = temp;
        }
        temp.left = node;
        node.parent = temp;
    }

    private void rotateRight(Node<T> node) {
        Node<T> temp = node.left;
        node.left = temp.right;
        if (temp.right != null) {
            temp.right.parent = node;
        }
        temp.parent = node.parent;
        if (node.parent == null) {
            root = temp;
        } else if (node == node.parent.right) {
            node.parent.right = temp;
        } else {
            node.parent.left = temp;
        }
        temp.right = node;
        node.parent = temp;
    }

    @Override
    public void balanceAfterDelete(Node<T> node) {
        while (node != root && node.color == BLACK) {
            if (node == node.parent.left) {
                Node<T> sibling = node.parent.right;

                if (sibling.color == RED) {
                    sibling.color = BLACK;
                    node.parent.color = RED;
                    rotateLeft(node.parent);
                    sibling = node.parent.right;
                }

                if ((sibling.left == null || sibling.left.color == BLACK) &&
                        (sibling.right == null || sibling.right.color == BLACK)) {
                    sibling.color = RED;
                    node = node.parent;
                } else {

                    if (sibling.right == null || sibling.right.color == BLACK) {
                        if (sibling.left != null) {
                            sibling.left.color = BLACK;
                        }
                        sibling.color = RED;
                        rotateRight(sibling);
                        sibling = node.parent.right;
                    }

                    sibling.color = node.parent.color;
                    node.parent.color = BLACK;
                    if (sibling.right != null) {
                        sibling.right.color = BLACK;
                    }
                    rotateLeft(node.parent);
                    node = root;
                }
            } else {
                Node<T> sibling = node.parent.left;

                if (sibling.color == RED) {
                    sibling.color = BLACK;
                    node.parent.color = RED;
                    rotateRight(node.parent);
                    sibling = node.parent.left;
                }

                if ((sibling.left == null || sibling.left.color == BLACK) &&
                        (sibling.right == null || sibling.right.color == BLACK)) {
                    sibling.color = RED;
                    node = node.parent;
                } else {

                    if (sibling.left == null || sibling.left.color == BLACK) {
                        if (sibling.right != null) {
                            sibling.right.color = BLACK;
                        }
                        sibling.color = RED;
                        rotateLeft(sibling);
                        sibling = node.parent.left;
                    }

                    sibling.color = node.parent.color;
                    node.parent.color = BLACK;
                    if (sibling.left != null) {
                        sibling.left.color = BLACK;
                    }
                    rotateRight(node.parent);
                    node = root;
                }
            }
        }
        node.color = BLACK;
    }

    @Override
    public void insert(T data) {
        Node<T> node = new Node<>(data);
        root = insertRec(root, node);
        balanceAfterInsert(node);
    }

    private Node<T> insertRec(Node<T> root, Node<T> node) {
        if (root == null) {
            return node;
        }
        if (node.data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, node);
            root.left.parent = root;
        } else if (node.data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    public void printInOrder() {
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(Node<T> node) {
        if (node != null) {
            printInOrderRec(node.left);
            System.out.print(node.data + " ");
            printInOrderRec(node.right);
        }
    }

    @Override
    public void delete(T data) {
        Node<T> node = searchTree(root, data);
        if (node == null) {
            return; // Element not found
        }
        deleteNode(node);
    }

    private void deleteNode(Node<T> node) {
        balanceAfterDelete(node);
    }
}