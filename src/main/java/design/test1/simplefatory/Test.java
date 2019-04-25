package design.test1.simplefatory;

import design.test1.simplefatory.factory.FactoryT;
import design.test1.simplefatory.product.Baomu;
import design.test1.simplefatory.product.Product;
import design.test1.simplefatory.product.Yuesao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: cjw
 * @Date: 2018/9/29 17:09
 * @Description:
 */
public class Test {




    public static void main(String[] args){
        int j=6;
        int[] middle = new int[]{2,4,6,1,3,5,7};
        //TreeNode node = buildTree(pre,middle,0,pre.length-1,0,middle.length-1);
        Test test = new Test();
        test.random7torandom10(new int[]{1,2,3,4,5,6,7},new int[]{0,7,14,21,28,35,42});
        //test.msort(middle,0,6);
        //test.Power(2,-3);
        test.reOrderArrayFast(middle);
        System.out.println(test.Power(2,-3));
    }

    //归并排序
    public int[] msort(int[] origin,int start,int end){
        int mid = (start+end)/2;

        if(start < end){
            msort(origin,start,mid);
            msort(origin,mid+1,end);
            merge(origin,start,end,mid);
        }
        return origin;
    }

    public void merge(int[] origin,int start,int end,int mid){
        int[] temp = new int[end-start+1];
        int start_index = start;
        int mid_index = mid+1;
        int temp_index = 0;
        while(start_index <= mid && mid_index <= end){
            if(origin[start_index] <= origin[mid_index]){
                temp[temp_index++]=origin[start_index++];
            }else {
                temp[temp_index++]=origin[mid_index++];
            }

        }
        while(start_index <=mid){
            temp[temp_index++]=origin[start_index++];
        }
        while(mid_index <=end){
            temp[temp_index++]=origin[mid_index++];
        }
        for(int j = 0;j<temp.length;j++){
            origin[start++]=temp[j];
        }
    }




    //替换字符串算法
    public static String replaceSpace(StringBuffer str) {
        if(str == null){
            return null;
        }
        int extral = 0;
        for(int i = 0; i< str.length();i++){
            if(str.charAt(i) == ' '){
                extral+=2;
            }
        }
        int  i = str.length()-1;
        str.setLength(str.length()+extral);
        int  j = str.length()-1;
        for(;i>=0;i--){
            if(str.charAt(i) == ' '){
                str.setCharAt(j--,'0');
                str.setCharAt(j--,'2');
                str.setCharAt(j--,'%');
                extral-=2;
            }else {
                if(extral == 0){
                    return str.toString();
                }
                str.setCharAt(j--,str.charAt(i));
            }
        }
        return str.toString();
    }

    public ArrayList<Integer> printListFromTailToHead( ) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        //list.add();
        return list;
    }

    //重建二叉树
    public static TreeNode buildTree(int[] pre,int[] middle,int preStart,int preEnd,int middleStart,int middleEnd){
          if(preStart > preEnd || middleStart > middleEnd){
              return null;
          }
          int root = 0;
          //获取根节点的位置
          for(int i = middleStart;i<=middleEnd;i++){
              if(middle[i] == pre[preStart]){
                  root = i;
                  break;
              }
          }
          TreeNode node = new TreeNode(middle[root]);
          //递归的构建左子树    关键点在于搞清楚子树从哪里开始，从哪里结束
          node.left = buildTree(pre,middle,preStart+1,preStart+root-middleStart,middleStart,root-1);
          //递归的构建右子树
          node.right = buildTree(pre,middle,preStart+root+1-middleStart,preEnd,root+1,middleEnd);
          return node;
    }


    //两个栈实现队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
         stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        if(stack1.isEmpty()){
            return 0;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static int findMiNumInTransArray(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }

        int mid = array.length/2;
        int start = 0;
        int end = array.length-1;
        while(start+1 != end){
            if(array[mid] <= array[end]){
                end = mid;
            }
            if(array[mid] > array[end]){
                start = mid;
            }
            mid = (start+end)/2;
        }
        return array[end];
    }

    public static int fibonaqi(int n){
        if(n == 1 || n== 2){
            return 1;
        }
        return fibonaqi(n-1)+fibonaqi(n-2);
    }

    //循环实现的斐波那契数列
    public static int repeateFibonaqi(int n){
        if(n <= 1){
            return n;
        }
        int fn1 = 0;
        int fn2 = 1;
        for(int i = 2 ;i<=n;i++){
            //保存的是当前 i项 的值
            fn2 = fn1 + fn2;
            //保存的是 i-1项 的值
            fn1 = fn2 - fn1;
            System.out.println(fn2);
        }
        return fn2;
    }

    public static int[] mergeSort(int[] pre,int[] after){

        if(pre == null || after == null){
            return null;
        }
        int[] result = new int[pre.length+after.length];
        int pre_index=0;
        int after_index=0;
        int result_index=0;
        while (pre_index<pre.length && after_index<after.length){
            if(pre[pre_index] <= after[after_index]){
                result[result_index++]=pre[pre_index++];
            }else {
                result[result_index++]=after[after_index++];
            }
        }
        while(pre_index < pre.length){
            result[result_index++]=pre[pre_index++];
        }
        while(after_index < after.length){
            result[result_index++]=after[after_index++];
        }
        return result;
    }

    //反转数字
    public static int reservenum(int n){
        if(n == 0){
            return 0;
        }
        int j = 0;
        while(n > 0){
            int i = n%10;
            j = i+j*10;
            n = n/10;
        }
        return j;
    }

    public  void random7torandom10(int[] random7,int[] random10){
        for(int i = 0;i<random7.length;i++){
            for(int j = 0;j<random10.length;j++){
                System.out.println(random7[i]+random10[j]);
            }
        }
    }


    public void topN(int[] arr,int n){

    }

    public void buildHeap(int[] arr,int n){
        int j = n/2-1;

    }

    public void adjust(int[] arr,int i,int n){
        int j = 2*i+1;
        while(i < n){
            if(j+1 < n){
                if(arr[j] > arr[j+1]){
                    j++;
                }
            }
            if(arr[i] > arr[j]){
                swap(arr,i,j);
            }
            i=j;
            j=i*2+1;
        }
    }


    public double Power(double base, int exponent) {
        if(base == 0 && exponent < 0){
            return 0;
        }
        if(base == 0){
            return 0;
        }
        if(exponent == 0){
            return 1;
        }
        double result = base;
        int flag = 0;
        if(exponent < 0){
            exponent = -exponent;
            flag = 1;
        }
        while(exponent > 0){
            if(exponent == 1){
                result=result*base;
                break;
            }else{
                result = result*result;
                exponent  = exponent/2;
            }
        }
        return flag == 1?1/result:result;
    }

    public void reOrderArray(int [] array) {
        if(array == null || array.length==0){
            return;
        }
        int current = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i]%2 != 0)
                continue;
            for(int j =i+1;j< array.length;j++){
                if(array[j]%2 != 0){
                    swap(array,j-1,j);
                }
            }
        }
    }
    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public void reOrderArrayFast(int [] array){

        for(int i = 0;i<array.length;i++){
            int k = -1;
            for(int j = 0;j<array.length-i;j++){
                if(array[j]%2 ==0){
                    k=j;
                }
                if(array[j]%2 !=0){
                    if(k>=0){
                        swap(array,k,j);
                        k=-1;
                        j--;
                    }
                }
            }
        }
    }

    public void bubbosort(int[] array){
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
    }

}
