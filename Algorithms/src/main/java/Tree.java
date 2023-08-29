package src.main.java;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

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

    public static void main(String[] args) {
        root.addNode(24);

    }

    //TODO реализовать дерево, поиск элементов в нем

    enum Color {
        RED, BLACK;
    }
    static Node root;

    static class Node {
        Node leftChild;
        Node rightChild;
        int value;
        Color color;

        public Node(int value, Color color) {
            this.value = value;
            this.color = color;
        }

        //TODO реализовать добавление элементов в дерево
        private void addNode(int value) {
            if (root == null) {
                root = new Node(value, BLACK);
            } else {
                Node currentNode = root;
                if (value > currentNode.value) {
                    if (rightChild == null){
                        rightChild = new Node(value, RED);
                        if (leftChild.color == BLACK) {
                            leftPivot(); // если правая нода красная и левая нода черная - левосторонний поворот
                        }
                    } else {
                        rightChild.addNode(value);
                    }
                } else {
                    if (leftChild == null){
                        leftChild = new Node(value, RED);
                        this.balance();
                    } else {
                        leftChild.addNode(value);
                    }
                }
            }
        }

        void leftPivot (){
            Node tmp = this.rightChild;
            if (this.rightChild.leftChild != null)
                this.rightChild =this.rightChild.leftChild;
            else
                this.rightChild = null;
            tmp.leftChild = this;
        }

        void rightPivot () {
            Node tmp = this.leftChild;
            if (this.leftChild.rightChild != null)
                this.leftChild = this.leftChild.rightChild;
            else
                this.leftChild = null;
            tmp.rightChild = this;
        }

        void swapColor() throws Exception {
            if (this.leftChild.color == RED && this.rightChild.color == RED) {
                leftChild.color = BLACK;
                rightChild.color = BLACK;
                this.color = RED;
            } else {
                throw new Exception("Not all children are RED");
            }
        }
    }

    //TODO метод для печати дерева. По сути поиск без поиска в ширину
    void printTree() {
        printTree(root);
    }

    void printTree(Node node) {
        Node currentNode = root;
        ArrayDeque<Node> listToPrint = new ArrayDeque<>();
        while (!listToPrint.isEmpty()) {
            listToPrint.add(currentNode);
            for (Node item : listToPrint) {
                System.out.printf("%d (%s)\t", item.value, item.color.toString());
                listToPrint.remove(item);
            }
            System.out.println();
            if (currentNode.leftChild != null) {
                listToPrint.add(currentNode.leftChild);
            }
            if (currentNode.rightChild != null) {
                listToPrint.add(currentNode.rightChild);
            }
        }
    }



    //TODO реализовать алгоритм поиска в глубину (рекурсивно)
    Node deepSearch(int value) {
        return deepSearch(root, value);
    }
    Node deepSearch(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child : node.children) {
                deepSearch(child, value);
            }
        }
        return null;
    }

    //TODO реализовать алгоритм поиска в ширину (потребуется переменная хранящая список нод для обхода)
}
