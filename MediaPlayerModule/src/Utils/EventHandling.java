package Utils;

import TestThings.MainAppTest1ForClickOne;
import XmlClassType.*;
import media.MusicLabel;
import media.MusicPanel;

/**
 * @DATE 2021.12.22
 * @VERSION v1.0
 * @author Zhang Haohan,Zhang Yingying
 * 这个类专门对用户点击事件的各种情况进行处理
 */
public class EventHandling {
    public String requestEnum;

    /**
     * 不同的函数会为这里传递参数,这里来决定如何去做
     * 一般来说与查询有关的问题采用MusicLabel的方法,如果不是的话先抛给其他的函数来处理吧
     * @param requestEnum
     */
    public static void decideRequest(String requestEnum,MusicLabel obj){
        String newXmlStream;
        switch (requestEnum){
            case "CLICK_A_USER":
                ClickOneUserOrSongOrSinger userinfo=new ClickOneUserOrSongOrSinger(RequestEnum.CLICK_A_USER,obj.getLabelId());
                String xmlStream= XStreamUtil.objectToXml(userinfo);
                ClientSocketUtils.sendToServerXml(xmlStream);
                break;
            case "CLICK_A_SONGLIST":
                ClickOneUserOrSongOrSinger clicksonglist=new ClickOneUserOrSongOrSinger(RequestEnum.CLICK_A_SONGLIST,obj.getLabelId());
                String xmlStream2= XStreamUtil.objectToXml(clicksonglist);
                ClientSocketUtils.sendToServerXml(xmlStream2);
                break;
            case "CLICK_A_SONG":
                ClickOneUserOrSongOrSinger clicksong=new ClickOneUserOrSongOrSinger(RequestEnum.CLICK_A_SONG,obj.getLabelId());
                String xmlStream3=XStreamUtil.objectToXml(clicksong);
                ClientSocketUtils.sendToServerXml(xmlStream3);
                break;
            case "DO_NOTHING":
                break;
            case "CLICK_AN_ALBUM":
                ClickOneUserOrSongOrSinger clickalbum=new ClickOneUserOrSongOrSinger(RequestEnum.CLICK_AN_ALBUM,obj.getLabelId());
                String xmlStream4=XStreamUtil.objectToXml(clickalbum);
                ClientSocketUtils.sendToServerXml(xmlStream4);
                break;
            case "SHOW_MY_SONGLIST":
                ClickOneUserOrSongOrSinger showMySongList=new ClickOneUserOrSongOrSinger(RequestEnum.SHOW_MY_SONGLISTS,MainAppTest1ForClickOne.userId);
                newXmlStream=XStreamUtil.objectToXml(showMySongList);
                ClientSocketUtils.sendToServerXml(newXmlStream);
                break;
        }
    }
    public static void giveOutMsg(String requestEnum,String[] msg){
        switch (requestEnum){
            case "REGIST":
                String[] collectinfo=msg;
                RegistRequest registRequest=new RegistRequest(RequestEnum.REGIST_A_USER,-1,collectinfo[0],collectinfo[1],collectinfo[2],collectinfo[3]);
                String xmlStream=XStreamUtil.objectToXml(registRequest);
                ClientSocketUtils.sendToServerXml(xmlStream);
                //System.out.println(xmlStream);
                break;
            case "LOGIN":
                String[] collectinfo2=msg;
                LoginQuest loginQuest=new LoginQuest("LOGIN_A_USER",collectinfo2[0],collectinfo2[1]);
                String xmlStream2=XStreamUtil.objectToXml(loginQuest);
                ClientSocketUtils.sendToServerXml(xmlStream2);
                break;
            case "SHOW_MY_INFO":
                String[] collectinfo3=msg;
                ClickOneUserOrSongOrSinger userinfo=new ClickOneUserOrSongOrSinger(RequestEnum.SHOW_MY_INFO,Integer.parseInt(msg[0]));
                String xmlStream3= XStreamUtil.objectToXml(userinfo);
                ClientSocketUtils.sendToServerXml(xmlStream3);
                break;
            case "UPDATE_USERINFO":
                String[] collectinfo4=msg;
                UserInfo userInfo2=new UserInfo("UPDATE_USERINFO",collectinfo4[0],collectinfo4[1],collectinfo4[2],
                        collectinfo4[3],collectinfo4[4],collectinfo4[5],collectinfo4[6],collectinfo4[7],collectinfo4[8]
                        );
                String xmlStream4= XStreamUtil.objectToXml(userInfo2);
                ClientSocketUtils.sendToServerXml(xmlStream4);
                break;

        }
    }
    public static void giveOutRequest(String requestEnum, MusicPanel musicPanel){
        String xmlStreamnew;
        switch(requestEnum){
            case "CREATE_A_SONGLIST":
                String[] collectinfo3=musicPanel.getCollectInfo();
                QuestAddGroup addSonglist=new QuestAddGroup("CREATE_A_SONGLIST", collectinfo3[0],collectinfo3[1]);
                xmlStreamnew=XStreamUtil.objectToXml(addSonglist);
                ClientSocketUtils.sendToServerXml(xmlStreamnew);
                break;
            case "SEARCH":

                break;
        }
    }

    /**
     * 用于发送单个基本请求,比如查询top10,搜索内容等
     * @param requestEnum 请求类型
     */
    public static void giveOutSingleRequest(String requestEnum){
        /*
        todo:后续不知道是否还需要加入与页码相关的内容,暂时不考虑
         */
        String xmlStreamnew;
        SingleQuest singleQuest;
        switch (requestEnum){
            case "SHOW_GOOD_SONGLISTS":
            case "SHOW_TOP_10":
            case "SHOW_GOOD_ALBUM":
                singleQuest=new SingleQuest(requestEnum);
                xmlStreamnew=XStreamUtil.objectToXml(singleQuest);
                ClientSocketUtils.sendToServerXml(xmlStreamnew);
                break;
        }
    }


}
