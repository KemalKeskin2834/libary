package com.kemalkeskin.library.core.utility;

import java.util.Locale;

public class StringNormalizer {

    public static String normalize(String input) {
        return input == null ? null :
                input.toLowerCase(Locale.ROOT) // hepsini küçük harfe çevir || root ile de türkçe karakte rolmayan karakterleri doğru çvir
                        .trim() // baştaki ve sondaki boşlukları sil
                        .replaceAll("\\s+", " ");// birden fazla boşluğu siler
    }
}