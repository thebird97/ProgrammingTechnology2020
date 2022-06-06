/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vizszintes.kereses;

/**
 *
 * @author Madár Bálint
 */
public class VizszintesKereses {

    /**
     *
     * @param args
     */
   public static void main(String[] args) {
     
        int size=5;
        int[][] matrix = {{1, 1, 1, 1, 1},
        {30, 1, 1, 1, 1},
        {44, 45, 46, 47, 48},
        {74, 75, 76, 77, 78},
        {1, 1, 63, 1, 1}
        };
        
        System.out.println("4 vízsintes");
      int counter=0;
        for(int i=0;i<size;i++){
            counter = 0;
            for(int j=0;j<size;j++){
               if(matrix[i][j]==1){
                counter++;
               }else {
                  counter = 0;
               }
               if(counter ==4){
                   System.out.println("4 db 1 van egymás után + sor: "+  i);
               }
            }
        }
        
        
                int[][] matrix2 = {{20, 19, 18, 17, 16},
        {30, 31, 32, 33, 34},
        {44, 45, 46, 47, 48},
        {74, 75, 76, 77, 78},
        {61, 62, 63, 64, 65}                        
                        
        };
                 for(int i=0;i<size;i++){
             System.out.println("");
            for(int j=0;j<size;j++){
              System.out.print(matrix2[j][i] + " ");
            }
                 }
    }

}
