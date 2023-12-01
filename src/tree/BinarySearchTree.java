package tree;

public class BinarySearchTree {
    private Node root;

    private static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    // 데이터 추가
    public void insert(int key) {
        root = insertNode(root, key);
    }

    // 추가 재귀함수
    private Node insertNode(Node node, int key) {
        // 현재 공간이 비었을 경우 새 노드를 만든다.
        if (node == null) {
            node = new Node(key);
            return node;
        }

        // 현재 노드보다 데이터가 작을경우 왼쪽으로
        if (key < node.key) {
            node.left = insertNode(node.left, key);
        }
        // 현재 노드보다 데이터가 클경우 오른쪽으로
        else if (key > node.key) {
            node.right = insertNode(node.right, key);
        }

        return node;
    }

    // 탐색
    public boolean search(int key) {
        return searchNode(root, key);
    }

    // 탐색 재귀함수
    private boolean searchNode(Node node, int key) {
        // 현재 노드가 없을 경우 탐색 실패
        if (node == null) {
            return false;
        }

        // 탐색 성공
        if (key == node.key) {
            return true;
        }

        // 현재 노드보다 데이터가 작을경우 왼쪽으로
        if (key < node.key) {
            return searchNode(node.left, key);
        }
        // 현재 노드보다 데이터가 클경우 오른쪽으로
        else {
            return searchNode(node.right, key);
        }
    }

    // 중위순회
    public void inorderTraversal() {
        inorder(root);
    }

    // BST 는 중위 순회할 시 오름차순으로 출력된다.
    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // 삭제
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    // 삭제 재귀함수
    private Node deleteNode(Node node, int key) {
        // 없는 노드는 돌아간다.
        if (node == null) {
            return null;
        }

        // 노드의 값이 삭제 대상보다 작을 경우
        if (key < node.key) {
            // 왼쪽 노드로 간다.
            // 삭제 결과에 따라 자식이 갱신될 수 있다.
            node.left = deleteNode(node.left, key);
        }
        // 노드의 값이 삭제 대상보다 클 경우
        else if (key > node.key) {
            // 오른쪽 노드로 간다.
            // 삭제 결과에 따라 자식이 갱신될 수 있다.
            node.right = deleteNode(node.right, key);
        }
        // 현재 노드가 삭제 대상이다.
        else {
            // 두 자식 중 하나가 없으면 반대쪽 자식이 현재 노드의 위치에 들어온다.
            // 두 자식 다 없으면 현재 노드가 단말 노드이기 때문에 null을 반환하게 된다.
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // 두 자식이 다 있다면
            // 오른쪽 서브트리의 가장 작은 값을 찾아 현재 노드에 할당한다.
            node.key = minValue(node.right);
            // 그 값을 가지는 노드를 제거한다.
            node.right = deleteNode(node.right, node.key);
        }

        // 현재 노드를 다시 반환한다.
        return node;
    }

    // 최소 값
    // 왼쪽 자식을 계속해서 찾아간다.
    private int minValue(Node node) {
        int min = node.key;
        while (node.left != null) {
            min = node.left.key;
            node = node.left;
        }
        return min;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
    }
}