package UI;

import Simulation.Objects.MetaObjects.MetaObject;
import Simulation.Objects.MetaObjects.Moveable.MetallBallMeta;
import Simulation.Objects.MetaObjects.Static.PlankMeta;
import UI.Controls.TabElement;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;

public class EditorTabPane {

    private MetaObject draggedObject;
    private boolean isDragging = false;

    public TabPane buildTabPane () {
        //initializing TabPane Element and Tabs
        TabPane objChooser = new TabPane ();
        objChooser.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        //tabs
        Tab balls = new Tab ("Balls");
        Tab blocks = new Tab ("Blocks");
        objChooser.getTabs().addAll(balls, blocks);

        //set tab content
        ScrollPane ballScroller = new ScrollPane();
        balls.setContent(ballScroller);
        ScrollPane blockScroller = new ScrollPane();
        blocks.setContent(blockScroller);

        //define elements in tab content
        defineBalls(ballScroller);
        defineBlocks(blockScroller);

        //return fully build TabPane to UI
        return objChooser;
    }

    private void defineBalls (ScrollPane content) {
        //define TabElements as MetaObjects
        TabElement metalBall = new TabElement (new MetallBallMeta("Metal Ball", "file:res/Images/metalBall.png", 20, 5, 255, 255, 255));

        //add TabElements to content
        HBox ballContent = new HBox (10);
        ballContent.setAlignment(Pos.CENTER_LEFT);
        //add elements here
        ballContent.getChildren().addAll(metalBall);

        //adding contents to scrollPane
        content.setContent(ballContent);

        //Drag Events
        metalBall.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            System.out.print("Drag started-");
            draggedObject = metalBall.getMetaObject();
            isDragging=true;
        });
    }

    private void defineBlocks (ScrollPane content) {
        //define TabElements as MetaObjects
        TabElement woodenPlank = new TabElement(new PlankMeta("Wooden Plank", "file:res/Images/woodenPlank.png", 50, 100, 0, 255, 0));

        //add TabElements to content
        HBox blockContent = new HBox (10);
        blockContent.setAlignment(Pos.CENTER_LEFT);
        //add elements here
        blockContent.getChildren().addAll(woodenPlank);

        //adding contents to scrollPane
        content.setContent(blockContent);

        //Drag Events
        woodenPlank.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            draggedObject = woodenPlank.getMetaObject();
            isDragging=true;
        });
    }

    public MetaObject getDraggedObject () {
        return draggedObject;
    }

    public boolean isDragging () {
        return isDragging;
    }

    public void resetDrag () {
        draggedObject = null;
        isDragging = false;
    }
}
