package VueControleur.Menus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Modele.ModeleMenu;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Cette classe représente la vue du menu niveaux dans le cadre du patron de conception MVP.
 * On y retrouve dedans uniquement l'aspect graphique du menu.
 * Le menu des niveaux donne accès aux menu de chaque niveau scolaire du cycle primaire
 *
 * @author nolan
 */
public class Niveaux extends JFrame {

    private JPanel tabMenuContener;
    private Controlleur controlleur;
    private ArrayList<JPanel> listButtons;
    private JPanel panelTitle;
    private JPanel contentPane;

    private Menus mainFrame;
    
    public Niveaux(ModeleMenu module, Menus mainFrame) {
    	this.controlleur = new Controlleur(module);
        this.mainFrame = mainFrame;
    	initComponents();
    }
    
    /**
     * Classe interne jouant le role de contrôleur
     *
     *
     * 1 - Lancer les menus des différents menus
     * 2 - Revenir au Menu principal
     */
    public class Controlleur{
        /**
         *  attribut jouant le rôle de modèle dans le cadre du patron de conception MVC
         */
        ModeleMenu menuModele;

        /**
         * Constructeur permettant d'initialiser le controlleur
         * @param menuModele classe jouant le rôle de modèle dans le cadre du patron de conception MVC
         */
        private Controlleur(ModeleMenu menuModele) {
            this.menuModele = menuModele;
        }

        /**
         *
         * @param action entier désignant l'action à faire
         *               1 - Lancer le menu CP
         *               2 - Lancer le menu CE1
         *               3 - Lancer le menu CE2
         *               4 - Lancer le menu CM1
         *               5 - Lancer le menu CM2
         *               6 - Relancer le menu Principal
         */
        public void actionToDo(int action){
            switch (action){
                case 1:
                    Niveaux.this.mainFrame.changeMenu("CP");
                    break;
                case 2:
                    Niveaux.this.mainFrame.changeMenu("CE1");
                    break;
                case 3:
                    Niveaux.this.mainFrame.changeMenu("CE2");
                    break;
                case 4:
                    Niveaux.this.mainFrame.changeMenu("CM1");
                    break;
                case 5:
                    Niveaux.this.mainFrame.changeMenu("CM2");
                    break;
                case 6:
                    Niveaux.this.mainFrame.changeMenu("Principal");
                    break;
            }

        }
    }
    
    /**
     * Cette fonction permet d'initialiser la vue du menu des niveaux
     */
    protected void initComponents() {


        listButtons = new ArrayList<JPanel>();
        panelTitle = createTitlePanel();
        contentPane = (JPanel) this.getContentPane();

        listButtons.add(createButton("CP",1));
        listButtons.add(createButton("CE1",2));
        listButtons.add(createButton("CE2",3));
        listButtons.add(createButton("CM1",4));
        listButtons.add(createButton("CM2",5));

        tabMenuContener = createMenuButtonList();

        contentPane.add(panelTitle, BorderLayout.NORTH);
        contentPane.add(tabMenuContener, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public JPanel createButton(String name, int actionToDo) {
        JButton button = new JButton();

        button.setBackground(new java.awt.Color(102, 153, 255));
        button.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setMinimumSize(new Dimension(800,80));
        button.setPreferredSize(new Dimension(800,80));
        button.setMaximumSize(new Dimension(800,80));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setText(name);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlleur.actionToDo(actionToDo);
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new java.awt.Color(102, 204, 255));
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(button);
        buttonPanel.add(Box.createVerticalStrut(10));

        return buttonPanel;
    }
    public JPanel createMenuButtonList(){
        JPanel tabMenu = new JPanel();
        JPanel jPanelButtons = new JPanel();
        JPanel jPanelButtonsContainer = new JPanel();

        tabMenu.setBackground(new java.awt.Color(102, 204, 255));
        jPanelButtons.setBackground(new java.awt.Color(102, 204, 255));
        jPanelButtonsContainer.setBackground(new java.awt.Color(102, 204, 255));

        for(JPanel button : listButtons){
            jPanelButtons.add(button);
        }
        jPanelButtons.setLayout(new BoxLayout(jPanelButtons, BoxLayout.Y_AXIS));
        tabMenu.add(Box.createVerticalGlue());
        tabMenu.add(jPanelButtons);
        tabMenu.add(Box.createVerticalGlue());
        tabMenu.setBorder(BorderFactory.createTitledBorder("demo"));
        tabMenu.setLayout(new BoxLayout(tabMenu,BoxLayout.Y_AXIS));

        jPanelButtonsContainer.setLayout(new BorderLayout());
        jPanelButtonsContainer.add(jPanelButtons,BorderLayout.NORTH);

        return jPanelButtonsContainer;

    }
    public JPanel createTitlePanel(){
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
                controlleur.actionToDo(6);

            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jSeparator1.setPreferredSize(new java.awt.Dimension(500, 20));
        jSeparator1.setMaximumSize(new java.awt.Dimension(500, 20));

        menuTitle.setBackground(new java.awt.Color(86, 109, 255));
        menuTitle.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        menuTitle.setForeground(new java.awt.Color(255, 255, 255));
        menuTitle.setText("Jeux par niveaux");
        menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanelTitle.setBorder(new EmptyBorder(50,10,100,10));
        jPanelTitle.add(gameTitle);
        jPanelTitle.add(jSeparator1);
        jPanelTitle.add(menuTitle);
        jPanelTitle.setLayout(new BoxLayout(jPanelTitle,BoxLayout.Y_AXIS));

        return jPanelTitle;
    }

}
