
package Geo;
import VueControleur.Menus.Menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class ExempleBoutonForme extends JFrame {

    Controlleur control;
    JLabel texteLabel;
    JLabel texteLabel1;
    JLabel texteLabel2;

    public ExempleBoutonForme() {
        this.control = new Controlleur("Géo", "CE1");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initComponent();

            }
        });
    }

    public void initComponent() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600)); // Définit la taille de la fenêtre

        // Création d'un JLayeredPane pour superposer les composants
        JLayeredPane layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);

        // Chargement de l'image de la carte
        ImageIcon mapIcon = new ImageIcon(getClass().getResource("./Geo/CarteVilles.png"));
        JLabel mapLabel = new JLabel(mapIcon);
        mapLabel.setBounds(0, 0, mapIcon.getIconWidth(), mapIcon.getIconHeight());
        layeredPane.add(mapLabel, JLayeredPane.DEFAULT_LAYER);

        // Création des boutons

        List<JButton> boutons = new ArrayList<JButton>();
        for(int i=0; i<30; i++){
            boutons.add(new JButton(){
                @Override
                protected void paintComponent(Graphics g) {
                    if (getModel().isArmed()) {
                        g.setColor(Color.GREEN);
                    } else if (getModel().isRollover()) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(Color.BLUE);
                    }
                    Graphics2D g2 = (Graphics2D) g;
                    g2.fill(getCircleShape());
                }

                @Override
                public boolean contains(int x, int y) {
                    return getCircleShape().contains(x, y);
                }
            });
        }

        texteLabel = new JLabel(control.requestQuestion());
        texteLabel.setFont(new Font("Serif", Font.BOLD, 20));
        texteLabel.setBounds(10, 1, 600, 100);
        layeredPane.add(texteLabel, JLayeredPane.PALETTE_LAYER);

        texteLabel1 = new JLabel("Numéro de la question : " + Integer.toString(control.requestNbQuestion()));
        texteLabel1.setFont(new Font("Serif", Font.BOLD, 20));
        texteLabel1.setBounds(700, 10, 600, 20);
        layeredPane.add(texteLabel1, JLayeredPane.PALETTE_LAYER);

        texteLabel2 = new JLabel("Nombre de bonnes réponses : " + Integer.toString(control.requestNbBonneQuestion()));
        texteLabel2.setFont(new Font("Serif", Font.BOLD, 20));
        texteLabel2.setBounds(10, 1, 400, 20);
        layeredPane.add(texteLabel2, JLayeredPane.PALETTE_LAYER);



        // Gestionnaire d'événements pour le clic sur le bouton de Caen
        boutons.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Caen");
                control.actionToDo("Caen");
                update();

            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Le Havre
        boutons.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Le Havre");
                control.actionToDo("Le Havre");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Rouen
        boutons.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Rouen");
                control.actionToDo("Rouen");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Lille
        boutons.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Lille");
                control.actionToDo("Lille");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Reims
        boutons.get(4).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Reims");
                control.actionToDo("Reims");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Metz
        boutons.get(5).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Metz");
                control.actionToDo("Metz");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Nancy
        boutons.get(6).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Nancy");
                control.actionToDo("Nancy");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Strasbourg
        boutons.get(7).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Strasbourg");
                control.actionToDo("Strasbourg");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Paris
        boutons.get(8).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Paris");
                control.actionToDo("Paris");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Brest
        boutons.get(9).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Brest");
                control.actionToDo("Brest");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Rennes
        boutons.get(10).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Rennes");
                control.actionToDo("Rennes");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Le Mans
        boutons.get(11).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Le Mans");
                control.actionToDo("Le Mans");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Orléans
        boutons.get(12).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Orleans");
                control.actionToDo("Orleans");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Dijon
        boutons.get(13).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Dijon");
                control.actionToDo("Dijon");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Angers
        boutons.get(14).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Angers");
                control.actionToDo("Angers");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Nantes
        boutons.get(15).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Nantes");
                control.actionToDo("Nantes");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Tours
        boutons.get(16).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Tours");
                control.actionToDo("Tours");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Limoges
        boutons.get(17).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Limoges");
                control.actionToDo("Limoges");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Clermont-Ferrand
        boutons.get(18).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Clermont-Ferrand");
                control.actionToDo("Clermont-Ferrand");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton St-Etienne
        boutons.get(19).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("St-Etienne");
                control.actionToDo("St-Etienne");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Lyon
        boutons.get(20).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Lyon");
                control.actionToDo("Lyon");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Grenoble
        boutons.get(21).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Grenoble");
                control.actionToDo("Grenoble");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Bordeaux
        boutons.get(22).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Bordeaux");
                control.actionToDo("Bordeaux");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Toulouse
        boutons.get(23).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Toulouse");
                control.actionToDo("Toulouse");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Montpellier
        boutons.get(24).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Montpellier");
                control.actionToDo("Montpellier");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Arlès
        boutons.get(25).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Arles");
                control.actionToDo("Arles");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Marseille
        boutons.get(26).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Marseille");
                control.actionToDo("Marseille");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Toulon
        boutons.get(27).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Toulon");
                control.actionToDo("Toulon");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Nice
        boutons.get(28).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Nice");
                control.actionToDo("Nice");
                update();
            }
        });

        // Gestionnaire d'événements pour le clic sur le bouton Perpignan
        boutons.get(29).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour le clic sur le bouton
                System.out.println("Perpignan");
                control.actionToDo("Perpignan");
                update();
            }
        });

        // Définition de la taille des boutons
        int buttonSize = 30;


        // Coordonnées des boutons

        // Bouton Caen
        int x = 355;
        int y = 255;

        // Bouton Le Havre
        int x2 = 400;
        int y2 = 215;

        // Bouton Rouen
        int x3 = 460;
        int y3 = 220;

        // Bouton Lille
        int x4 = 605;
        int y4 = 105;

        // Bouton Reims
        int x5 = 675;
        int y5 = 250;

        // Bouton Metz
        int x6 = 825;
        int y6 = 260;

        // Bouton Nancy
        int x7 = 835;
        int y7 = 300;

        // Bouton Strasbourg
        int x8 = 950;
        int y8 = 310;

        // Bouton Paris
        int x9 = 550;
        int y9 = 280;

        // Bouton Brest
        int x10 = 55;
        int y10 = 320;

        // Bouton Rennes
        int x11 = 260;
        int y11 = 360;

        // Bouton Le Mans
        int x12 = 395;
        int y12 = 375;

        // Bouton Orléans
        int x13 = 510;
        int y13 = 375;

        // Bouton Dijon
        int x14 = 745;
        int y14 = 435;

        // Bouton Angers
        int x15 = 340;
        int y15 = 420;

        // Bouton Nantes
        int x16 = 258;
        int y16 = 450;

        // Bouton Tours
        int x17 = 430;
        int y17 = 435;

        // Bouton Limoges
        int x18 = 470;
        int y18 = 590;

        // Bouton Clermont-Ferrand
        int x19 = 605;
        int y19 = 595;

        // Bouton St-Etienne
        int x20 = 703;
        int y20 = 617;

        // Bouton Lyon
        int x21 = 740;
        int y21 = 600;

        // Bouton Grenoble
        int x22 = 795;
        int y22 = 645;

        // Bouton Bordeaux
        int x23 = 337;
        int y23 = 687;

        // Bouton Toulouse
        int x24 = 485;
        int y24 = 797;

        // Bouton Montpellier
        int x25 = 670;
        int y25 = 800;

        // Bouton Arlès
        int x26 = 738;
        int y26 = 772;

        // Bouton Marseille
        int x27 = 785;
        int y27 = 820;

        // Bouton Toulon
        int x28 = 820;
        int y28 = 840;

        // Bouton Nice
        int x29 = 915;
        int y29 = 788;

        // Bouton Perpignan
        int x30 = 600;
        int y30 = 880;

        // Position des boutons
        boutons.get(0).setBounds(x, y, buttonSize, buttonSize);
        boutons.get(1).setBounds(x2, y2, buttonSize, buttonSize);
        boutons.get(2).setBounds(x3, y3, buttonSize, buttonSize);
        boutons.get(3).setBounds(x4, y4, buttonSize, buttonSize);
        boutons.get(4).setBounds(x5, y5, buttonSize, buttonSize);
        boutons.get(5).setBounds(x6, y6, buttonSize, buttonSize);
        boutons.get(6).setBounds(x7, y7, buttonSize, buttonSize);
        boutons.get(7).setBounds(x8, y8, buttonSize, buttonSize);
        boutons.get(8).setBounds(x9, y9, buttonSize, buttonSize);
        boutons.get(9).setBounds(x10, y10, buttonSize, buttonSize);
        boutons.get(10).setBounds(x11, y11, buttonSize, buttonSize);
        boutons.get(11).setBounds(x12, y12, buttonSize, buttonSize);
        boutons.get(12).setBounds(x13, y13, buttonSize, buttonSize);
        boutons.get(13).setBounds(x14, y14, buttonSize, buttonSize);
        boutons.get(14).setBounds(x15, y15, buttonSize, buttonSize);
        boutons.get(15).setBounds(x16, y16, buttonSize, buttonSize);
        boutons.get(16).setBounds(x17, y17, buttonSize, buttonSize);
        boutons.get(17).setBounds(x18, y18, buttonSize, buttonSize);
        boutons.get(18).setBounds(x19, y19, buttonSize, buttonSize);
        boutons.get(19).setBounds(x20, y20, buttonSize, buttonSize);
        boutons.get(20).setBounds(x21, y21, buttonSize, buttonSize);
        boutons.get(21).setBounds(x22, y22, buttonSize, buttonSize);
        boutons.get(22).setBounds(x23, y23, buttonSize, buttonSize);
        boutons.get(23).setBounds(x24, y24, buttonSize, buttonSize);
        boutons.get(24).setBounds(x25, y25, buttonSize, buttonSize);
        boutons.get(25).setBounds(x26, y26, buttonSize, buttonSize);
        boutons.get(26).setBounds(x27, y27, buttonSize, buttonSize);
        boutons.get(27).setBounds(x28, y28, buttonSize, buttonSize);
        boutons.get(28).setBounds(x29, y29, buttonSize, buttonSize);
        boutons.get(29).setBounds(x30, y30, buttonSize, buttonSize);


        // Ajout des boutons sur le panel
        layeredPane.add(boutons.get(0), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(1), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(2), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(3), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(4), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(5), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(6), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(7), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(8), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(9), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(10), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(11), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(12), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(13), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(14), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(15), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(16), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(17), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(18), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(19), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(20), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(21), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(22), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(23), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(24), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(25), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(26), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(27), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(28), JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutons.get(29), JLayeredPane.PALETTE_LAYER);

        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(new Dimension(screenWidth,screenHeight));
        setVisible(true);
    }

    private Shape getCircleShape() {
        int buttonSize = 30;
        int diameter = buttonSize - 10; // Réduire le diamètre du cercle par 10 pixels pour créer une bordure visible
        int x = 5; // Ajouter une marge de 5 pixels pour la bordure
        int y = 5;
        return new Ellipse2D.Double(x, y, diameter, diameter);
    }

    public void update() {
        if(this.control.isFinish() == true){
            this.dispose();
            Menus example = new Menus(false);
        }
        texteLabel.setText(control.requestQuestion());
        texteLabel1.setText("Numéro de la question : " + Integer.toString(control.requestNbQuestion()));
        texteLabel2.setText("Nombre de bonnes réponses : " + Integer.toString(control.requestNbBonneQuestion()));
    }

}