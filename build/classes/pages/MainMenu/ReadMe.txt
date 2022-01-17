/*

================ Background in AnchorPane ========

    how to set Background in MainMenu Page
1. Go to MainMenu.fxml and Open SceneBuilder
2. Left Hand, Go to Hierarchy -> AnchorPane (Back Largest), Then Click
3. Right Hand, Go to Properties -> JavaFX CSS -> Style
4. Set Style
    Left Column             :   Right Column
    -fx-background-image    :   url("assets/MainMenu/#nameImage")

================ Detail of Button ================

    < How to set Image in Button >
1. Go to ManMenu_Controller.java
2. Find "initialize" Function
3. add "shapeFillImage" Function in try{}catch(){}
#

    < How to set Cursor in Button >
1. Go to MainMenu.fxml and Open SceneBuilder
2. Click Rectangle Button
3. Right Hand, Go to Properties -> Node -> Cursor
4. Set Cursor : HAND
#

    < How to set on mouse entered and exited in button >
        * Create Function in Controller File*
1. Go to ManMenu_Controller.java
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
1. Go to MainMenu.fxml and Open SceneBuilder
2. Click Rectangle Button
3. Right Hand, Go to Code -> Mouse -> On Mouse Entered
4. Set name Function : onMouseEntered
5. Right Hand, Go to Code -> Mouse -> On Mouse Exited
6. Set name Function : onMouseExited
7. Save and Close SceneBuilder
#

*/