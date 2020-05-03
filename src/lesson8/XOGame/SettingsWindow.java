package lesson8.XOGame;

import javax.swing.*;
import java.awt.*;


public class SettingsWindow extends JFrame {

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 20;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MAX_WIN_LENGTH = 8;


    private JRadioButton radioBPlayerVersusPlayer;
    private JRadioButton radioBPlayerVersusAI;
    private JRadioButton radioBAIVersusAI;
    private ButtonGroup gameMode;

    private JSlider sliderFieldSize;
    private JSlider sliderWinLength;

    private GameWindow gameWindow;

    public SettingsWindow(GameWindow gameWindow) {


        this.gameWindow = gameWindow;
        setBounds(gameWindow.getBounds().x + 50, gameWindow.getBounds().y + 50, (gameWindow.getBounds().width - 100), (gameWindow.getBounds().height - 100));
        setResizable(false);
        setTitle("Настройки");

        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new GridLayout(10, 1));
        add(choicePanel, BorderLayout.CENTER);
//Режим игры
        choicePanel.add(new JLabel("Выберите режим игры:"));
        radioBPlayerVersusAI = new JRadioButton("Игрок против Компьютера", true);
        radioBPlayerVersusPlayer = new JRadioButton("Игрок против Игрока");
        gameMode = new ButtonGroup();
        gameMode.add(radioBPlayerVersusAI);
        gameMode.add(radioBPlayerVersusPlayer);
        choicePanel.add(radioBPlayerVersusAI);
        choicePanel.add(radioBPlayerVersusPlayer);

//Размер поля
        choicePanel.add(new JLabel("Выберите размер поля:"));
        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        choicePanel.add(sliderFieldSize);
        sliderFieldSize.setMajorTickSpacing(1);
        sliderFieldSize.setPaintLabels(true);
        sliderFieldSize.setPaintTicks(true);

        sliderFieldSize.addChangeListener(e -> {
            int fieldSize = sliderFieldSize.getValue();
            sliderWinLength.setMaximum(fieldSize);
            if (fieldSize > MAX_WIN_LENGTH) {
                sliderWinLength.setMaximum(MAX_WIN_LENGTH);
            }
            if (fieldSize > MIN_WIN_LENGTH) {
                sliderWinLength.setMinimum(MIN_WIN_LENGTH + 1);
            }
        });

//Длинна победной линии
        choicePanel.add(new JLabel("Выберите длинну победной линии:"));
        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        choicePanel.add(sliderWinLength);
        sliderWinLength.setMajorTickSpacing(1);
        sliderWinLength.setPaintLabels(true);
        sliderWinLength.setPaintTicks(true);

// Кнопки управления
        JPanel controlButtons = new JPanel();
        controlButtons.setLayout(new GridLayout(1, 2));
        add(controlButtons, BorderLayout.SOUTH);

        JButton accept = new JButton("Принять");
        accept.addActionListener(e -> {
            acceptButtonPush();
            setVisible(false);
        });
        controlButtons.add(accept);

        JButton abort = new JButton("Отмена");
        abort.addActionListener(e -> {
            setVisible(false);
        });
        controlButtons.add(abort);

        setVisible(false);
    }

    public void acceptButtonPush() {
        int gameMode;
        if (radioBPlayerVersusAI.isSelected()) {
            gameMode = Map.MODE_P_V_C;
        } else {
            gameMode = Map.MODE_P_V_P;
        }
        int fieldSize = sliderFieldSize.getValue();
        int winLength = sliderWinLength.getValue();

        Logic.SIZE = fieldSize;
        Logic.DOTS_TO_WIN = winLength;
        Logic.initMap();
        Logic.isFinished = false;

        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
    }
}
