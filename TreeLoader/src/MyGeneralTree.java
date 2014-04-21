import javax.xml.soap.Node;
import java.util.List;

/**
 * Created by Khanh-Long on 4/19/14.
 */
public class MyGeneralTree<T> {
    MyGeneralTreeNode<T> root;

    public int getHeight(MyGeneralTreeNode<T> node) {
        if (isLeaf(node))
        {
            return 0;
        }
        int maxDepth = 0;

        for (int i = 0; i < node.children.size(); i++)
        {
            MyGeneralTreeNode<T> currentChild = node.children.get(i);
            maxDepth = Math.max(maxDepth, getHeight(currentChild));
        }
        return maxDepth + 1;
    }

    public int getNumberOfBranchNodes(MyGeneralTreeNode<T> node) {
        if (!isLeaf(node))
        {
            return 1;
        }
        int total = 0;
        for (int i = 0; i < node.children.size(); i++)
        {
            MyGeneralTreeNode<T> currentChild = node.children.get(i);
            total = total + getNumberOfBranchNodes(currentChild);
        }
        return total;
    }

    public int getNumberOfLeaves(MyGeneralTreeNode<T> node) {
        if (isLeaf(node))
        {
            return 1;
        }
        int total = 0;
        for (int i = 0; i < node.children.size(); i++)
        {
            MyGeneralTreeNode<T> currentChild = node.children.get(i);
            total = total + getNumberOfLeaves(currentChild);
        }
        return total;
    }

    public int getNumberOfNodes(MyGeneralTreeNode<T> node) {
        return getNumberOfBranchNodes(node) + getNumberOfLeaves(node);
    }

    public String getPostOrderStructure(MyGeneralTreeNode<T> node)
    {
        String order = "";
        for (int i=0; i< node.children.size(); i++)
        {
            MyGeneralTreeNode<T> currentChild = node.children.get(i);
            order = order + getPostOrderStructure(currentChild);
        }
        order = order + node.data;
        return order;
    }

    public String getPreOrderStructure() {
        return null;
    }

    public String getStructure() {
        return null;
    }

    public boolean isLeaf(MyGeneralTreeNode<T> node) {
        if (node.children == null) return true;
        else return false;
    }
}
