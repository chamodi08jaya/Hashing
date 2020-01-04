/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method2;

/**
 *
 * @author Chamodi
 */
public class Method2 {
    
    boolean sorting(int setA[],int setB[]){
       int temp;
       for (int i = 0; i < setA.length; i++) {
            for (int j = i; j > 0; j--) {
                if (setA[j] < setA[j - 1]) {
                    temp = setA[j];
                    setA[j] = setA[j - 1];
                    setA[j - 1] = temp;
                }
            }
       }
       
//       for (int i = 0; i < setA.length; i++) {
//          System.out.println(setA[i]);
//       }
       
       for (int i = 0; i < setB.length; i++) {
            for (int j = i; j > 0; j--) {
                if (setB[j] < setB[j - 1]) {
                    temp = setB[j];
                    setB[j] = setB[j - 1];
                    setB[j - 1] = temp;
                }
            }
       }
       
//       for (int i = 0; i < setB.length; i++) {
//          System.out.println(setB[i]);
//       }
       
       
       int i=0,j=0;
       while(i<setA.length && j<setB.length){
           if(setA[i]<setB[j]){
               i++;
           }else if(setA[i]>setB[j]){
               j++;
           }else{
               return false;
           }
       
       }
       return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Method2 m=new Method2();
       int setA[] = {12,34,11,9,3};
       int setB[] = {2,1,3,5};
       
       boolean result=m.sorting(setA,setB);
       if(result){
           System.out.println("Comparison Yes");
       }else{
           System.out.println("No");
       }
        // TODO code application logic here
    }
    
}
