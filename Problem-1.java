// Time Complexity : O(n) for dfs and bfs, 
// Space Complexity : O(n) space for bfs and O(h) for dfs
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

   

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> re = new LinkedList<>();
        helper(root, 0, re);

        return re;
    } 

    private void helper(TreeNode root, int level, List<Integer> re){
        //base
        if(root == null) return;

        //logic
        if(level == re.size()){
            re.add(level, root.val);
        }else{
            re.set(level, root.val);
        }

        helper(root.left, level + 1, re);
        helper(root.right, level + 1, re);
    }

    public List<Integer> rightSideViewBFS(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> re = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(i == size - 1){
                    re.add(cur.val);
                }

                if(cur.left != null){
                    q.add(cur.left);
                }

                if(cur.right != null){
                    q.add(cur.right);
                }
            }
        }
        return re;
    } 


    public List<Integer> rightSideViewOld(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> r = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        // r.add(root.val);

        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                if(i == size - 1){
                    r.add(node.val);
                }

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        return r;
    }
}