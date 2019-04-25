package design.test1.simplefatory;

/**
 * @Auther: cjw
 * @Date: 2019/3/19 10:57
 * @Description:
 */
public class QuickSort {

    public static void main(String[] args){
        int[] arr = new int[]{1,3,5,4,7};
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(arr,0,arr.length-1);
        for(int i = 0;i< arr.length ;i++){
            System.out.println(arr[i]);
        }
    }



    public void quicksort(int[] arrs,int i,int k){
        if(i >= k){
            return;
        }
        int key = arrs[i];
        int temi = i;
        int temj= k;
        while(temi != temj){
            while( temj >  temi){
                if(arrs[temj] >= key){
                    temj --;
                    continue;
                }
                break;
            }
            while(temi <  temj){
                if(arrs[temi] <= key){
                   temi ++;
                   continue;
                }
                break;
            }
            if(temi < temj){
                int temp = arrs[temi];
                arrs[temi] = arrs[temj];
                arrs[temj] = temp;
            }
        }
        arrs[i] = arrs[temi];
        arrs[temi] = key;
        quicksort(arrs,i,temi-1);
        quicksort(arrs,temi+1,k);
    }
}
