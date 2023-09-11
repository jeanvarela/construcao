package br.com.repository.entity;

public class Teste {
        public boolean isValid(String s) {
            if (s == null || s == "")
                return false;

            boolean result = true;

            for(int i = 0; i< (s.length() - 1); i = i + 2){
                char char1 = s.charAt(i);
                char char2 = s.charAt(i + 1);
                result = (validParenthesis(char1,char2) || validSquareBrackets(char1,char2) || validKeys(char1,char2));

                if (!result)
                    break;;
            }

            if (!result){
                int metade = s.length()/2;
                for(int i = 0; i < metade; i++){
                    char char1 = s.charAt(i);
                    char char2 = s.charAt(s.length() - i - 1);

                    result = (validParenthesis(char1,char2) || validSquareBrackets(char1,char2) || validKeys(char1,char2));

                    if (!result)
                        break;;
                }
            }

            return result;
        }

        private boolean validParenthesis(char s1, char s2){
            return s1 == '(' && s2 == ')';
        }

        private boolean validSquareBrackets(char s1, char s2){
            return s1 == '[' && s2 == ']';
        }

        private boolean validKeys(char s1, char s2){
            return s1 == '{' && s2 == '}';
        }

    public static void main(String[] args) {
        Teste teste = new Teste();
        System.out.println(teste.isValid("({})"));
    }
}
