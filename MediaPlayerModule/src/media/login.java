package media;
import java.io.File;
import java.util.List;

import Utils.EventHandling;
import cn.itheima.media.MainApp;
import cn.itheima.utils.XMLUtils;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.MusicPlayerMainApp;

public class login {

    private Stage parentStage;// 父窗体
    public static Label labUserID;// 父窗体中显示用户昵称的Label对象
    private MusicPlayerMainApp musicPlayerMainApp;
    // 移动前的x,y坐标
    private double mouseX;
    private double mouseY;
    public static String userinfo;
    public static Label lab1;
    // 本窗体的舞台对象
    private Stage stage;

    public static void noNeedToLogin(){
        lab1.setText("");
    }
    public login(Stage parentStage, Label labUserID, MusicPlayerMainApp musicPlayerMainApp) {
        this.parentStage = parentStage;
        this.labUserID = labUserID;
        this.musicPlayerMainApp = musicPlayerMainApp;

        // 1.登录：Label
        lab1 = new Label("登录");
        lab1.setTextFill(Color.WHITE);
        lab1.setFont(new Font("黑体", 18));
        lab1.setPrefWidth(160);
        lab1.setPrefHeight(100);
        lab1.setLayoutX(120);
        lab1.setLayoutY(-30);
        // 绽放效果
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.5);
        lab1.setEffect(bloom);

        // 2.关闭按钮：ImageView
        ImageView v1 = new ImageView("img/topandbottom/closeDark.png");
        v1.setFitWidth(13);
        v1.setFitHeight(13);
        Label labClose = new Label("", v1);
        labClose.setMinWidth(13);
        labClose.setMinHeight(13);
        labClose.setPrefWidth(13);
        labClose.setPrefHeight(13);
        labClose.setLayoutX(270);
        labClose.setLayoutY(20);
        labClose.setOnMouseClicked(e -> {
            stage.hide();
        });

        // 3.文本框：TextField----用户名&密码
        TextField txtUserName = new TextField();
        txtUserName.setPromptText("请输入用户ID");
        txtUserName.setPrefWidth(220);
        txtUserName.setPrefHeight(15);
        txtUserName.setLayoutX(20);
        txtUserName.setLayoutY(70);

        TextField TextPassword = new TextField();
        TextPassword.setPromptText("请输入密码");
        TextPassword.setPrefWidth(220);
        TextPassword.setPrefHeight(15);
        TextPassword.setLayoutX(20);
        TextPassword.setLayoutY(120);

        // 4.提示标签：Label
        Label labMsg = new Label();
        labMsg.setPrefWidth(200);
        labMsg.setLayoutX(20);
        labMsg.setLayoutY(45);
        labMsg.setTextFill(Color.RED);

        // 5.取消按钮：Button
        Button butCancel = new Button("取消");
        butCancel.setPrefWidth(80);
        butCancel.setPrefHeight(30);
        butCancel.setLayoutX(150);
        butCancel.setLayoutY(190);
        butCancel.setTextFill(Color.WHITE);
        butCancel.setBackground(new Background(new BackgroundFill(Color.rgb(100, 100, 100), null, null)));
        butCancel.setOnMouseClicked(e -> stage.hide());

        // 6.确定按钮：Button
        Button butOk = new Button("确定");
        butOk.setPrefWidth(80);
        butOk.setPrefHeight(30);
        butOk.setLayoutX(50);
        butOk.setLayoutY(190);
        butOk.setTextFill(Color.WHITE);
        butOk.setBackground(new Background(new BackgroundFill(Color.rgb(15, 140, 170), null, null)));
        butOk.setOnMouseClicked(e -> {
            // 1.获取文件筐的数据
            String txtUser = txtUserName.getText().trim();
            // 判断
            if (txtUser == null || txtUser.length() == 0) {
                labMsg.setText("请输入用户ID！");
                return;
            }

            String txtPassword = TextPassword.getText().trim();
            // 判断
            if (txtPassword == null || txtPassword.length() == 0) {
                labMsg.setText("请输入密码！");
                return;
            }
            String[] collectInfo=new String[2];
            collectInfo[0]=txtUser;
            collectInfo[1]=txtPassword;
            userinfo=txtUser; //这是个全局变量,用于存储id号,验证成功直接登录.
            EventHandling.giveOutMsg("LOGIN",collectInfo);


            // 写入MusicGroup.xml中
//			XMLUtils.addGroup(txtUser);

//			HBox hBox1 = new HBox(10);
//			hBox1.getChildren().addAll();
//			hBox1.setPadding(new Insets(5, 5, 5, 10));
//			this.loginVBox.getChildren().add(hBox1);

            //获取当前登录用户的用户ID
            //String UserID="当前用户ID";
            //labUserID.setText(UserID);


            // 关闭此舞台
            this.stage.hide();
        });

        // 创建一个新舞台对象
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);

        // 创建一个场景
        Group login = new Group();
        login.getChildren().addAll(lab1, labClose, txtUserName, TextPassword, labMsg, butOk, butCancel);
        Scene sceneLogin = new Scene(login, 300, 240);
        sceneLogin.setFill(Color.rgb(45, 47, 51));
        sceneLogin.setOnMousePressed(e -> {
            //记录原位置
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();

        });
        sceneLogin.setOnMouseDragged(e -> {
            //设置新位置
            stage.setX(e.getScreenX() - mouseX);
            stage.setY(e.getScreenY() - mouseY);
        });
        // 设置场景
        stage.setScene(sceneLogin);
        // 显示舞台
        stage.show();
    }

}
