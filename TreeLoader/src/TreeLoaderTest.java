/**
 * Created by Khanh-Long on 4/19/14.
 */

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author jaya0089
 */
public class TreeLoaderTest
{
    @Test
    public void testOnEmptyTree()
    {
        // test an empty tree
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        assertNull("Gave null", tl.createGeneralTree(null));
        assertNull("Gave empty list", tl.createGeneralTree(list));
    }

    @Test
    public void testOnOneNodeTree()
    {
        //test a one node tree
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode<>();
        expected.root.data = "hello world";
        list.add("0 : : hello world");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

    @Test
    public void test3LevelTree()
    {
        // hello
        //   |-- 007
        //   |-- random
        //         |-- jon spiro
        //         |-- hello again
        //   |- square
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode<>();
        expected.root.data = "hello world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "007";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "Random !@##";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Square?!?!";
        expected.root.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Jon Spiro";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "hello once more world!";
        node2.children.add(node5);

        list.add("0 : : hello world");
        list.add("1 : 0 : 007");
        list.add("2 : 0 : Random !@##");
        list.add("3 : 0 : Square?!?!");
        list.add("4 : 2 : Jon Spiro");
        list.add("5 : 2 : hello once more world!");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

    @Test
    public void test13NodeTree()
    {
        // test a complex tree
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode<>();
        expected.root.data = "hello world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "007";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "Random !@##";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Square?!?!";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Jon Spiro";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "hello once more world!";
        node2.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "NetBeaners unite";
        node3.children.add(node6);
        MyGeneralTreeNode<String> node7 = new MyGeneralTreeNode();
        node7.data = "Trees!!!are!!!fun";
        node3.children.add(node7);
        MyGeneralTreeNode<String> node8 = new MyGeneralTreeNode();
        node8.data = "Plant more of them";
        node3.children.add(node8);
        MyGeneralTreeNode<String> node9 = new MyGeneralTreeNode();
        node9.data = "Can I get paid for advertising here?";
        node7.children.add(node9);
        MyGeneralTreeNode<String> node10 = new MyGeneralTreeNode();
        node10.data = "People want 1902 students";
        node9.children.add(node10);
        MyGeneralTreeNode<String> node11 = new MyGeneralTreeNode();
        node11.data = "Maveric* is hiring now";
        node4.children.add(node11);
        MyGeneralTreeNode<String> node12 = new MyGeneralTreeNode();
        node12.data = "So are a lot of other places";
        node5.children.add(node12);


        list.add("0 : : hello world");
        list.add("1 : 0 : 007");
        list.add("2 : 0 : Random !@##");
        list.add("3 : 1 : Square?!?!");
        list.add("4 : 2 : Jon Spiro");
        list.add("5 : 2 : hello once more world!");
        list.add("6 : 3 : NetBeaners unite");
        list.add("7 : 3 : Trees!!!are!!!fun");
        list.add("8 : 3 : Plant more of them");
        list.add("9 : 7 : Can I get paid for advertising here?");
        list.add("10 : 9 : People want 1902 students");
        list.add("11 : 4 : Maveric* is hiring now");
        list.add("12 : 5 : So are a lot of other places");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

    @Test
    public void testUnorderedNodeIDs()
    {
        // now we mess up ids
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode<>();
        expected.root.data = "hello world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "007";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "Random !@##";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Square?!?!";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Jon Spiro";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "hello once more world!";
        node2.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "NetBeaners unite";
        node3.children.add(node6);
        MyGeneralTreeNode<String> node7 = new MyGeneralTreeNode();
        node7.data = "Trees!!!are!!!fun";
        node3.children.add(node7);
        MyGeneralTreeNode<String> node8 = new MyGeneralTreeNode();
        node8.data = "Plant more of them";
        node3.children.add(node8);
        MyGeneralTreeNode<String> node9 = new MyGeneralTreeNode();
        node9.data = "Can I get paid for advertising here?";
        node7.children.add(node9);
        MyGeneralTreeNode<String> node10 = new MyGeneralTreeNode();
        node10.data = "People want 1902 students";
        node9.children.add(node10);
        MyGeneralTreeNode<String> node11 = new MyGeneralTreeNode();
        node11.data = "Maveric* is hiring now";
        node4.children.add(node11);
        MyGeneralTreeNode<String> node12 = new MyGeneralTreeNode();
        node12.data = "So are a lot of other places";
        node5.children.add(node12);


        list.add("0 : : hello world");
        list.add("-800 : 0 : 007");
        list.add("43 : 0 : Random !@##");
        list.add("1 : -800 : Square?!?!");
        list.add("-4 : 43 : Jon Spiro");
        list.add("-55 : 43 : hello once more world!");
        list.add("62 : 1 : NetBeaners unite");
        list.add("71111 : 1 : Trees!!!are!!!fun");
        list.add("80 : 1 : Plant more of them");
        list.add("108 : 71111 : Can I get paid for advertising here?");
        list.add("107 : 108 : People want 1902 students");
        list.add("12 : -4 : Maveric* is hiring now");
        list.add("13 : -55 : So are a lot of other places");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

    @Test
    public void testNonNumericIDs()
    {
        // now we do non numeric ids
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode<>();
        expected.root.data = "hello world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "007";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "Random !@##";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Square?!?!";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Jon Spiro";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "hello once more world!";
        node2.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "NetBeaners unite";
        node3.children.add(node6);
        MyGeneralTreeNode<String> node7 = new MyGeneralTreeNode();
        node7.data = "Trees!!!are!!!fun";
        node3.children.add(node7);
        MyGeneralTreeNode<String> node8 = new MyGeneralTreeNode();
        node8.data = "Plant more of them";
        node3.children.add(node8);
        MyGeneralTreeNode<String> node9 = new MyGeneralTreeNode();
        node9.data = "Can I get paid for advertising here?";
        node7.children.add(node9);
        MyGeneralTreeNode<String> node10 = new MyGeneralTreeNode();
        node10.data = "People want 1902 students";
        node9.children.add(node10);
        MyGeneralTreeNode<String> node11 = new MyGeneralTreeNode();
        node11.data = "Maveric* is hiring now";
        node4.children.add(node11);
        MyGeneralTreeNode<String> node12 = new MyGeneralTreeNode();
        node12.data = "So are a lot of other places";
        node5.children.add(node12);


        list.add("0 : : hello world");
        list.add("gedit : 0 : 007");
        list.add("rm -f *.o : 0 : Random !@##");
        list.add("ls -a : gedit : Square?!?!");
        list.add("vim : rm -f *.o : Jon Spiro");
        list.add("-55 : rm -f *.o : hello once more world!");
        list.add("62 : ls -a : NetBeaners unite");
        list.add("71111 : ls -a : Trees!!!are!!!fun");
        list.add("80 : ls -a : Plant more of them");
        list.add("108 : 71111 : Can I get paid for advertising here?");
        list.add("git commit -m : 108 : People want 1902 students");
        list.add("12 : vim : Maveric* is hiring now");
        list.add("13 : -55 : So are a lot of other places");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

    @Test
    public void testNodesInRandomOrder()
    {
        // now we mess up order!
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode<>();
        expected.root.data = "hello world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "007";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "Random !@##";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Square?!?!";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Jon Spiro";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "hello once more world!";
        node2.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "Plant more of them";
        node3.children.add(node6);
        MyGeneralTreeNode<String> node7 = new MyGeneralTreeNode();
        node7.data = "NetBeaners unite";
        node3.children.add(node7);
        MyGeneralTreeNode<String> node8 = new MyGeneralTreeNode();
        node8.data = "Trees!!!are!!!fun";
        node3.children.add(node8);
        MyGeneralTreeNode<String> node9 = new MyGeneralTreeNode();
        node9.data = "Can I get paid for advertising here?";
        node8.children.add(node9);
        MyGeneralTreeNode<String> node10 = new MyGeneralTreeNode();
        node10.data = "People want 1902 students";
        node9.children.add(node10);
        MyGeneralTreeNode<String> node11 = new MyGeneralTreeNode();
        node11.data = "Maveric* is hiring now";
        node4.children.add(node11);
        MyGeneralTreeNode<String> node12 = new MyGeneralTreeNode();
        node12.data = "So are a lot of other places";
        node5.children.add(node12);


        list.add("vim : rm -f *.o : Jon Spiro");
        list.add("80 : ls -a : Plant more of them");
        list.add("108 : 71111 : Can I get paid for advertising here?");
        list.add("62 : ls -a : NetBeaners unite");
        list.add("71111 : ls -a : Trees!!!are!!!fun");
        list.add("gedit : 0 : 007");
        list.add("12 : vim : Maveric* is hiring now");
        list.add("13 : -55 : So are a lot of other places");
        list.add("rm -f *.o : 0 : Random !@##");
        list.add("ls -a : gedit : Square?!?!");
        list.add("git commit -m : 108 : People want 1902 students");
        list.add("0 : : hello world");
        list.add("-55 : rm -f *.o : hello once more world!");

        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

    @Test
    public void testRequiredTrim()
    {
        // now we add space
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode<>();
        expected.root.data = "hello world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "007";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "Random !@##";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Square?!?!";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Jon Spiro";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "hello once more world!";
        node2.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "Plant more of them";
        node3.children.add(node6);
        MyGeneralTreeNode<String> node7 = new MyGeneralTreeNode();
        node7.data = "NetBeaners unite";
        node3.children.add(node7);
        MyGeneralTreeNode<String> node8 = new MyGeneralTreeNode();
        node8.data = "Trees!!!are!!!fun";
        node3.children.add(node8);
        MyGeneralTreeNode<String> node9 = new MyGeneralTreeNode();
        node9.data = "Can I get paid for advertising here?";
        node8.children.add(node9);
        MyGeneralTreeNode<String> node10 = new MyGeneralTreeNode();
        node10.data = "People want 1902 students";
        node9.children.add(node10);
        MyGeneralTreeNode<String> node11 = new MyGeneralTreeNode();
        node11.data = "Maveric* is hiring now";
        node4.children.add(node11);
        MyGeneralTreeNode<String> node12 = new MyGeneralTreeNode();
        node12.data = "So are a lot of other places";
        node5.children.add(node12);


        list.add("   vim :  rm -f *.o   :  Jon Spiro  ");
        list.add("  80 : ls -a      : Plant more of them  ");
        list.add(" 108 : 71111  :    Can I get paid for advertising here? ");
        list.add("62 : ls -a    : NetBeaners unite  ");
        list.add("   71111 : ls -a   : Trees!!!are!!!fun    ");
        list.add(" gedit :   0 :   007  ");
        list.add("12 :  vim :   Maveric* is hiring now  ");
        list.add("       13 :           -55 :   So are a lot of other places ");
        list.add("  rm -f *.o  : 0 : Random !@##");
        list.add("   ls -a   : gedit :  Square?!?!               ");
        list.add(" git commit -m :  108   :  People want 1902 students  ");
        list.add("0 :   :  hello world  ");
        list.add("  -55   : rm -f *.o :  hello once more world! ");

        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

    //hidden tests

    @Test
    public void testSmallTreeHidden() {
        //test a one node tree
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode();
        expected.root.data = "is there really a world";
        list.add("0 : : is there really a world");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

    @Test
    public void testSmallTree2Hidden() {
        //test a one node tree
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode();
        expected.root.data = "goodbye world";
        list.add("0 : : goodbye world");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

    @Test
    public void testMediumTree1Hidden() {
        //test a simple tree
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode();
        expected.root.data = "goodbye world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "scarlet postal";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "What is going on?";
        node1.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Rayleigh scattering";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Wherever I go";
        node1.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "I will be here!!!";
        node1.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "All that we can imagine";
        node4.children.add(node6);


        list.add("0 : : goodbye world");
        list.add("1 : 0 : scarlet postal");
        list.add("2 : 1 : What is going on?");
        list.add("3 : 1 : Rayleigh scattering");
        list.add("4 : 1 : Wherever I go");
        list.add("5 : 1 : I will be here!!!");
        list.add("6 : 4 : All that we can imagine");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

    @Test
    public void testMediumTree2Hidden() {
        //test another simple tree
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode();
        expected.root.data = "goodbye world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "scarlet postal";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "What is going on?";
        node1.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Rayleigh scattering";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Wherever I go";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "I will be here!!!";
        node4.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "All that we can imagine";
        node4.children.add(node6);


        list.add("0 : : goodbye world");
        list.add("1 : 0 : scarlet postal");
        list.add("2 : 1 : What is going on?");
        list.add("3 : 1 : Rayleigh scattering");
        list.add("4 : 2 : Wherever I go");
        list.add("5 : 4 : I will be here!!!");
        list.add("6 : 4 : All that we can imagine");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }


    @Test
    public void testLargeTreeHidden() {
        // test a complex tree
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode();
        expected.root.data = "goodbye world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "scarlet postal";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "What is going on?";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Rayleigh scattering";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Wherever I go";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "I will be here!!!";
        node2.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "All that we can imagine";
        node2.children.add(node6);
        MyGeneralTreeNode<String> node7 = new MyGeneralTreeNode();
        node7.data = "We didn't start the fire---";
        node5.children.add(node7);
        MyGeneralTreeNode<String> node8 = new MyGeneralTreeNode();
        node8.data = "It was always burning";
        node7.children.add(node8);
        MyGeneralTreeNode<String> node9 = new MyGeneralTreeNode();
        node9.data = "Since the world's been turning.";
        node7.children.add(node9);
        MyGeneralTreeNode<String> node10 = new MyGeneralTreeNode();
        node10.data = "We didn't start the fire";
        node3.children.add(node10);
        MyGeneralTreeNode<String> node11 = new MyGeneralTreeNode();
        node11.data = "No we didn't light it";
        node10.children.add(node11);
        MyGeneralTreeNode<String> node12 = new MyGeneralTreeNode();
        node12.data = "But we tried to fight it.";
        node10.children.add(node12);


        list.add("0 : : goodbye world");
        list.add("1 : 0 : scarlet postal");
        list.add("2 : 0 : What is going on?");
        list.add("3 : 1 : Rayleigh scattering");
        list.add("4 : 2 : Wherever I go");
        list.add("5 : 2 : I will be here!!!");
        list.add("6 : 2 : All that we can imagine");
        list.add("7 : 5 : We didn't start the fire---");
        list.add("8 : 7 : It was always burning");
        list.add("9 : 7 : Since the world's been turning.");
        list.add("10 : 3 : We didn't start the fire");
        list.add("11 : 10 : No we didn't light it");
        list.add("12 : 10 : But we tried to fight it.");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }


    @Test
    public void testUnorderedIdsHidden() {
        // now we mess up ids
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();

        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode();
        expected.root.data = "goodbye world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "scarlet postal";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "What is going on?";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Rayleigh scattering";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Wherever I go";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "I will be here!!!";
        node2.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "All that we can imagine";
        node2.children.add(node6);
        MyGeneralTreeNode<String> node7 = new MyGeneralTreeNode();
        node7.data = "We didn't start the fire---";
        node5.children.add(node7);
        MyGeneralTreeNode<String> node8 = new MyGeneralTreeNode();
        node8.data = "It was always burning";
        node7.children.add(node8);
        MyGeneralTreeNode<String> node9 = new MyGeneralTreeNode();
        node9.data = "Since the world's been turning.";
        node7.children.add(node9);
        MyGeneralTreeNode<String> node10 = new MyGeneralTreeNode();
        node10.data = "We didn't start the fire";
        node3.children.add(node10);
        MyGeneralTreeNode<String> node11 = new MyGeneralTreeNode();
        node11.data = "No we didn't light it";
        node10.children.add(node11);
        MyGeneralTreeNode<String> node12 = new MyGeneralTreeNode();
        node12.data = "But we tried to fight it.";
        node10.children.add(node12);


        list.add("0 : : goodbye world");
        list.add("1 : 0 : scarlet postal");
        list.add("-2 : 0 : What is going on?");
        list.add("3 : 1 : Rayleigh scattering");
        list.add("-5 : -2 : Wherever I go");
        list.add("8 : -2 : I will be here!!!");
        list.add("-13 : -2 : All that we can imagine");
        list.add("21 : 8 : We didn't start the fire---");
        list.add("-34 : 21 : It was always burning");
        list.add("55 : 21 : Since the world's been turning.");
        list.add("-89 : 3 : We didn't start the fire");
        list.add("143 : -89 : No we didn't light it");
        list.add("-232 : -89 : But we tried to fight it.");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }


    @Test
    public void testNonNumericIdsHidden() {
        // now we do non numeric ids
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();



        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode();
        expected.root.data = "goodbye world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "scarlet postal";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "What is going on?";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Rayleigh scattering";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Wherever I go";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "I will be here!!!";
        node2.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "All that we can imagine";
        node2.children.add(node6);
        MyGeneralTreeNode<String> node7 = new MyGeneralTreeNode();
        node7.data = "We didn't start the fire---";
        node5.children.add(node7);
        MyGeneralTreeNode<String> node8 = new MyGeneralTreeNode();
        node8.data = "It was always burning";
        node7.children.add(node8);
        MyGeneralTreeNode<String> node9 = new MyGeneralTreeNode();
        node9.data = "Since the world's been turning.";
        node7.children.add(node9);
        MyGeneralTreeNode<String> node10 = new MyGeneralTreeNode();
        node10.data = "We didn't start the fire";
        node3.children.add(node10);
        MyGeneralTreeNode<String> node11 = new MyGeneralTreeNode();
        node11.data = "No we didn't light it";
        node10.children.add(node11);
        MyGeneralTreeNode<String> node12 = new MyGeneralTreeNode();
        node12.data = "But we tried to fight it.";
        node10.children.add(node12);


        list.add("0 : : goodbye world");
        list.add("1 : 0 : scarlet postal");
        list.add("-2 : 0 : What is going on?");
        list.add("3 : 1 : Rayleigh scattering");
        list.add("man setitimer : -2 : Wherever I go");
        list.add("8 : -2 : I will be here!!!");
        list.add("-13 : -2 : All that we can imagine");
        list.add("exit : 8 : We didn't start the fire---");
        list.add("-34 : exit : It was always burning");
        list.add("55 : exit : Since the world's been turning.");
        list.add("python3 : 3 : We didn't start the fire");
        list.add("143 : python3 : No we didn't light it");
        list.add("-232 : python3 : But we tried to fight it.");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }


    @Test
    public void testUnorderedIds2Hidden() {
        // now we mess up order!
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();



        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode();
        expected.root.data = "goodbye world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "scarlet postal";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "What is going on?";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Rayleigh scattering";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Wherever I go";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "I will be here!!!";
        node2.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "All that we can imagine";
        node2.children.add(node6);
        MyGeneralTreeNode<String> node7 = new MyGeneralTreeNode();
        node7.data = "We didn't start the fire---";
        node5.children.add(node7);
        MyGeneralTreeNode<String> node8 = new MyGeneralTreeNode();
        node8.data = "It was always burning";
        node7.children.add(node8);
        MyGeneralTreeNode<String> node9 = new MyGeneralTreeNode();
        node9.data = "Since the world's been turning.";
        node7.children.add(node9);
        MyGeneralTreeNode<String> node10 = new MyGeneralTreeNode();
        node10.data = "We didn't start the fire";
        node3.children.add(node10);
        MyGeneralTreeNode<String> node11 = new MyGeneralTreeNode();
        node11.data = "No we didn't light it";
        node10.children.add(node11);
        MyGeneralTreeNode<String> node12 = new MyGeneralTreeNode();
        node12.data = "But we tried to fight it.";
        node10.children.add(node12);


        list.add("man setitimer : -2 : Wherever I go");
        list.add("8 : -2 : I will be here!!!");
        list.add("-13 : -2 : All that we can imagine");
        list.add("55 : exit : Since the world's been turning.");
        list.add("python3 : 3 : We didn't start the fire");
        list.add("0 : : goodbye world");
        list.add("1 : 0 : scarlet postal");
        list.add("exit : 8 : We didn't start the fire---");
        list.add("-34 : exit : It was always burning");
        list.add("-2 : 0 : What is going on?");
        list.add("3 : 1 : Rayleigh scattering");
        list.add("143 : python3 : No we didn't light it");
        list.add("-232 : python3 : But we tried to fight it.");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }


    @Test
    public void testRequiredTrimHidden() {
        // now we add space
        TreeLoader tl = new TreeLoader();
        List<String> list = new ArrayList<>();



        MyGeneralTree<String> expected = new MyGeneralTree();
        expected.root = new MyGeneralTreeNode();
        expected.root.data = "goodbye world";
        MyGeneralTreeNode<String> node1 = new MyGeneralTreeNode();
        node1.data = "scarlet postal";
        expected.root.children.add(node1);
        MyGeneralTreeNode<String> node2 = new MyGeneralTreeNode();
        node2.data = "What is going on?";
        expected.root.children.add(node2);
        MyGeneralTreeNode<String> node3 = new MyGeneralTreeNode();
        node3.data = "Rayleigh scattering";
        node1.children.add(node3);
        MyGeneralTreeNode<String> node4 = new MyGeneralTreeNode();
        node4.data = "Wherever I go";
        node2.children.add(node4);
        MyGeneralTreeNode<String> node5 = new MyGeneralTreeNode();
        node5.data = "I will be here!!!";
        node2.children.add(node5);
        MyGeneralTreeNode<String> node6 = new MyGeneralTreeNode();
        node6.data = "All that we can imagine";
        node2.children.add(node6);
        MyGeneralTreeNode<String> node7 = new MyGeneralTreeNode();
        node7.data = "We didn't start the fire---";
        node5.children.add(node7);
        MyGeneralTreeNode<String> node8 = new MyGeneralTreeNode();
        node8.data = "It was always burning";
        node7.children.add(node8);
        MyGeneralTreeNode<String> node9 = new MyGeneralTreeNode();
        node9.data = "Since the world's been turning.";
        node7.children.add(node9);
        MyGeneralTreeNode<String> node10 = new MyGeneralTreeNode();
        node10.data = "We didn't start the fire";
        node3.children.add(node10);
        MyGeneralTreeNode<String> node11 = new MyGeneralTreeNode();
        node11.data = "No we didn't light it";
        node10.children.add(node11);
        MyGeneralTreeNode<String> node12 = new MyGeneralTreeNode();
        node12.data = "But we tried to fight it.";
        node10.children.add(node12);


        list.add("   man setitimer :   -2 : Wherever I go    ");
        list.add("  8 :  -2 :  I will be here!!!    ");
        list.add(" -13 :  -2   : All that we can imagine  ");
        list.add("55 :  exit  : Since the world's been turning. ");
        list.add("  python3 : 3 : We didn't start the fire    ");
        list.add("     0   :     : goodbye world  ");
        list.add(" 1  : 0 : scarlet postal ");
        list.add("exit :   8 : We didn't start the fire---   ");
        list.add("-34    : exit : It was always burning ");
        list.add(" -2 : 0 :    What is going on? ");
        list.add("  3  : 1 :   Rayleigh scattering   ");
        list.add(" 143  : python3    : No we didn't light it  ");
        list.add("    -232 : python3  :   But we tried to fight it.  ");
        MyGeneralTree<String> result = tl.createGeneralTree(list);
        boolean areEqual = TreeValidator.areEqual(expected, result);
        assertTrue(areEqual);
    }

}
