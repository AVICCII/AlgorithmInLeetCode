# 构造最大二叉树

<img src="https://mmbiz.qpic.cn/sz_mmbiz_png/gibkIz0MVqdF8ZItXTVByS26EcqBSS9W6eOHriaUYiccxeORhkysMaVLwgl42iaMXz9942TK5lVInfjKiaOhAzHmZCg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">
函数签名如下：
```
TreeNode constructMaximumBinaryTree(int[] nums);
```
按照我们刚才说的，先明确根节点做什么？对于构造二叉树的问题，根节点要做的就是把想办法把自己构造出来。

我们肯定要遍历数组把找到最大值maxVal，把根节点root做出来，然后对maxVal左边的数组和右边的数组进行递归调用，作为root的左右子树。

按照题目给出的例子，输入的数组为[3,2,1,6,0,5]，对于整棵树的根节点来说，其实在做这件事：
```
TreeNode constructMaximumBinaryTree([3,2,1,6,0,5]) {
    // 找到数组中的最大值
    TreeNode root = new TreeNode(6);
    // 递归调用构造左右子树
    root.left = constructMaximumBinaryTree([3,2,1]);
    root.right = constructMaximumBinaryTree([0,5]);
    return root;
}
```
再详细一点，就是如下伪码：
```
TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums is empty) return null;
    // 找到数组中的最大值
    int maxVal = Integer.MIN_VALUE;
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > maxVal) {
            maxVal = nums[i];
            index = i;
        }
    }

    TreeNode root = new TreeNode(maxVal);
    // 递归调用构造左右子树
    root.left = constructMaximumBinaryTree(nums[0..index-1]);
    root.right = constructMaximumBinaryTree(nums[index+1..nums.length-1]);
    return root;
}
```

看懂了吗？对于每个根节点，只需要找到当前nums中的最大值和对应的索引，然后递归调用左右数组构造左右子树即可。

明确了思路，我们可以重新写一个辅助函数build，来控制nums的索引：
```
/* 主函数 */
TreeNode constructMaximumBinaryTree(int[] nums) {
    return build(nums, 0, nums.length - 1);
}

/* 将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
TreeNode build(int[] nums, int lo, int hi) {
    // base case
    if (lo > hi) {
        return null;
    }

    // 找到数组中的最大值和对应的索引
    int index = -1, maxVal = Integer.MIN_VALUE;
    for (int i = lo; i <= hi; i++) {
        if (maxVal < nums[i]) {
            index = i;
            maxVal = nums[i];
        }
    }

    TreeNode root = new TreeNode(maxVal);
    // 递归调用构造左右子树
    root.left = build(nums, lo, index - 1);
    root.right = build(nums, index + 1, hi);

    return root;
}
```

# 通过前序和中序遍历结果构造二叉树
<img src="https://mmbiz.qpic.cn/sz_mmbiz_png/gibkIz0MVqdF8ZItXTVByS26EcqBSS9W6HLh9gbjia7hJ8O78PJKJWzicpA5mIeKwZtLUIq3msx2lFibOREdlpR7icg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">
函数签名如下：
```
TreeNode buildTree(int[] preorder, int[] inorder);
```
废话不多说，直接来想思路，首先思考，根节点应该做什么。

**类似上一题，我们肯定要想办法确定根节点的值，把根节点做出来，然后递归构造左右子树即可。**

我们先来回顾一下，前序遍历和中序遍历的结果有什么特点？
```
void traverse(TreeNode root) {
    // 前序遍历
    preorder.add(root.val);
    traverse(root.left);
    traverse(root.right);
}

void traverse(TreeNode root) {
    traverse(root.left);
    // 中序遍历
    inorder.add(root.val);
    traverse(root.right);
}
```

preorder和inorder数组中的元素分布有如下特点：
<img src="https://mmbiz.qpic.cn/sz_mmbiz_jpg/gibkIz0MVqdF8ZItXTVByS26EcqBSS9W6zvlia07hHvYB5JTKLTHCAmDW9I8dX8c8LmSo1ibejUHGibgH6zhMXBCmw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">

找到根节点是很简单的，前序遍历的第一个值preorder[0]就是根节点的值，关键在于如何通过根节点的值，将preorder和postorder数组划分成两半，构造根节点的左右子树？

