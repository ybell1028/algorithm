package Baekjoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam5397_idiot {
    public static void processInput(char c){
        switch (c) {
            case '<':
                if (cursor > 0) cursor--;
                break;
            case '>':
                if (cursor < len) cursor++;
                break;
            case '-':
                if(cursor > 0 && cursor == len) result = result.substring(0, --cursor);
                else if(cursor > 0 && cursor < len) {
                    result = result.substring(0, cursor - 1)
                            + result.substring(cursor--, len);
                }
                break;
            default:
                if(cursor == 0 || cursor == len){
                    result += String.valueOf(c);
                }
                else if(cursor > 0 && cursor < len){
                    result = result.substring(0, cursor)
                            + String.valueOf(c)
                            + result.substring(cursor, len);
                }
                cursor++;
                break;
        }
    }

    public static int len;
    public static int cursor;
    public static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input[] = new String[n];
        for(int i = 0; i < n; ++i){
            // 백스페이스는 '-',  이때 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다.
            // 화살표 입력 < >, 이때는 커서의 위치를 움직일 수 있다면, 왼쪽 또는 오른쪽으로 1만큼 움직인다.
            // 만약 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.
            input[i] = br.readLine();
        }

        for(int i = 0; i < n; ++i){
            len = 0;
            cursor = 0;
            result = "";
            for(int j = 0; j < input[i].length(); ++j){
                len = result.length();
                processInput(input[i].charAt(j));
            }
            //만약 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.
            len = result.length();
            if(cursor != len){
                result = result.substring(0, cursor) + " " + result.substring(cursor, len);
            }
            System.out.println(result);
        }
    }
}
