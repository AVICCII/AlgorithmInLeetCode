package SGGAlogrithmDS.huffmanCode;

import com.sun.javafx.scene.NodeEventDispatcher;
import sun.applet.AppletResourceLoader;

import java.util.*;

/**
 * @author aviccii 2020/12/3
 * @Discrimination
 */
public class huffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes :" + nodes);

        //测试一把 创建的二叉树
        System.out.println("赫夫曼树");
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        preOrder(huffmanTreeRoot);
    }

    //前序遍历
    private static void preOrder(Node root){
        if (root!=null) root.preOrder();
        else System.out.println("赫夫曼树为空");
    }

    /**
     * @param bytes 接收字节数组
     * @return 返回的就是List形式[Node]...
     */
    private static List<Node> getNodes(byte[] bytes) {
        //1.创建1个arrayList
        ArrayList<Node> nodes = new ArrayList<>();
        //2.遍历bytes,统计存储每个byte出现的次数
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte aByte : bytes) {
            Integer count = counts.get(aByte);
            //map无该字符数据
            if (count == null) counts.put(aByte, 1);
            else counts.put(aByte, count + 1);
        }
        //把每一个键值对转成一个Node 对象，并加入到nodes集合
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //可以通过List创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            //排序 从小到大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node leftNode = nodes.get(0);
            //取出第二颗最小的二叉树
            Node rightNode = nodes.get(1);
            //创建一颗新的二叉树它的根节点没有data,只有权值
            Node parent = new Node(null,rightNode.weight+rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //将已经处理的两个二叉树移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树加入到nodes
            nodes.add(parent);
        }
        //返回的节点就是Nodes最后的节点，也就是Huffman树的最终节点
        return nodes.get(0);
    }

}

//创建Node,带数据和权值
class Node implements Comparable<Node> {
    Byte data; //存放数据本身(字符) 比如'a' => 97
    int weight; //代表权值 表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大
        return this.weight - o.weight; }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();
    }
}
