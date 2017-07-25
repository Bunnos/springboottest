package com.boot.constants;

/**
 * Created by Administrator on 2017/7/7.
 */
public enum NewResourceTypeConst {
    AUDIO("Audio", "音频"),
    CARTOON("Cartoon", "动画"),
    DOCUMENT("Document", "文档"),
    IMAGE("Image", "图片"),
    VIDEO("Video", "视频"),
    OTHER("Other", "其他"),
    UNSURE("unsure", "unsure");

    private String name;
    private String desc;

    NewResourceTypeConst(String name, String desc) {
        this.desc = desc;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
