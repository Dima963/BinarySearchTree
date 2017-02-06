package com.company;

public class Main {

    Node root;

    public void addNode(int key, String name){

        Node newNode =  new Node(key, name);

        if(root == null){
            root =  newNode;
        }else{
            Node focusNode = root;
            Node parent;

            while (true){
                parent =  focusNode;
                if(key < focusNode.Key){
                    focusNode =  focusNode.leftChild;
                    if(focusNode == null){
                        parent.leftChild =  newNode;
                        return;
                    }
                }else{
                    focusNode =  focusNode.rightChild;
                    if(focusNode == null){
                        parent.rightChild =  newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode){

        if(focusNode != null){
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
          //  System.out.println(focusNode);
        }
    }

    public Node findNode(int key){

        Node focusNode =  root;

        if(focusNode == null)
        {
            return null;
        }

        while (focusNode.Key != key){
            if(key < focusNode.Key){
                focusNode =  focusNode.leftChild;
            }else {
                focusNode =  focusNode.rightChild;
            }
        }
        return focusNode;
    }


    public static void main(String[] args) {

        Main  tree = new Main();
        tree.addNode(50, "A");
        tree.addNode(25, "b");
        tree.addNode(15, "c");
        tree.addNode(30, "d");
        tree.addNode(65, "s");
        tree.addNode(75, "r");
        tree.addNode(80, "s");

        tree.inOrderTraverseTree(tree.root);
        System.out.println(tree.findNode(30));

    }
}
