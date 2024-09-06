/**
 * ClassName: LifeGame
 * Package: PACKAGE_NAME
 */
public class LifeGame {
    public void gameOfLife(int[][] board) {
        int[][] changeIndex = new int[board.length*board[0].length][3];
        int changeCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
                int [][] eightLocation = new int[8][2];
                eightLocation[0][0] = i-1;
                eightLocation[0][1] = j-1;

                eightLocation[1][0] = i-1;
                eightLocation[1][1] = j;

                eightLocation[2][0] = i-1;
                eightLocation[2][1] = j+1;

                eightLocation[3][0] = i;
                eightLocation[3][1] = j-1;

                eightLocation[4][0] = i;
                eightLocation[4][1] = j+1;

                eightLocation[5][0] = i+1;
                eightLocation[5][1] = j-1;

                eightLocation[6][0] = i+1;
                eightLocation[6][1] = j;

                eightLocation[7][0] = i+1;
                eightLocation[7][1] = j+1;

                int countLive = 0;
                int countDead = 0;
                for (int k = 0; k < 8; k++) {
                    if(eightLocation[k][0]<0||eightLocation[k][0]>=board.length||eightLocation[k][1]<0||eightLocation[k][1]>=board[0].length){
                        //不在面板中
                        continue;
                    }else {
                        if(board[eightLocation[k][0]][eightLocation[k][1]]==1){
                            countLive++;
                        }else {
                            countDead++;
                        }
                    }
                }
                if(board[i][j] == 0){
                    //死细胞
                    if(countLive ==3){
                        changeIndex[changeCount][0] = i;
                        changeIndex[changeCount][1] = j;
                        changeIndex[changeCount][2] = 1;
                        changeCount++;
                    }
                }else{
                    //活细胞
                    if(countLive<2||countLive>3){
                        changeIndex[changeCount][0] = i;
                        changeIndex[changeCount][1] = j;
                        changeIndex[changeCount][2] = 0;
                        changeCount++;
                    }


                }


            }
            System.out.println();
        }
        for (int i = 0; i < changeCount; i++) {
            int x = changeIndex[i][0];
            int y = changeIndex[i][1];
            int value = changeIndex[i][2];
            board[x][y] = value;
        }
        System.out.println("------------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
            
        }

    }

    public static void main(String[] args) {
        int [][] board = new int[][]{{1,1},{1,0}};
        int [][] board2 = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new LifeGame().gameOfLife(board2);

    }
}
