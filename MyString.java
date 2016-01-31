/*
 * Author: Maxwell Fraser
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
        for (int i=0; i<currLength; i++){
            strChar[i] = str.charAt(i);
        }
        
    }
    
    public MyString(MyString str){
        currLength = str.length();
        ensureCapacity();
        for (int i=0; i<currLength; i++){
            strChar[i] = str.get(i);
        }
    }
    
    public int length(){
        return currLength;
    }
    
    //sets the array's length to the current length
    private void ensureCapacity(){
        strChar = new char[currLength];
    }
    
    //loop creates a string using each index of the character array
    public String toString(){
        String newStr = null;
        for(int i=0; i<currLength; i++){
            newStr += strChar[i];
        }
        return newStr;
    }
    
    //uses two loops to combine the two arrays into a new MyString character array
    public MyString concat(MyString str){
        String newStr = null;
        for(int i=0; i<currLength; i++){
            newStr += strChar[i];
        }
        for(int i=0; i<str.Length; i++){
            newStr += str.get(i);
        }
        MyString myStr = new MyString(newStr);
        return myStr;
    }
    
    //uses a single loop to combine the character array with a string for a new MyString
    public MyString concat(String str){
        String newStr = null;
        for(int i=0; i<currLength; i++){
            newStr += strChar[i];
        }
        newStr += str;
        MyString myStr = new MyString(newStr);
        return myStr;
    }
    
 
    public boolean equals(MyString str){
        boolean isEqual = true;
        //short circuits the process by checking to see if the length matches first
        if (currLength != str.length)
            isEqual = false;
        //otherwise loop checks each index of the two arrays to see if they match
        //loop is broken if characters do not match
        else{
            for(int i=0; i<currLength; i++){
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
    
    public int compareTo(MyString str){
        int compare = 0;
        //loop checks each character
        //if a character is greater than or less than another it will break the loop
        for (int i=0; i<currLength; i++){
            if(strChar[i] < str.get(i)){
                compare = -1;
                i = currLength;
            }
            else if(strChar[i] > str.get(i)){
                compare = 1;
                i = currLength;
            }
            else
                compare = 0;
            
        }
        return compare;
    }
    
    public char get(int index){
        //If the integer beyond the range, it will return the last character
        if(index >= currLength){
            System.out.println("ERROR: Integer not in range.\n"
                    + "Returning last character of MyString.");
            return strChar[currLength-1];
        }
        //If the integer is negative, it will return the first character
        if(index < 0){
            System.out.println("ERROR: Integer not in range.\n"
                    + "Returning first character of MyString.");
            return strChar[0];
        }
        return strChar[index];
    }
    
    //loops goes through the char array and makes all chars uppercase
    public MyString toUpper(){
        String upStr = null;
        for (int i=0; i<currLength; i++){            
           upStr += Character.toUpperCase(strChar[i]);
        }
        MyString upperStr = new MyString(upStr);
        return upperStr;
    }
    
    //similar loop does the same to make all chars lowercase
    public MyString toLower(){
        String lwStr = null;
        for (int i=0; i<currLength; i++){            
           lwStr += Character.toLowerCase(strChar[i]);
        }
        MyString lowerStr = new MyString(lwStr);
        return lowerStr;
    }
    
    //
    public int indexOf(MyString str){
        int index = -1;
        for(int i=0; i<str.length(); i++){
            if (strChar[0] == str.get(i)){
                int counter = 0;
                for (int j=i; j< str.length(); j++){
                    if (strChar[0] == str.get(j)){
                        counter++;
                        if(counter == currLength){
                            index = i;
                            return index;
                        }
                    }
                    
                    else{
                        counter = 0;
                    }
                } 
            }
        }
        return index;
    }
    
    public int lastIndexOf(MyString str){
        int index = -1;
        for(int i=0; i<str.length(); i++){
            if (strChar[0] == str.get(i)){
                int counter = 0;
                for (int j=i; j< str.length(); j++){
                    if (strChar[0] == str.get(j)){
                        index = i;
                        counter++;
                        if(counter == currLength){
                            index = i;
                        }
                    }
                    
                    else{
                        counter = 0;
                    }
                } 
            }
        }
        return index;
    }
}
