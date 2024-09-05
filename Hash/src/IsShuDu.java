import java.util.HashMap;

/**
 * ClassName: IsShuDu
 * Package: PACKAGE_NAME
 */
public class IsShuDu {
    public boolean isValidSudoku(char[][] board) {
        int [][] rows = new int[9][9];
        int [][] columns =new int[9][9];
        int [][][] count  = new int[3][3][9];
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c!='.'){
                    int number  = c-'0'-1;
                    rows[i][number]++;
                    columns[j][number]++;
                    count[i/3][j/3][number]++;
                    if(rows[i][number]>1||columns[j][number]>1|| count[i/3][j/3][number]>1){
                        return  false;
                    }
                }
            }
        }

        return  true;
    }

    public static void main(String[] args) {

    }
}
