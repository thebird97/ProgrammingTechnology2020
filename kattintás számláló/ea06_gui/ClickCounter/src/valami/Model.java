package valami;



public class Model {

    private int size;

    public FieldValue[][] table;
    private FieldValue clickedPlayer;
    private FieldValue currentPlayer = FieldValue.WHITEHORSE;

          

 public Model(int size) {
        this.size = size;
        clickedPlayer = FieldValue.WHITEHORSE;
//  currentPlayer =
        table = new FieldValue[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                table[i][j] = FieldValue.EMPTY;
            }
        }

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (i == 0 && j == 0) {
                    table[i][j] = FieldValue.WHITEHORSE;
                }
                if (i == 0 && j == size - 1) {
                    table[i][j] = FieldValue.WHITEHORSE;
                }

                if (i == size - 1 && j == 0) {
                    table[i][j] = FieldValue.BLACKHORSE;
                }
                if (i == size - 1 && j == size - 1) {
                    table[i][j] = FieldValue.BLACKHORSE;
                }
            }
        }

    }

    public FieldValue getNumber(int row, int column) {
        return table[row][column];
    }

    public void setValue(int row, int column, FieldValue fvalue) {
        table[row][column] = fvalue;
    }

    public FieldValue step(int row, int column) {

        System.out.println("akt játékos: " + currentPlayer);
        System.out.println("clickedPlayer: " + clickedPlayer);

        clickedPlayer = table[row][column];
        if (clickedPlayer == FieldValue.EMPTY) {
            return clickedPlayer;
        }

        if (clickedPlayer == FieldValue.WHITEHORSE && currentPlayer == FieldValue.WHITEHORSE && clickedPlayer != FieldValue.GREEN && clickedPlayer != FieldValue.WHITE && clickedPlayer != FieldValue.BLACK) {
            //Optimalizálható: 
            //új osztály írásába de 

            //8 db lépésfajta van és ha mindkét koordináta 0> és <size állítsa
            //be greenre
            int elsox = row + 1;
            int elsoy = column + 2;
            if (elsox >= 0 && elsoy >= 0 && elsox < size && elsoy < size) {
                if (table[elsox][elsoy] == FieldValue.EMPTY) {
                    table[elsox][elsoy] = FieldValue.GREEN;
                }

            }

            int masx = row + 2;
            int masrowky = column + 1;
            if (masx >= 0 && masrowky >= 0 && masx < size && masrowky < size) {
                if (table[masx][masrowky] == FieldValue.EMPTY) {
                    table[masx][masrowky] = FieldValue.GREEN;
                }
            }

            int harx = row - 1;
            int hary = column + 2;
            if (harx >= 0 && hary >= 0 && harx < size && hary < size) {
                  if(table[harx][hary] ==  FieldValue.EMPTY ){
                table[harx][hary] = FieldValue.GREEN;
                  }
            }

            int negyx = row + 1;
            int negyy = column - 2;
            if (negyx >= 0 && negyy >= 0 && negyx < size && negyy < size) {
                  if(table[negyx][negyy] ==  FieldValue.EMPTY ){
                table[negyx][negyy] = FieldValue.GREEN;
                  }
            }

            int otx = row + 2;
            int oty = column - 1;
            if (otx >= 0 && oty >= 0 && otx < size && oty < size) {
                  if(table[otx][oty] ==  FieldValue.EMPTY ){
                table[otx][oty] = FieldValue.GREEN;
                  }
            }

            int hatx = row - 2;
            int haty = column + 1;
            if (hatx >= 0 && haty >= 0 && hatx < size && haty < size) {
                  if(table[hatx][haty] ==  FieldValue.EMPTY ){
                table[hatx][haty] = FieldValue.GREEN;
                  }
            }

            int hetx = row - 1;
            int hety = column - 2;

            if (hetx >= 0 && hety >= 0 && hetx < size && hety < size) {
                      if(table[hetx][hety] ==  FieldValue.EMPTY ){
                table[hetx][hety] = FieldValue.GREEN;
                      }
            }

            int nyolcx = row - 2;
            int nyolcy = column - 1;
            if (nyolcx >= 0 && nyolcy >= 0 && nyolcx < size && nyolcy < size) {
                      if(table[nyolcx][nyolcy] ==  FieldValue.EMPTY ){
                table[nyolcx][nyolcy] = FieldValue.GREEN;
                      }
            }

            ///fehérre állítás 
            table[row][column] = FieldValue.WHITE;

        }

        if (currentPlayer == FieldValue.BLACKHORSE && clickedPlayer == FieldValue.BLACKHORSE && clickedPlayer != FieldValue.GREEN && clickedPlayer != FieldValue.WHITE && clickedPlayer != FieldValue.BLACK) {
                      int elsox = row + 1;
            int elsoy = column + 2;
            if (elsox >= 0 && elsoy >= 0 && elsox < size && elsoy < size) {
                if (table[elsox][elsoy] == FieldValue.EMPTY) {
                    table[elsox][elsoy] = FieldValue.GREEN;
                }

            }

            int masx = row + 2;
            int masrowky = column + 1;
            if (masx >= 0 && masrowky >= 0 && masx < size && masrowky < size) {
                if (table[masx][masrowky] == FieldValue.EMPTY) {
                    table[masx][masrowky] = FieldValue.GREEN;
                }
            }

            int harx = row - 1;
            int hary = column + 2;
            if (harx >= 0 && hary >= 0 && harx < size && hary < size) {
                  if(table[harx][hary] ==  FieldValue.EMPTY ){
                table[harx][hary] = FieldValue.GREEN;
                  }
            }

            int negyx = row + 1;
            int negyy = column - 2;
            if (negyx >= 0 && negyy >= 0 && negyx < size && negyy < size) {
                  if(table[negyx][negyy] ==  FieldValue.EMPTY ){
                table[negyx][negyy] = FieldValue.GREEN;
                  }
            }

            int otx = row + 2;
            int oty = column - 1;
            if (otx >= 0 && oty >= 0 && otx < size && oty < size) {
                  if(table[otx][oty] ==  FieldValue.EMPTY ){
                table[otx][oty] = FieldValue.GREEN;
                  }
            }

            int hatx = row - 2;
            int haty = column + 1;
            if (hatx >= 0 && haty >= 0 && hatx < size && haty < size) {
                  if(table[hatx][haty] ==  FieldValue.EMPTY ){
                table[hatx][haty] = FieldValue.GREEN;
                  }
            }

            int hetx = row - 1;
            int hety = column - 2;

            if (hetx >= 0 && hety >= 0 && hetx < size && hety < size) {
                      if(table[hetx][hety] ==  FieldValue.EMPTY ){
                table[hetx][hety] = FieldValue.GREEN;
                      }
            }

            int nyolcx = row - 2;
            int nyolcy = column - 1;
            if (nyolcx >= 0 && nyolcy >= 0 && nyolcx < size && nyolcy < size) {
                      if(table[nyolcx][nyolcy] ==  FieldValue.EMPTY ){
                table[nyolcx][nyolcy] = FieldValue.GREEN;
                      }
            }

            
            
            table[row][column] = FieldValue.BLACK;
            System.out.println("BlackKatt");
        }

        if (clickedPlayer == FieldValue.GREEN) {
            //ÜRESRe állítás
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    if (table[i][j] == FieldValue.GREEN) {
                        table[i][j] = FieldValue.EMPTY;
                    }
                }
            }
            if (FieldValue.WHITEHORSE == currentPlayer) {
                table[row][column] = FieldValue.WHITEHORSE;
                currentPlayer = FieldValue.BLACKHORSE;
                System.out.println("WHITE lovvv");
            } else if (FieldValue.BLACKHORSE == currentPlayer) {
                table[row][column] = FieldValue.BLACKHORSE;
                currentPlayer = FieldValue.WHITEHORSE;
                System.out.println("Black lovvv");
            }

        }

        return table[row][column];
    }

    public FieldValue getActualPlayer() {
        return clickedPlayer;
    }

    public void getModel() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.println(table[i][j] + " ");
            }
        }

    }

    public FieldValue getCurrentPlayer() {
        return currentPlayer;
    }
    
