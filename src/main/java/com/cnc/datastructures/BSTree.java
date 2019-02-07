package com.cnc.datastructures;

public class BSTree<T extends Comparable> {

    private Node<T> root;

    public void prettyPrint() {
        int depth = this.findDepth();

        Queue<Node<T>> queue = new Queue<>();
        if(this.getRoot() != null) {
            queue.push(this.getRoot());
        }

        StringBuilder currentLine = new StringBuilder();
        int nodesOnCurrentLine = 0;
        int currentDepth = 0;
        Node<T> blankSpaceNode = new Node<T>();

        while(queue.size() > 0) {
            Node<T> current = queue.pop();
            if(current.getLeft() != null) {
                queue.push(current.getLeft());
            }
            else if(currentDepth + 1 < depth) {
                queue.push(blankSpaceNode);
            }
            if(current.getRight() != null) {
                queue.push(current.getRight());
            }
            else if(currentDepth + 1 < depth) {
                queue.push(blankSpaceNode);
            }

            currentLine.append(leftpad(current.getData(), (depth - currentDepth) * 10));
            nodesOnCurrentLine++;


            if(Math.pow(2, currentDepth) <= nodesOnCurrentLine) {
                currentDepth++;
                nodesOnCurrentLine = 0;
                System.out.println(currentLine.toString());
                currentLine = new StringBuilder();
            }
        }

        if(currentLine.length() > 0) {
            System.out.println(currentLine.toString());
        }
    }

    private String leftpad(T text, int length) {
        return String.format("%" + length + "." + length + "s", text);
    }

    public int findDepth() {
        return findDepthHelper(root);
    }

    public int findDepthHelper(Node<T> root) {
        if (root == null) {
            return 0;
        }
        else {
            int left = findDepthHelper(root.getLeft());
            int right = findDepthHelper(root.getRight());
            return Math.max(left, right) + 1;
        }
    }

    public boolean add(T value) {

        Node<T> current = root;
        Node<T> nodeToInsert = new Node<T>();
        nodeToInsert.setData(value);

        if (root == null) {
            root = nodeToInsert;
            return true;
        }

        while (current != null) {
            int compared = value.compareTo(current.getData());
            if (compared == 0) {
                return false;
            }
            else if (compared < 0) {
                if (current.getLeft() == null) {
                    current.setLeft(nodeToInsert);
                    return true;
                }
                else {
                    current = current.getLeft();
                }
            }
            else {
                if (current.getRight() == null) {
                    current.setRight(nodeToInsert);
                    return true;
                }
                else {
                    current = current.getRight();
                }
            }
        }
        return false;
    }

    public T find(T value) {
        Node<T> found = findNode(value, this.root);
        T result = null;
        if(found != null) {
            result = found.getData();
        }
        return result;
    }

    private Node<T> findNode(T value, Node<T> current) {
        int comparison;
        while (current != null) {
            comparison = value.compareTo(current.getData());
            if (comparison == 0) {
                return current;
            }
            else if (comparison > 0) {
                current = current.getRight();
            }
            else {
                current = current.getLeft();
            }
        }
        return null;
    }

    public Node<T> getRoot() {
        return root;
    }

    private Node<T> findMinimum(Node<T> root) {
        Node<T> min = root;
        while (min.getRight() != null) {
            min = min.getRight();
        }
        return min;
    }

    private void remove(T value, Node<T> startingRoot) {
        if(startingRoot != null) {
            //find node to delete
            Node<T> prev = null;
            Node<T> current = startingRoot;
            while (current != null && !current.getData().equals(value)) {
                prev = current;
                if(current.getData().compareTo(value) > 0) {
                    current = current.getLeft();
                }
                else {
                    current = current.getRight();
                }
            }
            //found the node!
            if(current != null) {
                //2 children (the hard one)
                if(current.getLeft() != null && current.getRight() != null) {

                    //choose minimum from right
                    Node<T> minimum = findMinimum(current.getRight());
                    //copy value to current
                    current.setData(minimum.getData());
                    //remove the value
                    remove(value, current.getRight());
                }
                //no children
                else if(current.getLeft() == null && current.getRight() == null) {
                    if(prev == null) {
                        this.root = null;
                    }
                    else {
                        if(prev.getRight() == current) {
                            prev.setRight(null);
                        }
                        else {
                            prev.setLeft(null);
                        }
                    }
                }
                //left child only
                else if(current.getLeft() != null) {
                    if(prev == null) {
                        this.root = current.getLeft();
                    }
                    else {
                        if(prev.getRight() == current) {
                            prev.setRight(current.getLeft());
                        }
                        else {
                            prev.setLeft(current.getLeft());
                        }
                    }
                }
                //right child only
                else if(current.getRight() != null) {
                    if(prev == null) {
                        this.root = current.getRight();
                    }
                    else {
                        if(prev.getRight() == current) {
                            prev.setRight(current.getRight());
                        }
                        else {
                            prev.setLeft(current.getRight());
                        }
                    }

                }
            }
        }
    }

}
