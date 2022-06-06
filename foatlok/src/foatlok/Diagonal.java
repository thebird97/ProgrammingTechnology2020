package foatlok;

public class Diagonal {

    public static void main(String []args){
        /*
                   int[][] matrix = {{20, 19, 18, 17, 16},
                 {30, 31, 32, 33, 34},
                 {44, 45, 46, 47, 48},
                 {74, 55, 76, 77, 78},
                 {61, 62, 63, 64, 65}
       }  ;
        */
           int[][] matrix = {{20, 19, 18, 17, 16},
                 {30, 31, 32, 33, 34},
                 {44, 45, 46, 47, 666},
                 {74, 55, 76, 77, 666},
                 {61, 62, 63, 666, 666}
       }  ;

    int width = 5;
    int height = 5;    
    int startRow = height - 1;
    int startColumn = width - 1;
    int column = 0;
int counter = 0;
    do {

        int row = startRow;
        column = startColumn;
      
        do {
            if (matrix[row][column]==666){
                counter++;
            }else{
                counter = 0;
            }
            System.out.print(matrix[row][column] + " ");

            ++row;
            --column;

        } while ((row < height) && (column > -1));
        System.out.print( counter);
        System.out.println("");
     counter = 0;
        if (startRow > 0) {

            --startRow;
        } else {

            --startColumn;
        }
    } while (startColumn > -1);



 }
}
