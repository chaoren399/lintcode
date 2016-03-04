package lintcode.binarytree;


import java.util.*;

/**
 * Created by zzy on 15/12/23.
 */
public class BinaryTree {

    public static void main(String[] args) {

//
//        TreeNode newNodeB = new TreeNode(2,"B");
//        TreeNode newNodeC = new TreeNode(3,"C");
//        TreeNode newNodeD = new TreeNode(4,"D");
//        TreeNode newNodeE = new TreeNode(5,"E");
//        TreeNode newNodeF = new TreeNode(6,"F");
//        root.leftChild=newNodeB;
//        root.rightChild=newNodeC;
//        root.leftChild.leftChild=newNodeD;
//        root.leftChild.rightChild=newNodeE;
//        root.rightChild.rightChild=newNodeF;

//        {
//            TreeNode tn = new TreeNode(2);
//            TreeNode a = new TreeNode(1);
//            TreeNode b = new TreeNode(3);
//            tn.left = a;
//            tn.right = b;
//            if (tn == null) {
//                System.out.println("tn is null");
//            }
//
////        System.out.println(preorderTraversal(tn));
//            TreeNode result = inorderSuccessor(tn, a);
//
//            System.out.println(result.val);
//        }


//        {
//            TreeNode tn = new TreeNode(1);
//            TreeNode tnleft = null;
//            TreeNode a = new TreeNode(2);
//            TreeNode b = new TreeNode(3);
//            tn.left = tnleft;
//
//            tn.right = a;
//            tn.right.left = b;
//
//            if (tn == null) {
//                System.out.println("tn is null");
//            }
//
////        System.out.println(preorderTraversal(tn));
//             boolean isbalanced = isBalanced(tn);
//
//            System.out.println(isbalanced);
//        }


//        {
//            TreeNode tn = new TreeNode(1);
//
//            TreeNode a = new TreeNode(2);
//            TreeNode b = new TreeNode(3);
//
//
//            tn.right = a;
//            tn.left = b;
//
//            levelOrder(tn);
////            levelOrder1(tn);
//        }

        Stack<TreeNode> stack = new Stack<>();
        int [][] x = new int[8][9];
        System.out.println(x.length);



    }

    public static ArrayList<ArrayList<Integer>> levelOrder1(TreeNode root) {
        ArrayList result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }
    public static  ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> leverl = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                leverl.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(leverl);
        }
        return result;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }

        // divide
        if (root.left != null) {
            boolean leftboolen = isBalanced(root.left);
        }
        if (root.right != null) {
            boolean rightboolen = isBalanced(root.right);
        }



        // conquer
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left++;
        }
        if (root.right != null) {
            right++;
        }
        if (left == 0 && right == 0) {
            if (Math.abs(left - right) > 1) {
                return false;
            } else {
                return true;
            }
        }
        return false;

    }
    public static TreeNode inorderSuccessor(TreeNode root,TreeNode p){
        TreeNode successor = null;
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if (root == null) {
            return null;
        }

        if (root.right == null) {
            return successor;
        }

        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return  result;
        }
        ArrayList<Integer> left = (ArrayList<Integer>) preorderTraversal(root.left);
        ArrayList<Integer> right = (ArrayList<Integer>) preorderTraversal(root.right);


        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;

     }

}
