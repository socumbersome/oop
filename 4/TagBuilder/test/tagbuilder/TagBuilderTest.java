/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tagbuilder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ja
 */
public class TagBuilderTest {
    
    public TagBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void noIndent() {
        TagBuilder tag = new TagBuilder();
        tag.isIndented = false;
        String res = tag.StartTag("parent")
            .AddAttribute("parentproperty1", "true" )
            .AddAttribute( "parentproperty2", "5" )
            .StartTag( "child1")
            .AddAttribute( "childproperty1", "c" )
            .AddContent( "childbody" )
            .EndTag()
            .StartTag( "child2" )
            .AddAttribute( "childproperty2", "c" )
            .AddContent( "childbody" )
            .EndTag()
        .EndTag()
        .StartTag( "script" )
        .AddContent( "$.scriptbody();")
        .EndTag()
        .toString();
        
        String ref = "<parent parentproperty1='true' parentproperty2='5'><child1 childproperty1='c'>ch" +
"ildbody</child1><child2 childproperty2='c'>childbody</child2></parent><script>$." +
"scriptbody();</script>";
      //  System.out.println(res);
        assertEquals(ref, res);
    }
    
    @Test
    public void withIndent() {
        TagBuilder tag = new TagBuilder();
        tag.isIndented = true;
        tag.Indentation = 4;
        
        String res = tag.StartTag("parent")
            .AddAttribute("parentproperty1", "true" )
            .AddAttribute( "parentproperty2", "5" )
            .StartTag( "child1")
            .AddAttribute( "childproperty1", "c" )
            .AddContent( "childbody" )
            .EndTag()
            .StartTag( "child2" )
            .AddAttribute( "childproperty2", "c" )
            .AddContent( "childbody" )
            .EndTag()
        .EndTag()
        .StartTag( "script" )
        .AddContent( "$.scriptbody();")
        .EndTag()
        .toString();
        
        String ref = "<parent parentproperty1='true' parentproperty2='5'>\n" + 
                     "    <child1 childproperty1='c'>\n" + 
                     "    childbody\n" + 
                     "    </child1>\n" +
                     "    <child2 childproperty2='c'>\n" + 
                     "    childbody\n" + 
                     "    </child2>\n" +
                     "</parent>\n" +
                     "<script>\n" + 
                     "$.scriptbody();\n" + 
                     "</script>";
       // System.out.println(res);
        assertEquals(ref, res);
    }
    
}
