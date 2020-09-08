import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Your implementation of a BST.
 *
 * @author Jackson Isenberg
 * @version 1.2
 * @userid jisenberg3 (i.e. gburdell3)
 * @GTID 903556168 (i.e. 900000000)
 *
 * Collaborators: N/A
 *
 * Resources: N/A
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /**
     * Constructs a new BST.
     *
     * This constructor should initialize an empty BST.
     *
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public BST() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Constructs a new BST.
     *
     * This constructor should initialize the BST with the data in the
     * Collection. The data should be added in the same order it is in the
     * Collection.
     *
     * Hint: Not all Collections are indexable like Lists, so a regular for loop
     * will not work here. However, all Collections are Iterable, so what type
     * of loop would work?
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            // essentially the same as @NotNull
            throw new IllegalArgumentException("Cannot pass null argument into the constructor");
        }
        for (T el : data) {
            add(el);
        }
    }

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The data becomes a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to the tree");
        } else if (root == null) {
            root = new BSTNode<>(data);
            size++;
        } else {
            add(data, root);
        }
    }

    /**
     * A private helper method for adding data to the BST recursively
     *
     * @param data the data to be added to the tree (stored in a new node)
     * @param currRoot the current root of the subtree
     */
    private void add(T data, BSTNode<T> currRoot) {
        if (currRoot == null) {
            return;
        }
        int compare = data.compareTo(currRoot.getData());
        if (compare > 0) {
            if (currRoot.getRight() == null) {
                currRoot.setRight(new BSTNode<>(data));
                size++;
            } else {
                add(data, currRoot.getRight());
            }
        }
        if (compare < 0) {
            if (currRoot.getLeft() == null) {
                currRoot.setLeft(new BSTNode<>(data));
                size++;
            } else {
                add(data, currRoot.getLeft());
            }
        }
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the successor to
     * replace the data. You MUST use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to remove
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot remove null data from the tree");
        }
        if (size == 1 && root.getData().compareTo(data) == 0) {
            T tmp = root.getData();
            clear();
            return tmp;
        }
        return remove(data, root);
    }

    /**
     * A private helper method for removing data from the tree.
     *
     * @param data the data to remove from the tree
     * @param currRoot the current root of the subtree
     * @return the data in the node that was removed
     */
    private T remove(T data, BSTNode<T> currRoot) {
        if (currRoot == null) {
            throw new NoSuchElementException("Cannot remove data not in the tree");
        }
        int compare = data.compareTo(currRoot.getData());
        // I want to use C++ instead now ;-;
        if (compare == 0) {
            T tmp = currRoot.getData();
            if (currRoot.getLeft() != null && currRoot.getRight() != null) {
                BSTNode<T> successor = successor(currRoot, currRoot.getRight());
                currRoot.setRight(successor);
            } else if (currRoot.getLeft() != null) {
                currRoot.setData(currRoot.getLeft().getData());
                currRoot.setRight(currRoot.getLeft().getRight());
                currRoot.setLeft(currRoot.getLeft().getLeft());
            } else if (currRoot.getRight() != null) {
                currRoot.setData(currRoot.getRight().getData());
                currRoot.setLeft(currRoot.getRight().getLeft());
                currRoot.setRight(currRoot.getRight().getRight());
            } else {
                currRoot.setData(null);
            }
            size--;
            return tmp;
        } else if (compare < 0) {
            T temp = remove(data, currRoot.getLeft());
            if (currRoot.getLeft() != null && currRoot.getLeft().getData() == null) {
                currRoot.setLeft(null);
            }
            return temp;
        } else {
            T temp = remove(data, currRoot.getRight());
            if (currRoot.getRight() != null && currRoot.getRight().getData() == null) {
                currRoot.setRight(null);
            }
            return temp;
        }
    }

    /**
     * A private helper method for obtaining the successor of a node in the tree.
     * We assume the current root is not null.
     *
     * @param currRoot the root whose data we are replacing with the successor
     * @param searchRoot the node used to search for the successor
     * @return the next node in the search sequence
     */
    private BSTNode<T> successor(BSTNode<T> currRoot, BSTNode<T> searchRoot) {
        if (searchRoot.getLeft() == null) {
            currRoot.setData(searchRoot.getData());
            return searchRoot.getRight();
        }
        searchRoot.setLeft(successor(currRoot, searchRoot.getLeft()));
        return searchRoot;
    }

    /**
     * Returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to search for
     * @return the data in the tree equal to the parameter
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot retrieve null data from the tree");
        }
        return get(data, root);
    }

    /**
     * Private helper method for retrieving data from the tree.
     *
     * @param data the data to search for
     * @param currRoot the current root
     * @return the data in the tree equal to the parameter
     */
    private T get(T data, BSTNode<T> currRoot) {
        if (currRoot == null) {
            throw new NoSuchElementException("Cannot retrieve data not in the tree");
        }
        int compare = data.compareTo(currRoot.getData());
        if (compare == 0) {
            return currRoot.getData();
        } else if (compare < 0) {
            return get(data, currRoot.getLeft());
        } else {
            return get(data, currRoot.getRight());
        }
    }

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     *
     * This must be done recursively.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to search for
     * @return true if the parameter is contained within the tree, false
     * otherwise
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot search for null data in the tree");
        }
        return contains(data, root);
    }

    /**
     * Private helper method for seeing if data is in the tree.
     *
     * @param data the data to search for
     * @param currRoot the current root
     * @return true if the data is in the tree
     */
    private boolean contains(T data, BSTNode<T> currRoot) {
        if (currRoot == null) {
            return false;
        }
        int compare = data.compareTo(currRoot.getData());
        if (compare == 0) {
            return true;
        } else if (compare < 0) {
            return contains(data, currRoot.getLeft());
        } else {
            return contains(data, currRoot.getRight());
        }
    }

    /**
     * Generate a pre-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the preorder traversal of the tree
     */
    public List<T> preorder() {
        List<T> list = new ArrayList<>(size);
        return preorder(list, root);
    }

    /**
     * Generate an in-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the inorder traversal of the tree
     */
    public List<T> inorder() {
        List<T> list = new ArrayList<>(size);
        return inorder(list, root);
    }

    /**
     * Generate a post-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the postorder traversal of the tree
     */
    public List<T> postorder() {
        List<T> list = new ArrayList<>(size);
        return postorder(list, root);
    }

    /**
     * Helper method for returning a list of the elements in the tree
     * by preorder traversal.
     *
     * @param list the list that will be returned
     * @param node the current node in the tree
     * @return the list of elements
     */
    private List<T> preorder(List<T> list, BSTNode<T> node) {
        if (node != null) {
            list.add(node.getData());
            preorder(list, node.getLeft());
            preorder(list, node.getRight());
        }
        return list;
    }

    /**
     * Helper method for returning a list of the elements in the tree
     * by inorder traversal.
     *
     * @param list the list that will be returned
     * @param node the current node in the tree
     * @return the list of elements
     */
    private List<T> inorder(List<T> list, BSTNode<T> node) {
        if (node != null) {
            inorder(list, node.getLeft());
            list.add(node.getData());
            inorder(list, node.getRight());
        }
        return list;
    }

    /**
     * Helper method for returning a list of the elements in the tree
     * by postorder traversal.
     *
     * @param list the list that will be returned
     * @param node the current node in the tree
     * @return the list of elements
     */
    private List<T> postorder(List<T> list, BSTNode<T> node) {
        if (node != null) {
            postorder(list, node.getLeft());
            postorder(list, node.getRight());
            list.add(node.getData());
        }
        return list;
    }

    /**
     * Generate a level-order traversal of the tree.
     *
     * This does not need to be done recursively.
     *
     * Hint: You will need to use a queue of nodes. Think about what initial
     * node you should add to the queue and what loop / loop conditions you
     * should use.
     *
     * Must be O(n).
     *
     * @return the level order traversal of the tree
     */
    public List<T> levelorder() {
        Queue<BSTNode<T>> q = new LinkedList<>();
        List<T> list = new ArrayList<>();
        if (root == null) {
            throw new NullPointerException("Tree is empty");
        }
        q.add(root);
        while (!q.isEmpty()) {
            BSTNode<T> node = q.remove();
            if (node != null) {
                list.add(node.getData());
                q.add(node.getLeft());
                q.add(node.getRight());
            }
        }
        return list;
    }

    /**
     * Returns the height of the root of the tree.
     *
     * This must be done recursively.
     *
     * A node's height is defined as max(left.height, right.height) + 1. A
     * leaf node has a height of 0 and a null child has a height of -1.
     *
     * Must be O(n).
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    public int height() {
        return root != null ? height(root) : -1;
    }

    /**
     * Helper method for determining the height of the tree
     *
     * @param node the child node
     * @return the height of the subtree
     */
    private int height(BSTNode<T> node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        }
    }

    /**
     * Clears the tree.
     *
     * Clears all data and resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Finds and retrieves the k-largest elements from the BST in sorted order,
     * least to greatest.
     *
     * This must be done recursively.
     *
     * In most cases, this method will not need to traverse the entire tree to
     * function properly, so you should only traverse the branches of the tree
     * necessary to get the data and only do so once. Failure to do so will
     * result in an efficiency penalty.
     *
     * EXAMPLE: Given the BST below composed of Integers:
     *
     *                50
     *              /    \
     *            25      75
     *           /  \
     *          12   37
     *         /  \    \
     *        10  15    40
     *           /
     *          13
     *
     * kLargest(5) should return the list [25, 37, 40, 50, 75].
     * kLargest(3) should return the list [40, 50, 75].
     *
     * Should have a running time of O(log(n) + k) for a balanced tree and a
     * worst case of O(n + k).
     *
     * @param k the number of largest elements to return
     * @return sorted list consisting of the k largest elements
     * @throws java.lang.IllegalArgumentException if k > n, the number of data
     *                                            in the BST
     */
    public List<T> kLargest(int k) {
        if (k > size) {
            throw new IllegalArgumentException("Cannot retrieve more elements than the tree size");
        }
        LinkedList<T> list = new LinkedList<>();
        kLargest(list, k, root);
        return list;
    }

    /**
     * Helper method for kLargest
     *
     * @param list the list of k largest elements
     * @param k the number of largest elements to return
     * @param currRoot the current root of the subtree
     */
    private void kLargest(LinkedList<T> list, int k, BSTNode<T> currRoot) {
        if (list.size() < k) {
            if (currRoot.getRight() == null) {
                list.addFirst(currRoot.getData());
                if (currRoot.getLeft() != null) {
                    kLargest(list, k, currRoot.getLeft());
                }
            } else {
                kLargest(list, k, currRoot.getRight());
                if (list.size() < k) {
                    list.addFirst(currRoot.getData());
                }
                if (currRoot.getLeft() != null) {
                    kLargest(list, k, currRoot.getLeft());
                }
            }
        }
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
