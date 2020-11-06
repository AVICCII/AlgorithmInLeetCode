## 一、二叉树的重要性
举个例子，比如说我们的经典算法「快速排序」和「归并排序」，对于这两个算法，你有什么理解？如果你告诉我，快速排序就是个二叉树的前序遍历，归并排序就是个二叉树的后续遍历，那么我就知道你是个算法高手了。

为什么快速排序和归并排序能和二叉树扯上关系？我们来简单分析一下他们的算法思想和代码框架：

快速排序的逻辑是，若要对nums[lo..hi]进行排序，我们先找一个分界点p，通过交换元素使得nums[lo..p-1]都小于等于nums[p]，且nums[p+1..hi]都大于nums[p]，然后递归地去nums[lo..p-1]和nums[p+1..hi]中寻找新的分界点，最后整个数组就被排序了。

快速排序的代码框架如下：
```
void sort(int[] nums, int lo, int hi) {
    /****** 前序遍历位置 ******/
    // 通过交换元素构建分界点 p
    int p = partition(nums, lo, hi);
    /************************/

    sort(nums, lo, p - 1);
    sort(nums, p + 1, hi);
```
先构造分界点，然后去左右子数组构造分界点，你看这不就是一个二叉树的前序遍历吗？

再说说归并排序的逻辑，若要对nums[lo..hi]进行排序，我们先对nums[lo..mid]排序，再对nums[mid+1..hi]排序，最后把这两个有序的子数组合并，整个数组就排好序了。

归并排序的代码框架如下：
```
void sort(int[] nums, int lo, int hi) {
    int mid = (lo + hi) / 2;
    sort(nums, lo, mid);
    sort(nums, mid + 1, hi);

    /****** 后序遍历位置 ******/
    // 合并两个排好序的子数组
    merge(nums, lo, mid, hi);
    /************************/
}
```
先对左右子数组排序，然后合并（类似合并有序链表的逻辑），你看这是不是二叉树的后序遍历框架？另外，这不就是传说中的分治算法嘛，不过如此呀。

如果你一眼就识破这些排序算法的底细，还需要背这些算法代码吗？这不是手到擒来，从框架慢慢扩展就能写出算法了。

说了这么多，旨在说明，二叉树的算法思想的运用广泛，甚至可以说，只要涉及递归，都可以抽象成二叉树的问题。

## 二、写递归算法的秘诀
**写递归算法的关键是要明确函数的「定义」是什么，然后相信这个定义，利用这个定义推导最终结果，绝不要试图跳入递归。**


怎么理解呢，我们用一个具体的例子来说，比如说让你计算一棵二叉树共有几个节点：
```
// 定义：count(root) 返回以 root 为根的树有多少节点
int count(TreeNode root) {
    // base case
    if (root == null) return 0;
    // 自己加上子树的节点数就是整棵树的节点数
    return 1 + count(root.left) + count(root.right);
}
```
这个问题非常简单，大家应该都会写这段代码，root本身就是一个节点，加上左右子树的节点数就是以root为根的树的节点总数。

左右子树的节点数怎么算？其实就是计算根为root.left和root.right两棵树的节点数呗，按照定义，递归调用count函数即可算出来。

**写树相关的算法，简单说就是，先搞清楚当前root节点该做什么，然后根据函数定义递归调用子节点，递归调用会让孩子节点做相同的事情。**

我们接下来看几道算法题目实操一下。

