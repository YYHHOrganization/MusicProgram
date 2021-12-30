package media;


import cn.itheima.utils.XMLUtils;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.MusicPlayerMainApp;

public class Message {
    private Stage parentStage;// 父窗体
    private MusicPlayerMainApp musicPlayerMainApp;

    // 移动前的x,y坐标
    private double mouseX;
    private double mouseY;

    // 本窗体的舞台对象
    private Stage stage;

    public Message(Stage parentStage, MusicPlayerMainApp musicPlayerMainApp) {
        this.parentStage = parentStage;
        this.musicPlayerMainApp = musicPlayerMainApp;

        // 1.个人信息：Label
        Label labMessage = new Label("个人信息");
        labMessage.setTextFill(Color.WHITE);
        labMessage.setFont(new Font("宋体", 25));
        labMessage.setPrefWidth(160);
        labMessage.setPrefHeight(100);
        labMessage.setLayoutX(150);
        labMessage.setLayoutY(-26);
        // 绽放效果
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.5);
        labMessage.setEffect(bloom);

        // 2.关闭按钮：ImageView
        ImageView v1 = new ImageView("img/topandbottom/closeDark.png");
        v1.setFitWidth(13);
        v1.setFitHeight(13);
        Label labClose = new Label("", v1);
        labClose.setMinWidth(13);
        labClose.setMinHeight(13);
        labClose.setPrefWidth(13);
        labClose.setPrefHeight(13);
        labClose.setLayoutX(370);
        labClose.setLayoutY(20);
        labClose.setOnMouseClicked(e -> {
            stage.hide();
        });

        // 3.个人信息：文本框+label
        Label labID = new Label();
        labID.setPrefWidth(200);
        labID.setLayoutX(30);
        labID.setLayoutY(70);
        labID.setTextFill(Color.WHITE);
        labID.setText("ID");

        TextField txtID = new TextField();
        txtID.setPromptText("请输入ID");
        txtID.setPrefWidth(220);
        txtID.setPrefHeight(15);
        txtID.setLayoutX(160);
        txtID.setLayoutY(70);
        txtID.setText("ID");
        txtID.setEditable(false);// 不可修改

        Label labUserName = new Label();
        labUserName.setPrefWidth(200);
        labUserName.setLayoutX(30);
        labUserName.setLayoutY(105);
        labUserName.setTextFill(Color.WHITE);
        labUserName.setText("用户名");

        TextField txtUserName = new TextField();
        txtUserName.setPromptText("请输入用户名");
        txtUserName.setPrefWidth(220);
        txtUserName.setPrefHeight(15);
        txtUserName.setLayoutX(160);
        txtUserName.setLayoutY(105);

        Label labSex = new Label();
        labSex.setPrefWidth(200);
        labSex.setLayoutX(30);
        labSex.setLayoutY(140);
        labSex.setTextFill(Color.WHITE);
        labSex.setText("性别");

        TextField txtSex = new TextField();
        txtSex.setPromptText("请输入性别");
        txtSex.setPrefWidth(220);
        txtSex.setPrefHeight(15);
        txtSex.setLayoutX(160);
        txtSex.setLayoutY(140);

        Label labBirthday = new Label();
        labBirthday.setPrefWidth(200);
        labBirthday.setLayoutX(30);
        labBirthday.setLayoutY(175);
        labBirthday.setTextFill(Color.WHITE);
        labBirthday.setText("生日");

        TextField txtBirthday = new TextField();
        txtBirthday.setPromptText("请输入生日");
        txtBirthday.setPrefWidth(220);
        txtBirthday.setPrefHeight(15);
        txtBirthday.setLayoutX(160);
        txtBirthday.setLayoutY(175);

        Label labAdress = new Label();
        labAdress.setPrefWidth(200);
        labAdress.setLayoutX(30);
        labAdress.setLayoutY(210);
        labAdress.setTextFill(Color.WHITE);
        labAdress.setText("地址");

        TextField txtAdress = new TextField();
        txtAdress.setPromptText("请输入地址");
        txtAdress.setPrefWidth(220);
        txtAdress.setPrefHeight(15);
        txtAdress.setLayoutX(160);
        txtAdress.setLayoutY(210);

