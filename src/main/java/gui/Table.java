package gui;

import gameLogic.pieces.Bishop;
import gameLogic.pieces.Knight;
import gameLogic.pieces.Rook;
import utils.GridComposer;
import utils.Position;
import utils.PositionTranslator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public final class Table {

    private final BoardPanel boardPanel;
    private final JFrame gameFrame;

    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);
    private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);
    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);

    private Color lightBoardTileColor = new Color(238, 221, 187);
    private Color darkBoardTileColor = new Color(204, 136, 68);
    private Color isAttacked1White = new Color(0,191,255);
    private Color isAttacked2White = new Color(30,144,250);
    private Color isAttacked3White = new Color(65,105,225);
    private Color isAttacked1Black = new Color(255,127,80);
    private Color isAttacked2Black = new Color(255,99,71);
    private Color isAttacked3Black = new Color(255,69,0);

    public Table() {
        this.gameFrame = new JFrame("JTimChess");
        this.gameFrame.setLayout(new BorderLayout());
        final JMenuBar tableMenuBar = createTableMenubar();
        this.gameFrame.setJMenuBar(tableMenuBar);
        this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
        this.boardPanel = new BoardPanel();
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        this.gameFrame.setVisible(true);
    }

    private JMenuBar createTableMenubar() {
        final JMenuBar tableMenuBar = new JMenuBar();
        tableMenuBar.add(createFileMenu());
        return tableMenuBar;
    }

    private JMenu createFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem openPGN = new JMenuItem("Load PGN File");

        openPGN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("open up that pgn file....");
            }
        });
        fileMenu.add(openPGN);

        final JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        return fileMenu;
    }

    private class BoardPanel extends JPanel {
        final List<TilePanel> boardTiles;

        BoardPanel() {
            super(new GridLayout(8, 8));
            this.boardTiles = new ArrayList<>();
            for (int i = 0; i < Position.values().length - 1; i++) {
                final TilePanel tilePanel = new TilePanel(this, i);
                this.boardTiles.add(tilePanel);
                add(tilePanel);
            }
            setPreferredSize(BOARD_PANEL_DIMENSION);
            validate();
        }
    }

    private class TilePanel extends JPanel {

        private final int tileId;

        TilePanel(final BoardPanel boardPanel, final int tileId) {
            super(new GridBagLayout());
            this.tileId = tileId;
            setPreferredSize(TILE_PANEL_DIMENSION);

            Rook testPiece = new Rook("white rook", Position.C6);
            Bishop testPiece2 = new Bishop("black Bishop", Position.A1);
            Knight testPiece3 = new Knight("black Knight", Position.G4);

            GridComposer testComposer = new GridComposer(testPiece.getPotentialMoves(),testPiece2.getPotentialMoves());
            GridComposer testComposer2 = new GridComposer(testComposer.getComposedGrid(),testPiece3.getPotentialMoves());

            assignTileColorFromGrid(testComposer2.getComposedGrid());
            validate();

        }

        private void assignTileColorFromGrid(int[][] pattern) {

            PositionTranslator guiMapper = new PositionTranslator(null, null, null, tileId);
            int positionValue = pattern[guiMapper.getColumnInLogicGrid()][guiMapper.getRowInLogicGrid()];

              if(positionValue == 1){
                  setBackground(isAttacked1White);
              }
              else if(positionValue == 2){
                  setBackground(isAttacked2White);
              }
              else if (positionValue == 3){
                  setBackground(isAttacked3White);
              }
            else if(positionValue == -1){
                setBackground(isAttacked1Black);
            }
            else if(positionValue == -2){
                setBackground(isAttacked2Black);
            }
            else if (positionValue == -3){
                setBackground(isAttacked3Black);
            }
              else{
                  if(((tileId-tileId%8)/8)%2 == 0){
                      if(tileId%2==0)setBackground(lightBoardTileColor);
                      if(tileId%2==1)setBackground(darkBoardTileColor);
                  }
                  if(((tileId-tileId%8)/8)%2 == 1){
                      if(tileId%2==1)setBackground(lightBoardTileColor);
                      if(tileId%2==0)setBackground(darkBoardTileColor);
                  }
              }
        }
    }
}

