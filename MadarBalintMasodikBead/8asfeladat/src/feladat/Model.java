package feladat;

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
                    table[i][j] = FieldValue.BLACKHORSE;
                }

                if (i == size - 1 && j == 0) {
                    table[i][j] = FieldValue.BLACKHORSE;
                }
                if (i == size - 1 && j == size - 1) {
                    table[i][j] = FieldValue.WHITEHORSE;
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

        int whitehorsecounterpiece = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (table[i][j] == FieldValue.WHITEHORSE) {
                    whitehorsecounterpiece++;
                }
            }
        }
        if (clickedPlayer == FieldValue.WHITEHORSE && currentPlayer == FieldValue.WHITEHORSE && clickedPlayer != FieldValue.GREEN && clickedPlayer != FieldValue.WHITE && clickedPlayer != FieldValue.BLACK && whitehorsecounterpiece == 2) {
            //Optimalizálható: 
            //új osztály írásába de 

            //8 db lépésfajta van és ha mindkét koordináta 0> és <size állítsa
            //be greenre
            //bug kijavítva nem lehet a  fehér lóra lépni !
            int elsox = row + 1;
            int elsoy = column + 2;
            if (elsox >= 0 && elsoy >= 0 && elsox < size && elsoy < size) {
                if (table[elsox][elsoy] == FieldValue.EMPTY) {
                    table[elsox][elsoy] = FieldValue.GREEN;
                }
                if (table[elsox][elsoy] == FieldValue.BLACK) {
                    table[elsox][elsoy] = FieldValue.GB;
                }
                if (table[elsox][elsoy] == FieldValue.WHITE) {
                    table[elsox][elsoy] = FieldValue.GW;
                }

            }

            int masx = row + 2;
            int masrowky = column + 1;
            if (masx >= 0 && masrowky >= 0 && masx < size && masrowky < size) {
                if (table[masx][masrowky] == FieldValue.EMPTY && table[masx][masrowky] != FieldValue.WHITEHORSE) {
                    table[masx][masrowky] = FieldValue.GREEN;
                }
                if (table[masx][masrowky] == FieldValue.BLACK) {
                    table[masx][masrowky] = FieldValue.GB;
                }
                if (table[masx][masrowky] == FieldValue.WHITE) {
                    table[masx][masrowky] = FieldValue.GW;
                }
            }

            int harx = row - 1;
            int hary = column + 2;
            if (harx >= 0 && hary >= 0 && harx < size && hary < size) {
                if (table[harx][hary] == FieldValue.EMPTY) {
                    table[harx][hary] = FieldValue.GREEN;
                }
                if (table[harx][hary] == FieldValue.WHITE) {
                    table[harx][hary] = FieldValue.GW;
                }
                if (table[harx][hary] == FieldValue.BLACK) {
                    table[harx][hary] = FieldValue.GB;
                }
            }

            int negyx = row + 1;
            int negyy = column - 2;
            if (negyx >= 0 && negyy >= 0 && negyx < size && negyy < size) {
                if (table[negyx][negyy] == FieldValue.EMPTY) {

                    table[negyx][negyy] = FieldValue.GREEN;
                }
                if (table[negyx][negyy] == FieldValue.WHITE) {
                    table[negyx][negyy] = FieldValue.GW;
                }
                if (table[negyx][negyy] == FieldValue.BLACK) {
                    table[negyx][negyy] = FieldValue.GB;
                }
            }

            int otx = row + 2;
            int oty = column - 1;
            if (otx >= 0 && oty >= 0 && otx < size && oty < size) {
                if (table[otx][oty] == FieldValue.EMPTY) {
                    table[otx][oty] = FieldValue.GREEN;
                }
                if (table[otx][oty] == FieldValue.WHITE) {
                    table[otx][oty] = FieldValue.GW;
                }
                if (table[otx][oty] == FieldValue.BLACK) {
                    table[otx][oty] = FieldValue.GB;
                }
            }

            int hatx = row - 2;
            int hatypsz = column + 1;
            if (hatx >= 0 && hatypsz >= 0 && hatx < size && hatypsz < size) {
                if (table[hatx][hatypsz] == FieldValue.EMPTY) {

                    table[hatx][hatypsz] = FieldValue.GREEN;
                }
                if (table[hatx][hatypsz] == FieldValue.WHITE) {
                    table[hatx][hatypsz] = FieldValue.GW;
                }
                if (table[hatx][hatypsz] == FieldValue.BLACK) {
                    table[hatx][hatypsz] = FieldValue.GB;
                }
            }

            int hetx = row - 1;
            int hety = column - 2;

            if (hetx >= 0 && hety >= 0 && hetx < size && hety < size) {
                if (table[hetx][hety] == FieldValue.EMPTY) {
                    table[hetx][hety] = FieldValue.GREEN;
                }
                if (table[hetx][hety] == FieldValue.WHITE) {
                    table[hetx][hety] = FieldValue.GW;
                }
                if (table[hetx][hety] == FieldValue.BLACK) {
                    table[hetx][hety] = FieldValue.GB;
                }
            }

            int nyolcx = row - 2;
            int nyolcy = column - 1;
            if (nyolcx >= 0 && nyolcy >= 0 && nyolcx < size && nyolcy < size) {
                if (table[nyolcx][nyolcy] == FieldValue.EMPTY) {
                    table[nyolcx][nyolcy] = FieldValue.GREEN;
                }
                if (table[nyolcx][nyolcy] == FieldValue.WHITE) {
                    table[nyolcx][nyolcy] = FieldValue.GW;

                }
                if (table[nyolcx][nyolcy] == FieldValue.BLACK) {
                    table[nyolcx][nyolcy] = FieldValue.GB;
                }
            }

            //lehet-e egyáltalán lépni?
            int greencounterInWhite = 0;
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    if (table[i][j] == FieldValue.GW || table[i][j] == FieldValue.GB || table[i][j] == FieldValue.GREEN) {
                        greencounterInWhite++;
                    }
                }
            }
            if (greencounterInWhite == 0) {
                System.out.println("NEM LEHET LÉPNI  EZZEL A LÓVAL!");
                table[row][column] = FieldValue.WHITEHORSE;
                currentPlayer = FieldValue.WHITEHORSE;

            }else{
            ///fehérre állítás 
            table[row][column] = FieldValue.WHITE;
            }
        }

        int blackcounterpiece = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (table[i][j] == FieldValue.BLACKHORSE) {
                    blackcounterpiece++;
                }
            }
        }
        //clickedPlayer == FieldValue.WHITEHORSE && currentPlayer == FieldValue.WHITEHORSE && clickedPlayer != FieldValue.GREEN && clickedPlayer != FieldValue.WHITE && clickedPlayer != FieldValue.BLACK && whitehorsecounterpiece == 2
        if (currentPlayer == FieldValue.BLACKHORSE && clickedPlayer == FieldValue.BLACKHORSE && clickedPlayer != FieldValue.GREEN && blackcounterpiece == 2) {
            int elsox = row + 1;
            int elsoy = column + 2;
            if (elsox >= 0 && elsoy >= 0 && elsox < size && elsoy < size) {
                if (table[elsox][elsoy] == FieldValue.EMPTY) {
                    table[elsox][elsoy] = FieldValue.GREEN;
                }
                if (table[elsox][elsoy] == FieldValue.BLACK) {
                    table[elsox][elsoy] = FieldValue.GB;
                }
                if (table[elsox][elsoy] == FieldValue.WHITE) {
                    table[elsox][elsoy] = FieldValue.GW;
                }

            }

            int masx = row + 2;
            int masrowky = column + 1;
            if (masx >= 0 && masrowky >= 0 && masx < size && masrowky < size) {
                if (table[masx][masrowky] == FieldValue.EMPTY) {
                    table[masx][masrowky] = FieldValue.GREEN;
                }
                if (table[masx][masrowky] == FieldValue.BLACK) {
                    table[masx][masrowky] = FieldValue.GB;
                }
                if (table[masx][masrowky] == FieldValue.WHITE) {
                    table[masx][masrowky] = FieldValue.GW;
                }
            }

            int harx = row - 1;
            int hary = column + 2;
            if (harx >= 0 && hary >= 0 && harx < size && hary < size) {
                if (table[harx][hary] == FieldValue.EMPTY) {
                    table[harx][hary] = FieldValue.GREEN;
                }
                if (table[harx][hary] == FieldValue.WHITE) {
                    table[harx][hary] = FieldValue.GW;
                }
                if (table[harx][hary] == FieldValue.BLACK) {
                    table[harx][hary] = FieldValue.GB;
                }
            }

            int negyx = row + 1;
            int negyy = column - 2;
            if (negyx >= 0 && negyy >= 0 && negyx < size && negyy < size) {
                if (table[negyx][negyy] == FieldValue.EMPTY) {
                    table[negyx][negyy] = FieldValue.GREEN;
                }
                if (table[negyx][negyy] == FieldValue.WHITE) {
                    table[negyx][negyy] = FieldValue.GW;
                }
                if (table[negyx][negyy] == FieldValue.BLACK) {
                    table[negyx][negyy] = FieldValue.GB;
                }

            }

            int otx = row + 2;
            int oty = column - 1;
            if (otx >= 0 && oty >= 0 && otx < size && oty < size) {
                if (table[otx][oty] == FieldValue.EMPTY) {
                    table[otx][oty] = FieldValue.GREEN;
                }
                if (table[otx][oty] == FieldValue.WHITE) {
                    table[otx][oty] = FieldValue.GW;
                }
                if (table[otx][oty] == FieldValue.BLACK) {
                    table[otx][oty] = FieldValue.GB;
                }
            }

            int hatx = row - 2;
            int haty = column + 1;
            if (hatx >= 0 && haty >= 0 && hatx < size && haty < size) {
                if (table[hatx][haty] == FieldValue.EMPTY) {
                    table[hatx][haty] = FieldValue.GREEN;
                }
                if (table[hatx][haty] == FieldValue.WHITE) {
                    table[hatx][haty] = FieldValue.GW;
                }
                if (table[hatx][haty] == FieldValue.BLACK) {
                    table[hatx][haty] = FieldValue.GB;
                }

            }

            int hetx = row - 1;
            int hety = column - 2;

            if (hetx >= 0 && hety >= 0 && hetx < size && hety < size) {
                if (table[hetx][hety] == FieldValue.EMPTY) {
                    table[hetx][hety] = FieldValue.GREEN;
                }
                if (table[hetx][hety] == FieldValue.WHITE) {
                    table[hetx][hety] = FieldValue.GW;
                }
                if (table[hetx][hety] == FieldValue.BLACK) {
                    table[hetx][hety] = FieldValue.GB;
                }
            }

            int nyolcx = row - 2;
            int nyolcy = column - 1;
            if (nyolcx >= 0 && nyolcy >= 0 && nyolcx < size && nyolcy < size) {
                if (table[nyolcx][nyolcy] == FieldValue.EMPTY) {
                    table[nyolcx][nyolcy] = FieldValue.GREEN;
                }
                if (table[nyolcx][nyolcy] == FieldValue.WHITE) {
                    table[nyolcx][nyolcy] = FieldValue.GW;
                }
                if (table[nyolcx][nyolcy] == FieldValue.BLACK) {
                    table[nyolcx][nyolcy] = FieldValue.GB;
                }
            }

            //lehet-e egyáltalán lépni?
            int greencounterInBLACK = 0;
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    if (table[i][j] == FieldValue.GW || table[i][j] == FieldValue.GB || table[i][j] == FieldValue.GREEN) {
                        greencounterInBLACK++;
                    }
                }
            }
            if (greencounterInBLACK == 0) {
                System.out.println("NEM LEHET LÉPNI  EZZEL A LÓVAL!");
                table[row][column] = FieldValue.BLACKHORSE;
                currentPlayer = FieldValue.BLACKHORSE;

            }else{
            table[row][column] = FieldValue.BLACK;
            System.out.println("BlackKatt");
            }


        }

        if (clickedPlayer == FieldValue.GREEN || clickedPlayer == FieldValue.GB || clickedPlayer == FieldValue.GW) {
            //ÜRESRe állítás és fehérre és feketére visszaállítás
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    if (table[i][j] == FieldValue.GREEN) {
                        table[i][j] = FieldValue.EMPTY;
                    }
                    if (table[i][j] == FieldValue.GW) {
                        table[i][j] = FieldValue.WHITE;
                    }
                    if (table[i][j] == FieldValue.GB) {
                        table[i][j] = FieldValue.BLACK;
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

    @SuppressWarnings("empty-statement")
    public FieldValue findWinner() {
        //Tele van-e a tábla???
        int emptycounter = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (table[i][j] != FieldValue.EMPTY && table[i][j] != FieldValue.GREEN) {
                    emptycounter++;
                }
            }
        }
        int gamesize = (int) size * (int) size;
        if (emptycounter == gamesize) {
            return FieldValue.GREEN;
        }
        ///Vízsintes FEHÉR győztes keresés:
        int counter = 0;
        for (int i = 0; i < size; ++i) {
            counter = 0;
            for (int j = 0; j < size; ++j) {
                if (table[i][j] == FieldValue.WHITE) {
                    counter++;
                }
                if (table[i][j] != FieldValue.WHITE) {
                    counter = 0;
                }
                if (counter == 4) {
                    System.out.println("Vízsintes FEHÉR győztes keresés:");
                    return FieldValue.WHITEHORSE;
                }

            }
        }

        ///Vízsintes FEKETE győztes keresés:
        int counter2 = 0;

        for (int i = 0; i < size; ++i) {
            counter2 = 0;
            for (int j = 0; j < size; ++j) {
                if (table[i][j] == FieldValue.BLACK) {
                    counter2++;
                }
                if (table[i][j] != FieldValue.BLACK) {
                    counter2 = 0;
                }
                if (counter2 == 4) {
                    System.out.println("Vízsintes FEKETE győztes keresés:");
                    return FieldValue.BLACKHORSE;
                }

            }
        }

        //Függőleges FEHÉR gyűztes kereés
        int VERTICALWHITEcounter = 0;
        for (int i = 0; i < size; ++i) {
            VERTICALWHITEcounter = 0;
            for (int j = 0; j < size; ++j) {
                if (table[j][i] == FieldValue.WHITE) {
                    VERTICALWHITEcounter++;
                }
                if (table[j][i] != FieldValue.WHITE) {
                    VERTICALWHITEcounter = 0;
                }
                if (VERTICALWHITEcounter == 4) {
                    System.out.println("Függőleges FEHÉR gyűztes kereés");
                    return FieldValue.WHITEHORSE;
                }

            }
        }

        //Függőleges FEKETE gyűztes kereés
        int VERTICALBLACKcounter = 0;
        for (int i = 0; i < size; ++i) {
            VERTICALBLACKcounter = 0;
            for (int j = 0; j < size; ++j) {
                if (table[j][i] == FieldValue.BLACK) {
                    VERTICALBLACKcounter++;
                }
                if (table[j][i] != FieldValue.BLACK) {
                    VERTICALBLACKcounter = 0;
                }
                if (VERTICALBLACKcounter == 4) {
                    System.out.println("Függőleges FEKETE gyűztes kereés");
                    return FieldValue.BLACKHORSE;
                }

            }
        }

        //Függőleges alulról felfele keresés bal alsó -> jobb felső átlók 1. ker
        int leftdiagonalcounterWHITE = 0;
        int leftdiagonalcounterBLACK = 0;
        int width = size;
        int height = size;

        int startRow = height - 1;
        int startColumn = width - 1;
        int column = 0;

        do {

            int row = startRow;
            column = startColumn;

            do {

                if (table[row][column] == FieldValue.WHITE) {
                    leftdiagonalcounterWHITE++;

                } else {
                    leftdiagonalcounterWHITE = 0;
                }

                if (leftdiagonalcounterWHITE >= 4) {
                    System.out.println("Függőleges alulról felfele átló fehér");
                    return FieldValue.WHITEHORSE;
                }
                //BLACK
                if (table[row][column] == FieldValue.BLACK) {
                    leftdiagonalcounterBLACK++;

                } else {
                    leftdiagonalcounterBLACK = 0;
                }

                if (leftdiagonalcounterBLACK >= 4) {
                    System.out.println("Függőleges alulról felfele átló fekete");
                    return FieldValue.BLACKHORSE;
                }

                ++row;
                ++column;

            } while ((row < height) && (column < width));
            leftdiagonalcounterWHITE = 0;
            leftdiagonalcounterBLACK = 0;

            if (startRow > 0) {

                --startRow;
            } else {

                ++startColumn;
            }
        } while (startColumn < width);

        //ENDOFLEFT 
        //Függőleges jobb felső bal alsó > jobb átlók
        int RIGHTdiagonalcounterWHITE = 0;
        int RIGHTdiagonalcounterBLACK = 0;

        int startRow2 = size - 1;
        int startColumn2 = size - 1;
        int column2 = 0;

        do {

            int row2 = startRow2;
            column2 = startColumn2;

            do {

                if (table[row2][column2] == FieldValue.WHITE) {
                    RIGHTdiagonalcounterWHITE++;

                } else {
                    RIGHTdiagonalcounterWHITE = 0;
                }

                if (RIGHTdiagonalcounterWHITE >= 4) {
                    System.out.println("Függőleges jobb felső bal alsó > jobb átlók fehér");
                    return FieldValue.WHITEHORSE;
                }
                //BLACK
                if (table[row2][column2] == FieldValue.BLACK) {
                    RIGHTdiagonalcounterBLACK++;

                } else {
                    RIGHTdiagonalcounterBLACK = 0;
                }

                if (RIGHTdiagonalcounterBLACK >= 4) {
                    System.out.println("Függőleges jobb felső bal alsó > jobb átlók fekeete");
                    return FieldValue.BLACKHORSE;
                }

                ++row2;
                --column2;

            } while ((row2 < size) && (column2 > -1));
            RIGHTdiagonalcounterWHITE = 0;
            RIGHTdiagonalcounterBLACK = 0;

            if (startRow2 > 0) {

                --startRow2;
            } else {

                --startColumn2;
            }
        } while (startColumn2 > -1);

        return FieldValue.EMPTY;

    }

}
