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

  
        String data = rawData.trim();


        if (data.startsWith("[")) data = data.substring(1);
        if (data.endsWith("]")) data = data.substring(0, data.length() - 1);

  
        String[] objects = data.split("\\},\\s*\\{");

        for (String obj : objects) {

          
            obj = obj.replace("{", "").replace("}", "").trim();

            String[] fields = obj.split(",");

            String question = "";
            String answer = "";

            for (String field : fields) {
                String[] keyValue = field.split(":");

                if (keyValue.length < 2)
                    continue;

                String key = keyValue[0].replace("\"", "").trim();
                String value = keyValue[1].replace("\"", "").trim();

                if (key.equals("question")) question = value;
                if (key.equals("answer")) answer = value;
            }

      
            if (!question.isEmpty() && !answer.isEmpty()) {
                questions.add(new Question(question, answer));
            }
        }
    }

    @Override
    protected Category LoadCategory() {
        Category category = new Category("JSON Category");
        for (Question q : questions) {
            category.addQuestion(q);
        }
        return category;
    }
}

