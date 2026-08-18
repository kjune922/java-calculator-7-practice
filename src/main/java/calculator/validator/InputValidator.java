package calculator.validator;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    /**
     *
     * custom 구분자가 있는 경우 -> 숫자,쉼표(,),콜론(:) 이외의 값 예외처리
     *
     * custom 구분자가 없는 경우 -> 숫자, 쉼표, 콜론 이외의 값 예외처리하고 쉼표(,) 또는 콜론(:)을 구분자로 가짐
     */

    public int validateInput(String input) {

        if(input.isEmpty()){
            return 0;
        }
        if(input.isBlank()){
            throw new IllegalArgumentException("공백만 입력할 수 없습니다.");
        }

        int n = input.length();
        StringBuilder custom = new StringBuilder();

        int customStartIndex = 2;
        int customEndIndex = 0;
        int numStartIndex = 0;

        for (int i = customStartIndex; i < n; i++) {
            if(input.charAt(i + 1) == 'n'){
                customEndIndex = i;
                numStartIndex = i + 1;
                break;
            }
        }

        for (int i = customStartIndex; i < customEndIndex; i++) {
            custom.append(input.charAt(i));
        }
        System.out.println("커스텀 구분문자 : " + custom);

        List<Integer> numList = new ArrayList<>();
        for (int i = numStartIndex; i < n; i++) {

            char cur = input.charAt(i);

            if(Character.isDigit(cur)){
                numList.add(Integer.parseInt(String.valueOf(cur)));
            }
        }
        int sum = 0;
        for (Integer num : numList) {
            sum += num;
        }
        return sum;
    }
}
