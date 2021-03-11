# NathanEvans
Library that computes statistics about a text file

To compute the statistics relating to the text file, run the following command in the main method (where "file" relates to name/pathway of the text file):

System.out.println(wordCount(file)); prints the whitespace delimited word count 
System.out.println(numberOfLines(file)); prints the number of lines in the text file 
System.out.println(averageLettersPerWord(file)); prints the average number of letters per word
System.out.println(mostCommonLetter(file)); prints the most common letter 

The following is what the six methods do and an explanation for the design.

The method "fileReader" takes a file name as an argument and reads a text file and returns a StringBuilder object kwown as "text".

The method "singleString" takes takes a file name as an arguement, and uses the StringBuilder variable from fileReader and returns a string, whilst removing all new line characters. The reason for wanting a method that would return a string was to allow the use of inbuilt fucntions such as length(). 

The method wordCount takes the returned string variable from the method singleString, and then uses StringTokenizer. This method splits a string into tokens. The number of tokens is then counted using the inbuilt method countTokens(). It should be noted a "word" is any character/characters which has white space surrounding it, therefore characters such as a number will count as a word.

The method numberOfLines uses the returned StringBuilder variable from the fileReader method. It uses regular expressions to count the number of new line characters, "\n" in the text. It then returns the number of lines as an integer.  


