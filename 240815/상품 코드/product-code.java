import java.util.*;
import java.io.*;

public class Main {
    static class Product{
        String name;
        int code;
        public Product(){
            this.name = "codetree";
            this.code = 50;
        }
        public Product(String name, int code){
            this.name = name;
            this.code = code;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        int code = Integer.parseInt(st.nextToken());

        Product p1 = new Product();
        Product p2 = new Product(name, code);

        System.out.println("product "+p1.code + " is "+p1.name);
        System.out.println("product "+p2.code + " is "+p2.name);

    }
}