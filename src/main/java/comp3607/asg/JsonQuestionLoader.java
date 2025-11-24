package comp3607.asg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonQuestionLoader extends QuestionLoader {

    
    private Map<String, Category> categoryMap = new LinkedHashMap<>();

    public JsonQuestionLoader(String filepath) {
        super(filepath);
    }

    @Override
    protected void ReadFile() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line.trim());
            }
        } catch (Exception e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
        rawData = sb.toString();
    }

    @Override
    protected void ParseData() {
        String data = rawData;

        
        if (data.startsWith("[")) data = data.substring(1);
        if (data.endsWith("]")) data = data.substring(0, data.length() - 1);

        String[] objects = data.split("\\},\\s*\\{");

        for (String obj : objects) {
            obj = obj.trim();
            if (!obj.startsWith("{")) obj = "{" + obj;
            if (!obj.endsWith("}")) obj = obj + "}";

            String categoryName = getJsonString(obj, "Category");
            int value = Integer.parseInt(getJsonString(obj, "Value"));
            String questionText = getJsonString(obj, "Question");
            String correct = getJsonString(obj, "CorrectAnswer");

           
            String optionsObj = getJsonObject(obj, "Options");

            String A = getJsonString(optionsObj, "A");
            String B = getJsonString(optionsObj, "B");
            String C = getJsonString(optionsObj, "C");
            String D = getJsonString(optionsObj, "D");

           
            Category category = categoryMap.get(categoryName);
            if (category == null) {
                category = new Category(categoryName);
                categoryMap.put(categoryName, category);
            }

    
            Question q = new Question(questionText, correct);
            q.setPrice(value);
            q.addOption("A", A);
            q.addOption("B", B);
            q.addOption("C", C);
            q.addOption("D", D);

            category.addQuestion(q);
        }
    }

    @Override
    protected Category LoadCategory() {
        
        if (categoryMap.isEmpty()) return null;

        String firstKey = categoryMap.keySet().iterator().next();
        Category c = categoryMap.get(firstKey);
        categoryMap.remove(firstKey);
        return c;
    }



    private String getJsonString(String json, String key) {
    try {
        String k = "\"" + key + "\"";
        int start = json.indexOf(k);
        if (start == -1) return "";

        start = json.indexOf(":", start) + 1;

     
        while (start < json.length() && Character.isWhitespace(json.charAt(start))) {
            start++;
        }


        if (json.charAt(start) == '"') {
            start++;
            StringBuilder value = new StringBuilder();
            for (int i = start; i < json.length(); i++) {
                char c = json.charAt(i);
                if (c == '"') break;
                value.append(c);
            }
            return value.toString().trim();
        }


        StringBuilder number = new StringBuilder();
        for (int i = start; i < json.length(); i++) {
            char c = json.charAt(i);
            if (!Character.isDigit(c)) break;
            number.append(c);
        }
        return number.toString().trim();

    } catch (Exception e) {
        return "";
    }
}


    private String getJsonObject(String json, String key) {
        String k = "\"" + key + "\"";
        int start = json.indexOf(k);
        if (start == -1) return "";

        start = json.indexOf("{", start);
        int braceCount = 0;

        StringBuilder obj = new StringBuilder();
        for (int i = start; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{') braceCount++;
            if (c == '}') braceCount--;
            obj.append(c);
            if (braceCount == 0) break;
        }
        return obj.toString();
    }
}
