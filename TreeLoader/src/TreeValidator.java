/**
 * Created by Khanh-Long on 4/19/14.
 */

public class TreeValidator
{
    static public boolean areEqual(MyGeneralTree tree1, MyGeneralTree tree2)
    {
        return areRecursivelyEqual(tree1.root, tree2.root);
    }

    static private boolean areRecursivelyEqual(
            MyGeneralTreeNode<String> nodeA,
            MyGeneralTreeNode<String> nodeB)
    {
        if (!nodeA.data.equals(nodeB.data))
        {
            return false;
        }

        for (int i = 0; i < nodeA.children.size(); i++)
        {
            boolean found = false;
            for (int j = 0; j < nodeB.children.size(); j++)
            {
                found = areRecursivelyEqual(nodeA.children.get(i), nodeB.children.get(j));
                if (found)
                {
                    break;
                }
            }
            if (!found)
            {
                return false;
            }
        }

        for (int i = 0; i < nodeB.children.size(); i++)
        {
            boolean found = false;
            for (int j = 0; j < nodeA.children.size(); j++)
            {
                found = areRecursivelyEqual(nodeB.children.get(i), nodeA.children.get(j));
                if (found)
                {
                    break;
                }
            }
            if (!found)
            {
                return false;
            }
        }

        return true;
    }
}
