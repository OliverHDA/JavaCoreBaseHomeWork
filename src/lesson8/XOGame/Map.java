package lesson8.XOGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;

    private int cellHeight;
    private int cellWidth;
    private int gameMode;
    private char playerDot = Logic.DOT_X;

    private boolean isInit = false;

    private GameWindow gameWindow;
    public static final int MODE_P_V_C = 0;
    public static final int MODE_P_V_P = 1;

    public Map(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(new Color(0x87F2FF));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (!Logic.isFinished) {
                    update(e);
                } else {
                    gameWindow.startNewGame();
                }
            }
        });
    }

    private void update(MouseEvent e) {
        if (!isInit) {
            gameWindow.startNewGame();
        }
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!Logic.isFinished) {
            Logic.playerCoordinate(cellX, cellY, playerDot);
        }
        if (!Logic.isFinished && gameMode == MODE_P_V_C && Logic.isStep) {
            Logic.aiTurn();
        }
        if (gameMode == MODE_P_V_P && playerDot == Logic.DOT_X && Logic.isStep) {
            playerDot = Logic.DOT_O;
        } else if (gameMode == MODE_P_V_P && playerDot == Logic.DOT_O && Logic.isStep) {
            playerDot = Logic.DOT_X;
        }

        repaint();
        if (Logic.isWin(Logic.DOT_X)) {
            JOptionPane.showMessageDialog(null, "Крестики победили!");
        } else if (Logic.isWin(Logic.DOT_O)) {
            JOptionPane.showMessageDialog(null, "Нолики победили!");
        }else if (Logic.isMapFull()) {
            JOptionPane.showMessageDialog(null, "Ничья!");
        }
    }

    @Override
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSizeX;
        cellHeight = panelHeight / fieldSizeY;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }

            }
        }
        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }

            }
        }

        if (Logic.isWin(Logic.DOT_X)) {
            drawWinLine(g, Logic.x1, Logic.y1, Logic.x2, Logic.y2);
        }
        if (Logic.isWin(Logic.DOT_O)) {
            drawWinLine(g, Logic.x1, Logic.y1, Logic.x2, Logic.y2);
        }

    }

    private void drawO(Graphics gr, int cellX, int cellY) {
        Graphics2D g = (Graphics2D) gr;
        BasicStroke pen1 = new BasicStroke(3);
        g.setStroke(pen1);
        g.setColor(new Color(198, 82, 80));
        g.drawOval(cellX * cellWidth, cellY * cellHeight, cellWidth, cellHeight);
    }

    private void drawX(Graphics gr, int cellX, int cellY) {
        Graphics2D g = (Graphics2D) gr;
        BasicStroke pen1 = new BasicStroke(3);
        g.setStroke(pen1);
        g.setColor(new Color(0, 0, 0));
        g.drawLine(cellX * cellWidth, cellY * cellHeight, (cellX + 1) * cellWidth, (cellY + 1) * cellHeight);
        g.drawLine(cellX * cellWidth, (cellY + 1) * cellHeight, (cellX + 1) * cellWidth, cellY * cellHeight);
    }

    private void drawWinLine(Graphics gr, int cellX1, int cellY1, int cellX2, int cellY2) {
        Graphics2D g = (Graphics2D) gr;
        BasicStroke pen1 = new BasicStroke(7);
        g.setStroke(pen1);
        g.setColor(new Color(0xB975B6));
        g.drawLine(cellX1 * cellWidth + cellWidth / 2, cellY1 * cellHeight + cellHeight / 2, cellX2 * cellWidth + cellWidth / 2, cellY2 * cellHeight + cellHeight / 2);
    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        this.gameMode = gameMode;
        isInit = true;
        repaint();
    }
}
