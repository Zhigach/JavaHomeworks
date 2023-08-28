package src.main.java;

import java.util.List;

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
        root.simpleAdd(24);

    }

    //TODO реализовать дерево, поиск элементов в нем

    enum Color {
        RED, BLACK;
    }
    static Node root;

    static class Node {
        List<Node> children;
        int value;
        Color color;

        public Node(int value, Color color) {
            this.value = value;
            this.color = color;
        }

        //TODO реализовать добавление элементов в дерево
        public void simpleAdd(int value) {
            if (root == null) {
                root = new Node(value, BLACK);
            } else {
                Node currentNode = root;
                while (!currentNode.children.isEmpty()) {
                    currentNode = currentNode.children.get(0);
                }
                root.children.add(new Node(value, RED));
            }
        }

        void smallLeftPivot (){

        }

        void rightPivot () {

        }

        void swapColor() {

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
