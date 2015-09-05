/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ja
 */
public class ExpContext {
    
    private final Map<String, Boolean> Vars = new HashMap<>();
    
    public boolean GetValue(String VariableName) throws VarNotFoundException {
        if(Vars.containsKey(VariableName))
            return Vars.get(VariableName);
        throw new VarNotFoundException("Variable " + VariableName +
                " not found in current context.");
    }
    
    public boolean SetValue(String VariableName, boolean Value) {
        boolean alreadyExists = Vars.containsKey(VariableName);
        Vars.put(VariableName, Value);
        return alreadyExists;
        // is that what return value was supposed to mean? oO
    }
}
