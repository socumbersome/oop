/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_decorator;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author ja
 */
public class CaesarInputStream extends InputStream {

    InputStream iStream;
    int offset = 3;
    
    public CaesarInputStream(InputStream is, int offset) {
        iStream = is;
        this.offset = offset;
    }
    
    @Override
    public int read() throws IOException {
        int b = iStream.read();
        return (b + offset);
    }
    
}
