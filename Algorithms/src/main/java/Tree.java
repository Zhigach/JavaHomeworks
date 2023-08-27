package src.main.java;

import java.util.List;
import java.util.Random;

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
        Node root = new Node(0);
        root.simpleAdd(1);
    }

    //TODO реализовать дерево, поиск элементов в нем

    Node root;

    static class Node {
        List<Node> children;
        int value;

        public Node(int value) {
            this.value = value;
        }

        //TODO реализовать добавление элементов в дерево
        public void simpleAdd(int value) {
            Node currentNode = this;
            Random random = new Random();
            while (!currentNode.children.isEmpty() ) {
                try {
                    currentNode = currentNode.children.get(random.nextInt(2));
                } finally {
                    currentNode = currentNode.children.get(0);
                }
            }
            currentNode.children.add(new Node(value));
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
