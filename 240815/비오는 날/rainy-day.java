import java.util.*;
import java.io.*;

public class Main {
    static class Data implements Comparable<Data>{
        int year;
        int month;
        int date;
        String weekDay;
        String weather;
        public Data(int year, int month, int date, String weekDay, String weather){
            this.year = year;
            this.month = month;
            this.date = date;
            this.weekDay = weekDay;
            this.weather = weather;
        }
        public int compareTo(Data d){
            if(this.year != d.year) return this.year - d.year;
            if(this.month != d.month) return this.month - d.month;
            return this.date - d.date;
        }
    }
    static int N;
    static Data[] datas;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        datas = new Data[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String dateString = st.nextToken();
            String weekDay = st.nextToken();
            String weather = st.nextToken();

            String[] temp = dateString.split("-");
            int year = Integer.parseInt(temp[0]);
            int month = Integer.parseInt(temp[1]);
            int date = Integer.parseInt(temp[2]);
            datas[i] = new Data(year, month, date, weekDay, weather);
        }

        Arrays.sort(datas);

        for(int i = 0; i < N; i++){
            // System.out.println(datas[i].year+"-"+ datas[i].month+"-"+datas[i].date+" "+datas[i].weather);
            // System.out.println(datas[i].weather.equals("Rain"));
            if(datas[i].weather.equals("Rain")){
                // System.out.println("if문 안에 들어옴");
                String month = "";
                String date = "";
                if(datas[i].month < 10){
                    month = "0"+datas[i].month;
                } else {
                    month = month+datas[i].month;
                }
                if(datas[i].date < 10){
                    date = "0"+datas[i].date;
                } else {
                    date = date+datas[i].date;
                }
                System.out.println(datas[i].year+"-"+month+"-"+date+" "+datas[i].weekDay+" "+datas[i].weather);
                break;
            }
        }

    }
}