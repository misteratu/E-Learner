package VueControleur.MiniJeux;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;

import Modele.MiniJeux.ModeleQuizz;
import Modele.ModeleMenu;
import VueControleur.Menus.Menus;
import VueControleur.MiniJeux.QuizzUtils.*;

import org.json.simple.parser.ParseException;

import VueControleur.Menus.Menuprincipale;
import VueControleur.Menus.Niveaux;
import VueControleur.Menus.OptionMenu;

import java.util.Arrays;

public class Quizz extends javax.swing.JFrame {
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private Controlleur controlleur;


    /**
     * Constructer du Quizz
     */
    public Quizz(String matiere ,String niveau) {
        this.controlleur = new Controlleur(matiere,niveau);
        initComponents();
        this.setVisible(true);
    }

    public class Controlleur {


        int bonBouton; // Numéro du bon bouton (réponse correcte).

        ModeleQuizz modele; // Instance du modèle utilisé pour la gestion du jeu.

        List<String> listeQuestionBoutton = new ArrayList<>();

        int indexMatiere; // Index de la question dans la matière sélectionnée.



        /**
         * Constructeur de la classe Controlleur.
         * @param matiere la matière du quizz.
         * @param niveau le niveau du quizz.
         */
        public Controlleur(String matiere, String niveau) {
            super();
            modele = new ModeleQuizz(matiere, niveau, 10, 10);
            choixNumeroQuestion();
            modele.addToPreviousQ(indexMatiere);
            affectation();
        }

        /**
         * Méthode pour lancer le quizz.
         */
        public void lancerQuizz() {
            boolean repondu = true;
            while (modele.getCurrentQuestionNb() <= modele.getTotalQuestionNb()) {
                if (repondu) {

                    choixNumeroQuestion();

                    modele.addToPreviousQ(indexMatiere);
                    affectation();
                    repondu = false;
                } else if (true) { // Condition bouton
                    actionToDo(1);
                    listeQuestionBoutton.clear();
                    repondu = true;
                }
            }
        }

        /**
         * Méthode pour choisir le numéro de la question en fonction de la matière et du niveau.
         * Met à jour l'index de la matière.
         */
        public void choixNumeroQuestion() {
            Generateur generateur = new Generateur();
            String matiere = modele.getMatiere();
            String niveau = modele.getLevel();

            // Sélection de la matière
            switch (matiere) {
                case "histoire":
                    switch (niveau) {
                        case "CE1":
                            generateur = new Generateur(1, 54);
                            break;
                        case "CM1":
                            generateur = new Generateur(55, 81);
                            break;
                        case "CM2":
                            generateur = new Generateur(81, 104);
                            break;
                    }
                    break;
                case "geographie":
                    generateur = new Generateur(1, 44);
                    break;
                case "Français":
                    switch (niveau) {
                        case "CP":
                            generateur = new Generateur(1, 52);
                            break;
                        case "CE1":
                            generateur = new Generateur(53, 70);
                            break;
                        case "CE2":
                            generateur = new Generateur(71, 101);
                            break;
                        case "CM1":
                            generateur = new Generateur(102, 132);
                            break;
                        case "CM2":
                            generateur = new Generateur(133, 163);
                            break;
                    }
                    break;
                case "science":
                    switch (niveau) {
                        case "CM1":
                            generateur = new Generateur(1, 48);
                            break;
                        case "CM2":
                            generateur = new Generateur(49, 79);
                            break;
                    }
                    break;

            }
            // Génération d'un numéro de question unique à partir du générateur
            indexMatiere = generateur.generateRandomNumber(modele.getToPreviousQ());
        }

