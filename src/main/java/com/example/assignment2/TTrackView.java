package com.example.assignment2;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class TTrackView extends StackPane implements TTrackModelSubscriber {

    Button start;
    Button stop;
    Button add;
    Button swap;
    Label current;
    Label cur_name;
    ListView<String> list;
    TextField field;
    Label name;
    Label name2;
    TextField field2;
    TTrackModel model;


    public TTrackView(){
        HBox root = new HBox();
        VBox bt = new VBox(10);
        HBox text = new HBox(4);
        HBox text2 = new HBox(2);
        HBox cur = new HBox(2);

        // set up the boxes
        start = new Button("Start");
        stop = new Button("Stop");
        add = new Button("Add project");
        swap = new Button("Swap projects");
        current = new Label("Current Project: ");
        cur_name = new Label();
        name = new Label("Name");
        field = new TextField();
        text.getChildren().addAll(name,field);
        name2 = new Label("Name");
        field2 = new TextField();
        text2.getChildren().addAll(name2,field2);
        list = new ListView<>();

        // add the boxes
        cur.getChildren().addAll(current,cur_name);
        bt.getChildren().addAll(start,stop,text,add,cur,text2,swap);
        bt.setAlignment(Pos.CENTER);
        root.getChildren().addAll(bt,list);
        HBox.setHgrow(root, Priority.ALWAYS);
        HBox.setHgrow(list, Priority.ALWAYS);
        this.getChildren().add(root);
    }

    public void setModel(TTrackModel model) {
        this.model = model;
        list.setItems(model.Sprojects);
    }

    public void setController(TTrackController controller){
        add.setOnAction(e -> controller.addProject(field.getText()));
        swap.setOnAction(e -> controller.swapProject(field2.getText()));
        start.setOnAction(controller::startTimer);
        stop.setOnAction(controller::stopTimer);
    }

    public void modelUpdated(){
        // This will be an update for the current label
        cur_name.setText(model.getCurrent());
        list.refresh();
    }
}
