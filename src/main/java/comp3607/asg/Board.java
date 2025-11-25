package comp3607.asg;

import java.util.ArrayList;

public class Board {

    private final ArrayList<Categoryable> categories = new ArrayList<>();

    public void addCategory(Category c) {
        categories.add(c);
    }

    public void displayBoard() {
        if (categories.isEmpty()) {
            System.out.println("No categories loaded.");
            return;
        }

        System.out.println("\n============ JEOPARDY BOARD ============\n");

        for (Categoryable c : categories) {
            System.out.printf("| %-25s", c.getCategory());
        }
        System.out.println("|");

        System.out.println("------------------------------------------------------------------------------------");

        int numRows = categories.get(0).getQuestions().size();


        for (int row = 0; row < numRows; row++) {
            for (Categoryable c : categories) {
                Question q = c.getQuestions().get(row);

             
                if (q.isUsed()) {
                    System.out.printf("| %-25s", "X");
                } else {
                    System.out.printf("| %-25d", q.getPrice());
                }
            }
            System.out.println("|");
        }

        System.out.println("------------------------------------------------------------------------------------\n");
    }


    public boolean allQuestionsAnswered() {
        for (Categoryable c : categories) {
            for (Question q : c.getQuestions()) {
                if (!q.isUsed()) {
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<Categoryable> getCategories() {
        return new ArrayList<>(categories);
    }
    
    public Categoryable getCategoryByName(String name) {
        for (Categoryable c : categories) {
            if (c.getCategory().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
}
