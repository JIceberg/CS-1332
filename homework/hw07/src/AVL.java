import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.List;

/**
 * Your implementation of an AVL.
 *
 * Yes. Yes it is. :flushed:
 *
 * @author Jackson Isenberg
 * @version 1.0
 * @userid jisenberg3
 * @GTID 903556168
 *
 * Collaborators: N/A
 *
 * Resources: N/A
 */
public class AVL<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private AVLNode<T> root;
    private int size;

    /**
     * Constructs a new AVL.
     *
     * This constructor should initialize an empty AVL.
     *
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public AVL() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Constructs a new AVL.
     *
     * This constructor should initialize the AVL with the data in the
     * Collection. The data should be added in the same order it is in the
     * Collection.
     *
     * @param data the data to add to the tree
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public AVL(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot create an AVL with a null collection");
        }
        for (T entry : data) {
            this.add(entry);
        }
    }

    /**
     * Adds the element to the tree.
     *
     * Start by adding it as a leaf like in a regular BST and then rotate the
     * tree as necessary.
     *
     * If the data is already in the tree, then nothing should be done (the
     * duplicate shouldn't get added, and size should not be incremented).
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after adding the element, making sure to rebalance if
     * necessary.
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to the tree");
        } else if (root == null) {
            this.root = new AVLNode<>(data);
            this.size++;
        } else {
            AVLNode<T> dummy = new AVLNode<>(root.getData());
            this.add(data, root, dummy);
            this.root = dummy;
        }
    }

    /**
     * Helper method for add(data)
     *
     * @param data the data to add
     * @param node the root of the subtree
     * @param dummy the dummy node
     */
    private void add(T data, AVLNode<T> node, AVLNode<T> dummy) {
        if (node == null) {
            return;
        }
        int comparison = data.compareTo(node.getData());
        if (comparison > 0) {
            if (node.getRight() == null) {
                node.setRight(new AVLNode<>(data));
                this.size++;
            } else {
                this.add(data, node.getRight(), dummy);
            }
        }
        if (comparison < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new AVLNode<>(data));
                this.size++;
            } else {
                this.add(data, node.getLeft(), dummy);
            }
        }
        this.updateHeight(node);
        this.updateBalanceFactor(node);
        this.setDummy(dummy, this.balance(node));
    }

    /**
     * Sets the dummy to the node using pointer reinforcement
     *
     * @param dummy the dummy node
     * @param node  the node who will be transferred into the dummy
     */
    private void setDummy(AVLNode<T> dummy, AVLNode<T> node) {
        if (node == null) {
            return;
        }
        dummy.setData(node.getData());
        dummy.setLeft(node.getLeft());
        dummy.setRight(node.getRight());
        dummy.setBalanceFactor(node.getBalanceFactor());
        dummy.setHeight(node.getHeight());
    }

    /**
     * Balances the subtree
     *
     * @param node the root of the subtree
     * @return the new root of the subtree
     */
    private AVLNode<T> balance(AVLNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.getBalanceFactor() < -1) {
            if (node.getRight().getBalanceFactor() > 0) {
                node.setRight(this.rightRotation(node.getRight()));
            }
            return this.leftRotation(node);
        } else if (node.getBalanceFactor() > 1) {
            if (node.getLeft().getBalanceFactor() < 0) {
                node.setLeft(this.leftRotation(node.getLeft()));
            }
            return this.rightRotation(node);
        } else {
            return node;
        }
    }

    /**
     * Performs a left rotation on the current subtree.
     *
     * @param node the current root of the subtree
     * @return the new root of the subtree
     * @throws java.lang.IllegalArgumentException if node has null right child
     */
    private AVLNode<T> leftRotation(AVLNode<T> node) {
        AVLNode<T> pivot = node.getRight();

        if (pivot == null) {
            throw new IllegalArgumentException("Cannot left rotate a subtree with no right child to the root");
        }

        node.setRight(pivot.getLeft());
        pivot.setLeft(node);
        this.updateHeight(node);
        this.updateBalanceFactor(node);
        this.updateHeight(pivot);
        this.updateBalanceFactor(pivot);

        return pivot;
    }

    /**
     * Performs a right rotation on the current subtree.
     *
     * @param node the current root of the subtree
     * @return the new root of the subtree
     * @throws java.lang.IllegalArgumentException if node has null left child
     */
    private AVLNode<T> rightRotation(AVLNode<T> node) {
        AVLNode<T> pivot = node.getLeft();

        if (pivot == null) {
            throw new IllegalArgumentException("Cannot right rotate a subtree with no left child to the root");
        }

        node.setLeft(pivot.getRight());
        pivot.setRight(node);
        this.updateHeight(node);
        this.updateBalanceFactor(node);
        this.updateHeight(pivot);
        this.updateBalanceFactor(pivot);

        return pivot;
    }

    /**
     * Updates the height for the given node
     *
     * @param node the node whose height needs to be updated
     */
    private void updateHeight(AVLNode<T> node) {
        if (node.getLeft() != null && node.getRight() != null) {
            node.setHeight(Math.max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);
        } else if (node.getLeft() != null) {
            node.setHeight(node.getLeft().getHeight() + 1);
        } else if (node.getRight() != null) {
            node.setHeight(node.getRight().getHeight() + 1);
        } else {
            node.setHeight(0);
        }
    }

    /**
     * Updates the balance factor for the given node
     *
     * @param node the node whose balance factor needs to be updated
     */
    private void updateBalanceFactor(AVLNode<T> node) {
        if (node.getLeft() != null && node.getRight() != null) {
            node.setBalanceFactor(node.getLeft().getHeight() - node.getRight().getHeight());
        } else if (node.getLeft() != null) {
            node.setBalanceFactor(node.getLeft().getHeight() + 1);
        } else if (node.getRight() != null) {
            node.setBalanceFactor(-1 - node.getRight().getHeight());
        } else {
            node.setBalanceFactor(0);
        }
    }

    /**
     * Removes and returns the element from the tree matching the given
     * parameter.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     *    simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     *    replace it with its child.
     * 3: The node containing the data has 2 children. Use the predecessor to
     *    replace the data, NOT successor. As a reminder, rotations can occur
     *    after removing the predecessor node.
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after removing the element, making sure to rebalance if
     * necessary.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data the data to remove
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException   if the data is not found
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot remove null data from the tree");
        }
        T tmp;
        if (size == 1 && root.getData().compareTo(data) == 0) {
            tmp = root.getData();
            this.clear();
        } else {
            AVLNode<T> dummy = new AVLNode<>(root.getData());
            tmp = this.remove(data, root, dummy);
            this.root = dummy;
        }
        return tmp;
    }

    /**
     * A private helper method for removing data from the tree.
     *
     * @param data the data to remove from the tree
     * @param node the current root of the subtree
     * @param dummy the dummy node
     * @return the data in the node that was removed
     */
    private T remove(T data, AVLNode<T> node, AVLNode<T> dummy) {
        if (node == null) {
            throw new NoSuchElementException("Could not find " + data + " in the tree, so nothing was removed");
        }
        int comparison = data.compareTo(node.getData());
        if (comparison == 0) {
            T tmp = node.getData();
            if (node.getLeft() != null && node.getRight() != null) {
                AVLNode<T> predecessor = this.predecessor(node, node.getLeft());
                node.setLeft(predecessor);
            } else if (node.getLeft() != null) {
                node.setData(node.getLeft().getData());
                node.setRight(node.getLeft().getRight());
                node.setLeft(node.getLeft().getLeft());
            } else if (node.getRight() != null) {
                node.setData(node.getRight().getData());
                node.setLeft(node.getRight().getLeft());
                node.setRight(node.getRight().getRight());
            } else {
                node.setData(null);
            }
            this.updateHeight(node);
            this.updateBalanceFactor(node);
            this.setDummy(dummy, this.balance(node));
            this.size--;
            return tmp;
        } else if (comparison < 0) {
            T temp = remove(data, node.getLeft(), dummy);
            if (node.getLeft() != null && node.getLeft().getData() == null) {
                node.setLeft(null);
            }
            this.updateHeight(node);
            this.updateBalanceFactor(node);
            this.setDummy(dummy, this.balance(node));
            return temp;
        } else {
            T temp = remove(data, node.getRight(), dummy);
            if (node.getRight() != null && node.getRight().getData() == null) {
                node.setRight(null);
            }
            this.updateHeight(node);
            this.updateBalanceFactor(node);
            this.setDummy(dummy, this.balance(node));
            return temp;
        }
    }

    /**
     * A private helper method for obtaining the predecessor of a node in the tree.
     * We assume the current root is not null.
     *
     * @param currRoot the root whose data we are replacing with the predecessor
     * @param searchRoot the node used to search for the predecessor
     * @return the next node in the search sequence
     */
    private AVLNode<T> predecessor(AVLNode<T> currRoot, AVLNode<T> searchRoot) {
        if (searchRoot.getRight() == null) {
            currRoot.setData(searchRoot.getData());
            return searchRoot.getLeft();
        }
        searchRoot.setLeft(predecessor(currRoot, searchRoot.getRight()));
        return searchRoot;
    }

    /**
     * Returns the element from the tree matching the given parameter.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * @param data the data to search for in the tree
     * @return the data in the tree equal to the parameter
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot retrieve null data from the tree");
        }
        return this.get(data, root);
    }

    /**
     * The recursive helper method for get(data)
     *
     * @param data the data to retrieve/search for
     * @param node the current root node of the subtree
     * @return the data found in the tree
     * @throws java.util.NoSuchElementException if the data is not in the tree
     */
    private T get(T data, AVLNode<T> node) {
        if (node == null) {
            throw new NoSuchElementException("Could not find " + data + " in the tree");
        }
        int comparison = data.compareTo(node.getData());
        if (comparison < 0) {
            return this.get(data, node.getLeft());
        } else if (comparison > 0) {
            return this.get(data, node.getRight());
        } else {
            return node.getData();
        }
    }

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data the data to search for in the tree
     * @return true if the parameter is contained within the tree, false
     * otherwise
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Tree does not contain null data");
        }
        return this.contains(data, root);
    }

    /**
     * The helper method for contains(data)
     *
     * @param data the data to see if it is in the tree
     * @param node the current root of the subtree
     * @return true if the data is in the tree
     */
    private boolean contains(T data, AVLNode<T> node) {
        if (node == null) {
            return false;
        }
        int comparison = data.compareTo(node.getData());
        if (comparison < 0) {
            return this.contains(data, node.getLeft());
        } else if (comparison > 0) {
            return this.contains(data, node.getRight());
        } else {
            return true;
        }
    }

    /**
     * Returns the height of the root of the tree. Do NOT compute the height
     * recursively. This method should be O(1).
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    public int height() {
        return root == null ? -1 : root.getHeight();
    }

    /**
     * Clears the tree.
     *
     * Clears all data and resets the size.
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Find a path of letters in the tree that spell out a particular word,
     * if the path exists.
     *
     * Ex: Given the following AVL
     *
     *                   g
     *                 /   \
     *                e     i
     *               / \   / \
     *              b   f h   n
     *             / \         \
     *            a   c         u
     *
     * wordSearch([b, e, g, i, n]) returns the list [b, e, g, i, n],
     * where each letter in the returned list is from the tree and not from
     * the word array.
     *
     * wordSearch([h, i]) returns the list [h, i], where each letter in the
     * returned list is from the tree and not from the word array.
     *
     * wordSearch([a]) returns the list [a].
     *
     * wordSearch([]) returns an empty list [].
     *
     * wordSearch([h, u, g, e]) throws NoSuchElementException. Although all
     * 4 letters exist in the tree, there is no path that spells 'huge'.
     * The closest we can get is 'hige'.
     *
     * To do this, you must first find the deepest common ancestor of the
     * first and last letter in the word. Then traverse to the first letter
     * while adding letters on the path to the list while preserving the order
     * they appear in the word (consider adding to the front of the list).
     * Finally, traverse to the last letter while adding its ancestor letters to
     * the back of the list. Please note that there is no relationship between
     * the first and last letters, in that they may not belong to the same
     * branch. You will most likely have to split off to traverse the tree when
     * searching for the first and last letters.
     *
     * You may only use 1 list instance to complete this method. Think about
     * what type of list to use since you may have to add to the front and
     * back of the list.
     *
     * You will only need to traverse to the deepest common ancestor once.
     * From that node, go to the first and last letter of the word in one
     * traversal each. Failure to do so will result in a efficiency penalty.
     * Validating the path against the word array efficiently after traversing
     * the tree will NOT result in an efficiency penalty.
     *
     * If there exists a path between the first and last letters of the word,
     * there will only be 1 valid path.
     *
     * You may assume that the word will not contain duplicate letters.
     *
     * WARNING: Do not return letters from the passed-in word array!
     * If a path exists, the letters should be retrieved from the tree.
     * Returning any letter from the word array will result in a penalty!
     *
     * @param word array of T, where each element represents a letter in the
     * word (in order).
     * @return list containing the path of letters in the tree that spell out
     * the word, if such a path exists. Order matters! The ordering of the
     * letters in the returned list should match that of the word array.
     * @throws java.lang.IllegalArgumentException if the word array is null
     * @throws java.util.NoSuchElementException if the path is not in the tree
     */
    public List<T> wordSearch(T[] word) {
        if (word == null) {
            throw new IllegalArgumentException("Cannot search for a null word");
        } else if (word.length == 0) {
            return new LinkedList<>();
        } else if (size < word.length) {
            throw new NoSuchElementException("Tree is smaller than the input word");
        } else {
            LinkedList<T> list = new LinkedList<>();
            AVLNode<T> dca = this.getDCA(word[0], word[word.length - 1], root);
            list.add(dca.getData());

            int compareFirst = word[0].compareTo(dca.getData());
            int compareLast = word[word.length - 1].compareTo(dca.getData());
            if (compareFirst == 0 && compareLast != 0) {
                this.pathToEntry(word[word.length - 1],
                        compareLast < 0 ? dca.getLeft() : dca.getRight(),
                        list, true);
            } else if (compareFirst != 0 && compareLast == 0) {
                this.pathToEntry(word[0],
                        compareFirst < 0 ? dca.getLeft() : dca.getRight(),
                        list, false);
            } else if (compareFirst != 0) {
                this.pathToEntry(word[0],
                        compareFirst < 0 ? dca.getLeft() : dca.getRight(),
                        list, false);
                this.pathToEntry(word[word.length - 1],
                        compareLast < 0 ? dca.getLeft() : dca.getRight(),
                        list, true);
            }

            if (list.size() != word.length) {
                throw new NoSuchElementException("Cannot find a valid path for the search");
            }
            for (int i = 0; i < word.length; i++) {
                if (!list.get(i).equals(word[i])) {
                    throw new NoSuchElementException("Cannot find a valid path for the search");
                }
            }

            return list;
        }
    }

    /**
     * Put the path to entry into the given list
     *
     * @param entry     the entry to find
     * @param node      the current node
     * @param list      the list to add data to
     * @param addToBack add to back of list if true, else add to front
     */
    private void pathToEntry(T entry, AVLNode<T> node, LinkedList<T> list, boolean addToBack) {
        if (node == null) {
            return;
        }
        if (addToBack) {
            list.addLast(node.getData());
        } else {
            list.addFirst(node.getData());
        }
        int comparison = entry.compareTo(node.getData());
        if (comparison == 0) {
            return;
        } else if (comparison < 0) {
            this.pathToEntry(entry, node.getLeft(), list, addToBack);
        } else {
            this.pathToEntry(entry, node.getRight(), list, addToBack);
        }
    }

    /**
     * Find the deepest common ancestor of two entries
     *
     * @param first the first entry
     * @param last  the last entry
     * @param node the node we will use to find the common ancestor
     * @return the deepest common ancestor
     */
    private AVLNode<T> getDCA(T first, T last, AVLNode<T> node) {
        if (node == null) {
            throw new NoSuchElementException("Cannot find a common path for the search");
        } else {
            int compareFirst = first.compareTo(node.getData());
            int compareLast = last.compareTo(node.getData());
            if (compareFirst < 0 && compareLast < 0) {
                return this.getDCA(first, last, node.getLeft());
            } else if (compareFirst > 0 && compareLast > 0) {
                return this.getDCA(first, last, node.getRight());
            } else {
                return node;
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
    public AVLNode<T> getRoot() {
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