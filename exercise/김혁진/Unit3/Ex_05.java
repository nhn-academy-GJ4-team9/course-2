import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Problem
 * 파일을 읽어서 특정 정보를 추출
 */
public class Ex_05 {
    public static void main(String[] args) throws IOException {
        String filename = "/sales.dat";
        double totalSales = 0.0;
        int noDataCount = 0;

        try (InputStream is = Ex_05.class.getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String city = parts[0].trim();
                    String data = parts[1].trim();

                    if (data.equals("no report received")) {
                        noDataCount++;
                    } else {
                        double sales = Double.parseDouble(data);
                        totalSales += sales;
                    }
                }
            }

            System.out.println("총 판매 금액 : " + totalSales);
            System.out.println("데이터 없는 도시 갯수 : " + noDataCount);
        }
    }
}
