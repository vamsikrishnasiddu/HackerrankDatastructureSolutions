import java.util.Scanner;

public class HourGlass {
    public static void main(String args[]){
        int arr[][] = new int[6][6];
        Scanner scan = new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
               arr[i][j] = scan.nextInt();
            }
        }
       // System.out.println(arr.length);

        printArray(arr);
        hourGlassSum(arr);
    }

    static void printArray(int[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    static int hourGlassSum(int arr[][]){
        int n = arr.length;
        int count=1;
        int max=Integer.MIN_VALUE;
        //iterating vertically
        for(int k=0;k<=n/2;k++){
            //iterating horizontally
            for(int m=0;m<=n/2;m++){
                int sum=0;
                System.out.println("Hourglass"+count);
                //iterating over the row elements of matrix
                for(int i=k;i<n/2+k;i++){
                    //iterating over the column elements of matrix
                    for(int j=m;j<n/2+m;j++){
                    //checking the condition of hour glass
                    /*
                      a b c 
                        d
                      e f g
                    */
                       if(i==k+1 && (j==m || j==m+2))
                       {
                           continue;
                       }
                       //adding the elements sum
                        sum+=arr[i][j];
                        System.out.println("the element is "+arr[i][j]);
                    }
                }
                //comparing the maximum hourglass sum
                if(sum>max)
                max=sum;
                count++;

                System.out.println(sum);
            }
        }
        System.out.println(max);
        return max;
    }
}