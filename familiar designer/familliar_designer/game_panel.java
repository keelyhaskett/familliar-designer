

import ecs100.*;
/**
 * Write a description of class game_panel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class game_panel
{
    // instance variables - replace the example below with your own
    private String option1;
    private String option2;
    private String option3;
    
    public void startGame() {
        draw();
        initialPicker();
    }
    
    /**
     * Start section for the choices
     */
    public void initialPicker() {
        
    }
    
    /**
     * choices for cat
     */
    public void pickedCat() {
        
    }
    
    /**
     * choices for crow
     */
    public void pickedCrow() {
        
    }
    
    /**
     * choices for frog
     */
    public void pickedFrog() {
        
    }
    /**
     * enables user to save their friend if wants to
     */
    public void save() {
        
    }
    
    /**
     * draw method
     */
    public void draw() {
        UI.fillOval(10,50,20,20);
        UI.drawImage("setup.png",0,0,1000,750);
        UI.setColor(color.white);
    }
    
    public void doMouse(String a, double x, double y) {
        if (a.equals("released")) {
            
        }
    }
    
    
    public static void main(String[] arguments){
        game_panel obj = new game_panel();
        UI.initialise();
        UI.setMouseListener(obj::doMouse);
        UI.setDivider(0.0);
        UI.addButton("Start", obj::startGame);
        UI.addButton("Quit", UI::quit);
    }
}
