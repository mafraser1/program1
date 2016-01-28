/*
 * Author: 
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */
package program1;

public class MyString {
    private char[] strChar;
    private int currLength;
    
    
    
    public MyString(){
        strChar = null;
        currLength = 0;
    }
    
    public MyString(String str){
        currLength = str.length();
        ensureCapacity();
        for (int i = 0; i < currLength; i++){
            strChar[i] = str.charAt(i);
        }
        
    }
    
    public MyString(MyString str){
        currLength = str.length();
        ensureCapacity();
        for (int i = 0; i < currLength; i++){
            strChar[i] = str.get(i);
        }
    }
    
    public int length(){
        return currLength;
    }
    
    private void ensureCapacity(){
        strChar = new char[currLength];
    }
    
    public String toString(){
        String newStr = null;
        for(int i = 0; i < currLength; i++){
            newStr += strChar[i];
        }
        return newStr;
    }
    
    public MyString concat(MyString str){
        String newStr = null;
        for(int i = 0; i < currLength; i++){
            newStr += strChar[i];
        }
        for(int i = 0; i < str.Length; i++){
            newStr += str.get(i);
        }
        MyString myStr = new MyString(newStr);
        return myStr;
    }
    
    public MyString concat(String str){
        String newStr = null;
        for(int i = 0; i < currLength; i++){
            newStr += strChar[i];
        }
        newStr += str;
        MyString myStr = new MyString(newStr);
        return myStr;
    }
    
    public boolean equals(MyString str){
        boolean isEqual = true;
        if (currLength != str.Length)
            isEqual = false;
        else{
            for(int i= 0; i<currLength; i++){
                if (strChar[i] == str.get(i)){
                    isEqual = true;
                }
                else{
                    isEqual = false;
                    i = currLength;
                }
            }
        }
    return isEqual;
    }
    
    public char get(int index){
        return strChar[index];
    }
}
