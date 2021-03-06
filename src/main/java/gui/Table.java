package gui;

import gameLogic.analyzationTools.tacticAnalyzers.AttackAnalyzer;
import gameLogic.pieces.Piece;
import utils.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Table {

    private final BoardPanel boardPanel;
    private final JFrame gameFrame;

    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);
    private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);
    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
    private static String defaultPieceImagesPath = "art/simple/";

    private ChessField sourceTile;
    private ChessField destinationTile;
    private Piece humanMovedPiece;


    public Board board;

    private Color lightBoardTileColor = new Color(238, 221, 187);
    private Color darkBoardTileColor = new Color(204, 136, 68);
    private Color isAttacked1White = new Color(0,191,255);
    private Color isAttacked2White = new Color(30,144,250);
    private Color isAttacked3White = new Color(65,105,225);
    private Color isAttacked4White = new Color(51,51,255);
    private Color isAttacked5White = new Color(0,0,255);
    private Color isAttacked6White = new Color(0,0,204);
    private Color isAttacked7White = new Color(0,0,153);
    private Color isAttacked8White = new Color(0,0,102);
    private Color isAttacked9White = new Color(0,0,75);
    private Color isAttacked1Black = new Color (255,135,75);    //(178,255,102);//(255,127,80);
    private Color isAttacked2Black = new Color (255,100,85);    //(153,255,51);//(255,99,71);
    private Color isAttacked3Black = new Color (255,80,20);    //(128,255,0);//(255,69,0);
    private Color isAttacked4Black = new Color (255,50,20);    //(51,255,51);
    private Color isAttacked5Black = new Color (255,0,0);    //(0,255,0);
    private Color isAttacked6Black = new Color (205,0,0);    //(0,204,0);
    private Color isAttacked7Black = new Color (155,0,0);    //(0,153,0);
    private Color isAttacked8Black = new Color (105,0,0);    //(0,105,0);
    private Color isAttacked9Black = new Color (75,0,0);    //(0,75,0);


    public Table(Board board) {
        InitializeGame newGame = new InitializeGame();
        this.board = board;
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

            AttackAnalyzer attackAnalyzer = new AttackAnalyzer(board.getActivePiecesFromFields());
           assignTileColorFromGrid(attackAnalyzer.getCompositionGrid());
            //assignTileColorEmptyBoard();
            assignTilePieceIcon(board);

            addMouseListener(new MouseListener() {
               @Override
                public void mouseClicked(MouseEvent mouseEvent) {
 /*
                  //  if(isRightMouseButton(event)){

                        if(sourceTile == null){
                            sourceTile = board

                        }
                    //}else if (isLeftMouseButton(event)){

                    }*/
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {

                }
            });
            validate();

        }

        private void assignTilePieceIcon(final Board board){
            this.removeAll();
            PositionTranslator fieldGuiTranslator = new PositionTranslator(null,null,null,this.tileId);
            if(board.getChessfield(fieldGuiTranslator.getHumanReadablePosition()).getIsOccupiedBy() != null){
                try {
                    final BufferedImage image = ImageIO.read(new File(defaultPieceImagesPath + board.getChessfield(fieldGuiTranslator.getHumanReadablePosition()).getIsOccupiedBy().getName()+".gif") );
                add(new JLabel(new ImageIcon(image)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void assignTileColorEmptyBoard(){

            if(((tileId-tileId%8)/8)%2 == 0){
                if(tileId%2==0)setBackground(lightBoardTileColor);
                if(tileId%2==1)setBackground(darkBoardTileColor);
            }

            if(((tileId-tileId%8)/8)%2 == 1){
                if(tileId%2==1)setBackground(lightBoardTileColor);
                if(tileId%2==0)setBackground(darkBoardTileColor);
            }
        }

        private void assignTileColorFromGrid(int[][] pattern) {

            PositionTranslator guiMapper = new PositionTranslator(null, null, null, tileId);
            int positionValue = pattern[guiMapper.getColumnInLogicGrid()][guiMapper.getRowInLogicGrid()];

            for (int j = 7; j > -1; j--) {
                for (int i = 0; i < 8; i++) {
                    System.out.print(pattern[i][j]);
                }
                System.out.println();
            }


              if(positionValue == 1){
                  setBackground(isAttacked1White);
              }
              else if(positionValue == 2){
                  setBackground(isAttacked2White);
              }
              else if (positionValue == 3){
                  setBackground(isAttacked3White);
              }
              else if(positionValue == 4){
                    setBackground(isAttacked4White);
              }
              else if (positionValue == 5){
                    setBackground(isAttacked5White);
              }
              else if(positionValue == 6){
                  setBackground(isAttacked6White);
              }
              else if (positionValue == 7){
                  setBackground(isAttacked7White);
              }
              else if(positionValue == 8){
                  setBackground(isAttacked8White);
              }
              else if (positionValue == 9){
                  setBackground(isAttacked9White);
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
              else if(positionValue == -4){
                  setBackground(isAttacked4Black);
              }
              else if (positionValue == -5){
                  setBackground(isAttacked5Black);
              }
              else if(positionValue == -6){
                  setBackground(isAttacked6Black);
              }
              else if (positionValue == -7){
                  setBackground(isAttacked7Black);
              }
              else if(positionValue == -8){
                  setBackground(isAttacked8Black);
              }
              else if (positionValue == -9){
                  setBackground(isAttacked9Black);
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

