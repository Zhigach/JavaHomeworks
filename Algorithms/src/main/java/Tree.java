package src.main.java;

import static src.main.java.Tree.Color.BLACK;
import static src.main.java.Tree.Color.RED;

public class Tree {
    /*
    Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. И реализовать в нем метод добавления новых элементов с балансировкой.

    Красно-черное дерево имеет следующие критерии:
    • Каждая нода имеет цвет (красный или черный)
    • Корень дерева всегда черный
    • Новая нода всегда красная
    • Красные ноды могут быть только левым ребенком
    • У краной ноды все дети черного цвета

    Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево необходимо произвести балансировку, благодаря которой все критерии выше станут валидными.
    Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.

     */

    public static void main(String[] args) throws Exception {
       insertNode(24);
       insertNode(10);
       insertNode(15);
    }

    enum Color {
        RED, BLACK;
    }
    static Node root;

    public static class Node {
        int data;

        Node left;
        Node right;
        Node parent;

        Color color;

        public Node(int data) {
            this.data = data;
        }
    }

    private static void rotateRight(Node node) {
        Node parent = node.parent;
        Node leftChild = node.left;

        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        leftChild.right = node;
        node.parent = leftChild;

        replaceParentsChild(parent, node, leftChild);
    }

    private static void rotateLeft(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;

        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        rightChild.left = node;
        node.parent = rightChild;

        replaceParentsChild(parent, node, rightChild);
    }

    private static void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        } else {
            throw new IllegalStateException("Node is not a child of its parent");
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }

    public static void insertNode(int key) {
        Node node = root;
        Node parent = null;

        while (node != null) {
            parent = node;
            if (key < node.data) {
                node = node.left;
            } else if (key > node.data) {
                node = node.right;
            } else {
                throw new IllegalArgumentException("BST already contains a node with key " + key);
            }
        }

        Node newNode = new Node(key);
        newNode.color = RED;
        if (parent == null) {
            root = newNode;
        } else if (key < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;

        fixRedBlackPropertiesAfterInsert(newNode);
    }

    private static void fixRedBlackPropertiesAfterInsert(Node node) {
        Node parent = node.parent;


        if (parent == null) {
            return;
        }

        if (parent.color == BLACK) {
            return;
        }

        Node grandparent = parent.parent;


        if (grandparent == null) {
            parent.color = BLACK;
            return;
        }

        Node uncle = getUncle(parent);


        if (uncle != null && uncle.color == RED) {
            parent.color = BLACK;
            grandparent.color = RED;
            uncle.color = BLACK;

            fixRedBlackPropertiesAfterInsert(grandparent);
        }


        else if (parent == grandparent.left) {

            if (node == parent.right) {
                rotateLeft(parent);

                parent = node;
            }

            rotateRight(grandparent);

            parent.color = BLACK;
            grandparent.color = RED;
        }


        else {

            if (node == parent.left) {
                rotateRight(parent);
                parent = node;
            }

            rotateLeft(grandparent);

            parent.color = BLACK;
            grandparent.color = RED;
        }
    }

    private static Node getUncle(Node parent) {
        Node grandparent = parent.parent;
        if (grandparent.left == parent) {
            return grandparent.right;
        } else if (grandparent.right == parent) {
            return grandparent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }
}
