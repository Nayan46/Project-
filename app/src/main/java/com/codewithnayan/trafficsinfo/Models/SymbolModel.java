package com.codewithnayan.trafficsinfo.Models;

public class SymbolModel {
    int pic;
    int text;

    public SymbolModel(int pic, int text) {
        this.pic = pic;
        this.text = text;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }
}
