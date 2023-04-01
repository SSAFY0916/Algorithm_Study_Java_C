import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16987_계란으로계란치기_신재혁 {
	public static StringBuilder sb;
	public static int N;
	public static int maxCrack;
	public static Egg[] eggs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // 계란의 수
		eggs = new Egg[N];
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		maxCrack = 0;
		crack(0, eggs, 0); // start from index 0
		System.out.println(maxCrack);
	}
	public static void crack(int start, Egg[] eggs, int crack){
		for(int i = 0; i < N; i++){
			if(i == start) continue;
			if(eggs[i].hp <= 0){
				continue;
			}else{
				eggs[start].hp -= eggs[i].atk;
				eggs[i].hp -= eggs[start].atk;
				int cracked = 0;
				if(eggs[start].hp <= 0)
					cracked++;
				if(eggs[i].hp <= 0)
					cracked++;
				for(int j = start+1; j < N; j++){
					if(eggs[j].hp > 0){
						crack(j,eggs, crack+cracked);
					}
				}
				maxCrack = Math.max(maxCrack,crack+cracked);
				eggs[start].hp += eggs[i].atk;
				eggs[i].hp += eggs[start].atk;
			}

		}
	}
	static class Egg {
		int hp;
		int atk;

		public Egg(int hp, int atk) {
			this.hp = hp;
			this.atk = atk;
		}
	}
}