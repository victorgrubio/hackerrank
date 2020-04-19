import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import org.graalvm.compiler.nodes.memory.MemoryCheckpoint.Single;

import java.lang.reflect.*;


class Singleton{
    public String str;
    private Singleton (){

    }
    static Singleton getSingleInstance(){
        return new Singleton();
    }
}