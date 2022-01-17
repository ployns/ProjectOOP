/*

================ Background in AnchorPane ========

    < How to set Background in Start.fxml Page >
1. Go to Start.fxml and Open SceneBuilder
2. Left Hand, Go to Hierarchy -> AnchorPane (Back Largest), Then Click
3. Right Hand, Go to Properties -> JavaFX CSS -> Style
4. Set Style
    Left Column             :   Right Column
    -fx-background-image    :    url("assets/Start/#nameImage")

    < How to set Background in Mode_1.fxml >
1. Go to Mode_1.fxml and Open SceneBuilder
2. Left Hand, Go to Hierarchy -> StackPane -> Pane (fx:id = PaneMode_1), Then Click
3. Right Hand, Go to Properties -> JavaFX CSS -> Style
4. Set Style
    Left Column             :   Right Column
    -fx-background-image    :   url("assets/Start/#nameImage")
    -fx-background-radius   :   50
    -fx-border-width        :   4
    -fx-border-radius       :   50
    -fx-border-color        :   black

================ Detail of Button ================

    < How to set Image in Button >
1. Go to Start_Controller.java (or other controller file)
2. Copy and Paste this code

    public void shapeFillImage(Shape shape, String pathImage) throws IOException{
//        shape.setFill(new ImagePattern(new Image(new FileInputStream(pathImage))));
        shape.setFill(new ImagePattern(new Image(pathImage)));
    }

3. Find "initialize" Function
4. add "shapeFillImage" Function in try{}catch(){}
#

    < How to set Cursor in Button >
1. Go to Start.fxml (or other controller file) and Open SceneBuilder
2. Click Rectangle Button
3. Right Hand, Go to Properties -> Node -> Cursor
4. Set Cursor : HAND
#

    < How to set on mouse entered and exited in button >
        * Create Function in Controller File *
1. Go to Start_Controller.java (or other controller file)
2. Copy and Paste this code

    @FXML
    void onMouseEntered(MouseEvent event) {
        Rectangle object = (Rectangle) event.getSource();
        object.setStroke(Color.YELLOW);
        object.setStrokeWidth(4);
    }

    @FXML
    void onMouseExited(MouseEvent event) {
        Rectangle object = (Rectangle) event.getSource();
        object.setStroke(Color.BLACK);
        object.setStrokeWidth(1);
    }
#
        * Connect Function in SceneBuilder *
1. Go to Start.fxml (or other controller file) and Open SceneBuilder
2. Click Rectangle Button
3. Right Hand, Go to Code -> Mouse -> On Mouse Entered
4. Set name Function : onMouseEntered
5. Right Hand, Go to Code -> Mouse -> On Mouse Exited
6. Set name Function : onMouseExited
7. Save and Close SceneBuilder
#

================ Animation Image ================

    < How to add Image How To Play >
1. Go to Mode_1_HowToPlay_Controller.java
2. Find "imageViews" Array
3. Add Image File in "imageViews" Array

    @FXML
    private final ImageView[] imageViews = {
            new ImageView("assets/Start/#nameImage1"),
            new ImageView("assets/Start/#nameImage2"),
            new ImageView("assets/Start/#nameimage3"),
            ...
    };
#
*/