换句话说，对于以下代码中的?部分应该填入什么：
```
/* 主函数 */
TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, 0, preorder.length - 1,
                 inorder, 0, inorder.length - 1);
}

/* 
   若前序遍历数组为 preorder[preStart..preEnd]，
   后续遍历数组为 postorder[postStart..postEnd]，
   构造二叉树，返回该二叉树的根节点 
*/
TreeNode build(int[] preorder, int preStart, int preEnd, 
               int[] inorder, int inStart, int inEnd) {
    // root 节点对应的值就是前序遍历数组的第一个元素
    int rootVal = preorder[preStart];
    // rootVal 在中序遍历数组中的索引
    int index = 0;
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == rootVal) {
            index = i;
            break;
        }
    }

    TreeNode root = new TreeNode(rootVal);
    // 递归构造左右子树
    root.left = build(preorder, ?, ?,
                      inorder, ?, ?);

    root.right = build(preorder, ?, ?,
                       inorder, ?, ?);
    return root;
}
```
对于代码中的rootVal和index变量，就是下图这种情况：
<img src="https://mmbiz.qpic.cn/sz_mmbiz_jpg/gibkIz0MVqdF8ZItXTVByS26EcqBSS9W6cuUtHIdXvXjbicaaZnpBWzEO1ZLfCGn9ntniaEicl5Et2wiarGaSq2GCZw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">
现在我们来看图做填空题，下面这几个问号处应该填什么：

root.left = build(preorder, ?, ?,
                  inorder, ?, ?);

root.right = build(preorder, ?, ?,
                   inorder, ?, ?);
对于左右子树对应的inorder数组的起始索引和终止索引比较容易确定：


<img src="https://mmbiz.qpic.cn/sz_mmbiz_jpg/gibkIz0MVqdF8ZItXTVByS26EcqBSS9W6BFJp9KicjbvfTdvhU3vaDFEqaUiaNF1q3HzkyFjnpypG8XrGzJXdpeLg/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">
root.left = build(preorder, ?, ?,
                  inorder, inStart, index - 1);

root.right = build(preorder, ?, ?,
                   inorder, index + 1, inEnd);
对于preorder数组呢？如何确定左右数组对应的起始索引和终止索引？

这个可以通过左子树的节点数推导出来，假设左子树的节点数为leftSize，那么preorder数组上的索引情况是这样的：

<img src="https://mmbiz.qpic.cn/sz_mmbiz_jpg/gibkIz0MVqdF8ZItXTVByS26EcqBSS9W6Awr35eI0tibAJ2qW6pDUpgWTv5icgDhRhniaIJg3dpYib7Ph5kqDneL08A/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">
看着这个图就可以把preorder对应的索引写进去了：
```
int leftSize = index - inStart;

root.left = build(preorder, preStart + 1, preStart + leftSize,
                  inorder, inStart, index - 1);

root.right = build(preorder, preStart + leftSize + 1, preEnd,
                   inorder, index + 1, inEnd);
```
至此，整个算法思路就完成了，我们再补一补 base case 即可写出解法代码：

```
TreeNode build(int[] preorder, int preStart, int preEnd, 
               int[] inorder, int inStart, int inEnd) {

    if (preStart > preEnd) {
        return null;
    }

    // root 节点对应的值就是前序遍历数组的第一个元素
    int rootVal = preorder[preStart];
    // rootVal 在中序遍历数组中的索引
    int index = 0;
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == rootVal) {
            index = i;
            break;
        }
    }

    int leftSize = index - inStart;

    // 先构造出当前根节点
    TreeNode root = new TreeNode(rootVal);
    // 递归构造左右子树
    root.left = build(preorder, preStart + 1, preStart + leftSize,
                      inorder, inStart, index - 1);

    root.right = build(preorder, preStart + leftSize + 1, preEnd,
                       inorder, index + 1, inEnd);
    return root;
}
```

# 通过后序和中序遍历结果构造二叉树

利用后序和中序遍历的结果数组来还原二叉树，这是力扣第 106 题：
<img src="https://mmbiz.qpic.cn/sz_mmbiz_png/gibkIz0MVqdF8ZItXTVByS26EcqBSS9W6MRJ8lXFDiaiaKT4GVOH9naRTbJCJOkJbbeyTguZpfpeOI5p6TcT0aRYQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">
函数签名如下：
TreeNode buildTree(int[] inorder, int[] postorder);