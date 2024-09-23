// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int dep_x;
    int dep_y;
    TreeNode x_par;
    TreeNode y_par;
    boolean flag = true;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,y,0);
        if(!flag) return false;
        return (dep_x == dep_y);
    }

    private void dfs(TreeNode root, int x, int y, int depth){
        //base
        if(!flag) return;
        if(dep_x != 0 && dep_y != 0){
            return;
        }
        if(root == null) return ;

        //logic
        if(root.val == x){
            dep_x = depth;
        }

        if(root.val == y){
            dep_y = depth;
        }

        System.out.println(root.val);

        if(root.left != null && root.right != null){
            if(root.left.val == x && root.right.val == y){
                flag = false;
                return;
            }

            if(root.left.val == y && root.right.val == x){
                flag = false;
                return;
            }
        }

        //recurse
        if(flag) dfs(root.left,x,y,depth+1);
        if(flag) dfs(root.right,x,y,depth+1);

    }
}