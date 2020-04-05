package hello;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DataPoolProcessing {

    private Map<String, String> dataMap;

    private DataPoolProcessing() {

        this.dataMap = new HashMap<String, String>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("C:\\\\Loadtest\\datapool.dat"), "UTF-8"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] tempData = line.trim().split(",");
                this.dataMap.put(tempData[0], tempData[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataPoolProcessing getInstance() {
        return LazyDataPoolProcessing.INSTANCE;
    }

    public String getSAPLogin(String key) {
        String loginToUse = this.dataMap.get(key);
        return loginToUse;
    }

    private static class LazyDataPoolProcessing {
        private static DataPoolProcessing INSTANCE = new DataPoolProcessing();
    }
}