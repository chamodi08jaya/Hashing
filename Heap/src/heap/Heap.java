/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;
/**
 *
 * @author Chamodi
 */
public class Heap {
    void heapify(int arr[], int n, int i) 
	{ 
		int largest = i;  
		int l = 2*i + 1; 
		int r = 2*i + 2; 
		if (l < n && arr[l] > arr[largest]) 
			largest = l;
		if (r < n && arr[r] > arr[largest]) 
			largest = r; 
		if (largest != i) 
		{ 
			int swap = arr[i]; 
			arr[i] = arr[largest]; 
			arr[largest] = swap; 
			heapify(arr, n, largest); 
		} 
        }
    
    public static void main(String[] args) {
        int arr[] = {5,2,8,1,3,7}; 
		int n = arr.length; 
            
                 Heap ob = new Heap(); 
		for (int i = n / 2 - 1; i >= 0; i--) 
			ob.heapify(arr, n, i); 

		for (int i=n-1; i>=0; i--) 
		{ 
			int temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp; 
			ob.heapify(arr, i, 0); 
		} 

		System.out.println("Sorted array is");
		for (int i=0; i<n; ++i) {
                    System.out.print(arr[i]+" "); 
                } 
       
    }
    
}


	

	
	 
 