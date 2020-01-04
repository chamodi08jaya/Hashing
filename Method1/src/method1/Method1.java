/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method1;

/**
 *
 * @author Chamodi
 */
public class Method1 {
       
    boolean match(int setA[],int setB[]){
        for(int i=0;i<setA.length;i++){
            for(int j=0;j<setB.length;j++){
                if(setA[i]==setB[j]){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Method1 m=new Method1();
       int setA[] = {12,34,11,9,3};
       int setB[] = {2,1,3,5};
       
       boolean result=m.match(setA,setB);
       if(!result){
           System.out.println("Common Element");
       }else{
           System.out.println("Haven't common Element");
       }
       
        // TODO code application logic here
    }

   
    
}