        /**
         * Méthode pour effectuer la récupération des questions et réponses en fonction de la matière.
         * Met à jour les données du modèle.
         */
        public String[] recuperation() {
            // Initialisation des variables de question, réponse et autres réponses par défaut
            String question = "coucou";
            String reponse = "coucou";
            String[] autresReponses = new String[] {"Coucou", "Coucou", "Coucou"};
            String matiere = modele.getMatiere();

            // Sélection de la matière et récupération des questions et réponses correspondantes
            switch (matiere) {
                case "histoire":
                    try {
                        QuestionsReponsesHistoire qrHistoire = new QuestionsReponsesHistoire();
                        question = qrHistoire.getQuestionHistoire(indexMatiere);
                        reponse = qrHistoire.getBonneReponseHistoire(indexMatiere);
                        autresReponses = qrHistoire.getReponsesHistoire(indexMatiere);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "science":
                    try {
                        QuestionsReponsesSciences qrSciences = new QuestionsReponsesSciences();
                        question = qrSciences.getQuestionSciences(indexMatiere);
                        reponse = qrSciences.getBonneReponseSciences(indexMatiere);
                        autresReponses = qrSciences.getReponsesSciences(indexMatiere);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Français":
                    try {
                        QuestionsReponsesFrançais qrFrancais = new QuestionsReponsesFrançais();
                        question = qrFrancais.getQuestionFrançais(indexMatiere);
                        reponse = qrFrancais.getBonneReponseFrançais(indexMatiere);
                        autresReponses = qrFrancais.getReponsesFrançais(indexMatiere);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("IO");


                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("Parse");
                    }
                    break;
                case "geographie":
                    try {
                        QuestionsReponsesGeographie qrGeographie = new QuestionsReponsesGeographie();
                        question = qrGeographie.getQuestionGeographie(indexMatiere);
                        reponse = qrGeographie.getBonneReponseGeographie(indexMatiere);
                        autresReponses = qrGeographie.getReponsesGeographie(indexMatiere);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
            }

            // Récupération de la question et des réponses possibles.
            String[]questionReponses = new String[] {question, reponse, autresReponses[0], autresReponses[1], autresReponses[2]};
            return questionReponses;
        }

        /**
         * Méthode pour effectuer les affectations des boutons et des réponses.
         */

        public void affectation() {
            List<Integer> indexBoutonReponses = new ArrayList<>();
            String[] reponses = recuperation();
            int numeroJsonQuestion;

            // Ajout de la numérotation des questions à la liste
            indexBoutonReponses.add(1);
            indexBoutonReponses.add(2);
            indexBoutonReponses.add(3);
            indexBoutonReponses.add(4);

            // Génération d'un index aléatoire
            Random random = new Random();
            int randomIndex = random.nextInt(indexBoutonReponses.size());

            for (int i = 1; i <= 4; i++) {
                randomIndex = random.nextInt(indexBoutonReponses.size());
                numeroJsonQuestion = indexBoutonReponses.get(randomIndex);
                //System.out.println("Numéro d'une des réponses de la question" + numeroJsonQuestion);
                listeQuestionBoutton.add(reponses[numeroJsonQuestion]);
                //System.out.println(reponses[numeroJsonQuestion]);
                indexBoutonReponses.remove(randomIndex);
            }
            System.out.println(reponses[0]);
            printList(listeQuestionBoutton);

            bonBouton = listeQuestionBoutton.indexOf(reponses[1]);

        }


        /**
         * Méthode pour exécuter l'action correspondant à un bouton cliqué.
         *
         * @param i Le numéro du bouton cliqué.
         */
        public void actionToDo(int i) {
            // Vérification si le bouton cliqué est le bon bouton
            if (i == bonBouton) {
                // Incrémentation du nombre de bonnes réponses
                modele.setCorrectAnswerNb(modele.getCorrectAnswerNb() + 1);
            } else {
                // Affichage du message "Faux"
            }

            // Incrémentation du nombre de questions courantes
            if (modele.getCurrentQuestionNb() + 1 > modele.getTotalQuestionNb()){
                Quizz.this.dispose();
                new Menus(false);
            }else {
                modele.setCurrentQuestionNb(modele.getCurrentQuestionNb() + 1);
                listeQuestionBoutton.clear();
                choixNumeroQuestion();
                modele.addToPreviousQ(indexMatiere);
                affectation();
            }
        }

        public static void printList(List<?> list) {
            int i = 0;
            for (Object element : list) {
                //System.out.println("Case : " + i + " : "+ element);
                i++;
            }
        }

        public String requestText(int numeroBoutton) {
            return listeQuestionBoutton.get(numeroBoutton);
        }

        public String requestQuestion() {
            String[] liste = recuperation();
            return liste[0];
        }

        public int requestNbBonneQuestion() {
            return modele.getCorrectAnswerNb();
        }

        public int requestNbQuestion() {
            return modele.getCurrentQuestionNb();
        }

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Color bgColor = new java.awt.Color(101, 146, 253);
        Color fgColor = new java.awt.Color(95, 89, 247);
        Color textColor = new java.awt.Color(75, 246, 255);
        Color btnColor = new java.awt.Color(52, 48, 144);
        Color btnTextColor = new java.awt.Color(75, 246, 255);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1165, 684));
        setResizable(false);

        jPanel1.setBackground(bgColor);

        jLabel3.setFont(new java.awt.Font("L M Mono Caps10", 0, 36)); // NOI18N
        jLabel3.setText(Integer.toString(controlleur.requestNbQuestion()));
        jLabel3.setForeground(textColor);

        jLabel1.setFont(new java.awt.Font("L M Mono Caps10", 0, 36)); // NOI18N
        jLabel1.setForeground(textColor);
        jLabel1.setText(Integer.toString(controlleur.requestNbBonneQuestion()));


        jPanel3.setBackground(fgColor);

        jButton4.setText(convertToHTML(controlleur.requestText(1)));
        jButton4.setFont(new java.awt.Font("Lato Light", 1, 18));

        jButton4.setPreferredSize(new java.awt.Dimension(300, 100));
        jButton4.setForeground(btnTextColor);
        jButton4.setBackground(btnColor);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlleur.actionToDo(1);
                updateView();
            }
        });

        jButton5.setPreferredSize(new java.awt.Dimension(300, 100));
        jButton5.setFont(new java.awt.Font("Lato Light", 1, 18));
        jButton5.setForeground(btnTextColor);
        jButton5.setBackground(btnColor);
        jButton5.setText(convertToHTML(controlleur.requestText(2)));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlleur.actionToDo(2);
                updateView();
            }
        });

        jButton2.setPreferredSize(new java.awt.Dimension(300, 100));
        jButton2.setFont(new java.awt.Font("Lato Light", 1, 18));
        jButton2.setForeground(btnTextColor);
        jButton2.setBackground(btnColor);
        jButton2.setText(convertToHTML(controlleur.requestText(3)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlleur.actionToDo(3);
                updateView();
            }
        });

        jButton3.setFont(new java.awt.Font("Lato Light", 1, 18));
        jButton3.setText(convertToHTML(controlleur.requestText(0)));
        jButton3.setToolTipText("");
        jButton3.setHideActionText(true);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setForeground(btnTextColor);
        jButton3.setBackground(btnColor);
        jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton3.setMaximumSize(new java.awt.Dimension(300, 100));
        jButton3.setMinimumSize(new java.awt.Dimension(300, 100));
        jButton3.setPreferredSize(new java.awt.Dimension(300, 100));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlleur.actionToDo(0);
                updateView();
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("L M Mono Caps10", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(convertToHTML(controlleur.requestQuestion()));
        jLabel4.setForeground(textColor);
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(56, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(jLabel3)))
                                .addGap(121, 121, 121)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(59, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap(547, Short.MAX_VALUE)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(124, 124, 124)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    /**
     * Fonction permettant de convertir une phrase en HTML. Le but principal de cette fonction est de pouvoir mettre un JLabel sur plusieurs lignes dans un JButton
     * @param entry String à convertir
     * @return Le String avec des balises HTML
     */
    public String convertToHTML(String entry){
        int i = 1;
        String[] splitted = entry.split(" ");
        String retour = "<html>";
        while(i <= splitted.length){
            if(i % 8 != 0){
                retour = retour + " " + splitted[i-1];
            } else {
                retour = retour + " " + splitted[i-1];
            }
            i++;
        }
        retour = retour +  "</html>";
        return retour;
    }

    public void updateView(){
        jLabel4.setText(convertToHTML(controlleur.requestQuestion()));
        jButton3.setText(convertToHTML(controlleur.requestText(0)));
        System.out.println(controlleur.requestText(0));
        System.out.println(controlleur.requestText(1));
        System.out.println(controlleur.requestText(2));
        System.out.println(controlleur.requestText(3));
        jButton4.setText(convertToHTML(controlleur.requestText(1)));
        jButton5.setText(convertToHTML(controlleur.requestText(2)));
        jButton2.setText(convertToHTML(controlleur.requestText(3)));
        jLabel1.setText(Integer.toString(controlleur.requestNbQuestion()));
        jLabel3.setText(Integer.toString(controlleur.requestNbBonneQuestion()));

    }






}

