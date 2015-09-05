/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_decorator;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author ja
 */
public class CaesarOutputStream extends OutputStream {
    
    OutputStream oStream;
    int offset = 3;
    
    public CaesarOutputStream(OutputStream os, int offset) {
        oStream = os;
        this.offset = offset;
    }
    
    @Override
    public void write(int i) throws IOException {
        oStream.write(i + offset);
    }
    
}
