package co.kr.sharek.common.util;

import co.kr.sharek.common.exception.httpexception.ParseByJsonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * json -> String
 */
@Component
@Log4j2
public class JsonUtil {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T extends Object> void writeStringAndLog(T dto){
        String result = "";
        try{
            result = objectMapper.writeValueAsString(dto);
            log.debug("request: {}", result);
        } catch (JsonProcessingException e){
            log.error("err: {}", e.getMessage());
            throw new ParseByJsonException("Json parse error", 500);
        }
    }
}
