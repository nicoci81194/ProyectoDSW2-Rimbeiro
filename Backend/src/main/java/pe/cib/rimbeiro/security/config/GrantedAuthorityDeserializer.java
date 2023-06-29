package pe.cib.rimbeiro.security.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class GrantedAuthorityDeserializer extends JsonDeserializer<Set<GrantedAuthority>> {

    @Override
    public Set<GrantedAuthority> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Set<GrantedAuthority> authorities = new HashSet<>();

        JsonNode authoritiesNode = node.get("authorities");
        if (authoritiesNode != null && authoritiesNode.isArray()) {
            for (JsonNode authorityNode : authoritiesNode) {
                if (authorityNode.isTextual()) {
                    String authority = authorityNode.asText();
                    authorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }

        return authorities;
    }
}
