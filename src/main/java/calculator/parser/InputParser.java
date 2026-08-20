package calculator.parser;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public List<Integer> parse(String input){

       List<Integer> numList = new ArrayList<>();

        if (input.isEmpty()) {
            return numList;
        }
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백만 입력할 수 없습니다.");
        }

        if (isJustNum(input)) {
            numList.add(Integer.parseInt(input));
            return numList;
        }

        if (hasCustomDelimiter(input)){
            return parseCustomDelimiterInput(input);
        }
        return parseDefaultDelimiterInput(input);

    }

    private boolean isJustNum(String input) {
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (!Character.isDigit(cur)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private List<Integer> parseCustomDelimiterInput(String input) {
        List<Integer> numList = new ArrayList<>();
        int n = input.length();

        StringBuilder custom = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        int customStartIndex = 2;
        int customEndIndex = 0;
        int numStartIndex = 0;

        for (int i = customStartIndex; i < n; i++) {
            if (i + 1 < n && input.charAt(i) == '\\' &&input.charAt(i + 1) == 'n') {
                customEndIndex = i;
                numStartIndex = i + 2;
                break;
            }
        }
        if(customEndIndex <= customStartIndex){
            throw new IllegalArgumentException("커스텀 구분자 입력 형식이 올바르지 않습니다.");
        }

        for (int i = customStartIndex; i < customEndIndex; i++) {
            custom.append(input.charAt(i));
        }

        int customSize = custom.length();

        for (int i = numStartIndex; i < n; i++) {
            char cur = input.charAt(i);

            if (Character.isDigit(cur)) {
                sb.append(cur);
                if(i == n - 1){
                    numList.add(Integer.parseInt(sb.toString()));
                }
            }
            else if(i == n - 1 && !Character.isDigit(cur)){
                throw new IllegalArgumentException("마지막 입력은 구분자일 수 없습니다.");
            }
            else if (cur == custom.charAt(0)) {
                int checkIndex = 0;
                while (checkIndex < customSize) {
                    if (i + checkIndex >= n) {
                        throw new IllegalArgumentException("문자열 입력방식이 올바르지 않습니다.");
                    }
                    if (input.charAt(i + checkIndex) != custom.charAt(checkIndex)) {
                        throw new IllegalArgumentException("구분자가 올바르지 않습니다.");
                    }
                    checkIndex++;
                }
                if(!sb.isEmpty()){
                    numList.add(Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                }
                i += customSize - 1;
                if(i + 1 == input.length()){
                    throw new IllegalArgumentException("마지막 입력은 구분자일 수 없습니다.");
                }
            }
            else if(cur != ',' && cur != ':'){
                throw new IllegalArgumentException("구분자가 올바르지 않습니다.");
            }
            else {
                if(!sb.isEmpty()) {
                    numList.add(Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                }
            }
        }
        return numList;
    }

    private List<Integer> parseDefaultDelimiterInput(String input) {
        List<Integer> numList = new ArrayList<>();
        int n = input.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            char cur = input.charAt(i);

            if (Character.isDigit(cur)) {
                sb.append(cur);
                if(i == n - 1){
                    numList.add(Integer.parseInt(sb.toString()));
                }
            }
            else if(i == n - 1 && (cur == ',' || cur == ':')){
                throw new IllegalArgumentException("마지막 입력은 구분자일 수 없습니다.");
            }
            else if (cur != ',' && cur != ':') {
                throw new IllegalArgumentException("구분자가 올바르지 않습니다.");
            }
            else if(!sb.isEmpty()){
                numList.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }
        return numList;
    }
}
