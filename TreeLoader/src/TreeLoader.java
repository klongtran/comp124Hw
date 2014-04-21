import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Khanh-Long on 4/19/14.
 */
public class TreeLoader<T>
{
    public MyGeneralTree<T> createGeneralTree(List<String> nodeInfo)
    {
        Map<String, MyGeneralTreeNode<T>> nodes = new HashMap<>();
        Map<String, String> parentage = new HashMap<>();

        for (int i = 0; i < nodeInfo.size(); i++)
        {
            // grab a line for each node
            String descriptor = nodeInfo.get(i);
            // split them into different
            String[] tokens = descriptor.split(":");
            MyGeneralTreeNode<T> node = new MyGeneralTreeNode<T>((T) tokens[2]);
            // build the nodes table
            nodes.put(node, (T)tokens[3]);
            // build the parentage table
            parentage.put(tokens[0], tokens[1]);
        }
        for (String childID : parentage.keySet())
        {
            String parentID = parentage.get(childID);
        }
        MyGeneralTree<T> tree = new MyGeneralTree<>();
        tree.root =
        return tree;
    }
}
