package lesson5;

import java.io.*;
import java.util.ArrayList;

public class CsvFileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("value.txt");
        file.createNewFile();
        System.out.println(file.exists());

        ArrayList<ValueData> valueDatas = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("value.txt"))) {
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] valueParams = temp.split(" ");
                valueDatas.add(new ValueData(valueParams[0], Integer.parseInt(valueParams[1]), Integer.parseInt(valueParams[2])));
            }
  // не пойму что не так в ячейках параметров
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(valueDatas);

        try (PrintWriter printWriter = new PrintWriter("new_value.csv")) {
        for (ValueData valueData: valueDatas)
            printWriter.println(valueData.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
