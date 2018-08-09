package searchSorting;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree=new BinaryTree();
		tree.Insert(32);
		tree.Insert(23);
		tree.Insert(33);
		tree.Insert(27);
		tree.Insert(40);
		tree.Insert(15);
		tree.Insert(35);
		tree.Insert(13);
		tree.Insert(47);
		tree.Insert(43);
		tree.Insert(5);
		tree.Insert(85);
		tree.InOrderTraversal();
		System.out.println(tree.FindNode(33));
		System.out.println(tree.FindNode(3));
		tree.Delete(15);
		tree.InOrderTraversal();
		tree.Delete(40);
		tree.InOrderTraversal();
		tree.Delete(32);
		tree.InOrderTraversal();
		tree.Delete(35);
		tree.InOrderTraversal();
		tree.Delete(33);
		tree.InOrderTraversal();
		tree.Delete(5);
		tree.InOrderTraversal();
		tree.Delete(27);
		tree.InOrderTraversal();
		tree.Delete(85);
		tree.InOrderTraversal();
		BinaryNode b=new BinaryNode(10);
		b.leftTree=new BinaryNode(5);
		b.rightTree=new BinaryNode(0);
		b.rightTree.rightTree=new BinaryNode(12);
		b.rightTree.rightTree.rightTree=new BinaryNode(10);
		b.leftTree.rightTree=new BinaryNode(16);
		b.leftTree.leftTree=new BinaryNode(6);
		int check= tree.maxDepth(b);
		System.out.println("depth : "+ check);
	}

}
class BinaryNode{
	int data;
	BinaryNode leftTree;
	BinaryNode rightTree;
	BinaryNode(int data){
		this.data=data;
	}
	public void Insert(int num){
		if(num==data)
			return;
		if(num<data){
			if(leftTree == null)
				leftTree= new BinaryNode(num);
			else
				leftTree.Insert(num);
		}
		
		if(num>data){
			if(rightTree == null)
				rightTree= new BinaryNode(num);
			else
				rightTree.Insert(num);
		}
		
	}
	public void InOrderTraversal(){
		if(leftTree!=null)
			leftTree.InOrderTraversal();
		System.out.println(data);
		if(rightTree!=null)
			rightTree.InOrderTraversal();
	}
	public int FindNode(int num){
		if(num==data)
			return data;
		if(num<data){
			if(leftTree!=null)
				leftTree.FindNode(num);
			else
				return -1;
		}
		if(num>data){
			if(rightTree!=null)
				rightTree.FindNode(num);
			else
				return -1;
		}
		return -1;
	}
}
class BinaryTree{
	BinaryNode root;
	public void Insert(int num){
		if(root==null)
			root=new BinaryNode(num);
		else
			root.Insert(num);
	}
	public void InOrderTraversal(){

		System.out.println("check now");
		if(root==null)
			System.out.println("No element");
		else
			root.InOrderTraversal();
		
	}
	public int FindNode(int num){
		if(root==null){
			System.out.println("No element");
			return -1;
			
		}
		else
			return root.FindNode(num);
	}
	public void Delete(int value){
		root=Delete(root, value);
	}
	private BinaryNode Delete(BinaryNode subTree,int value){
		if(subTree==null)
			return subTree;
		if(subTree.data>value)
			subTree.leftTree=Delete(subTree.leftTree,value);
		if(subTree.data<value)
			subTree.rightTree=Delete(subTree.rightTree,value);
		if(subTree.data==value)
			if(subTree.leftTree==null && subTree.rightTree==null)
				subTree=null;
			else{
				if(subTree.leftTree==null){
					subTree=subTree.rightTree;
				}
				else if(subTree.rightTree==null){
					subTree=subTree.leftTree;
				}
				else{
					BinaryNode check=subTree.rightTree;
					while(check.leftTree!=null){
						check=check.leftTree;
					}
					subTree.data=check.data;
					subTree.rightTree=Delete(subTree.rightTree,check.data);
				}
				

			}
		return subTree;
	}
	public int maxDepth1(BinaryNode root) {
        if(root == null){
            return 0;
        }
        
        return Math.max(maxDepth1(root.leftTree),maxDepth1(root.rightTree)) + 1;
    }
	public int maxDepth(BinaryNode root) {
        int count=0;
        int max=0;
        count = callDepth(root, count, max);
        return count+1;
    }
    public int callDepth(BinaryNode check, int count, int max){
        if(check.leftTree!=null && check.rightTree!=null){
             count++;
            count= Integer.max(callDepth(check.leftTree, count, max), callDepth(check.rightTree, count, max));
        }
        else if(check.leftTree==null && check.rightTree!=null){
             count++;
            count=  callDepth(check.rightTree, count, max);
        }
        else if(check.rightTree==null && check.leftTree!=null){
             count++;
            count=  callDepth(check.leftTree, count, max);
        }
        return count;
    }
    public List<List<Integer>> levelOrderBottom(BinaryNode root) {
        List<List<Integer>> again= new ArrayList<List<Integer>>();
        ArrayList<BinaryNode> temp = new ArrayList<BinaryNode>();
        List<Integer> lst1= new ArrayList<Integer>();
        lst1.add(root.data);
        again.add(0,lst1);
        temp.add(root);
        while(temp!=null && !temp.isEmpty()){
            int length=temp.size();
            List<Integer> lst= new ArrayList<Integer>();
            for(int i=0; i<length;i++){
                if(temp.get(0).leftTree !=null){
                    temp.add(temp.get(0).leftTree);
                    lst.add(temp.get(0).leftTree.data);
                    System.out.println(temp.get(0).leftTree.data);
                }
                if(temp.get(0).rightTree !=null){
                    temp.add(temp.get(0).rightTree);
                    lst.add(temp.get(0).rightTree.data);
                    System.out.println(temp.get(0).rightTree.data);
                }
                temp.remove(0);
                
            }
            if(temp!=null && !temp.isEmpty())
            	again.add(0,lst);
        }
        again.remove(0);
        return again;
    }
    
    
}

