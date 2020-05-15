package lesson8.XOGame;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 560;
    private static final int WINDOW_WIDTH = 510;
    private static final int WINDOW_POS_X = 200;
    private static final int WINDOW_POS_Y = 400;

    private SettingsWindow settingsWindow;
    private Map map;

    public GameWindow() {
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Tic Tac Toe");
//        setResizable(false);

        settingsWindow = new SettingsWindow(this);
        map = new Map(this);
        add(map, BorderLayout.CENTER);


//Панель с кнопками управления.
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,3));
        add(buttonsPanel, BorderLayout.SOUTH);

        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(e -> {
            startNewGame();
        });
        buttonsPanel.add(newGameButton);

        JButton settingsButton = new JButton("Настройки");
        buttonsPanel.add(settingsButton);
        settingsButton.addActionListener(e -> {
            settingsWindow.setVisible(true);
        });

        JButton exitButton = new JButton("Выход");
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        buttonsPanel.add(exitButton);


        setVisible(true);
    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
    public void startNewGame (){
        settingsWindow.acceptButtonPush();
    }
}
