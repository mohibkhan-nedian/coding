package com.Tree;

public class ZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean even = true;

        while(!q.isEmpty()){
            int n = q.size();
            // we can also use simple linked list and use addFisrt() to append on head for odd levels but that will take n time, where as arraydequeu will take constant time
            Deque<Integer> subList = new ArrayDeque<>();

            for(int i = 0; i < n; i++){
                TreeNode top = q.remove();

                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
                if(even)
                    subList.addLast(top.val); // takes constant time
                else {
                    //this means we insert in reverse order for odd level so they will be removed in reverese as well which is what we want
                    subList.addFirst(top.val);//takes constant time because it is arraydeque
                }
            }
            list.add(new ArrayList<>(subList));
            even = !even;
        }

        return list;
    }
}
