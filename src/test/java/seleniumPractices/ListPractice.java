package seleniumPractices;

import java.util.ArrayList;

public class ListPractice {


    public static void main(String[] args) {
        ArrayList<String> datas = new ArrayList<>();
        datas.add("NY");
        datas.add("NJ");
        datas.add("CT");
        datas.add("VA");

        String expectedData = "VA";

        boolean flag = false;

        for (int i = 0; i < datas.size(); i++) {
            String dataFromList = datas.get(i);
            if (dataFromList.equalsIgnoreCase(expectedData)) {
                flag = true;
            }
        }

        if (flag == true) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }
}
