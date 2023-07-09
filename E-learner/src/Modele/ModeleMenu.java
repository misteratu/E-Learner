package Modele;

/**
 * Cette classe est le modèle du Menu dans le cadre du patron de conception MVC.Elle contient l'état des éléments propres au menu
 * tel que la résolution le plein écran ou encore l'utilisateur
 *
 * @author Nolan
 *
 *
 */
public class ModeleMenu {

    private String utilisateur;
    private boolean fullscreen;
    private int xresolution;
    private int yresolution;
    private boolean isParent;

    private double generalLevelSound;
    private double musicLevelSound;

    public ModeleMenu() {
        this.utilisateur = "Guest";
        this.fullscreen = false;
        this.xresolution = 1080;
        this.yresolution = 720;
        this.isParent = false;
        this.generalLevelSound = 100;
        this.musicLevelSound = 100;
    }

    public ModeleMenu(String utilisateur, boolean fullscreen, int xresolution, int yresolution, boolean isParent, double generalLevelSound, double musicLevelSound) {
        this.utilisateur = utilisateur;
        this.fullscreen = fullscreen;
        this.xresolution = xresolution;
        this.yresolution = yresolution;
        this.isParent = isParent;
        this.generalLevelSound = generalLevelSound;
        this.musicLevelSound = musicLevelSound;
    }





    public double getGeneralLevelSound() {
        return generalLevelSound;
    }

    public void setGeneralLevelSound(double generalLevelSound) {
        this.generalLevelSound = generalLevelSound;
    }

    public double getMusicLevelSound() {
        return musicLevelSound;
    }

    public void setMusicLevelSound(double musicLevelSound) {
        this.musicLevelSound = musicLevelSound;
    }

    public boolean getFullscreen() {
        return fullscreen;
    }

    public int getXresolution() {
        return xresolution;
    }

    public int getYresolution() {
        return yresolution;
    }

    public String getUtilisateur(){
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public void setXresolution(int xresolution) {
        this.xresolution = xresolution;
    }

    public void setYresolution(int yresolution) {
        this.yresolution = yresolution;
    }
}
