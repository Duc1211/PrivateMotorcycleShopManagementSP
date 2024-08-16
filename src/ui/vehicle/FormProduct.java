package ui.vehicle;

import format.other.Card;
import format.panel.PanelBorder;
import model.CardModel;

import javax.swing.*;
import java.awt.*;

public class FormProduct extends JPanel {
    private Card cardBMW, cardDucati, cardHarley, cardHonda, cardKawasaki, cardKymco, cardPiaggio;
    private Card cardSuzuki, cardSYM, cardTriumph, cardVinfast, cardYamaha;
    private JLayeredPane panel;
    private PanelBorder panelBorder;

    public FormProduct(){
        setBackground(Color.WHITE);
        initComponent();
        init();
    }
    private void init (){

        cardBMW.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/BMW/bmw.png")), "BMW", "9", ""));
        cardDucati.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Ducati/ducati.png")), "Ducati", "13", ""));
        cardHarley.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Harley Davidson/harley.png")), "Harley Davidson", "13", ""));
        cardHonda.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Honda/honda.png")), "Honda", "26", ""));
        cardKawasaki.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Kawasaki/kawasaki.png")), "Kawasaki", "9", ""));
        cardKymco.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Kymco/kymco.png")), "Kymco", "7", ""));
        cardPiaggio.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Piaggio/piaggio.png")), "Piaggio", "14", ""));
        cardSuzuki.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Suzuki/suzuki.png")), "Suzuki", "9", ""));
        cardSYM.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/SYM/sym.png")), "SYM", "8", ""));
        cardTriumph.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Triumph/triumph.png")), "Triumph", "26", ""));
        cardVinfast.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Vinfast/vinfast.png")), "Vinfast", "5", ""));
        cardYamaha.setData(new CardModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Yamaha/yamaha.png")), "Yamaha", "27", ""));
    }
    private void initComponent(){
        panel = new JLayeredPane();
        cardBMW = new Card();
        cardKymco = new Card();
        cardDucati = new Card();
        cardHarley = new Card();
        cardHonda = new Card();
        cardKawasaki = new Card();
        cardPiaggio = new Card();
        cardSuzuki = new Card();
        cardSYM = new Card();
        cardTriumph = new Card();
        cardVinfast = new Card();
        cardYamaha = new Card();
        panelBorder = new PanelBorder();

        panel.setLayout(new GridLayout(3, 0, 10, 10));


        cardHarley.setColor1(new Color(234, 209, 99));
        cardHarley.setColor2(new Color(201, 167, 11));
        panel.add(cardHarley);

        cardKawasaki.setColor1(new Color(35, 180, 104));
        cardKawasaki.setColor2(new Color(22, 77, 47));
        panel.add(cardKawasaki);

        cardBMW.setColor1(new Color(62, 187, 241));
        cardBMW.setColor2(new Color(61, 166, 211));
        panel.add(cardBMW);

        cardDucati.setColor1(new Color(225, 88, 88));
        cardDucati.setColor2(new Color(225, 11, 63));
        panel.add(cardDucati);

        cardTriumph.setColor1(new Color(154, 62, 241));
        cardTriumph.setColor2(new Color(121, 61, 211));
        panel.add(cardTriumph);

        cardHonda.setColor1(new Color(47, 47, 47));
        cardHonda.setColor2(new Color(0, 0, 0));
        panel.add(cardHonda);

        cardYamaha.setColor1(new Color(216, 246, 82));
        cardYamaha.setColor2(new Color(211, 184, 61));
        panel.add(cardYamaha);

        cardKymco.setColor1(new Color(113, 241, 62));
        cardKymco.setColor2(new Color(86, 183, 47));
        panel.add(cardKymco);

        cardPiaggio.setColor1(new Color(151, 234, 214));
        cardPiaggio.setColor2(new Color(61, 211, 198));
        panel.add(cardPiaggio);

        cardVinfast.setColor1(new Color(241, 143, 62));
        cardVinfast.setColor2(new Color(211, 119, 61));
        panel.add(cardVinfast);

        cardSYM.setColor1(new Color(186, 123, 247));
        cardSYM.setColor2(new Color(167, 94, 236));
        panel.add(cardSYM);

        cardSuzuki.setColor1(new Color(192, 192, 192));
        cardSuzuki.setColor2(new Color(128,128,128));
        panel.add(cardSuzuki);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(panelBorder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(panelBorder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
        );




    }


}
