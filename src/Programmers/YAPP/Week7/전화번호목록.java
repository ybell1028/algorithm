package Programmers.YAPP.Week7;

import java.util.*;

public class 전화번호목록 {
	static class Solution {
		public boolean solution1(String[] phone_book){
			boolean answer = true;
			TreeMap<String, Integer>[] tm = new TreeMap[21];
			for(int i = 0; i < tm.length; ++i){
				tm[i] = new TreeMap<>();
			}

			for(String pn : phone_book){
				int len = pn.length();
				tm[len].put(pn, 1);
			}
			int diff;
			int result;
			for(int i = 1; i < tm.length - 1; ++i){
				if(!tm[i].isEmpty()){
					for(String pre : tm[i].keySet()){
						for(int j = i + 1; j < tm.length; ++j){
							if(!tm[j].isEmpty()){
								for(String key : tm[j].keySet()){
									result = pre.compareTo(key);
									if(result < 0){ // 접두사보다 키가 길거나 클 때
										diff = key.length() - pre.length();
										if(key.startsWith(pre)) {
											return false;
										} else if(result + diff >= 0) break;
									}
								}
							}
						}
					}
				}
			}
			return answer;
		}

		public static boolean solution2(String[] phone_book) {
			boolean answer = true;
			Arrays.sort(phone_book);  //정렬합니다.
			HashMap<String, String> hm = new HashMap<>();
			for(int i = 0;i < phone_book.length; ++i){
				String arg = phone_book[i];
				hm.put(arg, arg);  //대상을 넣습니다.
				for(int j = 0; j < arg.length(); j++){ //본인의 키 값 패턴이 다른곳에도 있는지
					String stub = arg.substring(0,j);  //하나하나 늘려가며
					if(hm.get(stub) != null){  //조사합니다.
						return false;
					}
				}
			}
			return answer;
		}
		
		public static void main(String[] args){
			String[] pb1 = {"119", "97674223", "1195524421"};
			String[] pb2 = {"123","456","789","341089", "5421", "4315", "13467", "12089843", "1345047", "234", "1244", "2545", "3456", "1212", "1111", "123456789"};
			String[] pb3 = {"12","123","1235","567","88"};
			
			Solution s = new Solution();
			System.out.println("123".compareTo("12346")); // 두자릿수 차이 점점 커진다 diff 더한게 0보다 커지면 break
			//"123".compareTo("1111") 1
			//"123".compareTo("125") -2 diff 0 합치면 -2
			//"123".compareTo("1255") -2 diff = 1 합치면 -1
			//"123".compareTo("1234") -1

			System.out.println(s.solution2(pb2));
		}
	}
}
