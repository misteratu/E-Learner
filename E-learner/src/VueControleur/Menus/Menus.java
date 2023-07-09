package VueControleur.Menus;

import Modele.ModeleMenu;

import javax.swing.*;
import java.awt.*;

public class Menus extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public Menus(boolean fullscreen) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setUndecorated(fullscreen);
        this.setSize(new Dimension(screenWidth,screenHeight));

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        createMenus();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        cardLayout.show(cardPanel,"Principal");
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void createMenus(){
        JPanel menuPrincipal = (JPanel) (new Menuprincipale(new ModeleMenu(),this)).getContentPane();
        cardPanel.add(menuPrincipal, "Principal");

        JPanel niveaux = (JPanel) (new Niveaux(new ModeleMenu(),this)).getContentPane();
        cardPanel.add(niveaux, "Niveaux");

        JPanel cp = (JPanel) (new CP(new ModeleMenu(),this)).getContentPane();
        cardPanel.add(cp, "CP");

        JPanel ce1 = (JPanel) (new CE1(new ModeleMenu(),this)).getContentPane();
        cardPanel.add(ce1, "CE1");

        JPanel ce2 = (JPanel) (new CE2(new ModeleMenu(),this)).getContentPane();
        cardPanel.add(ce2, "CE2");

        JPanel cm1 = (JPanel) (new CM1(new ModeleMenu(),this)).getContentPane();
        cardPanel.add(cm1, "CM1");

        JPanel cm2 = (JPanel) (new CM2(new ModeleMenu(),this)).getContentPane();
        cardPanel.add(cm2, "CM2");

        JPanel options = (JPanel) (new OptionMenu(new ModeleMenu(),this)).getContentPane();
        cardPanel.add(options, "Options");

        JPanel graphiques = (JPanel) (new OptionGraphMenu(new ModeleMenu(),this)).getContentPane();
        cardPanel.add(graphiques, "Graphiques");

        JPanel sonores = (JPanel) (new OptionSonoreMenu(new ModeleMenu(),this)).getContentPane();
        cardPanel.add(sonores, "Sonores");
    }

    public void changeMenu(String name){
        cardLayout.show(cardPanel,name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menus example = new Menus(false);
        });
    }
}
