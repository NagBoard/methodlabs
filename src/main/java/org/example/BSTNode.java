package main.java.org.example;

public class BSTNode {
    private int key;
    private String value;
    private BSTNode left, right;

    // BST Node конструктор
    public BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
        left = right = null;
    }

    // Вставка (ключ, значення). Якщо такий ключ вже є – значення перезаписується
    public static BSTNode insert(BSTNode node, int key, String value) {
        if (node == null) {
            return new BSTNode(key, value);
        }

        if (key < node.key) {
            node.left = insert(node.left, key, value);
        } else if (key > node.key) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    // Видалення по ключу
    public static BSTNode delete(BSTNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            // нема листя
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                // без лівого ноду
                return node.right;
            } else if (node.right == null) {
                // без правого ноду
                return node.left;
            } else {
                // Два ноди
                BSTNode min = findMin(node.right);
                node.key = min.key;
                node.value = min.value;
                // Видалення ноду
                node.right = delete(node.right, node.key);
            }
        }

        return node;
    }

    // пошук мінімального ключа для видалення
    private static BSTNode findMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // пошук по ключу
    public static String search(BSTNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            return search(node.left, key);
        } else if (key > node.key) {
            return search(node.right, key);
        } else {
            return node.value;
        }
    }

    // обхід дерева від кореня
    public static void traverseInOrder(BSTNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println("Key: " + node.key + " Value: " + node.value);
            traverseInOrder(node.right);
        }
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }
}

