package lesson5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ZagruzkaCsvFile {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("value.csv"))
        {
            int c;
            while((c=reader.read())!=-1){
             System.out.print((char)c);
            }
        }
        catch(IOException e){

            System.out.println(e.getMessage());
        }


        ArrayList<AppData> appDataArrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("value.csv"))) {
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            String[] valueParams = temp.split(" ; ");
            appDataArrayList.add(new AppData(new String[]{valueParams[0]}, new int[][]{{Integer.parseInt(valueParams[1])}, {Integer.parseInt(valueParams[2])}}));
        }
// затрудняюсь с указанием параметров
        } catch (FileNotFoundException exception) {
        exception.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
        System.out.println(appDataArrayList);

    }

}
