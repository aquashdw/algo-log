package tree;

public class TreeTraverse {
    private int nodes;
    private int[] arr;

    public void setArr(int[] arr) {
        this.arr = arr;
        this.nodes = arr.length;
    }

    public static void main(String[] args) {
        TreeTraverse tree = new TreeTraverse();
//        tree.setArr(new int[]{
//                0, 1, 2, 3, 4, 0, 5, 6, 7, 0, 0, 0, 8, 9, 10, 11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13
//        });
        tree.setArr(new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        });
        tree.traversePreorder(1);
        System.out.println();
        tree.traverseInorder(1);
        System.out.println();
        tree.traversePostorder(1);
        System.out.println();
    }

    public void traversePreorder(int node) {
        if (node < nodes && arr[node] != 0) {
            System.out.print(arr[node] + ", ");
            this.traversePreorder(node * 2);
            this.traversePreorder(node * 2 + 1);
        }
    }

    public void traverseInorder(int node) {
        if (node < nodes && arr[node] != 0) {
            this.traverseInorder(node * 2);
            System.out.print(arr[node] + ", ");
            this.traverseInorder(node * 2 + 1);
        }
    }

    public void traversePostorder(int node) {
        if (node < nodes && arr[node] != 0) {
            this.traversePostorder(node * 2);
            this.traversePostorder(node * 2 + 1);
            System.out.print(arr[node] + ", ");
        }
    }
}
