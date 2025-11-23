package comp3607.asg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvQuestionLoader extends QuestionLoader {

    private List<Question> questions = new ArrayList<>();

    public CsvQuestionLoader(String filepath) {
        super(filepath);
    }

    @Override
    protected void ReadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            rawData = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void ParseData() {
        String[] lines = rawData.split("\n");

        for (int i = 1; i < lines.length; i++) { // skip header
            String[] parts = lines[i].split(",");
            questions.add(new Question(parts[0], parts[1]));
        }
    }

    @Override
    protected Category LoadCategory() {
        Category c = new Category("CSV Category");
        for (Question q : questions) c.addQuestion(q);
        return c;
    }
}
