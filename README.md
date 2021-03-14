# NathanEvans
Library that computes statistics about a text file.

Download the files known as File from github. Open a new project and import the jar file from the downloaded code known as "file.jar". In Intellij, this is done by clicking File (top left), Project Structure, Libraries, click "New project library" (+ symbol), and then select java out out the options. Then go to the downloaded file (known as "File"), out, artifacts, and the click the folder file.jar (i.e. the first one). 

The project will now have access to the library. In the src code create a new java class and import the library by typing "import NathanEvans.FileReader;" above the class.  

To compute the statistics relating to the text file, run the following commands in the main method (where "filename" relates to name/pathway of the text file):

System.out.println(FileReader.wordCount(filename)); prints the whitespace delimited word count 
System.out.println(FileReader.numberOfLines(filename)); prints the number of lines in the text file 
System.out.println(FileReader.averageLettersPerWord(filename)); prints the average number of letters per word
System.out.println(FileReader.mostCommonLetter(filename)); prints the most common letter 

The program has been split into a series of methods. The reason for this is that it ensures the code is more organised and structured, and it is clear what each method does. The following is what the six methods do and an explanation for the design.

The method "fileReader" takes a file name as an argument and reads a text file and returns a StringBuilder object known as "text".

The method "singleString" takes a file name as an argument and uses the StringBuilder variable from fileReader and returns a string, whilst removing all new line characters. The reason for wanting a method that would return a string was to allow the use of inbuilt functions such as length() to be performed. In addition, by the creating this method it avoids having to write code which would create a string variable out of the StringBuilder variable in other methods. 

The method wordCount takes the returned string variable from the method singleString, and then uses StringTokenizer. This method splits a string into tokens. The number of tokens is then counted using the inbuilt method countTokens(). It should be noted a "word" is any character/characters which has white space surrounding it, therefore characters such as a number will count as a word.

The method numberOfLines uses the returned StringBuilder variable from the fileReader method. It uses regular expressions to count the number of new line characters, "\n" in the text. It then returns the number of lines as an integer.  

The method averageLettersPerWord again takes the file name as the argument and pulls the integer value from the method wordCount, as well as the string value from the method singleString. A new string variable, letters, is set equal to the variable single, but replaces all non-alphabetic characters, including whitespaces, with an empty string. Therefore, letters is a string of all the letters in a text file with no other characters. The inbuilt method length(), can be used to get number of letters (the double variable numberOfLetters). Finally, the method returns value of numberOfLetters divided by wordCount, rounded to one significant figure. 

The method mostCommonLetter has the file name as the argument and takes the value from the method singleString. It then produces a string consisting of letters only (variable letters). The array charCount, is initialised, which creates an array of counters for each letter. The method uses a for loop to compare a letters' count to the max count (maxCount). If it is greater, or equal, the maxCount will be updated along with the maxChar. 
