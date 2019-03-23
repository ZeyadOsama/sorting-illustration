package illustrations;

import sorting.Sorting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

public class Illustration extends JPanel {

    private static final int NUM_OF_ITEMS = 25;
    private static final int DIM_W = 450;
    private static final int DIM_H = 450;
    private static final int HORIZON = 450;
    private static final int VERTICAL_INC = 15;
    private static final int HORIZONTAL_INC = DIM_W / NUM_OF_ITEMS;
    private static final int TIME_DELAY = 150;

    private JButton btnStart;
    private JButton btnReset;
    private JComboBox<String> comboBoxChoices;

    private Timer timer;

    private String[] sortingTechniques = {Sorting.BUBBLE_SORT, Sorting.SELECTION_SORT};
    private String SORTING_TECHNIQUE = sortingTechniques[0];
    private Integer[] list;
    private int currentIndex = NUM_OF_ITEMS - 1;

    public Illustration() {
        list = initList();

        timer = new Timer(TIME_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isSortingDone()) {
                    ((Timer) e.getSource()).stop();
                    btnStart.setEnabled(false);
                } else {
                    list = Sorting.sortOneTime(SORTING_TECHNIQUE, list, currentIndex);
                    currentIndex--;
                }

                repaint();
            }
        });

        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnStart.setBackground(Color.RED);
                btnStart.setEnabled(false);
                timer.start();
            }
        });

        btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                list = initList();
                currentIndex = NUM_OF_ITEMS - 1;
                repaint();
                btnStart.setEnabled(true);
            }
        });

        comboBoxChoices = new JComboBox<>(sortingTechniques);
        comboBoxChoices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SORTING_TECHNIQUE = String.valueOf(comboBoxChoices.getSelectedItem());
                System.out.println(SORTING_TECHNIQUE);
            }
        });

        add(btnStart);
        add(btnReset);
        add(comboBoxChoices);
    }

    private boolean isSortingDone() {
        return currentIndex == 0;
    }

    private Integer[] initList() {
        Integer[] generatedList = new Integer[NUM_OF_ITEMS];

        for (int i = 0; i < generatedList.length; i++) {
            generatedList[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(generatedList));
        return generatedList;
    }

    private void drawItem(Graphics g, int item, int index) {
        int height = item * VERTICAL_INC;
        int y = HORIZON - height;
        int x = index * HORIZONTAL_INC;
        g.fillRect(x, y, HORIZONTAL_INC, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < list.length; i++) {
            drawItem(g, list[i], i);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DIM_W, DIM_H);
    }
}