        Label labVIP = new Label();
        labVIP.setPrefWidth(200);
        labVIP.setLayoutX(30);
        labVIP.setLayoutY(245);
        labVIP.setTextFill(Color.WHITE);
        labVIP.setText("会员");

        TextField TextVIP = new TextField();
        TextVIP.setPromptText("是否为VIP");
        TextVIP.setPrefWidth(220);
        TextVIP.setPrefHeight(15);
        TextVIP.setLayoutX(160);
        TextVIP.setLayoutY(245);
        TextVIP.setText("VIP");
        TextVIP.setEditable(false);// 不可修改

        Label labImage = new Label();
        labImage.setPrefWidth(200);
        labImage.setLayoutX(30);
        labImage.setLayoutY(280);
        labImage.setTextFill(Color.WHITE);
        labImage.setText("头像");

        TextField TextImage = new TextField();
        TextImage.setPromptText("Image");
        TextImage.setPrefWidth(220);
        TextImage.setPrefHeight(15);
        TextImage.setLayoutX(160);
        TextImage.setLayoutY(280);

        Label labSinger = new Label();
        labSinger.setPrefWidth(200);
        labSinger.setLayoutX(30);
        labSinger.setLayoutY(315);
        labSinger.setTextFill(Color.WHITE);
        labSinger.setText("歌手");

        TextField TextSinger = new TextField();
//	        TextSinger.setPromptText(" IS Singer?");
        TextSinger.setPrefWidth(220);
        TextSinger.setPrefHeight(15);
        TextSinger.setLayoutX(160);
        TextSinger.setLayoutY(315);
        TextSinger.setText("Singer");
        TextSinger.setEditable(false);// 不可修改

        Label labUserDescription = new Label();
        labUserDescription.setPrefWidth(200);
        labUserDescription.setLayoutX(30);
        labUserDescription.setLayoutY(350);
        labUserDescription.setTextFill(Color.WHITE);
        labUserDescription.setText("简介");

        TextArea TextUserDescription = new TextArea();
        TextUserDescription.setPromptText("请输入简介");
        TextUserDescription.setPrefWidth(220);
        TextUserDescription.setPrefHeight(15);
        TextUserDescription.setLayoutX(160);
        TextUserDescription.setLayoutY(350);

        // 5.取消按钮：Button
        Button butCancel = new Button("取消");
        butCancel.setPrefWidth(80);
        butCancel.setPrefHeight(30);
        butCancel.setLayoutX(230);
        butCancel.setLayoutY(420);
        butCancel.setTextFill(Color.WHITE);
        butCancel.setBackground(new Background(new BackgroundFill(Color.rgb(100, 100, 100), null, null)));
        butCancel.setOnMouseClicked(e -> stage.hide());

        // 6.确定按钮：Button
        Button butOk = new Button("提交");
        butOk.setPrefWidth(80);
        butOk.setPrefHeight(30);
        butOk.setLayoutX(70);
        butOk.setLayoutY(420);
        butOk.setTextFill(Color.WHITE);
        butOk.setBackground(new Background(new BackgroundFill(Color.rgb(15, 140, 170), null, null)));
        butOk.setOnMouseClicked(e -> {
            // 1.获取文件筐的数据
            String txtUser = txtUserName.getText().trim();

//			// 写入MusicGroup.xml中
//			XMLUtils.addGroup(txtUser);
//
//			HBox hBox1 = new HBox(10);
//			hBox1.getChildren().addAll();
//			hBox1.setPadding(new Insets(5, 5, 5, 10));
//			this.groupVBox.getChildren().add(hBox1);

            // 关闭此舞台
            this.stage.hide();
        });

        // 创建一个新舞台对象
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);

        // 创建一个场景
        Group login = new Group();
        login.getChildren().addAll(labMessage, labClose, labID, txtID, labUserName, txtUserName, labSex, txtSex,
                labBirthday, txtBirthday, labAdress, txtAdress, labVIP, TextVIP, labUserDescription,
                TextUserDescription, labImage, TextImage, labSinger, TextSinger,
                /* TextPassword,TextMail,TextPhone,labMsg, */butOk, butCancel);
        // 场景大小
        Scene sceneLogin = new Scene(login, 400, 500);
        sceneLogin.setFill(Color.rgb(45, 47, 51));

        // 设置场景
        stage.setScene(sceneLogin);
        // 显示舞台
        stage.show();
    }
}

