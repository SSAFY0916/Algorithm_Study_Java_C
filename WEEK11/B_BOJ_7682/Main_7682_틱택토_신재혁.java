import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7682_틱택토_신재혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while(!"end".equals(str)){
            char[][] map = new char[3][3];
            int Xcount = 0;
            int Ocount = 0;
            int bingoes = 0;
            boolean filled = true;
            int Xbingo = 0;
            int Obingo = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    char c = str.charAt(i*3+j);
                    map[i][j] = c;
                    if(c == 'X'){
                        Xcount++;
                    }
                    if(c == 'O'){
                        Ocount++;
                    }
                    if(c == '.'){
                        filled = false;
                    }
                }
            }
            for(int k = 0; k < 7; k++){
                if(k < 3){ // horz
                    int i = k;
                    if(map[0][i] != '.' && map[0][i] == map[1][i] && map[1][i] == map[2][i]){
                        bingoes++;
                        if(map[0][i]=='X'){
                            Xbingo ++;
                        }else{
                            Obingo ++;
                        }
                    }
                }else if (k < 6){ // vert
                    int i = k-3;
                    if(map[i][0] != '.' && map[i][0] == map[i][1] && map[i][1] == map[i][2]){
                        bingoes++;
                        if(map[i][0]=='X'){
                            Xbingo ++;
                        }else{
                            Obingo ++;
                        }
                    }
                }else { // diag
                    if(map[1][1] != '.' && map[0][0] == map[1][1] && map[1][1] == map[2][2]){
                        bingoes++;
                        if(map[1][1]=='X'){
                            Xbingo ++;
                        }else{
                            Obingo ++;
                        }
                    }
                    if(map[1][1] != '.' && map[2][0] == map[1][1] && map[1][1] == map[0][2]){
                        bingoes++;
                        if(map[1][1]=='X'){
                            Xbingo ++;
                        }else{
                            Obingo ++;
                        }
                    }
                }
            }
            boolean reject = false;
            if(Xbingo >= 1 && Obingo >= 1){
                reject = true;
            }
            else if(!filled && bingoes != 1){
                reject = true;
            }else if(filled && Xcount != Ocount + 1){
                reject = true;
            }else if(bingoes == 1 && Xcount != Ocount && Obingo == 1){
                reject = true;
            }else if(Xbingo == 1 && Xcount != Ocount + 1){
                reject = true;
            }
            System.out.println(reject?"invalid":"valid");
            str = br.readLine();
        }


    }
}