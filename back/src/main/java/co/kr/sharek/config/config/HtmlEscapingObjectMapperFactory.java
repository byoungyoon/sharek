package co.kr.sharek.config.config;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class HtmlEscapingObjectMapperFactory implements FactoryBean<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public HtmlEscapingObjectMapperFactory() {
        objectMapper = new ObjectMapper();
        objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public ObjectMapper getObject() throws Exception {
        return objectMapper;
    }

    @Override
    public Class<?> getObjectType() {
        return ObjectMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * XSS filter
     */
    public static class HTMLCharacterEscapes extends CharacterEscapes {

        private static final long serialVersionUID = 1L;
        private final int[] asciiEscapes;

        public HTMLCharacterEscapes() {
            // start with set of characters known to require escaping (double-quote, backslash etc)
            asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
            // and force escaping of a few others:
            asciiEscapes['<'] = CharacterEscapes.ESCAPE_CUSTOM;
            asciiEscapes['>'] = CharacterEscapes.ESCAPE_CUSTOM;
            asciiEscapes['&'] = CharacterEscapes.ESCAPE_CUSTOM;
            asciiEscapes['"'] = CharacterEscapes.ESCAPE_CUSTOM;
            asciiEscapes['\''] = CharacterEscapes.ESCAPE_CUSTOM;
        }

        @Override
        public int[] getEscapeCodesForAscii() {
            return asciiEscapes;
        }

        // and this for others; we don't need anything special here
        @Override
        public SerializableString getEscapeSequence(int ch) {
            char charAt = (char) ch;
            if (Character.isHighSurrogate(charAt) || Character.isLowSurrogate(charAt)) {
                StringBuilder sb = new StringBuilder();
                sb.append("\\u");
                sb.append(String.format("%04x", ch));
                return new SerializedString(sb.toString());
            } else {
                return new SerializedString(StringEscapeUtils.escapeHtml4(Character.toString(charAt)));
            }
        }
    }
}