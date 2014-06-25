/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.skakun.textparser.entity;

/**
 *
 * @author apple
 */
public interface TextPart {
    void operation();
    void add(TextPart t);
    void remove(TextPart t);
    Object getChild(int index);
}
