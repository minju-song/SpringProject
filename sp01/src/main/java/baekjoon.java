import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int square = (int)Math.pow(4, n);

		int vertex = (int)Math.pow((int)Math.sqrt(square)+1,2);
		
		System.out.println(vertex);
	}
}
