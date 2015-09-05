/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tagbuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ja
 */
public class TagBuilder {
    public TagBuilder() { }
    
    public TagBuilder(String TagName, TagBuilder Parent) {
        this.tagName = TagName;
        this.parent = Parent;
    }
    
    private TagBuilder(String TagName, TagBuilder Parent,int dp) {
        this.tagName = TagName;
        this.parent = Parent;
        depth = dp;
    }
    
    public boolean isIndented = false;
    public int Indentation = 4;
    private int depth = 0;
    private String tagName;
    private TagBuilder parent;
    private StringBuilder body = new StringBuilder();
    private Map<String, String> _attributes = new HashMap<>();
    
    public TagBuilder AddContent(String Content) {
        body.append(Content);
        return this;
    }
    
    public TagBuilder AddContentFormat(String Format, Object... args) {
        body.append(String.format(Format, args));
        return this;
    }
    
    public TagBuilder StartTag(String TagName) {
        TagBuilder tag = new TagBuilder(TagName, this, depth+1);
        tag.isIndented = isIndented;
        tag.Indentation = Indentation;
        return tag;
    }
    
    public TagBuilder EndTag() {
        parent.AddContent(this.toString());
        return parent;
    }
    
    public TagBuilder AddAttribute(String Name, String Value) {
        _attributes.put(Name, Value);
        return this;
    }
    
    private void addIndent(StringBuilder sb) {
        if(isIndented && shouldIndent())
            for(int i = 0; i < Indentation; i++)
                sb.append(" ");
    }
    
    private boolean shouldIndent() {
        return depth > 1;
    }
    
    @Override
    public String toString() {
        StringBuilder tag = new StringBuilder();
        
        // preamble
        if(tagName != null && !tagName.isEmpty()) {
            addIndent(tag);
            tag.append("<" + tagName);
        }
        
        if(_attributes.size() > 0) {
            tag.append(" ");
            for(String key : _attributes.keySet()) {
                tag.append(key + "='" + _attributes.get(key) + "' ");
            }
            tag.deleteCharAt(tag.length()-1);
        }
        
        if(body.length() > 0) {
            if(tagName != null && !tagName.isEmpty() || _attributes.size() > 0)
                tag.append(">" + (isIndented ? "\n" : ""));
            
            if(isIndented) {
                Scanner scanner = new Scanner(body.toString());
                String line;
                StringBuilder sb = new StringBuilder();
                while(scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    addIndent(sb);
                    sb.append(line);
                    if(scanner.hasNextLine())
                        sb.append("\n");
                }
                tag.append(sb.toString());
            }
            else
                tag.append(body.toString());
            
            if(tagName != null && !tagName.isEmpty()) {
                if(isIndented) {
                    tag.append("\n");
                    addIndent(tag);
                }
                tag.append("</" + tagName + ">" + (isIndented ? "\n" : ""));
            }
                
        }
        else if(tagName != null && !tagName.isEmpty())
            tag.append("/>" +(isIndented ? "\n" : ""));
        
        return tag.toString();
    }
    
}
