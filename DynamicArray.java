import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class DynamicArray {
    int arr[];
    int index = 0;
    DynamicArray(){
        arr = new int[1];
        index = 1;
    }
    void addElement(int el){
           if(index == 1){
               arr[0] = el;
               index++;

           }
           else{
            int brr[] = new int[arr.length+1];
            for(int i=0;i<arr.length;i++){
                brr[i] = arr[i];
                //System.out.println(arr[i]);
            }
        
            brr[arr.length] = el;
    
            arr = brr;
        }
        
    }
    int getElement(int index){
        return arr[index];
    }

    int getSize(){
        return arr.length;
    }

    void printArray(){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

class Solution{
    static int lastAnswer = 0;
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
         int n = scan.nextInt();
         int q = scan.nextInt();
         
         List<List<Integer>> queries = new ArrayList<List<Integer>>();
        

        for(int i=0;i<q;i++)
        {
            List<Integer> al = new ArrayList<Integer>();
            for(int j=0;j<3;j++){
               
                al.add(scan.nextInt());
            }
            queries.add(al);
        }

       // System.out.println(queries);

        DynamicArray[] drr = new DynamicArray[n];
        for(int i=0;i<drr.length;i++){
            drr[i] = new DynamicArray();
           // System.out.println(drr[i]);
        }
       /*  query(1,0,5,2,drr);
        query(1,1,7,2,drr);
        query(1,0,3,2,drr);
        query(2,1,0,2,drr);
        query(2,1,1,2,drr); */

        for(int i=0;i<q;i++){
            queries.get(i).get(0);
            query(queries.get(i).get(0),queries.get(i).get(1),queries.get(i).get(2),n,drr);
        }




    }
    static void query(int a, int x, int y,int n,DynamicArray[] drr){
        if(a ==1){
            int i = (x^lastAnswer)%n;
            drr[i].addElement(y);
        }
        else{
            int i = (x^lastAnswer)%n;
            int innerIndex = y%drr[i].getSize();
           lastAnswer= drr[i].getElement(innerIndex);
           System.out.println(lastAnswer);
        }

    }
}
