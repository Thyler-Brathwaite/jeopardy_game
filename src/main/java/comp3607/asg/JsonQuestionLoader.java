package comp3607.asg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class JsonQuestionLoader extends QuestionLoader {

    private List<Question> questions = new ArrayList<>();

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

        // Remove [ and ]
        String data = rawData.trim();
        if (data.startsWith("[")) data = data.substring(1);
        if (data.endsWith("]")) data = data.substring(0, data.length() - 1);

        // Split objects by "}, {"
        String[] objects = data.split("\\},\\s*\\{");

        for (int i = 0; i < objects.length; i++) {
            String obj = objects[i].trim();

            // Fix remaining braces
            if (!obj.startsWith("{")) obj = "{" + obj;
            if (!obj.endsWith("}")) obj = obj + "}";

            String category = getJsonString(obj, "Category");
            int value = Integer.parseInt(getJsonString(obj, "Value"));
            String questionText = getJsonString(obj, "Question");
            String correct = getJsonString(obj, "CorrectAnswer");

            // Extract Options object
            String optionsObj = getJsonObject(obj, "Options");

            String optionA = getJsonString(optionsObj, "A");
            String optionB = getJsonString(optionsObj, "B");
            String optionC = getJsonString(optionsObj, "C");
            String optionD = getJsonString(optionsObj, "D");

            // Build Question
            Question q = new Question(questionText, correct);
            q.addOption("A", optionA);
            q.addOption("B", optionB);
            q.addOption("C", optionC);
            q.addOption("D", optionD);
            q.setValue(value);

            questions.add(q);
        }
    }

    // Extract "key": "value"
    private String getJsonString(String json, String key) {
        try {
            String k = "\"" + key + "\"";
            int start = json.indexOf(k);
            if (start == -1) return "";
            start = json.indexOf(":", start) + 1;

            // Remove quotes and spaces
            StringBuilder value = new StringBuilder();
            boolean insideString = false;

            for (int i = start; i < json.length(); i++) {
                char c = json.charAt(i);

                if (c == '"') {
                    insideString = !insideString;
                    continue;
                }
                if (!insideString && (c == ',' || c == '}')) break;

                if (insideString) value.append(c);
            }

            return value.toString().trim();

        } catch (Exception e) {
            return "";
        }
    }

    // Extract nested object: "Options": { ... }
    private String getJsonObject(String json, String key) {
        String k = "\"" + key + "\"";
        int start = json.indexOf(k);
        if (start == -1) return "";

        start = json.indexOf("{", start); // first {
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

    @Override
    protected Category LoadCategory() {
        Category c = new Category("All Categories from JSON");

        for (Question q : questions) {
            c.addQuestion(q);
        }
        return c;
    }
}
