package com.manish.superbalancetree;
import java.util.*;


public class SuperBalanceTree {

    public static boolean isBalanced( Tree root){
    if (root == null)
        return  true;

    List<Integer> depths = new ArrayList<>(3);
    Deque<NodePair> nodes = new ArrayDeque<>();
    nodes.push(new NodePair(root, 0));
    while(!nodes.isEmpty()){
        NodePair nodePair = nodes.pop();
        Tree node = nodePair.node;
        int depth = nodePair.depth;
        if(node.left == null && node.right == null){
            if(!depths.contains(depth)){
                depths.add(depth);
            }
            if(depths.size() > 2 || (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1 )){
                return false;
            }

        } else {
            if (node.left != null){
                nodes.push(new NodePair(node.left, depth+1));
            }
            if(node.right != null){
                nodes.push(new NodePair(node.right,depth+1));
            }
        }

    }
    return  true;
    }
}

class NodePair {
Tree node;
int depth;
    NodePair(Tree node, int depth){
        this.node = node;
        this.depth = depth;
    }
}
class Tree {
    int value;
    Tree left, right;

    Tree(int value){
        this.value = value;
        left = right = null;
    }

}