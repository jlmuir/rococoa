package org.rococoa;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

@SuppressWarnings("nls")
public class FoundationStructureReturnTest extends NSTestCase {
       
    private interface StructLibrary extends Library {
        MyStructByValue  returnStructByValue(int a, double b);
    }
    
    private StructLibrary instance = (StructLibrary) Native.loadLibrary("rococoa", StructLibrary.class);    
    
    public static class MyStruct extends Structure {
        public int anInt;
        public double aDouble;
    }
    
    public static class MyStructByValue extends MyStruct implements Structure.ByValue {
        public MyStructByValue() {};
        public MyStructByValue(int anInt, double aDouble) {
            this.anInt = anInt; this.aDouble = aDouble;
        }
    }
    
    public static class MyStructOfStruct extends Structure {
        public double aDouble;
        public MyStructByValue aStruct;
    }

    public static class MyStructOfStructByValue extends MyStructOfStruct implements Structure.ByValue {
        public MyStructOfStructByValue() {}
        public MyStructOfStructByValue(int anInt, double aDouble) {
            this.aDouble = aDouble;
            this.aStruct = new MyStructByValue(anInt, aDouble);
        }        
    }

    public void testStaticReceiveStructure() {
        MyStruct result = instance.returnStructByValue(42, Math.E);
        assertEquals(42, result.anInt);
        assertEquals(Math.E, result.aDouble);        
    }
    
    public void testCallMethod() {
        ID testID = Foundation.createInstance(Foundation.nsClass("TestShunt"));
        Object[] args = { 42, Math.E };
        MyStruct result = Foundation.send(testID, 
                Foundation.selector("testReturnStructByValue:and:"), 
                MyStructByValue.class, args);
        assertEquals(42, result.anInt);
        assertEquals(Math.E, result.aDouble);        
    }
    
    public void testAsArgument() {
        ID testID = Foundation.createInstance(Foundation.nsClass("TestShunt"));
        MyStruct arg = new MyStructByValue(42, Math.PI);
        Object[] args = { arg };
        double result = Foundation.send(testID, 
                Foundation.selector("testPassStructByValue:"), 
                double.class, args);
        assertEquals(Math.PI, result);        
    }
    
    public void testStructOfStruct() {
        ID testID = Foundation.createInstance(Foundation.nsClass("TestShunt"));
        Object[] args1 = { 42, Math.E };
        MyStructOfStruct result = Foundation.send(testID, 
                Foundation.selector("testReturnStructOfStructByValue:and:"), 
                MyStructOfStructByValue.class, args1);
        assertEquals(Math.E, result.aDouble);
        assertEquals(42, result.aStruct.anInt);        
        assertEquals(Math.E, result.aStruct.aDouble);
        Object[] args = { result };
        
        double result2 = Foundation.send(testID, 
                Foundation.selector("testPassStructOfStructByValue:"), 
                double.class, args);
        assertEquals(Math.E, result2);        
    }        
}