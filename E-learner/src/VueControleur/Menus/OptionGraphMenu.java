package VueControleur.Menus;

import Modele.ModeleMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Cette classe représente la vue du menu des paramètres grapĥiques dans le cadre du patron de conception MVP.
 * On y retrouve dedans uniquement l'aspect graphique du menu.
 * Le menu des paramètres graphiques ne donne accès à aucun autre menu
 *
 * @author nolan
 */
public class OptionGraphMenu extends JFrame {
    /**
     * Élements graphiques
     */
    boolean isFullscreen;
    private ArrayList<JPanel> listButtons;

    private JPanel tabMenuContener;
    private Controlleur controlleur;

    private JPanel panelTitle;
    private JPanel contentPane;
    private Menus mainFrame;

    public OptionGraphMenu(ModeleMenu modele, Menus mainFrame){
        this.controlleur = new Controlleur(modele);
        this.mainFrame = mainFrame;
        this.isFullscreen = mainFrame.isUndecorated();

        initComponents();
    }

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
         *               1 - Relancer le menu Principal
         */
        public void actionToDo(int action){
            switch (action){
                case 1:
                    changeFullscreen();
                    break;
                case 2:
                    OptionGraphMenu.this.mainFrame.changeMenu("Options");
                    break;
            }

        }

        /**
         * Fonction permettant de passer d'une résolution sous forme de String à un tableau
         * @param resolution résolution sous la forme "@@@@|@@@@" OÙ @@@@ représente un entier et | représente un des caractères suivant :
         *                   X,x,*,(caractère espace)
         * @return Un tableau contenant dans l'ordre :la résolution selon l'axe des abscisse et la résolution selon l'axe des ordonnées
         */
        public String[] getUserResolution(String resolution){
            return resolution.split("\\*|X|x| ");
        }

        /**
         * Fonction permettant de vérifier si un tableau donné vérifie bien les conditions pour être accepté en tant que résolution
         * @param resolutionSplit résolution candidate
         * @return booléen indiquant si le candidat est valable ou non
         */
        public boolean checkResolution(String[] resolutionSplit){

            if (resolutionSplit.length != 2){
                return false;
            }
            try {
                Integer.parseInt(resolutionSplit[0]);
                Integer.parseInt(resolutionSplit[1]);
                return true;

            } catch (NumberFormatException e){
                return false;
            }

        }

        public void changeResolution(String resolutionUtil){
                String[] newResolution = getUserResolution(resolutionUtil);
                if(checkResolution(newResolution)){
                    OptionGraphMenu.this.mainFrame.setSize(new Dimension(Integer.parseInt(newResolution[0]),Integer.parseInt(newResolution[1])));
                }
        }

        public void changeFullscreen(){
            OptionGraphMenu.this.mainFrame.dispose();
            Menus newFrame = new Menus(!isFullscreen);
            newFrame.changeMenu("Graphiques");
        }
    }


    /**
     * Cette fonction permet d'initialiser la vue du menu des paramètres graphiques
     */
    protected void initComponents() {

        listButtons = new ArrayList<JPanel>();
        panelTitle = createTitlePanel();
        contentPane = (JPanel) this.getContentPane();

        listButtons.add(createComponent("Résolution",new JTextField()));
        listButtons.add(createComponent("Plein Ecran",new JButton()));

        tabMenuContener = createMenuButtonList();

        contentPane.add(panelTitle, BorderLayout.NORTH);
        contentPane.add(tabMenuContener, BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if(!controlleur.menuModele.getFullscreen()){
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;
            this.setSize(screenWidth,screenHeight);
        }
        setLocationRelativeTo(null);
    }
    public JPanel createComponent(String name, JComponent component) {

        JLabel jName= new JLabel();
        jName.setBackground(new java.awt.Color(86, 109, 255));
        jName.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jName.setForeground(new java.awt.Color(255, 255, 255));
        jName.setText(name);
        jName.setAlignmentX(Component.CENTER_ALIGNMENT);
        jName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        component.setBackground(new java.awt.Color(102, 153, 255));
        component.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N

        JPanel nameAndComponent = new JPanel();
        nameAndComponent.setBackground(new java.awt.Color(102, 153, 255));
        nameAndComponent.add(jName);

        if(component instanceof JButton){
            JButton button = (JButton) component;
            button.setBackground(new java.awt.Color(102, 153, 255));
            button.setForeground(new java.awt.Color(255, 255, 255));
            button.setMinimumSize(new Dimension(200,80));
            button.setPreferredSize(new Dimension(200,80));
            button.setMaximumSize(new Dimension(100,60));
            button.setHorizontalAlignment(JButton.CENTER);
            button.setAlignmentX(JButton.CENTER_ALIGNMENT);
            if(isFullscreen) {
                button.setText("ON");
            } else {
                button.setText("OFF");
            }
            button.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    controlleur.actionToDo(1);
                }
            });
            nameAndComponent.add(button);
        } else{
            JTextField resolutionField = (JTextField) component;
            resolutionField.setFont(new java.awt.Font("Cantarell", 1, 24));
            resolutionField.setText(String.valueOf(this.mainFrame.getWidth()) + "*" + String.valueOf(this.mainFrame.getHeight()));
            resolutionField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OptionGraphMenu.this.controlleur.changeResolution(resolutionField.getText());
                }
            });
            nameAndComponent.add(resolutionField);
        }


        JPanel componentPanel = new JPanel();
        componentPanel.setBackground(new java.awt.Color(102, 204, 255));
        componentPanel.setLayout(new BoxLayout(componentPanel,BoxLayout.Y_AXIS));
        componentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        componentPanel.add(nameAndComponent);
        componentPanel.add(Box.createVerticalStrut(10));

        return componentPanel;
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
                controlleur.actionToDo(2);

            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jSeparator1.setPreferredSize(new java.awt.Dimension(500, 20));
        jSeparator1.setMaximumSize(new java.awt.Dimension(500, 20));

        menuTitle.setBackground(new java.awt.Color(86, 109, 255));
        menuTitle.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        menuTitle.setForeground(new java.awt.Color(255, 255, 255));
        menuTitle.setText("Options Graphiques");
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
