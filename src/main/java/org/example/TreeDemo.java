package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node{
    int value;
    Node left, right;

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }

}

class BinarySearchTree{

    Node root;


    /*
    recursive insert method
    */
        /*
	   inserts a node into the tree
	   */
    public void insert(int value){
        //tree is empty
        if(root == null){
            root = new Node(value);
            return;
        }else{
            Node current = root;
            Node parent = null;

            while(true){
                parent = current;

                if(value < current.value){
                    current = current.left;
                    if(current == null){
                        parent.left = new Node(value);
                        return;
                    }
                }else{
                    current = current.right;
                    if(current == null){
                        parent.right = new Node(value);
                        return;
                    }
                }

            }//closing while

        }//closing main if-else
    }

    /*
    pre-order traversal
    Prints the value of every node preorder
    */
    public void preOrderTraversal(Node root){
        StringBuilder values = new StringBuilder();
        traversePreOrder(values, root);

        if(values.length() >= 2) //remove trailing ", "
            values.setLength(values.length() - 2);

        System.out.print(values.toString());
    }


    /*
    adds node values to stringbuilder object in preorder
    */
    private void traversePreOrder(StringBuilder sb, Node root) {
        sb.append(root.value + ", ");

        if(root.left != null)
            traversePreOrder(sb, root.left);

        if(root.right != null)
            traversePreOrder(sb, root.right);
    }



    /*
    in-order traversal
    */
    public void inOrderTraversal(Node root){
        StringBuilder values = new StringBuilder();
        traverseInOrder(values, root);

        if(values.length() >= 2) //remove trailing ", "
            values.setLength(values.length() - 2);

        System.out.print(values.toString());
    }


    /*
    adds node values to stringbuilder object in inorder
    */
    private void traverseInOrder(StringBuilder sb, Node root) {
        if(root.left != null)
            traverseInOrder(sb, root.left);

        sb.append(root.value + ", ");

        if(root.right != null)
            traverseInOrder(sb, root.right);
    }



    /*
	post-order traversal
    */
    public void postOrderTraversal(Node root){
        StringBuilder values = new StringBuilder();
        traversePostOrder(values, root);

        if(values.length() >= 2) //remove trailing ", "
            values.setLength(values.length() - 2);

        System.out.print(values.toString());
    }

    /*
    adds node values to stringbuilder object in postorder
    */
    private void traversePostOrder(StringBuilder sb, Node root) {
        if(root.left != null)
            traversePostOrder(sb, root.left);

        if(root.right != null)
            traversePostOrder(sb, root.right);

        sb.append(root.value + ", ");
    }



    /*
    a method to find the node in the tree
    with a specific value
    */
    public boolean find(Node root, int key){
        if(root.value == key)
            return true;

        if(key < root.value && root.left != null)
            find(root.left, key);

        if(key > root.value && root.right != null)
            find(root.right, key);

        return false;
    }



    /*
    a method to find the node in the tree
    with a smallest key
    */
    public int getMin(Node root){
        if(root.left != null)
            getMax(root.right);

        return root.value;
    }



    /*
    a method to find the node in the tree
    with a largest key
    */
    public int getMax(Node root){
        if(root.right != null)
            getMax(root.right);

        return root.value;
    }



    /*
    this method will not compile until getMax
    is implemented
    */
    public Node delete(Node root, int key){

        if(root == null){
            return root;
        }else if(key < root.value){
            root.left = delete(root.left, key);
        }else if(key > root.value){
            root.right = delete(root.right, key);
        }else{
            //node has been found
            if(root.left==null && root.right==null){
                //case #1: leaf node
                root = null;
            }else if(root.right == null){
                //case #2 : only left child
                root = root.left;
            }else if(root.left == null){
                //case #2 : only right child
                root = root.right;
            }else{
                //case #3 : 2 children
                root.value = getMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }
        return root;
    }



}



public class TreeDemo{
    public static void main(String[] args){
        BinarySearchTree t1  = new BinarySearchTree();
        t1.insert( 24);
        t1.insert(80);
        t1.insert(18);
        t1.insert(9);
        t1.insert(90);
        t1.insert(22);

        System.out.print("in-order :   ");
        t1.inOrderTraversal(t1.root);
        System.out.println();


    }
}
