import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16235_나무재태크_변준호{
	static int N,M,K,food[][],add[][];
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static Queue<Tree> trees;
	static class Tree implements Comparable<Tree>{
		int x, y, age;

		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.age,o.age);
		}
		
	}
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        
        food = new int[N][N];
        add = new int[N][N];
        trees = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                food[i][j] = 5;
                add[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            
            trees.add(new Tree(x-1, y-1, a));
        }
        Collections.sort((List<Tree>) trees);
        
        for(int i=0;i<K;i++) {
        	spring();
        	fall();
        	winter();
        }
        System.out.println(trees.size());
	}
	private static void winter() {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				food[i][k]+=add[i][k];
			}
		}
	}
	private static void fall() {
		// TODO Auto-generated method stub
		ArrayList<Tree> parents = new ArrayList<>();
		
		int size = trees.size();
		for(int i=0;i<size;i++) {
			Tree tmp = trees.poll();
			if(tmp.age%5==0) {
				for(int x=0;x<8;x++) {
					int cy = tmp.y+dy[x];
					int cx = tmp.x+dx[x];
					if(cy>=0&&cx>=0&&cy<N&&cx<N) {
						trees.add(new Tree(cx,cy,1));
					}
				}
			}
			parents.add(tmp);
		}
		for(Tree t : parents) {
			trees.add(t);
		}
	}
	private static void spring() {
		// TODO Auto-generated method stub
		ArrayList<Tree> dead = new ArrayList<>();
		int size = trees.size();
		for(int i=0;i<size;i++) {
			Tree tmp = trees.poll();
			if(food[tmp.x][tmp.y]-tmp.age<0) {
				dead.add(new Tree(tmp.x,tmp.y,tmp.age/2));
			}
			else {
				//양분 쪽쪽
				food[tmp.x][tmp.y]-=tmp.age;
				trees.add(new Tree(tmp.x,tmp.y,tmp.age+1));
			}
		}
		//여름
		for(Tree tmp : dead) {
			food[tmp.x][tmp.y]+=tmp.age;
		}
	}
}