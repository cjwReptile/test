package design.test1.simplefatory.product;

/**
 * @Auther: cjw
 * @Date: 2019/3/19 13:48
 * @Description:
 */
public class TopN {


    public static void main(String[] args){
        TopN topN = new TopN();
        int[] arr = new int[]{1,3,5,4,7,2,0,9};
        topN.makeHeap(arr,4);
        for(int i = 4;i<arr.length;i++){
            if(arr[0] <= arr[i]){
                topN.swap(0,i,arr);
                topN.adjust(arr,0,4);
            }else {
                continue;
            }
        }

        System.out.println("sss");
    }

    public void makeHeap(int[] arr,int n){
        for(int i = n/2-1;i > 0 ; i--){
            adjust(arr,i,n);
        }
    }

    public void adjust(int[] arr,int i,int n){
        int j = i*2+1;
        while(j < n){
            if(j + 1 < n){
                if(arr[j] > arr[j+1]){
                    j++;
                }
            }
            if(arr[i] > arr[j]){
                swap(i,j,arr);
            }else {
                break;
            }
            i= j;
            j= 2*i+1;
        }
    }
    public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
