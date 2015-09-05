/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ja
 */
public class GenericFactory {
    
    Map<String, Object> objectsCreated = new HashMap<>();
    
    public Object CreateObject(
            String TypeName, 
            boolean isSingleton,
            Object... Parameters) throws Exception {
        if(isSingleton && objectsCreated.containsKey(TypeName)) {
                return objectsCreated.get(TypeName);
        }
        else {
            Class<?> cls = Class.forName(TypeName);
            Class<?> ParametersTypes[] = new Class<?>[Parameters.length];
            for(int i = 0; i < Parameters.length; i++) {
                ParametersTypes[i] = Parameters[i].getClass();
            }
            
            Constructor matched = null;
            for(Constructor cs : cls.getConstructors()) {
                Class<?>[] itsparams = cs.getParameterTypes();
                if(itsparams.length != ParametersTypes.length)
                    continue;
                
                boolean matches = true;
                for(int i = 0; i < itsparams.length; i++) {
                    if(!itsparams[i].isAssignableFrom(ParametersTypes[i]))
                        matches = false;
                }
                if(matches) {
                    matched = cs;
                    break;
                }
            }
            
            if(matched != null) {
                Object ob = matched.newInstance(Parameters);
                objectsCreated.put(TypeName, ob);
                return ob;
            }
            else {
                throw new NoSuchMethodException();
            }
        }
    }
}