## 三、算法实践
### 1.翻转二叉树
我们先从简单的题开始，看看力扣第 226 题「翻转二叉树」，输入一个二叉树根节点root，让你把整棵树镜像翻转，比如输入的二叉树如下：
```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```
算法原地翻转二叉树，使得以root为根的树变成：
```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

通过观察，我们发现**只要把二叉树上的每一个节点的左右子节点进行交换，最后的结果就是完全翻转之后的二叉树。**

可以直接写出解法代码：
```
// 将整棵树的节点翻转
TreeNode invertTree(TreeNode root) {
    // base case
    if (root == null) {
        return null;
    }

    /**** 前序遍历位置 ****/
    // root 节点需要交换它的左右子节点
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    // 让左右子节点继续翻转它们的子节点
    invertTree(root.left);
    invertTree(root.right);

    return root;
}
```

这道题目比较简单，关键思路在于我们发现翻转整棵树就是交换每个节点的左右子节点，于是我们把交换左右子节点的代码放在了前序遍历的位置。

值得一提的是，如果把交换左右子节点的代码放在后序遍历的位置也是可以的，但是放在中序遍历的位置是不行的，请你想一想为什么？这个应该不难想到，我会把答案置顶在公众号留言区。

首先讲这道题目是想告诉你，**二叉树题目的一个难点就是，如何把题目的要求细化成每个节点需要做的事情**。

这种洞察力需要多刷题训练，我们看下一道题。
### 2.填充二叉树节点的右侧指针
这是力扣第 116 题，看下题目：

给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下
```
struct Node{
    int val;
    Node *left;
    Node *right;
    Node *next;
}
```
填充它的每个next指针，让这个指针向其下一个右侧节点。如果找不到下一个右侧节点，则将next指针设置为null。
初始状态下，所有指针都被设置为null。
函数签名如下：
```
Node connect(Node root);
```
题目的意思就是把二叉树的每一层节点都用next指针连接起来：

<img src="https://mmbiz.qpic.cn/sz_mmbiz_png/gibkIz0MVqdFUAYaibsUwwKXicw0ibDuiafN6zDe25AFgsibSx6uDc4zFCRicAuRqI9kpV6QUBLaO1Hmrs0mAT3ka1lQQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1" />

而且题目说了，输入是一棵「完美二叉树」，形象地说整棵二叉树是一个正三角形，除了最右侧的节点next指针会指向null，其他节点的右侧一定有相邻的节点。

这道题怎么做呢？把每一层的节点穿起来，是不是只要把每个节点的左右子节点都穿起来就行了？

我们可以模仿上一道题，写出如下代码：
```
Node connect(Node root) {
    if (root == null || root.left == null) {
        return root;
    }

    root.left.next = root.right;

    connect(root.left);
    connect(root.right);

    return root;
}
```

这样其实有很大问题，节点 5 和节点 6 不属于同一个父节点，那么按照这段代码的逻辑，它俩就没办法被穿起来，这是不符合题意的。

回想刚才说的，**二叉树的问题难点在于，如何把题目的要求细化成每个节点需要做的事情**，但是如果只依赖一个节点的话，肯定是没办法连接「跨父节点」的两个相邻节点的。

那么，我们的做法就是增加函数参数，一个节点做不到，我们就给他安排两个节点，「将每一层二叉树节点连接起来」可以细化成「将每两个相邻节点都连接起来」：
```
// 主函数
Node connect(Node root) {
    if (root == null) return null;
    connectTwoNode(root.left, root.right);
    return root;
}

// 定义：输入两个节点，将它俩连接起来
void connectTwoNode(Node node1, Node node2) {
    if (node1 == null || node2 == null) {
        return;
    }
    /**** 前序遍历位置 ****/
    // 将传入的两个节点连接
    node1.next = node2;

    // 连接相同父节点的两个子节点
    connectTwoNode(node1.left, node1.right);
    connectTwoNode(node2.left, node2.right);
    // 连接跨越父节点的两个子节点
    connectTwoNode(node1.right, node2.left);
}
```
这样，connectTwoNode函数不断递归，可以无死角覆盖整棵二叉树，将所有相邻节点都连接起来，也就避免了我们之前出现的问题，这道题就解决了。

### 3.将二叉树展开为链表
这是力扣第 114 题，看下题目：
<img src="https://mmbiz.qpic.cn/sz_mmbiz_png/gibkIz0MVqdFUAYaibsUwwKXicw0ibDuiafN6tKibbFy90h6LcLq1YG5XJCCGcZfcv9cv0ua7HNFKElGJJQbQ7Wiaibxgg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1"  />
函数签名如下：
```
void flatten(TreeNode root);
```
我们尝试给出这个函数的定义：

给flatten函数输入一个节点root，那么以root为根的二叉树就会被拉平为一条链表。

我们再梳理一下，如何按题目要求把一棵树拉平成一条链表？很简单，以下流程：

1、将root的左子树和右子树拉平。

2、将root的右子树接到左子树下方，然后将整个左子树作为右子树。
<img src="https://mmbiz.qpic.cn/sz_mmbiz_jpg/gibkIz0MVqdFUAYaibsUwwKXicw0ibDuiafN6GKZ2DRNJmFyet7HeKxjCSxqmibwTIbicWn9DTUAPa8ZzLrxvDald9yicQ/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">
上面三步看起来最难的应该是第一步对吧，如何把root的左右子树拉平？其实很简单，按照flatten函数的定义，对root的左右子树递归调用flatten函数即可：
```
// 定义：将以 root 为根的树拉平为链表
void flatten(TreeNode root) {
    // base case
    if (root == null) return;
    flatten(root.left);
    flatten(root.right);

    /**** 后序遍历位置 ****/
    // 1、左右子树已经被拉平成一条链表
    TreeNode left = root.left;
    TreeNode right = root.right;

    // 2、将左子树作为右子树
    root.left = null;
    root.right = left;

    // 3、将原先的右子树接到当前右子树的末端
    TreeNode p = root;
    while (p.right != null) {
        p = p.right;
    }
    p.right = right;
}
```

你看，这就是递归的魅力，你说flatten函数是怎么把左右子树拉平的？不容易说清楚，但是只要知道flatten的定义如此，相信这个定义，让root做它该做的事情，然后flatten函数就会按照定义工作。

另外注意递归框架是后序遍历，因为我们要先拉平左右子树才能进行后续操作。