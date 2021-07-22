import java.util.ArrayList;

public class Practice {
//    public static void main(String[] args) {
//
//    }
//
//    public void Combination() {
//        for (int i = 0; i < (1 << 4); i++) { // info 하나당 조건이 4가지니까 총 나올 수 있는 경우의 수 = 16(아무것도 없는것 포함)
//            StringBuilder key = new StringBuilder();
//            for (int j = 0; j < 4; j++) { // 요건 대체 어케한거지 (나중에 써먹자)
//                if ((i & (1 << j)) > 0) key.append(split[j]);
//            }
//        }
//    }
//
//    private void permutation(int n, int r, int[] perms, int[] input, int depth, int flag) {
//        if (depth == r) {
//            int[] temp = new int[n];
//            //arraycopy(Object src , int srcPos, object dest, int destPos, length)
//            //Object src : 배열원본
//            //srcPos : 소스 배열을 어디부터 복사시킬 것인지
//            //dest : 위치시킬 배열
//            //destPos : 위치시킬 배열의 시작 데이터 위치
//            //length : 복사되는 배열 요소의 수
//            System.arraycopy(perms, 0, temp, 0, n);
//            orders.add(temp); // orders.ArrayList에 순서 순열 저장
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if ((flag & (1 << i)) == 0) {
//                perms[depth] = input[i];
//                permutation(n, r, perms, input, depth + 1, flag | (1 << i));
//            }
//        }
//    }
}
