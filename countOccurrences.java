// Method implements the count of Occurrences of Chars in String;

public int countOccurrences (String input, Character symbol) {
  int countCharacters = 0;

      for(int i = 0; i < input.length(); i ++) {
          if (input.charAt(i) == symbol) {
              countCharacters ++;
          }
      }
      return countCharacters;
}


// Alternitive way
int countCharacters = StringUtils.countMatches(input, symbol);
