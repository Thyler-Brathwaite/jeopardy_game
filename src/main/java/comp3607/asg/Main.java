package comp3607.asg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("        JEOPARDY GAME");
        System.out.println("=================================\n");

        // Ask for file type and path
        System.out.print("Enter question file type (csv/json/xml): ");
        String type = in.nextLine().trim().toLowerCase();

        System.out.print("Enter path to question file (or press Enter to use a default): ");
        String inputPath = in.nextLine().trim();

        // Provide sensible defaults if user just presses Enter
        String filePath;
        if (inputPath.isEmpty()) {
            switch (type) {
                case "json":
                    filePath = "resources/sample_game_JSON.json";
                    break;
                case "xml":
                    filePath = "resources/sample_game_XML.xml";
                    break;
                case "csv":
                default:
                    filePath = "resources/sample_game_CSV.csv";
                    break;
            }
            System.out.println("Using default file: " + filePath);
        } else {
            filePath = inputPath;
        }

        // Instantiate loader with filePath (constructors expect filepath)
        QuestionLoader loader;
        switch (type) {
            case "json":
                loader = new JsonQuestionLoader(filePath);
                break;
            case "xml":
                loader = new XmlQuestionLoader(filePath);
                break;
            case "csv":
            default:
                loader = new CsvQuestionLoader(filePath);
                break;
        }

        // Build the board using your loader pattern
        Board board = new Board();

        // Your project used loader.loadQuestions() returning a Category, then repeated calls to LoadCategory().
        // We follow the same pattern so we don't change loader internals.
        Category c = loader.loadQuestions();
        while (c != null) {
            board.addCategory(c);
            // LoadCategory() is a protected/subclass method in your loader implementations;
            // accessible from same package. If your loader returns null when done, this breaks out.
            c = loader.LoadCategory();
        }

        // Create game and add players
        Game game = new Game(board);

        System.out.print("How many players? ");
        int numPlayers = 1;
        try {
            numPlayers = Integer.parseInt(in.nextLine().trim());
            if (numPlayers < 1) numPlayers = 1;
        } catch (Exception e) {
            System.out.println("Invalid number entered; defaulting to 1 player.");
            numPlayers = 1;
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = in.nextLine().trim();
            if (name.isEmpty()) name = "Player" + (i + 1);
            game.addPlayer(new Player(name, i + 1));
        }

        // Start the game loop
        game.start();

        in.close();
    }
}
