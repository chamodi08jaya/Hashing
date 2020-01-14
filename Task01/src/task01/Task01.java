/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task01;

/**
 *
 * @author Chamodi
 */
public class Task01 {
    
    int partion(int array[],int minimum,int maximum){
        int pivot=array[maximum];
        int i=(minimum-1);
        
        for(int j=minimum;j<maximum;j++){
            if(array[j]<pivot){
                i++;
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;    
            }
        }
        
        int temp=array[i+1];
        array[i+1]=array[maximum];
        array[maximum]=temp;
        return i+1;
         
    }
    
    void sort(int array[],int minimum,int maximum){
        if(minimum<maximum){
            int next=partion(array,minimum,maximum);
            sort(array,minimum,next-1);
            sort(array,next+1,maximum);
        
        }
    }
    
    static void get(int array[]){
        int n=array.length;
        for(int i=0;i<n;i++){
            System.out.print(array[i]+" ");
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[]={2,34,27,59,16,20,45,48,26};
        int m=array.length;
         System.out.println("Array Before Sorting-");
        for (int element: array) {
            System.out.print(" "+ element);
            
        }
        System.out.println("\n");
        
        Task01 t1=new Task01();
        t1.sort(array,0,m-1);
        System.out.print("Array After Sorting :\n"); 
        get(array); 
        

        // TODO code application logic here
    }
    
}
