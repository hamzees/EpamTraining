/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.skakun.textparser.entity;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author apple
 */
public class Text implements TextPart{
private int id;
private ArrayList<TextPart> content;

    public Text(int id, ArrayList<TextPart> content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public ArrayList<TextPart> getContent() {
        return content;
    }

    @Override
    public void operation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(TextPart t) {
    content.add(t);
    }

    @Override
    public void remove(TextPart t) {
    content.remove(t);
    }

    @Override
    public Object getChild(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
