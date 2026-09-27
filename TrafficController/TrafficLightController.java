package light;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightController extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel lightPanel;
    private JButton startButton, stopButton;
    private Timer timer;

    private int currentLight = 0; // 0: Red, 1: Yellow, 2: Green

    private final Color[] lightColors = {
        Color.RED,
        Color.YELLOW,
        Color.GREEN
    };

    private final int[] lightTimings = {
        5000, 2000, 5000
    }; // Timings in milliseconds

    public TrafficLightController() {

        setTitle("Traffic Light Controller");
        setSize(300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the light panel
        lightPanel = new JPanel() {

            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw the traffic light circles
                for (int i = 0; i < 3; i++) {
                    g.setColor(
                        i == currentLight
                            ? lightColors[i]
                            : Color.GRAY
                    );

                    g.fillOval(100, 50 + (100 * i), 80, 80);
                }
            }
        };

        lightPanel.setBackground(Color.BLACK);
        add(lightPanel, BorderLayout.CENTER);

        // Control Panel for buttons
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        stopButton.setEnabled(false);

        controlPanel.add(startButton);
        controlPanel.add(stopButton);

        add(controlPanel, BorderLayout.SOUTH);

        // Timer to manage light transitions
        timer = new Timer(
            lightTimings[currentLight],
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    currentLight = (currentLight + 1) % 3;

                    // Update timing for the next light
                    timer.setDelay(lightTimings[currentLight]);

                    lightPanel.repaint();
                }
            }
        );

        // Start button action
        startButton.addActionListener(e -> {
            timer.start();

            startButton.setEnabled(false);
            stopButton.setEnabled(true);
        });

        // Stop button action
        stopButton.addActionListener(e -> {
            timer.stop();

            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TrafficLightController trafficLightController =
                new TrafficLightController();

            trafficLightController.setVisible(true);
        });
    }
}
