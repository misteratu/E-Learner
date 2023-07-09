package VueControleur.Menus;

import Modele.ModeleMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Cette classe représente la vue du menu des paramètres sonores dans le cadre du patron de conception MVP.
 * On y retrouve dedans uniquement l'aspect graphique du menu.
 * Le menu des paramètres sonores ne donne accès à aucun autre menu
 *
 * @author nolan
 */
public class OptionSonoreMenu extends JFrame {

    private ArrayList<JPanel> listButtons;

    private JPanel tabMenuContener;
    private Controlleur controlleur;

    private JPanel panelTitle;
    private JPanel contentPane;

    private Menus mainFrame;

    public OptionSonoreMenu(ModeleMenu modele, Menus mainFrame) {
        this.controlleur = new Controlleur(modele);
        this.mainFrame = mainFrame;
        initComponents();
    }

    /**
     * Cette fonction permet d'initialiser la vue du menu des paramètres audio
     */

    public class Controlleur {
        /**
         * attribut jouant le rôle de modèle dans le cadre du patron de conception MVC
         */
        ModeleMenu menuModele;

        /**
         * Constructeur permettant d'initialiser le controlleur
         *
         * @param menuModele classe jouant le rôle de modèle dans le cadre du patron de conception MVC
         */
        public Controlleur(ModeleMenu menuModele) {
            this.menuModele = menuModele;
        }

        /**
         * @param action entier désignant l'action à faire
         *               1 - Relancer le menu Principal
         */
        public void actionToDo(int action) {
            switch (action) {
                case 1:
                    OptionSonoreMenu.this.mainFrame.changeMenu("Options");
                    break;
            }
        }

    }

    /**
     * Cette fonction permet d'initialiser la vue du menu des paramètres graphiques
     */
    protected void initComponents() {

        listButtons = new ArrayList<JPanel>();
        panelTitle = createTitlePanel();
        contentPane = (JPanel) this.getContentPane();

        listButtons.add(createComponent("Volume              ", new JSlider()));
        listButtons.add(createComponent("Effets sonores   ", new JSlider()));
        listButtons.add(createComponent("Voix                   ", new JSlider()));
        listButtons.add(createComponent("Musique            ", new JSlider()));

        tabMenuContener = createMenuButtonList();

        contentPane.add(panelTitle, BorderLayout.NORTH);
        contentPane.add(tabMenuContener, BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }

    public JPanel createComponent(String name, JSlider slider) {

        JLabel jName = new JLabel();
        jName.setBackground(new java.awt.Color(86, 109, 255));
        jName.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jName.setForeground(new java.awt.Color(255, 255, 255));
        jName.setText(name);
        jName.setAlignmentX(Component.CENTER_ALIGNMENT);
        jName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        slider.setBackground(new java.awt.Color(255, 255, 255));
        slider.setForeground(new java.awt.Color(102, 102, 255));

        JPanel nameAndComponent = new JPanel();
        nameAndComponent.setBackground(new java.awt.Color(102, 153, 255));
        nameAndComponent.add(jName);
        nameAndComponent.add(slider);

        JPanel componentPanel = new JPanel();
        componentPanel.setBackground(new java.awt.Color(102, 204, 255));
        componentPanel.setLayout(new BoxLayout(componentPanel, BoxLayout.Y_AXIS));
        componentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        componentPanel.add(nameAndComponent);
        componentPanel.add(Box.createVerticalStrut(10));

        return componentPanel;
    }

    public JPanel createMenuButtonList() {
        JPanel tabMenu = new JPanel();
        JPanel jPanelButtons = new JPanel();
        JPanel jPanelButtonsContainer = new JPanel();

        tabMenu.setBackground(new java.awt.Color(102, 204, 255));
        jPanelButtons.setBackground(new java.awt.Color(102, 204, 255));
        jPanelButtonsContainer.setBackground(new java.awt.Color(102, 204, 255));

        for (JPanel button : listButtons) {
            jPanelButtons.add(button);
        }
        jPanelButtons.setLayout(new BoxLayout(jPanelButtons, BoxLayout.Y_AXIS));
        tabMenu.add(Box.createVerticalGlue());
        tabMenu.add(jPanelButtons);
        tabMenu.add(Box.createVerticalGlue());
        tabMenu.setBorder(BorderFactory.createTitledBorder("demo"));
        tabMenu.setLayout(new BoxLayout(tabMenu, BoxLayout.Y_AXIS));

        jPanelButtonsContainer.setLayout(new BorderLayout());
        jPanelButtonsContainer.add(jPanelButtons, BorderLayout.NORTH);

        return jPanelButtonsContainer;

    }

    public JPanel createTitlePanel() {
        JPanel jPanelTitle = new javax.swing.JPanel();
        JLabel gameTitle = new javax.swing.JLabel();
        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JLabel menuTitle = new javax.swing.JLabel();
        jPanelTitle.setBackground(new java.awt.Color(102, 204, 255));
        gameTitle.setFont(new java.awt.Font("Cantarell Extra Bold", 1, 48)); // NOI18N
        gameTitle.setForeground(new java.awt.Color(86, 109, 255));
        gameTitle.setText("E-learning");
        gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                controlleur.actionToDo(1);

            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jSeparator1.setPreferredSize(new java.awt.Dimension(500, 20));
        jSeparator1.setMaximumSize(new java.awt.Dimension(500, 20));

        menuTitle.setBackground(new java.awt.Color(86, 109, 255));
        menuTitle.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        menuTitle.setForeground(new java.awt.Color(255, 255, 255));
        menuTitle.setText("Options Sonores");
        menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanelTitle.setBorder(new EmptyBorder(50, 10, 100, 10));
        jPanelTitle.add(gameTitle);
        jPanelTitle.add(jSeparator1);
        jPanelTitle.add(menuTitle);
        jPanelTitle.setLayout(new BoxLayout(jPanelTitle, BoxLayout.Y_AXIS));

        return jPanelTitle;
    }

}