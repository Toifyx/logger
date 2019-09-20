package com.toi;



import javax.xml.bind.annotation.*;

@XmlRootElement(name ="CMMTMSG")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cmmtmsg {
    @XmlElement(name = "MSG_TITLE")
    private String MsgTitle;
    @XmlElement( name ="MSG_CONTENT")
    private String MsgContent;
    @XmlElement(name = "MSG_IMG_URL")
    private String MsgImgUrl;
    @XmlElement(name = "MSG_DEST_URL")
    private String MsgDestUrl;
    @XmlElement(name = "MSG_EFF_DT")
    private String MsgEffDt;
    @XmlElement(name = "MSG_EFF_TM")
    private String MsgEffTm;
    @XmlElement(name = "MSG_EOF_DT")
    private String MsgEofDt;
    @XmlElement(name = "MSG_EOF_TM")
    private String MsgEofTm;
    @XmlElement(name = "EFF_BTN_TXT")
    private String EffBtnTxt;
    @XmlElement(name = "EOF_BTN_TXT")
    private String EofBtnTxt;

    @Override
    public String toString() {
        return "Cmmtmsg{" +
                "MsgTitle='" + MsgTitle + '\'' +
                ", MsgContent='" + MsgContent + '\'' +
                ", MsgImgUrl='" + MsgImgUrl + '\'' +
                ", MsgDestUrl='" + MsgDestUrl + '\'' +
                ", MsgEffDt='" + MsgEffDt + '\'' +
                ", MsgEffTm='" + MsgEffTm + '\'' +
                ", MsgEofDt='" + MsgEofDt + '\'' +
                ", MsgEofTm='" + MsgEofTm + '\'' +
                ", EffBtnTxt='" + EffBtnTxt + '\'' +
                ", EofBtnTxt='" + EofBtnTxt + '\'' +
                '}';
    }

    public String getMsgTitle() {
        return MsgTitle;
    }

    public String getMsgContent() {
        return MsgContent;
    }

    public String getMsgImgUrl() {
        return MsgImgUrl;
    }

    public String getMsgDestUrl() {
        return MsgDestUrl;
    }

    public String getMsgEffDt() {
        return MsgEffDt;
    }

    public String getMsgEffTm() {
        return MsgEffTm;
    }

    public String getMsgEofDt() {
        return MsgEofDt;
    }

    public String getMsgEofTm() {
        return MsgEofTm;
    }

    public String getEffBtnTxt() {
        return EffBtnTxt;
    }

    public String getEofBtnTxt() {
        return EofBtnTxt;
    }
}
