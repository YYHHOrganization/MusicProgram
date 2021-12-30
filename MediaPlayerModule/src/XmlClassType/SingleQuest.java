package XmlClassType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name="SelectSongsInSonglist")
// 控制JAXB绑定类中属性和字段的排序
@XmlType(propOrder = {"requestEnum"})
public class SingleQuest {
    String requestEnum;
    public SingleQuest(){}
    public SingleQuest(String requestEnum){
        this.requestEnum=requestEnum;
    }

    public String getRequestEnum() {
        return requestEnum;
    }

    public void setRequestEnum(String requestEnum) {
        this.requestEnum = requestEnum;
    }
}
