import java.util.List;

/**
 * Created by Khanh-Long on 4/19/14.
 */
public class MyGeneralTreeNode<T> {
    T data;
    List<MyGeneralTreeNode<T>> children;

    public MyGeneralTreeNode(T data) {
        this.data = data;
        children = null;
    }

    public MyGeneralTreeNode() {
    }

}
