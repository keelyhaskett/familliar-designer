
import ecs100.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.io.*;
/**
 * Write a description of class game_panel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class game_panel
{
    public static double choiceBoxSize = 140;
    public static double choiceX = 327;
    public static double choice1Y = 132;
    public static double choice2Y = 322;
    public static double choice3Y = 537;
    // instance variables - replace the example below with your own
    private String option1;
    private String option2;
    private String option3;
    private double mouseX;
    private double mouseY;
    private String image1;
    private String image2;
    private String image3;
    private String picked;
    private int choice;
    private boolean initial = true;
    private boolean pickedOutfit = false;
    private boolean activate = false;
    private boolean go = false;
    private boolean end = false;
    private BufferedImage img = null;

    public void startGame() {
        draw();
        initialPicker();
    }

    /**
     * Start section for the choices
     */
    public void initialPicker() {
        option1 = "Cat";
        option2 = "Frog";
        option3 = "Crow";
        image1 = "c";
        image2 = "f";
        image3 = "b";
        draw();

    }

    /**
     * choices for cat
     */
    public void pickedCat() {
        option1 = "White";
        option2 = "Black";
        option3 = "Ginger";
        image1 = "c1";
        image2 = "c2";
        image3 = "c3";
        draw();
    }

    /**
     * choices for crow
     */
    public void pickedCrow() {
        option1 = "Black";
        option2 = "Red";
        option3 = "White";
        image1 = "b1";
        image2 = "b2";
        image3 = "b3";
        draw();
    }

    /**
     * choices for frog
     */
    public void pickedFrog() {
        option1 = "Brown";
        option2 = "Green";
        option3 = "Purple";
        image1 = "f1";
        image2 = "f2";
        image3 = "f3";
        draw();
    }

    public void branchedFrom1() {
        if (!pickedOutfit) {
            if (picked.contains("c")) {
                option1 = "Bowtie";
                option2 = "Cape";
                option3 = "Crown";
                image1 ="c11";
                image2 = "c12";
                image3 = "c13";
                draw();
                pickedOutfit = true;
            }
            else if (picked.contains("f")) {
                option1 = "Hat";
                option2 = "Makeup";
                option3 = "Stars";
                image1 = "f11";
                image2 = "f12";
                image3 = "f13";
                draw();
                pickedOutfit = true;
            }
            else if (picked.contains("b")) {
                option1 = "Apron";
                option2 = "Backpack";
                option3 = "Tie";
                image1 = "b11";
                image2 = "b12";
                image3 = "b13";
                draw();
                pickedOutfit = true;
            }
        }
        else {
            option1 = "Night";
            option2 = "Day";
            option3 = null;
            image2 = image1 + "1";
            image1 += "2";
            image3 = null;
            draw();
            activate = true;
        }
    }

    public void branchedFrom2() {
        if (!pickedOutfit) {
            if (picked.contains("c")) {
                option1 = "Raincoat";
                option2 = "Scarf";
                option3 = "Witch Hat";
                image1 = "c21";
                image2 = "c22";
                image3 = "c23";
                draw();
                pickedOutfit = true;
            }
            else if (picked.contains("f")) {
                option1 = "Cowboy";
                option2 = "Miku";
                option3 = "Uniform";
                image1 = "f21";
                image2 = "f22";
                image3 = "f23";
                draw();
                pickedOutfit = true;
            }
            else if (picked.contains("b")) {
                option1 = "Hat";
                option2 = "Glasses";
                option3 = "Necklace";
                image1 = "b21";
                image2 = "b22";
                image3 = "b23";
                draw();
                pickedOutfit = true;
            }
        }
        else {
            option1 = "Night";
            option2 = "Day";
            option3 = null;
            image1 = image2 + "2";
            image2 += "1";
            image3 = null;
            draw();
            activate = true;
        }
    }

    public void branchedFrom3() {
        if (!pickedOutfit) {
            if (picked.contains("c")) {
                option1 = "Boots";
                option2 = "Dinosaur";
                option3 = "Suit";
                image1 = "c31";
                image2 = "c32";
                image3 = "c33";
                draw();
                pickedOutfit = true;
            }
            else if (picked.contains("f")) {
                option1 = "Sweater";
                option2 = "Lei";
                option3 = "Suit";
                image1 = "f31";
                image2 = "f32";
                image3 = "f33";
                draw();
                pickedOutfit = true;
            }
            else if (picked.contains("b")) {
                option1 = "Friend";
                option2 = "Earmuffs";
                option3 = "Sunglasees";
                image1 = "b31";
                image2 = "b32";
                image3 = "b33";
                draw();
                pickedOutfit = true;
            }
        }
        else {
            option1 = "Night";
            option2 = "Day";
            option3 = null;
            image1 = image3 + "2";
            image2 = image3 +"1";
            image3 = null;
            draw();
            activate = true;
        }
    }

    /**
     * enables user to save their friend if wants to
     */
    public void save() {
        try {
            // retrieve image
            BufferedImage image = img;
            String name = UIFileChooser.save("Save your friend?");
            File outputfile = new File(name);
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
        }

    }

    public void load() {
        try {
            img = ImageIO.read(new File(picked + ".png"));
        } catch (IOException e) {
        }
    }

    /**
     * checks if the current mouse click is on one of the 'buttons'
     */
    public boolean checkClick(double x1, double y1, double x2, double y2) {
        if (mouseX > x1 && mouseX < x2 && mouseY > y1 && mouseY < y2) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * draw method
     */
    public void draw() {
        UI.drawImage("setup.png",0,0,1000,750);
        if (option1 != null) {
            UI.setColor(Color.white);
            UI.setFontSize(60);
            if (option3 != null) {
                UI.drawString(option3, 40, 607);
            }
            UI.drawString(option2, 40, 402);
            UI.drawString(option1, 40, 212);
            UI.drawImage(image1 + ".png", 347, 152, 100, 100);
            UI.drawImage(image2 + ".png", 347, 342, 100, 100);
            if (image3 != null) {
                UI.drawImage(image3 + ".png", 347, 557, 100, 100);
            }
        }
        if (picked != null) {
            UI.drawImage(picked + ".png", 690, 280, 250, 250);
        }

    }

    public void drawFinish() {
        UI.drawImage("bgfinish.png",0,0,1000,750);
        UI.fillRect(343, 253, 304, 304);
        UI.drawImage(picked + ".png", 345, 255, 300, 300);
    }

    /**
     * what to do when clicked
     */
    public void doMouse(String a, double x, double y) {
        if (a.equals("released")) {
            mouseX = x;
            mouseY = y;
            if (!end) {
                if (checkClick(choiceX, choice1Y, choiceX + choiceBoxSize, choice1Y + choiceBoxSize)) {
                    picked = image1;
                    choice = 1;
                    if (activate) {
                        go = true;
                    }
                }
                else if (checkClick(choiceX, choice2Y, choiceX + choiceBoxSize, choice2Y + choiceBoxSize)) {
                    picked = image2;
                    choice = 2;
                    if (activate) {
                        go = true;
                    }
                } 
                else if (checkClick(choiceX, choice3Y, choiceX + choiceBoxSize, choice3Y + choiceBoxSize)) {
                    if (image3 != null) {
                        picked = image3;
                        choice = 3;
                    }
                }
                else if (checkClick(840, 700, 940, 740)) {
                    if (initial) {
                        initial = false;
                        if (choice == 1) {
                            pickedCat();
                        }
                        else if (choice == 2) {
                            pickedFrog();
                        }
                        else if (choice == 3) {
                            pickedCrow();
                        }
                    }
                    else if (go) {
                        drawFinish();
                        end = true;
                        return;
                    }
                    else {
                        if (choice == 1) {
                            branchedFrom1();
                        }
                        else if (choice == 2) {
                            branchedFrom2();
                        }
                        else if (choice == 3) {
                            branchedFrom3();
                        }
                    }
                }
                draw();
            }
            else {
                if (checkClick(375, 630, 625, 465)) {
                    load();
                    save();
                }
            }
        }
    }

    public static void main(String[] arguments){
        game_panel pan = new game_panel();
        UI.initialise();
        UI.setMouseListener(pan::doMouse);
        UI.setDivider(0);
        UI.setWindowSize(1000,750);
        UI.addButton("Start", pan::startGame);
        UI.addButton("Quit", UI::quit);
    }
}
