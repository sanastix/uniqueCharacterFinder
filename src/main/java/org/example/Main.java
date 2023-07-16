package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    //- програма приймає на вхід довільний текст і знаходить в кожному слові цього
    // тексту найперший символ, який більше НЕ повторюється в аналізуємому слові;
    //- далі із отриманого набору символів програма повинна вибрати перший
    // унікальний (тобто той, який більше не зустрічається в наборі) і повернути його.

    public static String text = """
            The Tao gave birth to machine language.  Machine language gave birth
            to the assembler.
            The assembler gave birth to the compiler.  Now there are ten thousand
            languages.
            Each language has its purpose, however humble.  Each language
            expresses the Yin and Yang of software.  Each language has its place within
            the Tao.
            But do not program in COBOL if you can avoid it.
                    -- Geoffrey James, "The Tao of Programming\"""";

    public static char findUniqueCharacter(String text) {
        //1. розбити вхідний текст на окремі слова за пробілами
        String[] words = text.split("\\s+");
        //2. створити порожній словник, де ключами будуть символи, а значеннями - кількість їх зустрічей
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        //3. створити список, куди будуть додаватись унікальні символи
        StringBuilder uniqueChars = new StringBuilder();

        //4. для кожного слова в тексті ітерувати по його символам, оновлювати словник
        //та підраховувати кількість зустрічей кожного символа
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (charCount.containsKey(c)) {
                    charCount.put(c, charCount.get(c) + 1);
                } else {
                    charCount.put(c, 1);
                }
                break;
            }
        }

        //5. зібрати в новий список символи, що зустрічаються тільки один раз
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueChars.append(entry.getKey());
            }
        }
        //6. повернути перший символ, який не зустрічається повторно
        return uniqueChars.charAt(0);
    }

    public static void main(String[] args) {
        char result = findUniqueCharacter(text);
        System.out.println(result);
    }
}