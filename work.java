public class FootballGame extends JFrame {
    private int milanScore = 0; 
    private int madridScore = 0; 
    private JLabel resultLabel; 
    private JLabel lastScorerLabel; 
    private JLabel winnerLabel; 

    public FootballGame() {
        super("Football Game");


        setLayout(new FlowLayout());


        JButton milanButton = new JButton("AC Milan");
        milanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                milanScore++;
                updateLabels("AC Milan");
            }
        });
        add(milanButton);


        JButton madridButton = new JButton("Real Madrid");
        madridButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                madridScore++;
                updateLabels("Real Madrid");
            }
        });
        add(madridButton);


        resultLabel = new JLabel("Result: " + milanScore + " X " + madridScore);
        add(resultLabel);


        lastScorerLabel = new JLabel("Last Scorer: N/A");
        add(lastScorerLabel);

     
        winnerLabel = new JLabel("Winner: DRAW");
        add(winnerLabel);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private void updateLabels(String lastScorer) {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);

        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (milanScore < madridScore) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FootballGame();
            }
        });
    }
}