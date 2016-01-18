package gui;

import game.GameManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.TextField;

public class Controller {

    public TextField field0;
    public TextField field1;
    public TextField field2;
    public TextField field3;
    public TextField field4;
    public TextField field5;
    public TextField field6;
    public TextField field7;
    public TextField field8;
    GameManager game = new GameManager();

    public void onMouseClick0(Event event) {doMove(0);}

    public void onMouseClick1(Event event) {doMove(1);}

    public void onMouseClick2(Event event) {doMove(2);}

    public void onMouseClick3(Event event) {doMove(3);}

    public void onMouseClick4(Event event) {doMove(4);}

    public void onMouseClick5(Event event) {doMove(5);}

    public void onMouseClick6(Event event)  {doMove(6);}

    public void onMouseClick7(Event event)  {doMove(7);}

    public void onMouseClick8(Event event)  {doMove(8);}

    public void doQuit(ActionEvent actionEvent) { Platform.exit(); }


    void doMove(int field){
        TextField[] fieldarr = {field0, field1, field2, field3, field4, field5, field6, field7, field8};
        //fieldarr[field].setText("X");
        game.theMove(field, fieldarr);
    }
}
