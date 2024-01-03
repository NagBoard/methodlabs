package test.java.org.example;

import main.java.org.example.BSTNode;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BSTNodeTest {
    private BSTNode root;
    private Map<Integer, String> testData;
    private int startNumber = 5;
    private int missingKey;

    @Before
    public void setUp() {
        root = null;
        testData = new HashMap<>();
        Random random = new Random();

        // Додавання 20 випадкових значень починаючи з startNumber в HashMap
        for (int i = startNumber; i < startNumber + 20; i++) {
            testData.put(i, "Value " + random.nextInt());
        }

        // Видалення одного значення з HashMap для перевірки видалення
        missingKey = startNumber + 10;
        testData.remove(missingKey);

        // Вставка значень в BST
        for (Map.Entry<Integer, String> entry : testData.entrySet()) {
            root = BSTNode.insert(root, entry.getKey(), entry.getValue());
        }
    }

    @Test
    public void testInsertAndTraverse() {
        int nodeCount = countNodes(root);
        assertEquals(19, nodeCount);
    }

    @Test
    public void testSearch() {
        String value = BSTNode.search(root, startNumber);
        assertEquals(testData.get(startNumber), value);

        value = BSTNode.search(root, missingKey);
        assertNull(value);
    }

    @Test
    public void testInsertAndSearchMissingKey() {
        root = BSTNode.insert(root, missingKey, "New Value");
        String value = BSTNode.search(root, missingKey);
        assertEquals("New Value", value);

        int nodeCount = countNodes(root);
        assertEquals(20, nodeCount);
    }

    @Test
    public void testDelete() {
        root = BSTNode.delete(root, missingKey);
        String value = BSTNode.search(root, missingKey);
        assertNull(value);

        int nodeCount = countNodes(root);
        assertEquals(19, nodeCount);
    }

    private int countNodes(BSTNode node) {
        if (node == null) {
            return 0;
        } else {
            return countNodes(node.getLeft()) + countNodes(node.getRight()) + 1;
        }
    }
}