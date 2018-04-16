package com.egeio.net;

import android.text.TextUtils;

/**
 * Created by wangjinpeng on 16/7/8.
 */
public class Header {

    private String name;
    private String value;
    private boolean requisite = false;

    public Header(String name, String value, boolean requisite) {
        this.name = name;
        this.value = value;
        this.requisite = requisite;
    }

    public Header(String name, String value) {
        this(name, value, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isValid(){
        return !TextUtils.isEmpty(name) && !TextUtils.isEmpty(value);
    }

    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Header){
            if(TextUtils.equals(value, ((Header) o).getValue())
                    && (name != null && name.equalsIgnoreCase(name))){
                return true;
            }
        }
        return false;
    }

    public boolean isRequisite() {
        return requisite;
    }

    public void setRequisite(boolean requisite) {
        this.requisite = requisite;
    }
}
