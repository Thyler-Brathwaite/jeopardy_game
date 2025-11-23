package comp3607.asg;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlQuestionLoader extends QuestionLoader {

    private List<Question> questions = new ArrayList<>();

    public XmlQuestionLoader(String filepath) {
        super(filepath);
    }

    @Override
    protected void ReadFile() {
        try {
            rawData = new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void ParseData() {
        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();

            Document doc = b.parse(new File(filepath));
            NodeList nodes = doc.getElementsByTagName("question");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element e = (Element) nodes.item(i);

                String q = e.getAttribute("text");
                String a = e.getAttribute("answer");

                questions.add(new Question(q, a));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Category LoadCategory() {
        Category c = new Category("XML Category");
        for (Question q : questions) c.addQuestion(q);
        return c;
    }
}