public FieldValue findWinner() {
        
  
    
        for (int i = 0; i < size; ++i) {
            if (table[0][i] != FieldValue.EMPTY) {
                boolean ok = true;
                for (int j = 1; ok && j < size; ++j) {
                    ok = ok && table[j][i] == table[0][i];
                }
                if (ok) {
                    return table[0][i];
                }
            }
        }
        for (int i = 0; i < size; ++i) {
            if (table[i][0] != FieldValue.EMPTY) {
                boolean ok = true;
                for (int j = 1; ok && j < size; ++j) {
                    ok = ok && table[i][j] == table[i][0];
                }
                if (ok) {
                    return table[i][0];
                }
            }
        }
        if (table[0][0] != FieldValue.EMPTY) {
            boolean ok = true;
            for (int j = 1; ok && j < size; ++j) {
                ok = ok && table[j][j] == table[0][0];
            }
            if (ok) {
                return table[0][0];
            }
        }
        if (table[0][size - 1] != FieldValue.EMPTY) {
            boolean ok = true;
            for (int j = 1; ok && j < size; ++j) {
                ok = ok && table[j][size - 1 - j] == table[0][size - 1];
            }
            if (ok) {
                return table[0][size - 1];
            }
        }

        return FieldValue.EMPTY;
    
    }

}
