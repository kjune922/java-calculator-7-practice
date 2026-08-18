package calculator.validator;

public class InputValidator {

    /**
     *
     * custom 구분자가 있는 경우 -> 숫자,쉼표(,),콜론(:) 이외의 값 예외처리
     *
     * custom 구분자가 없는 경우 -> 숫자, 쉼표, 콜론 이외의 값 예외처리하고 쉼표(,) 또는 콜론(:)을 구분자로 가짐
     */

    public int validateInput(String input) {

        if(input.isBlank()){
            return 0;
        }

        int n = input.length();
        StringBuilder custom = new StringBuilder();

        int customStartIndex = 2;
        int customEndIndex = 0;

        for (int i = customStartIndex; i < n; i++) {
            if(input.charAt(i + 1) == n && input.charAt(i + 2) == '1'){
                customEndIndex = i;
            }
        }

        for (int i = customStartIndex; i < customEndIndex; i++) {
            custom.append(input.charAt(i));
        }
        System.out.println(custom);
        return Integer.parseInt(custom.toString());
    }
}
